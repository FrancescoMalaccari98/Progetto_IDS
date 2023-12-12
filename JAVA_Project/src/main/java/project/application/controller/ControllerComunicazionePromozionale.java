package project.application.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import project.application.model.ComunicazionePromozionale;
import project.application.service.ServiceComunicazionePromozionale;

/**
 * Controller for managing promotional communications.
 */
@RestController
public class ControllerComunicazionePromozionale {

    @Autowired
    ServiceComunicazionePromozionale serviceComunicazonePromozionale;

    /**
     * Retrieves a list of promotional communications for a given point of sale.
     *
     * @param idPuntoVendita An integer representing the point of sale ID.
     * @return A list of ComunicazionePromozionale objects.
     */
    @GetMapping("/getListaCPromozionale")
    public List<ComunicazionePromozionale> getListaCPromozionale(int idPuntoVendita) {
        return serviceComunicazonePromozionale.getListaCPromozionale(idPuntoVendita);
    }

    /**
     * Creates a new promotional communication.
     *
     * @param idProgrammaFedelta An integer representing the loyalty program ID.
     * @param info               A string containing information about the promotional communication.
     * @param idPuntoVendita     An integer representing the point of sale ID.
     * @return A string indicating the result of the promotional communication creation process.
     */
    @PostMapping("/creaComunicazionePromozionale")
    public String creaComunicazionePromozionale(int idProgrammaFedelta, String info, int idPuntoVendita) {
        return serviceComunicazonePromozionale.inserimentoCPromozionale(idProgrammaFedelta, info, idPuntoVendita);
    }
}
