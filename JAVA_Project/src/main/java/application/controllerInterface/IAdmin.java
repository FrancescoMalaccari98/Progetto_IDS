package application.controllerInterface;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/IAdmin")
public interface IAdmin {
	
	@PostMapping("/creazioneProgrammaFedelta")
	public HashMap<String,String> creazioneProgrammaFedelta(String nomeUtente,String Password);
	
	@PostMapping("/inserimentoInformazioniBase")
	public HashMap<String,String>  inserimentoInformazioniBase(HashMap<String,String>  moduloInformazioniBase);
	
	@PostMapping("/inserimentoInformazioniDettagliate")
	public String inserimentoInformazioniDettagliate(HashMap<String,String> moduloInformazioniDettagliate);

}
