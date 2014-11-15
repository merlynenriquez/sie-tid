package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.CasoAgenteHibernate;
import pe.gob.mininter.dirandro.model.DetCasoAgente;
import pe.gob.mininter.dirandro.service.CasoAgenteService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class CasoAgenteServiceImpl extends BaseServiceImpl<DetCasoAgente, Long> implements CasoAgenteService {

	private static final long serialVersionUID = -2955237894648256006L;

	private CasoAgenteHibernate casoAgenteHibernate;
		
	@Autowired
	public CasoAgenteServiceImpl(CasoAgenteHibernate casoAgenteHibernate) {
		super(casoAgenteHibernate);
		this.casoAgenteHibernate = casoAgenteHibernate;
	}

	@Override
	public List<DetCasoAgente> buscar(DetCasoAgente caso) {
		Busqueda filtro = Busqueda.forClass(DetCasoAgente.class);		
		if(caso!=null){
//			if(caso.getPersona()!=null){
//				if(caso.getPersona().getId()!=null){
//					filtro.add(Restrictions.eq("persona.id", correo.getPersona().getId()));			
//				}
//			}
		}
		return casoAgenteHibernate.buscar(filtro);
	}
	
}
