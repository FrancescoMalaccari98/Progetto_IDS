package application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Prodotto {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nome;
    private String prezzo;
    private String informazioniProdotto;
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
