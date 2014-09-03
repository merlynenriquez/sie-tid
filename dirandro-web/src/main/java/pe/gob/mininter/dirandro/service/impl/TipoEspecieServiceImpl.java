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

import pe.gob.mininter.dirandro.dao.hibernate.TipoEspecieHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.TipoEspecie;
import pe.gob.mininter.dirandro.service.TipoEspecieService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;

@Service
public class TipoEspecieServiceImpl extends BaseServiceImpl<TipoEspecie, Long> implements TipoEspecieService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2601419480887715709L;
	
	private TipoEspecieHibernate TipoEspecieHibernate;

	@Autowired
	public TipoEspecieServiceImpl(TipoEspecieHibernate TipoEspecieHibernate) {
		super(TipoEspecieHibernate);
		this.TipoEspecieHibernate = TipoEspecieHibernate;
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(TipoEspecie tipoEspecie) {
		tipoEspecie.validar();
		Busqueda filtro = Busqueda.forClass(TipoEspecie.class);
		/*filtro.add(Restrictions.eq("nombres", object.getNombres()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		/*if (PoliciaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_Policia_EXISTENTE,
					new Object[] { object.getNombres() });
		}*/
		if(tipoEspecie.getPadre()!=null && tipoEspecie.getPadre().getId()!=null){
			if(tipoEspecie.getId().equals(tipoEspecie.getPadre().getId())){
				throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_BUCLE_PADRE, new Object[] { tipoEspecie.getNombre() });
			}
		}
		TipoEspecieHibernate.actualizar(tipoEspecie);
	}
	
	@Override
	public List<TipoEspecie> listarTipoEspecie() {
		Busqueda filtro = Busqueda.forClass(TipoEspecie.class);		
		return TipoEspecieHibernate.buscar(filtro);
	}	

	@Override
	public Map<String, List<TipoEspecie>> listarTipoEspecieMap(){
		Busqueda filtro = Busqueda.forClass(TipoEspecie.class);
		
		filtro.addOrder(Order.asc("id"));
		filtro.addOrder(Order.asc("padre"));
		
		List<TipoEspecie> tipos = TipoEspecieHibernate.buscar(filtro);
		return HarecUtil.ordenarTipoEspecie(tipos);
	}

	@Override
	public Map<String, List<TipoEspecie>> filtrarTipoEspecie(List<TipoEspecie> lstTipoEspecie) {
		return HarecUtil.ordenarTipoEspecie(lstTipoEspecie);
	}
	
	@Override
	public List<TipoEspecie> buscarPadreHijos(TipoEspecie TipoEspecie) {
		List<TipoEspecie> lstDelitos = null;
		
		TipoEspecie delitoHijo = null;
		delitoHijo = new TipoEspecie();
		delitoHijo.setPadre(TipoEspecie);
		
		lstDelitos = buscar(TipoEspecie);
		Map<String, TipoEspecie> map = new HashMap<String, TipoEspecie>();
		
		for (TipoEspecie beanDelito : lstDelitos) {
			map.put(beanDelito.getId().toString(), beanDelito);
			if (beanDelito.getPadre() != null) {
				if (beanDelito.getPadre().getId() != null) {
					
					if(map.get( beanDelito.getPadre().getId().toString() ) == null){
						getPAdreRecursivo(beanDelito.getPadre().getId(), map);
					}
				}
			}
		}
		List<TipoEspecie> values = new ArrayList<TipoEspecie>(map.values());
		 
		return values;
	}

	public TipoEspecie getPAdreRecursivo( Long idPAdre , Map<String, TipoEspecie> map ){
		TipoEspecie testDelito = buscarTipoEspecie( idPAdre );
		map.put(testDelito.getId().toString(), testDelito);
		if( testDelito.getPadre()!=null && testDelito.getPadre().getId()!=null ){
			return getPAdreRecursivo(testDelito.getPadre().getId(), map);
		}else{
			return testDelito;
		}
	}
	
	@Override
	public List<TipoEspecie> buscar(TipoEspecie delito) {
		Busqueda filtro = Busqueda.forClass(TipoEspecie.class);
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
		return TipoEspecieHibernate.buscar(filtro);
	}

	@Override
	public TipoEspecie buscarTipoEspecie(Long id){
		TipoEspecie delito = new TipoEspecie();
		delito.setId(id);
		List<TipoEspecie> lstDelitos = buscar(delito);
		return lstDelitos.get(0);
	}	

}
