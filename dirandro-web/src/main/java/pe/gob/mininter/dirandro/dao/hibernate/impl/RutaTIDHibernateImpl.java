package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.RutaTIDHibernate;
import pe.gob.mininter.dirandro.model.RutaTid;

@Repository
public class RutaTIDHibernateImpl extends BaseHibernateImpl<RutaTid, Long> implements RutaTIDHibernate {

	private static final long serialVersionUID = -8881052889223123674L;

	@Autowired
	public RutaTIDHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
