package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.LetradoHibernate;
import pe.gob.mininter.dirandro.model.Letrado;

@Repository
public class LetradoHibernateImpl extends BaseHibernateImpl<Letrado, Long> implements LetradoHibernate {

	private static final long serialVersionUID = -6792421953967749474L;

	@Autowired
	public LetradoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
