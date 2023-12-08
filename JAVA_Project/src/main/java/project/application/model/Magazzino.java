package project.application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Magazzino")
public class Magazzino {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @Column
    private int idPuntoVendita;
    @Column
    private int idProdotto;
    @Column
    private int quantita;

}
