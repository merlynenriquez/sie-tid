package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteEspecieHibernate;
import pe.gob.mininter.dirandro.model.Especie;
import pe.gob.mininter.dirandro.service.ExpedienteEspecieService;

@Service
public class ExpedienteEspecieServiceImpl extends BaseServiceImpl<Especie, Long> implements ExpedienteEspecieService{

	private static final long serialVersionUID = 839822685524157864L;	
	
	private ExpedienteEspecieHibernate expEspeciesHibernate;
	
	@Autowired
	public ExpedienteEspecieServiceImpl(ExpedienteEspecieHibernate expEspeciesHibernate) {
		super(expEspeciesHibernate);
		this.expEspeciesHibernate = expEspeciesHibernate;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Especie object) {
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Especie object) {
		/*Busqueda filtro = Busqueda.forClass(Especie.class);
		filtro.add(Restrictions.eq("id", object.getId()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		if (expEspeciesHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_ESPECIE_EXISTENTE,new Object[] { object.getId() });
		}*/
		expEspeciesHibernate.actualizar(object);
	}	

	@Override
	public List<Especie> buscar(Especie especie) {
		
		return null;
	}


}
