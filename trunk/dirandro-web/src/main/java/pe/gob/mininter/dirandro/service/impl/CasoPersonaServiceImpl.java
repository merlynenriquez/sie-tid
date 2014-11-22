package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.CasoPersonaHibernate;
import pe.gob.mininter.dirandro.model.DetCasoPersona;
import pe.gob.mininter.dirandro.service.CasoPersonaService;
import pe.gob.mininter.dirandro.service.NoIdentificadoService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.HarecUtil;

@Service
public class CasoPersonaServiceImpl extends BaseServiceImpl<DetCasoPersona, Long> implements CasoPersonaService {

	private static final long serialVersionUID = -3223274958709374921L;

	@Autowired
	private NoIdentificadoService noIdentificadoService;
	
	private CasoPersonaHibernate casoPersonaHibernate;
		
	@Autowired
	public CasoPersonaServiceImpl(CasoPersonaHibernate casoPersonaHibernate) {
		super(casoPersonaHibernate);
		this.casoPersonaHibernate = casoPersonaHibernate;
	}

	@Override
	public List<DetCasoPersona> buscar(DetCasoPersona caso) {
		Busqueda filtro = Busqueda.forClass(DetCasoPersona.class);		
		if(caso!=null){
			
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
		return casoPersonaHibernate.buscar(filtro);
	}

	@Override
	public void registrar(DetCasoPersona caso) {
		noIdentificadoService.crear(caso.getNoIdentificado());
		casoPersonaHibernate.crear(caso);
	}

}
