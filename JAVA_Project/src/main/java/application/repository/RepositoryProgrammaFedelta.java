package application.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import application.model.ProgrammaFedelta;

public interface RepositoryProgrammaFedelta extends JpaRepository<ProgrammaFedelta, Integer> {
	
	ProgrammaFedelta findProgrammaFedeltaById(int id);

}
