package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.InformeHibernate;
import pe.gob.mininter.dirandro.model.Informe;

@Repository
public class InformeHibernateImpl extends BaseHibernateImpl<Informe, Long> implements InformeHibernate{
	
	private static final long serialVersionUID = 3549627759742192812L;

	@Autowired
	public InformeHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
