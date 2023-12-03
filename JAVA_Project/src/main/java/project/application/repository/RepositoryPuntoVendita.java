package project.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.application.model.PuntoVendita;
import jakarta.transaction.Transactional;

@Transactional
public interface RepositoryPuntoVendita  extends JpaRepository<PuntoVendita, Integer>{
	
	PuntoVendita findPuntoVenditaById(int id);	
}
