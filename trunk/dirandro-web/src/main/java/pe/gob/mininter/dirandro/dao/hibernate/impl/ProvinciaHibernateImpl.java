package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.ProvinciaHibernate;
import pe.gob.mininter.dirandro.model.Provincia;


@Repository
public class ProvinciaHibernateImpl extends BaseHibernateImpl<Provincia, Long> implements ProvinciaHibernate {
	
	private static final long serialVersionUID = -1143632255799838731L;

	@Autowired
	public ProvinciaHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
