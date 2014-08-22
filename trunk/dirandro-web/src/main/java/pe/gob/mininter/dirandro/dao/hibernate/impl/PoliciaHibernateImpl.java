package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.PoliciaHibernate;
import pe.gob.mininter.dirandro.model.Policia;

@Repository
public class PoliciaHibernateImpl extends BaseHibernateImpl<Policia, Long> implements PoliciaHibernate{
	
	private static final long serialVersionUID = 3549627759742192812L;

	@Autowired
	public PoliciaHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
