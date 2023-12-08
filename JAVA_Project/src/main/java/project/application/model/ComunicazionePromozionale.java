package project.application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ComunicazionePromozionale")
public class ComunicazionePromozionale {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @Column
    private int tipo;
    @Column
    private String contenuto;
    @Column
    private int idPuntoVendita;
    @Column
    private int idProgrammaFedelta;
	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getContenuto() {
		return contenuto;
	}
	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}
	public int getIdPuntoVendita() {
		return idPuntoVendita;
	}
	public void setIdPuntoVendita(int idPuntoVendita) {
		this.idPuntoVendita = idPuntoVendita;
	}
	public int getIdProgrammaFedelta() {
		return idProgrammaFedelta;
	}
	public void setIdProgrammaFedelta(int idProgrammaFedelta) {
		this.idProgrammaFedelta = idProgrammaFedelta;
	}

}
