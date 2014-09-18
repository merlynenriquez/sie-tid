package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.DrogaHibernate;
import pe.gob.mininter.dirandro.model.Droga;

@Repository
public class DrogaHibernateImpl extends BaseHibernateImpl<Droga, Long> implements DrogaHibernate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4304534874137979019L;
	
	@Autowired
	public DrogaHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
