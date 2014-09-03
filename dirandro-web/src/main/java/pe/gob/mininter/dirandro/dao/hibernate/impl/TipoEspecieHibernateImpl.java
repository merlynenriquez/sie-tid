package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.TipoEspecieHibernate;
import pe.gob.mininter.dirandro.model.TipoEspecie;

@Repository
public class TipoEspecieHibernateImpl extends BaseHibernateImpl<TipoEspecie, Long> implements TipoEspecieHibernate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9110153770100029328L;
	
	@Autowired
	public TipoEspecieHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
