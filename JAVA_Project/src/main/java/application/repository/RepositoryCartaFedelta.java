package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.model.CartaFedelta;

@Repository
public interface RepositoryCartaFedelta extends JpaRepository<CartaFedelta, Integer>{
	
	CartaFedelta findCartaFedeltabyId(int id);
	
	CartaFedelta findCartaFedeltabyIdCliente(int idCliente);
}
