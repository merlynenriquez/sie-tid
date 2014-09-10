package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteDelitoHibernate;
import pe.gob.mininter.dirandro.model.ExpedienteDelito;
import pe.gob.mininter.dirandro.service.ExpedienteDelitoService;
import pe.gob.mininter.dirandro.util.Busqueda;

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
		return expDelitoHibernate.buscar(filtro);		
	}
	
}
