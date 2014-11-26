package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.ZonaCultivo;

public interface ZonaCultivoService extends BaseService<ZonaCultivo, Long> {

	public List<ZonaCultivo> buscar(ZonaCultivo zona);
	
}