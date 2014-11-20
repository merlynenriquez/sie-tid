package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.RutaTIDHibernate;
import pe.gob.mininter.dirandro.model.RutaTid;
import pe.gob.mininter.dirandro.service.RutaTIDService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class RutaTIDServiceImpl extends BaseServiceImpl<RutaTid, Long> implements RutaTIDService {
	
	private static final long serialVersionUID = -3141569548388320537L;
	
	private RutaTIDHibernate rutaTIDHibernate;

	@Autowired
	public RutaTIDServiceImpl(RutaTIDHibernate rutaTIDHibernate) {
		super(rutaTIDHibernate);
		this.rutaTIDHibernate = rutaTIDHibernate;
	}
 
	@Override
	public List<RutaTid> buscar(RutaTid ruta) {
		Busqueda filtro = Busqueda.forClass(RutaTid.class);
		
		if(ruta!=null){
			
		}
		
		return rutaTIDHibernate.buscar(filtro);
	}

}
