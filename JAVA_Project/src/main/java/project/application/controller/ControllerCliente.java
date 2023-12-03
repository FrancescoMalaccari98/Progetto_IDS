package project.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.application.service.ServiceCliente;
import project.application.model.CartaFedelta;
import project.application.model.Premi;
import project.application.model.Prodotto;
import project.application.model.Sconto;

@RestController
@RequestMapping("/ICliente")
public class ControllerCliente{
	
	@Autowired
	ServiceCliente serviceCliente;
	
	@Autowired
	ControllerProdotto controllerProdotto;
	
	@Autowired
	ControllerSconto controllerSconto;
	
	@Autowired
	ControllerProgrammaFedelta controllerProgrammaFedelta;
	
	@Autowired
	ControllerCartaFedelta controllerCartaFedelta;
	
	@Autowired
	ControllerPuntoVendita controllerPuntoVendita;
	
	@PostMapping("/inserimentoCredenziali")
	public String inserimentoCredenziali(String nomeUtente,String password) {
		if(serviceCliente.getDati(nomeUtente,password)) {
			return "Autenticato";
		}
		return "Non Autenticato, controllare credenziali";
	}
	
	@PostMapping("/acquistoProdotto")
	public String acquistoProdotto(List<Prodotto> prodotti,int idPuntoVendita,int idCliente) {
		 int punti = controllerProdotto.registraAcquistoProdotto(prodotti,idPuntoVendita);		
		 controllerCartaFedelta.updateCashBack(idCliente,punti);
		 return "Punti Aggiornati";
	}

	@PostMapping("/visualizzaClassifica")
	public List<CartaFedelta> visualizzaClassifica(int idProgramma) {
		return controllerCartaFedelta.getListaCartaFedelta(idProgramma);
	}

	@PostMapping("/richiestaCashback")
	public int richiestaCashback(int idCliente) {
		return controllerCartaFedelta.recuperaSaldoCashbackDisponibile(idCliente);
	}

	@PostMapping("/inserisceImporto")
	public String inserisceImporto(int importoCashBack,int idCliente) {
		if(controllerCartaFedelta.verificaDisponibilità(importoCashBack,idCliente)) {
			return "avvioPagamento";
		} else {
			return "Avviso importo non disponibile";
		}
	}

	@PostMapping("/inserisceContoCorrente")
	public String inserisceContoCorrente(int contoCorrente, int idCliente,int importoCashBack) {
		if(controllerCartaFedelta.inserisceContoCorrente(contoCorrente,idCliente,importoCashBack))
			return "notificaPagamento";
		return "ErrorePagamento";
	}

	@PostMapping("/acquistaProdotto")
	public String acquistaProdotto(List<Prodotto> prodotti) {
		float prezzoTotale = controllerProdotto.getPrezzoTotale(prodotti);
		return "Richiedi Sconto, prezzo Totale " + prezzoTotale;
	}

	@PostMapping("/rispostaSconto")
	public String rispostaSconto(String rispostaSconto, int prezzoTotale) {
		if(rispostaSconto.toUpperCase().equals("yes"))
			return "richiestaCodiceSconto";
	  	return "richiestaPagamento";
		
	}

	@PostMapping("/pagamento")
	public String pagamento(String datiPagamento, List<Prodotto> prodotti,int idPuntoVendita) {
		boolean controlloPagamento = true;
		if(controlloPagamento) {
			controllerProdotto.registraAcquistoProdotto(prodotti,idPuntoVendita);
			return "ConfermaAqcuisto";
			}
		return "PagamentoRifiutato";
	}

	@PostMapping("/inserimentoSconto")
	public String inserimentoSconto(Sconto sconto, int prezzoTotale) {
		if(controllerSconto.controlloSconto(sconto)) {
			float prezzoScontato = controllerSconto.applicaSconto(sconto,prezzoTotale);
			return "Prezzo: "+ prezzoScontato ;
		}
		return "ScontoNonApplicabile";
	}
	
	@PostMapping("/visualizzazioneClassifica")
	public List<CartaFedelta> visualizzazioneClassifica(int idProgramma) {
		List<CartaFedelta> classificaClienti = controllerCartaFedelta.getClassificaCartaFedelta(idProgramma);;
		return classificaClienti;
	}
	
	@PostMapping("/riscattoPremi")
	public List<Integer> riscattoPremi(int idPuntoVendita) {
		List<Integer> listaPremi = controllerPuntoVendita.riscattoPremi(idPuntoVendita);;
		return listaPremi;
	}

	@PostMapping("/selezionePremio")
	public String selezionePremio(Premi premio,int idCliente) {
		String listaPremi = controllerCartaFedelta.selezionePremio(premio,idCliente);;
		return listaPremi;
	}
	
	@PostMapping("/accessoServiziEsclusivi")
	public List<String>accessoServiziEsclusivi(int idCliente) {
		List<String> listaServizi  = new ArrayList<>();
		if(controllerCartaFedelta.verificaCliente(idCliente)) {
			//listaServizi = controllerProgrammaFedelta.getListaServiziEsclusivi();
			//TODO TODO TODO TODO TODO TODO
			return listaServizi;
		}
		listaServizi.set(0, "AccessoNegato");
		return listaServizi;
	}
	
	@PostMapping("/inserimentoCampiRecensione")
	public String inserimentoCampiRecensione(int value,String descrizione, int idPuntoVendita) {
		return controllerPuntoVendita.inserimentoRecensione(value,descrizione,idPuntoVendita);
	}
	
	@PostMapping("/acquistoCartaVIP")
	public String acquistoCartaVIP(int idCliente){
		return controllerProgrammaFedelta.acquistoCartaVIP(idCliente);
	}
}
	