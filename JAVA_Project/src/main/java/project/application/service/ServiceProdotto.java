package project.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.application.model.CartaFedelta;
import project.application.model.Cliente;
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
	
	public int updateProdotto(List<Integer> idProdotti,int idPuntoVendita,int idCliente) {
		int punti = 0;
        for (Integer idProdotto : idProdotti) {
		Prodotto product = repositoryProdotto.findProdottoById(idProdotto);
		if (product!=null && product.getIdPuntoVendita() == idPuntoVendita) {
			product.setIdPuntoVendita(0);
			repositoryProdotto.save(product);
			punti++;
			}
        }
        punti=punti*10;
		return punti;
	}

}
