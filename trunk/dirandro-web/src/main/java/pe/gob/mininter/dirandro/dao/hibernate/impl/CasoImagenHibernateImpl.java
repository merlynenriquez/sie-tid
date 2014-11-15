package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.CasoImagenHibernate;
import pe.gob.mininter.dirandro.model.DetCasoImagen;

@Repository
public class CasoImagenHibernateImpl extends BaseHibernateImpl<DetCasoImagen, Long> implements CasoImagenHibernate {

	private static final long serialVersionUID = 8722739742699737868L;

	@Autowired
	public CasoImagenHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}