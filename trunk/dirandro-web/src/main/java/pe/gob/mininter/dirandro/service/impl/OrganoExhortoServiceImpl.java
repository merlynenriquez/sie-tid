package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.OrganoExhortoHibernate;
import pe.gob.mininter.dirandro.model.GremioCocalero;
import pe.gob.mininter.dirandro.model.OrgExhorto;
import pe.gob.mininter.dirandro.service.OrganoExhortoService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class OrganoExhortoServiceImpl extends BaseServiceImpl<OrgExhorto, Long> implements OrganoExhortoService {

	private static final long serialVersionUID = 6536710495404108065L;

	private OrganoExhortoHibernate organoHibernate;
	
	@Autowired
	public OrganoExhortoServiceImpl(OrganoExhortoHibernate organoHibernate) {
		super(organoHibernate);
		this.organoHibernate = organoHibernate;
	}

	@Override
	public List<OrgExhorto> buscar(OrgExhorto organo) {
		Busqueda filtro = Busqueda.forClass(OrgExhorto.class);		
		if(organo!=null){
			
			logger.debug("bean detalle lleno");
			if(organo.getInforme()!=null){
//				logger.debug(" tiene direccion ");
				filtro.createAlias("informe", "i");
				if(organo.getInforme().getId()!=null){
//					logger.debug(" direccion id " + caso.getDireccion().getId() );	
					filtro.add(Restrictions.eq("i.id", organo.getInforme().getId() ));			
				}
//				if(!HarecUtil.nullToEmpty( caso.getDireccion().getDireccion() ).equals("")){
//					filtro.add(Restrictions.ilike("d.direccion", caso.getDireccion().getDireccion(), MatchMode.ANYWHERE ));			
//				}
			}

				
		}
		return organoHibernate.buscar(filtro);
	}
}
