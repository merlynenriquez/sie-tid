package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.EntidadHibernate;
import pe.gob.mininter.dirandro.model.Entidad;


@Repository
public class EntidadHibernateImpl extends BaseHibernateImpl<Entidad, Long> implements EntidadHibernate {

	private static final long serialVersionUID = -5845321587222964886L;
	
	@Autowired
	public EntidadHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
