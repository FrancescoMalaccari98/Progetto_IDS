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
    private int idPuntoVendita;
    @Column
    private String nome;
    @Column
    private String descrizione;
    @Column
    private int idProgrammaFedelta;
    @Column
    private int idCatalogoPremi; 
    @Column
    private String recensione;
    @Column
    private int idClienti;
    
    public String getNome() {
		return nome;
	}
    
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public int getListaClienti() {
		return idClienti;
	}

	public void setListaClienti(int listaClienti) {
		this.idClienti = listaClienti;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getIdProgrammaFedelta() {
		return idProgrammaFedelta;
	}

	public void setIdProgrammaFedelta(int idProgrammaFedelta) {
		this.idProgrammaFedelta = idProgrammaFedelta;
	}

	public int getIdCatalogoPremi() {
		return idCatalogoPremi;
	}

	public void setIdCatalogoPremi(int idCatalogoPremi) {
		this.idCatalogoPremi = idCatalogoPremi;
	}

	public String getRecensione() {
		return recensione;
	}

	public void setRecensione(String recensione) {
		this.recensione = recensione;
	}

	public int getListaIdProgrammaFedelta() {
		return idProgrammaFedelta;
	}

	public void setListaIdProgrammaFedelta(int programmaFedelta) {
		this.idProgrammaFedelta = programmaFedelta;
	}
}
