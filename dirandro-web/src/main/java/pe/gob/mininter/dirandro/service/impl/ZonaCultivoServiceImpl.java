package pe.gob.mininter.dirandro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.ZonaCultivoHibernate;
import pe.gob.mininter.dirandro.model.ZonaCultivo;
import pe.gob.mininter.dirandro.service.ZonaCultivoService;

@Service
@SuppressWarnings("serial")
public class ZonaCultivoServiceImpl extends BaseServiceImpl<ZonaCultivo, Long> implements ZonaCultivoService {
	
	private ZonaCultivoHibernate zonaCultivoHibernate;
	
	@Autowired
	public ZonaCultivoServiceImpl(ZonaCultivoHibernate zonaCultivoHibernate) {
		super(zonaCultivoHibernate);
		this.zonaCultivoHibernate = zonaCultivoHibernate;
	}
	
}
