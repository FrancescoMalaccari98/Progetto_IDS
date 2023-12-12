package project.application.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.application.model.ComunicazionePromozionale;
import project.application.model.Operatore;
import project.application.service.ServiceOperatore;

/**
 * Controller for managing operator-related operations.
 */
@RestController
@RequestMapping("/IOperatore")
public class ControllerOperatore {

    @Autowired
    ServiceOperatore serviceOperatore;

    @Autowired
    ControllerComunicazionePromozionale controllerComunicazionePromozionale;

    @Autowired
    ControllerCartaFedelta controllerCartaFedelta;

    @Autowired
    ControllerPuntoVendita controllerPuntovendita;

    /**
     * Retrieves a list of employees for a given point of sale.
     *
     * @param idPuntoVendita An integer representing the point of sale ID.
     * @return A list of Operatore objects representing employees.
     */
    @GetMapping("/richiestaListaDipendenti")
    public List<Operatore> richiestaListaDipendenti(int idPuntoVendita) {
        return serviceOperatore.getDipendenteByPuntoVendita(idPuntoVendita);
    }

    /**
     * Sets an operator as an admin.
     *
     * @param idOperatore An integer representing the operator ID.
     * @return A string indicating the result of the role modification process.
     */
    @PostMapping("/setAdmin")
    public String setAdmin(int idOperatore) {
        return serviceOperatore.modifyRuolo(idOperatore);
    }

    /**
     * Sends promotional communication to a point of sale.
     *
     * @param idPuntoVendita An integer representing the point of sale ID.
     * @return A list of ComunicazionePromozionale objects.
     */
    @PostMapping("/inviaCPromozionale")
    public List<ComunicazionePromozionale> inviaCPromozionale(int idPuntoVendita) {
        return controllerComunicazionePromozionale.getListaCPromozionale(idPuntoVendita);
    }

    /**
     * Inserts promotional communication for a loyalty program.
     *
     * @param idCPromozionale An integer representing the promotional communication ID.
     * @param idProgramma     An integer representing the loyalty program ID.
     * @return A list of client IDs.
     */
    @PostMapping("/inseriementoCPromozionale")
    public List<Integer> inseriementoCPromozionale(int idCPromozionale, int idProgramma) {
        return controllerCartaFedelta.getListaClienti(idProgramma);
    }

    /**
     * Requests the creation of a loyalty card for a point of sale.
     *
     * @param idPuntoVendita An integer representing the point of sale ID.
     * @return A list of loyalty program IDs.
     */
    @GetMapping("/richiestaCreazioneCarta")
    public List<Integer> richiestaCreazioneCarta(int idPuntoVendita) {
        return controllerPuntovendita.getListaProgrammiFedelta(idPuntoVendita);
    }

    /**
     * Creates a loyalty card for a customer.
     *
     * @param idCliente   An integer representing the customer ID.
     * @param idProgramma An integer representing the loyalty program ID.
     * @param info        A string containing additional information about the loyalty card.
     * @return A string indicating the result of the loyalty card creation process.
     */
    @PostMapping("/creaCarta")
    public String creaCarta(int idCliente, int idProgramma, String info) {
        return controllerCartaFedelta.creazioneCartaFedelta(idCliente, idProgramma, info);
    }
}
