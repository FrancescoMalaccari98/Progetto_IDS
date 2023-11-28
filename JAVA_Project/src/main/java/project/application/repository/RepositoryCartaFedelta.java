package project.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.application.model.CartaFedelta;
import jakarta.transaction.Transactional;

@Transactional
public interface RepositoryCartaFedelta extends JpaRepository<CartaFedelta, Integer>{
	
	CartaFedelta findById(int id);
	
	CartaFedelta findByIdCliente(int idCliente);
	
	List<CartaFedelta> findByIdProgrammaFedelta(int idProgrammaFedelta);
}
