package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Cliente;
import application.repository.RepositoryCliente;

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

	public int getCashBack(int idCliente) {
		Cliente cliente = repositoryCliente.findClienteById(idCliente);
		return cliente.getCashBack();
	}

	public boolean verificaDisponibilità(int importoCashBack, int idCliente) {
		Cliente cliente = repositoryCliente.findClienteById(idCliente);
		if(importoCashBack>cliente.getCashBack()) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean updateCashBack(int contoCorrente,int idCliente,int importoCashBack){
		Cliente cliente = repositoryCliente.findClienteById(idCliente);
		try {
			cliente.setCashBack(cliente.getCashBack()-importoCashBack);
			repositoryCliente.save(cliente);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
