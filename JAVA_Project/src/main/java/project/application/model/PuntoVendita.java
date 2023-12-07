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
    private String nome;
    @Column
    private String descrizione;
    @Column
    private List<Integer> listaIdProgrammaFedelta;
    @Column
    private List<Integer> idCatalogoPremi; 
    @Column
    private String recensione;
	
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Integer> getIdProgrammaFedelta() {
		return listaIdProgrammaFedelta;
	}

	public void setIdProgrammaFedelta(List<Integer> idProgrammaFedelta) {
		this.listaIdProgrammaFedelta = idProgrammaFedelta;
	}

	public List<Integer> getIdCatalogoPremi() {
		return idCatalogoPremi;
	}

	public void setIdCatalogoPremi(List<Integer> idCatalogoPremi) {
		this.idCatalogoPremi = idCatalogoPremi;
	}

	public String getRecensione() {
		return recensione;
	}

	public void setRecensione(String recensione) {
		this.recensione = recensione;
	}

	public List<Integer> getProgrammaFedelta() {
		return listaIdProgrammaFedelta;
	}

	public void setProgrammaFedelta(List<Integer> programmaFedelta) {
		this.listaIdProgrammaFedelta = programmaFedelta;
	}
}
