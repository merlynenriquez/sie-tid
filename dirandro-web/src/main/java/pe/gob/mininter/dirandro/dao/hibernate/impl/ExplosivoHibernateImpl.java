package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.ExplosivoHibernate;
import pe.gob.mininter.dirandro.model.Explosivo;

@Repository
public class ExplosivoHibernateImpl extends BaseHibernateImpl<Explosivo, Long> implements ExplosivoHibernate {
	
	private static final long serialVersionUID = 8452199044673307417L;

	@Autowired
	public ExplosivoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
}
