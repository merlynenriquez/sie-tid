package pe.gob.mininter.dirandro.service;

import java.util.List;
import java.util.Map;

import pe.gob.mininter.dirandro.model.Hojaremision;

public interface HojaRemisionService extends BaseService<Hojaremision,Long>{
	
	public List<Hojaremision> buscar(Hojaremision hojaremision);
	List<Hojaremision> buscarBandeja(Map<String, Object> map);
	
}
