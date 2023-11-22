package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import application.service.ServiceCliente;
import application.controllerInterface.ICliente;

@RestController
public class ControllerCliente implements ICliente{
	
	@Autowired
	ServiceCliente serviceCliente;
	
	@Override
	public String inserimentoCredenziali(String nomeUtente,String password) {
		if(serviceCliente.controlloDati(nomeUtente,password)) {
			return "Autenticato";
		}
		return "Non Autenticato, controllare credenziali";
	}

}
