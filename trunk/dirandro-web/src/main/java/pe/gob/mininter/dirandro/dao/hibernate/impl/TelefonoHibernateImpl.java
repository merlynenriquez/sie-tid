package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.TelefonoHibernate;
import pe.gob.mininter.dirandro.model.Telefono;

@Repository
public class TelefonoHibernateImpl extends BaseHibernateImpl<Telefono, Long> implements TelefonoHibernate{
	
	private static final long serialVersionUID = 3579009119754952806L;

	@Autowired
	public TelefonoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
