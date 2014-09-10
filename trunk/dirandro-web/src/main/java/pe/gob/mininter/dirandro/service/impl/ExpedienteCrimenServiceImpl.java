package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteCrimenHibernate;
import pe.gob.mininter.dirandro.model.DetCrimen;
import pe.gob.mininter.dirandro.service.ExpedienteCrimenService;
import pe.gob.mininter.dirandro.util.Busqueda;

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
