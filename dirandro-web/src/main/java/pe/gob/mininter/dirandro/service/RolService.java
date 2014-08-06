package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Rol;

public interface RolService extends BaseService<Rol, Long> {
	
	List<Rol> buscar(Rol lista);

}
