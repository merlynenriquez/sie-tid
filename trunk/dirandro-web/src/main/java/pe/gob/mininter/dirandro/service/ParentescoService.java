package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Parentezco;

public interface ParentescoService extends BaseService<Parentezco, Long> {
	
	public List<Parentezco> obtenerParientesXPersona(Long idPersona, boolean estadoActivo);

}
