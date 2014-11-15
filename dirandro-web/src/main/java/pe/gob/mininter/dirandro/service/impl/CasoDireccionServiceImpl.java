package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.CasoDireccionHibernate;
import pe.gob.mininter.dirandro.model.DetCasoDireccion;
import pe.gob.mininter.dirandro.service.CasoDireccionService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class CasoDireccionServiceImpl extends BaseServiceImpl<DetCasoDireccion, Long> implements CasoDireccionService {

	private static final long serialVersionUID = -7158176309400411754L;

	private CasoDireccionHibernate casoDireccionHibernate;
		
	@Autowired
	public CasoDireccionServiceImpl(CasoDireccionHibernate casoDireccionHibernate) {
		super(casoDireccionHibernate);
		this.casoDireccionHibernate = casoDireccionHibernate;
	}

	@Override
	public List<DetCasoDireccion> buscar(DetCasoDireccion caso) {
		Busqueda filtro = Busqueda.forClass(DetCasoDireccion.class);		
		if(caso!=null){
//			if(caso.getPersona()!=null){
//				if(caso.getPersona().getId()!=null){
//					filtro.add(Restrictions.eq("persona.id", correo.getPersona().getId()));			
//				}
//			}
		}
		return casoDireccionHibernate.buscar(filtro);
	}
	
}
