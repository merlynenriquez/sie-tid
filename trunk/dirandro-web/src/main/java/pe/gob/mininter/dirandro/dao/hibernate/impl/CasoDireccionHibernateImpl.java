package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.CasoDireccionHibernate;
import pe.gob.mininter.dirandro.model.DetCasoDireccion;

@Repository
public class CasoDireccionHibernateImpl extends BaseHibernateImpl<DetCasoDireccion, Long> implements CasoDireccionHibernate {

	private static final long serialVersionUID = 8722739742699737868L;

	@Autowired
	public CasoDireccionHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}