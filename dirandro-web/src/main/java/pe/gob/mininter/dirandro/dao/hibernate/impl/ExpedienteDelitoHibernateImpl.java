package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteDelitoHibernate;
import pe.gob.mininter.dirandro.model.ExpedienteDelito;

@Repository
public class ExpedienteDelitoHibernateImpl extends BaseHibernateImpl<ExpedienteDelito, Long> implements ExpedienteDelitoHibernate {
	
	private static final long serialVersionUID = -7053119087132878435L;

	@Autowired
	public ExpedienteDelitoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
