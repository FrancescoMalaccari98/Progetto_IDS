package application.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.ProgrammaFedelta;
import application.repository.RepositoryProgrammaFedelta;

@Service
public class ServiceProgrammaFedelta {
	
	@Autowired
	RepositoryProgrammaFedelta repositoryProgrammaFedelta;
	
	public List<ProgrammaFedelta> getListaProgrammiFedelta() {	
        // Recupera la lista di programmi fedeltà dal repository
        List<ProgrammaFedelta> programmiFedelta = repositoryProgrammaFedelta.findAll();
        
        return programmiFedelta;	
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
	
	public HashMap<String,String> creazioneProgrammaFedelta(){
		HashMap<String,String> richiestaInformazioniBase = new HashMap<String,String>();
		richiestaInformazioniBase.put("idProgrammaFedelta", "1");
		richiestaInformazioniBase.put("nomeProgramma 1", "Nome programma");
		richiestaInformazioniBase.put("informazioniBase", "Programma Fedeltà 1");
		
		richiestaInformazioniBase.put("idProgrammaFedelta", "2");
		richiestaInformazioniBase.put("nomeProgramma 2", "Nome programma");
		richiestaInformazioniBase.put("informazioniBase", "Programma Fedeltà 2");

		return richiestaInformazioniBase;
	}
	
	public String inserimentoInformazioniBase(HashMap<String,String>  moduloInformazioneBase){
		String nomeProgramma = moduloInformazioneBase.get("nomeProgramma");
		String informazioniBaseString = moduloInformazioneBase.get("informazioniBase");
		
		ProgrammaFedelta newProgramma = new ProgrammaFedelta(nomeProgramma,informazioniBaseString);
		
		try {
			repositoryProgrammaFedelta.save(newProgramma);
		} catch (Exception e) {
			return "Errore nel salvataggio del nuovo Programma";
		}
		return "RichiestaInformazioniDettagliate";
	}
	
	
	public String inserimentoInformazioniDetagliate(HashMap<String,String>  moduloInformazioniDettagliate){
		int idProgrammaFedelta = Integer.parseInt( moduloInformazioniDettagliate.get("idProgrammaFedelta"));
		String informazioniDettagliateString = moduloInformazioniDettagliate.get("informazioniDettagliate");

		ProgrammaFedelta programmaFedelta = repositoryProgrammaFedelta.findProgrammaFedeltaById((long) idProgrammaFedelta);
		
		programmaFedelta.setInformazioniDettagliate(informazioniDettagliateString);
		
		try {
			repositoryProgrammaFedelta.save(programmaFedelta);
		} catch (Exception e) {
			return "Errore nel salvataggio del nuovo Programma";
		}
		return "RichiestaInformazioniDettagliate";
	}
}
