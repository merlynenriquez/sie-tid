package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.InmuebleHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.DetPerInmExp;
import pe.gob.mininter.dirandro.model.Inmueble;
import pe.gob.mininter.dirandro.service.InmuebleService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Service
public class InmuebleServiceImpl extends BaseServiceImpl<Inmueble, String> implements InmuebleService{

	private static final long serialVersionUID = 2565423206722461545L;
	
	private InmuebleHibernate expedienteInmuebleHibernate;
	
	@Autowired
	public InmuebleServiceImpl(InmuebleHibernate expedienteInmuebleHibernate) {
		super(expedienteInmuebleHibernate);
		this.expedienteInmuebleHibernate = expedienteInmuebleHibernate;
	}
	
	
	@Override
	public List<Inmueble> buscar(Inmueble inmueble) {
		Busqueda filtro = Busqueda.forClass(Inmueble.class);
		if(inmueble!=null)
		{
		}
		return expedienteInmuebleHibernate.buscar(filtro);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Inmueble object) {		
		if (object==null) {
			throw new ValidacionException("NO existe Registro",
					//Constante.CODIGO_MENSAJE.VALIDAR_ESTADO_EXISTENTE,
					new Object[] { "Inmueble" });		}
		object.validar();
		expedienteInmuebleHibernate.crear(object);
		
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Inmueble object) {
		//object.validar();
		Busqueda filtro = Busqueda.forClass(Inmueble.class);
		
		if (expedienteInmuebleHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_INMUEBLE_EXISTENTE,
					new Object[] { object.getNroInscripcion() });
		}
		expedienteInmuebleHibernate.actualizar(object);
	}
	
}
