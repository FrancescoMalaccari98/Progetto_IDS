package project.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.application.model.ComunicazionePromozionale;
import project.application.repository.RepositoryComunicazionePromozionale;

@Service
public class ServiceComunicazionePromozionale {
	
	@Autowired
	RepositoryComunicazionePromozionale repositoryComunicazionePromozionale;
	
	public List<ComunicazionePromozionale> getListaCPromozionale(int idPuntoVendita){
		return repositoryComunicazionePromozionale.findComunicazionePromozionaleByIdPuntoVendita(idPuntoVendita);
	}

	public String inserimentoCPromozionale(int idProgrammaFedelta, String info, int idPuntoVendita) {
		ComunicazionePromozionale cp = new ComunicazionePromozionale();
		cp.setIdProgrammaFedelta(idProgrammaFedelta);
		cp.setIdPuntoVendita(idPuntoVendita);
		cp.setContenuto(info);
		repositoryComunicazionePromozionale.save(cp);
		return "confermaCreazione";
	}

	public String richiestaInfoCP(int idProgrammaFedelta) {
		return "Richiedi le info CP";
	}
}
