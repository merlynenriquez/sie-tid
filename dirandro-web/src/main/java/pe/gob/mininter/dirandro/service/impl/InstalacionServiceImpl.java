package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.InstalacionHibernate;
import pe.gob.mininter.dirandro.model.Instalacion;
import pe.gob.mininter.dirandro.service.InstalacionService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class InstalacionServiceImpl extends BaseServiceImpl<Instalacion, Long> implements InstalacionService {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4526868383136649006L;
	private InstalacionHibernate instalacionHibernate; 
	
	@Autowired
	public InstalacionServiceImpl(InstalacionHibernate instalacionHibernate) {
		super(instalacionHibernate);
		this.instalacionHibernate = instalacionHibernate;
	}
	
	@Override
	public List<Instalacion> buscar(Instalacion instalacion) {
		Busqueda filtro = Busqueda.forClass(Instalacion.class);
		
		if(instalacion!=null){
			if(instalacion.getExpediente()!=null){
				if(instalacion.getExpediente().getId()!=null){
					filtro.add(Restrictions.eq("expediente.id", instalacion.getExpediente().getId()));			
				}
			}
		}
		
		return instalacionHibernate.buscar(filtro);
	}

}
