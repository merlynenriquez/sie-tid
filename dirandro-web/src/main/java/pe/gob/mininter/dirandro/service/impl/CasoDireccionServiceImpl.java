package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.CasoDireccionHibernate;
import pe.gob.mininter.dirandro.model.DetCasoDireccion;
import pe.gob.mininter.dirandro.service.CasoDireccionService;
import pe.gob.mininter.dirandro.service.DireccionService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.HarecUtil;

@Service
public class CasoDireccionServiceImpl extends BaseServiceImpl<DetCasoDireccion, Long> implements CasoDireccionService {

	private static final long serialVersionUID = -7158176309400411754L;

	private static final Logger logger = Logger.getLogger(CasoDireccionServiceImpl.class);
	
	private CasoDireccionHibernate casoDireccionHibernate;
	@Autowired
	private DireccionService direccionService;
	
	@Autowired
	public CasoDireccionServiceImpl(CasoDireccionHibernate casoDireccionHibernate) {
		super(casoDireccionHibernate);
		this.casoDireccionHibernate = casoDireccionHibernate;
	}

	@Override
	public List<DetCasoDireccion> buscar(DetCasoDireccion caso) {
		Busqueda filtro = Busqueda.forClass(DetCasoDireccion.class);		
		if(caso!=null){
			logger.debug("bean detalle lleno");
			if(caso.getDireccion()!=null){
				logger.debug(" tiene direccion ");
				filtro.createAlias("direccion", "d");
				if(caso.getDireccion().getId()!=null){
					logger.debug(" direccion id " + caso.getDireccion().getId() );	
					filtro.add(Restrictions.eq("d.id", caso.getDireccion().getId() ));			
				}
				if(!HarecUtil.nullToEmpty( caso.getDireccion().getDireccion() ).equals("")){
					filtro.add(Restrictions.ilike("d.direccion", caso.getDireccion().getDireccion(), MatchMode.ANYWHERE ));			
				}
			}
			
			if(caso.getCaso()!=null){
				filtro.createAlias("caso", "c");
				if(caso.getCaso().getId()!=null){
					filtro.add(Restrictions.eq("c.id", caso.getCaso().getId() ));			
				}
				if(!HarecUtil.nullToEmpty( caso.getCaso().getNombre() ).equals("")){
					filtro.add(Restrictions.ilike("c.nombre", caso.getCaso().getNombre(), MatchMode.ANYWHERE ));			
				}
			}
		}
		return casoDireccionHibernate.buscar(filtro);
	}

	@Override
	@Transactional
	public void registrar(DetCasoDireccion caso) {
		logger.debug("registrando la direccion");
		direccionService.crear(caso.getDireccion());
		logger.debug("registrando el detalle direccion caso");
		super.crear(caso);
		
	}
	
}
