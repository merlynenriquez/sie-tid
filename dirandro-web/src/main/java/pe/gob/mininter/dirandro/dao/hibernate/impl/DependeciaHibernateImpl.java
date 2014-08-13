package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.DependenciaHibernate;
import pe.gob.mininter.dirandro.model.Dependencia;

@Repository
public class DependeciaHibernateImpl extends BaseHibernateImpl<Dependencia, Long> implements DependenciaHibernate{
	
	private static final long serialVersionUID = 3549627759742192812L;

	@Autowired
	public DependeciaHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
