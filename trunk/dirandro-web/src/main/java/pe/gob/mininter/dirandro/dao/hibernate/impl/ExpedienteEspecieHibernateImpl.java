package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.EstadoHibernate;
import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteEspecieHibernate;
import pe.gob.mininter.dirandro.model.Especie;
import pe.gob.mininter.dirandro.model.Estado;

@Repository
public class ExpedienteEspecieHibernateImpl extends BaseHibernateImpl<Especie, Long> implements ExpedienteEspecieHibernate {
	
	private static final long serialVersionUID = 3627808003795950018L;

	@Autowired
	public ExpedienteEspecieHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
}
