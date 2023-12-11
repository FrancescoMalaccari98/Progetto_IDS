package project.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import project.application.model.ComunicazionePromozionale;
import project.application.service.ServiceComunicazionePromozionale;

@RestController
public class ControllerComunicazionePromozionale {
	
	@Autowired
	ServiceComunicazionePromozionale serviceComunicazonePromozionale;
	
	@PostMapping("/getListaCPromozionale")
	public List<ComunicazionePromozionale> getListaCPromozionale(int idPuntoVendtia) {
		return serviceComunicazonePromozionale.getListaCPromozionale(idPuntoVendtia);
	}
	
	@PostMapping("/creaComunicazionePromozionale")
	public String creaComunicazionePromozionale(int idProgrammaFedelta,String info,int idPuntoVendita){
		return serviceComunicazonePromozionale.inserimentoCPromozionale(idProgrammaFedelta,info,idPuntoVendita);
	}

}
