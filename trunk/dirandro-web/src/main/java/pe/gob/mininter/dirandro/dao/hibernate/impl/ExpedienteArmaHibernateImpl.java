package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteArmaHibernate;
import pe.gob.mininter.dirandro.model.DetPerArmExp;

@Repository
public class ExpedienteArmaHibernateImpl extends BaseHibernateImpl<DetPerArmExp, Long> implements ExpedienteArmaHibernate{
	
	private static final long serialVersionUID = 3549627759742192812L;

	@Autowired
	public ExpedienteArmaHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
