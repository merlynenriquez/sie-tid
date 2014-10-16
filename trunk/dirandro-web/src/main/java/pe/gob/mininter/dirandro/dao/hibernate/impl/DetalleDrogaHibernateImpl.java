package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.DetalleDrogaHibernate;
import pe.gob.mininter.dirandro.model.DetDroga;

@Repository
public class DetalleDrogaHibernateImpl extends BaseHibernateImpl<DetDroga, Long> implements DetalleDrogaHibernate{

	private static final long serialVersionUID = 4915147389295246117L;

	@Autowired
	public DetalleDrogaHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
