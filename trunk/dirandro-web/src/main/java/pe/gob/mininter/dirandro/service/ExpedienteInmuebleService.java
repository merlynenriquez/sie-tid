package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Inmueble;

public interface ExpedienteInmuebleService  extends BaseService<Inmueble,String>{
	
	public List<Inmueble> buscar(Inmueble inmueble);
	
}