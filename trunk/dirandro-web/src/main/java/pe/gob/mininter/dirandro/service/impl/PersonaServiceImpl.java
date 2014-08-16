package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.PersonaHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.Persona;
import pe.gob.mininter.dirandro.service.PersonaService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2697106645391028183L;
	
	private PersonaHibernate personaHibernate;
	
	@Autowired
	public PersonaServiceImpl(PersonaHibernate personaHibernate) {
		super(personaHibernate);
		this.personaHibernate = personaHibernate;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Persona object) {
		object.validar();
		Busqueda filtro = Busqueda.forClass(Persona.class);
		filtro.add(Restrictions.eq("nombres", object.getNombres()));
		if (personaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_PERSONA_EXISTENTE,
					new Object[] { object.getNombres() });
		}
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Persona object) {
		object.validar();
		Busqueda filtro = Busqueda.forClass(Persona.class);
		filtro.add(Restrictions.eq("nombres", object.getNombres()));
		filtro.add(Restrictions.not(Restrictions.eq("id", object.getId())));
		if (personaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_PERSONA_EXISTENTE,
					new Object[] { object.getNombres() });
		}
		personaHibernate.actualizar(object);
	}

	public Persona obtener(Long id){		
		return personaHibernate.obtener(id);
	}

	@Override
	public List<Persona> buscar(Persona persona) {
		
		Busqueda filtro = Busqueda.forClass(Persona.class);
		
		if (persona != null) {
		
			if (persona.getTipoDocumento()!= null) {
				filtro.createAlias("tipoDocumento", "t");
				filtro.add(Restrictions.ilike("t.nombre", persona.getTipoDocumento().getNombre(), MatchMode.ANYWHERE));				
			}
			
			if (persona.getNroDocumento()!= null) {
				filtro.add(Restrictions.ilike("nroDocumento",persona.getNroDocumento(), MatchMode.ANYWHERE));
			}
			if (persona.getNombres()!= null) {
				filtro.add(Restrictions.ilike("nombres",persona.getNombres(), MatchMode.ANYWHERE));
			}			
			
			if (persona.getApePaterno()!= null) {
				filtro.add(Restrictions.ilike("apePaterno",persona.getApePaterno(), MatchMode.ANYWHERE));
			}
			if (persona.getApeMaterno()!= null) {
				filtro.add(Restrictions.ilike("apeMaterno",persona.getApeMaterno(), MatchMode.ANYWHERE));
			}
			if (persona.getSexo()!= null) {
				filtro.add(Restrictions.ilike("sexo",persona.getSexo(), MatchMode.ANYWHERE));
			}
		
			if (persona.getFecNacimiento()!= null) {
				filtro.add(Restrictions.eq("fecNacimiento",persona.getFecNacimiento()));
			}
			
			if (persona.getEstadoCivil()!= null) {
				filtro.createAlias("estadoCivil", "e");
				filtro.add(Restrictions.ilike("e.nombre", persona.getEstadoCivil().getNombre(), MatchMode.ANYWHERE));				
			}
					
			if (persona.getNacionalidad()!= null) {
				filtro.createAlias("nacionalidad", "n");
				filtro.add(Restrictions.ilike("n.nombre", persona.getNacionalidad().getNombre(), MatchMode.ANYWHERE));				
			}
		/*
			if (persona.getLugarNacimiento()!= null) {
				filtro.createAlias("lugarNacimiento", "d");
				filtro.add(Restrictions.ilike("d.nombre",persona.getLugarNacimiento().getNombre(), MatchMode.ANYWHERE));
			}

		*/
		}		
		return personaHibernate.buscar(filtro);		
	}
}
