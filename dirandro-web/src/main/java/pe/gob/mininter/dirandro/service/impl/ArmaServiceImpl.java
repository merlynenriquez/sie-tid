package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.ArmaHibernate;
import pe.gob.mininter.dirandro.model.Arma;
import pe.gob.mininter.dirandro.service.ArmaService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class ArmaServiceImpl extends BaseServiceImpl<Arma, Long> implements ArmaService{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6214909808376225533L;
	private ArmaHibernate armaHibernate; 
	
	@Autowired
	public ArmaServiceImpl(ArmaHibernate armaHibernate) {
		super(armaHibernate);
		this.armaHibernate = armaHibernate;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Arma object) {
		object.validar();
		//Busqueda filtro = Busqueda.forClass(Municion.class);
		//filtro.add(Restrictions.eq("nombres", object.get));
		/*if (PoliciaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_Policia_EXISTENTE,
					new Object[] { object.getNombres() });
		}*/
		armaHibernate.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Arma object) {
		object.validar();
		//Busqueda filtro = Busqueda.forClass(Municion.class);
		/*filtro.add(Restrictions.eq("nombres", object.getNombres()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		/*if (PoliciaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_Policia_EXISTENTE,
					new Object[] { object.getNombres() });
		}*/
		armaHibernate.actualizar(object);
	}

	@Override
	public List<Arma> buscar(Arma arma) {
		Busqueda filtro = Busqueda.forClass(Arma.class);
		if (arma != null) {
			
			if (arma.getCalibre() != null && arma.getCalibre().getId()!=null) {
				filtro.add(Restrictions.eq("calibre.id", arma.getCalibre().getId()));
			}
			if (arma.getModelo() != null && arma.getModelo().getId()!=null) {
				filtro.add(Restrictions.eq("modelo.id", arma.getModelo().getId()));
			}
			/*
			if (arma.getDescripcion()!= null && municion.getDescripcion().length() > 0) {
				filtro.add(Restrictions.ilike("descripcion", municion.getDescripcion(), MatchMode.ANYWHERE));
			}*/
			
		}
		return armaHibernate.buscar(filtro);		
	}
	
}
