package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import application.service.ServiceCliente;
import application.controllerInterface.ICliente;
import application.model.CartaFedelta;

@RestController
public class ControllerCliente implements ICliente{
	
	@Autowired
	ServiceCliente serviceCliente;
	
	@Autowired
	ControllerProdotto controllerProdotto;
	
	@Autowired
	ControllerCartaFedelta controllerCartaFedelta;
	
	@Override
	public String inserimentoCredenziali(String nomeUtente,String password) {
		if(serviceCliente.getDati(nomeUtente,password)) {
			return "Autenticato";
		}
		return "Non Autenticato, controllare credenziali";
	}
	
	@Override
	public String acquistoProdotto(List<Integer> idProdotto,int idPuntoVendita,int idCliente) {
		 int punti = controllerProdotto.acquistoProdotto(idProdotto,idPuntoVendita,idCliente);
		 controllerCartaFedelta.updatePunti(idCliente,punti);
		 return "Punti Aggiornati";
	}

	@Override
	public List<CartaFedelta> visualizzaClassifica(int idProgramma) {
		return controllerCartaFedelta.getListaCartaFedelta(idProgramma);
	}

	@Override
	public int richiestaCashback(int idCliente) {
		return serviceCliente.getCashBack(idCliente);
	}

	@Override
	public String inserisceImporto(int importoCashBack,int idCliente) {
		if(serviceCliente.verificaDisponibilità(importoCashBack,idCliente)) {
			return "Avvio Pagamento";
		} else {
			return "Avviso importo non disponibile";
		}
	}

	@Override
	public String inserisceContoCorrente(int contoCorrente, int idCliente,int importoCashBack) {
		if(serviceCliente.updateCashBack(contoCorrente,idCliente,importoCashBack))
			return "notifica Pagamento";
		return "Errore";
	}

}
