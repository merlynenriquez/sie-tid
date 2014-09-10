package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteEspecieHibernate;
import pe.gob.mininter.dirandro.model.Especie;

@Repository
public class ExpedienteEspecieHibernateImpl extends BaseHibernateImpl<Especie, Long> implements ExpedienteEspecieHibernate {
	
	private static final long serialVersionUID = 3171299258042705391L;

	@Autowired
	public ExpedienteEspecieHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
}
