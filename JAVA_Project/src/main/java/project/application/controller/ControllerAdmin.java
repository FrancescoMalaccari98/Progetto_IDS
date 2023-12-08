package project.application.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/IAdmin")
public class ControllerAdmin {
	
	@Autowired
	ControllerProgrammaFedelta controllerProgrammaFedelta;
	
	@Autowired
	ControllerSconto controllerSconto;

	@PostMapping("/creazioneProgrammaFedelta")
	public HashMap<String,String> creazioneProgrammaFedelta(String nomeUtente, String Password) {
		return controllerProgrammaFedelta.creazioneProgrammaFedelta();
	}

	@PostMapping("/inserimentoInformazioniBase")
	public HashMap<String,String> inserimentoInformazioniBase(HashMap<String,String>  moduloInformazioniBase) {
		return controllerProgrammaFedelta.inserimentoInformazioniBase(moduloInformazioniBase);
	}

	@PostMapping("/inserimentoInformazioniDettagliate")
	public String inserimentoInformazioniDettagliate(HashMap<String, String> moduloInfomrmazioniDettagliate) {
		return controllerProgrammaFedelta.inserimentoInformazioniDetagliate(moduloInfomrmazioniDettagliate);

	}

	@PostMapping("/creaCodiceSconto")
	public String creaCodiceSconto() {
		return controllerSconto.creaCodiceSconto();
	}

	@PostMapping("/inserimentoInfoSconto")
	public String inserimentoInfoSconto(HashMap<String,String>  infoSconto, int idPuntoVendita) {
		return controllerSconto.inserimentoSconto(infoSconto,idPuntoVendita);
	}

	@PostMapping("/selezionaTipo")
	public List<Integer> selezionaTipo(String tipo,int idPuntoVendita) {
		return controllerSconto.selezionaTipo(tipo,idPuntoVendita);
	}
	
	@PostMapping("/selezioneProgramma")
	public String selezioneProgramma(int idProgramma) {
		return controllerSconto.selezioneProgramma(idProgramma);
	}
	
	@PostMapping("/selezioneCliente")
	public String selezioneCliente(int idCliente) {
		return controllerSconto.selezioneCliente(idCliente);
	}
	
}
