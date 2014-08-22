package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.AdjuntoHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.Adjunto;
import pe.gob.mininter.dirandro.service.AdjuntoService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Service
public class AdjuntoServiceImpl extends BaseServiceImpl<Adjunto, Long> implements AdjuntoService{
	
	private static final long serialVersionUID = 1565658681505263811L;
	
	private AdjuntoHibernate adjuntoHibernate;
	
	@Autowired
	public AdjuntoServiceImpl(AdjuntoHibernate adjuntoHibernate) {
		super(adjuntoHibernate);
		this.adjuntoHibernate = adjuntoHibernate;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Adjunto object) {		
		/*Busqueda filtro = Busqueda.forClass(Adjunto.class);
		filtro.add(Restrictions.eq("nombre", object.getNombre()));
		if (adjuntoHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_ENTIDAD_EXISTENTE,
					new Object[] { object.getNombre() });
		}*/
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Adjunto object) {
		Busqueda filtro = Busqueda.forClass(Adjunto.class);
		filtro.add(Restrictions.eq("nombre", object.getNombre()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		if (adjuntoHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_ENTIDAD_EXISTENTE, new Object[] { object.getNombre() });
		}
		adjuntoHibernate.actualizar(object);
	}

	@Override
	public List<Adjunto> buscar(Adjunto adjunto) {
		Busqueda filtro = Busqueda.forClass(Adjunto.class);
		
		if (adjunto != null) {
			
		}		
		
		filtro.setFirstResult(0);
		filtro.setMaxResults(500);
		
		return adjuntoHibernate.buscar(filtro);
		
	}
}
