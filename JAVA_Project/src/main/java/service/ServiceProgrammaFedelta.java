package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.ProgrammaFedelta;
import repository.RepositoryProgrammaFedelta;

@Service
public class ServiceProgrammaFedelta {
	
	@Autowired
	RepositoryProgrammaFedelta repositoryProgrammaFedelta;
	
	public List<String> getListaProgrammiFedelta() {	
		List<String> listaProgrammi = new ArrayList<>();

        // Recupera la lista di programmi fedeltà dal repository
        List<ProgrammaFedelta> programmiFedelta = repositoryProgrammaFedelta.findAll();

        if (programmiFedelta == null || programmiFedelta.isEmpty()) {
            listaProgrammi.add("Non ci sono Programmi Fedeltà");
            return listaProgrammi;
        }

        // Aggiungi i nomi dei programmi alla lista
        for (ProgrammaFedelta programma : programmiFedelta) {
            listaProgrammi.add(programma.getNomeProgramma());
        }

        return listaProgrammi;	
	}
	
	public HashMap<String,String> getModuloAdesione(String programmaScelto) {
		HashMap<String,String> moduloAdesione= new HashMap<String,String>();
		if(programmaScelto.equals("Programma 1")) {
			moduloAdesione.put("Programma 1", "Modulo richiesta 1") ; //TODO Caricare Modulo dalle properties
		} else {
			moduloAdesione.put("Programma 2", "Modulo richiesta 2") ; //TODO Caricare Modulo dalle properties
		}
		
		return moduloAdesione;
	}

}
