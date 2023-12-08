package project.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import project.application.service.ServiceMagazzino;

@RestController
public class ControllerMagazzino {

	@Autowired
	ServiceMagazzino serviceMagazzino;
	
	public List<Integer> getListaProdotti(int idPuntoVendita) {	
		return serviceMagazzino.getListaProdotti(idPuntoVendita);
	}
	
}
