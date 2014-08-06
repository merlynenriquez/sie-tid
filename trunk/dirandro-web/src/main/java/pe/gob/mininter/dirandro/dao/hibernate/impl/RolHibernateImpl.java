package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.RolHibernate;
import pe.gob.mininter.dirandro.model.Rol;

@Repository
public class RolHibernateImpl extends
		BaseHibernateImpl<Rol, Long> implements RolHibernate {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1143632255799838731L;

	@Autowired
	public RolHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
