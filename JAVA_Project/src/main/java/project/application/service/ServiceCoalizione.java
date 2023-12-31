package project.application.service;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import project.application.model.Coalizione;
import project.application.repository.RepositoryCoalizione;

@Service
public class ServiceCoalizione {
	
	RepositoryCoalizione repositoryCoalizione;

	public boolean controlloCoalizione(HashMap<String,String> informazioni) {
		Long idCoalizione = Long.parseLong(informazioni.get("idCoalizione"));
		
		Coalizione coalizione = repositoryCoalizione.findCoalizioneById(idCoalizione);
		
		if(coalizione==null) {
			repositoryCoalizione.save(coalizione);
			return false;
		} else{
			return true;
		} 
	}

	public String inserimentoAdesione(String adesione) {
		Coalizione coalizione = new Coalizione();
		coalizione.setAdesione(adesione);
		try {
			repositoryCoalizione.save(coalizione);
		} catch (Exception e) {
			return "Errore inserimento Adesione";
		}
		return "Adesione Effettuata";
	}

	public String creaCoalizione(List<Integer> listaIdPuntiVendita, int idCoalizione) {
		Coalizione coalizione = new Coalizione();
		coalizione.setIdCoalizone(idCoalizione);
		for (Integer id : listaIdPuntiVendita) {
			coalizione.setIdPuntoVendita(id);
			repositoryCoalizione.save(coalizione);
			return "Adesione Effettuata";
		}
		return "Errore inserimento Adesione";
	}
	
	
	

}
