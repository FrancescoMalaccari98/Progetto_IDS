package project.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.application.model.Magazzino;
import project.application.repository.RepositoryMagazzino;

@Service
public class ServiceMagazzino {

	@Autowired
	RepositoryMagazzino repositoryMagazzino;
	
	public List<Integer> getListaProdotti(int idPuntoVendita) {
		 List<Magazzino> listaMagazzino = repositoryMagazzino.findAllByIdPuntoVendita(idPuntoVendita);
		 List<Integer> listaIdProdotti = new ArrayList<Integer>();
		 for (Magazzino magazzino : listaMagazzino) {
			 listaIdProdotti.add(magazzino.getIdProdotto());
		}
		 return listaIdProdotti;
	}

}
