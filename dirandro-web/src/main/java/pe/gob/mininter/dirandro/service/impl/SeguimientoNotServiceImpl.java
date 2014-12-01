package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.SeguimientoNotHibernate;
import pe.gob.mininter.dirandro.model.SeguimientoNot;
import pe.gob.mininter.dirandro.service.SeguimientoNotService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
@SuppressWarnings("serial")
public class SeguimientoNotServiceImpl extends BaseServiceImpl<SeguimientoNot, Long> implements SeguimientoNotService {
	
	private SeguimientoNotHibernate seguimientoNotHibernate;
	
	@Autowired
	public SeguimientoNotServiceImpl(SeguimientoNotHibernate seguimientoNotHibernate) {
		super(seguimientoNotHibernate);
		this.seguimientoNotHibernate = seguimientoNotHibernate;
	}

	@Override
	public List<SeguimientoNot> buscar(SeguimientoNot seguimientoNot) {
		Busqueda filtro = Busqueda.forClass(SeguimientoNot.class);
		
		if (seguimientoNot != null) {
			if(seguimientoNot.getNotificacion()!=null){
				filtro.createAlias("notificacion", "n");
				filtro.add(Restrictions.eq("n.id", seguimientoNot.getNotificacion().getId()));
			}
		}
		
		return seguimientoNotHibernate.buscar(filtro);
	}
	
}
