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
	
	@PostMapping("/getDipendenteByPuntoVendita")
	public List<Operatore> getDipendenteByPuntoVendita(int idPuntoVendita) {
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
}
