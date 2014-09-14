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

import pe.gob.mininter.dirandro.dao.hibernate.ModeloMarcaHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.ModeloMarca;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.ModeloMarcaService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;

@Service
public class ModeloMarcaServiceImpl extends BaseServiceImpl<ModeloMarca, Long> implements ModeloMarcaService{
	
	private static final long serialVersionUID = 6898269939441215168L;
	
	private ModeloMarcaHibernate modeloMarcaHibernate;

	@Autowired
	public ModeloMarcaServiceImpl(ModeloMarcaHibernate modeloMarcaHibernate) {
		super(modeloMarcaHibernate);
		this.modeloMarcaHibernate = modeloMarcaHibernate;
	}

	@Override
	public List<ModeloMarca> buscar(ModeloMarca modeloMarca) {
		Busqueda filtro = Busqueda.forClass(ModeloMarca.class);		 
		if (modeloMarca!=null){
			if(modeloMarca.getNombre()!= null ){
				filtro.add(Restrictions.ilike("nombre",modeloMarca.getNombre(),MatchMode.ANYWHERE));
			}
			if (modeloMarca.getPadre() != null) {
				if( modeloMarca.getPadre().getId()  != null){
					filtro.createAlias("padre", "pa");				
					filtro.add(Restrictions.eq("pa.id", modeloMarca.getPadre().getId()));
				}
			}else{
				filtro.add(Restrictions.isNull("padre"));
			}
		}
		filtro.addOrder(Order.asc("id"));
		filtro.addOrder(Order.asc("padre"));
		return modeloMarcaHibernate.buscar(filtro);
	}
	//----- Utilizado desde del formular de armas
	@Override
	public List<ModeloMarca> buscarPorTipo(ModeloMarca modeloMarca,Valor valor) {
		Busqueda filtro = Busqueda.forClass(ModeloMarca.class);		
		if (modeloMarca!=null){			
			if(modeloMarca.getNombre()!= null ){
				
				if (modeloMarca.getPadre() != null && modeloMarca.getPadre().getId()  != null) {
					filtro.createAlias("padre", "pa");			
					filtro.add(Restrictions.eq("pa.id", modeloMarca.getPadre().getId()));
				}else{				
					filtro.add(Restrictions.isNull("padre"));
				}
								
			}		
		}		
		filtro.addOrder(Order.asc("id"));
		filtro.addOrder(Order.asc("padre"));
		return modeloMarcaHibernate.buscar(filtro);
	}
	
	@Override
	public Map<String, List<ModeloMarca>> listarModeloMarcas() {
		Busqueda filtro = Busqueda.forClass(ModeloMarca.class);		
		filtro.addOrder(Order.asc("nombre"));				
		List<ModeloMarca> modeloMarcas = modeloMarcaHibernate.buscar(filtro);
		return HarecUtil.ordenarModeloMarcas(modeloMarcas);
	}
	@Override
	public List<ModeloMarca> listarMarcas() {
		Busqueda filtro = Busqueda.forClass(ModeloMarca.class);
		filtro.add(Restrictions.isNull("padre"));
		return modeloMarcaHibernate.buscar(filtro);
	}

	@Override
	public List<ModeloMarca> buscarPadreHijos(ModeloMarca modeloMarca) {
		// TODO: aqui tengo q generer el metodo buscar padre recursivo		
		List<ModeloMarca> lstmodeMarcas = null;		
		ModeloMarca marcaHijo = null;
		marcaHijo = new ModeloMarca();
		marcaHijo.setPadre(modeloMarca);
		
		lstmodeMarcas = buscar(modeloMarca);
		Map<String, ModeloMarca> map = new HashMap<String, ModeloMarca>();
		
		for (ModeloMarca beanModelo : lstmodeMarcas) {			
			map.put(beanModelo.getId().toString(), beanModelo);
			if (beanModelo.getPadre() != null) {				
				if (beanModelo.getPadre().getId() != null) {					
					if(map.get( beanModelo.getPadre().getId().toString() ) == null){
						getPadreRecursivo(beanModelo.getPadre().getId(), map);
					}
				}
			}
		}
		List<ModeloMarca> lstModelosMarcas = new ArrayList<ModeloMarca>(map.values());		 
		return lstModelosMarcas;
	}	
	
	public ModeloMarca getPadreRecursivo( Long idPadre , Map<String, ModeloMarca> map ){
		ModeloMarca modeloMarca = modeloMarcaHibernate.obtener(idPadre);
		map.put(modeloMarca.getId().toString(), modeloMarca);		
		if( modeloMarca.getPadre()!=null && modeloMarca.getPadre().getId()!=null ){			
			return getPadreRecursivo(modeloMarca.getPadre().getId(), map);
		}else{
			return modeloMarca;
		}			
	}

	@Override
	public Map<String, List<ModeloMarca>> filtrarModelosMarcas(List<ModeloMarca> modelosMarcas) {
		return HarecUtil.ordenarModeloMarcas(modelosMarcas);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(ModeloMarca object) {		
		object.validar();
		Busqueda filtro = Busqueda.forClass(ModeloMarca.class);
		filtro.add(Restrictions.eq("nombre", object.getNombre()));		
		if (modeloMarcaHibernate.buscar(filtro).size()>0) {			 
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_ENTIDAD_EXISTENTE,
					new Object[] { object.getNombre() });
		}		
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(ModeloMarca object) {
		object.validar();
		Busqueda filtro = Busqueda.forClass(ModeloMarca.class);
		filtro.add(Restrictions.eq("nombre", object.getNombre()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));		
		if (modeloMarcaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_ENTIDAD_EXISTENTE,
					new Object[] { object.getNombre() });
		}
		modeloMarcaHibernate.actualizar(object);
	}
	public List<ModeloMarca> buscarPadreseli() {
		Busqueda filtro = Busqueda.forClass(ModeloMarca.class);
		filtro.add(Restrictions.isNull("padre"));
		List<ModeloMarca> delitos = modeloMarcaHibernate.buscar(filtro);
		return delitos;
	}
	
	
	@Override
	public List<ModeloMarca> buscarPadres(ModeloMarca modeloMarca,Valor valor) {
		Busqueda filtro = Busqueda.forClass(ModeloMarca.class);		
		if (modeloMarca!=null){			
			if(modeloMarca.getNombre()!= null ){				

				if (modeloMarca.getPadre() != null && modeloMarca.getPadre().getId()  != null) {
					filtro.createAlias("padre", "pa");			
					filtro.add(Restrictions.eq("pa.id", modeloMarca.getPadre().getId()));
				}else{				
					filtro.add(Restrictions.isNull("padre"));
				}
										
			}		
		}		
		filtro.addOrder(Order.asc("id"));
		filtro.addOrder(Order.asc("padre"));
		return modeloMarcaHibernate.buscar(filtro);
	}
	
	@Override
	public List<ModeloMarca> buscarHijos(ModeloMarca modelo) {
	Busqueda filtro = Busqueda.forClass(ModeloMarca.class);
		
		if (modelo!=null){
			if (modelo.getId() != null) {
				filtro.add(Restrictions.eq("padre.id", modelo.getId()));
			}
		}
		
		List<ModeloMarca> lstModelos = modeloMarcaHibernate.buscar(filtro);
		return lstModelos;		
	}

}