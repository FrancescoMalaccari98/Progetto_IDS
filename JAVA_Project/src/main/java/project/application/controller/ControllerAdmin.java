package project.application.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAdmin {
	
	@Autowired
	ControllerProgrammaFedelta controllerProgrammaFedelta;
	
	@Autowired
	ControllerSconto controllerSconto;

	
	public HashMap<String,String> creazioneProgrammaFedelta(String nomeUtente, String Password) {
		return controllerProgrammaFedelta.creazioneProgrammaFedelta();
	}

	
	public HashMap<String,String> inserimentoInformazioniBase(HashMap<String,String>  moduloInformazioniBase) {
		return controllerProgrammaFedelta.inserimentoInformazioniBase(moduloInformazioniBase);
	}

	
	public String inserimentoInformazioniDettagliate(HashMap<String, String> moduloInfomrmazioniDettagliate) {
		return controllerProgrammaFedelta.inserimentoInformazioniDetagliate(moduloInfomrmazioniDettagliate);

	}

	
	public String creaCodiceSconto() {
		return controllerSconto.creaCodiceSconto();
	}

	
	public String inserimentoInfoSconto(HashMap<String,String>  infoSconto, int idPuntoVendita) {
		return controllerSconto.inserimentoSconto(infoSconto,idPuntoVendita);
	}
	
	

}
