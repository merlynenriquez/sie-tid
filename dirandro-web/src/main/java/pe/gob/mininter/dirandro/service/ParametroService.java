package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Parametro;

public interface ParametroService extends BaseService<Parametro, String> {

	List<Parametro> buscar(Parametro parametro);
	
}
