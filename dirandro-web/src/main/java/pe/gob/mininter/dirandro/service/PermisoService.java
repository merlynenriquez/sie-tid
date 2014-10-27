package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Permiso;
import pe.gob.mininter.dirandro.model.Valor;

public interface PermisoService extends BaseService<Permiso, Long> {
	
	public List<Permiso> obtenerPermisosXRol(Long idRol, boolean estadoActivo);
	
	public void guardarPermisos(Long idRol, List<Long> idsOpciones);

	public void prepararLista(List<Permiso> lista, Valor estado);
	
}
