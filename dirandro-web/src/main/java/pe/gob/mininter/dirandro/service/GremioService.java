package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.GremioCocalero;

public interface GremioService extends BaseService<GremioCocalero, Long> {

	public List<GremioCocalero> buscar(GremioCocalero gremio);
	
}
