package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.TelefonoHibernate;
import pe.gob.mininter.dirandro.model.Telefono;
import pe.gob.mininter.dirandro.service.TelefonoService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class TelefonoServiceImpl extends BaseServiceImpl<Telefono, Long> implements TelefonoService {

	private static final long serialVersionUID = -4926097337616720814L;
	
	private TelefonoHibernate telefonoHibernate; 
	
	@Autowired
	public TelefonoServiceImpl(TelefonoHibernate telefonoHibernate) {
		super(telefonoHibernate);
		this.telefonoHibernate = telefonoHibernate;
	}

	@Override
	public List<Telefono> buscar(Telefono telefono) {
		Busqueda filtro = Busqueda.forClass(Telefono.class);
		return telefonoHibernate.buscar(filtro);		
	}
}
