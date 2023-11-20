package controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import controllerInterface.IProprietarioAzienda;

public class ControllerProprietarioAzienda implements IProprietarioAzienda {
	
	@Autowired
	ControllerProgrammaFedelta controllerProgrammaFedelta;
	
	@Autowired
	ControllerPuntoVendita controllerPuntoVendita;
	
	@Override
	public List<String> adesioneProgrammaFedelta() {
		List<String> listaProgrammi = controllerProgrammaFedelta.adesioneProgrammaFedelta();
		return listaProgrammi;
	}

	@Override
	public HashMap<String,String>  selezioneProgramma(String programmiScelti) {
		HashMap<String,String> modulo = controllerProgrammaFedelta.selezioneProgramma(programmiScelti);
		return modulo;
	}

	@Override
	public String compilazioneModuloDiAdesione(HashMap<String, String> moduloAdesione) {
		String response = controllerPuntoVendita.compilazioneModuloDiAdesione(moduloAdesione);
		if(response.equals("RichiestaInformazioniAggiuntive"))
			//inserire informazioni
			return "";
		return response;
	}
	
	@Override
	public String inserimentoInformazioniAggiuntive(HashMap<String, String> informazioniAggiuntive) {
		String response = controllerPuntoVendita.inserimentoInformazioniAggiuntive(informazioniAggiuntive);
		return response;
	}
}
