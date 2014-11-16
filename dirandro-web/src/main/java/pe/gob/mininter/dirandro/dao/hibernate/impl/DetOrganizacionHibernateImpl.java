package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.DetOrganizacionHibernate;
import pe.gob.mininter.dirandro.model.DetOrganizacion;

@Repository
@SuppressWarnings("serial")
public class DetOrganizacionHibernateImpl extends BaseHibernateImpl<DetOrganizacion, Long> implements DetOrganizacionHibernate {

	@Autowired
	public DetOrganizacionHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
