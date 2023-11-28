package project.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.application.model.Cliente;
import jakarta.transaction.Transactional;

@Transactional
public interface RepositoryCliente extends JpaRepository<Cliente, Long> {

    Cliente findByNomeUtenteAndPassword(String nomeUtente, String password);
    
    Cliente findClienteById(int id);
    
}
