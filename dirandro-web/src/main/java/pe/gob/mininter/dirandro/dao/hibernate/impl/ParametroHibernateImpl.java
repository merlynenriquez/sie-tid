package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.ParametroHibernate;
import pe.gob.mininter.dirandro.model.Parametro;

@Repository
public class ParametroHibernateImpl extends BaseHibernateImpl<Parametro, String> implements ParametroHibernate {

	private static final long serialVersionUID = -5845321587222964886L;
	
	@Autowired
	public ParametroHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
