package application.controllerInterface;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.CartaFedelta;

@RequestMapping("/ICliente")
public interface ICliente {
	
	@PostMapping("/inserimentoCredenziali")
	public String inserimentoCredenziali(String nomeUtente, String Password);
	
	@PostMapping("/venditaProdotto")
	public String acquistoProdotto(List<Integer> idProdotto, int idPuntoVendita, int idCliente);
	
	@PostMapping("/visualizzaClassifica")
	public List<CartaFedelta> visualizzaClassifica(int idProgramma);
	
	@PostMapping("/richiestaCashback")
	public int richiestaCashback(int idCliente);
	
	@PostMapping("/inserisceImporto")
	public String inserisceImporto(int importoCashBack,int idCliente);
	
	@PostMapping("/inserisceContoCorrente")
	public String inserisceContoCorrente(int contoCorrente,int idCliente, int importoCashBack);
}
