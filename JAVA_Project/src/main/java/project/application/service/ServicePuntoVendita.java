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
		List<PuntoVendita> listPuntoVendita= repositoryPuntoVendita.findPuntoVenditaByIdPuntoVendita(idPuntoVendita);
		
		if(listPuntoVendita != null) {
			for (PuntoVendita puntoVendita : listPuntoVendita) {
				if(puntoVendita.getListaIdProgrammaFedelta() != 0) {
					if(puntoVendita.getListaIdProgrammaFedelta()==idProgramma)
						return "Adesione già Esistente";
				}
			}
		} else {
			return "Punto Vendita non Trovato";
		}
		
		return "RichiestaInformazioniAggiuntive";
	}
	
	public String aggiuntaProgramma(int idProgramma,int idPuntoVendita){
		try {
			List<PuntoVendita> listaPuntoVendita = repositoryPuntoVendita.findPuntoVenditaByIdPuntoVendita(idPuntoVendita);

			if (listaPuntoVendita != null) {
				for (PuntoVendita puntoVendita : listaPuntoVendita) {
				if(puntoVendita.getListaIdProgrammaFedelta() != 0) {
						PuntoVendita puntoVenditaProg = new PuntoVendita();
						puntoVenditaProg.setIdProgrammaFedelta(idProgramma);
						puntoVenditaProg.setDescrizione(puntoVendita.getDescrizione());
						puntoVenditaProg.setIdCatalogoPremi(puntoVendita.getIdCatalogoPremi());
						repositoryPuntoVendita.save(puntoVenditaProg);
						break;
					}
				}
			}
		} catch (Exception e) {
			return "Errore nell'aggiunta del programma a questo punto vendita (idPuntoVendita: "
					+ idPuntoVendita + ")";
		}
		return "Avviso Corretta Adesione";
	}

	public List<Integer> getCatalogoPremi(int idPuntoVendita) {
		List<PuntoVendita> listaPuntoVendita = repositoryPuntoVendita.findPuntoVenditaByIdPuntoVendita(idPuntoVendita);
		List<Integer> idCatalogoPremi = new ArrayList<Integer>();
		for (PuntoVendita puntoVendita : listaPuntoVendita) {
			if(puntoVendita.getIdCatalogoPremi() != 0 && puntoVendita.getIdProgrammaFedelta() ==0 && puntoVendita.getListaClienti() ==0 ) {
				idCatalogoPremi.add(puntoVendita.getIdCatalogoPremi());
			}
		}
		return idCatalogoPremi;
	}

	public String inserimentoRecensione(int value, String descrizione, int idPuntoVendita) {
		List<PuntoVendita> listPuntoVendita = repositoryPuntoVendita.findPuntoVenditaByIdPuntoVendita(idPuntoVendita);
		for (PuntoVendita puntoVendita : listPuntoVendita) {
			serviceRecensione.insertRecensione(descrizione, idPuntoVendita, value);
			puntoVendita.setRecensione(puntoVendita.getRecensione()+","+descrizione);
			repositoryPuntoVendita.save(puntoVendita);
			return "Conferma Recensione";
		}
		return "Errore Recensione";

	}
	
	public String updateCatalogo(int idPremio, int idPuntoVendita) {
		List<PuntoVendita> listPuntoVendita = repositoryPuntoVendita.findPuntoVenditaByIdPuntoVendita(idPuntoVendita);
		for (PuntoVendita puntoVendita : listPuntoVendita) {
			if(puntoVendita.getIdCatalogoPremi() == idPremio)
				repositoryPuntoVendita.delete(puntoVendita);
			return "Conferma Catalogo modificato";
		}
		return "Errore modifica Catalogo";
	}

	public List<String> getListaPuntiVendita() {
		List<PuntoVendita>listaPuntiVendita =repositoryPuntoVendita.findAll();
		List<String> listaNomiPuntiVendita = new ArrayList<String>();
		for(PuntoVendita puntoVendita: listaPuntiVendita) {
			if(!listaNomiPuntiVendita.contains(puntoVendita.getNome()))
				listaNomiPuntiVendita.add(puntoVendita.getNome());
		}
		return listaNomiPuntiVendita;
	}

	public List<Integer> getListaProgrammiFedelta(int idPuntoVendita) {
		List<PuntoVendita> listPuntoVendita=repositoryPuntoVendita.findPuntoVenditaByIdPuntoVendita(idPuntoVendita);
		List<Integer> idCatalogoPremi = new ArrayList<Integer>();
		for (PuntoVendita puntoVendita : listPuntoVendita) {
			if(puntoVendita.getIdCatalogoPremi() != 0 && puntoVendita.getListaClienti() ==0 && puntoVendita.getIdProgrammaFedelta() ==0)
				idCatalogoPremi.add(puntoVendita.getIdCatalogoPremi());
		}		
		return idCatalogoPremi;
	}
	
	public boolean checkDatiIstruzione (HashMap<String,String> datiIstruzione){
		 if(datiIstruzione.get("idPuntoVendita")==null)
		 return false;
		return true;
	}

	public List<Integer> getListaNomiProgrammiFedelta(int idPuntoVendita) {
		List<PuntoVendita> listaPuntoVendita=repositoryPuntoVendita.findPuntoVenditaByIdPuntoVendita(idPuntoVendita);		
		List<Integer> idProgrammiFedelta = new ArrayList<Integer>();
		for (PuntoVendita puntoVendita : listaPuntoVendita) {
			if(puntoVendita.getIdCatalogoPremi() == 0 && puntoVendita.getListaClienti() ==0 && puntoVendita.getIdProgrammaFedelta() !=0)
				idProgrammiFedelta.add(puntoVendita.getIdProgrammaFedelta());
		}		
		return idProgrammiFedelta;
	}

	public List<Integer> getListaNomiClienti(int idPuntoVendita) {
		List<PuntoVendita> listaPuntoVendita=repositoryPuntoVendita.findPuntoVenditaByIdPuntoVendita(idPuntoVendita);		
		List<Integer> idClienti = new ArrayList<Integer>();
		for (PuntoVendita puntoVendita : listaPuntoVendita) {
			if(puntoVendita.getIdCatalogoPremi() == 0 && puntoVendita.getListaClienti() !=0 && puntoVendita.getIdProgrammaFedelta() ==0)
				idClienti.add(puntoVendita.getListaClienti());
		}		
		return idClienti;
	}
}
