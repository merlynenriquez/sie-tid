package pe.gob.mininter.dirandro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.RutaHibernate;
import pe.gob.mininter.dirandro.model.Ruta;
import pe.gob.mininter.dirandro.service.RutaService;

@Service
public class RutaServiceImpl extends BaseServiceImpl<Ruta, Long> implements RutaService {

	private RutaHibernate rutaHibernate;

	@Autowired
	public RutaServiceImpl(RutaHibernate rutaHibernate) {
		super(rutaHibernate);
		this.rutaHibernate = rutaHibernate;
	}
	
}
