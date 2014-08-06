package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.OpcionHibernate;
import pe.gob.mininter.dirandro.model.Opcion;

@Repository
public class OpcionHibernateImpl extends BaseHibernateImpl<Opcion, Long> implements OpcionHibernate {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8539528121329387055L;

	@Autowired
	public OpcionHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
