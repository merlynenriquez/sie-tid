package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.DetCrimen;

public interface ExpedienteCrimenService extends BaseService<DetCrimen, Long> {
	
	public List<DetCrimen> buscar(DetCrimen expCrimen);

}
