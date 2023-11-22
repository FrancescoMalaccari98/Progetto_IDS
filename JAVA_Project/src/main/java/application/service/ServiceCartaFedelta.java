package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.CartaFedelta;
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
}
