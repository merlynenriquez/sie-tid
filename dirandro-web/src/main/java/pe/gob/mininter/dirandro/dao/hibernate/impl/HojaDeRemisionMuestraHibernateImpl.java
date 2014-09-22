package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.HojaDeRemisionMuestraHibernate;
import pe.gob.mininter.dirandro.model.HojaremisionMuestra;

@Repository
public class HojaDeRemisionMuestraHibernateImpl extends BaseHibernateImpl<HojaremisionMuestra, Long> implements HojaDeRemisionMuestraHibernate {
	
	private static final long serialVersionUID = 4680088614350992816L;

	@Autowired
	public HojaDeRemisionMuestraHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
}
