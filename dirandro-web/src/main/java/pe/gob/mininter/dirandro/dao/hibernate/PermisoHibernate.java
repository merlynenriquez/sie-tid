package pe.gob.mininter.dirandro.dao.hibernate;

import java.util.List;

import pe.gob.mininter.dirandro.model.Permiso;

public interface PermisoHibernate extends BaseHibernate<Permiso, Long> {

	List<Permiso> obtenerPermisosXRol(Long idRol, boolean estadoActivo);
	
}
