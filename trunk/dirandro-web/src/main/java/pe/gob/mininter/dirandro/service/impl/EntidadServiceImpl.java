//CIS 2014-08-17

package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.EntidadHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.Entidad;
import pe.gob.mininter.dirandro.service.EntidadService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Service
public class EntidadServiceImpl extends BaseServiceImpl<Entidad, Long> implements EntidadService {

	private static final long serialVersionUID = -2615092658998593825L;

	private EntidadHibernate entidadHibernate;
	
	@Autowired
	public EntidadServiceImpl(EntidadHibernate entidadHibernate) {
		super(entidadHibernate);
		this.entidadHibernate = entidadHibernate;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Entidad object) {		
		Busqueda filtro = Busqueda.forClass(Entidad.class);
		filtro.add(Restrictions.eq("nombre", object.getNombre()));
		if (entidadHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_ENTIDAD_EXISTENTE,
					new Object[] { object.getNombre() });
		}
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Entidad object) {
		Busqueda filtro = Busqueda.forClass(Entidad.class);
		filtro.add(Restrictions.eq("nombre", object.getNombre()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		if (entidadHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_ENTIDAD_EXISTENTE,
					new Object[] { object.getNombre() });
		}
		super.actualizar(object);
	}

	@Override
	public List<Entidad> buscar(Entidad entidad) {
		
		Busqueda filtro = Busqueda.forClass(Entidad.class);
		filtro.createAlias("tipo", "t");
		
		if (entidad != null) {
		
			if (entidad.getTipo()!= null) {				
				if (entidad.getTipo().getNombre()!= null){ 
					filtro.add(Restrictions.ilike("t.nombre", entidad.getTipo().getNombre(), MatchMode.ANYWHERE));
				}
			
			}
			if (entidad.getNombre()!= null) {
				filtro.add(Restrictions.ilike("nombre",entidad.getNombre(), MatchMode.ANYWHERE));
			}
			if (entidad.getDistrito()!= null) {
				filtro.createAlias("distrito", "d");
				filtro.add(Restrictions.ilike("d.nombre",entidad.getDistrito().getNombre(), MatchMode.ANYWHERE));
			}
			if (entidad.getDirtepol()!= null) {
				filtro.add(Restrictions.ilike("dirtepol",entidad.getDirtepol().toString(), MatchMode.ANYWHERE));
			}
			if (entidad.getCorreo()!= null) {
				filtro.add(Restrictions.ilike("correo",entidad.getCorreo(), MatchMode.ANYWHERE));
			}
			if (entidad.getTelefono()!= null) {
				filtro.add(Restrictions.ilike("telefono",entidad.getTelefono(), MatchMode.ANYWHERE));
			}
		}		
		
		filtro.setFirstResult(0);
		filtro.setMaxResults(500);
		filtro.addOrder(Order.asc("t.nombre"));
		filtro.addOrder(Order.asc("nombre"));
		
		return entidadHibernate.buscar(filtro);		
	}
}
