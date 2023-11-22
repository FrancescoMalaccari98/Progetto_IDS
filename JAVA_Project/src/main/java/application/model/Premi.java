package application.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Premi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String descrizioni;
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
