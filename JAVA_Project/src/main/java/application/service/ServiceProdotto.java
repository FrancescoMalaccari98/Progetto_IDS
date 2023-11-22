package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.CartaFedelta;
import application.model.Cliente;
import application.model.Prodotto;
import application.repository.RepositoryProdotto;

@Service
public class ServiceProdotto {
	
	@Autowired
	RepositoryProdotto repositoryProdotto;
	
	@Autowired
	ServiceCartaFedelta serviceCartaFedelta;
	
	@Autowired
	ServiceCliente serviceCliente;
	
	public int updateProdotto(List<Integer> idProdotti,int idPuntoVendita,int idCliente) {
		int prodottiAcquistati = 0;
        for (Integer idProdotto : idProdotti) {
		Prodotto product = repositoryProdotto.findProdottoById(idProdotto);
		if (product!=null && product.getIdPuntoVendita() == idPuntoVendita) {
			product.setIdPuntoVendita(0);
			repositoryProdotto.save(product);
			prodottiAcquistati++;
			}
        }
		return prodottiAcquistati;
	}

}
