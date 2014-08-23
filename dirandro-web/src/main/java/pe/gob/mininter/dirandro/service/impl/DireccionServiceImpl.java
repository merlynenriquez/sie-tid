package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.DireccionHibernate;
import pe.gob.mininter.dirandro.model.Direccion;
import pe.gob.mininter.dirandro.service.DireccionService;
import pe.gob.mininter.dirandro.service.ValorService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class DireccionServiceImpl extends BaseServiceImpl<Direccion, Long>
		implements DireccionService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8064866370340152994L;
	
	private DireccionHibernate direccionHibernate;
	
	@Autowired
	private ValorService valorService;
	
	@Autowired
	public DireccionServiceImpl(DireccionHibernate direccionHibernate) {
		super(direccionHibernate);
		this.direccionHibernate = direccionHibernate;
	}

	

	@Override
	public List<Direccion> buscar(Direccion direccion) {
		Busqueda filtro = Busqueda.forClass(Direccion.class);
		if(direccion!=null){
			if(direccion.getPersona()!=null){
				if(direccion.getPersona().getId()!=null){
					filtro.add(Restrictions.eq("persona.id", direccion.getPersona().getId()));			
				}
			}
		}
		return direccionHibernate.buscar(filtro);
	}

}
