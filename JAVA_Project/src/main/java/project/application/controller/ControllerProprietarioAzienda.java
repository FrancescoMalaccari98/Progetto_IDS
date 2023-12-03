package project.application.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.application.model.Operatore;
import project.application.model.ProgrammaFedelta;

@RestController
@RequestMapping("/IProprietarioAzienda")
public class ControllerProprietarioAzienda {
	
	@Autowired
	ControllerProgrammaFedelta controllerProgrammaFedelta;
	
	@Autowired
	ControllerPuntoVendita controllerPuntoVendita;
	
	@Autowired
	ControllerCoalizione controllerCoalizione;
	
	@Autowired	
	ControllerCliente controllerCliente;
	
	@Autowired
	ControllerOperatore controllerOperatore;
	
	@PostMapping("/adesioneProgrammaFedelta")
	public List<ProgrammaFedelta> adesioneProgrammaFedelta() {
		List<ProgrammaFedelta> listaProgrammi = controllerProgrammaFedelta.adesioneProgrammaFedelta();
		return listaProgrammi;
	}

	@PostMapping("/selezioneProgramma")
	public HashMap<String,String>  selezioneProgramma(int idProgrammaScelto) {
		HashMap<String,String> modulo = controllerProgrammaFedelta.selezioneProgramma(idProgrammaScelto);
		return modulo;
	}

	@PostMapping("/compilazioneModuloDiAdesione")
	public String compilazioneModuloDiAdesione(HashMap<String, String> moduloAdesione) {
		String response = controllerPuntoVendita.compilazioneModuloDiAdesione(moduloAdesione);
		if(response.equals("RichiestaInformazioniAggiuntive"))
			//inserire informazioni
			return "";
		return response;
	}
	
	@PostMapping("/inserimentoInformazioniAggiuntive")
	public String inserimentoInformazioniAggiuntive(HashMap<String, String> informazioniAggiuntive) {
		String response = controllerPuntoVendita.inserimentoInformazioniAggiuntive(informazioniAggiuntive);
		return response;
	}

	@PostMapping("/creaCoalizione")
	public String creaCoalizione() {
		String response = controllerCoalizione.creaCoalizione();
		return response;
	}

	@PostMapping("/inserimentoInformazioni")
	public String inserimentoInformazioni(HashMap<String, String> informazioni) {
		String response = controllerCoalizione.inserimentoInformazioni(informazioni);
		return response;
	}
	
	@PostMapping("/inoltroRichiestaAdesione")
	public String inoltroRichiestaAdesione(String adesione) {
		String response = controllerCoalizione.inserimentoAdesione(adesione);
		return response;
	}
	
	@PostMapping("/accessoPannelloDiControllo")
	public String accessoPannelloDiControllo(String nomeUtente,String password) {
		String cliente =controllerCliente.inserimentoCredenziali(nomeUtente,password);
		if(cliente != null && cliente.equals("Autenticato"))
			return "accessoConsentito";
		return "accessoNegato";
	}
	
	@PostMapping("/richiestaListaDipendeti")
	public List<Operatore> richiestaListaDipendeti(int idPuntoVendita){
		List<Operatore> response = controllerOperatore.getDipendenteByPuntoVendita(idPuntoVendita);
		return response;
	}
	
	@PostMapping("/selezionaCandidatoAdmin")
	public String selezionaCandidatoAdmin(int idOperatore){
		String response = controllerOperatore.setAdmin(idOperatore); 
		return response;
	}
	
}
