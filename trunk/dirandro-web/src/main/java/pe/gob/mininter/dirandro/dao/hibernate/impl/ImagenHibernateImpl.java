package pe.gob.mininter.dirandro.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.hibernate.ImagenHibernate;
import pe.gob.mininter.dirandro.model.Imagen;


@Repository
public class ImagenHibernateImpl extends BaseHibernateImpl<Imagen, Long> implements ImagenHibernate {

	private static final long serialVersionUID = 6709339760956462700L;

	@Autowired
	public ImagenHibernateImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
}
