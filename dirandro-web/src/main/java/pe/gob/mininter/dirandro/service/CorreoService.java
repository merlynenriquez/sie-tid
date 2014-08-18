package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Correo;

public interface CorreoService extends BaseService<Correo, Long> {
	
	public List<Correo> obtenerCorreosXPersona(Long idPersona, boolean estadoActivo);

}
