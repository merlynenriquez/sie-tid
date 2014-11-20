package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.AdjuntoHibernate;
import pe.gob.mininter.dirandro.dao.hibernate.CasoImagenHibernate;
import pe.gob.mininter.dirandro.model.Adjunto;
import pe.gob.mininter.dirandro.model.DetCasoImagen;
import pe.gob.mininter.dirandro.service.AdjuntoService;
import pe.gob.mininter.dirandro.service.CasoImagenService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.HarecUtil;

@Service
public class CasoImagenServiceImpl extends BaseServiceImpl<DetCasoImagen, Long> implements CasoImagenService {

	private static final long serialVersionUID = -8647808839681193993L;
	private static final Logger logger = Logger.getLogger(CasoImagenServiceImpl.class);
	
	private CasoImagenHibernate casoImagenHibernate;	
	
	@Autowired
	private AdjuntoHibernate adjuntoHibernate;
	
	@Autowired
	public CasoImagenServiceImpl(CasoImagenHibernate casoImagenHibernate) {
		super(casoImagenHibernate);
		this.casoImagenHibernate = casoImagenHibernate;
	}

	@Override
	public List<DetCasoImagen> buscar(DetCasoImagen caso) {
		Busqueda filtro = Busqueda.forClass(DetCasoImagen.class);		
		if(caso!=null){
			
//			if(caso.getCaso()!=null){
//				if(caso.getAdjunto().getId()!=null){
//					filtro.add(Restrictions.eq("persona.id", correo.getPersona().getId()));			
//				}
//			}

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
		return casoImagenHibernate.buscar(filtro);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void registrarAdjunta(DetCasoImagen caso) {
		logger.debug("registrando el adjunto");
		Adjunto adjunto = caso.getAdjunto(); 
		logger.debug("creando adjunto");
		adjuntoHibernate.crear(adjunto);
		logger.debug("creando caso");
		casoImagenHibernate.crear(caso);
		logger.debug("grabando adjunto en disco");
		HarecUtil.adjuntarDocumentos(adjunto);
		
	}

}
