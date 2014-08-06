package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.PermisoHibernate;
import pe.gob.mininter.dirandro.model.Permiso;

@Repository
public class PermisoHibernateImpl extends BaseHibernateImpl<Permiso, Long> implements PermisoHibernate {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1143632255799838731L;

	@Autowired
	public PermisoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
