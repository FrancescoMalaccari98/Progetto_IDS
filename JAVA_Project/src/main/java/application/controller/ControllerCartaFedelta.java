package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import application.model.CartaFedelta;
import application.service.ServiceCartaFedelta;

@RestController
public class ControllerCartaFedelta {
	
	@Autowired
	ServiceCartaFedelta serviceCartaFedelta;
	
	public String updatePunti(int idCliente,int informazioniProdotto) {
		serviceCartaFedelta.updatePunti(idCliente,informazioniProdotto);
		return "Punti aggiornati";
	}
	
	public List<CartaFedelta> getListaCartaFedelta(int idProgramma){
		return serviceCartaFedelta.getListaCartaFedelta(idProgramma);
	}

	public boolean verificaDisponibilità(int importoCashBack, int idCliente) {
		return serviceCartaFedelta.verificaCashBack(importoCashBack, idCliente);
	}

	public boolean inserisceContoCorrente(int contoCorrente, int idCliente, int importoCashBack) {
		return serviceCartaFedelta.updateCashBack(contoCorrente, idCliente, importoCashBack);
	}

	public int recuperaSaldoCashbackDisponibile(int idCliente) {
		return serviceCartaFedelta.getCashBack(idCliente);
	}
}
