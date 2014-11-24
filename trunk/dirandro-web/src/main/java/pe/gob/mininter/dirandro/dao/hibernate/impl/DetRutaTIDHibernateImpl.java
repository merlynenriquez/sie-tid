package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.DetRutaTIDHibernate;
import pe.gob.mininter.dirandro.model.DetIntRuta;

@Repository
@SuppressWarnings("serial")
public class DetRutaTIDHibernateImpl extends BaseHibernateImpl<DetIntRuta, Long> implements DetRutaTIDHibernate {

	@Autowired
	public DetRutaTIDHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
