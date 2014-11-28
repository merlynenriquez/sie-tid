package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Agenda;

public interface AgendaService extends BaseService<Agenda, Long> {

	List<Agenda> buscar(Agenda agenda);
	
}
