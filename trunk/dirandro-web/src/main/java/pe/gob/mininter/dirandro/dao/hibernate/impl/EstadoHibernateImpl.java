package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.EstadoHibernate;
import pe.gob.mininter.dirandro.model.Estado;

@Repository
public class EstadoHibernateImpl extends BaseHibernateImpl<Estado, Long> implements EstadoHibernate {
	
	private static final long serialVersionUID = 4680088614350992816L;

	@Autowired
	public EstadoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
}
