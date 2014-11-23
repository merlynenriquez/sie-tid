package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.GremioHibernate;
import pe.gob.mininter.dirandro.model.GremioCocalero;
import pe.gob.mininter.dirandro.service.GremioService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
@SuppressWarnings("serial")
public class GremioServiceImpl extends BaseServiceImpl<GremioCocalero, Long> implements GremioService {
	
	private GremioHibernate gremioHibernate;
	
	@Autowired
	public GremioServiceImpl(GremioHibernate gremioHibernate) {
		super(gremioHibernate);
		this.gremioHibernate = gremioHibernate;
	}

	@Override
	public List<GremioCocalero> buscar(GremioCocalero gremio) {
		Busqueda filtro = Busqueda.forClass(GremioCocalero.class);		
		if(gremio!=null){
			
			logger.debug("bean detalle lleno");
//			if(caso.getDireccion()!=null){
//				logger.debug(" tiene direccion ");
//				filtro.createAlias("direccion", "d");
//				if(caso.getDireccion().getId()!=null){
//					logger.debug(" direccion id " + caso.getDireccion().getId() );	
//					filtro.add(Restrictions.eq("d.id", caso.getDireccion().getId() ));			
//				}
//				if(!HarecUtil.nullToEmpty( caso.getDireccion().getDireccion() ).equals("")){
//					filtro.add(Restrictions.ilike("d.direccion", caso.getDireccion().getDireccion(), MatchMode.ANYWHERE ));			
//				}
//			}
//			
//				filtro.createAlias("caso", "c");
//			
//				if(!HarecUtil.nullToEmpty( caso.getCaso().getNombre() ).equals("")){
//					filtro.add(Restrictions.ilike("c.nombre", caso.getCaso().getNombre(), MatchMode.ANYWHERE ));			
//				}
//			
			
			if(gremio.getId()!=null){
				filtro.add(Restrictions.eq("id", gremio.getId() ));			
			}
				
		}
		return gremioHibernate.buscar(filtro);
	}
	
}
