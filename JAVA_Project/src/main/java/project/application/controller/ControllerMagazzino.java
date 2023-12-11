package project.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import project.application.model.Prodotto;
import project.application.service.ServiceMagazzino;

@RestController
public class ControllerMagazzino {

	@Autowired
	ServiceMagazzino serviceMagazzino;
	
	@PostMapping("/getListaProdotti")
	public List<Integer> getListaProdotti(int idPuntoVendita) {	
		return serviceMagazzino.getListaProdotti(idPuntoVendita);
	}
	
	@PostMapping("/addProdotto")
	public String addProdotto(int quantita, int idProdotto, int idPuntoVendita) {
		return serviceMagazzino.addProdotto(quantita,idProdotto,idPuntoVendita);
	}
	
	@PostMapping("/removeProdotto")
	public String removeProdotto(int quantita, int idProdotto, int idPuntoVendita) {
		return serviceMagazzino.removeProdotto(quantita,idProdotto,idPuntoVendita);
	}
	
}
