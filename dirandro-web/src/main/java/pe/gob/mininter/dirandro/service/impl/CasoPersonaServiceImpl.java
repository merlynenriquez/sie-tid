package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.CasoPersonaHibernate;
import pe.gob.mininter.dirandro.model.DetCasoPersona;
import pe.gob.mininter.dirandro.service.CasoPersonaService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class CasoPersonaServiceImpl extends BaseServiceImpl<DetCasoPersona, Long> implements CasoPersonaService {

	private static final long serialVersionUID = -3223274958709374921L;

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
//			if(caso.getPersona()!=null){
//				if(caso.getPersona().getId()!=null){
//					filtro.add(Restrictions.eq("persona.id", correo.getPersona().getId()));			
//				}
//			}
		}
		return casoPersonaHibernate.buscar(filtro);
	}

}
