package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.OrganoExhortoHibernate;
import pe.gob.mininter.dirandro.model.OrgExhorto;

@Repository
@SuppressWarnings("serial")
public class OtganoExhortoHibernateImpl extends BaseHibernateImpl<OrgExhorto, Long> implements OrganoExhortoHibernate {

	@Autowired
	public OtganoExhortoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
