package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.PoliciaHibernate;
import pe.gob.mininter.dirandro.model.Policia;
import pe.gob.mininter.dirandro.service.PoliciaService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class PoliciaServiceImpl extends BaseServiceImpl<Policia, Long> implements PoliciaService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2697106645391028183L;
	
	private PoliciaHibernate policiaHibernate;
	
	@Autowired
	public PoliciaServiceImpl(PoliciaHibernate policiaHibernate) {
		super(policiaHibernate);
		this.policiaHibernate = policiaHibernate;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Policia object) {
		object.validar();
		Busqueda filtro = Busqueda.forClass(Policia.class);
		//filtro.add(Restrictions.eq("nombres", object.getNombres()));
		/*if (PoliciaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_Policia_EXISTENTE,
					new Object[] { object.getNombres() });
		}*/
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Policia object) {
		object.validar();
		Busqueda filtro = Busqueda.forClass(Policia.class);
		/*filtro.add(Restrictions.eq("nombres", object.getNombres()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		/*if (PoliciaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_Policia_EXISTENTE,
					new Object[] { object.getNombres() });
		}*/
		policiaHibernate.actualizar(object);
	}

	public Policia obtener(Long id){		
		return policiaHibernate.obtener(id);
	}

	@Override
	public List<Policia> buscar(Policia Policia) {
		Busqueda filtro = Busqueda.forClass(Policia.class);
		
		if (Policia != null) {
			filtro.createAlias("persona", "per");
		
			if (Policia.getPersona().getNombres() != null && Policia.getPersona().getNombres().length() > 0) {
				filtro.add(Restrictions.ilike("per.nombres", Policia.getPersona().getNombres(), MatchMode.ANYWHERE));
			}
			
			if (Policia.getPersona().getApePaterno()!= null && Policia.getPersona().getApePaterno().length() > 0) {
				filtro.add(Restrictions.ilike("per.apePaterno", Policia.getPersona().getApePaterno(), MatchMode.ANYWHERE));
			}
			
			if (Policia.getPersona().getApeMaterno()!= null && Policia.getPersona().getApeMaterno().length() > 0) {
				filtro.add(Restrictions.ilike("per.apeMaterno", Policia.getPersona().getApeMaterno(), MatchMode.ANYWHERE));
			}
			
			if (Policia.getPersona().getNroDocumento()!= null) {
				filtro.add(Restrictions.ilike("per.nroDocumento", Policia.getPersona().getNroDocumento(), MatchMode.ANYWHERE));
			}
			
			if (Policia.getCip()!= null) {				
				filtro.add(Restrictions.ilike("cip", Policia.getCip(), MatchMode.ANYWHERE));				
			}
		}
		return policiaHibernate.buscar(filtro);		
	}
}
