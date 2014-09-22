package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Telefono;

public interface TelefonoService extends BaseService<Telefono, Long> {
	
	public List<Telefono> buscar(Telefono telefono);
	
}
