package pe.gob.mininter.dirandro.dao.hibernate.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.BaseHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Transactional
public abstract class BaseHibernateImpl <Entidad extends Serializable, TipoLlave extends Serializable> extends HibernateTransactionManager implements BaseHibernate<Entidad, TipoLlave> {

	private static final long serialVersionUID = -553083254621919950L;
			
	protected static final Log logger = LogFactory.getLog(HibernateTransactionManager.class);
	
	protected Class<Entidad> domainClass;
	
	@Autowired
	public SessionFactory sessionFactory;
	
    /*public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }*/

	protected Session getSession() {
    	return sessionFactory.getCurrentSession();
    }
	
	@SuppressWarnings("unchecked")
	public BaseHibernateImpl() {
		super();
		this.domainClass = (Class<Entidad>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Entidad obtener(TipoLlave id) {
		return (Entidad) getSession().get(domainClass, id);
	}

	@Override
	public void actualizar(Entidad t) {
		getSession().update(t);
		getSession().flush();
	}

	@Override
	public void crear(Entidad t) {
		getSession().save(t);
		getSession().flush();
	}
	
	@Override
	public void grabarTodos(List<Entidad> list){	
		for (Entidad entidad : list){
			getSession().save(entidad);
		}
	}

	@Override
	public void eliminar(Entidad t) {
		try {
			getSession().delete(t);
			getSession().flush();
		} catch (DataIntegrityViolationException e) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_ELIMINAR_GENERICO,null,e);
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<Entidad> obtenerTodos() {
		Query query = getSession().createQuery("from "+ domainClass.getName());
        return query.list();
	}

	@Override
	public void eliminarXId(TipoLlave id) {
		try {
			Object obj = obtener(id);
			getSession().delete(obj);
			getSession().flush();
		} catch (DataIntegrityViolationException e) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_ELIMINAR_GENERICO,null,e);
		}
	}
		
	@Override
	public void eliminarTodos(List<Entidad> list) {
		getSession().delete(list);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Entidad> buscar(final Busqueda filtro) {
        Criteria busqueda = filtro.getExecutableCriteria(getSession());
		busqueda.setFirstResult(((Busqueda) filtro).getFirstResult());
		if (filtro.getMaxResults() > 0) {
			busqueda.setMaxResults(((Busqueda) filtro).getMaxResults());
		}
		busqueda.setReadOnly(true);
		return (List<Entidad>) busqueda.list();
	}
	
	@Override
	public boolean contiene(TipoLlave tipoLlave) {
		Entidad object = obtener(tipoLlave);
		return object != null;
	};

}