package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.CasoImagenHibernate;
import pe.gob.mininter.dirandro.model.DetCasoImagen;
import pe.gob.mininter.dirandro.service.CasoImagenService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class CasoImagenServiceImpl extends BaseServiceImpl<DetCasoImagen, Long> implements CasoImagenService {

	private static final long serialVersionUID = -8647808839681193993L;
	
	private CasoImagenHibernate casoImagenHibernate;
		
	@Autowired
	public CasoImagenServiceImpl(CasoImagenHibernate casoImagenHibernate) {
		super(casoImagenHibernate);
		this.casoImagenHibernate = casoImagenHibernate;
	}

	@Override
	public List<DetCasoImagen> buscar(DetCasoImagen caso) {
		Busqueda filtro = Busqueda.forClass(DetCasoImagen.class);		
		if(caso!=null){
//			if(caso.getPersona()!=null){
//				if(caso.getPersona().getId()!=null){
//					filtro.add(Restrictions.eq("persona.id", correo.getPersona().getId()));			
//				}
//			}
		}
		return casoImagenHibernate.buscar(filtro);
	}

}
