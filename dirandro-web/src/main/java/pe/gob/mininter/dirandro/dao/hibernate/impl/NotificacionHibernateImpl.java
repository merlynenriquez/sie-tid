package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.NotificacionHibernate;
import pe.gob.mininter.dirandro.model.Notificacion;

@Repository
@SuppressWarnings("serial")
public class NotificacionHibernateImpl extends BaseHibernateImpl<Notificacion, Long> implements NotificacionHibernate {

	@Autowired
	public NotificacionHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
