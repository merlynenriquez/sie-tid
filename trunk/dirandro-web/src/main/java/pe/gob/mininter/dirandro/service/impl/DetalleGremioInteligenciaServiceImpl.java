package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.DetalleGremioInteligenciaHibernate;
import pe.gob.mininter.dirandro.model.DetGremioCocalero;
import pe.gob.mininter.dirandro.service.DetalleGremioInteligenciaService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class DetalleGremioInteligenciaServiceImpl extends BaseServiceImpl<DetGremioCocalero, Long> implements DetalleGremioInteligenciaService {
	
	private static final long serialVersionUID = -2672328860538765704L;
	private DetalleGremioInteligenciaHibernate detalleGremioInteligenciaHibernate;
	
	@Autowired
	public DetalleGremioInteligenciaServiceImpl(DetalleGremioInteligenciaHibernate detalleGremioInteligenciaHibernate) {
		super(detalleGremioInteligenciaHibernate);
		this.detalleGremioInteligenciaHibernate = detalleGremioInteligenciaHibernate;
	}

	@Override
	public List<DetGremioCocalero> buscar(DetGremioCocalero detalle) {
		Busqueda filtro = Busqueda.forClass(DetGremioCocalero.class);
		
		if (detalle != null) {
			if(detalle.getGremioCocalero()!=null){
				filtro.createAlias("gremioCocalero", "c");
				if(detalle.getGremioCocalero().getId()!=null){
					filtro.add(Restrictions.eq("c.id", detalle.getGremioCocalero().getId() ));			
				}	
			}
			if(detalle.getInteligencia()!=null){
				filtro.createAlias("inteligencia", "i");
				if(detalle.getInteligencia().getId()!=null){
					filtro.add(Restrictions.eq("i.id", detalle.getInteligencia().getId() ));			
				}
			}
		}
		
		return detalleGremioInteligenciaHibernate.buscar(filtro);
	}
	
}
