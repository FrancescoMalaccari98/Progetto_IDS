package project.application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Coalizione")
public class Coalizione {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int idCoalizone;
    @Column
    private String descrizione;
    @Column
    private int idPuntoVendita;

	public int getIdCoalizone() {
		return idCoalizone;
	}

	public void setIdCoalizone(int idCoalizone) {
		this.idCoalizone = idCoalizone;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getIdPuntoVendita() {
		return idPuntoVendita;
	}

	public void setIdPuntoVendita(int idPuntoVendita) {
		this.idPuntoVendita = idPuntoVendita;
	}

	public String getAdesione() {
		return descrizione;
	}

	public void setAdesione(String descrizione) {
		this.descrizione = descrizione;
	}
}
