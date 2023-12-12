package project.application.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.application.model.Sconto;
import project.application.service.ServiceSconto;

/**
 * Controller for managing discount-related operations.
 */
@RestController
@RequestMapping("/ISconto")
public class ControllerSconto {

    @Autowired
    ServiceSconto serviceSconto;

    @Autowired
    ControllerPuntoVendita controllerPuntoVendita;

    /**
     * Handles the insertion of a discount.
     *
     * @param infoSconto     A HashMap containing information for the discount.
     * @param idPuntoVendita An integer representing the point of sale ID.
     * @return A string indicating the result of the discount insertion process.
     */
    @PostMapping("/inserimentoSconto")
    public String inserimentoSconto(HashMap<String, String> infoSconto, int idPuntoVendita) {
        serviceSconto.inserimentoSconto(infoSconto, idPuntoVendita);
        return "ConfermaCreazione";
    }

    /**
     * Checks the validity of a discount.
     *
     * @param sconto A Sconto object representing the discount.
     * @return A boolean indicating whether the discount is valid.
     */
    @PostMapping("/controlloSconto")
    public boolean controlloSconto(Sconto sconto) {
        return serviceSconto.controllaSconto(sconto);
    }

    /**
     * Applies a discount to the total price.
     *
     * @param sconto        A Sconto object representing the discount.
     * @param prezzoTotale  An integer representing the total price.
     * @return A float representing the discounted total price.
     */
    @PostMapping("/applicaSconto")
    public float applicaSconto(Sconto sconto, float prezzoTotale) {
        return serviceSconto.applicaSconto(sconto, prezzoTotale);
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
        if (tipo.equals("Cliente"))
            return controllerPuntoVendita.getListaNomiClienti(idPuntoVendita);
        else
            return controllerPuntoVendita.getListaNomiProgrammiFedelta(idPuntoVendita);
    }

    /**
     * Selects a loyalty program for the discount.
     *
     * @param idProgramma An integer representing the loyalty program ID.
     * @return A string indicating the result of the loyalty program selection process.
     */
    @GetMapping("/selezioneProgramma")
    public String selezioneProgramma(int idProgramma) {
        return serviceSconto.inserimentoScontoProgramma(idProgramma);
    }

    /**
     * Selects a customer for the discount.
     *
     * @param idCliente An integer representing the customer ID.
     * @return A string indicating the result of the customer selection process.
     */
    @PostMapping("/selezioneCliente")
    public String selezioneCliente(int idCliente) {
        return serviceSconto.inserimentoScontoCliente(idCliente);
    }
}
