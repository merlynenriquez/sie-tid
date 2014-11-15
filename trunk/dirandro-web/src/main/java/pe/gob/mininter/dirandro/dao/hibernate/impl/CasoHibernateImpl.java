package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.CasoHibernate;
import pe.gob.mininter.dirandro.model.Caso;

@Repository
public class CasoHibernateImpl extends BaseHibernateImpl<Caso, Long> implements CasoHibernate {

	private static final long serialVersionUID = 8722739742699737868L;

	@Autowired
	public CasoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}