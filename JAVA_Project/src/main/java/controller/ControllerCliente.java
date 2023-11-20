package controller;

import org.springframework.beans.factory.annotation.Autowired;

import controllerInterface.ICliente;
import service.ServiceCliente;

public class ControllerCliente implements ICliente{
	
	@Autowired
	ServiceCliente serviceCliente;
	
	@Override
	public String inserimentoCredenziali(String nomeUtente, String Password) {
		if(serviceCliente.controlloDati(nomeUtente,Password)) {
			return "Autenticato";
		}
		return "Non Autenticato, controllare credenziali";
	}

}
