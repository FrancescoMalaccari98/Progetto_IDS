package project.application.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.application.model.Operatore;
import project.application.repository.RepositoryOperatore;

@Service
public class ServiceOperatore {
	
	@Autowired
	RepositoryOperatore repositoryOperatore;

	public List<Operatore> getDipendenteByPuntoVendita(int idPuntoVendita) {
		return repositoryOperatore.findAllByIdPuntoVendita(idPuntoVendita);
	}

	public String modifyRuolo(int idOperatore) {
		Operatore operatore = repositoryOperatore.findById(idOperatore);
		operatore.setRuolo("ADMIN");
		repositoryOperatore.save(operatore);
		return "AssegnazioneCorretta";
	}
		
}
