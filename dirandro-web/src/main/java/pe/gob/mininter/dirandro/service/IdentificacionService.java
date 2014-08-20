package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Identificacion;

public interface IdentificacionService extends BaseService<Identificacion, Long> {
	
	public List<Identificacion> obtenerIdentificacionesXPersona(Long idPersona, boolean estadoActivo);

}
