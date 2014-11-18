package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.GremioHibernate;
import pe.gob.mininter.dirandro.model.GremioCocalero;

@Repository
public class GremioHibernateImpl extends BaseHibernateImpl<GremioCocalero, Long> implements GremioHibernate {

	private static final long serialVersionUID = 95083142886419802L;

	@Autowired
	public GremioHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}