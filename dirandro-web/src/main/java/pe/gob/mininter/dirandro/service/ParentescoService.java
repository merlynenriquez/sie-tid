package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Parentesco;

public interface ParentescoService extends BaseService<Parentesco, Long> {
	
	public List<Parentesco> obtenerParientesXPersona(Long idPersona, boolean estadoActivo);

}
