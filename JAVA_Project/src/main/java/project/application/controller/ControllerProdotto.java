package project.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import project.application.model.Prodotto;
import project.application.service.ServiceProdotto;

@RestController
public class ControllerProdotto {
	
	@Autowired
	ServiceProdotto serviceProdotto;
	
	public int registraAcquistoProdotto(List<Prodotto> prodotti,int idPuntoVendita) {
		 return serviceProdotto.updateProdotto(prodotti,idPuntoVendita);
	}

	public float getPrezzoTotale(List<Prodotto> prodotti) {
		return serviceProdotto.getPrezzoTotale(prodotti);
	}

}
