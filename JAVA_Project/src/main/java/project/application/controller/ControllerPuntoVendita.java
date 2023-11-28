package project.application.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import project.application.service.ServicePuntoVendita;

@RestController
public class ControllerPuntoVendita {

	@Autowired
	ServicePuntoVendita servicePuntoVendita;
	
	public String compilazioneModuloDiAdesione(HashMap<String,String> moduloAdesione){
		int idPuntoVendita = Integer.parseInt(moduloAdesione.get("idPuntoVendita"));
		int idProgramma = Integer.parseInt(moduloAdesione.get("idProgramma"));
		String checkAdesione = servicePuntoVendita.controlloAdesioneEsistente(idPuntoVendita,idProgramma);
		return checkAdesione;
	}
	
	public String inserimentoInformazioniAggiuntive(HashMap<String,String> informazioniAggiuntive){
		int idPuntoVendita = Integer.parseInt(informazioniAggiuntive.get("idPuntoVendita"));
		int idProgramma = Integer.parseInt(informazioniAggiuntive.get("idProgramma"));
		String checkAdesione = servicePuntoVendita.aggiuntaProgramma(idPuntoVendita,idProgramma);
		return checkAdesione;
	}
}
