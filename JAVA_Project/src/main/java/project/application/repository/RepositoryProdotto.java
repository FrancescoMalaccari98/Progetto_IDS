package project.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.application.model.Prodotto;
import jakarta.transaction.Transactional;

@Transactional
public interface RepositoryProdotto  extends JpaRepository<Prodotto, Long> {
	
	Prodotto findById(int id);

	Prodotto findProdottoById(int idProdotto);
}
