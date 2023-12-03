package project.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;
import project.application.model.Recensione;

@Transactional
public interface RepositoryRecensione extends JpaRepository<Recensione, Long>  {

}
