package project.application.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.application.service.ServiceCliente;
import project.application.model.CartaFedelta;
import project.application.model.Premi;
import project.application.model.Prodotto;
import project.application.model.Sconto;

/**
 * Controller for managing operations related to clients.
 */
@RestController
@RequestMapping("/ICliente")
public class ControllerCliente {

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

    /**
     * Handles the insertion of credentials for client authentication.
     *
     * @param nomeUtente A string representing the client's username.
     * @param password   A string representing the client's password.
     * @return A string indicating the result of authentication.
     */
    @PostMapping("/inserimentoCredenziali")
    public String inserimentoCredenziali(String nomeUtente, String password) {
        if (serviceCliente.getDati(nomeUtente, password)) {
            return "Autenticato";
        }
        return "Non Autenticato, controllare credenziali";
    }

    /**
     * Handles the purchase of products by a client, updating loyalty program points.
     *
     * @param prodotti        A list of products to be purchased.
     * @param idPuntoVendita  An integer representing the point of sale ID.
     * @param idCliente       An integer representing the client ID.
     * @return A string indicating the result of the purchase.
     */
    @PostMapping("/acquistoProdotto")
    public String acquistoProdotto(List<Prodotto> prodotti, int idPuntoVendita, int idCliente) {
        controllerCartaFedelta.updatePuntiProgramma(prodotti, idPuntoVendita, idCliente);
        return "Punti Aggiornati";
    }

    /**
     * Handles the purchase of products by a client, requesting the use of discounts.
     *
     * @param prodotti A list of products to be purchased.
     * @return A string requesting the use of discounts and displaying the total price.
     */
    @PostMapping("/acquistaProdotto")
    public String acquistaProdotto(List<Prodotto> prodotti) {
        float prezzoTotale = controllerProdotto.getPrezzoTotale(prodotti);
        return "Richiedi utilizzo sconto, prezzo Totale " + prezzoTotale;
    }

    /**
     * Retrieves the available cashback balance for a client.
     *
     * @param idCliente An integer representing the client ID.
     * @return An integer representing the available cashback balance.
     */
    @GetMapping("/richiestaCashback")
    public int richiestaCashback(int idCliente) {
        return controllerCartaFedelta.recuperaSaldoCashbackDisponibile(idCliente);
    }

    /**
     * Handles the insertion of cashback amount by a client.
     *
     * @param importoCashBack An integer representing the cashback amount.
     * @param idCliente       An integer representing the client ID.
     * @return A string indicating the result of the cashback insertion.
     */
    @PostMapping("/inserisceImporto")
    public String inserisceImporto(int importoCashBack, int idCliente) {
        if (controllerCartaFedelta.verificaDisponibilità(importoCashBack, idCliente)) {
            return "avvioPagamento";
        } else {
            return "Avviso importo non disponibile";
        }
    }

    /**
     * Handles the insertion of bank account information by a client for payment.
     *
     * @param contoCorrente   An integer representing the bank account.
     * @param idCliente       An integer representing the client ID.
     * @param importoCashBack An integer representing the cashback amount.
     * @return A string indicating the result of the payment.
     */
    @PostMapping("/inserisceContoCorrente")
    public String inserisceContoCorrente(int contoCorrente, int idCliente, int importoCashBack) {
        if (controllerCartaFedelta.inserisceContoCorrente(contoCorrente, idCliente, importoCashBack))
            return "notificaPagamento";
        return "ErrorePagamento";
    }

    /**
     * Handles the client's response regarding the use of discounts.
     *
     * @param rispostaSconto A string representing the client's response.
     * @param prezzoTotale   A float representing the total price.
     * @return A string indicating the next step based on the client's response.
     */
    @PostMapping("/rispostaSconto")
    public String rispostaSconto(String rispostaSconto, float prezzoTotale) {
        if (rispostaSconto.toUpperCase().equals("yes"))
            return "richiestaCodiceSconto";
        return "richiestaPagamento";
    }

    /**
     * Handles the payment process.
     *
     * @param datiPagamento A string representing payment information.
     * @param prodotti      A list of products to be purchased.
     * @param idPuntoVendita An integer representing the point of sale ID.
     * @param quantita       An integer representing the quantity of products.
     * @return A string indicating the result of the payment.
     */
    @PostMapping("/pagamento")
    public String pagamento(String datiPagamento, List<Prodotto> prodotti, int idPuntoVendita, int quantita) {
        boolean controlloPagamento = true;
        if (controlloPagamento) {
            controllerProdotto.updateProdotto(prodotti, idPuntoVendita, quantita);
            return "ConfermaAqcuisto";
        }
        return "PagamentoRifiutato";
    }

    /**
     * Handles the insertion of a discount by a client.
     *
     * @param sconto      A Sconto object representing the discount information.
     * @param prezzoTotale A float representing the total price.
     * @return A string indicating the result of the discount insertion.
     */
    @PostMapping("/inserimentoSconto")
    public String inserimentoSconto(Sconto sconto, float prezzoTotale) {
        if (controllerSconto.controlloSconto(sconto)) {
            float prezzoScontato = controllerSconto.applicaSconto(sconto, prezzoTotale);
            return "Prezzo: " + prezzoScontato;
        }
        return "ScontoNonApplicabile";
    }

    /**
     * Retrieves the leaderboard of loyalty program members for a specific program.
     *
     * @param idProgramma An integer representing the loyalty program ID.
     * @return A list of CartaFedelta objects representing the leaderboard.
     */
    @GetMapping("/visualizzazioneClassifica")
    public List<CartaFedelta> visualizzazioneClassifica(int idProgramma) {
        List<CartaFedelta> classificaClienti = controllerCartaFedelta.getClassificaCartaFedelta(idProgramma);
        return classificaClienti;
    }

    /**
     * Retrieves a list of available rewards for a specific point of sale.
     *
     * @param idPuntoVendita An integer representing the point of sale ID.
     * @return A list of integers representing available rewards.
     */
    @PostMapping("/riscattoPremi")
    public List<Integer> riscattoPremi(int idPuntoVendita) {
        List<Integer> listaPremi = controllerPuntoVendita.riscattoPremi(idPuntoVendita);
        return listaPremi;
    }

    /**
     * Handles the selection of a reward by a client.
     *
     * @param premio     A Premi object representing the selected reward.
     * @param idCliente  An integer representing the client ID.
     * @return A string indicating the result of the reward selection.
     */
    @PostMapping("/selezionePremio")
    public String selezionePremio(Premi premio, int idCliente) {
        String listaPremi = controllerCartaFedelta.selezionePremio(premio, idCliente);
        return listaPremi;
    }

    /**
     * Retrieves a list of exclusive services for a client within a loyalty program.
     *
     * @param idCliente           An integer representing the client ID.
     * @param idProgrammaFedelta  An integer representing the loyalty program ID.
     * @return A list of strings representing available exclusive services.
     */
    @GetMapping("/accessoServiziEsclusivi")
    public List<String> accessoServiziEsclusivi(int idCliente, int idProgrammaFedelta) {
        List<String> listaServizi = new ArrayList<>();
        if (controllerCartaFedelta.verificaCliente(idCliente)) {
            listaServizi = controllerProgrammaFedelta.getListaServiziEsclusivi(idProgrammaFedelta);
            return listaServizi;
        }
        listaServizi.add("AccessoNegato");
        return listaServizi;
    }

    /**
     * Handles the insertion of review information by a client.
     *
     * @param value            An integer representing the review rating.
     * @param descrizione      A string representing the review description.
     * @param idPuntoVendita   An integer representing the point of sale ID.
     * @return A string indicating the result of the review insertion.
     */
    @PostMapping("/inserimentoCampiRecensione")
    public String inserimentoCampiRecensione(int value, String descrizione, int idPuntoVendita) {
        return controllerPuntoVendita.inserimentoRecensione(value, descrizione, idPuntoVendita);
    }

    /**
     * Handles the VIP card purchase by a client.
     *
     * @param idCliente An integer representing the client ID.
     * @return A string indicating the result of the VIP card purchase.
     */
    @PostMapping("/acquistoCartaVIP")
    public String acquistoCartaVIP(int idCliente) {
        return controllerProgrammaFedelta.acquistoCartaVIP(idCliente);
    }

    /**
     * Handles the loyalty program subscription process by a client.
     *
     * @return A list of strings representing available points of sale.
     */
    @PostMapping("/iscrizioneProgrammaFedelta")
    public List<String> iscrizioneProgrammaFedelta() {
        return controllerPuntoVendita.getListaPuntiVendita();
    }

    /**
     * Handles the selection of a point of sale by a client during the loyalty program subscription process.
     *
     * @param idPuntoVendita An integer representing the selected point of sale ID.
     * @return A list of integers representing available loyalty programs at the selected point of sale.
     */
    @PostMapping("/selezionePuntoVendita")
    public List<Integer> selezionePuntoVendita(int idPuntoVendita) {
        return controllerPuntoVendita.getListaProgrammiFedelta(idPuntoVendita);
    }

    /**
     * Handles the selection of a loyalty program during the loyalty program subscription process by a client.
     *
     * @param datiIscrizione A HashMap containing information for the loyalty program subscription.
     * @return A string indicating the result of the loyalty program subscription process.
     */
    @PostMapping("/selezioneProgramma")
    public String selezioneProgramma(HashMap<String, String> datiIscrizione) {
        return controllerPuntoVendita.controllaDatiIscrizione(datiIscrizione);
    }
}
