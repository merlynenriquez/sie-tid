package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteVehiculoHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.DetPerVehExp;
import pe.gob.mininter.dirandro.service.ExpedienteVehiculoService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;


@Service
public class ExpedienteVehiculoServiceImpl extends BaseServiceImpl<DetPerVehExp, Long> implements ExpedienteVehiculoService{
	
	private static final long serialVersionUID = 2697106645391028183L;
	
	private ExpedienteVehiculoHibernate expVehiculoHibernate;
	
	@Autowired
	public ExpedienteVehiculoServiceImpl(ExpedienteVehiculoHibernate expVehiculoHibernate) {
		super(expVehiculoHibernate);	
		this.expVehiculoHibernate = expVehiculoHibernate;
	}

	@Override
	public List<DetPerVehExp> buscar(DetPerVehExp detPerVehExp) {
		Busqueda filtro = Busqueda.forClass(DetPerVehExp.class);
		return expVehiculoHibernate.buscar(filtro);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(DetPerVehExp object) {
		super.crear(object);
		
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(DetPerVehExp object) {
		//object.validar();
		Busqueda filtro = Busqueda.forClass(DetPerVehExp.class);
		filtro.add(Restrictions.eq("id", object.getVehiculo().getId()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		if (expVehiculoHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_VEHICULO_EXISTENTE,
					new Object[] { object.getVehiculo().getPlaca() });
		}
		expVehiculoHibernate.actualizar(object);
	}
	
}
