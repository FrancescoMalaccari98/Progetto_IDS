package project.application.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
		return controllerProgrammaFedelta.getListaProgrammiFedelta();
	}

	@PostMapping("/selezioneProgramma")
	public HashMap<String,String>  selezioneProgramma(int idProgrammaScelto) {
		return controllerProgrammaFedelta.selezioneProgramma(idProgrammaScelto);
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
		return controllerPuntoVendita.inserimentoInformazioniAggiuntive(informazioniAggiuntive);
	}

	
	@PostMapping("/inserimentoInfoCoalizione")
	public String inserimentoInfoCoalizione(HashMap<String, String> informazioni) {
		return controllerCoalizione.inserimentoInformazioni(informazioni);
	}
	
	
	@PostMapping("/accessoPannelloDiControllo")
	public String accessoPannelloDiControllo(String nomeUtente,String password) {
		String cliente =controllerCliente.inserimentoCredenziali(nomeUtente,password);
		if(cliente != null && cliente.equals("Autenticato"))
			return "accessoConsentito";
		return "accessoNegato";
	}
	
	@GetMapping("/richiestaListaDipendeti")
	public List<Operatore> richiestaListaDipendeti(int idPuntoVendita){
		return controllerOperatore.richiestaListaDipendenti(idPuntoVendita);
	}
	
	@PostMapping("/selezionaCandidatoAdmin")
	public String selezionaCandidatoAdmin(int idOperatore){
		return controllerOperatore.setAdmin(idOperatore); 
	}
	
	@GetMapping("/richiestaPuntiVenditaDisponibili")
	public List<String> richiestaPuntiVenditaDisponibili(){
		return controllerPuntoVendita.getListaPuntiVendita(); 
	}

	@PostMapping("/inoltroRichiestaAdesioneCoalizione")
	public String inoltroRichiestaAdesioneCoalizione(List<Integer> listaIdPuntiVendita,int idCoalizione){
		return controllerCoalizione.inoltroRichiestaAdesioneCoalizione(listaIdPuntiVendita,idCoalizione); 
	}
}
