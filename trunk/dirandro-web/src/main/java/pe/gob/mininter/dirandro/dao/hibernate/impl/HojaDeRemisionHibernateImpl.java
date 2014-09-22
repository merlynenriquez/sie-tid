package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.HojaDeRemisionHibernate;
import pe.gob.mininter.dirandro.model.Hojaremision;

@Repository
public class HojaDeRemisionHibernateImpl extends BaseHibernateImpl<Hojaremision, Long> implements HojaDeRemisionHibernate {
	
	private static final long serialVersionUID = -5993937963981155621L;

	@Autowired
	public HojaDeRemisionHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
}