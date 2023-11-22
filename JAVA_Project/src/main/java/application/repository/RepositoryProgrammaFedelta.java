package application.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.model.ProgrammaFedelta;

@Repository
public interface RepositoryProgrammaFedelta extends JpaRepository<ProgrammaFedelta, Integer> {
	
	ProgrammaFedelta findProgrammaFedeltaById(int id);

}
