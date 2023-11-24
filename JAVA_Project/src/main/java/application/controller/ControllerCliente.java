package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import application.service.ServiceCliente;
import application.controllerInterface.ICliente;
import application.model.CartaFedelta;
import application.model.Cliente;

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
		 Cliente cliente = serviceCliente.getClienteById(idCliente);
		 int punti = controllerProdotto.acquistoProdotto(idProdotto,idPuntoVendita,idCliente);
		 if(cliente.getProgrammaFedeltaType().equals("Cliente CashBack"))
			 //aggiungo 10 punti perchè cliente CashBack
			 controllerCartaFedelta.updatePunti(idCliente,punti+10);
		 if(cliente.getProgrammaFedeltaType().equals("Cliente Punti"))
			 //aggiungo 20 punti perchè cliente Punti
			 controllerCartaFedelta.updatePunti(idCliente,punti+20);
		 return "Punti Aggiornati";
	}

	@Override
	public List<CartaFedelta> visualizzaClassifica(int idProgramma) {
		return controllerCartaFedelta.getListaCartaFedelta(idProgramma);
	}

	@Override
	public int richiestaCashback(int idCliente) {
		return controllerCartaFedelta.recuperaSaldoCashbackDisponibile(idCliente);
	}

	@Override
	public String inserisceImporto(int importoCashBack,int idCliente) {
		if(controllerCartaFedelta.verificaDisponibilità(importoCashBack,idCliente)) {
			return "avvioPagamento";
		} else {
			return "Avviso importo non disponibile";
		}
	}

	@Override
	public String inserisceContoCorrente(int contoCorrente, int idCliente,int importoCashBack) {
		if(controllerCartaFedelta.inserisceContoCorrente(contoCorrente,idCliente,importoCashBack))
			return "notificaPagamento";
		return "ErrorePagamento";
	}

}
