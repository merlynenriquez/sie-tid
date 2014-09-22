package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Importe;

public interface ImporteService extends BaseService<Importe,Long>{
	
	public List<Importe> buscar(Importe importe);
	
}
