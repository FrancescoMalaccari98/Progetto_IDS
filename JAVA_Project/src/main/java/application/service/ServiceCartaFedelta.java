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
		return repositoryCartaFedelta.findById(idCartaFedelta);
	}
	
	/*
	 * Sets the cashback after a product purchase.
	 */
	public String setCashBack(int idCartaFedelta,int punti) {
		 CartaFedelta cartaCliente = repositoryCartaFedelta.findById(idCartaFedelta);
		 cartaCliente.setPunti(cartaCliente.getPunti()+punti);
		 return "Punti Aggiornati";
	}
	
	public List<CartaFedelta> getListaCartaFedelta(int idProgrammaFedelta) {
		return repositoryCartaFedelta.findByIdProgrammaFedelta(idProgrammaFedelta);
	}
	
	public int getCashBack(int idCliente) {
		CartaFedelta cartaFedelta = repositoryCartaFedelta.findByIdCliente(idCliente);
		return cartaFedelta.getCashBack();
	}

	public boolean verificaCashBack(int importoCashBack, int idCliente) {
		CartaFedelta cartaFedelta = repositoryCartaFedelta.findByIdCliente(idCliente);
		if(importoCashBack>cartaFedelta.getCashBack()) {
			return false;
		} else {
			return true;
		}
	}
	
	/*
	 * Reflects changes in the cashback balance post withdrawal request.
	 */
	public boolean updateCashBack(int contoCorrente,int idCliente,int importoCashBack){
		CartaFedelta cartaFedelta = repositoryCartaFedelta.findByIdCliente(idCliente);
		try {
			cartaFedelta.setCashBack(cartaFedelta.getCashBack()-importoCashBack);
			repositoryCartaFedelta.save(cartaFedelta);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public CartaFedelta getCartaFedeltaByIdCliente(int idCliente) {
		return repositoryCartaFedelta.findByIdCliente(idCliente);
	}
}
