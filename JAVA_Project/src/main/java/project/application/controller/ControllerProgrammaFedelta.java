package project.application.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.application.model.CartaFedelta;
import project.application.model.ProgrammaFedelta;
import project.application.service.ServiceProgrammaFedelta;

@RestController
@RequestMapping("/IProgrammaFedelta")
public class ControllerProgrammaFedelta {

	@Autowired
	ServiceProgrammaFedelta serviceProgrammaFedelta;
	
	@Autowired
	ControllerCartaFedelta controllerCartaFedelta;
	
	@PostMapping("/adesioneProgrammaFedelta")
	public List<ProgrammaFedelta> adesioneProgrammaFedelta() {
		List<ProgrammaFedelta> listaProgrammi = serviceProgrammaFedelta.getListaProgrammiFedelta();
		return listaProgrammi;
	}

	@PostMapping("/selezioneProgramma")
	public HashMap<String,String> selezioneProgramma(int idProgrammaScelto) {
		HashMap<String,String> modulo = serviceProgrammaFedelta.getModuloAdesione(idProgrammaScelto);
		return modulo;
	}

	@PostMapping("/creazioneProgrammaFedelta")
	public HashMap<String,String> creazioneProgrammaFedelta(){
		return serviceProgrammaFedelta.creazioneProgrammaFedelta();
	}
	
	@PostMapping("/inserimentoInformazioniBase")
	public HashMap<String,String>  inserimentoInformazioniBase(HashMap<String,String>  moduloInformazioniBase){
		return serviceProgrammaFedelta.inserimentoInformazioniBase(moduloInformazioniBase);
	}

	@PostMapping("/inserimentoInformazioniDetagliate")
	public String inserimentoInformazioniDetagliate(HashMap<String,String>  moduloInformazioniDettagliate){
		return serviceProgrammaFedelta.inserimentoInformazioniDetagliate(moduloInformazioniDettagliate);
	}

	public List<String> getListaServiziEsclusivi(int idProgrammaFedelta) {
		return serviceProgrammaFedelta.getListaServiziEsclusivi(idProgrammaFedelta);
	}

	public String acquistoCartaVIP(int idCliente) {
		boolean controlloPagamento = true;
		if(controlloPagamento) {
			CartaFedelta cartaFedelta = controllerCartaFedelta.creazioneCartaFedeltaVIP(idCliente,"VIP");
			return "idCliente" + cartaFedelta.getIdCliente() + "Descrizione: " + cartaFedelta.getDescrizione();
		}
		return "Pagamento Rifiutato";
	}
	
}
