package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.DetalleDrogaHibernate;
import pe.gob.mininter.dirandro.model.DetDroga;
import pe.gob.mininter.dirandro.service.DetalleDrogaService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class DetalleDrogaServiceImpl extends BaseServiceImpl<DetDroga, Long> implements DetalleDrogaService {

	private static final long serialVersionUID = -5239881532212124647L;
	
	private DetalleDrogaHibernate detalleDrogaHibernate;
	
	@Autowired
	public DetalleDrogaServiceImpl(DetalleDrogaHibernate detalleDrogaHibernate) {
		super(detalleDrogaHibernate);
		
		this.detalleDrogaHibernate = detalleDrogaHibernate;
	}

	@Override
	public List<DetDroga> buscar(DetDroga detalleDroga) {
		Busqueda filtro = Busqueda.forClass(DetDroga.class);
		
		if (detalleDroga!=null){
			if (detalleDroga.getDroga() != null) {
				filtro.add(Restrictions.eq("droga.id", detalleDroga.getDroga().getId()));
			}
		}
		return detalleDrogaHibernate.buscar(filtro);
	}
	
}