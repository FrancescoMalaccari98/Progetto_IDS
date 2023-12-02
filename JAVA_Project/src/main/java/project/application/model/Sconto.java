package project.application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Sconto")
public class Sconto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @Column
    private int idPuntoVendita;
    @Column
    private int valore;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getValore() {
		return valore;
	}
	public void setValore(int valore) {
		this.valore = valore;
	}
	public int getIdPuntoVendita() {
		return idPuntoVendita;
	}
	public void setIdPuntoVendita(int idPuntoVendita) {
		this.idPuntoVendita = idPuntoVendita;
	}
}
