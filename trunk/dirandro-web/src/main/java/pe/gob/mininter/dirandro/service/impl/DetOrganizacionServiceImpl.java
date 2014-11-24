package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.DetOrganizacionHibernate;
import pe.gob.mininter.dirandro.model.DetOrganizacion;
import pe.gob.mininter.dirandro.service.DetOrganizacionService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
@SuppressWarnings("serial")
public class DetOrganizacionServiceImpl extends BaseServiceImpl<DetOrganizacion, Long> implements DetOrganizacionService {
	
	private DetOrganizacionHibernate detOrganizacionHibernate;
	
	@Autowired
	public DetOrganizacionServiceImpl(DetOrganizacionHibernate detOrganizacionHibernate) {
		super(detOrganizacionHibernate);
		this.detOrganizacionHibernate = detOrganizacionHibernate;
	}

	@Override
	public List<DetOrganizacion> buscar(DetOrganizacion detOrganizacion) {
		Busqueda filtro = Busqueda.forClass(DetOrganizacion.class);
		if (detOrganizacion != null) {
			if(detOrganizacion.getInteligencia()!=null){
				filtro.createAlias("inteligencia", "i");
				filtro.add(Restrictions.eq("i.id", detOrganizacion.getInteligencia().getId()));
			}
		}
		filtro.addOrder(Order.asc("id"));
		return detOrganizacionHibernate.buscar(filtro);
	}
	
}
