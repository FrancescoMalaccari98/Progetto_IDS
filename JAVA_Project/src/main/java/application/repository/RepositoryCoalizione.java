package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Coalizione;

public interface RepositoryCoalizione extends JpaRepository<Coalizione, Long> {
	
	Coalizione findCoalizioneById(Long id);

}
