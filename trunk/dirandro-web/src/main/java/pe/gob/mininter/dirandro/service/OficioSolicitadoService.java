package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.OficioSolicitado;

public interface OficioSolicitadoService extends BaseService<OficioSolicitado, Long> {
	
	public List<OficioSolicitado> buscar(OficioSolicitado oficioSolicitado);
	
}
