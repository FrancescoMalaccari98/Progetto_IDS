package application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coalizione {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String adesione;

	public String getAdesione() {
		return adesione;
	}

	public void setAdesione(String adesione) {
		this.adesione = adesione;
	}
}
