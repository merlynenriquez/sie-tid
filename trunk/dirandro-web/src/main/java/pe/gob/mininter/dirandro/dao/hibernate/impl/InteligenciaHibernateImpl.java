package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.InteligenciaHibernate;
import pe.gob.mininter.dirandro.model.Inteligencia;

@Repository
public class InteligenciaHibernateImpl extends BaseHibernateImpl<Inteligencia, Long> implements InteligenciaHibernate {

	private static final long serialVersionUID = 8761776081230570630L;

	@Autowired
	public InteligenciaHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}