package controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import service.ServiceProgrammaFedelta;

public class ControllerProgrammaFedelta {

	@Autowired
	ServiceProgrammaFedelta serviceProgrammaFedelta;
	
	
	public List<String> adesioneProgrammaFedelta() {
		List<String> listaProgrammi = serviceProgrammaFedelta.getListaProgrammiFedelta();
		return listaProgrammi;
	}

	public HashMap<String,String>  selezioneProgramma(String programmaScelto) {
		HashMap<String,String> modulo = serviceProgrammaFedelta.getModuloAdesione(programmaScelto);
		return modulo;
	}
}
