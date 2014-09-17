package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.VehiculoHibernate;
import pe.gob.mininter.dirandro.model.Vehiculo;

@Repository
public class VehiculoHibernateImpl extends BaseHibernateImpl<Vehiculo, Long> implements VehiculoHibernate {
	
	private static final long serialVersionUID = -3294557806938718602L;

	@Autowired
	public VehiculoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
