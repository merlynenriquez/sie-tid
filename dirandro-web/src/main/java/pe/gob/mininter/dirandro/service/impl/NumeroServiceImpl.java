package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.NumeroHibernate;
import pe.gob.mininter.dirandro.model.Numero;
import pe.gob.mininter.dirandro.service.NumeroService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class NumeroServiceImpl extends BaseServiceImpl<Numero, Long> implements NumeroService {
	
	private static final long serialVersionUID = -7887078540135503570L;
	
	private NumeroHibernate numeroHibernate;
	
	@Autowired
	public NumeroServiceImpl(NumeroHibernate numeroHibernate) {
		super(numeroHibernate);	
		this.numeroHibernate = numeroHibernate;
	}

	@Override
	public List<Numero> buscar(Numero numero) {
		Busqueda filtro = Busqueda.forClass(Numero.class);
		return numeroHibernate.buscar(filtro);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Numero object) {
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Numero object) {
		//Busqueda filtro = Busqueda.forClass(DetPerVehExp.class);
		numeroHibernate.actualizar(object);
	}
}
