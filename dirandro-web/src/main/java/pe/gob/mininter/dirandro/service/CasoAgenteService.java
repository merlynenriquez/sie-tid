package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.DetCasoAgente;

public interface CasoAgenteService extends BaseService<DetCasoAgente, Long> {

	public List<DetCasoAgente> buscar(DetCasoAgente caso);
	
}
