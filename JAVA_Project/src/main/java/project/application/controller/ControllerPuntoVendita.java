package project.application.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.application.service.ServicePuntoVendita;

@RestController
@RequestMapping("/IPuntoVendita")
public class ControllerPuntoVendita {

	@Autowired
	ServicePuntoVendita servicePuntoVendita;
	
	@Autowired
	ControllerCartaFedelta controllerCartaFedelta;
	
	@PostMapping("/compilazioneModuloDiAdesione")
	public String compilazioneModuloDiAdesione(HashMap<String,String> moduloAdesione){
		int idPuntoVendita = Integer.parseInt(moduloAdesione.get("idPuntoVendita"));
		int idProgramma = Integer.parseInt(moduloAdesione.get("idProgramma"));
		String checkAdesione = servicePuntoVendita.controlloAdesioneEsistente(idPuntoVendita,idProgramma);
		return checkAdesione;
	}
	
	@PostMapping("/inserimentoInformazioniAggiuntive")
	public String inserimentoInformazioniAggiuntive(HashMap<String,String> informazioniAggiuntive){
		int idPuntoVendita = Integer.parseInt(informazioniAggiuntive.get("idPuntoVendita"));
		int idProgramma = Integer.parseInt(informazioniAggiuntive.get("idProgramma"));
		String checkAdesione = servicePuntoVendita.aggiuntaProgramma(idPuntoVendita,idProgramma);
		return checkAdesione;
	}
	
	@PostMapping("/riscattoPremi")
	public List<Integer> riscattoPremi(int idPuntoVendita){
		List<Integer> listaPremi = servicePuntoVendita.getCatalogoPremi(idPuntoVendita);
		return listaPremi;
	}

	@PostMapping("/inserimentoRecensione")
	public String inserimentoRecensione(int value,String descrizione, int idPuntoVendita) {
		return servicePuntoVendita.inserimentoRecensione(value,descrizione,idPuntoVendita);
	}
	
	@PostMapping("/updateCatalogo")
	public String updateCatalogo(int idPremio,int idPuntoVendita) {
		return servicePuntoVendita.updateCatalogo(idPremio,idPuntoVendita);
	}

	@PostMapping("/getListaPuntiVendita")
	public List<String> getListaPuntiVendita() {
		return servicePuntoVendita.getListaPuntiVendita();
	}
	
	@PostMapping("/getListaProgrammiFedeltà")
	public List<Integer> getListaProgrammiFedeltà(int idPuntoVendita) {
		return servicePuntoVendita.getListaProgrammiFedeltà(idPuntoVendita);
	}

	@PostMapping("/controllaDatiIscrizione")
	public String controllaDatiIscrizione(HashMap<String,String> datiIscrizione) {
		if(servicePuntoVendita.checkDatiIstruzione( datiIscrizione)) {
		 if(controllerCartaFedelta.creazioneCartaFedelta(
				 Integer.parseInt(datiIscrizione.get("idCliente")),
				 Integer.parseInt(datiIscrizione.get("idProgramma"))
				 ,datiIscrizione.get("descrizione")).equals("ConfermaCreazione"));
		 	return "confermaIscrizione";
		}
		return "Dati errati";
	}

	public List<Integer> getListaNomiClienti(int idPuntoVendita) {
		return servicePuntoVendita.getListaNomiClienti(idPuntoVendita);
	}

	public List<Integer> getListaNomiProgrammiFedeltà(int idPuntoVendita) {
		return servicePuntoVendita.getListaNomiProgrammiFedeltà(idPuntoVendita);
	}
}

