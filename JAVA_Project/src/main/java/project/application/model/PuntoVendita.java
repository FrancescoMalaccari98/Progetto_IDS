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
    private List<Integer> listaIdCatalogoPremi; 
    @Column
    private String recensione;
    @Column
    private List<Integer> listaIdClienti;
    
    public String getNome() {
		return nome;
	}
    
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public List<Integer> getListaClienti() {
		return listaIdClienti;
	}

	public void setListaClienti(List<Integer> listaClienti) {
		this.listaIdClienti = listaClienti;
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
		return listaIdCatalogoPremi;
	}

	public void setIdCatalogoPremi(List<Integer> idCatalogoPremi) {
		this.listaIdCatalogoPremi = idCatalogoPremi;
	}

	public String getRecensione() {
		return recensione;
	}

	public void setRecensione(String recensione) {
		this.recensione = recensione;
	}

	public List<Integer> getListaIdProgrammaFedelta() {
		return listaIdProgrammaFedelta;
	}

	public void setListaIdProgrammaFedelta(List<Integer> programmaFedelta) {
		this.listaIdProgrammaFedelta = programmaFedelta;
	}
}
