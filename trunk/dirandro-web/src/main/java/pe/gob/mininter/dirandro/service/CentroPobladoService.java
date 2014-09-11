package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.CentroPoblado;

public interface CentroPobladoService extends BaseService<CentroPoblado, Long> {
	
	public List<CentroPoblado> buscar(CentroPoblado centroPoblado);
 
}
