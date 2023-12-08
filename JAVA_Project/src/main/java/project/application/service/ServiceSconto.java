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

	public String inserimentoScontoProgramma(int idProgramma) {
		Sconto sconto = new Sconto();
		sconto.setIdProgrammaFedelta(idProgramma);
		sconto.setIdPuntoVendita(0);
		repositorySconto.save(sconto);
		return "ConfermaAssegnazioneSconto";
	}

	public String inserimentoScontoCliente(int idCliente) {
		Sconto sconto = new Sconto();
		sconto.setIdCliente(idCliente);
		sconto.setIdProgrammaFedelta(0);
		repositorySconto.save(sconto);
		return "ConfermaAssegnazioneSconto";
	}

	
	
}
