package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Inmueble;

public interface InmuebleService  extends BaseService<Inmueble,String>{
	
	public List<Inmueble> buscar(Inmueble inmueble);
	
}