package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.DetIntRuta;

public interface DetRutaTIDService extends BaseService<DetIntRuta, Long> {

	public List<DetIntRuta> buscar(DetIntRuta detalleRutaTID);
}
