package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.OficioSolicitadoHibernate;
import pe.gob.mininter.dirandro.model.OficioSolicitado;
import pe.gob.mininter.dirandro.model.OficioSolicitadoAdjunto;
import pe.gob.mininter.dirandro.service.OficioSolicitadoAdjuntoService;
import pe.gob.mininter.dirandro.service.OficioSolicitadoService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
@SuppressWarnings("serial")
public class OficioSolicitadoServiceImpl extends BaseServiceImpl<OficioSolicitado, Long> implements OficioSolicitadoService {

	@Autowired 
	private OficioSolicitadoAdjuntoService oficioSolicitadoAdjuntoService;
	private OficioSolicitadoHibernate oficioSolicitadoHibernate;
	
	@Autowired
	public OficioSolicitadoServiceImpl(OficioSolicitadoHibernate oficioSolicitadoHibernate) {
		super(oficioSolicitadoHibernate);
		this.oficioSolicitadoHibernate = oficioSolicitadoHibernate;
	}

	@Override
	public List<OficioSolicitado> buscar(OficioSolicitado oficioSolicitado) {
		Busqueda filtro = Busqueda.forClass(OficioSolicitado.class);
		if (oficioSolicitado != null) {
			if (oficioSolicitado.getId() != null) {
				filtro.add(Restrictions.ilike("id", oficioSolicitado.getId().toString(), MatchMode.ANYWHERE));
			}
			if(oficioSolicitado.getExpediente()!=null){
				filtro.createAlias("expediente", "e");
				filtro.add(Restrictions.eq("e.id", oficioSolicitado.getExpediente().getId()));
			}
		}
		filtro.addOrder(Order.asc("id"));
		return oficioSolicitadoHibernate.buscar(filtro);
	}	
	
}
