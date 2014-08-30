package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.TipoHechoHibernate;
import pe.gob.mininter.dirandro.model.TipoHecho;

@Repository
public class TipoHechoHibernateImpl extends BaseHibernateImpl<TipoHecho, Long> implements TipoHechoHibernate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9110153770100029328L;
	
	@Autowired
	public TipoHechoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
