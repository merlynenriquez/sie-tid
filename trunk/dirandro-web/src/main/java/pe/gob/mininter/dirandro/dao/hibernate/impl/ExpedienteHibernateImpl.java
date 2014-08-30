package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteHibernate;
import pe.gob.mininter.dirandro.model.Expediente;

@Repository
public class ExpedienteHibernateImpl extends BaseHibernateImpl<Expediente, Long> implements ExpedienteHibernate {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1576015974837932896L;
	
	@Autowired
	public ExpedienteHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
