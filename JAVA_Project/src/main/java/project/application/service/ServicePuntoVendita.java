package project.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project.application.model.PuntoVendita;
import project.application.repository.RepositoryPuntoVendita;

@Service
public class ServicePuntoVendita {
	
	RepositoryPuntoVendita repositoryPuntoVendita;
	
	public String controlloAdesioneEsistente(int idPuntoVendita,int idProgramma){
		PuntoVendita puntoVendita= repositoryPuntoVendita.findPuntoVenditaById(idPuntoVendita);
		
		if(puntoVendita != null) {
			List<Integer> programmmiFedelta = puntoVendita.getProgrammaFedelta();
			for (Integer idCurrentProgrammaFedelta : programmmiFedelta) {
				if(idCurrentProgrammaFedelta==idProgramma)
					return "Adesione già Esistente";
			}
		} else {
			return "Punto Vendita non Trovato";
		}
		
		return "RichiestaInformazioniAggiuntive";
	}
	
	public String aggiuntaProgramma(int idProgramma,int idPuntoVendita){
		try {
			repositoryPuntoVendita.aggiungiIdProgrammaAlPuntoVendita(idProgramma,idPuntoVendita);
		} catch (Exception e) {
			return "Errore nell'aggiunta del programma a questo punto vendita (idPuntoVendita: "
					+ idPuntoVendita + ")";
		}
		return "Avviso Corretta Adesione";
	}
	
}
