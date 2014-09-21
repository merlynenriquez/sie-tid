package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.ArmaHibernate;
import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteArmaHibernate;
import pe.gob.mininter.dirandro.model.Arma;
import pe.gob.mininter.dirandro.model.DetPerArmExp;
import pe.gob.mininter.dirandro.service.ArmaService;
import pe.gob.mininter.dirandro.service.ExpedienteArmaService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class ExpedienteArmaServiceImpl extends BaseServiceImpl<DetPerArmExp, Long> implements ExpedienteArmaService{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6214909808376225533L;
	private ExpedienteArmaHibernate expedienteArmaHibernate;   
	
	@Autowired
	public ExpedienteArmaServiceImpl(ExpedienteArmaHibernate expedienteArmaHibernate) {
		super(expedienteArmaHibernate);
		this.expedienteArmaHibernate = expedienteArmaHibernate;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(DetPerArmExp object) {
		object.validar();
		//Busqueda filtro = Busqueda.forClass(Municion.class);
		//filtro.add(Restrictions.eq("nombres", object.get));
		/*if (PoliciaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_Policia_EXISTENTE,
					new Object[] { object.getNombres() });
		}*/
		expedienteArmaHibernate.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(DetPerArmExp object) {
		object.validar();
		//Busqueda filtro = Busqueda.forClass(Municion.class);
		/*filtro.add(Restrictions.eq("nombres", object.getNombres()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		/*if (PoliciaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_Policia_EXISTENTE,
					new Object[] { object.getNombres() });
		}*/
		expedienteArmaHibernate.actualizar(object);
	}

	@Override
	public List<DetPerArmExp> buscar(DetPerArmExp detarma) {
		Busqueda filtro = Busqueda.forClass(DetPerArmExp.class);
		if (detarma != null) {
			if(detarma.getArma()!=null){
				filtro.createAlias("arma", "arma");
				if (detarma.getArma().getCalibre() != null && detarma.getArma().getCalibre().getId()!=null) {
					filtro.add(Restrictions.eq("arma.calibre.id", detarma.getArma().getCalibre().getId()));
				}
				if (detarma.getArma().getModelo() != null && detarma.getArma().getModelo().getId()!=null) {
					filtro.add(Restrictions.eq("arma.modelo.id", detarma.getArma().getModelo().getId()));
				}	
			}
			
			/*
			if (arma.getDescripcion()!= null && municion.getDescripcion().length() > 0) {
				filtro.add(Restrictions.ilike("descripcion", municion.getDescripcion(), MatchMode.ANYWHERE));
			}*/
			
		}
		return expedienteArmaHibernate.buscar(filtro);		
	}
	
}
