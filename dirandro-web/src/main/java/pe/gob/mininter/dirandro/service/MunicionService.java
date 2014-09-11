package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Municion;

public interface MunicionService extends BaseService<Municion,Long>{
	
	public List<Municion> buscar(Municion municion);
	
}
