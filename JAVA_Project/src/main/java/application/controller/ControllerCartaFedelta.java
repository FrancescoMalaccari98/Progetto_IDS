package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import application.service.ServiceCartaFedelta;

@RestController
public class ControllerCartaFedelta {
	
	@Autowired
	ServiceCartaFedelta serviceCartaFedelta;
	
	String updatePunti(int idCliente,int informazioniProdotto) {
		serviceCartaFedelta.updatePunti(idCliente,informazioniProdotto);
		return "Punti aggiornati";
	}
}
