package project.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.application.model.Recensione;
import project.application.repository.RepositoryRecensione;

@Service
public class ServiceRecensione {
	
	@Autowired 
	RepositoryRecensione repositoryRecensione;
	
	public void insertRecensione(String descrizione, int idPuntoVendita, int value) {
		Recensione recensione = new Recensione();
		recensione.setDescrizione(descrizione);
		recensione.setIdPuntoVendita(idPuntoVendita);
		recensione.setValore(value);
		repositoryRecensione.save(recensione);
	}

}
