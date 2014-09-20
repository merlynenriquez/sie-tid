package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.NumeroHibernate;
import pe.gob.mininter.dirandro.model.Numero;

@Repository
public class NumeroHibernateImpl extends BaseHibernateImpl<Numero, Long> implements NumeroHibernate{
	
	private static final long serialVersionUID = -379816290290811647L;

	@Autowired
	public NumeroHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
}
