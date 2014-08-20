package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.PaisHibernate;
import pe.gob.mininter.dirandro.model.Pais;

@Repository
public class PaisHibernateImpl extends BaseHibernateImpl<Pais, Long> implements PaisHibernate {

	private static final long serialVersionUID = 7072383163040247784L;

	@Autowired
	public PaisHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}