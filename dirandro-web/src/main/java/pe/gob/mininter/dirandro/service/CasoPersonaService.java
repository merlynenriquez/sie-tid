package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.DetCasoPersona;

public interface CasoPersonaService extends BaseService<DetCasoPersona, Long> {

	public List<DetCasoPersona> buscar(DetCasoPersona caso);
	
	public void registrar(DetCasoPersona caso);
	
	
}
