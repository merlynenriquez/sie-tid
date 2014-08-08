package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.ListaHibernate;
import pe.gob.mininter.dirandro.dao.hibernate.ValorHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.Lista;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.ListaService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Service
public class ListaServiceImpl extends BaseServiceImpl<Lista, Long> implements ListaService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8559177787411460886L;
	
	private ListaHibernate listaHibernate;
	
	@Autowired
	private ValorHibernate valorHibernate;
	
	@Autowired
	public ListaServiceImpl(ListaHibernate listaHibernate) {
		super(listaHibernate);
		this.listaHibernate = listaHibernate;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Lista object) {
		//object.validar();
		Busqueda filtro = Busqueda.forClass(Lista.class);
		filtro.add(Restrictions.eq("codigo", object.getCodigo()));
		if (listaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_LISTA_EXISTENTE,
					new Object[] { object.getCodigo() });
		}
		//listaHibernate.crear(object);
		super.crear(object);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Lista object) {
		object.validar();
		Busqueda filtro = Busqueda.forClass(Lista.class);
		filtro.add(Restrictions.eq("codigo", object.getCodigo()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		if (listaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_LISTA_EXISTENTE,
					new Object[] { object.getCodigo() });
		}
		listaHibernate.actualizar(object);
	}

	@Override
	public List<Lista> buscar(Lista lista) {
		Busqueda filtro = Busqueda.forClass(Lista.class);
		if (lista != null) {
			if (lista.getId() != null) {
				filtro.add(Restrictions.ilike("id",
						lista.getId().toString(), MatchMode.ANYWHERE));
			}
			if (lista.getCodigo() != null) {
				filtro.add(Restrictions.ilike("codigo",
						lista.getCodigo(), MatchMode.ANYWHERE));
			}
			if (lista.getNombre() != null) {
				filtro.add(Restrictions.ilike("nombre",
						lista.getNombre(), MatchMode.ANYWHERE));
			}
			if (lista.getEstado() != null) {
				filtro.add(Restrictions.ilike("estado",
						lista.getEstado(), MatchMode.ANYWHERE));
			}
			
		}
		filtro.addOrder(Order.asc("id"));
		return listaHibernate.buscar(filtro);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void eliminarXId(Long id) {
		Busqueda filtro = Busqueda.forClass(Valor.class);
		filtro.createAlias("lista", "l");
		filtro.add(Restrictions.eq("l.id",id));
		//valorHibernate.eliminarTodos(valorHibernate.buscar(filtro));
		listaHibernate.eliminarXId(id);
	}

	@Override
	public List<Lista> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
