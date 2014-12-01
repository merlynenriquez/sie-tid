package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

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
	public List<AgendaActor> buscar(AgendaActor agendaActor) {
		Busqueda filtro = Busqueda.forClass(AgendaActor.class);
		
		if(agendaActor!=null){
			if(agendaActor.getAgenda()!=null){
				filtro.createAlias("agenda", "a");
				filtro.add(Restrictions.eq("a.id", agendaActor.getAgenda().getId()));
			}
		}
		
		return agendaActorHibernate.buscar(filtro);
	}
	
}
