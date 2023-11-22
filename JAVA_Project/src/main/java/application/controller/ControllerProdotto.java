package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import application.service.ServiceProdotto;

@RestController
public class ControllerProdotto {
	
	@Autowired
	ServiceProdotto serviceProdotto;
	
	public int acquistoProdotto(List<Integer> idProdotto,int idPuntoVendita,int idCliente) {
		 return serviceProdotto.updateProdotto(idProdotto,idPuntoVendita,idCliente);
	}

}
