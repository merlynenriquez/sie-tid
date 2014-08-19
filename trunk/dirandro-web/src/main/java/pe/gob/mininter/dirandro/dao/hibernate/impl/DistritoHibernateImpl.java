package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.DistritoHibernate;
import pe.gob.mininter.dirandro.model.Distrito;


@Repository
public class DistritoHibernateImpl extends BaseHibernateImpl<Distrito, Long> implements DistritoHibernate {
	
	private static final long serialVersionUID = -1143632255799838731L;

	@Autowired
	public DistritoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
