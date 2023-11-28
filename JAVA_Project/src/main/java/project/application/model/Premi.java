package project.application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Premi")
public class Premi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String descrizioni;
    @Column
    private int puntiRiscatto;
    
	public String getDescrizioni() {
		return descrizioni;
	}
	public void setDescrizioni(String descrizioni) {
		this.descrizioni = descrizioni;
	}
	public int getPuntiRiscatto() {
		return puntiRiscatto;
	}
	public void setPuntiRiscatto(int puntiRiscatto) {
		this.puntiRiscatto = puntiRiscatto;
	}
    
    
}
