package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.IntegranteHibernate;
import pe.gob.mininter.dirandro.model.Integrante;

@Repository
public class IntegranteHibernateImpl extends BaseHibernateImpl<Integrante, Long> implements IntegranteHibernate  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6450735699315073513L;
	
	@Autowired
	public IntegranteHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
