package pe.gob.mininter.dirandro.service;

import java.util.List;
import java.util.Map;

import pe.gob.mininter.dirandro.model.Pericia;

public interface PericiaService extends BaseService<Pericia,Long>{
	
	public List<Pericia> buscar(Pericia arma);
	public List<Pericia> buscarBandeja(Map<String, Object> map);
}
