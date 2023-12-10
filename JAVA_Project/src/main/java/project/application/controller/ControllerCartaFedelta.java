package project.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.application.model.CartaFedelta;
import project.application.model.Cliente;
import project.application.model.Premi;
import project.application.model.Prodotto;
import project.application.model.ProgrammaFedelta;
import project.application.service.ServiceCartaFedelta;
import project.application.service.ServiceCliente;
import project.application.service.ServiceProgrammaFedelta;

@RestController
@RequestMapping("/ICartaFedelta")
public class ControllerCartaFedelta {
	
	@Autowired
	ServiceCartaFedelta serviceCartaFedelta;
	
	@Autowired
	ServiceCliente serviceCliente;
	
	@Autowired
	ServiceProgrammaFedelta serviceProgrammaFedelta;
	
	@Autowired
	ControllerPuntoVendita controllerPuntoVendita;
	
	@Autowired
	ControllerCliente controllerCliente;
	
	@Autowired
	ControllerCartaFedelta controllerCartaFedelta;
	
	@PostMapping("/updatePuntiProgramma")
	public String updatePuntiProgramma(List<Prodotto> prodotti,int idPuntoVendita,int idCliente) {
		 CartaFedelta cartaFedelta =serviceCartaFedelta.getCartaFedeltaByIdCliente(idCliente);
		 ProgrammaFedelta programmaFedelta = serviceProgrammaFedelta.getProgrammaFedelta(cartaFedelta.getIdProgrammaFedelta());
		 if(programmaFedelta.getNomeProgramma().equals("Cliente CashBack"))
			 //aggiungo 10 punti perchè cliente CashBack
			 serviceCartaFedelta.setCashBack(idCliente,10);
		 if(programmaFedelta.getNomeProgramma().equals("Cliente Punti"))
			 //aggiungo 20 punti perchè cliente Punti
			 serviceCartaFedelta.setCashBack(idCliente,20);
		 if(programmaFedelta.getNomeProgramma().equals("Cliente Punti"))
			 controllerCartaFedelta.updatePunti(prodotti, idPuntoVendita, idCliente);
		return "Punti aggiornati";
	}
	
	@PostMapping("/getListaCartaFedelta")
	public List<CartaFedelta> getListaCartaFedelta(int idProgramma){
		return serviceCartaFedelta.getListaCartaFedelta(idProgramma);
	}
	
	@PostMapping("/verificaDisponibilità")
	public boolean verificaDisponibilità(int importoCashBack, int idCliente) {
		return serviceCartaFedelta.verificaCashBack(importoCashBack, idCliente);
	}
	
	@PostMapping("/inserisceContoCorrente")
	public boolean inserisceContoCorrente(int contoCorrente, int idCliente, int importoCashBack) {
		return serviceCartaFedelta.updateCashBack(contoCorrente, idCliente, importoCashBack);
	}

	@PostMapping("/recuperaSaldoCashbackDisponibile")
	public int recuperaSaldoCashbackDisponibile(int idCliente) {
		return serviceCartaFedelta.getCashBack(idCliente);
	}
	
	@PostMapping("/getClassificaCartaFedelta")
	public List<CartaFedelta> getClassificaCartaFedelta(int idProgramma) {
		return serviceCartaFedelta.getClassificaCartaFedelta(idProgramma);
	}
	
	@PostMapping("/verificaCliente")
	public boolean verificaCliente(int idCliente) {
		return serviceCartaFedelta.verificaCliente(idCliente);
	}
	
	@PostMapping("/selezionePremio")
	public String selezionePremio(Premi premio,int idCliente) {
		if(serviceCartaFedelta.controlloPunti(premio,idCliente)) {
			controllerPuntoVendita.updateCatalogo(idCliente, idCliente);
			return "ConfermaRiscatto";
		}
		return "revocaRiscatto";
	}

	@PostMapping("/creazioneCartaFedeltaVIP")
	public CartaFedelta creazioneCartaFedeltaVIP(int idCliente, String type) {
		return serviceCartaFedelta.insertCartaVip(idCliente,type);
	}

	@PostMapping("/creazioneCartaFedelta")
	public String creazioneCartaFedelta(int idCliente,int idProgramma,String idPuntoVendita) {
		return serviceCartaFedelta.creazioneCartaFedelta(idCliente, idProgramma, idPuntoVendita);
	}

	@PostMapping("/richiestaDatiCarta")
	public CartaFedelta richiestaDatiCarta(int idCliente) {
		return serviceCartaFedelta.richiestaDatiCarta(idCliente);
	}

	@PostMapping("/getListaClienti")
	public List<Integer> getListaClienti(int idProgramma) {
		List<Integer> listIdCliente= serviceCartaFedelta.getListaClienti(idProgramma);
		/*
		 * Invio dati ad un WebService esterno per l'inoltro delle mail/sms 
		 */
		return listIdCliente;
	}
	
	@PostMapping("/updatePunti")
	public String updatePunti(List<Prodotto> listaProdotti,int idProgrammaFedelta,int idCliente){
		ProgrammaFedelta programmaFedelta = serviceProgrammaFedelta.getProgrammaFedelta(idProgrammaFedelta);
		String informazioniBase = programmaFedelta.getInformazioniBase();
		String[] informazioni = informazioniBase.split(",");
		CartaFedelta cartaFedelta = serviceCartaFedelta.getCartaFedeltaByIdCliente(idCliente);
		if(cartaFedelta.getPunti()>Integer.parseInt(informazioni[0])) {
			cartaFedelta.setLivello(cartaFedelta.getLivello()+1);
			serviceCartaFedelta.aggiornaCartaFedelta(cartaFedelta);
			return "Livello Sbloccato";
		} else if (cartaFedelta.getPunti()>Integer.parseInt(informazioni[1])) {
			cartaFedelta.setLivello(cartaFedelta.getLivello()+1);
			serviceCartaFedelta.aggiornaCartaFedelta(cartaFedelta);
			return "Livello Sbloccato";
		} else {
			return "Punti: "+ cartaFedelta.getPunti() +", Punti livelli: "+informazioni[0]+", "+informazioni[1];
		}
	}
}
