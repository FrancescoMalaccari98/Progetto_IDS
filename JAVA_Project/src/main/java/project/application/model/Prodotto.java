package project.application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Prodotto")
public class Prodotto {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String nome;
    @Column
    private String prezzo;
    @Column
    private String informazioniProdotto;
    @Column
    private int idPuntoVendita;
    
	public String getInformazioniProdotto() {
		return informazioniProdotto;
	}
	public void setInformazioniProdotto(String informazioniProdotto) {
		this.informazioniProdotto = informazioniProdotto;
	}
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}
	public int getIdPuntoVendita() {
		return idPuntoVendita;
	}
	public void setIdPuntoVendita(int idPuntoVendita) {
		this.idPuntoVendita = idPuntoVendita;
	}


}
