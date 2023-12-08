package project.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;
import project.application.model.Magazzino;

@Transactional
public interface RepositoryMagazzino  extends JpaRepository<Magazzino, Long> {

	List<Magazzino> findAllByIdPuntoVendita(int idPuntoVendita);

}
