package application.controllerInterface;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/ICliente")
public interface ICliente {
	
	@PostMapping("/inserimentoCredenziali")
	public String inserimentoCredenziali(String nomeUtente, String Password);

}
