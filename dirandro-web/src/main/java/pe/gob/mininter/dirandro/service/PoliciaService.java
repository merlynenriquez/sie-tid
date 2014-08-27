package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Policia;

public interface PoliciaService extends BaseService<Policia,Long>{
	
	public List<Policia> buscar(Policia Policia);
	
	public Policia obtener(Long id);	
	
}
