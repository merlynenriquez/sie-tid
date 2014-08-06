package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.ValorHibernate;
import pe.gob.mininter.dirandro.dao.oracle.ValorOracle;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.ValorService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Service(Constante.NOMBRE_SERVICIO.VALOR)
public class ValorServiceImpl extends BaseServiceImpl<Valor, Long> implements
		ValorService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6023109311267834442L;

	private ValorHibernate valorHibernate;

	@Autowired
	private ValorOracle valorOracle;
	
	@Autowired
	public ValorServiceImpl(ValorHibernate valorHibernate) {
		super(valorHibernate);
		this.valorHibernate = valorHibernate;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Valor object) {
		Busqueda filtro = Busqueda.forClass(Valor.class);
		filtro.add(Restrictions.eq("codigo", object.getCodigo()));
		if (valorHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_VALOR_EXISTENTE,
					new Object[] { object.getCodigo() });
		}
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Valor object) {
		object.validar();
		Busqueda filtro = Busqueda.forClass(Valor.class);
		filtro.add(Restrictions.eq("codigo", object.getCodigo()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		if (valorHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_VALOR_EXISTENTE,
					new Object[] { object.getCodigo() });
		}
		valorHibernate.actualizar(object);
	}

	@Override
	public List<Valor> obtenerLista(String codigoLista) {
		Busqueda filtro = Busqueda.forClass(Valor.class);
		filtro.createAlias("lista", "l");
		filtro.add(Restrictions.eq("l.codigo", codigoLista));
		filtro.add(Restrictions.eq("estado", Constante.VALOR.CODIGO.ACTIVO));
		filtro.addOrder(Order.asc("orden"));
		filtro.addOrder(Order.asc("id"));
		return valorHibernate.buscar(filtro);
	}

	@Override
	public List<Valor> buscar(Valor valor) {
		Busqueda filtro = Busqueda.forClass(Valor.class);
		if (valor != null) {
			if (valor.getId() != null) 
				filtro.add(Restrictions.eq("id",valor.getId()));
			
			if (valor.getCodigo() != null) 
				filtro.add(Restrictions.ilike("codigo", valor.getCodigo(), MatchMode.EXACT));
			
			if (valor.getNombre() != null)
				filtro.add(Restrictions.ilike("nombre",valor.getNombre(), MatchMode.ANYWHERE));
		
			if (valor.getEstado() != null)
				filtro.add(Restrictions.ilike("estado",valor.getEstado(), MatchMode.ANYWHERE));
		
			if (valor.getLista() != null) {
				filtro.createAlias("lista", "l");
				filtro.add(Restrictions.eq("l.id", valor.getLista().getId()));
			}
		}
		filtro.addOrder(Order.asc("id"));
		return valorHibernate.buscar(filtro);
	}

	@Override
	public Valor obtenerValor(String lista, String codValor) {
		Busqueda filtro = Busqueda.forClass(Valor.class);
		filtro.createAlias("lista", "l2");
		filtro.add(Restrictions.eq("l2.codigo",lista));
		
		if (!StringUtils.isEmpty(codValor)) {
			filtro.add(Restrictions.eq("codigo",codValor));
		}
		
		filtro.add(Restrictions.eq("estado",Constante.VALOR.CODIGO.ACTIVO));		
		List<Valor> valores = valorHibernate.buscar(filtro);
	
		if(valores.size() > 0){
			return valores.get(0);
		}
		return null;
	}

	@Override
	public List<Valor> obtenerxVector(Long valor1) {
		return valorOracle.obtenerxVector(valor1);
	}

	@Override
	public List<Valor> obtenerListaSalida(String codigoLista) {
		Busqueda filtro = Busqueda.forClass(Valor.class);
		filtro.createAlias("lista", "l");
		filtro.add(Restrictions.eq("l.codigo", codigoLista));
		filtro.add(Restrictions.eq("estado", Constante.VALOR.CODIGO.ACTIVO));
		filtro.add(Restrictions.or(Restrictions.eq("codigo", Constante.VALOR.CODIGO.ATESTADO), Restrictions.ilike("codigo", Constante.VALOR.CODIGO.OFICIO)));
		return valorHibernate.buscar(filtro);
	}

	@Override
	public List<Valor> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Valor> buscar(Busqueda filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
