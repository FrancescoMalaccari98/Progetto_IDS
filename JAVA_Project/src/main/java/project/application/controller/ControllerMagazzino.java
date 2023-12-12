package project.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import project.application.service.ServiceMagazzino;

/**
 * Controller for managing warehouse-related operations.
 */
@RestController
public class ControllerMagazzino {

    @Autowired
    ServiceMagazzino serviceMagazzino;

    /**
     * Retrieves a list of product IDs available in the warehouse for a given point of sale.
     *
     * @param idPuntoVendita An integer representing the point of sale ID.
     * @return A list of product IDs.
     */
    @GetMapping("/getListaProdotti")
    public List<Integer> getListaProdotti(int idPuntoVendita) {
        return serviceMagazzino.getListaProdotti(idPuntoVendita);
    }

    /**
     * Adds a specified quantity of a product to the warehouse inventory.
     *
     * @param quantita       An integer representing the quantity of the product to be added.
     * @param idProdotto     An integer representing the product ID.
     * @param idPuntoVendita An integer representing the point of sale ID.
     * @return A string indicating the result of the product addition process.
     */
    @PostMapping("/addProdotto")
    public String addProdotto(int quantita, int idProdotto, int idPuntoVendita) {
        return serviceMagazzino.addProdotto(quantita, idProdotto, idPuntoVendita);
    }

    /**
     * Removes a specified quantity of a product from the warehouse inventory.
     *
     * @param quantita       An integer representing the quantity of the product to be removed.
     * @param idProdotto     An integer representing the product ID.
     * @param idPuntoVendita An integer representing the point of sale ID.
     * @return A string indicating the result of the product removal process.
     */
    @PostMapping("/removeProdotto")
    public String removeProdotto(int quantita, int idProdotto, int idPuntoVendita) {
        return serviceMagazzino.removeProdotto(quantita, idProdotto, idPuntoVendita);
    }

}
