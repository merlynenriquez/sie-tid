package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.DetalleGremioInteligenciaHibernate;
import pe.gob.mininter.dirandro.model.DetGremioCocalero;

@Repository
public class DetalleGremioInteligenciaHibernateImpl extends BaseHibernateImpl<DetGremioCocalero, Long> implements DetalleGremioInteligenciaHibernate {

	private static final long serialVersionUID = 8722739742699737868L;

	@Autowired
	public DetalleGremioInteligenciaHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}