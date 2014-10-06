package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.AbogadoPersona;

public interface AbogadoPersonaService extends BaseService<AbogadoPersona, Long> {

	List<AbogadoPersona> listarAbogadoPersona();
	
}
