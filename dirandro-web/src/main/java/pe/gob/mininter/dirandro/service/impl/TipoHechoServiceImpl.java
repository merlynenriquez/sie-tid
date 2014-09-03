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

import pe.gob.mininter.dirandro.dao.hibernate.TipoHechoHibernate;
import pe.gob.mininter.dirandro.model.TipoHecho;
import pe.gob.mininter.dirandro.service.TipoHechoService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.HarecUtil;

@Service
public class TipoHechoServiceImpl extends BaseServiceImpl<TipoHecho, Long> implements TipoHechoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2601419480887715709L;
	
	private TipoHechoHibernate tipoHechoHibernate;

	@Autowired
	public TipoHechoServiceImpl(TipoHechoHibernate tipoHechoHibernate) {
		super(tipoHechoHibernate);
		this.tipoHechoHibernate = tipoHechoHibernate;
	}

	@Override
	public List<TipoHecho> listarTipoHecho() {
		Busqueda filtro = Busqueda.forClass(TipoHecho.class);		
		return tipoHechoHibernate.buscar(filtro);
	}	

	@Override
	public Map<String, List<TipoHecho>> listarTipoHechoMap(){
		Busqueda filtro = Busqueda.forClass(TipoHecho.class);
		
		filtro.addOrder(Order.asc("id"));
		filtro.addOrder(Order.asc("padre"));
		
		List<TipoHecho> tipos = tipoHechoHibernate.buscar(filtro);
		return HarecUtil.ordenarTipoHechos(tipos);
	}

	@Override
	public Map<String, List<TipoHecho>> filtrarTipoHecho(List<TipoHecho> lstTipoHecho) {
		return HarecUtil.ordenarTipoHechos(lstTipoHecho);
	}
	
	@Override
	public List<TipoHecho> buscarPadreHijos(TipoHecho tipoHecho) {
		List<TipoHecho> lstDelitos = null;
		
		TipoHecho delitoHijo = null;
		delitoHijo = new TipoHecho();
		delitoHijo.setPadre(tipoHecho);
		
		lstDelitos = buscar(tipoHecho);
		Map<String, TipoHecho> map = new HashMap<String, TipoHecho>();
		
		for (TipoHecho beanDelito : lstDelitos) {
			map.put(beanDelito.getId().toString(), beanDelito);
			if (beanDelito.getPadre() != null) {
				if (beanDelito.getPadre().getId() != null) {
					
					if(map.get( beanDelito.getPadre().getId().toString() ) == null){
						getPAdreRecursivo(beanDelito.getPadre().getId(), map);
					}
				}
			}
		}
		List<TipoHecho> values = new ArrayList<TipoHecho>(map.values());
		 
		return values;
	}

	public TipoHecho getPAdreRecursivo( Long idPAdre , Map<String, TipoHecho> map ){
		TipoHecho testDelito = buscarTipoHecho( idPAdre );
		map.put(testDelito.getId().toString(), testDelito);
		if( testDelito.getPadre()!=null && testDelito.getPadre().getId()!=null ){
			return getPAdreRecursivo(testDelito.getPadre().getId(), map);
		}else{
			return testDelito;
		}
	}
	
	@Override
	public List<TipoHecho> buscar(TipoHecho delito) {
		Busqueda filtro = Busqueda.forClass(TipoHecho.class);
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
		return tipoHechoHibernate.buscar(filtro);
	}

	@Override
	public TipoHecho buscarTipoHecho(Long id){
		TipoHecho delito = new TipoHecho();
		delito.setId(id);
		List<TipoHecho> lstDelitos = buscar(delito);
		return lstDelitos.get(0);
	}	

}
