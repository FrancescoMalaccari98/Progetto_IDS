package project.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.application.model.Prodotto;
import project.application.service.ServiceProdotto;

/**
 * Controller for managing product-related operations.
 */
@RestController
@RequestMapping("/IProdotto")
public class ControllerProdotto {

    @Autowired
    ServiceProdotto serviceProdotto;

    @Autowired
    ControllerMagazzino controllerMagazzino;

    /**
     * Updates the quantity of products in the warehouse and returns a confirmation message.
     *
     * @param prodotti         A list of Prodotto objects to be updated.
     * @param idPuntoVendita   An integer representing the point of sale ID.
     * @param quantita         An integer representing the quantity to be updated.
     * @return A string indicating the result of the product update process.
     */
    @PostMapping("/updateProdotto")
    public String updateProdotto(List<Prodotto> prodotti, int idPuntoVendita, int quantita) {
        for (Prodotto prodotto : prodotti) {
            controllerMagazzino.removeProdotto(prodotto.getId(), idPuntoVendita, quantita);
        }
        return "confermaUpdateMagazzino"; // Warehouse update confirmation
    }

    /**
     * Calculates the total price of a list of products.
     *
     * @param prodotti A list of Prodotto objects.
     * @return A float representing the total price of the products.
     */
    @GetMapping("/getPrezzoTotale")
    public float getPrezzoTotale(List<Prodotto> prodotti) {
        return serviceProdotto.getPrezzoTotale(prodotti);
    }

}
