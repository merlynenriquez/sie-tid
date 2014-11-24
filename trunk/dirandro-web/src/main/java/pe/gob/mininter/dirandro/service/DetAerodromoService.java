package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.DetAerodromo;

public interface DetAerodromoService extends BaseService<DetAerodromo, Long> {

	List<DetAerodromo> buscar(DetAerodromo detAerodromo);
	
}
