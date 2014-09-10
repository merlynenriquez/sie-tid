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

import pe.gob.mininter.dirandro.dao.hibernate.DelitoHibernate;
import pe.gob.mininter.dirandro.model.Delito;
import pe.gob.mininter.dirandro.service.DelitoService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.HarecUtil;

@Service
public class DelitoServiceImpl extends BaseServiceImpl<Delito, Long> implements DelitoService {

	private static final long serialVersionUID = 6536710495404108065L;

	private DelitoHibernate delitoHibernate;
	
	@Autowired
	public DelitoServiceImpl(DelitoHibernate delitoHibernate) {
		super(delitoHibernate);
		this.delitoHibernate = delitoHibernate;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Delito object) {
		/*Busqueda filtro = Busqueda.forClass(Delito.class);
		filtro.add(Restrictions.eq("codigo", object.getCodigo()));
		//filtro.
		//filtro.add(Comment.START_DOCUMENT);
		
		//ProjectionList proList = Projections.projectionList();		
		//proList.add(Projections.sqlProjection("/*+INDEX_DESC(this_ MY_INDEX_NAME) 1 as MYHINT", new String[]{}, new Type[]{}));
		//proList.add(Projections.property("field1"));
		
		/*if (delitoHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_VALOR_EXISTENTE, new Object[] { object.getCodigo() });
		}*/
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Delito object) {
		//object.validar();
		/*Busqueda filtro = Busqueda.forClass(Delito.class);
		filtro.add(Restrictions.eq("codigo", object.getCodigo()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		if (delitoHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_VALOR_EXISTENTE,
					new Object[] { object.getCodigo() });
		}*/
		delitoHibernate.actualizar(object);
	}	

	@Override
	public List<Delito> buscar(Delito delito) {
		Busqueda filtro = Busqueda.forClass(Delito.class);
		//filtro.setComment("+ RICHS_SECRET_HINT"); Averiguar implementacion de Hints
		filtro.setFirstResult(0);
		filtro.setMaxResults(100);
		
		if (delito!=null){
			if (delito.getId() != null) {
				filtro.add(Restrictions.eq("id", delito.getId()));
			}
			if(delito.getNombre()!= null){
				filtro.add(Restrictions.ilike("nombre",delito.getNombre(),MatchMode.ANYWHERE));
			}	
			if (delito.getPadre() != null && delito.getPadre().getId()  != null) {
				filtro.createAlias("padre", "pa");
				filtro.add(Restrictions.eq("pa.id", delito.getPadre().getId()));
			}
			if (delito.getPadre() != null) {
				filtro.add(Restrictions.eq("padre", delito.getPadre()));
			}
			
		}
		
		filtro.addOrder(Order.asc("id"));
		filtro.addOrder(Order.asc("padre"));
		return delitoHibernate.buscar(filtro);
	}
	
	@Override
	public List<Delito> buscarPadreHijos(Delito delito) {
		List<Delito> lstDelitos = null;
		
		Delito delitoHijo = null;
		delitoHijo = new Delito();
		delitoHijo.setPadre(delito);
		
		lstDelitos = buscar(delito);
		Map<String, Delito> map = new HashMap<String, Delito>();
		
		for (Delito beanDelito : lstDelitos) {
			map.put(beanDelito.getId().toString(), beanDelito);
			if (beanDelito.getPadre() != null) {
				if (beanDelito.getPadre().getId() != null) {
					
					if(map.get( beanDelito.getPadre().getId().toString() ) == null){
						getPAdreRecursivo(beanDelito.getPadre().getId(), map);
					}
				}
			}
		}
		List<Delito> values = new ArrayList<Delito>(map.values());
		 
		return values;
	}

	public Delito getPAdreRecursivo( Long idPAdre , Map<String, Delito> map ){
		Delito testDelito = buscarDelito( idPAdre );
		map.put(testDelito.getId().toString(), testDelito);
		if( testDelito.getPadre()!=null && testDelito.getPadre().getId()!=null ){
			return getPAdreRecursivo(testDelito.getPadre().getId(), map);
		}else{
			return testDelito;
		}
			
	}
	
	@Override
	public Delito buscarDelito(Long id){
		Delito delito = new Delito();
		delito.setId(id);
		List<Delito> lstDelitos = buscar(delito);
		
		return lstDelitos.get(0);
	}	

	@Override
	public Map<String, List<Delito>> filtrarDelitos(List<Delito> lstDelitos) {
		return HarecUtil.ordenarDelitos(lstDelitos);
	}

	@Override
	public Map<String, List<Delito>> listarDelitos() {
		Busqueda filtro = Busqueda.forClass(Delito.class);
		
		filtro.addOrder(Order.asc("id"));
		filtro.addOrder(Order.asc("padre"));
		
		List<Delito> delitos = delitoHibernate.buscar(filtro);
		return HarecUtil.ordenarDelitos(delitos);
	}

	@Override
	public List<Delito> buscarHijos(Delito delito) {
		Busqueda filtro = Busqueda.forClass(Delito.class);
		
		if (delito!=null){
			if (delito.getId() != null) {
				filtro.add(Restrictions.eq("padre.id", delito.getId()));
			}
		}
		
		List<Delito> delitos = delitoHibernate.buscar(filtro);
		return delitos;
	}

	@Override
	public List<Delito> buscarPadres() {
		Busqueda filtro = Busqueda.forClass(Delito.class);
		filtro.add(Restrictions.isNull("padre"));
		List<Delito> delitos = delitoHibernate.buscar(filtro);
		return delitos;
	}	

	@Override
	public Delito buscarPadre(Delito delito) {
		
		if (delito.getPadre() != null) {
			logger.debug("test");
			if(delito.getPadre().getId() != null){
				logger.debug("test2");
				delito = delitoHibernate.obtener(delito.getPadre().getId());
			}
		}
		System.out.println(delito.getNombre());
		return delito;
	}

}
