package pe.gob.mininter.dirandro.service.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.EquipoHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.Equipo;
import pe.gob.mininter.dirandro.service.EquipoService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;

@Service
public class EquipoServiceImpl extends BaseServiceImpl<Equipo, Long> implements EquipoService{

	private static final long serialVersionUID = 8546679032560370500L;
	
	private EquipoHibernate equipoHibernate;
	
	@Autowired
	public EquipoServiceImpl(EquipoHibernate equipoHibernate) {
		super(equipoHibernate);
		this.equipoHibernate = equipoHibernate;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Equipo object) {		
		/*Busqueda filtro = Busqueda.forClass(Equipo.class);
		filtro.add(Restrictions.eq("nombre", object.getNombre()));
		if (equipoHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_ENTIDAD_EXISTENTE,
					new Object[] { object.getNombre() });
		}*/
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Equipo object) {
		Busqueda filtro = Busqueda.forClass(Equipo.class);
		filtro.add(Restrictions.eq("nombre", object.getNombre()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		if (equipoHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_ENTIDAD_EXISTENTE,
					new Object[] { object.getNombre() });
		}
		equipoHibernate.actualizar(object);
	}

	@Override
	public List<Equipo> buscar(Equipo equipo) {
		
		Busqueda filtro = Busqueda.forClass(Equipo.class);
		
		if (equipo != null) {
			if (equipo.getId() != null) 
				filtro.add(Restrictions.ne("id",equipo.getId()));
			
			if(equipo.getCodigo() != null){
				filtro.add(Restrictions.ilike("codigo", equipo.getCodigo().trim(), MatchMode.ANYWHERE));
			}	
			
			if (equipo.getNombre()!= null) 
				filtro.add(Restrictions.ilike("nombre",equipo.getNombre(), MatchMode.ANYWHERE));
			
			if (equipo.getPadre()!= null) {
				if(equipo.getPadre().getId() != null){
					filtro.createAlias("padre", "p");
					filtro.add(Restrictions.eq("p.id",equipo.getPadre().getId()));
				}
			}
			
			
			
			if (equipo.getDependencia() != null){
				filtro.createAlias("dependencia", "d");
				filtro.add(Restrictions.eq("d.id",equipo.getDependencia().getId()));
			}
			
			/*if (equipo.getDependencia() != null){
				if(equipo.getDependencia().getPadre() != null){
					filtro.createAlias("d.padre", "p");					
					filtro.add(Restrictions.ilike("p.abreviatura",equipo.getDependencia().getPadre().getAbreviatura(), MatchMode.ANYWHERE));
				}
			}*/
			
			if (equipo.getDepartamento() != null) {
				if(equipo.getDepartamento().getAbreviatura() != null){
					filtro.add(Restrictions.ilike("d.abreviatura",equipo.getDepartamento().getAbreviatura(), MatchMode.ANYWHERE));
				}
			}
		}	
		
		filtro.addOrder(Order.asc("dependencia"));
		filtro.addOrder(Order.asc("codigo"));
		filtro.addOrder(Order.asc("nombre"));
		
		filtro.createAlias("estado", "e");
		filtro.add(Restrictions.eq("e.codigo", Constante.VALOR.CODIGO.ACTIVO));
		
		return equipoHibernate.buscar(filtro);
	}

	@Override
	public Map<String, List<Equipo>> listarEquipos() {
		Busqueda filtro = Busqueda.forClass(Equipo.class);
		
		filtro.addOrder(Order.asc("dependencia"));
		filtro.addOrder(Order.asc("codigo"));
		filtro.addOrder(Order.asc("nombre"));
		
		filtro.createAlias("estado", "e");
		filtro.add(Restrictions.eq("e.codigo", Constante.VALOR.CODIGO.ACTIVO));
		
		List<Equipo> equipos = equipoHibernate.buscar(filtro);
		
		return HarecUtil.ordenarEquipos(equipos);
		
	}

	@Override
	public Map<String, List<Equipo>> filtrarEquipos(List<Equipo> lstEquipo) {
		return HarecUtil.ordenarEquipos(lstEquipo);
	}
}
