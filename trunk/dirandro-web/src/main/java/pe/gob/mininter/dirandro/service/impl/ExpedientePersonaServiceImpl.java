package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedientePersonaHibernate;
import pe.gob.mininter.dirandro.model.DetExpedientePersona;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.service.ExpedientePersonaService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class ExpedientePersonaServiceImpl extends BaseServiceImpl<DetExpedientePersona, Long> implements ExpedientePersonaService {
	
	private static final long serialVersionUID = 2124806059954362807L;
	
	private ExpedientePersonaHibernate expPersonaHibernate;
	
	@Autowired
	public ExpedientePersonaServiceImpl(ExpedientePersonaHibernate expPersonaHibernate) {
		super(expPersonaHibernate);
		this.expPersonaHibernate = expPersonaHibernate;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(DetExpedientePersona object) {
		//object.validar();
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(DetExpedientePersona object) {
		object.validar();
		expPersonaHibernate.actualizar(object);
	}

	@Override
	public List<DetExpedientePersona> buscar(DetExpedientePersona expPersona) {
		Busqueda filtro = Busqueda.forClass(DetExpedientePersona.class);
		return expPersonaHibernate.buscar(filtro);		
	}

	@Override
	public List<DetExpedientePersona> cargarIntervinientes(Expediente expediente) {
		Busqueda filtro = Busqueda.forClass(DetExpedientePersona.class);
		filtro.add(Restrictions.eq("expediente", expediente));
		return expPersonaHibernate.buscar(filtro);		
	}
	
}
