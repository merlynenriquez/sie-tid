package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Inteligencia;

public interface InteligenciaService extends BaseService<Inteligencia,Long>{
	
	public void registrarDocInteligencia(Inteligencia inteligencia);
	
	public List<Inteligencia> buscar(Inteligencia inteligencia);
	
}
