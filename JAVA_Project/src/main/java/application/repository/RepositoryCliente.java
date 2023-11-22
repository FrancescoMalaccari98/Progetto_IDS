package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.model.Cliente;

@Repository
public interface RepositoryCliente extends JpaRepository<Cliente, Long> {

    Cliente findByNomeUtenteAndPassword(String nomeUtente, String password);
    
}
