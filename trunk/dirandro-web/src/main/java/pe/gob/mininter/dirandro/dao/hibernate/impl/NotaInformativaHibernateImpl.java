package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.NotaInformativaHibernate;
import pe.gob.mininter.dirandro.model.NotaInformativa;
@Repository
public class NotaInformativaHibernateImpl extends BaseHibernateImpl<NotaInformativa, Long>  implements NotaInformativaHibernate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5845853037320983988L;

	@Autowired
	public NotaInformativaHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
