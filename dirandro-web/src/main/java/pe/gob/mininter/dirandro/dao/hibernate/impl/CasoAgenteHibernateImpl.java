package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.CasoAgenteHibernate;
import pe.gob.mininter.dirandro.model.DetCasoAgente;

@Repository
public class CasoAgenteHibernateImpl extends BaseHibernateImpl<DetCasoAgente, Long> implements CasoAgenteHibernate {

	private static final long serialVersionUID = 8722739742699737868L;

	@Autowired
	public CasoAgenteHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}