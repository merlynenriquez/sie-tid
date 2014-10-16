package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.InmuebleHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
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
			if ( inmueble.getId()!=null) {
				filtro.add(Restrictions.eq("id", inmueble.getId()));
			}
			addILikeRestrictions(filtro, "descripcion", inmueble.getDescripcion());
			
			addILikeRestrictions(filtro, "direccion", inmueble.getDireccion());
			addILikeRestrictions(filtro, "urbanizacion", inmueble.getUrbanizacion());
			
			addILikeRestrictions(filtro, "nroInscripcion", inmueble.getNroInscripcion());
			addILikeRestrictions(filtro, "oficinaRegistral", inmueble.getOficinaRegistral());
			addILikeRestrictions(filtro, "resolucion", inmueble.getResolucion());
			
			addILikeRestrictions(filtro, "observaciones", inmueble.getObservaciones());
			addILikeRestrictions(filtro, "longitud", inmueble.getLongitud());
			addILikeRestrictions(filtro, "latitud", inmueble.getLatitud());
		}
		return expedienteInmuebleHibernate.buscar(filtro);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Inmueble object) {		
		if (object==null) {
			throw new ValidacionException("NO existe Registro",
					//Constante.CODIGO_MENSAJE.VALIDAR_ESTADO_EXISTENTE,
					new Object[] { "Inmueble" });
		}
		//object.validar();
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
