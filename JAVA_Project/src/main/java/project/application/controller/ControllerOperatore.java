package project.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import project.application.model.Operatore;
import project.application.service.ServiceOperatore;

@RestController
public class ControllerOperatore {
	
	@Autowired
	ServiceOperatore serviceOperatore;
	
	public List<Operatore> getDipendenteByPuntoVendita(int idPuntoVendita) {
		return serviceOperatore.getDipendenteByPuntoVendita(idPuntoVendita);
	}

	public String setAdmin(int idOperatore) {
		return serviceOperatore.modifyRuolo(idOperatore);
	}
	
	
}
