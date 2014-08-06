package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Permiso;

public interface PermisoService extends BaseService<Permiso, Long> {
	
	List<Permiso> obtenerPermisosXRol(Long idRol, boolean estadoActivo);
	
	void guardarPermisos(Long idRol, List<Long> idsOpciones);

}
