package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.OrganizacionHibernate;
import pe.gob.mininter.dirandro.model.Organizacion;


@Repository
public class OrganizacionHibernateImpl extends BaseHibernateImpl<Organizacion, Long> implements OrganizacionHibernate{
	
	private static final long serialVersionUID = 3549627759742192812L;

	@Autowired
	public OrganizacionHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
