package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
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
			if(detalle.getInteligencia()!=null){
				filtro.createAlias("inteligencia", "i");
				if(detalle.getInteligencia().getId()!=null){
					filtro.add(Restrictions.eq("i.id", detalle.getInteligencia().getId() ));			
				}
			}		
		}
		return detalleHibernate.buscar(filtro);		
	}
	
}
