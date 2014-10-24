package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.HojaRemisionMuestraHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.HojaremisionMuestra;
import pe.gob.mininter.dirandro.service.HojaRemisionMuestraService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Service
public class HojaRemisionMuestraServiceImpl extends BaseServiceImpl<HojaremisionMuestra, Long> implements HojaRemisionMuestraService {
	
	private static final long serialVersionUID = 3208937870429422307L;
	
	private HojaRemisionMuestraHibernate hojaRemisionMuestraHibernate;
	
	@Autowired
	public HojaRemisionMuestraServiceImpl(HojaRemisionMuestraHibernate hojaRemisionMuestraHibernate) {
		super(hojaRemisionMuestraHibernate);
		this.hojaRemisionMuestraHibernate = hojaRemisionMuestraHibernate;
	}

	//TODO crear 
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(HojaremisionMuestra object) {		
		Busqueda filtro = Busqueda.forClass(HojaremisionMuestra.class);
		filtro.createAlias("hojaRemision", "h");
		filtro.add(Restrictions.eq("h.id", object.getHojaRemision().getId()));
		logger.debug("id " + object.getHojaRemision().getId() );
		
		if(object.getDroga()!=null){
			logger.debug("valida por droga " + object.getDroga().getId() );
			filtro.add(Restrictions.eq("droga.id", object.getDroga().getId()));
		}
		if(object.getEspecie()!=null){
			logger.debug("valida por especie " + object.getEspecie().getId() );
			filtro.add(Restrictions.eq("especie.id", object.getEspecie().getId()));
		}
		if (hojaRemisionMuestraHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException( Constante.CODIGO_MENSAJE.VALIDAR_MUESTRA_EXISTENTE,
					new Object[] { null });
		}
		hojaRemisionMuestraHibernate.crear(object);
	}
	
	@Override
	public List<HojaremisionMuestra> buscar(HojaremisionMuestra hojaRemisionMuestra) {
		Busqueda filtro = Busqueda.forClass(HojaremisionMuestra.class);
		
		if (hojaRemisionMuestra != null) {
			if (hojaRemisionMuestra.getHojaRemision()!= null) {
				filtro.createAlias("hojaRemision", "h");
				filtro.add(Restrictions.eq("h.id",hojaRemisionMuestra.getHojaRemision().getId() ));
			}			
		}
		return hojaRemisionMuestraHibernate.buscar(filtro);		
	}

	
}
