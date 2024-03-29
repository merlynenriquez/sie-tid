package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteInmuebleHibernate;
import pe.gob.mininter.dirandro.model.DetPerInmExp;

@Repository
public class ExpedienteInmuebleHibernateImpl extends BaseHibernateImpl<DetPerInmExp, String> implements ExpedienteInmuebleHibernate {
	
	private static final long serialVersionUID = 8452199044673307417L;

	@Autowired
	public ExpedienteInmuebleHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
}
