package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Cliente;
import application.repository.RepositoryCliente;

@Service
public class ServiceCliente {
	
	@Autowired
	RepositoryCliente repositoryCliente;
	
	public boolean controlloDati(String nomeUtente,String password) {
		Cliente cliente = repositoryCliente.findByNomeUtenteAndPassword(nomeUtente,password);
		
		if (cliente == null) {
			System.out.println("Credenziali non valide");
			return false;
		}
		return true;
	}

}
