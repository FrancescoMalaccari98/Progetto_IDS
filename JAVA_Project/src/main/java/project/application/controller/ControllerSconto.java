package project.application.controller;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import project.application.model.Sconto;
import project.application.service.ServiceSconto;

@RestController
public class ControllerSconto {
	
	@Autowired
	ServiceSconto serviceSconto;
	
	public String creaCodiceSconto() {
		return "RichiestaInfo";
	}
	
	public String inserimentoSconto(HashMap<String,String>  infoSconto,int idPuntoVendita){
		serviceSconto.inserimentoSconto(infoSconto,idPuntoVendita);
		return "ConfermaCreazione";
	}

	public boolean controlloSconto(Sconto sconto) {
		return serviceSconto.controllaSconto(sconto);
	}

	public float applicaSconto(Sconto sconto, int prezzoTotale) {
		return serviceSconto.applicaSconto(sconto,prezzoTotale);
	}

}
