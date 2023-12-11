package project.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.application.model.Prodotto;
import project.application.service.ServiceProdotto;

@RestController
@RequestMapping("/IProdotto")
public class ControllerProdotto {
	
	@Autowired
	ServiceProdotto serviceProdotto;
	
	@Autowired
	ControllerMagazzino controllerMagazzino;
	
	@PostMapping("/updateProdotto")
	public String updateProdotto(List<Prodotto> prodotti,int idPuntoVendita,int quantita) {
		  for (Prodotto prodotto : prodotti) {
			  controllerMagazzino.removeProdotto(prodotto.getId(),idPuntoVendita,quantita);
		}
		  return "confermaUpdateMagazzino";
	}

	@PostMapping("/getPrezzoTotale")
	public float getPrezzoTotale(List<Prodotto> prodotti) {
		return serviceProdotto.getPrezzoTotale(prodotti);
	}

}
