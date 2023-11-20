package model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PuntoVendita {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

	List<Integer> idProgrammaFedelta;
	
    public List<Integer> getProgrammaFedelta() {
		return idProgrammaFedelta;
	}

	public void setProgrammaFedelta(List<Integer> programmaFedelta) {
		this.idProgrammaFedelta = programmaFedelta;
	}
}
