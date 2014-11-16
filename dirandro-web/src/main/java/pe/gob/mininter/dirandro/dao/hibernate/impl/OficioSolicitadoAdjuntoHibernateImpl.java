package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.OficioSolicitadoAdjuntoHibernate;
import pe.gob.mininter.dirandro.model.OficioSolicitadoAdjunto;

@Repository
@SuppressWarnings("serial")
public class OficioSolicitadoAdjuntoHibernateImpl extends BaseHibernateImpl<OficioSolicitadoAdjunto, Long> implements OficioSolicitadoAdjuntoHibernate {

	@Autowired
	public OficioSolicitadoAdjuntoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}