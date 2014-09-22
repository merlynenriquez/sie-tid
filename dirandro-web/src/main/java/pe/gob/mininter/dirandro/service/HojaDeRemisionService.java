package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Hojaremision;

public interface HojaDeRemisionService extends BaseService<Hojaremision,Long>{
	
	public List<Hojaremision> buscar(Hojaremision hojaremision);
	
}
