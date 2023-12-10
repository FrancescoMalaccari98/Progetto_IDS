package project.application.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ProgrammaFedelta")
public class ProgrammaFedelta {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
    @Column
    private String NomeProgramma;
    @Column
    private String informazioniBase;
    @Column
    private String informazioniDettagliate;
    @Column
	private String listaServiziEsclusivi;

	public ProgrammaFedelta(String nomeProgramma, String informazioniBase, String informazioniDettagliate) {
		super();
		NomeProgramma = nomeProgramma;
		this.informazioniBase = informazioniBase;
		this.informazioniDettagliate = informazioniDettagliate;
	}
	

	public ProgrammaFedelta(String nomeProgramma, String informazioniBase) {
		super();
		NomeProgramma = nomeProgramma;
		this.informazioniBase = informazioniBase;
	}
	
	public ProgrammaFedelta() {
	}
	
	public String getInformazioniDettagliate() {
		return informazioniDettagliate;
	}

	public void setInformazioniDettagliate(String informazioniDettagliate) {
		this.informazioniDettagliate = informazioniDettagliate;
	}

	public String  getInformazioniBase() {
		return informazioniBase;
	}

	public void setInformazioniBase(String  informazioniBase) {
		this.informazioniBase = informazioniBase;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
  public String getListaServiziEsclusivi() {
		return listaServiziEsclusivi;
	}


	public void setListaServiziEsclusivi(String listaServiziEsclusivi) {	
		this.listaServiziEsclusivi = listaServiziEsclusivi;
	}
		
	public ProgrammaFedelta(int id, String nomeProgramma) {
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
