package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.model.Prodotto;

@Repository
public interface RepositoryProdotto  extends JpaRepository<Prodotto, Long> {
	
	Prodotto findProdottoById(int idProdotto);
}
