package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.ModeloMarcaHibernate;
import pe.gob.mininter.dirandro.model.ModeloMarca;

@Repository
public class ModeloMarcaHibernateImpl extends BaseHibernateImpl<ModeloMarca, Long> implements ModeloMarcaHibernate{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -709691682080298236L;

	@Autowired
	public ModeloMarcaHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
