package project.application.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.application.model.PuntoVendita;
import project.application.repository.RepositoryPuntoVendita;

@Service
public class ServicePuntoVendita {
	
	@Autowired
	RepositoryPuntoVendita repositoryPuntoVendita;
	
	@Autowired
	ServiceRecensione serviceRecensione;
	
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
			PuntoVendita puntoVendita = repositoryPuntoVendita.findPuntoVenditaById(idPuntoVendita);

			if (puntoVendita != null) {
				List<Integer> listaProgrammi = puntoVendita.getProgrammaFedelta();
				listaProgrammi.add(idProgramma);
				puntoVendita.setProgrammaFedelta(listaProgrammi);
				repositoryPuntoVendita.save(puntoVendita);
			}
		} catch (Exception e) {
			return "Errore nell'aggiunta del programma a questo punto vendita (idPuntoVendita: "
					+ idPuntoVendita + ")";
		}
		return "Avviso Corretta Adesione";
	}

	public List<Integer> getCatalogoPremi(int idPuntoVendita) {
		PuntoVendita puntoVendita = repositoryPuntoVendita.findPuntoVenditaById(idPuntoVendita);
		return puntoVendita.getIdCatalogoPremi();
	}

	public String inserimentoRecensione(int value, String descrizione, int idPuntoVendita) {
		PuntoVendita puntoVendita = repositoryPuntoVendita.findPuntoVenditaById(idPuntoVendita);
		serviceRecensione.insertRecensione(descrizione, idPuntoVendita, value);
		puntoVendita.setRecensione(puntoVendita.getRecensione()+","+descrizione);
		repositoryPuntoVendita.save(puntoVendita);
		return "Conferma Recensione";
	}
	
	public String updateCatalogo(int idPremio, int idPuntoVendita) {
		PuntoVendita puntoVendita = repositoryPuntoVendita.findPuntoVenditaById(idPuntoVendita);
		List<Integer> listaIdPremi = puntoVendita.getIdCatalogoPremi();
		listaIdPremi.remove(idPremio);
		puntoVendita.setIdCatalogoPremi(listaIdPremi);
		repositoryPuntoVendita.save(puntoVendita);
		return "Conferma Recensione";
	}

	public List<String> getListaPuntiVendita() {
		List<PuntoVendita>listaPuntiVendita =repositoryPuntoVendita.findAll();
		List<String> listaNomiPuntiVendita = new ArrayList<String>();
		for(PuntoVendita puntoVendita: listaPuntiVendita) {
			listaNomiPuntiVendita.add(puntoVendita.getNome());
		return listaNomiPuntiVendita;
		}
		return listaNomiPuntiVendita;
	}

	public List<Integer> getListaProgrammiFedeltà(int idPuntoVendita) {
		PuntoVendita puntoVendita=repositoryPuntoVendita.findPuntoVenditaById(idPuntoVendita);
		return puntoVendita.getProgrammaFedelta();
	}
	
	public boolean checkDatiIstruzione (HashMap<String,String> datiIstruzione){
		 if(datiIstruzione.get("idPuntoVendita")==null)
		 return false;
		return true;
	}

}
