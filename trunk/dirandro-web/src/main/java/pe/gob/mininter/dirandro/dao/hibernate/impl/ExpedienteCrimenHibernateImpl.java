package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteCrimenHibernate;
import pe.gob.mininter.dirandro.model.DetCrimen;

@Repository
public class ExpedienteCrimenHibernateImpl extends BaseHibernateImpl<DetCrimen, Long> implements ExpedienteCrimenHibernate {

	private static final long serialVersionUID = -5703196836013297322L;

	@Autowired
	public ExpedienteCrimenHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
