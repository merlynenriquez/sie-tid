package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.DetGremioCocalero;

/**
 * 
 * @author Elvis campos
 *
 */
public interface DetalleGremioInteligenciaService extends BaseService<DetGremioCocalero,Long>{
	
	public List<DetGremioCocalero> buscar(DetGremioCocalero detalleGremio);
	
}
