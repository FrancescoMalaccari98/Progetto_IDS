package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.CartaFedelta;
import application.model.Cliente;
import application.repository.RepositoryCartaFedelta;

@Service
public class ServiceCartaFedelta {
	
	@Autowired
	RepositoryCartaFedelta repositoryCartaFedelta;
	
	public CartaFedelta getCartaFedelta(int idCartaFedelta) {
		return repositoryCartaFedelta.findCartaFedeltabyId(idCartaFedelta);
	}
	
	public String updatePunti(int idCartaFedelta,int punti) {
		 CartaFedelta cartaCliente = repositoryCartaFedelta.findCartaFedeltabyIdCliente(idCartaFedelta);
		 cartaCliente.setPunti(cartaCliente.getPunti()+punti);
		 return "Punti Aggiornati";
	}
	
	public List<CartaFedelta> getListaCartaFedelta(int idProgramma) {
		return repositoryCartaFedelta.findCartaFedeltabyIdProgramma(idProgramma);
	}
	
	public int getCashBack(int idCliente) {
		CartaFedelta cartaFedelta = repositoryCartaFedelta.findCartaFedeltabyIdCliente(idCliente);
		return cartaFedelta.getCashBack();
	}

	public boolean verificaCashBack(int importoCashBack, int idCliente) {
		CartaFedelta cartaFedelta = repositoryCartaFedelta.findCartaFedeltabyIdCliente(idCliente);
		if(importoCashBack>cartaFedelta.getCashBack()) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean updateCashBack(int contoCorrente,int idCliente,int importoCashBack){
		CartaFedelta cartaFedelta = repositoryCartaFedelta.findCartaFedeltabyIdCliente(idCliente);
		try {
			cartaFedelta.setCashBack(cartaFedelta.getCashBack()-importoCashBack);
			repositoryCartaFedelta.save(cartaFedelta);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
