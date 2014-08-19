package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.DepartamentoHibernate;
import pe.gob.mininter.dirandro.model.Departamento;


@Repository
public class DepartamentoHibernateImpl extends BaseHibernateImpl<Departamento, Long> implements DepartamentoHibernate {
	
	private static final long serialVersionUID = -1143632255799838731L;

	@Autowired
	public DepartamentoHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
