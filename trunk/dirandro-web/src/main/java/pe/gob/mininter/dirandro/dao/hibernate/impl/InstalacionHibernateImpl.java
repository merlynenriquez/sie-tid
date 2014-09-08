package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.InstalacionHibernate;
import pe.gob.mininter.dirandro.model.Instalacion;

@Repository
public class InstalacionHibernateImpl extends BaseHibernateImpl<Instalacion, Long> implements InstalacionHibernate {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -454783503379888333L;

	@Autowired
	public InstalacionHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
}
