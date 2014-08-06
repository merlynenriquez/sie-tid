package pe.gob.mininter.dirandro.service;

import java.util.List;
import java.util.Map;

import pe.gob.mininter.dirandro.model.Opcion;

public interface OpcionService extends BaseService<Opcion, Long> {
	
	List<Opcion> buscar(Opcion lista);
	
	Map<String, List<Opcion>> listarOpciones();
	
	Opcion obtenerOpcionPorCodigo(String codigo);
	
}
