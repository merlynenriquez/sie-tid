package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.DetRutaTIDHibernate;
import pe.gob.mininter.dirandro.model.DetIntRuta;
import pe.gob.mininter.dirandro.service.DetRutaTIDService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class DetRutaTIDServiceImpl extends BaseServiceImpl<DetIntRuta, Long> implements DetRutaTIDService {

	private static final long serialVersionUID = -7946844261586175512L;
	
	private DetRutaTIDHibernate detRutaTIDHibernate;
		
	@Autowired
	public DetRutaTIDServiceImpl(DetRutaTIDHibernate detRutaTIDHibernate) {
		super(detRutaTIDHibernate);
		this.detRutaTIDHibernate = detRutaTIDHibernate;
	}

	@Override
	public List<DetIntRuta> buscar(DetIntRuta rutaTID) {
		Busqueda filtro = Busqueda.forClass(DetIntRuta.class);
		
		return detRutaTIDHibernate.buscar(filtro);
	}

}
