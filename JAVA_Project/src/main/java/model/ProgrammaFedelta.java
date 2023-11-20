package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProgrammaFedelta {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String NomeProgramma;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public ProgrammaFedelta(Long id, String nomeProgramma) {
		super();
		this.id = id;
		NomeProgramma = nomeProgramma;
	}
	
	public String getNomeProgramma() {
		return NomeProgramma;
	}
	
	public void setNomeProgramma(String nomeProgramma) {
		NomeProgramma = nomeProgramma;
	}

}
