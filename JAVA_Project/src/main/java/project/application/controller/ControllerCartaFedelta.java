package project.application.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.application.model.CartaFedelta;
import project.application.model.Premi;
import project.application.model.Prodotto;
import project.application.model.ProgrammaFedelta;
import project.application.service.ServiceCartaFedelta;
import project.application.service.ServiceCliente;
import project.application.service.ServiceProgrammaFedelta;

/**
 * Controller for managing operations related to loyalty cards.
 */
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

    /**
     * Update loyalty program points based on the customer type.
     *
     * @param prodotti       The list of purchased products.
     * @param idPuntoVendita The ID of the sales point.
     * @param idCliente      The customer's ID.
     * @return               A message indicating the outcome of the operation.
     */
    @PostMapping("/updatePuntiProgramma")
    public String updatePuntiProgramma(List<Prodotto> prodotti, int idPuntoVendita, int idCliente) {
        CartaFedelta cartaFedelta = serviceCartaFedelta.getCartaFedeltaByIdCliente(idCliente);
        ProgrammaFedelta programmaFedelta = serviceProgrammaFedelta.getProgrammaFedelta(cartaFedelta.getIdProgrammaFedelta());
        if (programmaFedelta.getNomeProgramma().equals("Cliente CashBack"))
            serviceCartaFedelta.setCashBack(idCliente, 10);
        if (programmaFedelta.getNomeProgramma().equals("Cliente Punti")) {
            serviceCartaFedelta.setCashBack(idCliente, 20);
            controllerCartaFedelta.updatePunti(prodotti, idPuntoVendita, idCliente);
        }
        return "Points updated";
    }

    /**
     * Get the list of loyalty cards associated with a specific program.
     *
     * @param idProgramma The ID of the loyalty program.
     * @return            The list of loyalty cards.
     */
    @GetMapping("/getListaCartaFedelta")
    public List<CartaFedelta> getListaCartaFedelta(int idProgramma) {
        return serviceCartaFedelta.getListaCartaFedelta(idProgramma);
    }

    /**
     * Check the availability of cashback for a customer.
     *
     * @param importoCashBack The cashback amount to check.
     * @param idCliente       The customer's ID.
     * @return                True if cashback is available, false otherwise.
     */
    @PostMapping("/verificaDisponibilità")
    public boolean verificaDisponibilità(int importoCashBack, int idCliente) {
        return serviceCartaFedelta.verificaCashBack(importoCashBack, idCliente);
    }

    /**
     * Insert the current account for a customer.
     *
     * @param contoCorrente   The current account to insert.
     * @param idCliente       The customer's ID.
     * @param importoCashBack The cashback amount to associate with the current account.
     * @return                True if the operation was successful, false otherwise.
     */
    @PostMapping("/inserisceContoCorrente")
    public boolean inserisceContoCorrente(int contoCorrente, int idCliente, int importoCashBack) {
        return serviceCartaFedelta.updateCashBack(contoCorrente, idCliente, importoCashBack);
    }

    /**
     * Retrieve the available cashback balance for a customer.
     *
     * @param idCliente The customer's ID.
     * @return          The available cashback balance.
     */
    @PostMapping("/recuperaSaldoCashbackDisponibile")
    public int recuperaSaldoCashbackDisponibile(int idCliente) {
        return serviceCartaFedelta.getCashBack(idCliente);
    }

    /**
     * Get the ranking of loyalty cards for a specific program.
     *
     * @param idProgramma The ID of the loyalty program.
     * @return            The ranking of loyalty cards.
     */
    @GetMapping("/getClassificaCartaFedelta")
    public List<CartaFedelta> getClassificaCartaFedelta(int idProgramma) {
        return serviceCartaFedelta.getClassificaCartaFedelta(idProgramma);
    }

    /**
     * Check the existence of a customer.
     *
     * @param idCliente The customer's ID.
     * @return          True if the customer exists, false otherwise.
     */
    @PostMapping("/verificaCliente")
    public boolean verificaCliente(int idCliente) {
        return serviceCartaFedelta.verificaCliente(idCliente);
    }

    /**
     * Selection of a reward for a customer.
     *
     * @param premio    The selected reward.
     * @param idCliente The customer's ID.
     * @return          A message indicating the outcome of the selection.
     */
    @PostMapping("/selezionePremio")
    public String selezionePremio(Premi premio, int idCliente) {
        if (serviceCartaFedelta.controlloPunti(premio, idCliente)) {
            controllerPuntoVendita.updateCatalogo(idCliente, idCliente);
            return "RedemptionConfirmed";
        }
        return "RedemptionRevoked";
    }

    /**
     * Creation of a VIP loyalty card for a customer.
     *
     * @param idCliente The customer's ID.
     * @param type      The type of VIP loyalty card.
     * @return          The created VIP loyalty card.
     */
    @PostMapping("/creazioneCartaFedeltaVIP")
    public CartaFedelta creazioneCartaFedeltaVIP(int idCliente, String type) {
        return serviceCartaFedelta.insertCartaVip(idCliente, type);
    }

    /**
     * Creation of a loyalty card for a customer.
     *
     * @param idCliente        The customer's ID.
     * @param idProgramma      The ID of the loyalty program.
     * @param idPuntoVendita   The ID of the sales point.
     * @return                 A message indicating the outcome of the operation.
     */
    @PostMapping("/creazioneCartaFedelta")
    public String creazioneCartaFedelta(int idCliente, int idProgramma, String idPuntoVendita) {
        return serviceCartaFedelta.creazioneCartaFedelta(idCliente, idProgramma, idPuntoVendita);
    }

    /**
     * Get data from a loyalty card for a customer.
     *
     * @param idCliente The customer's ID.
     * @return          The loyalty card data.
     */
    @GetMapping("/richiestaDatiCarta")
    public CartaFedelta richiestaDatiCarta(int idCliente) {
        return serviceCartaFedelta.richiestaDatiCarta(idCliente);
    }

    /**
     * Get the list of customers for a specific program.
     *
     * @param idProgramma The ID of the loyalty program.
     * @return            The list of customer IDs.
     */
    @GetMapping("/getListaClienti")
    public List<Integer> getListaClienti(int idProgramma) {
        List<Integer> listIdCliente = serviceCartaFedelta.getListaClienti(idProgramma);
        /*
         * Send data to an external WebService for forwarding emails/sms
         */
        return listIdCliente;
    }

    /**
     * Update points for a customer based on purchased products and loyalty program.
     *
     * @param listaProdotti     The list of purchased products.
     * @param idProgrammaFedelta The ID of the loyalty program.
     * @param idCliente          The customer's ID.
     * @return                   A message indicating the outcome of the operation.
     */
    @PostMapping("/updatePunti")
    public String updatePunti(List<Prodotto> listaProdotti, int idProgrammaFedelta, int idCliente) {
        ProgrammaFedelta programmaFedelta = serviceProgrammaFedelta.getProgrammaFedelta(idProgrammaFedelta);
        String informazioniBase = programmaFedelta.getInformazioniBase();
        String[] informazioni = informazioniBase.split(",");
        CartaFedelta cartaFedelta = serviceCartaFedelta.getCartaFedeltaByIdCliente(idCliente);
        if (cartaFedelta.getPunti() > Integer.parseInt(informazioni[0])) {
            cartaFedelta.setLivello(cartaFedelta.getLivello() + 1);
            serviceCartaFedelta.aggiornaCartaFedelta(cartaFedelta);
            return "Level Unlocked";
        } else if (cartaFedelta.getPunti() > Integer.parseInt(informazioni[1])) {
            cartaFedelta.setLivello(cartaFedelta.getLivello() + 1);
            serviceCartaFedelta.aggiornaCartaFedelta(cartaFedelta);
            return "Level Unlocked";
        } else {
            return "Points: " + cartaFedelta.getPunti() + ", Level Points: " + informazioni[0] + ", " + informazioni[1];
        }
    }
}
