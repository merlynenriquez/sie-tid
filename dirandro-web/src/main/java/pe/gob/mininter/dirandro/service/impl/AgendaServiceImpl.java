package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.AgendaHibernate;
import pe.gob.mininter.dirandro.model.Agenda;
import pe.gob.mininter.dirandro.service.AgendaService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
@SuppressWarnings("serial")
public class AgendaServiceImpl extends BaseServiceImpl<Agenda, Long> implements AgendaService {
	
	private AgendaHibernate agendaHibernate;
	
	@Autowired
	public AgendaServiceImpl(AgendaHibernate agendaHibernate) {
		super(agendaHibernate);
		this.agendaHibernate = agendaHibernate;
	}

	@Override
	public List<Agenda> buscar(Agenda agenda) {
		Busqueda filtro = Busqueda.forClass(Agenda.class);
		
		if(agenda.getNotificacion()!=null){
			if(agenda.getNotificacion()!=null && agenda.getNotificacion().getInforme()!=null){
				filtro.createAlias("notificacion", "n");
				filtro.createAlias("n.informe", "i");
				filtro.add(Restrictions.eq("i.id", agenda.getNotificacion().getInforme().getId()));
			}
		}
		
		return agendaHibernate.buscar(filtro);
	}
	
}
