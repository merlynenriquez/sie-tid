package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.AgendaActorHibernate;
import pe.gob.mininter.dirandro.model.AgendaActor;
import pe.gob.mininter.dirandro.service.AgendaActorService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
@SuppressWarnings("serial")
public class AgendaActorServiceImpl extends BaseServiceImpl<AgendaActor, Long> implements AgendaActorService {
	
	private AgendaActorHibernate agendaActorHibernate;
	
	@Autowired
	public AgendaActorServiceImpl(AgendaActorHibernate agendaActorHibernate) {
		super(agendaActorHibernate);
		this.agendaActorHibernate = agendaActorHibernate;
	}

	@Override
	public List<AgendaActor> buscar(AgendaActor aerodromo) {
		Busqueda filtro = Busqueda.forClass(AgendaActor.class);
		
		/*if (aerodromo != null) {
			if(aerodromo.getNombre()!=null && StringUtils.isNotBlank(aerodromo.getNombre())){
				filtro.add(Restrictions.ilike("nombre", aerodromo.getNombre(), MatchMode.ANYWHERE));
			}
			if(aerodromo.getEmpresa()!=null && 
					StringUtils.isNotBlank(aerodromo.getEmpresa().getRazonSocial())){
				filtro.createAlias("empresa", "e");
				filtro.add(Restrictions.ilike("e.razonSocial", aerodromo.getEmpresa().getRazonSocial(), MatchMode.ANYWHERE));
			}
			if(aerodromo.getAeronaveMaxima()!=null && 
					StringUtils.isNotBlank(aerodromo.getAeronaveMaxima().getNombre())){
				filtro.createAlias("aeronaveMaxima", "a");
				filtro.add(Restrictions.ilike("a.nombre", aerodromo.getAeronaveMaxima().getNombre(), MatchMode.ANYWHERE));
			}
			if(aerodromo.getUbicacion()!=null && 
					StringUtils.isNotBlank(aerodromo.getUbicacion().getNombre())){
				filtro.createAlias("ubicacion", "u");
				filtro.createAlias("u.provincia", "p");
				filtro.createAlias("p.departamento", "d");
				filtro.add(Restrictions.or(
				Restrictions.ilike("u.nombre", aerodromo.getUbicacion().getNombre(),MatchMode.ANYWHERE),
				Restrictions.ilike("p.nombre", aerodromo.getUbicacion().getNombre(),MatchMode.ANYWHERE),
				Restrictions.ilike("d.nombre", aerodromo.getUbicacion().getNombre(),MatchMode.ANYWHERE)));
			}
		}
		
		return aerodromoHibernate.buscar(filtro);*/
		return null;
	}
	
}
