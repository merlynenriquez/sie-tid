package pe.gob.mininter.dirandro.service;

import java.util.List;
import java.util.Map;

import pe.gob.mininter.dirandro.model.Opcion;

public interface OpcionService extends BaseService<Opcion, Long> {
	
	public List<Opcion> buscar(Opcion lista);
	
	public Map<String, List<Opcion>> listarOpciones();
	
	public Opcion obtenerOpcionPorCodigo(String codigo);
	
}
