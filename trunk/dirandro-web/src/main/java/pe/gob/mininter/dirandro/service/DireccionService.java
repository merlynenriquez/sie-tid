package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Direccion;

public interface DireccionService extends BaseService<Direccion, Long> {
	
	//public List<Direccion> obtenerDireccionesXPersona(Long idPersona, boolean estadoActivo);
	public List<Direccion> buscar(Direccion direccion);
	
}
