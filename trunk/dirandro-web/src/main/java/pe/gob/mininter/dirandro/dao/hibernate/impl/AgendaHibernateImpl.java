package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.AgendaHibernate;
import pe.gob.mininter.dirandro.model.Agenda;

@Repository
@SuppressWarnings("serial")
public class AgendaHibernateImpl extends BaseHibernateImpl<Agenda, Long> implements AgendaHibernate {

	@Autowired
	public AgendaHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
