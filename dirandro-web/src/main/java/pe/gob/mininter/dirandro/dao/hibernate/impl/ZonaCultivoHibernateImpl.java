package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.ZonaCultivoHibernate;
import pe.gob.mininter.dirandro.model.ZonaCultivo;

@Repository
public class ZonaCultivoHibernateImpl extends BaseHibernateImpl<ZonaCultivo, Long> implements ZonaCultivoHibernate {

	private static final long serialVersionUID = 2256740847346212101L;

	@Autowired
	public ZonaCultivoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}