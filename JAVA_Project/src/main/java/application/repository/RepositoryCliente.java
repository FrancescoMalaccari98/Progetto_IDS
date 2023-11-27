package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import application.model.Cliente;

public interface RepositoryCliente extends JpaRepository<Cliente, Long> {

    Cliente findByNomeUtenteAndPassword(String nomeUtente, String password);
    
    Cliente findClienteById(int id);
    
}
