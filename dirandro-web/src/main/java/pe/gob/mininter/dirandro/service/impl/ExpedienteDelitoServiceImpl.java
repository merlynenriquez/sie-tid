package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteDelitoHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.ExpedienteDelito;
import pe.gob.mininter.dirandro.service.ExpedienteDelitoService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Service
public class ExpedienteDelitoServiceImpl extends BaseServiceImpl<ExpedienteDelito, Long> implements ExpedienteDelitoService {
	
	private static final long serialVersionUID = 781759596903344467L;
	
	private ExpedienteDelitoHibernate expDelitoHibernate;
	
	@Autowired
	public ExpedienteDelitoServiceImpl(ExpedienteDelitoHibernate expDelitoHibernate) {
		super(expDelitoHibernate);
		this.expDelitoHibernate = expDelitoHibernate;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(ExpedienteDelito object) {
		object.validar();
		
		Busqueda filtro = Busqueda.forClass(ExpedienteDelito.class);
	
		if(object.getPrioridad()!=null){
			logger.debug("valida por prioridad " + object.getPrioridad().getId() );
			filtro.add(Restrictions.eq("prioridad.id", object.getPrioridad().getId()));
		}
		if(object.getDelito()!=null){
			logger.debug("valida por delito " + object.getDelito().getId() );
			filtro.add(Restrictions.eq("delito.id", object.getDelito().getId()));
		}
		if (expDelitoHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException( Constante.CODIGO_MENSAJE.VALIDAR_DELITO_EXISTENTE,
					new Object[] { null });
		}
		
		
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(ExpedienteDelito object) {
		object.validar();
		expDelitoHibernate.actualizar(object);
	}

	@Override
	public List<ExpedienteDelito> buscar(ExpedienteDelito expDelito) {
		Busqueda filtro = Busqueda.forClass(ExpedienteDelito.class);

		if (expDelito != null) {
			if (expDelito.getExpediente()!= null && !expDelito.getExpediente().esNuevo()) {
				filtro.createAlias("expediente", "e");
				filtro.add(Restrictions.eq("e.id",expDelito.getExpediente().getId() ));
			}			
		}
		
		return expDelitoHibernate.buscar(filtro);
	}
	
}
