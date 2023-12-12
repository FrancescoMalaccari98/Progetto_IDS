package project.application.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.application.model.CartaFedelta;
import project.application.model.ProgrammaFedelta;
import project.application.service.ServiceProgrammaFedelta;

/**
 * Controller for managing loyalty program-related operations.
 */
@RestController
@RequestMapping("/IProgrammaFedelta")
public class ControllerProgrammaFedelta {

    @Autowired
    ServiceProgrammaFedelta serviceProgrammaFedelta;

    @Autowired
    ControllerCartaFedelta controllerCartaFedelta;

    /**
     * Retrieves a list of loyalty programs.
     *
     * @return A list of ProgrammaFedelta objects representing loyalty programs.
     */
    @GetMapping("/getListaProgrammiFedelta")
    public List<ProgrammaFedelta> getListaProgrammiFedelta() {
        List<ProgrammaFedelta> listaProgrammi = serviceProgrammaFedelta.getListaProgrammiFedelta();
        return listaProgrammi;
    }

    /**
     * Selects a loyalty program and retrieves its enrollment form.
     *
     * @param idProgrammaScelto An integer representing the selected loyalty program ID.
     * @return A HashMap containing the enrollment form for the selected loyalty program.
     */
    @PostMapping("/selezioneProgramma")
    public HashMap<String, String> selezioneProgramma(int idProgrammaScelto) {
        return serviceProgrammaFedelta.getModuloAdesione(idProgrammaScelto);
    }

    /**
     * Creates a new loyalty program and retrieves its enrollment form.
     *
     * @return A HashMap containing the enrollment form for the newly created loyalty program.
     */
    @PostMapping("/creazioneProgrammaFedelta")
    public HashMap<String, String> creazioneProgrammaFedelta() {
        return serviceProgrammaFedelta.creazioneProgrammaFedelta();
    }

    /**
     * Inserts basic information for a loyalty program.
     *
     * @param moduloInformazioniBase A HashMap containing basic information for a loyalty program.
     * @return A HashMap containing the updated enrollment form.
     */
    @PostMapping("/inserimentoInformazioniBase")
    public HashMap<String, String> inserimentoInformazioniBase(HashMap<String, String> moduloInformazioniBase) {
        return serviceProgrammaFedelta.inserimentoInformazioniBase(moduloInformazioniBase);
    }

    /**
     * Inserts detailed information for a loyalty program.
     *
     * @param moduloInformazioniDettagliate A HashMap containing detailed information for a loyalty program.
     * @return A string indicating the result of the information insertion process.
     */
    @PostMapping("/inserimentoInformazioniDetagliate")
    public String inserimentoInformazioniDetagliate(HashMap<String, String> moduloInformazioniDettagliate) {
        return serviceProgrammaFedelta.inserimentoInformazioniDetagliate(moduloInformazioniDettagliate);
    }

    /**
     * Retrieves a list of exclusive services for a loyalty program.
     *
     * @param idProgrammaFedelta An integer representing the loyalty program ID.
     * @return A list of strings representing exclusive services.
     */
    @GetMapping("/getListaServiziEsclusivi")
    public List<String> getListaServiziEsclusivi(int idProgrammaFedelta) {
        return serviceProgrammaFedelta.getListaServiziEsclusivi(idProgrammaFedelta);
    }

    /**
     * Processes the purchase of a VIP loyalty card for a customer.
     *
     * @param idCliente An integer representing the customer ID.
     * @return A string indicating the result of the VIP card acquisition process.
     */
    @PostMapping("/acquistoCartaVIP")
    public String acquistoCartaVIP(int idCliente) {
        boolean controlloPagamento = true;
        if (controlloPagamento) {
            CartaFedelta cartaFedelta = controllerCartaFedelta.creazioneCartaFedeltaVIP(idCliente, "VIP");
            return "idCliente" + cartaFedelta.getIdCliente() + "Descrizione: " + cartaFedelta.getDescrizione();
        }
        return "Pagamento Rifiutato";
    }
}
