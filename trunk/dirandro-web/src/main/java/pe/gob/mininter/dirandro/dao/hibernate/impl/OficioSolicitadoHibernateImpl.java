package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.OficioSolicitadoHibernate;
import pe.gob.mininter.dirandro.model.OficioSolicitado;

@Repository
@SuppressWarnings("serial")
public class OficioSolicitadoHibernateImpl extends BaseHibernateImpl<OficioSolicitado, Long> implements OficioSolicitadoHibernate {

	@Autowired
	public OficioSolicitadoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}