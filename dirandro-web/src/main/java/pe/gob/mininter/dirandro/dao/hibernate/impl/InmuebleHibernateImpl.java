package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.InmuebleHibernate;
import pe.gob.mininter.dirandro.model.Inmueble;

@Repository
public class InmuebleHibernateImpl extends BaseHibernateImpl<Inmueble, String> implements InmuebleHibernate {
	
	private static final long serialVersionUID = 8452199044673307417L;

	@Autowired
	public InmuebleHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
}
