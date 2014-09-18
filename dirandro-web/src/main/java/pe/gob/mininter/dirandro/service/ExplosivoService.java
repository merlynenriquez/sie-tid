package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Explosivo;

public interface ExplosivoService extends BaseService<Explosivo,Long>{
	
	public List<Explosivo> buscar(Explosivo explosivo);
	public Explosivo obtener(Long id);	
	
}
