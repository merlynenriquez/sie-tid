package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Instalacion;

public interface InstalacionService extends BaseService<Instalacion,Long>{
	
	public List<Instalacion> buscar(Instalacion instalacion);
	
	
}
