package project.application.controller;


import java.util.HashMap;
import java.util.List;

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
	
	@Autowired
	ControllerPuntoVendita controllerPuntoVendita;
	
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

	@PostMapping("/selezionaTipo")
	public List<Integer> selezionaTipo(String tipo,int idPuntoVendita) {
		if(tipo.equals("Cliente"))
		return controllerPuntoVendita.getListaNomiClienti(idPuntoVendita);
		else 
			return controllerPuntoVendita.getListaNomiProgrammiFedelta(idPuntoVendita);
	}

	@PostMapping("/selezioneProgramma")
	public String selezioneProgramma(int idProgramma) {
		return serviceSconto.inserimentoScontoProgramma(idProgramma);
	}

	@PostMapping("/selezioneCliente")
	public String selezioneCliente(int idCliente) {
		return serviceSconto.inserimentoScontoCliente(idCliente);
	}

}
