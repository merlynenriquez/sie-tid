package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.OficioSolicitadoAdjuntoHibernate;
import pe.gob.mininter.dirandro.model.OficioSolicitadoAdjunto;
import pe.gob.mininter.dirandro.service.OficioSolicitadoAdjuntoService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
@SuppressWarnings("serial")
public class OficioSolicitadoAdjuntoServiceImpl extends BaseServiceImpl<OficioSolicitadoAdjunto, Long> implements OficioSolicitadoAdjuntoService {
	
	private OficioSolicitadoAdjuntoHibernate oficioSolicitadoAdjuntoHibernate;
	
	@Autowired
	public OficioSolicitadoAdjuntoServiceImpl(OficioSolicitadoAdjuntoHibernate oficioSolicitadoAdjuntoHibernate) {
		super(oficioSolicitadoAdjuntoHibernate);
		this.oficioSolicitadoAdjuntoHibernate = oficioSolicitadoAdjuntoHibernate;
	}

	@Override
	public List<OficioSolicitadoAdjunto> buscar(OficioSolicitadoAdjunto oficioSolicitadoAdjunto) {
		Busqueda filtro = Busqueda.forClass(OficioSolicitadoAdjunto.class);
		if (oficioSolicitadoAdjunto != null) {
			if (oficioSolicitadoAdjunto.getId() != null) {
				filtro.add(Restrictions.ilike("id", oficioSolicitadoAdjunto.getId().toString(), MatchMode.ANYWHERE));
			}
		}
		filtro.addOrder(Order.asc("codigo"));
		return oficioSolicitadoAdjuntoHibernate.buscar(filtro);
	}

}
