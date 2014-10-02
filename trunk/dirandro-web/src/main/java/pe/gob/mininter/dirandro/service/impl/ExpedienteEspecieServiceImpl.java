package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteEspecieHibernate;
import pe.gob.mininter.dirandro.model.Especie;
import pe.gob.mininter.dirandro.service.ExpedienteEspecieService;
import pe.gob.mininter.dirandro.util.Busqueda;

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
	public List<Especie> buscar(Especie especie) {
		Busqueda filtro = Busqueda.forClass(Especie.class);
		
		if (especie != null) {
			
		}
		return expEspeciesHibernate.buscar(filtro);
	}


}
