package pe.gob.mininter.dirandro.service.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.PoliciaHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.Policia;
import pe.gob.mininter.dirandro.service.PoliciaService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;

@Service
public class PoliciaServiceImpl extends BaseServiceImpl<Policia, Long> implements PoliciaService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2697106645391028183L;
	
	private PoliciaHibernate PoliciaHibernate;
	
	@Autowired
	public PoliciaServiceImpl(PoliciaHibernate PoliciaHibernate) {
		super(PoliciaHibernate);
		this.PoliciaHibernate = PoliciaHibernate;
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
		PoliciaHibernate.actualizar(object);
	}

	public Policia obtener(Long id){		
		return PoliciaHibernate.obtener(id);
	}

	@Override
	public List<Policia> buscar(Policia Policia) {
		
		Busqueda filtro = Busqueda.forClass(Policia.class);
		
		/*
		if (Policia != null) {
		
			if (Policia.getTipoDocumento()!= null) {
				filtro.createAlias("tipoDocumento", "t");
				filtro.add(Restrictions.ilike("t.nombre", Policia.getTipoDocumento().getNombre(), MatchMode.ANYWHERE));				
			}
			
			if (Policia.getNroDocumento()!= null) {
				filtro.add(Restrictions.ilike("nroDocumento",Policia.getNroDocumento(), MatchMode.ANYWHERE));
			}
			if (Policia.getNombres()!= null) {
				filtro.add(Restrictions.ilike("nombres",Policia.getNombres(), MatchMode.ANYWHERE));
			}			
			
			if (Policia.getApePaterno()!= null) {
				filtro.add(Restrictions.ilike("apePaterno",Policia.getApePaterno(), MatchMode.ANYWHERE));
			}
			if (Policia.getApeMaterno()!= null) {
				filtro.add(Restrictions.ilike("apeMaterno",Policia.getApeMaterno(), MatchMode.ANYWHERE));
			}
			if (Policia.getSexo()!= null) {
				filtro.add(Restrictions.ilike("sexo",Policia.getSexo(), MatchMode.ANYWHERE));
			}
		
			if (Policia.getFecNacimiento()!= null) {
				filtro.add(Restrictions.eq("fecNacimiento",Policia.getFecNacimiento()));
			}
			
			if (Policia.getEstadoCivil()!= null) {
				filtro.createAlias("estadoCivil", "e");
				filtro.add(Restrictions.ilike("e.nombre", Policia.getEstadoCivil().getNombre(), MatchMode.ANYWHERE));				
			}
					
			if (Policia.getNacionalidad()!= null) {
				filtro.createAlias("nacionalidad", "n");
				filtro.add(Restrictions.ilike("n.nombre", Policia.getNacionalidad().getNombre(), MatchMode.ANYWHERE));				
			}
		
		}		*/
		return PoliciaHibernate.buscar(filtro);		
	}

	@Override
	public List<Policia> listarPolicias() {
		Busqueda filtro = Busqueda.forClass(Policia.class);
		filtro.createAlias("persona", "per");
		filtro.addOrder(Order.asc("per.nombres")); 
		return PoliciaHibernate.buscar(filtro);
	}

	
}
