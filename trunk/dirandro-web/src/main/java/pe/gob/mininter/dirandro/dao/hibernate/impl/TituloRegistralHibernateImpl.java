package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.TituloRegistralHibernate;
import pe.gob.mininter.dirandro.model.TituloRegistral;

@Repository
@SuppressWarnings("serial")
public class TituloRegistralHibernateImpl extends BaseHibernateImpl<TituloRegistral, Long> implements TituloRegistralHibernate {

	@Autowired
	public TituloRegistralHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
