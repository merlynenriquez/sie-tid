package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteCrimenHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.DetCrimen;
import pe.gob.mininter.dirandro.service.ExpedienteCrimenService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Service
public class ExpedienteCrimenServiceImpl extends BaseServiceImpl<DetCrimen, Long> implements ExpedienteCrimenService {
	
	private static final long serialVersionUID = 1024263881753473280L;
	
	private ExpedienteCrimenHibernate expCrimenHibernate;
	
	@Autowired
	public ExpedienteCrimenServiceImpl(ExpedienteCrimenHibernate expCrimenHibernate) {
		super(expCrimenHibernate);
		this.expCrimenHibernate = expCrimenHibernate;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(DetCrimen object) {
		object.validar();
		
		Busqueda filtro = Busqueda.forClass(DetCrimen.class);
	
		if(object.getPrioridad()!=null){
			logger.debug("valida por prioridad " + object.getPrioridad().getId() );
			filtro.add(Restrictions.eq("prioridad.id", object.getPrioridad().getId()));
		}
		if(object.getExpedientePersona()!=null){
			logger.debug("valida por persona " + object.getExpedientePersona().getId() );
			filtro.add(Restrictions.eq("expedientePersona.id", object.getExpedientePersona().getId()));
		}
		if(object.getExpedienteDelito()!=null){
			logger.debug("valida por getExpedienteDelito " + object.getExpedienteDelito().getId() );
			filtro.add(Restrictions.eq("expedienteDelito.id", object.getExpedienteDelito().getId()));
		}
		if (expCrimenHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException( Constante.CODIGO_MENSAJE.VALIDAR_INVOLUCRADO_EXISTENTE,
					new Object[] { null });
		}
		
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(DetCrimen object) {
		object.validar();
		expCrimenHibernate.actualizar(object);
	}

	@Override
	public List<DetCrimen> buscar(DetCrimen expCrimen) {
		Busqueda filtro = Busqueda.forClass(DetCrimen.class);
		
		if (expCrimen.getExpedienteDelito() != null) {
			filtro.createAlias("expedienteDelito", "expDel");
			filtro.add(Restrictions.eq("expDel.id", expCrimen.getExpedienteDelito().getId()));
		}
		
		return expCrimenHibernate.buscar(filtro);		
	}
	
}
