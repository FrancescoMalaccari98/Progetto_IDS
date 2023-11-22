package application.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import application.model.ProgrammaFedelta;
import application.service.ServiceProgrammaFedelta;

@RestController
public class ControllerProgrammaFedelta {

	@Autowired
	ServiceProgrammaFedelta serviceProgrammaFedelta;
	
	
	public List<ProgrammaFedelta> adesioneProgrammaFedelta() {
		List<ProgrammaFedelta> listaProgrammi = serviceProgrammaFedelta.getListaProgrammiFedelta();
		return listaProgrammi;
	}

	public HashMap<String,String> selezioneProgramma(int idProgrammaScelto) {
		HashMap<String,String> modulo = serviceProgrammaFedelta.getModuloAdesione(idProgrammaScelto);
		return modulo;
	}

	public HashMap<String,String> creazioneProgrammaFedelta(){
		return serviceProgrammaFedelta.creazioneProgrammaFedelta();
	}
	
	public HashMap<String,String>  inserimentoInformazioniBase(HashMap<String,String>  moduloInformazioniBase){
		return serviceProgrammaFedelta.inserimentoInformazioniBase(moduloInformazioniBase);
	}
	
	public String inserimentoInformazioniDetagliate(HashMap<String,String>  moduloInformazioniDettagliate){
		return serviceProgrammaFedelta.inserimentoInformazioniDetagliate(moduloInformazioniDettagliate);
	}
	
}
