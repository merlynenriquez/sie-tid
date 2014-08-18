package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.EstadoHibernate;
import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteInmuebleHibernate;
import pe.gob.mininter.dirandro.model.Estado;
import pe.gob.mininter.dirandro.model.Inmueble;

@Repository
public class ExpedienteInmuebleHibernateImpl extends BaseHibernateImpl<Inmueble, String> implements ExpedienteInmuebleHibernate {
	
	private static final long serialVersionUID = 8452199044673307417L;

	@Autowired
	public ExpedienteInmuebleHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
}
