package project.application.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.application.service.ServicePuntoVendita;

/**
 * Controller for managing point of sale-related operations.
 */
@RestController
@RequestMapping("/IPuntoVendita")
public class ControllerPuntoVendita {

    @Autowired
    ServicePuntoVendita servicePuntoVendita;

    @Autowired
    ControllerCartaFedelta controllerCartaFedelta;

    @Autowired
    ControllerMagazzino controllerMagazzino;

    @Autowired
    ControllerProdotto controllerProdotto;

    @Autowired
    ControllerComunicazionePromozionale controllerComunicazionePromozionale;

    /**
     * Handles the completion of the membership form.
     *
     * @param moduloAdesione A HashMap containing information for the membership form.
     * @return A string indicating the result of the membership form completion process.
     */
    @PostMapping("/compilazioneModuloDiAdesione")
    public String compilazioneModuloDiAdesione(HashMap<String, String> moduloAdesione) {
        int idPuntoVendita = Integer.parseInt(moduloAdesione.get("idPuntoVendita"));
        int idProgramma = Integer.parseInt(moduloAdesione.get("idProgramma"));
        String checkAdesione = servicePuntoVendita.controlloAdesioneEsistente(idPuntoVendita, idProgramma);
        return checkAdesione;
    }

    /**
     * Handles the insertion of additional information for the membership form.
     *
     * @param informazioniAggiuntive A HashMap containing additional information for the membership form.
     * @return A string indicating the result of the additional information insertion process.
     */
    @PostMapping("/inserimentoInformazioniAggiuntive")
    public String inserimentoInformazioniAggiuntive(HashMap<String, String> informazioniAggiuntive) {
        int idPuntoVendita = Integer.parseInt(informazioniAggiuntive.get("idPuntoVendita"));
        int idProgramma = Integer.parseInt(informazioniAggiuntive.get("idProgramma"));
        String checkAdesione = servicePuntoVendita.aggiuntaProgramma(idPuntoVendita, idProgramma);
        return checkAdesione;
    }

    /**
     * Retrieves a list of available rewards for redemption.
     *
     * @param idPuntoVendita An integer representing the point of sale ID.
     * @return A list of reward IDs.
     */
    @GetMapping("/riscattoPremi")
    public List<Integer> riscattoPremi(int idPuntoVendita) {
        List<Integer> listaPremi = servicePuntoVendita.getCatalogoPremi(idPuntoVendita);
        return listaPremi;
    }

    /**
     * Handles the insertion of a review for a point of sale.
     *
     * @param value          An integer representing the review rating.
     * @param descrizione    A string containing the review description.
     * @param idPuntoVendita An integer representing the point of sale ID.
     * @return A string indicating the result of the review insertion process.
     */
    @PostMapping("/inserimentoRecensione")
    public String inserimentoRecensione(int value, String descrizione, int idPuntoVendita) {
        return servicePuntoVendita.inserimentoRecensione(value, descrizione, idPuntoVendita);
    }

    /**
     * Handles the update of the product catalog.
     *
     * @param idPremio        An integer representing the reward ID.
     * @param idPuntoVendita  An integer representing the point of sale ID.
     * @return A string indicating the result of the catalog update process.
     */
    @PostMapping("/updateCatalogo")
    public String updateCatalogo(int idPremio, int idPuntoVendita) {
        return servicePuntoVendita.updateCatalogo(idPremio, idPuntoVendita);
    }

    /**
     * Retrieves a list of point of sale names.
     *
     * @return A list of point of sale names.
     */
    @GetMapping("/getListaPuntiVendita")
    public List<String> getListaPuntiVendita() {
        return servicePuntoVendita.getListaPuntiVendita();
    }

    /**
     * Retrieves a list of loyalty program IDs for a point of sale.
     *
     * @param idPuntoVendita An integer representing the point of sale ID.
     * @return A list of loyalty program IDs.
     */
    @GetMapping("/getListaProgrammiFedelta")
    public List<Integer> getListaProgrammiFedelta(int idPuntoVendita) {
        return servicePuntoVendita.getListaProgrammiFedelta(idPuntoVendita);
    }

    /**
     * Checks the data for loyalty program enrollment and creates a loyalty card for the customer.
     *
     * @param datiIscrizione A HashMap containing data for loyalty program enrollment.
     * @return A string indicating the result of the enrollment process.
     */
    @PostMapping("/controllaDatiIscrizione")
    public String controllaDatiIscrizione(HashMap<String, String> datiIscrizione) {
        if (servicePuntoVendita.checkDatiIstruzione(datiIscrizione)) {
            if (controllerCartaFedelta.creazioneCartaFedelta(
                    Integer.parseInt(datiIscrizione.get("idCliente")),
                    Integer.parseInt(datiIscrizione.get("idProgramma")),
                    datiIscrizione.get("descrizione")).equals("ConfermaCreazione")) {
                return "confermaIscrizione";
            }
        }
        return "Dati errati";
    }

    /**
     * Retrieves a list of customer names for a point of sale.
     *
     * @param idPuntoVendita An integer representing the point of sale ID.
     * @return A list of customer names.
     */
    @GetMapping("/getListaNomiClienti")
    public List<Integer> getListaNomiClienti(int idPuntoVendita) {
        return servicePuntoVendita.getListaNomiClienti(idPuntoVendita);
    }

    /**
     * Retrieves a list of loyalty program names for a point of sale.
     *
     * @param idPuntoVendita An integer representing the point of sale ID.
     * @return A list of loyalty program names.
     */
    @GetMapping("/getListaNomiProgrammiFedelta")
    public List<Integer> getListaNomiProgrammiFedelta(int idPuntoVendita) {
        return servicePuntoVendita.getListaNomiProgrammiFedelta(idPuntoVendita);
    }

    /**
     * Updates the warehouse inventory for a point of sale.
     *
     * @param idPuntoVendita An integer representing the point of sale ID.
     * @return A list of product IDs.
     */
    @PostMapping("/updateMagazzino")
    public List<Integer> updateMagazzino(int idPuntoVendita) {
        return controllerMagazzino.getListaProdotti(idPuntoVendita);
    }

    /**
     * Creates a promotional communication for a point of sale.
     *
     * @param idPuntoVendita An integer representing the point of sale ID.
     * @return A list of loyalty program IDs.
     */
    @PostMapping("/creaCPromozionale")
    public List<Integer> creaCPromozionale(int idPuntoVendita) {
        return servicePuntoVendita.getListaNomiProgrammiFedelta(idPuntoVendita);
    }

    /**
     * Inserts promotional communication for a point of sale.
     *
     * @param idPuntoVendita An integer representing the point of sale ID.
     * @param idProgramma     An integer representing the loyalty program ID.
     * @param info            A string containing additional information about the promotional communication.
     * @return A string indicating the result of the promotional communication insertion process.
     */
    @PostMapping("/inserimentoCPPromozionale")
    public String inserimentoCPPromozionale(int idPuntoVendita, int idProgramma, String info) {
        return controllerComunicazionePromozionale.creaComunicazionePromozionale(idPuntoVendita, info, idProgramma);
    }

    /**
     * Handles the insertion or removal of product quantity for a point of sale.
     *
     * @param quantita         An integer representing the quantity to be inserted or removed.
     * @param idProdotto       An integer representing the product ID.
     * @param tipoOperazione   A string indicating whether it is an insertion or removal operation.
     * @param idPuntovendita   An integer representing the point of sale ID.
     * @return A string indicating the result of the product quantity operation.
     */
    @PostMapping("/inserimentoQuantita")
    public String inserimentoQuantita(int quantita, int idProdotto, String tipoOperazione, int idPuntovendita) {
        if (tipoOperazione.equals("Inserimento")) {
            return controllerMagazzino.addProdotto(quantita, idProdotto, idPuntovendita);
        } else {
            return controllerMagazzino.removeProdotto(quantita, idProdotto, idPuntovendita);
        }
    }
}
