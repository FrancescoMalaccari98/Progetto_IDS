package service;

import org.springframework.stereotype.Service;

import model.Cliente;
import repository.RepositoryCliente;

@Service
public class ServiceCliente {
	
	RepositoryCliente repositoryCliente;
	
	public boolean controlloDati(String nomeUtente,String password) {
		Cliente accesso = repositoryCliente.findByNomeUtenteAndPassword(nomeUtente,password);
		
		if (accesso == null) {
			System.out.println("Credenziali non valide");
			return false;
		}
		return true;
	}

}
