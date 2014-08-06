package pe.gob.mininter.dirandro.service.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.OpcionHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.service.OpcionService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;

@Service
public class OpcionServiceImpl extends BaseServiceImpl<Opcion, Long> implements OpcionService {

	private static final long serialVersionUID = -1996923554551485459L;
	
	private OpcionHibernate opcionHibernate;
	
	@Autowired
	public OpcionServiceImpl(OpcionHibernate opcionHibernate) {
		super(opcionHibernate);
		this.opcionHibernate = opcionHibernate;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Opcion object) {
		//object.validar();
		Busqueda filtro = Busqueda.forClass(Opcion.class);
		filtro.add(Restrictions.eq("codigo", object.getCodigo()));
		if (opcionHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_OPCION_EXISTENTE,
					new Object[] { object.getCodigo() });
		}
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Opcion object) {
		object.validar();
		Busqueda filtro = Busqueda.forClass(Opcion.class);
		filtro.add(Restrictions.eq("codigo", object.getCodigo()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		if (opcionHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_OPCION_EXISTENTE,
					new Object[] { object.getCodigo() });
		}
		opcionHibernate.actualizar(object);
	}

	@Override
	public List<Opcion> buscar(Opcion opcion) {
		Busqueda filtro = Busqueda.forClass(Opcion.class);
		if (opcion != null) {
			if (opcion.getId() != null) {
				filtro.add(Restrictions.ilike("id", opcion.getId().toString(), MatchMode.ANYWHERE));
			}
		}
		filtro.addOrder(Order.asc("codigo"));
		return opcionHibernate.buscar(filtro);
	}
	
	@Override
	public Map<String, List<Opcion>> listarOpciones(){
		
		Busqueda filtro = Busqueda.forClass(Opcion.class);
		filtro.addOrder(Order.asc("id"));
		filtro.addOrder(Order.asc("padre"));
		filtro.addOrder(Order.asc("orden"));		
		List<Opcion> opciones = opcionHibernate.buscar(filtro);
		
		return HarecUtil.ordenarOpciones(opciones);
	}

	@Override
	public Opcion obtenerOpcionPorCodigo(String codigo) {
		Busqueda filtro = Busqueda.forClass(Opcion.class);
		filtro.add(Restrictions.eq("codigo", codigo));
		
		List<Opcion> opciones = opcionHibernate.buscar(filtro);
		
		if(opciones.size() > 0)
		{
			return opciones.get(0);
		}
		
		return null;
	}

	@Override
	public List<Opcion> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
