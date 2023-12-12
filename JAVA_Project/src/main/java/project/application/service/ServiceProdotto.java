package project.application.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.application.model.Prodotto;
import project.application.repository.RepositoryProdotto;

@Service
public class ServiceProdotto {
	
	@Autowired
	RepositoryProdotto repositoryProdotto;
	
	@Autowired
	ServiceCartaFedelta serviceCartaFedelta;
	
	@Autowired
	ServiceCliente serviceCliente;
	

	public float getPrezzoTotale(List<Prodotto> prodotti) {
		float prezzoTotale = 0;
		for(Prodotto prodotto: prodotti) {
			prezzoTotale = prezzoTotale + prodotto.getPrezzo();
		}
		
		return prezzoTotale;
	}


}
