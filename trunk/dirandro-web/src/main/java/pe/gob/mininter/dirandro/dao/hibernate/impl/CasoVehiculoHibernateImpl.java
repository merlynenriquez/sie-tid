package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.CasoVehiculoHibernate;
import pe.gob.mininter.dirandro.model.DetCasoVehiculo;

@Repository
public class CasoVehiculoHibernateImpl extends BaseHibernateImpl<DetCasoVehiculo, Long> implements CasoVehiculoHibernate {

	private static final long serialVersionUID = 8722739742699737868L;

	@Autowired
	public CasoVehiculoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}