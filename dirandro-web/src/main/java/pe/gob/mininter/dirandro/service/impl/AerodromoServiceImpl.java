package pe.gob.mininter.dirandro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.AerodromoHibernate;
import pe.gob.mininter.dirandro.model.Aerodromo;
import pe.gob.mininter.dirandro.service.AerodromoService;

@Service
@SuppressWarnings("serial")
public class AerodromoServiceImpl extends BaseServiceImpl<Aerodromo, Long> implements AerodromoService {
	
	private AerodromoHibernate aerodromoHibernate;
	
	@Autowired
	public AerodromoServiceImpl(AerodromoHibernate aerodromoHibernate) {
		super(aerodromoHibernate);
		this.aerodromoHibernate = aerodromoHibernate;
	}
	
}
