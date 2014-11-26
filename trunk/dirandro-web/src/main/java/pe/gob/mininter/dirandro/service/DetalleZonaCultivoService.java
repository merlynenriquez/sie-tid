package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.DetZonaCultivo;

public interface DetalleZonaCultivoService extends BaseService<DetZonaCultivo, Long> {

	public List<DetZonaCultivo> buscar(DetZonaCultivo detalle);
	
}
