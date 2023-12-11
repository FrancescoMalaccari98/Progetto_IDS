package project.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.application.model.Cliente;
import project.application.model.ComunicazionePromozionale;
import project.application.model.Operatore;
import project.application.service.ServiceOperatore;

@RestController
@RequestMapping("/IOperatore")
public class ControllerOperatore {
	
	@Autowired
	ServiceOperatore serviceOperatore;
	
	@Autowired
	ControllerComunicazionePromozionale controllerComunicazionePromozionale;
	
	@Autowired
	ControllerCartaFedelta controllerCartaFedelta;
	
	@Autowired
	ControllerPuntoVendita controllerPuntovendita;
	
	@PostMapping("/richiestaListaDipendenti")
	public List<Operatore> richiestaListaDipendenti(int idPuntoVendita) {
		return serviceOperatore.getDipendenteByPuntoVendita(idPuntoVendita);
	}
	
	@PostMapping("/setAdmin")
	public String setAdmin(int idOperatore) {
		return serviceOperatore.modifyRuolo(idOperatore);
	}
	
	@PostMapping("/inviaCPromozionale")
	public List<ComunicazionePromozionale> inviaCPromozionale(int idPuntoVendtia) {
		return controllerComunicazionePromozionale.getListaCPromozionale(idPuntoVendtia);
	}
	
	@PostMapping("/inseriementoCPromozionale")
	public List<Integer> inseriementoCPromozionale(int idCPromozionale,int idProgramma){
		return controllerCartaFedelta.getListaClienti(idProgramma);
	}
	
	@PostMapping("/richiestaCreazioneCarta")
	public List<Integer> richiestaCreazioneCarta(int idPuntoVendita){
		return controllerPuntovendita.getListaProgrammiFedelta(idPuntoVendita);
	}
	
	@PostMapping("/creaCarta")
	public String creaCarta(int idCliente,int idProgramma,String info){
		return controllerCartaFedelta.creazioneCartaFedelta(idCliente,idProgramma,info);
	}
}
