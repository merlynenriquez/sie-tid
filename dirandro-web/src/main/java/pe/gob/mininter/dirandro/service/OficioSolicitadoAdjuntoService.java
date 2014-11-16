package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.OficioSolicitadoAdjunto;

public interface OficioSolicitadoAdjuntoService extends BaseService<OficioSolicitadoAdjunto, Long> {
	
	public List<OficioSolicitadoAdjunto> buscar(OficioSolicitadoAdjunto oficioSolicitadoAdjunto);
	
}
