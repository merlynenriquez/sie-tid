package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.BaseHibernate;
import pe.gob.mininter.dirandro.dao.hibernate.EstadoHibernate;
import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteEspecieHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.DetPerVehExp;
import pe.gob.mininter.dirandro.model.Especie;
import pe.gob.mininter.dirandro.model.Estado;
import pe.gob.mininter.dirandro.service.EstadoService;
import pe.gob.mininter.dirandro.service.ExpedienteEspecieService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Service
public class ExpedienteEspecieServiceImpl extends BaseServiceImpl<Especie, Long> implements ExpedienteEspecieService{

	private static final long serialVersionUID = 839822685524157864L;	
	
	private ExpedienteEspecieHibernate expedienteEspeciesHibernate;
	
	@Autowired
	public ExpedienteEspecieServiceImpl(ExpedienteEspecieHibernate expedienteEspeciesHibernate) {
		super(expedienteEspeciesHibernate);
		this.expedienteEspeciesHibernate = expedienteEspeciesHibernate;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Especie object) {		
		if (object!=null) {
			throw new ValidacionException("NO existe Registro",
					//Constante.CODIGO_MENSAJE.VALIDAR_ESTADO_EXISTENTE,
					new Object[] { "Especie" });		}
		super.crear(object);
		
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Especie object) {

		Busqueda filtro = Busqueda.forClass(Especie.class);
		filtro.add(Restrictions.eq("id", object.getId()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		if (expedienteEspeciesHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_ESPECIE_EXISTENTE,
					new Object[] { object.getId() });
		}
		expedienteEspeciesHibernate.actualizar(object);
	}
		

	@Override
	public List<Especie> buscar(Especie especie) {
		// TODO Auto-generated method stub
		return null;
	}


}
