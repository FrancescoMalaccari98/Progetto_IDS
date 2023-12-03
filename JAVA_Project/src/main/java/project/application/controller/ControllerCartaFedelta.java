package project.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.application.model.CartaFedelta;
import project.application.model.Premi;
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
	
	@PostMapping("/updateCashBack")
	public String updateCashBack(int idCliente,int puntiProdotto) {
		 CartaFedelta cartaFedelta =serviceCartaFedelta.getCartaFedeltaByIdCliente(idCliente);
		 ProgrammaFedelta programmaFedelta = serviceProgrammaFedelta.getProgrammaFedelta(cartaFedelta.getIdProgrammaFedelta());
		 if(programmaFedelta.getNomeProgramma().equals("Cliente CashBack"))
			 //aggiungo 10 punti perchè cliente CashBack
			 serviceCartaFedelta.setCashBack(idCliente,puntiProdotto+10);
		 if(programmaFedelta.getNomeProgramma().equals("Cliente Punti"))
			 //aggiungo 20 punti perchè cliente Punti
			 serviceCartaFedelta.setCashBack(idCliente,puntiProdotto+20);
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
		if(serviceCartaFedelta.controlloPunti(premio,idCliente))
			//TODO TODO TODO TODO TODO TODO
			return "";
		return "revocaRiscatto";
	}

	public CartaFedelta creazioneCartaFedeltaVIP(int idCliente, String type) {
		return serviceCartaFedelta.insertCartaVip(idCliente,type);
	}
}
