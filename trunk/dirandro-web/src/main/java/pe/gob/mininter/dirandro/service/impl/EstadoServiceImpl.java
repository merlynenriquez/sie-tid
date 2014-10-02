package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.EstadoHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.Estado;
import pe.gob.mininter.dirandro.service.EstadoService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Service
public class EstadoServiceImpl extends BaseServiceImpl<Estado, Long> implements EstadoService{

	private static final long serialVersionUID = 2697106645391028183L;
	
	private EstadoHibernate estadoHibernate;
	
	@Autowired
	public EstadoServiceImpl(EstadoHibernate estadoHibernate) {
		super(estadoHibernate);
		this.estadoHibernate = estadoHibernate;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Estado object) {
		object.validar();
		Busqueda filtro = Busqueda.forClass(Estado.class);
		filtro.add(Restrictions.eq("codigo", object.getNombre()));
		if (estadoHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_ESTADO_EXISTENTE,
					new Object[] { object.getNombre() });
		}
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Estado object) {
		object.validar();
		Busqueda filtro = Busqueda.forClass(Estado.class);
		filtro.add(Restrictions.eq("codigo", object.getNombre()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		if (estadoHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_ESTADO_EXISTENTE,
					new Object[] { object.getNombre() });
		}
		estadoHibernate.actualizar(object);
	}
	
	@Override
	public List<Estado> buscar(Estado estado) {		
		Busqueda filtro = Busqueda.forClass(Estado.class);		
		if(estado !=null){			
			if ( estado.getCodigo() != null) {
				filtro.add(Restrictions.ilike("codigo", estado.getCodigo(), MatchMode.ANYWHERE));				
			}
			if ( estado.getNombre() != null) {
				filtro.add(Restrictions.ilike("nombre", estado.getNombre(), MatchMode.ANYWHERE));				
			}
			if ( estado.getDescripcion() != null) {
				filtro.add(Restrictions.ilike("descripcion", estado.getDescripcion(), MatchMode.ANYWHERE));				
			}
		}						
		return estadoHibernate.buscar(filtro);		
	}

	@Override
	public Estado obtenerEstado(String codEstado) {
		Busqueda filtro = Busqueda.forClass(Estado.class);
		
		if (!StringUtils.isEmpty(codEstado)) {
			filtro.add(Restrictions.eq("codigo", codEstado));
		}
		
		List<Estado> lstEstados = estadoHibernate.buscar(filtro);
		
		if(lstEstados.size() > 0){
			return lstEstados.get(0);
		}
		return null;
	}
}
