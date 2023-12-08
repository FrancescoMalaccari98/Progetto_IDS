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
    @Column
    private int idCliente;
    @Column
    private int idProgrammaFedelta;
	
    
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdProgrammaFedelta() {
		return idProgrammaFedelta;
	}
	public void setIdProgrammaFedelta(int idProgrammaFedelta) {
		this.idProgrammaFedelta = idProgrammaFedelta;
	}
	public int getId() {
		return id;
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
