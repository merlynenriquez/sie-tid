package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.EstadoHibernate;
import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteInmuebleHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.DetPerVehExp;
import pe.gob.mininter.dirandro.model.Estado;
import pe.gob.mininter.dirandro.model.Inmueble;
import pe.gob.mininter.dirandro.service.EstadoService;
import pe.gob.mininter.dirandro.service.ExpedienteInmuebleService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Service
public class ExpedienteInmuebleServiceImpl extends BaseServiceImpl<Inmueble, String> implements ExpedienteInmuebleService{

	private static final long serialVersionUID = 2565423206722461545L;
	
	private ExpedienteInmuebleHibernate expedienteInmuebleHibernate;
	
	@Autowired
	public ExpedienteInmuebleServiceImpl(ExpedienteInmuebleHibernate expedienteInmuebleHibernate) {
		super(expedienteInmuebleHibernate);
		this.expedienteInmuebleHibernate = expedienteInmuebleHibernate;
	}
	
	
	@Override
	public List<Inmueble> buscar(Inmueble inmueble) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Inmueble object) {		
		if (object!=null) {
			throw new ValidacionException("NO existe Registro",
					//Constante.CODIGO_MENSAJE.VALIDAR_ESTADO_EXISTENTE,
					new Object[] { "Inmueble" });		}
		super.crear(object);
		
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Inmueble object) {
		//object.validar();
		Busqueda filtro = Busqueda.forClass(Inmueble.class);
		filtro.add(Restrictions.eq("codigo", object.getCodigo()));
		filtro.add(Restrictions.not(Restrictions.eq("codigo", object.getCodigo())));
		if (expedienteInmuebleHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_INMUEBLE_EXISTENTE,
					new Object[] { object.getCodigo() });
		}
		expedienteInmuebleHibernate.actualizar(object);
	}
	
}
