package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.DetalleZonaCultivoHibernate;
import pe.gob.mininter.dirandro.model.DetZonaCultivo;

@Repository
public class DetalleZonaCultivoHibernateImpl extends BaseHibernateImpl<DetZonaCultivo, Long> implements DetalleZonaCultivoHibernate {

	private static final long serialVersionUID = 8722739742699737868L;

	@Autowired
	public DetalleZonaCultivoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}