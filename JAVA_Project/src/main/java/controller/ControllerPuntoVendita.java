package controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import service.ServiceProgrammaFedelta;
import service.ServicePuntoVendita;

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
		Long idPuntoVendita = Long.parseLong(informazioniAggiuntive.get("idPuntoVendita"));
		Long idProgramma = Long.parseLong(informazioniAggiuntive.get("idProgramma"));
		String checkAdesione = servicePuntoVendita.aggiuntaProgramma(idPuntoVendita,idProgramma);
		return checkAdesione;
	}
}
