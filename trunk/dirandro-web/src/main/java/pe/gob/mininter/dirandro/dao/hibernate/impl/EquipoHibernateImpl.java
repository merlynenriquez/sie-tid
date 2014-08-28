package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.EquipoHibernate;
import pe.gob.mininter.dirandro.model.Equipo;

@Repository
public class EquipoHibernateImpl extends BaseHibernateImpl<Equipo, Long> implements EquipoHibernate{
	
	private static final long serialVersionUID = 5854209826094075952L;

	@Autowired
	public EquipoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
