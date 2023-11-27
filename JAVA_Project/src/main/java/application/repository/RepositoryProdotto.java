package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Prodotto;

public interface RepositoryProdotto  extends JpaRepository<Prodotto, Long> {
	
	Prodotto findProdottoById(int idProdotto);
}
