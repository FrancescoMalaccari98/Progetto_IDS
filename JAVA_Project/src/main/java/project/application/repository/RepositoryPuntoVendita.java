package project.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.application.model.PuntoVendita;
import jakarta.transaction.Transactional;

@Transactional
public interface RepositoryPuntoVendita  extends JpaRepository<PuntoVendita, Integer>{
	
	PuntoVendita findPuntoVenditaById(int id);
	
	
	// Metodo per aggiungere l'id del programma al PuntoVendita
	default void aggiungiIdProgrammaAlPuntoVendita(int idPuntoVendita, int idProgramma) {
		PuntoVendita puntoVendita = findPuntoVenditaById(idPuntoVendita);

		if (puntoVendita != null) {
			List<Integer> listaProgrammi = puntoVendita.getProgrammaFedelta();
			listaProgrammi.add(idProgramma);
			puntoVendita.setProgrammaFedelta(listaProgrammi);
			save(puntoVendita);
		}
	}
}
