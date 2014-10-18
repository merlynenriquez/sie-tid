package pe.gob.mininter.dirandro.dao.hibernate;

import java.util.List;

import pe.gob.mininter.dirandro.model.Rol;

public interface RolHibernate extends BaseHibernate<Rol, Long> {

	List<Rol> busquedaRoles(Rol rol);
	
}
