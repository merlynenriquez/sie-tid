package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.SituacionProcesoHibernate;
import pe.gob.mininter.dirandro.model.SituacionProceso;

@Repository
public class SituacionProcesoHibernateImpl extends BaseHibernateImpl<SituacionProceso, Long> implements SituacionProcesoHibernate {

	private static final long serialVersionUID = -8732601810781607133L;

	@Autowired
	public SituacionProcesoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}