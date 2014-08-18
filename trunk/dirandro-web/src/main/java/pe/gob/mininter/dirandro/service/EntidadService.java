package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Entidad;



public interface EntidadService extends BaseService<Entidad, Long> {

	List<Entidad> buscar(Entidad parametro);
	
}
