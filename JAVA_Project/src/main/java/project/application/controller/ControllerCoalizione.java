package project.application.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.application.service.ServiceCoalizione;

/**
 * Controller for managing coalitions.
 */
@RestController
@RequestMapping("/ICoalizione")
public class ControllerCoalizione {

    @Autowired
    ServiceCoalizione serviceCoalizione;

    /**
     * Handles the insertion of coalition information.
     *
     * @param informazioni A HashMap containing information for the coalition.
     * @return A string indicating whether the coalition already exists or was successfully created.
     */
    @PostMapping("/inserimentoInformazioni")
    public String inserimentoInformazioni(HashMap<String, String> informazioni) {
        boolean checkCoalizione = serviceCoalizione.controlloCoalizione(informazioni);
        if (checkCoalizione) {
            return "Coalizione già esistente"; // Coalition already exists
        } else {
            return "Coalizione creata"; // Coalition created
        }
    }

    /**
     * Handles forwarding a request for coalition membership.
     *
     * @param listaIdPuntiVendita A list of integers representing point of sale IDs.
     * @param idCoalizione        An integer representing the coalition ID.
     * @return A string indicating the result of the coalition creation process.
     */
    @PostMapping("/inoltroRichiestaAdesioneCoalizione")
    public String inoltroRichiestaAdesioneCoalizione(List<Integer> listaIdPuntiVendita, int idCoalizione) {
        return serviceCoalizione.creaCoalizione(listaIdPuntiVendita, idCoalizione);
    }
}
