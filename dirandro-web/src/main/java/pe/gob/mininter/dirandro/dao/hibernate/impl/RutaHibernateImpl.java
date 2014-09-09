package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.RutaHibernate;
import pe.gob.mininter.dirandro.model.Ruta;

@Repository
public class RutaHibernateImpl extends BaseHibernateImpl<Ruta, Long> implements RutaHibernate {
	
	private static final long serialVersionUID = -1143632255799838731L;

	@Autowired
	public RutaHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
