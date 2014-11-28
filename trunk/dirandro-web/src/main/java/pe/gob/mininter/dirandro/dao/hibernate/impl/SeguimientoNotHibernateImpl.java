package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.SeguimientoNotHibernate;
import pe.gob.mininter.dirandro.model.SeguimientoNot;

@Repository
@SuppressWarnings("serial")
public class SeguimientoNotHibernateImpl extends BaseHibernateImpl<SeguimientoNot, Long> implements SeguimientoNotHibernate {

	@Autowired
	public SeguimientoNotHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
