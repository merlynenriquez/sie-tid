package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.ExplosivoHibernate;
import pe.gob.mininter.dirandro.model.Explosivo;
import pe.gob.mininter.dirandro.service.ExplosivoService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class ExplosivoServiceImpl extends BaseServiceImpl<Explosivo, Long> implements ExplosivoService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2697106645391028183L;
	
	private ExplosivoHibernate explosivoHibernate;
	
	@Autowired
	public ExplosivoServiceImpl(ExplosivoHibernate explosivoHibernate) {
		super(explosivoHibernate);
		this.explosivoHibernate = explosivoHibernate;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Explosivo object) {
		object.validar();
		Busqueda filtro = Busqueda.forClass(Explosivo.class);
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
	public void actualizar(Explosivo object) {
		object.validar();
		Busqueda filtro = Busqueda.forClass(Explosivo.class);
		/*filtro.add(Restrictions.eq("nombres", object.getNombres()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		/*if (PoliciaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_Policia_EXISTENTE,
					new Object[] { object.getNombres() });
		}*/
		explosivoHibernate.actualizar(object);
	}

	public Explosivo obtener(Long id){		
		return explosivoHibernate.obtener(id);
	}

	@Override
	public List<Explosivo> buscar(Explosivo explosivo) {
		
		Busqueda filtro = Busqueda.forClass(Explosivo.class);
		
		if (explosivo != null) {
			
			/*filtro.createAlias("perPersona", "per");
		
			if (Policia.getPerPersona().getNombres() != null && Policia.getPerPersona().getNombres().length() > 0) {
				filtro.add(Restrictions.ilike("per.nombres", Policia.getPerPersona().getNombres(), MatchMode.ANYWHERE));
			}
			
			if (Policia.getPerPersona().getApePaterno()!= null && Policia.getPerPersona().getApePaterno().length() > 0) {
				filtro.add(Restrictions.ilike("per.apePaterno", Policia.getPerPersona().getApePaterno(), MatchMode.ANYWHERE));
			}
			
			if (Policia.getPerPersona().getApeMaterno()!= null && Policia.getPerPersona().getApeMaterno().length() > 0) {
				filtro.add(Restrictions.ilike("per.apeMaterno", Policia.getPerPersona().getApeMaterno(), MatchMode.ANYWHERE));
			}
			
			if (Policia.getPerPersona().getNroDocumento()!= null) {
				filtro.add(Restrictions.ilike("per.nroDocumento", Policia.getPerPersona().getNroDocumento(), MatchMode.ANYWHERE));
			}*/
			
			/*filtro.createAlias("perPersona", "per");
			if (empresa.getPerPersona() != null && empresa.getRazonSocial().length() > 0) {
				filtro.add(Restrictions.ilike("razon_social", empresa.getRazonSocial(), MatchMode.ANYWHERE));
			}
						
			if (empresa.getRazonSocial() != null && empresa.getRazonSocial().length() > 0) {
				filtro.add(Restrictions.ilike("razonSocial", empresa.getRazonSocial(), MatchMode.ANYWHERE));
			}
			else
			if (empresa.getRuc() != null && empresa.getRuc().length() > 0) {
				filtro.add(Restrictions.ilike("ruc", empresa.getRuc(), MatchMode.ANYWHERE));
			}*/
								
		}
		return explosivoHibernate.buscar(filtro);		
	}

	
}
