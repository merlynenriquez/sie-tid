package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.ParametroHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.Parametro;
import pe.gob.mininter.dirandro.service.ParametroService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Service
public class ParametroServiceImpl extends BaseServiceImpl<Parametro, String> implements ParametroService {

	private static final long serialVersionUID = -2615092658998593825L;

	@Autowired
	//private ParametroOracle parametroOracle;
	
	private ParametroHibernate parametroHibernate;
	
	@Autowired
	public ParametroServiceImpl(ParametroHibernate parametroHibernate) {
		super(parametroHibernate);
		this.parametroHibernate = parametroHibernate;
	}

	@Override	
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Parametro parametro) {
		//validarReglaNegocio(parametro,Constante.OPERACION.CREAR_REGISTRO); 
		super.crear(parametro);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Parametro parametro) {		
		//validarReglaNegocio(parametro,Constante.OPERACION.ACTUALIZAR_REGISTRO);	
		//parametroOracle.actualizar(parametro);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly = false)
	public void eliminar(Parametro parametro) {
		eliminarXId(parametro.getCodigo());
	}
	

	@Override
	public List<Parametro> buscar(Parametro parametro) {
		Busqueda filtro = Busqueda.forClass(Parametro.class);
		if (parametro != null) {
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
				filtro.add(Restrictions.eq("l.codigo",
						Constante.LISTA.CODIGO.ESTADO));
				filtro.add(Restrictions.ilike("e.nombre",parametro.getEstado().getNombre(), MatchMode.ANYWHERE));
			}

		}
		filtro.addOrder(Order.asc("codigo"));
		return parametroHibernate.buscar(filtro);
	}
		
	/*protected void validarReglaNegocio(Parametro parametro, String tipoOperacion){
		parametro.setCodigo(parametro.getCodigo().trim().toUpperCase());
		if (tipoOperacion.equals("CREAR")) {
			if (parametroHibernate.contiene(parametro.getCodigo())) {
				throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_PARAMETRO_EXISTENTE, new Object[] { parametro.getCodigo() });
			}
		}else {
			if(!parametro.getCodigoAnterior().equalsIgnoreCase(parametro.getCodigo())){
				Busqueda filtroCodigo = Busqueda.forClass(Parametro.class);
				filtroCodigo.add(Restrictions.eq("codigo", parametro.getCodigo().trim()).ignoreCase());
				filtroCodigo.add(Restrictions.not(Restrictions.eq("codigo", parametro.getCodigoAnterior().trim()).ignoreCase()));
				List<Parametro> parametroCodigo = parametroHibernate.buscar(filtroCodigo);
				if (parametroCodigo.size() > 0) {
					throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_PARAMETRO_EXISTENTE, new Object[] { parametro.getCodigo() });
				}
			}
		}
		
		Busqueda filtroNombre = Busqueda.forClass(Parametro.class);
		filtroNombre.add(Restrictions.eq("nombre", parametro.getNombre().trim()).ignoreCase());
		List<Parametro> parametroNombre = parametroHibernate.buscar(filtroNombre);
		
		
	}*/

	@Override
	public List<Parametro> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
