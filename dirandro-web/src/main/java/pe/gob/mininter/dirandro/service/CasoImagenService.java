package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.DetCasoImagen;

public interface CasoImagenService extends BaseService<DetCasoImagen, Long> {

	public List<DetCasoImagen> buscar(DetCasoImagen caso);
	
}
