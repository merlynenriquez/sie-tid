package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.DetallePersonaHibernate;
import pe.gob.mininter.dirandro.model.Detalle;

@Repository
public class DetallePersonaHibernateImpl  extends BaseHibernateImpl<Detalle, Long> implements DetallePersonaHibernate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5371262042354719953L;

	@Autowired
	public DetallePersonaHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
