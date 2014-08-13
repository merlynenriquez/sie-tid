package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.PredecesorHibernate;
import pe.gob.mininter.dirandro.model.Predecesor;

@Repository
public class PredecesorHibernateImpl extends BaseHibernateImpl<Predecesor, Long> implements PredecesorHibernate{

	private static final long serialVersionUID = -5573416683686883754L;

	@Autowired
	public PredecesorHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
}