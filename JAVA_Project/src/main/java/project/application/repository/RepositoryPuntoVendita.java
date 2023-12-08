package project.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.application.model.PuntoVendita;
import jakarta.transaction.Transactional;

@Transactional
public interface RepositoryPuntoVendita  extends JpaRepository<PuntoVendita, Integer>{
	
	List<PuntoVendita> findPuntoVenditaByIdPuntoVendita(int idPuntoVendita);	
}
