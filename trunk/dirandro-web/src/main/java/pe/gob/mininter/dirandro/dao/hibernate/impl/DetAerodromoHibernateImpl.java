package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.DetAerodromoHibernate;
import pe.gob.mininter.dirandro.model.DetAerodromo;

@Repository
@SuppressWarnings("serial")
public class DetAerodromoHibernateImpl extends BaseHibernateImpl<DetAerodromo, Long> implements DetAerodromoHibernate {

	@Autowired
	public DetAerodromoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
