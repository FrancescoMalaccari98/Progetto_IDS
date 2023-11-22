package application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.model.PuntoVendita;

@Repository
public interface RepositoryPuntoVendita  extends JpaRepository<PuntoVendita, Long>{
	
	PuntoVendita findPuntoVenditaById(Long id);
	
	
	// Metodo per aggiungere l'id del programma al PuntoVendita
	default void aggiungiIdProgrammaAlPuntoVendita(Long idPuntoVendita, Long idProgramma) {
		PuntoVendita puntoVendita = findPuntoVenditaById(idPuntoVendita);

		if (puntoVendita != null) {
			List<Integer> listaProgrammi = puntoVendita.getProgrammaFedelta();
			Integer integerId = idProgramma.intValue();
			listaProgrammi.add(integerId);
			puntoVendita.setProgrammaFedelta(listaProgrammi);
			save(puntoVendita);
		}
	}
}
