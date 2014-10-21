package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.OrganizacionHibernate;
import pe.gob.mininter.dirandro.model.Organizacion;
import pe.gob.mininter.dirandro.service.OrganizacionService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.HarecUtil;

@Service
public class OrganizacionServiceImpl extends BaseServiceImpl<Organizacion, Long> implements OrganizacionService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2697106645391028183L;
	
	private OrganizacionHibernate organizacionHibernate; 
	
	@Autowired
	public OrganizacionServiceImpl(OrganizacionHibernate organizacionHibernate) {
		super(organizacionHibernate);
		this.organizacionHibernate = organizacionHibernate;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Organizacion object) {
		object.validar();
		Busqueda filtro = Busqueda.forClass(Organizacion.class);
		//filtro.add(Restrictions.eq("nombres", object.getNombres()));
		/*if (PoliciaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_Policia_EXISTENTE,
					new Object[] { object.getNombres() });
		}*/
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Organizacion object) {
		object.validar();
		Busqueda filtro = Busqueda.forClass(Organizacion.class);
		/*filtro.add(Restrictions.eq("nombres", object.getNombres()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		/*if (PoliciaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_Policia_EXISTENTE,
					new Object[] { object.getNombres() });
		}*/
		organizacionHibernate.actualizar(object);
	}

	public Organizacion obtener(Long id){		
		return organizacionHibernate.obtener(id);
	}

	@Override
	public List<Organizacion> buscar(Organizacion organizacion) {
		Busqueda filtro = Busqueda.forClass(Organizacion.class);
		
		if (organizacion != null) {
			if (organizacion.getNombre() != null && organizacion.getNombre() .length() > 0) {
				filtro.add(Restrictions.ilike("nombre", organizacion.getNombre(), MatchMode.ANYWHERE));
			}
			if (organizacion.getZonaOperacion() != null && organizacion.getZonaOperacion().length() > 0) {
				filtro.add(Restrictions.ilike("zonaOperacion", organizacion.getZonaOperacion(), MatchMode.ANYWHERE));
			}
			if (organizacion.getDescripcion()!= null && organizacion.getDescripcion().length() > 0) {
				logger.debug("descripcion " + organizacion.getDescripcion());
				filtro.add(Restrictions.ilike("descripcion", organizacion.getDescripcion(), MatchMode.ANYWHERE));
			}
			if ( !HarecUtil.nullToEmpty( organizacion.getUbicacionActivos()).equals("")) {
				logger.debug("ubicacionActivos " + organizacion.getUbicacionActivos());
				filtro.add(Restrictions.ilike("ubicacionActivos", organizacion.getUbicacionActivos(), MatchMode.ANYWHERE));
			}
			if ( !HarecUtil.nullToEmpty( organizacion.getNroIntegrantes() ).equals("")) {
				logger.debug("nro integ " + organizacion.getNroIntegrantes() );
				filtro.add(Restrictions.ge("nroIntegrantes", organizacion.getNroIntegrantes()));
			}
		}
		return organizacionHibernate.buscar(filtro);		
	}

	@Override
	public List<Organizacion> listarOrganizaciones() {
		Busqueda filtro = Busqueda.forClass(Organizacion.class);		
		filtro.addOrder(Order.asc("nombre")); 
		return organizacionHibernate.buscar(filtro);
	}

	
}
