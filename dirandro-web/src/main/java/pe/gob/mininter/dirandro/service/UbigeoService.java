package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Distrito;
import pe.gob.mininter.dirandro.model.Pais;

public interface UbigeoService {

	public Distrito obtenerDistritoHost(String codigoHost);

	public List<Distrito> obtenerTodos();

	public Distrito obtenerDistrito(Long idDistrito);

	public void cargarUbigeo();
	
	public List<Pais> obtenerPaises();
	
}
