package pe.gob.mininter.dirandro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.DetAerodromoHibernate;
import pe.gob.mininter.dirandro.model.DetAerodromo;
import pe.gob.mininter.dirandro.service.DetAerodromoService;

@Service
@SuppressWarnings("serial")
public class DetAerodromoServiceImpl extends BaseServiceImpl<DetAerodromo, Long> implements DetAerodromoService {
	
	private DetAerodromoHibernate detAerodromoHibernate;
	
	@Autowired
	public DetAerodromoServiceImpl(DetAerodromoHibernate detAerodromoHibernate) {
		super(detAerodromoHibernate);
		this.detAerodromoHibernate = detAerodromoHibernate;
	}
	
}
