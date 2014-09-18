package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.DrogaHibernate;
import pe.gob.mininter.dirandro.model.Droga;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.service.DrogaService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class DrogaServiceImpl extends BaseServiceImpl<Droga, Long> implements DrogaService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4911345513738472979L;
	
	private DrogaHibernate drogaHibernate;

	@Autowired
	public DrogaServiceImpl(DrogaHibernate drogaHibernate) {
		super(drogaHibernate);
		this.drogaHibernate = drogaHibernate;
	}

	@Override
	public List<Droga> obtenerDrogasExpediente(Expediente expediente) {
		Busqueda filtro = Busqueda.forClass(Droga.class);
		filtro.add(Restrictions.eq("expediente", expediente));
		return drogaHibernate.buscar(filtro);
	}
	
	

}
