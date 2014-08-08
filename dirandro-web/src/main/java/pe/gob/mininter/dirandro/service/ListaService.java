package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Lista;

public interface ListaService extends BaseService<Lista, Long> {
	
	List<Lista> buscar(Lista lista);

}
