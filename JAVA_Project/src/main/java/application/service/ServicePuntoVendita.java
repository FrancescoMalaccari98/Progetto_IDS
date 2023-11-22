package application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.ProgrammaFedelta;
import application.model.PuntoVendita;
import application.repository.RepositoryPuntoVendita;

@Service
public class ServicePuntoVendita {
	
	RepositoryPuntoVendita repositoryPuntoVendita;
	
	public String controlloAdesioneEsistente(int idPuntoVendita,int idProgramma){
		long longId = idPuntoVendita;
		PuntoVendita puntoVendita= repositoryPuntoVendita.findPuntoVenditaById(longId);
		
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
	
	public String aggiuntaProgramma(Long idProgramma,Long idPuntoVendita){
		try {
			repositoryPuntoVendita.aggiungiIdProgrammaAlPuntoVendita(idProgramma,idPuntoVendita);
		} catch (Exception e) {
			return "Errore nell'aggiunta del programma a questo punto vendita (idPuntoVendita: "
					+ idPuntoVendita + ")";
		}
		return "Avviso Corretta Adesione";
	}
	
}
