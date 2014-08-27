package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.CentroPobladoHibernate;
import pe.gob.mininter.dirandro.model.CentroPoblado;

@Repository
public class CentroPobladoHibernateImpl extends BaseHibernateImpl<CentroPoblado, Long> implements CentroPobladoHibernate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1476711088627499562L;
	
	@Autowired
	public CentroPobladoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
