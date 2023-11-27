package application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CartaFedelta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descrizione;
    private int punti;
    private int idProgrammaFedelta;
	private int idCliente;
    private int cashBack;
    private int livello;
    
	public int getLivello() {
		return livello;
	}
	public void setLivello(int livello) {
		this.livello = livello;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getId() {
		return id;
	}
	public int getPunti() {
		return punti;
	}
	public void setPunti(int punti) {
		this.punti = punti;
	}
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
    public int getCashBack() {
		return cashBack;
	}
	public void setCashBack(int cashBack) {
		this.cashBack = cashBack;
	}
}
