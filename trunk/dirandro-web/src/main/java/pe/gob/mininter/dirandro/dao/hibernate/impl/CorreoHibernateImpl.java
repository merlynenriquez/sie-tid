package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.CorreoHibernate;
import pe.gob.mininter.dirandro.model.Correo;

@Repository
public class CorreoHibernateImpl extends BaseHibernateImpl<Correo, Long> implements CorreoHibernate {

	private static final long serialVersionUID = 8722739742699737868L;

	@Autowired
	public CorreoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}