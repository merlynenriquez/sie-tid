package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteInmuebleHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.DetPerInmExp;
import pe.gob.mininter.dirandro.service.ExpedienteInmuebleService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Service
public class ExpedienteInmuebleServiceImpl extends BaseServiceImpl<DetPerInmExp, String> implements ExpedienteInmuebleService{

	private static final long serialVersionUID = 2565423206722461545L;
	
	private ExpedienteInmuebleHibernate expedienteInmuebleHibernate;
	
	@Autowired
	public ExpedienteInmuebleServiceImpl(ExpedienteInmuebleHibernate expedienteInmuebleHibernate) {
		super(expedienteInmuebleHibernate);
		this.expedienteInmuebleHibernate = expedienteInmuebleHibernate;
	}
	
	@Override
	public List<DetPerInmExp> buscar(DetPerInmExp inmueble) {
		Busqueda filtro = Busqueda.forClass(DetPerInmExp.class);
		if(inmueble!=null)
		{
			if(inmueble.getExpediente()!=null){
				filtro.createAlias("expediente", "e");
				filtro.add(Restrictions.eq("e.id", inmueble.getExpediente().getId()));	
			}
			if(inmueble.getInmueble()!=null){
				filtro.createAlias("inmueble", "i");
				filtro.add(Restrictions.eq("i.id", inmueble.getInmueble().getId()));	
			}
		}
		return expedienteInmuebleHibernate.buscar(filtro);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(DetPerInmExp object) {
		if (object==null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_INMUEBLE_EXISTENTE ,new Object[] { "Inmueble" });
		}
		Busqueda filtro = Busqueda.forClass(DetPerInmExp.class);
		if(object.getExpediente()!=null){
			filtro.createAlias("expediente", "e");
			filtro.add(Restrictions.eq("e.id", object.getExpediente().getId()));	
		}
		if(object.getInmueble()!=null){
			filtro.createAlias("inmueble", "i");
			filtro.add(Restrictions.eq("i.id", object.getInmueble().getId()));	
		}
		if (expedienteInmuebleHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_INMUEBLE_EXISTENTE,new Object[] { object.getId() });
		}
		expedienteInmuebleHibernate.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(DetPerInmExp object) {
		Busqueda filtro = Busqueda.forClass(DetPerInmExp.class);
		
		if (expedienteInmuebleHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_INMUEBLE_EXISTENTE,new Object[] { object.getId() });
		}
		expedienteInmuebleHibernate.actualizar(object);
	}
	
}
