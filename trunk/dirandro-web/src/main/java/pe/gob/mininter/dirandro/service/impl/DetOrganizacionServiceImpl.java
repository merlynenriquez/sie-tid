package pe.gob.mininter.dirandro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.DetOrganizacionHibernate;
import pe.gob.mininter.dirandro.model.DetOrganizacion;
import pe.gob.mininter.dirandro.service.DetOrganizacionService;

@Service
@SuppressWarnings("serial")
public class DetOrganizacionServiceImpl extends BaseServiceImpl<DetOrganizacion, Long> implements DetOrganizacionService {
	
	private DetOrganizacionHibernate detOrganizacionHibernate;
	
	@Autowired
	public DetOrganizacionServiceImpl(DetOrganizacionHibernate detOrganizacionHibernate) {
		super(detOrganizacionHibernate);
		this.detOrganizacionHibernate = detOrganizacionHibernate;
	}
	
}
