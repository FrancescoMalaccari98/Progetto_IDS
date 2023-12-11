package project.application.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.application.model.ComunicazionePromozionale;
import project.application.service.ServicePuntoVendita;

@RestController
@RequestMapping("/IPuntoVendita")
public class ControllerPuntoVendita {

	@Autowired
	ServicePuntoVendita servicePuntoVendita;
	
	@Autowired
	ControllerCartaFedelta controllerCartaFedelta;
	
	@Autowired
	ControllerMagazzino controllerMagazzino;
	
	@Autowired
	ControllerProdotto controllerProdotto;
	
	@Autowired
	ControllerComunicazionePromozionale controllerComunicazionePromozionale;
	
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
	
	@PostMapping("/getListaProgrammiFedelta")
	public List<Integer> getListaProgrammiFedelta(int idPuntoVendita) {
		return servicePuntoVendita.getListaProgrammiFedelta(idPuntoVendita);
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
	
	@PostMapping("/getListaNomiClienti")
	public List<Integer> getListaNomiClienti(int idPuntoVendita) {
		return servicePuntoVendita.getListaNomiClienti(idPuntoVendita);
	}

	@PostMapping("/getListaNomiProgrammiFedelta")
	public List<Integer> getListaNomiProgrammiFedelta(int idPuntoVendita) {
		return servicePuntoVendita.getListaNomiProgrammiFedelta(idPuntoVendita);
	}
	
	@PostMapping("/updateMagazzino")
	public List<Integer> updateMagazzino(int idPuntoVendita) {
		return controllerMagazzino.getListaProdotti(idPuntoVendita);
	}
	
	@PostMapping("/creaCPromozionale")
	public List<Integer> creaCPromozionale(int idPuntoVendita) {
		return servicePuntoVendita.getListaNomiProgrammiFedelta(idPuntoVendita);
	}
	
	@PostMapping("/inserimentoCPPromozionale")
	public String inserimentoCPPromozionale(int idPuntoVendita, int idProgramma,String info) {
		return controllerComunicazionePromozionale.creaComunicazionePromozionale(idPuntoVendita,info,idProgramma);
	}
	
	@PostMapping("/inserimentoQuantita")
	public String inserimentoQuantita(int quantita, int idProdotto,String tipoOperazione,int idPuntovendita) {
		if(tipoOperazione.equals("Inserimento")){
			return controllerMagazzino.addProdotto(quantita,idProdotto,idPuntovendita);
		} else {
			return controllerMagazzino.removeProdotto(quantita,idProdotto, idPuntovendita);

		}
	}
}

