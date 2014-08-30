package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.TipoHecho;

public interface TipoHechoService extends BaseService<TipoHecho, Long> {

	List<TipoHecho> listarTipoHecho();
	
}
