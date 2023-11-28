package project.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.application.model.Cliente;
import project.application.repository.RepositoryCliente;

@Service
public class ServiceCliente {
	
	@Autowired
	RepositoryCliente repositoryCliente;
	
	public boolean getDati(String nomeUtente,String password) {
		Cliente cliente = repositoryCliente.findByNomeUtenteAndPassword(nomeUtente,password);
		
		if (cliente == null) {
			System.out.println("Credenziali non valide");
			return false;
		}
		return true;
	}
	
	public Cliente getClienteById(int id) {
		return repositoryCliente.findClienteById(id);
	}

}
