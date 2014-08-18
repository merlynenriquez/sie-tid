package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.DireccionHibernate;
import pe.gob.mininter.dirandro.model.Direccion;

@Repository
public class DireccionHibernateImpl extends BaseHibernateImpl<Direccion, Long> implements DireccionHibernate {
	
	private static final long serialVersionUID = 4142567013547924014L;

	@Autowired
	public DireccionHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}