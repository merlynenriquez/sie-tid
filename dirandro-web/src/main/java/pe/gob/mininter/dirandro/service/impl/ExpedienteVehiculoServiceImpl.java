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
	
	private ExpedienteVehiculoHibernate expedienteVehiculoHibernate;
	
	@Autowired
	public ExpedienteVehiculoServiceImpl(
			ExpedienteVehiculoHibernate expedienteVehiculoHibernate) {
		super(expedienteVehiculoHibernate);	
		this.expedienteVehiculoHibernate = expedienteVehiculoHibernate;
	}

	@Override
	public List<DetPerVehExp> buscar(DetPerVehExp detPerVehExp) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(DetPerVehExp object) {		
		if (object!=null) {
			throw new ValidacionException("NO existe Registro",
					//Constante.CODIGO_MENSAJE.VALIDAR_ESTADO_EXISTENTE,
					new Object[] { "Vehiculo" });		}
		super.crear(object);
		
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(DetPerVehExp object) {
		//object.validar();
		Busqueda filtro = Busqueda.forClass(DetPerVehExp.class);
		filtro.add(Restrictions.eq("id", object.getExpVehiculo().getId()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		if (expedienteVehiculoHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_VEHICULO_EXISTENTE,
					new Object[] { object.getExpVehiculo().getPlaca() });
		}
		expedienteVehiculoHibernate.actualizar(object);
	}
	
}
