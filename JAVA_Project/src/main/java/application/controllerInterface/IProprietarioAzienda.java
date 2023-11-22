package application.controllerInterface;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import application.model.ProgrammaFedelta;
import application.model.PuntoVendita;

@RequestMapping("/IProprietarioAzienda")
public interface IProprietarioAzienda {
	
	@PostMapping("/adesioneProgrammaFedelta")
	public List<ProgrammaFedelta> adesioneProgrammaFedelta();

	@PostMapping("/selezioneProgramma")
	public HashMap<String, String> selezioneProgramma(int idProgrammaScelto);
	
	@PostMapping("/compilazioneModuloDiAdesione")
	public String compilazioneModuloDiAdesione(HashMap<String,String> moduloAdesione);
	
	@PostMapping("/inserimentoInformazioniAggiuntive")
	public String inserimentoInformazioniAggiuntive(HashMap<String, String> informazioniAggiuntive);
	
	@PostMapping("/creaCoalizione")
	public String creaCoalizione();
	
	@PostMapping("/inserimentoInformazioni")
	public String inserimentoInformazioni(HashMap<String, String> informazioni);
	
	@PostMapping("/richiestaPuntiVenditaDisponibili")
	public List<PuntoVendita> richiestaPuntiVenditaDisponibili();

	@PostMapping("/inoltroRichiestaAdesione")
	public String inoltroRichiestaAdesione(String Adesione);

}
