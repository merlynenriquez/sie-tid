package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Predecesor;

public interface PredecesorService extends BaseService<Predecesor,Long>{
	
	public List<Predecesor> buscar(Predecesor predecesor);
	
}
