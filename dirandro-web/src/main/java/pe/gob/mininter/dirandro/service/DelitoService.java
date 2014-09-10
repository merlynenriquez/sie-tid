package pe.gob.mininter.dirandro.service;

import java.util.List;
import java.util.Map;

import pe.gob.mininter.dirandro.model.Delito;

public interface DelitoService extends BaseService<Delito, Long> {

	public List<Delito> buscar(Delito delito);
	
	public Map<String, List<Delito>> listarDelitos();
	
	public Map<String, List<Delito>> filtrarDelitos(List<Delito> lstDelitos);
	
	public List<Delito> buscarPadreHijos(Delito delito);
	
	public Delito buscarDelito(Long id);
	
	public List<Delito> buscarHijos(Delito delito);
	
	public List<Delito> buscarPadres();
	
	public Delito buscarPadre(Delito delito);
	
}
