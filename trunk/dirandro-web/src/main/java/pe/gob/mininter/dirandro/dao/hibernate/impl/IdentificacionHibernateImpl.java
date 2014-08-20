package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.IdentificacionHibernate;
import pe.gob.mininter.dirandro.model.Identificacion;

@Repository
public class IdentificacionHibernateImpl extends BaseHibernateImpl<Identificacion, Long> implements IdentificacionHibernate {

	private static final long serialVersionUID = 8722739742699737868L;

	@Autowired
	public IdentificacionHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}