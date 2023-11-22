package application.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import application.model.Coalizione;
import application.service.ServiceCoalizione;

@RestController
public class ControllerCoalizione {
	
	@Autowired
	ServiceCoalizione serviceCoalizione;
	
	public String creaCoalizione(){
		return "richiestaInformazioni";
	}
	
	public String inserimentoInformazioni(HashMap<String,String> informazioni){		
		boolean checkCoalizione = serviceCoalizione.controlloCoalizione(informazioni);
		if(checkCoalizione == true)
			return "Coalizione già esistente";
		else
			return "Coalizione creata";
	}

	public String inserimentoAdesione(String  adesione) {
		return serviceCoalizione.inserimentoAdesione(adesione);
	}
}
