package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.AerodromoHibernate;
import pe.gob.mininter.dirandro.model.Aerodromo;

@Repository
@SuppressWarnings("serial")
public class AerodromoHibernateImpl extends BaseHibernateImpl<Aerodromo, Long> implements AerodromoHibernate {

	@Autowired
	public AerodromoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
