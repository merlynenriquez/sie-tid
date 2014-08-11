package pe.gob.mininter.dirandro.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.BaseHibernate;
import pe.gob.mininter.dirandro.service.BaseService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Validador;

@Transactional(readOnly = true)
public abstract class BaseServiceImpl<Entidad, TipoLlave> implements BaseService<Entidad, TipoLlave> {

	private static final long serialVersionUID = -8689463786842580735L;
	
	protected static final Log logger = LogFactory.getLog(BaseServiceImpl.class);

	private BaseHibernate<Entidad, TipoLlave> baseHibernate;
	
	private Class<Entidad> domainClass;
	
	private static final String CAMPO_CODIGO="codigo";
	
	@SuppressWarnings("unchecked")
	protected BaseServiceImpl(BaseHibernate<Entidad, TipoLlave> baseHibernate) {
		this.baseHibernate = baseHibernate;
		this.domainClass = (Class<Entidad>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public Entidad obtener(TipoLlave id) {
		return this.baseHibernate.obtener(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly = false)
	public void actualizar(Entidad object) {
		if (object instanceof Validador){
			((Validador) object).validar();
		}
		this.baseHibernate.actualizar(object);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly = false)
	public void crear(Entidad object) {		
		if (object instanceof Validador){
			((Validador) object).validar();
		}
		this.baseHibernate.crear(object);		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly = false)
	public void eliminar(Entidad object) {
		this.baseHibernate.eliminar(object);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly = false)
	public void eliminarXId(TipoLlave id) {		
		this.baseHibernate.eliminarXId(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly = false)
	public void eliminarTodos(List<Entidad> list) {
		this.baseHibernate.eliminarTodos(list);
	}	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly = false)
	public void grabarTodos(List<Entidad> list){
		if(list != null){
			if (list.size() != 0) 
				this.baseHibernate.grabarTodos(list);
		}else {
			return;
		}
	}
	
	public Entidad obtenerPorCodigo(String codigo){
		Busqueda filtro = Busqueda.forClass(domainClass);
		
		if(esObjetoConCodigo()){
			filtro.add(Restrictions.eq(CAMPO_CODIGO, codigo));
			List<Entidad> entidads = baseHibernate.buscar(filtro);
			if(entidads.size() > 0){
				return entidads.get(0);
			}
		}
		return null;
	}
	
	private boolean esObjetoConCodigo() {
		@SuppressWarnings("unused")
		Field field = null;
		try {
			field = domainClass.getDeclaredField(CAMPO_CODIGO);
		} catch (SecurityException e) {
			return false;
		} catch (NoSuchFieldException e) {
			return false;
		}
		return true;
	}
	
	
	protected void agregarValor(Busqueda filtro, String aliasLista, String codigoLista, String associationPathValor, String aliasValor, String codigoValor){
		filtro.createAlias(associationPathValor, aliasValor);
		filtro.createAlias(aliasValor+".lista", aliasLista);
		filtro.add(Restrictions.eq(aliasValor+".codigo", codigoValor));
		filtro.add(Restrictions.eq(aliasLista+".codigo", codigoLista));
	}
	
	protected void agregarValorEstado(Busqueda filtro, String codigoLista, String codigoValor){
		agregarValor(filtro, "l", codigoLista, "estado", "e", codigoValor);
	}
	
	protected void validarReglaNegocio(Entidad object,TipoOperacion tipoOperacion){
		logger.debug("Iniciando validarReglaNegocio en BaseServiceImpl");
		logger.debug("finalizando validarReglaNegocio en BaseServiceImpl");
	}
	
	protected void validarReglaNegocioEliminar(Entidad object){
		logger.debug("Iniciando validarReglaNegocioEliminar en BaseServiceImpl");
		logger.debug("finalizando validarReglaNegocioEliminar en BaseServiceImpl");
	}
	
	protected enum TipoOperacion{CREAR,ACTUALIZAR,ELIMINAR}
}
