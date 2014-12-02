package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.NotaAgenteHibernate;
import pe.gob.mininter.dirandro.model.NotaAgente;

@Repository
public class NotaAgenteHibernateImpl extends BaseHibernateImpl<NotaAgente, Long>  implements NotaAgenteHibernate {

	private static final long serialVersionUID = 237951027010116632L;

	@Autowired
	public NotaAgenteHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
