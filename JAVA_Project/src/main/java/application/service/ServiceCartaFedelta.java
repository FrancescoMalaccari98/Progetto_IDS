package application.service;

import java.util.List;

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
	
	public List<CartaFedelta> getListaCartaFedelta(int idProgramma) {
		return repositoryCartaFedelta.findCartaFedeltabyIdProgramma(idProgramma);
	}
}
