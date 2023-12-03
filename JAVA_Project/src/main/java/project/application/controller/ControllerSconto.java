package project.application.controller;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.application.model.Sconto;
import project.application.service.ServiceSconto;

@RestController
@RequestMapping("/ISconto")
public class ControllerSconto {
	
	@Autowired
	ServiceSconto serviceSconto;
	
	@PostMapping("/creaCodiceSconto")
	public String creaCodiceSconto() {
		return "RichiestaInfo";
	}
	
	@PostMapping("/inserimentoSconto")
	public String inserimentoSconto(HashMap<String,String>  infoSconto,int idPuntoVendita){
		serviceSconto.inserimentoSconto(infoSconto,idPuntoVendita);
		return "ConfermaCreazione";
	}

	@PostMapping("/controlloSconto")
	public boolean controlloSconto(Sconto sconto) {
		return serviceSconto.controllaSconto(sconto);
	}

	@PostMapping("/applicaSconto")
	public float applicaSconto(Sconto sconto, int prezzoTotale) {
		return serviceSconto.applicaSconto(sconto,prezzoTotale);
	}

}
