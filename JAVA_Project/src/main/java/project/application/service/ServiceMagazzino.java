package project.application.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.application.model.Magazzino;
import project.application.repository.RepositoryMagazzino;

@Service
public class ServiceMagazzino {

	@Autowired
	RepositoryMagazzino repositoryMagazzino;
	
	public List<Integer> getListaProdotti(int idPuntoVendita) {
		 List<Magazzino> listaMagazzino = repositoryMagazzino.findAllByIdPuntoVendita(idPuntoVendita);
		 List<Integer> listaIdProdotti = new ArrayList<Integer>();
		 for (Magazzino magazzino : listaMagazzino) {
			 listaIdProdotti.add(magazzino.getIdProdotto());
		}
		 return listaIdProdotti;
	}

	public String addProdotto(int quantita, int idProdotto, int idPuntoVendita) {
		 List<Magazzino> listaMagazzino = repositoryMagazzino.findAllByIdPuntoVendita(idPuntoVendita);
		 for (Magazzino magazzino : listaMagazzino) {
			 if(magazzino.getIdProdotto()==idProdotto) {
				 magazzino.setQuantita(magazzino.getQuantita()+quantita);
			 	repositoryMagazzino.save(magazzino);
			 	return "conferma update magazzino";
			}
		}
		 return "Errore in update Magazzino";
	}

	public String removeProdotto(int quantita, int idProdotto, int idPuntoVendita) {
		 List<Magazzino> listaMagazzino = repositoryMagazzino.findAllByIdPuntoVendita(idPuntoVendita);
		 for (Magazzino magazzino : listaMagazzino) {
			 if(magazzino.getIdProdotto()==idProdotto) {
				 if(magazzino.getQuantita()<quantita) {
					 magazzino.setQuantita(magazzino.getQuantita()-quantita);
					 repositoryMagazzino.save(magazzino);
					 return "conferma update magazzino";
				} else {
					return "Operazione non valida";
				}
			}
		}
		 return "Errore in update Magazzino";
	}

}
