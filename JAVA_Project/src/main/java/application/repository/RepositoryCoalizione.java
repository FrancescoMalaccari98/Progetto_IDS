package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.model.Coalizione;

@Repository
public interface RepositoryCoalizione extends JpaRepository<Coalizione, Long> {
	
	Coalizione findCoalizioneById(Long id);

}
