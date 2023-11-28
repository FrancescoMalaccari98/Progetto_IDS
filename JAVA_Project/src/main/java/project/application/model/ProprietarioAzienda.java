package project.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ProprietarioAzienda")
public class ProprietarioAzienda {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
