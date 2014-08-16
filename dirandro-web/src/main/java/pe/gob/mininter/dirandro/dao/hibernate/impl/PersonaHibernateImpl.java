package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.PersonaHibernate;
import pe.gob.mininter.dirandro.model.Persona;

@Repository
public class PersonaHibernateImpl extends BaseHibernateImpl<Persona, Long> implements PersonaHibernate{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4598090927498097916L;

	@Autowired
	public PersonaHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
