package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.PuntoVendita;

@Repository
public interface RepositoryPuntoVendita  extends JpaRepository<PuntoVendita, Long>{
	
	//optional nel caso in cui l'entità non è presente in DB
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
