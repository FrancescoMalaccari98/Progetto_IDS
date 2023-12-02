package project.application.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.application.model.Sconto;
import project.application.repository.RepositorySconto;

@Service
public class ServiceSconto {
	
	@Autowired
	RepositorySconto repositorySconto;
	
	public void inserimentoSconto(HashMap<String,String> infoSconto, int idPuntoVendita) {
		Sconto sconto = new Sconto();
		sconto.setIdPuntoVendita(idPuntoVendita);
		sconto.setValore(Integer.parseInt(infoSconto.get("valore_sconto")));;
		repositorySconto.save(sconto);
	}

	public boolean controllaSconto(Sconto sconto) {
		
		return false;
	}

	public float applicaSconto(Sconto sconto,int prezzoTotale) {
		float prezzoScontato = prezzoTotale - sconto.getValore();
		return prezzoScontato;
	}

	
	
}
