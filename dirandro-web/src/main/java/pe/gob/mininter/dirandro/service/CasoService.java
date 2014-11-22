package pe.gob.mininter.dirandro.service;

import java.util.List;
import java.util.Map;

import pe.gob.mininter.dirandro.model.Caso;

public interface CasoService extends BaseService<Caso, Long> {

	public List<Caso> buscar(Caso caso);
	
	public void registrarCaso(Caso caso);
	
	public Map<String, List<Caso>> listarCasos();
	
	public Map<String, List<Caso>> filtrarCasos(List<Caso> lstCasos);
	
	public List<Caso> buscarBandeja(Map<String, Object> map);
}
