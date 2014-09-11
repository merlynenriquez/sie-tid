package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.MunicionHibernate;
import pe.gob.mininter.dirandro.model.Municion;

@Repository
public class MunicionHibernateImpl extends BaseHibernateImpl<Municion, Long> implements MunicionHibernate{
	
	private static final long serialVersionUID = -4798638963320075122L;

	@Autowired
	public MunicionHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
