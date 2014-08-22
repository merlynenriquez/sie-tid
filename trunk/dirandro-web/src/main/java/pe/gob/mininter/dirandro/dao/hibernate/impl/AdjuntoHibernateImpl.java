package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.AdjuntoHibernate;
import pe.gob.mininter.dirandro.model.Adjunto;


@Repository
public class AdjuntoHibernateImpl extends BaseHibernateImpl<Adjunto, Long> implements AdjuntoHibernate {

	private static final long serialVersionUID = -5226347088355502746L;

	@Autowired
	public AdjuntoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
