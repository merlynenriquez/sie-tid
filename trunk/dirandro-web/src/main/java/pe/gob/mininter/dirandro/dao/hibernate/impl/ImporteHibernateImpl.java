package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.ImporteHibernate;
import pe.gob.mininter.dirandro.model.Importe;

@Repository
public class ImporteHibernateImpl extends BaseHibernateImpl<Importe, Long> implements ImporteHibernate {

	private static final long serialVersionUID = -5555811715970141140L;

	@Autowired
	public ImporteHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}