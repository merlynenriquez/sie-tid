package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.VehiculoHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.Vehiculo;
import pe.gob.mininter.dirandro.service.VehiculoService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Service
public class VehiculoServiceImpl extends BaseServiceImpl<Vehiculo, Long> implements	VehiculoService {

	private static final long serialVersionUID = -6023109311267834442L;
	
	private VehiculoHibernate vehiculoHibernate;

	@Autowired
	public VehiculoServiceImpl(VehiculoHibernate vehiculoHibernate) {
		super(vehiculoHibernate);
		this.vehiculoHibernate = vehiculoHibernate;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Vehiculo object) {
		Busqueda filtro = Busqueda.forClass(Vehiculo.class);
		filtro.add(Restrictions.eq("placa", object.getPlaca()));
		if (vehiculoHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_VALOR_EXISTENTE, new Object[] { object.getPlaca() });
		}
		super.crear(object);
	}
	
  	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Vehiculo object) {
		object.validar();
		vehiculoHibernate.actualizar(object);
	}

	@Override
	public List<Vehiculo> buscar(Vehiculo vehiculo) {
		
		Busqueda filtro = Busqueda.forClass(Vehiculo.class);
		
		if (vehiculo != null) {

			if (vehiculo.getPlaca()!= null) {
				filtro.add(Restrictions.ilike("placa",vehiculo.getPlaca(), MatchMode.ANYWHERE));
			}
			
			if (vehiculo.getSerieChasis()!= null) {
				filtro.add(Restrictions.ilike("serieChasis",vehiculo.getSerieChasis(), MatchMode.ANYWHERE));
			}
			
			if (vehiculo.getSerieMotor()!= null) {
				filtro.add(Restrictions.ilike("serieMotor",vehiculo.getSerieMotor(), MatchMode.ANYWHERE));
			}						
		}
		
		return vehiculoHibernate.buscar(filtro);
		
	}
}
