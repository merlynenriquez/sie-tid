package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Letrado;
import pe.gob.mininter.dirandro.model.Policia;

public interface LetradoService extends BaseService<Letrado, Long> {

	List<Letrado> buscar(Letrado letrado);
	
	List<Letrado> listarLetrado();
	
}
