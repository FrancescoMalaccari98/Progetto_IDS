package project.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;
import project.application.model.CartaFedelta;
import project.application.model.Operatore;

@Transactional
public interface RepositoryOperatore extends JpaRepository<Operatore, Integer> {
	
	Operatore findById(int id);

	List<Operatore> findAllByIdPuntoVendita(int idPuntoVendita);

}
