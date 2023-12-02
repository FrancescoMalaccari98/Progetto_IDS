package project.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;
import project.application.model.Sconto;

@Transactional
public interface RepositorySconto extends JpaRepository<Sconto, Integer>{

	
}
