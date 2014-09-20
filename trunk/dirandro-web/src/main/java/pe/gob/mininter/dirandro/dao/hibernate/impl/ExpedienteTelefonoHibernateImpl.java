package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteTelefonoHibernate;
import pe.gob.mininter.dirandro.model.DetPerTelExp;

@Repository
public class ExpedienteTelefonoHibernateImpl extends BaseHibernateImpl<DetPerTelExp, Long> implements ExpedienteTelefonoHibernate {
	
	private static final long serialVersionUID = -5993937963981155621L;

	@Autowired
	public ExpedienteTelefonoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
}