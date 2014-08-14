package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Estado;

public interface EstadoService  extends BaseService<Estado,Long>{
	
	public List<Estado> buscar(Estado estado);
	
	public Estado obtenerEstado(String codigo);
	
}