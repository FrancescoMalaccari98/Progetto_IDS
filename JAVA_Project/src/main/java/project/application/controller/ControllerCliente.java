package project.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import project.application.service.ServiceCliente;
import project.application.model.CartaFedelta;
import project.application.model.Prodotto;
import project.application.model.Sconto;

@RestController
public class ControllerCliente{
	
	@Autowired
	ServiceCliente serviceCliente;
	
	@Autowired
	ControllerProdotto controllerProdotto;
	
	@Autowired
	ControllerSconto controllerSconto;
	
	@Autowired
	ControllerCartaFedelta controllerCartaFedelta;
	
	
	public String inserimentoCredenziali(String nomeUtente,String password) {
		if(serviceCliente.getDati(nomeUtente,password)) {
			return "Autenticato";
		}
		return "Non Autenticato, controllare credenziali";
	}
	
	
	public String acquistoProdotto(List<Prodotto> prodotti,int idPuntoVendita,int idCliente) {
		 int punti = controllerProdotto.registraAcquistoProdotto(prodotti,idPuntoVendita);		
		 controllerCartaFedelta.updateCashBack(idCliente,punti);
		 return "Punti Aggiornati";
	}

	
	public List<CartaFedelta> visualizzaClassifica(int idProgramma) {
		return controllerCartaFedelta.getListaCartaFedelta(idProgramma);
	}

	
	public int richiestaCashback(int idCliente) {
		return controllerCartaFedelta.recuperaSaldoCashbackDisponibile(idCliente);
	}

	
	public String inserisceImporto(int importoCashBack,int idCliente) {
		if(controllerCartaFedelta.verificaDisponibilità(importoCashBack,idCliente)) {
			return "avvioPagamento";
		} else {
			return "Avviso importo non disponibile";
		}
	}

	
	public String inserisceContoCorrente(int contoCorrente, int idCliente,int importoCashBack) {
		if(controllerCartaFedelta.inserisceContoCorrente(contoCorrente,idCliente,importoCashBack))
			return "notificaPagamento";
		return "ErrorePagamento";
	}

	
	public String acquistaProdotto(List<Prodotto> prodotti) {
		float prezzoTotale = controllerProdotto.getPrezzoTotale(prodotti);
		return "Richiedi Sconto, prezzo Totale " + prezzoTotale;
	}

	
	public String rispostaSconto(String rispostaSconto, int prezzoTotale) {
		if(rispostaSconto.toUpperCase().equals("yes"))
			return "richiestaCodiceSconto";
		return "richiestaPagamento";
	}

	
	public String pagamento(String datiPagamento, List<Prodotto> prodotti,int idPuntoVendita) {
		boolean controlloPagamento = true;
		if(controlloPagamento) {
			controllerProdotto.registraAcquistoProdotto(prodotti,idPuntoVendita);
			return "ConfermaAqcuisto";
			}
		return "PagamentoRifiutato";
	}

	
	public String inserimentoSconto(Sconto sconto, int prezzoTotale) {
		if(controllerSconto.controlloSconto(sconto)) {
			float prezzoScontato = controllerSconto.applicaSconto(sconto,prezzoTotale);
			return "Prezzo: "+ prezzoScontato ;
		}
		return "ScontoNonApplicabile";
	}
	

	public List<CartaFedelta> visualizzazioneClassifica(int idProgramma) {
		List<CartaFedelta> classificaClienti = controllerCartaFedelta.getClassificaCartaFedelta(idProgramma);;
		return classificaClienti;
	}
	
}
