package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.DelitoHibernate;
import pe.gob.mininter.dirandro.model.Delito;


@Repository
public class DelitoHibernateImpl extends BaseHibernateImpl<Delito, Long> implements DelitoHibernate {
	
	private static final long serialVersionUID = -2640821743705077635L;

	@Autowired
	public DelitoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
