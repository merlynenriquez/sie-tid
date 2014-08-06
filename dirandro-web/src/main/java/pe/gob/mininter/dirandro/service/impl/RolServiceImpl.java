package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.RolHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.Rol;
import pe.gob.mininter.dirandro.service.RolService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Service
public class RolServiceImpl extends BaseServiceImpl<Rol, Long>
		implements RolService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8064866370340152994L;
	
	private RolHibernate rolHibernate;
	
	@Autowired
	public RolServiceImpl(RolHibernate rolHibernate) {
		super(rolHibernate);
		this.rolHibernate = rolHibernate;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Rol object) {
		Busqueda filtro = Busqueda.forClass(Rol.class);
		filtro.add(Restrictions.eq("codigo", object.getCodigo()));
		if (rolHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_ROL_EXISTENTE,
					new Object[] { object.getCodigo() });
		}
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Rol object) {
		object.validar();
		Busqueda filtro = Busqueda.forClass(Rol.class);
		filtro.add(Restrictions.eq("codigo", object.getCodigo()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		if (rolHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_ROL_EXISTENTE,
					new Object[] { object.getCodigo() });
		}
		rolHibernate.actualizar(object);
	}

	@Override
	public List<Rol> buscar(Rol rol) {
		Busqueda filtro = Busqueda.forClass(Rol.class);
		if (rol != null) {
			if (rol.getId() != null) {
				filtro.add(Restrictions.ilike("id",
						"%" + rol.getId() + "%"));
			}
			if (rol.getCodigo() != null) {
				filtro.add(Restrictions.ilike("codigo",
						"%" + rol.getCodigo() + "%"));
			}
			if (rol.getNombre() != null) {
				filtro.add(Restrictions.ilike("nombre",
						"%" + rol.getNombre() + "%"));
			}
			if (rol.getPadre() != null
					&& rol.getPadre().getNombre() != null) {
				filtro.createAlias("padre", "p");
				filtro.add(Restrictions.ilike("p.nombre", "%"
						+ rol.getPadre().getNombre() + "%"));
			}

		}
		filtro.addOrder(Order.asc("id"));
		return rolHibernate.buscar(filtro);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void eliminarXId(Long id) {
		Busqueda filtroR = Busqueda.forClass(Rol.class);
		filtroR.createAlias("padre", "p");
		filtroR.add(Restrictions.eq("p.id",id));
		if (rolHibernate.buscar(filtroR).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_ROL_ES_PADRE,
					new Object[] {});
		}
		/*Busqueda filtroM = Busqueda.forClass(Membresia.class);
		filtroM.createAlias("rol", "r");
		filtroM.add(Restrictions.eq("r.id",id));
		membresiaHibernate.eliminarTodos(membresiaHibernate.buscar(filtroM));*/
		rolHibernate.eliminarXId(id);
	}

	@Override
	public List<Rol> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
