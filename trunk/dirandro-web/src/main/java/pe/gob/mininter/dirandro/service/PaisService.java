package pe.gob.mininter.dirandro.service;

import java.util.List;
import java.util.Map;

import pe.gob.mininter.dirandro.model.Pais;

public interface PaisService  extends BaseService<Pais, Long>{
	
	public List<Pais> buscar(Pais pais);

	public Map<String, List<Pais>> listarPaises();
	
}
