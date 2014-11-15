package pe.gob.mininter.dirandro.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.CasoHibernate;
import pe.gob.mininter.dirandro.model.Caso;
import pe.gob.mininter.dirandro.service.CasoService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class CasoServiceImpl extends BaseServiceImpl<Caso, Long> implements CasoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8064866370340152994L;
	
	private CasoHibernate casoHibernate;
		
	@Autowired
	public CasoServiceImpl(CasoHibernate casoHibernate) {
		super(casoHibernate);
		this.casoHibernate = casoHibernate;
	}

	@Override
	public List<Caso> buscar(Caso caso) {
		Busqueda filtro = Busqueda.forClass(Caso.class);		
		if(caso!=null){
//			if(caso.getPersona()!=null){
//				if(caso.getPersona().getId()!=null){
//					filtro.add(Restrictions.eq("persona.id", correo.getPersona().getId()));			
//				}
//			}
		}
		return casoHibernate.buscar(filtro);
	}

	@Override
	public Map<String, List<Caso>> listarCasos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<Caso>> filtrarCasos(List<Caso> lstCasos) {
		// TODO Auto-generated method stub
		return null;
	}
 
	
}
