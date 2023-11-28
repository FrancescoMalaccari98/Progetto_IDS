package project.application.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.application.model.ProgrammaFedelta;
import project.application.repository.RepositoryProgrammaFedelta;

@Service
public class ServiceProgrammaFedelta {
	
	@Autowired
	public
	RepositoryProgrammaFedelta repositoryProgrammaFedelta;

	public List<ProgrammaFedelta> getListaProgrammiFedelta() {	
        // Recupera la lista di programmi fedeltà dal repository
        List<ProgrammaFedelta> programmiFedelta = repositoryProgrammaFedelta.findAll();
        
        return programmiFedelta;	
	}
	
	public HashMap<String,String> getModuloAdesione(int idProgrammaScelto) {
		HashMap<String,String> moduloAdesione= new HashMap<String,String>();
		
		// Ottieni il percorso assoluto del file properties
        String pathToFile = "src/main/resources/project.application.properties";
        
		// Carica il file properties in base all'id del programma scelto
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(pathToFile)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Estrai i valori dalle properties in base all'id del programma scelto
        String chiaveProgramma = "programma" + idProgrammaScelto;
        String moduloRichiesta = properties.getProperty(chiaveProgramma);

        // Aggiungi la coppia chiave-valore all'HashMap
        moduloAdesione.put(chiaveProgramma, moduloRichiesta);
        System.out.println(moduloAdesione);
		return moduloAdesione;
	}
	
	public HashMap<String,String> creazioneProgrammaFedelta(){
        
        String pathToFile = "src/main/resources/project.application.properties";

        // Carica il file properties
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(pathToFile)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Estrai le informazioni dai properties
        HashMap<String, String> richiestaInformazioniBase = new HashMap<>();

        String chiaveId = "moduloBase.idProgrammaFedelta";
        String chiaveNome = "moduloBase.nomeProgramma";
        String chiaveInformazioniBase = "moduloBase.informazioniBase";
            
        richiestaInformazioniBase.put(chiaveId, properties.getProperty(chiaveId));
        richiestaInformazioniBase.put(chiaveNome, properties.getProperty(chiaveNome));
        richiestaInformazioniBase.put(chiaveInformazioniBase, properties.getProperty(chiaveInformazioniBase));

        return richiestaInformazioniBase;
	}
	
	public HashMap<String,String>  inserimentoInformazioniBase(HashMap<String,String>  moduloInformazioneBase){
		String nomeProgramma = moduloInformazioneBase.get("nomeProgramma");
		String informazioniBaseString = moduloInformazioneBase.get("informazioniBase");
		
		ProgrammaFedelta newProgramma = new ProgrammaFedelta(nomeProgramma,informazioniBaseString);
		
		try {
			repositoryProgrammaFedelta.save(newProgramma);
		} catch (Exception e) {
			return null;
		}
		
		String pathToFile = "src/main/resources/project.application.properties";

        // Carica il file properties
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(pathToFile)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Estrai le informazioni dai properties
        HashMap<String, String> richiestaInformazioniDettagliate = new HashMap<>();

        String chiaveId = "moduloDettagliato.idProgrammaFedelta";
        String chiaveNome = "moduloDettagliato.nomeProgramma";
        String chiaveInformazioniBase = "moduloDettagliato.informazioniDettagliate";
            
        richiestaInformazioniDettagliate.put(chiaveId, properties.getProperty(chiaveId));
        richiestaInformazioniDettagliate.put(chiaveNome, properties.getProperty(chiaveNome));
        richiestaInformazioniDettagliate.put(chiaveInformazioniBase, properties.getProperty(chiaveInformazioniBase));
        
		return richiestaInformazioniDettagliate;
	}
	
	
	public String inserimentoInformazioniDetagliate(HashMap<String,String>  moduloInformazioniDettagliate){
		int idProgrammaFedelta = Integer.parseInt( moduloInformazioniDettagliate.get("idProgrammaFedelta"));
		String informazioniDettagliateString = moduloInformazioniDettagliate.get("informazioniDettagliate");

		ProgrammaFedelta programmaFedelta = repositoryProgrammaFedelta.findProgrammaFedeltaById(idProgrammaFedelta);
		
		programmaFedelta.setInformazioniDettagliate(informazioniDettagliateString);
		
		try {
			repositoryProgrammaFedelta.save(programmaFedelta);
		} catch (Exception e) {
			return "Errore nel salvataggio del nuovo Programma";
		}
		return "RichiestaInformazioniDettagliate";
	}

	public ProgrammaFedelta getProgrammaFedelta(int idProgrammaFedelta) {
		return repositoryProgrammaFedelta.findProgrammaFedeltaById(idProgrammaFedelta);
	}
}
