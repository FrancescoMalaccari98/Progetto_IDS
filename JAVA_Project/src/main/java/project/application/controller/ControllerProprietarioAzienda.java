package project.application.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import project.application.controllerInterface.IProprietarioAzienda;
import project.application.model.ProgrammaFedelta;
import project.application.model.PuntoVendita;

@RestController
public class ControllerProprietarioAzienda implements IProprietarioAzienda {
	
	@Autowired
	ControllerProgrammaFedelta controllerProgrammaFedelta;
	
	@Autowired
	ControllerPuntoVendita controllerPuntoVendita;
	
	@Autowired
	ControllerCoalizione controllerCoalizione;
	
	@Override
	public List<ProgrammaFedelta> adesioneProgrammaFedelta() {
		List<ProgrammaFedelta> listaProgrammi = controllerProgrammaFedelta.adesioneProgrammaFedelta();
		return listaProgrammi;
	}

	@Override
	public HashMap<String,String>  selezioneProgramma(int idProgrammaScelto) {
		HashMap<String,String> modulo = controllerProgrammaFedelta.selezioneProgramma(idProgrammaScelto);
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

	@Override
	public String creaCoalizione() {
		String response = controllerCoalizione.creaCoalizione();
		return response;
	}

	@Override
	public String inserimentoInformazioni(HashMap<String, String> informazioni) {
		String response = controllerCoalizione.inserimentoInformazioni(informazioni);
		return response;
	}

	@Override
	public List<PuntoVendita> richiestaPuntiVenditaDisponibili() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inoltroRichiestaAdesione(String adesione) {
		String response = controllerCoalizione.inserimentoAdesione(adesione);
		return response;
	}
}
