package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.UsuarioHibernate;
import pe.gob.mininter.dirandro.model.Usuario;

@Repository
public class UsuarioHibernateImpl extends BaseHibernateImpl<Usuario, Long>
		implements UsuarioHibernate {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5705020726314524566L;

	@Autowired
	public UsuarioHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
}
