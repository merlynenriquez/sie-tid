package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Aerodromo;

public interface AerodromoService extends BaseService<Aerodromo, Long> {

	List<Aerodromo> buscar(Aerodromo aerodromo);
	
}
