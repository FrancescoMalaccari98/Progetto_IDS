package application.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import application.controllerInterface.IAdmin;

@RestController
public class ControllerAdmin implements IAdmin{
	
	@Autowired
	ControllerProgrammaFedelta controllerProgrammaFedelta;

	@Override
	public HashMap<String,String> creazioneProgrammaFedelta(String nomeUtente, String Password) {
		return controllerProgrammaFedelta.creazioneProgrammaFedelta();
	}

	@Override
	public HashMap<String,String> inserimentoInformazioniBase(HashMap<String,String>  moduloInformazioniBase) {
		return controllerProgrammaFedelta.inserimentoInformazioniBase(moduloInformazioniBase);
	}

	@Override
	public String inserimentoInformazioniDettagliate(HashMap<String, String> moduloInfomrmazioniDettagliate) {
		return controllerProgrammaFedelta.inserimentoInformazioniDetagliate(moduloInfomrmazioniDettagliate);

	}
	
	

}
