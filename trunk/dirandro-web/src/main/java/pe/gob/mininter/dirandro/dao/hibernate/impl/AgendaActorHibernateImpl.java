package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.AgendaActorHibernate;
import pe.gob.mininter.dirandro.model.AgendaActor;

@Repository
@SuppressWarnings("serial")
public class AgendaActorHibernateImpl extends BaseHibernateImpl<AgendaActor, Long> implements AgendaActorHibernate {

	@Autowired
	public AgendaActorHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
