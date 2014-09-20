package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Numero;

public interface NumeroService extends BaseService<Numero, Long> {
	
	public List<Numero> buscar(Numero numero);
 
}
