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
import pe.gob.mininter.dirandro.dao.oracle.ParametroOracle;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.Entidad;

import pe.gob.mininter.dirandro.service.EntidadService;
import pe.gob.mininter.dirandro.service.ParametroService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Service
public class EntidadServiceImpl extends BaseServiceImpl<Entidad, Long> implements EntidadService {

	private static final long serialVersionUID = -2615092658998593825L;
	
	protected enum TipoOperacion{CREAR,ACTUALIZAR,ELIMINAR}

	@Autowired
	private ParametroOracle parametroOracle;
	
	private EntidadHibernate parametroHibernate;
	
	@Autowired
	public EntidadServiceImpl(EntidadHibernate parametroHibernate) {
		super(parametroHibernate);
		this.parametroHibernate = parametroHibernate;
	}

	@Override	
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Entidad parametro) {
		validarReglaNegocio(parametro,TipoOperacion.CREAR); 
		super.crear(parametro);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Entidad parametro) {
		validarReglaNegocio(parametro,TipoOperacion.ACTUALIZAR);
		//parametroOracle.actualizar(parametro);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly = false)
	public void eliminar(Entidad parametro) {
		//eliminarXId(parametro.getCodigo());
	}

	@Override
	public List<Entidad> buscar(Entidad parametro) {
		Busqueda filtro = Busqueda.forClass(Entidad.class);
		/*if (parametro != null) {
			if (parametro.getCodigo() != null) {
				filtro.add(Restrictions.ilike("codigo",parametro.getCodigo(), MatchMode.ANYWHERE));
			}
			if (parametro.getNombre() != null) {
				filtro.add(Restrictions.ilike("nombre",parametro.getNombre(), MatchMode.ANYWHERE));
			}
			if (parametro.getValor() != null) {
				filtro.add(Restrictions.ilike("valor",parametro.getValor(), MatchMode.ANYWHERE));
			}
			if (parametro.getEstado() != null && parametro.getEstado().getNombre() != null) {
				filtro.createAlias("estado", "e");
				filtro.createAlias("e.lista", "l");
				filtro.add(Restrictions.eq("l.codigo", Constante.LISTA.CODIGO.ESTADO));
				filtro.add(Restrictions.ilike("e.nombre",parametro.getEstado().getNombre(), MatchMode.ANYWHERE));
			}
		}
		filtro.addOrder(Order.asc("codigo"));*/
		return parametroHibernate.buscar(filtro);
	}	
	
	protected void validarReglaNegocio(Entidad parametro, TipoOperacion tipoOperacion) {
		/*parametro.setCodigo(parametro.getCodigo().trim().toUpperCase());
		if (tipoOperacion.equals(TipoOperacion.CREAR)) {
			if (parametroHibernate.contiene(parametro.getCodigo())) {
				throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_PARAMETRO_EXISTENTE_CODIGO, new Object[] { parametro.getCodigo() });
			}
		} else {
			if(!parametro.getCodigoAnterior().equalsIgnoreCase(parametro.getCodigo())){
				Busqueda filtroCodigo = Busqueda.forClass(Entidad.class);
				filtroCodigo.add(Restrictions.eq("codigo", parametro.getCodigo().trim()).ignoreCase());
				filtroCodigo.add(Restrictions.not(Restrictions.eq("codigo", parametro.getCodigoAnterior().trim()).ignoreCase()));
				List<Parametro> parametroCodigo = parametroHibernate.buscar(filtroCodigo);
				if (parametroCodigo.size() > 0) {
					throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_PARAMETRO_EXISTENTE_CODIGO, new Object[] { parametro.getCodigo() });
				}
			}
		}
				
		Busqueda filtroNombre = Busqueda.forClass(Parametro.class);
		filtroNombre.add(Restrictions.eq("nombre", parametro.getNombre().trim()).ignoreCase());
		List<Parametro> parametroNombre=parametroHibernate.buscar(filtroNombre);
		
		if (parametroNombre.size() > 0) {
			if (tipoOperacion.equals(TipoOperacion.CREAR)) {
				throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_PARAMETRO_EXISTENTE_NOMBRE, new Object[] { parametro.getNombre() });
			} else {
				if (!parametroNombre.get(0).getCodigo().equalsIgnoreCase(parametro.getCodigo())) {
					throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_PARAMETRO_EXISTENTE_NOMBRE, new Object[] { parametro.getNombre() });
				}
			}
		}*/
	}

	@Override
	public Entidad obtener(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void grabarTodos(List<Entidad> list) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void eliminarXId(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarTodos(List<Entidad> list) {
		// TODO Auto-generated method stub
		
	}

	

}
