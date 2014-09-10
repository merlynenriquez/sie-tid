package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedientePersonaHibernate;
import pe.gob.mininter.dirandro.model.DetExpedientePersona;

@Repository
public class ExpedientePersonaHibernateImpl extends BaseHibernateImpl<DetExpedientePersona, Long> implements ExpedientePersonaHibernate {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	public ExpedientePersonaHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
