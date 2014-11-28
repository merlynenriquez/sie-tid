package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.AgendaActor;

public interface AgendaActorService extends BaseService<AgendaActor, Long> {

	List<AgendaActor> buscar(AgendaActor agendaActor);
	
}
