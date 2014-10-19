package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.PericiaHibernate;
import pe.gob.mininter.dirandro.model.Pericia;

@Repository
public class PericiaHibernateImpl extends BaseHibernateImpl<Pericia, Long> implements PericiaHibernate {

	private static final long serialVersionUID = 8722739742699737868L;

	@Autowired
	public PericiaHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}