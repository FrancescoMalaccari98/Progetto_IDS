package project.application.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.application.model.CartaFedelta;
import project.application.model.Premi;
import project.application.repository.RepositoryCartaFedelta;

@Service
public class ServiceCartaFedelta {
	
	@Autowired
	RepositoryCartaFedelta repositoryCartaFedelta;
	
	public CartaFedelta getCartaFedelta(int idCartaFedelta) {
		return repositoryCartaFedelta.findById(idCartaFedelta);
	}
	

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
	

	public boolean updatePunti(int idCliente,int punti){
		CartaFedelta cartaFedelta = repositoryCartaFedelta.findByIdCliente(idCliente);
		try {
			cartaFedelta.setPunti(punti+cartaFedelta.getPunti());
			repositoryCartaFedelta.save(cartaFedelta);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public CartaFedelta getCartaFedeltaByIdCliente(int idCliente) {
		return repositoryCartaFedelta.findByIdCliente(idCliente);
	}

	public List<CartaFedelta> getClassificaCartaFedelta(int idProgramma) {
		return repositoryCartaFedelta.findByIdProgrammaFedelta(idProgramma);
	}
	
	public boolean controlloPunti(Premi premio,int idCliente) {
	CartaFedelta cartaFedelta = repositoryCartaFedelta.findByIdCliente(idCliente);
	if(cartaFedelta.getPunti()>premio.getPuntiRiscatto())
		return true;
	return false;
	}

	public boolean verificaCliente(int idCliente) {
		CartaFedelta cartaFedelta = repositoryCartaFedelta.findByIdCliente(idCliente);
		if(cartaFedelta == null)
			return false;
		return true;
	}

	public CartaFedelta insertCartaVip(int idCliente, String type) {
		CartaFedelta cartaFedelta = new CartaFedelta();
		cartaFedelta.setIdCliente(idCliente);
		//1 indica il programma fedeltà VIP
		cartaFedelta.setIdProgrammaFedelta(1);
		cartaFedelta.setDescrizione("Programma VIP");
		repositoryCartaFedelta.save(cartaFedelta);
		return cartaFedelta;
	}

	public String creazioneCartaFedelta(int idCliente, int idProgramma, String descrizione) {
		CartaFedelta cartaFedelta = new CartaFedelta();
		cartaFedelta.setIdCliente(idCliente);
		cartaFedelta.setIdProgrammaFedelta(idProgramma);
		cartaFedelta.setDescrizione(descrizione);
		repositoryCartaFedelta.save(cartaFedelta);
		return "Carta creata Correttamente";
	}

	public CartaFedelta richiestaDatiCarta(int idCliente) {
		CartaFedelta cartaFedelta = repositoryCartaFedelta.findByIdCliente(idCliente);
		return cartaFedelta;
	}

	public List<Integer> getListaClienti(int idProgramma) {
		List<CartaFedelta> listCartaFedelta =repositoryCartaFedelta.findByIdProgrammaFedelta(idProgramma);
		List<Integer> listIdCliente = new ArrayList<Integer>();
		for(CartaFedelta cartaFedelta : listCartaFedelta) {
			listIdCliente.add(cartaFedelta.getIdCliente());
		}
		return listIdCliente;
	}

	public void aggiornaCartaFedelta(CartaFedelta cartaFedelta) {
		repositoryCartaFedelta.save(cartaFedelta);
	}
}
