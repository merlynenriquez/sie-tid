package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.TituloRegistral;

public interface TituloRegistralService extends BaseService<TituloRegistral, Long> {

	List<TituloRegistral> buscar(TituloRegistral tituloRegistral);
	
}
