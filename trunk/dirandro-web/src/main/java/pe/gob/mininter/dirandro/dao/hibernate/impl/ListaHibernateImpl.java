package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.ListaHibernate;
import pe.gob.mininter.dirandro.model.Lista;

@Repository
public class ListaHibernateImpl extends BaseHibernateImpl<Lista, Long> implements ListaHibernate {

	private static final long serialVersionUID = -5447589227734948629L;

	@Autowired
	public ListaHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
