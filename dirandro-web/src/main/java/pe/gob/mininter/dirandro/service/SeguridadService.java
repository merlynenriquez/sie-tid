package pe.gob.mininter.dirandro.service;

import java.io.Serializable;

import pe.gob.mininter.dirandro.model.Usuario;

public interface SeguridadService extends Serializable {

	public Usuario login(String usuario, String clave);
	
}
