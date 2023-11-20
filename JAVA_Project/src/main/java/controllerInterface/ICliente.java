package controllerInterface;

import org.springframework.stereotype.Controller;

@Controller
public interface ICliente {
	
	public String inserimentoCredenziali(String nomeUtente,String Password);

}
