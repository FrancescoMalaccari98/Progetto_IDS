package application.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PuntoVendita {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String nome;
    String descrizione;
	List<Integer> idProgrammaFedelta;
	List<Integer> idCatalogoPremi; 
	
    public List<Integer> getProgrammaFedelta() {
		return idProgrammaFedelta;
	}

	public void setProgrammaFedelta(List<Integer> programmaFedelta) {
		this.idProgrammaFedelta = programmaFedelta;
	}
}
