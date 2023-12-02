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
    private String adesione;

	public String getAdesione() {
		return adesione;
	}

	public void setAdesione(String adesione) {
		this.adesione = adesione;
	}
}