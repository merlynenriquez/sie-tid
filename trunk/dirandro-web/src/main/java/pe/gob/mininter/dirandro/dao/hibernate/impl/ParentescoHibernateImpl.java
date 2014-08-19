package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.ParentescoHibernate;
import pe.gob.mininter.dirandro.model.Parentezco;

@Repository
public class ParentescoHibernateImpl extends BaseHibernateImpl<Parentezco, Long> implements ParentescoHibernate {

	private static final long serialVersionUID = 164081887443064753L;

	@Autowired
	public ParentescoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}