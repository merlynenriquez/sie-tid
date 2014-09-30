package pe.gob.mininter.dirandro.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.DependenciaHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.Dependencia;
import pe.gob.mininter.dirandro.service.DependenciaService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;

@Service
public class DependenciasServiceImpl extends BaseServiceImpl<Dependencia, Long> implements DependenciaService {
	
	private static final long serialVersionUID = -3483034683930018296L;

	private DependenciaHibernate dependenciaHibernate;
	
	Dependencia dependencia = null;
	
	@Autowired
	protected DependenciasServiceImpl(DependenciaHibernate dependenciaHibernate) {
		super(dependenciaHibernate);		 
		this.dependenciaHibernate = dependenciaHibernate;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Dependencia object) {
		object.validar();
		Busqueda filtro = Busqueda.forClass(Dependencia.class);
		filtro.add(Restrictions.eq("nombre", object.getNombre()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		if (dependenciaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_ENTIDAD_EXISTENTE,
					new Object[] { object.getNombre() });
		}
		dependenciaHibernate.actualizar(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Dependencia object) {		
		object.validar();
		Busqueda filtro = Busqueda.forClass(Dependencia.class);
		filtro.add(Restrictions.eq("nombre", object.getNombre()));
		if (dependenciaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_ENTIDAD_EXISTENTE,
					new Object[] { object.getNombre() });
		}
		super.crear(object);
	}

	public List<Dependencia> buscar(Dependencia dependencia){
		Busqueda filtro = Busqueda.forClass(Dependencia.class);
		
		if (dependencia!=null){
			if (dependencia.getId() != null) {
				filtro.add(Restrictions.eq("id", dependencia.getId()));
			}
			if(dependencia.getNombre()!= null){
				filtro.add(Restrictions.ilike("nombre",dependencia.getNombre(),MatchMode.ANYWHERE));
			}	
			if (dependencia.getPadre() != null) {
				filtro.createAlias("padre", "pa");
				filtro.add(Restrictions.eq("pa.id", dependencia.getPadre().getId()));
			}
			if( dependencia.getEstado()!=null ){
				filtro.createAlias("estado", "e");
				filtro.add(Restrictions.eq("e.id", dependencia.getEstado().getId()));
			}
		}
		
		filtro.addOrder(Order.asc("id"));
		filtro.addOrder(Order.asc("padre"));
		return dependenciaHibernate.buscar(filtro);
	}

	@Override
	public Map<String, List<Dependencia>> listarDependencias() {
		Busqueda filtro = Busqueda.forClass(Dependencia.class);
		filtro.addOrder(Order.asc("nombre"));		
		List<Dependencia> dependencias = dependenciaHibernate.buscar(filtro);
		return HarecUtil.ordenarDependencias(dependencias);
	}

	@Override
	public Map<String, List<Dependencia>> filtrarDependencias(List<Dependencia> lstDependencias) {
		return HarecUtil.ordenarDependencias(lstDependencias);
	}

	@Override
	public List<Dependencia> buscarPadreHijos(Dependencia dependencia) {
		List<Dependencia> lstDependencias = null;
		
		Dependencia dependenciaHijo = null;
		dependenciaHijo = new Dependencia();
		dependenciaHijo.setPadre(dependencia);
		
		lstDependencias = buscar(dependenciaHijo);
		
		Map<String, Dependencia> map = new HashMap<String, Dependencia>();
		
		for (Dependencia beanDependencia : lstDependencias) {
			map.put(beanDependencia.getId().toString(), beanDependencia);
			if (beanDependencia.getPadre() != null) {
				if (beanDependencia.getPadre().getId() != null) {
					
					if(map.get( beanDependencia.getPadre().getId().toString() ) == null){
						getPadreRecursivo(beanDependencia.getPadre().getId(), map);
					}
				}
			}
		}
		List<Dependencia> values = new ArrayList<Dependencia>(map.values());
		 
		return values;
	}
	
	/**
	 * Listado de los Hijos de los padres de la tabla dependencia
	 */
	@Override
	public List<Dependencia> buscarHijos(Dependencia dependencia) {
		Dependencia dependenciaHijo = null;
		dependenciaHijo = new Dependencia();
		dependenciaHijo.setPadre(dependencia);
		
		return buscar(dependenciaHijo);
	}
	
	public Dependencia getPadreRecursivo( Long idPadre , Map<String, Dependencia> map ){
		Dependencia testDependencia = dependenciaHibernate.obtener(idPadre);
		map.put(testDependencia.getId().toString(), testDependencia);		
		if( testDependencia.getPadre()!=null && testDependencia.getPadre().getId()!=null ){
			return getPadreRecursivo(testDependencia.getPadre().getId(), map);
		}else{
			return testDependencia;
		}	
	}	

	@Override
	public Dependencia buscarPadre(Long id) {
		List<Dependencia> lstDependencias = buscar(dependencia);
		Dependencia dep = lstDependencias.get(0);
		
		if (dep.getPadre() != null) {
			if(dep.getPadre().getId() != null){
				dep = buscarPadre(dep.getPadre().getId());
			}
			return dep;
			
		}else {
			return lstDependencias.get(0);
		}
	}

	@Override
	public List<Dependencia> buscarPadres() {
		Busqueda filtro = Busqueda.forClass(Dependencia.class);
		filtro.add(Restrictions.isNull("padre"));
		return dependenciaHibernate.buscar(filtro);
	}
}
