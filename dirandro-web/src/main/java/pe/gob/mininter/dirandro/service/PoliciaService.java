package pe.gob.mininter.dirandro.service;

import java.util.List;
import java.util.Map;

import pe.gob.mininter.dirandro.model.Policia;

public interface PoliciaService extends BaseService<Policia,Long>{
	
	public List<Policia> buscar(Policia Policia);
	List<Policia> listarPolicias();
	public Policia obtener(Long id);	
	
}
