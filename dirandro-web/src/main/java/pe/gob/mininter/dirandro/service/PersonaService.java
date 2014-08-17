package pe.gob.mininter.dirandro.service;

import java.util.List;
import java.util.Map;

import pe.gob.mininter.dirandro.model.Persona;

public interface PersonaService extends BaseService<Persona,Long>{
	
	public List<Persona> buscar(Persona persona);
	Map<String,List<Persona>> listarPersonas();
	public Persona obtener(Long id);	
	
}
