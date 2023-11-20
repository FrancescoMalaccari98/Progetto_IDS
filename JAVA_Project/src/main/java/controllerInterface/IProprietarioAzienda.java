package controllerInterface;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;

@Controller
public interface IProprietarioAzienda {
	
	public List<String> adesioneProgrammaFedelta();

	public HashMap<String, String> selezioneProgramma(String programmaScelto);
	
	public String compilazioneModuloDiAdesione(HashMap<String,String> moduloAdesione);
	
	public String inserimentoInformazioniAggiuntive(HashMap<String, String> informazioniAggiuntive);

}
