package application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
	private String nomeUtente;
    @Column
    private String password;
    
	public Cliente(String nomeUtente, String password) {
		super();
		this.nomeUtente = nomeUtente;
		this.password = password;
	}
	
	public Cliente() {}
	
	public int getId() {
		return id;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}
	
	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}
