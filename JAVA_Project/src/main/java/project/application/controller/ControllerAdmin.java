package project.application.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for managing administrative operations.
 */
@RestController
@RequestMapping("/IAdmin")
public class ControllerAdmin {

    @Autowired
    ControllerProgrammaFedelta controllerProgrammaFedelta;

    @Autowired
    ControllerSconto controllerSconto;

    /**
     * Handles the creation of a loyalty program by an admin.
     *
     * @param nomeUtente A string representing the username of the admin.
     * @param password   A string representing the password of the admin.
     * @return A HashMap containing information about the created loyalty program.
     */
    @PostMapping("/creazioneProgrammaFedelta")
    public HashMap<String, String> creazioneProgrammaFedelta(String nomeUtente, String password) {
        return controllerProgrammaFedelta.creazioneProgrammaFedelta();
    }

    /**
     * Handles the insertion of basic information for a loyalty program by an admin.
     *
     * @param moduloInformazioniBase A HashMap containing basic information for a loyalty program.
     * @return A HashMap containing information about the inserted basic information.
     */
    @PostMapping("/inserimentoInformazioniBase")
    public HashMap<String, String> inserimentoInformazioniBase(HashMap<String, String> moduloInformazioniBase) {
        return controllerProgrammaFedelta.inserimentoInformazioniBase(moduloInformazioniBase);
    }

    /**
     * Handles the insertion of detailed information for a loyalty program by an admin.
     *
     * @param moduloInfomrmazioniDettagliate A HashMap containing detailed information for a loyalty program.
     * @return A string indicating the result of the detailed information insertion process.
     */
    @PostMapping("/inserimentoInformazioniDettagliate")
    public String inserimentoInformazioniDettagliate(HashMap<String, String> moduloInfomrmazioniDettagliate) {
        return controllerProgrammaFedelta.inserimentoInformazioniDetagliate(moduloInfomrmazioniDettagliate);
    }

    /**
     * Handles the insertion of discount information by an admin.
     *
     * @param infoSconto      A HashMap containing information for the discount.
     * @param idPuntoVendita  An integer representing the point of sale ID.
     * @return A string indicating the result of the discount insertion process.
     */
    @PostMapping("/inserimentoInfoSconto")
    public String inserimentoInfoSconto(HashMap<String, String> infoSconto, int idPuntoVendita) {
        return controllerSconto.inserimentoSconto(infoSconto, idPuntoVendita);
    }

    /**
     * Selects the type of discount (customer or loyalty program) and retrieves a list of applicable entities.
     *
     * @param tipo            A string indicating the type of discount (Cliente for customer, Altro for loyalty program).
     * @param idPuntoVendita  An integer representing the point of sale ID.
     * @return A list of entity IDs applicable for the discount.
     */
    @PostMapping("/selezionaTipo")
    public List<Integer> selezionaTipo(String tipo, int idPuntoVendita) {
        return controllerSconto.selezionaTipo(tipo, idPuntoVendita);
    }

    /**
     * Selects a loyalty program for the discount.
     *
     * @param idProgramma An integer representing the loyalty program ID.
     * @return A string indicating the result of the loyalty program selection process.
     */
    @PostMapping("/selezioneProgramma")
    public String selezioneProgramma(int idProgramma) {
        return controllerSconto.selezioneProgramma(idProgramma);
    }

    /**
     * Selects a customer for the discount.
     *
     * @param idCliente An integer representing the customer ID.
     * @return A string indicating the result of the customer selection process.
     */
    @PostMapping("/selezioneCliente")
    public String selezioneCliente(int idCliente) {
        return controllerSconto.selezioneCliente(idCliente);
    }
}
