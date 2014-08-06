package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.ValorHibernate;
import pe.gob.mininter.dirandro.model.Valor;

@Repository
public class ValorHibernateImpl extends BaseHibernateImpl<Valor, Long> implements ValorHibernate {

	private static final long serialVersionUID = -8732601810781607133L;

	@Autowired
	public ValorHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}