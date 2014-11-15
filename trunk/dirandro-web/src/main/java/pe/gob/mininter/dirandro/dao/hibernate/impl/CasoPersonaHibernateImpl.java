package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.CasoPersonaHibernate;
import pe.gob.mininter.dirandro.model.DetCasoPersona;

@Repository
public class CasoPersonaHibernateImpl extends BaseHibernateImpl<DetCasoPersona, Long> implements CasoPersonaHibernate {

	private static final long serialVersionUID = 8722739742699737868L;

	@Autowired
	public CasoPersonaHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}