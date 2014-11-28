package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.SeguimientoNot;

public interface SeguimientoNotService extends BaseService<SeguimientoNot, Long> {

	List<SeguimientoNot> buscar(SeguimientoNot seguimientoNot);
	
}
