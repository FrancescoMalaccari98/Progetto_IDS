package application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.model.CartaFedelta;

@Repository
public interface RepositoryCartaFedelta extends JpaRepository<CartaFedelta, Integer>{
	
	CartaFedelta findCartaFedeltabyId(int id);
	
	CartaFedelta findCartaFedeltabyIdCliente(int idCliente);
	
	List<CartaFedelta> findCartaFedeltabyIdProgramma(int idProgramma);
}
