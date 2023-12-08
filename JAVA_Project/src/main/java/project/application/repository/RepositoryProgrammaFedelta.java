package project.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.application.model.ProgrammaFedelta;
import jakarta.transaction.Transactional;

@Transactional
public interface RepositoryProgrammaFedelta extends JpaRepository<ProgrammaFedelta, Integer> {
	
	ProgrammaFedelta findProgrammaFedeltaById(int id);

}
