package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteVehiculoHibernate;
import pe.gob.mininter.dirandro.model.DetPerVehExp;

@Repository
public class ExpedienteVehiculoHibernateImpl extends BaseHibernateImpl<DetPerVehExp, Long> implements ExpedienteVehiculoHibernate {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	public ExpedienteVehiculoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
