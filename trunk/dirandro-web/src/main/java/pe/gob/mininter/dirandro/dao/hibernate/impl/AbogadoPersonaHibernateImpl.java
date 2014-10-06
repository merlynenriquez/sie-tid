package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.AbogadoPersonaHibernate;
import pe.gob.mininter.dirandro.model.AbogadoPersona;

@Repository
public class AbogadoPersonaHibernateImpl extends BaseHibernateImpl<AbogadoPersona, Long> implements AbogadoPersonaHibernate {

	private static final long serialVersionUID = -6792421953967749474L;

	@Autowired
	public AbogadoPersonaHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
