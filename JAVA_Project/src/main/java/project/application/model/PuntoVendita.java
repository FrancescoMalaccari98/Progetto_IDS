package project.application.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PuntoVendita")
public class PuntoVendita {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    String nome;
    @Column
    String descrizione;
    @Column
	List<Integer> idProgrammaFedelta;
    @Column
	List<Integer> idCatalogoPremi; 
	
    public List<Integer> getProgrammaFedelta() {
		return idProgrammaFedelta;
	}

	public void setProgrammaFedelta(List<Integer> programmaFedelta) {
		this.idProgrammaFedelta = programmaFedelta;
	}
}