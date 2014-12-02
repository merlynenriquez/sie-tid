package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.NotaAgente;

public interface NotaAgenteService extends BaseService<NotaAgente,Long> {

	public List<NotaAgente> buscar(NotaAgente notaAgente);
	
}
