package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.EmpresaHibernate;
import pe.gob.mininter.dirandro.model.Empresa;

@Repository
public class EmpresaHibernateImpl extends BaseHibernateImpl<Empresa, Long> implements EmpresaHibernate{
	
	private static final long serialVersionUID = 3549627759742192812L;

	@Autowired
	public EmpresaHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
