package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.DetCasoDireccion;

public interface CasoDireccionService extends BaseService<DetCasoDireccion, Long> {

	public List<DetCasoDireccion> buscar(DetCasoDireccion caso);
	
	public void registrar(DetCasoDireccion caso);
}
