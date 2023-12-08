package project.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;
import project.application.model.ComunicazionePromozionale;

@Transactional
public interface RepositoryComunicazionePromozionale extends JpaRepository<ComunicazionePromozionale, Integer> {

	List<ComunicazionePromozionale> findComunicazionePromozionaleByIdPuntoVendita(int idPuntoVendita);

}
