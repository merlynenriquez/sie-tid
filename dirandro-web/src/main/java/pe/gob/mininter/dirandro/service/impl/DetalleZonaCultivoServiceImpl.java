package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.DetalleZonaCultivoHibernate;
import pe.gob.mininter.dirandro.model.DetZonaCultivo;
import pe.gob.mininter.dirandro.service.DetalleZonaCultivoService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class DetalleZonaCultivoServiceImpl extends BaseServiceImpl<DetZonaCultivo, Long> implements DetalleZonaCultivoService{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6214909808376225533L;
	private DetalleZonaCultivoHibernate detalleHibernate; 
	
	@Autowired
	public DetalleZonaCultivoServiceImpl(DetalleZonaCultivoHibernate detalleHibernate) {
		super(detalleHibernate);
		this.detalleHibernate = detalleHibernate;
	}
	
	@Override
	public List<DetZonaCultivo> buscar(DetZonaCultivo detalle) {
		Busqueda filtro = Busqueda.forClass(DetZonaCultivo.class);
		if (detalle != null) {
//			if (arma.getModelo() != null && arma.getModelo().getId()!=null) {
//				filtro.createAlias("modelo", "m");
//				filtro.add(Restrictions.eq("m.id", arma.getModelo().getId()));
//			}
//			if (arma.getEstadoSerie() != null && arma.getEstadoSerie().getId()!=null) {
//				filtro.createAlias("estadoSerie", "e");
//				filtro.add(Restrictions.eq("e.id", arma.getModelo().getId()));
//			}
//			addILikeRestrictions(filtro, "nroSerie", arma.getNroSerie());
//			if (arma.getCalibre() != null && arma.getCalibre().getId()!=null) {
//				filtro.createAlias("calibre", "c");
//				filtro.add(Restrictions.eq("c.id", arma.getCalibre().getId()));
//			}
//			addILikeRestrictions(filtro, "internamiento", arma.getInternamiento());
//			
		}
		return detalleHibernate.buscar(filtro);		
	}
	
}
