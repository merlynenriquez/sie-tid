package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.DocumentoHibernate;
import pe.gob.mininter.dirandro.model.Documento;

@Repository
public class DocumentoHibernateImpl extends BaseHibernateImpl<Documento, Long> implements DocumentoHibernate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2796034393726299707L;
	
	@Autowired
	public DocumentoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
