package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.HojaRemisionMuestraHibernate;
import pe.gob.mininter.dirandro.model.HojaremisionMuestra;
import pe.gob.mininter.dirandro.service.HojaRemisionMuestraService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class HojaRemisionMuestraServiceImpl extends BaseServiceImpl<HojaremisionMuestra, Long> implements HojaRemisionMuestraService {
	
	private static final long serialVersionUID = 3208937870429422307L;
	
	private HojaRemisionMuestraHibernate hojaRemisionMuestraHibernate;
	
	@Autowired
	public HojaRemisionMuestraServiceImpl(HojaRemisionMuestraHibernate hojaRemisionMuestraHibernate) {
		super(hojaRemisionMuestraHibernate);
		this.hojaRemisionMuestraHibernate = hojaRemisionMuestraHibernate;
	}

	@Override
	public List<HojaremisionMuestra> buscar(HojaremisionMuestra hojaRemisionMuestra) {
		Busqueda filtro = Busqueda.forClass(HojaremisionMuestra.class);
		
		if (hojaRemisionMuestra != null) {
								
		}
		return hojaRemisionMuestraHibernate.buscar(filtro);		
	}

	
}
