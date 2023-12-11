package project.application.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.application.service.ServiceCoalizione;

@RestController
@RequestMapping("/ICoalizione")
public class ControllerCoalizione {
	
	@Autowired
	ServiceCoalizione serviceCoalizione;
	
	
	@PostMapping("/inserimentoInformazioni")
	public String inserimentoInformazioni(HashMap<String,String> informazioni){		
		boolean checkCoalizione = serviceCoalizione.controlloCoalizione(informazioni);
		if(checkCoalizione == true)
			return "Coalizione già esistente";
		else
			return "Coalizione creata";
	}

	@PostMapping("/inoltroRichiestaAdesioneCoalizione")
	public String inoltroRichiestaAdesioneCoalizione(List<Integer> listaIdPuntiVendita, int idCoalizione) {
		return serviceCoalizione.creaCoalizione(listaIdPuntiVendita,idCoalizione);
	}
}
