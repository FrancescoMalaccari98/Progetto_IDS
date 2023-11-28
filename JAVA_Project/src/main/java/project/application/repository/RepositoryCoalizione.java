package project.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.application.model.Coalizione;
import jakarta.transaction.Transactional;

@Transactional
public interface RepositoryCoalizione extends JpaRepository<Coalizione, Long> {
	
	Coalizione findCoalizioneById(Long id);

}
