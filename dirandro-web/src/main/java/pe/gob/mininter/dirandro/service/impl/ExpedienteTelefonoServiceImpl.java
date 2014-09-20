package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteTelefonoHibernate;
import pe.gob.mininter.dirandro.model.DetPerTelExp;
import pe.gob.mininter.dirandro.service.ExpedienteTelefonoService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class ExpedienteTelefonoServiceImpl extends BaseServiceImpl<DetPerTelExp, Long> implements ExpedienteTelefonoService {
	
	private static final long serialVersionUID = 1893717123659192777L;
	
	private ExpedienteTelefonoHibernate expTelefonoHibernate;
	
	@Autowired
	public ExpedienteTelefonoServiceImpl(ExpedienteTelefonoHibernate expTelefonoHibernate) {
		super(expTelefonoHibernate);	
		this.expTelefonoHibernate = expTelefonoHibernate;
	}

	@Override
	public List<DetPerTelExp> buscar(DetPerTelExp detTelefono) {
		Busqueda filtro = Busqueda.forClass(DetPerTelExp.class);
		return expTelefonoHibernate.buscar(filtro);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(DetPerTelExp object) {
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(DetPerTelExp object) {
		//Busqueda filtro = Busqueda.forClass(DetPerVehExp.class);
		expTelefonoHibernate.actualizar(object);
	}
}
