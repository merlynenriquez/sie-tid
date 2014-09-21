package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.NoIdentificadoHibernate;
import pe.gob.mininter.dirandro.model.NoIdentificado;

@Repository
public class NoIdentificadoHibernateImpl extends BaseHibernateImpl<NoIdentificado, Long> implements NoIdentificadoHibernate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5455554061156442887L;

	@Autowired
	public NoIdentificadoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
}
