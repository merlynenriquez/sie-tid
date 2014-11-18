package pe.gob.mininter.dirandro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.GremioHibernate;
import pe.gob.mininter.dirandro.model.GremioCocalero;
import pe.gob.mininter.dirandro.service.GremioService;

@Service
@SuppressWarnings("serial")
public class GremioServiceImpl extends BaseServiceImpl<GremioCocalero, Long> implements GremioService {
	
	private GremioHibernate gremioHibernate;
	
	@Autowired
	public GremioServiceImpl(GremioHibernate gremioHibernate) {
		super(gremioHibernate);
		this.gremioHibernate = gremioHibernate;
	}
	
}
