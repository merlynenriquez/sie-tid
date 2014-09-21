package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.ArmaHibernate;
import pe.gob.mininter.dirandro.model.Arma;

@Repository
public class ArmaHibernateImpl extends BaseHibernateImpl<Arma, Long> implements ArmaHibernate {

	private static final long serialVersionUID = 8722739742699737868L;

	@Autowired
	public ArmaHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}