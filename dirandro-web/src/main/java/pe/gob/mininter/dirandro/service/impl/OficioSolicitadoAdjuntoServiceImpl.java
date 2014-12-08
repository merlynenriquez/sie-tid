package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.OficioSolicitadoAdjuntoHibernate;
import pe.gob.mininter.dirandro.model.Adjunto;
import pe.gob.mininter.dirandro.model.OficioSolicitadoAdjunto;
import pe.gob.mininter.dirandro.service.AdjuntoService;
import pe.gob.mininter.dirandro.service.OficioSolicitadoAdjuntoService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.HarecUtil;

@Service
@SuppressWarnings("serial")
public class OficioSolicitadoAdjuntoServiceImpl extends BaseServiceImpl<OficioSolicitadoAdjunto, Long> implements OficioSolicitadoAdjuntoService {
	
	@Autowired
	private AdjuntoService adjuntoService;
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
			if (oficioSolicitadoAdjunto.getOficioSolicitado() != null) {
				filtro.createAlias("oficioSolicitado", "o");
				filtro.add(Restrictions.eq("o.id", oficioSolicitadoAdjunto.getOficioSolicitado().getId()));
			}
		}
		filtro.addOrder(Order.asc("id"));
		return oficioSolicitadoAdjuntoHibernate.buscar(filtro);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void registrarOficioSolicitadoAdjunta(
			OficioSolicitadoAdjunto oficioSolicitadoAdjunto) {
		Adjunto adjunto = oficioSolicitadoAdjunto.getAdjunto();
		
		adjuntoService.crear(adjunto);	
		
		oficioSolicitadoAdjuntoHibernate.crear(oficioSolicitadoAdjunto);
		
		//grabar binario en disco duro
		HarecUtil.adjuntarDocumentos(adjunto);
	}

}
