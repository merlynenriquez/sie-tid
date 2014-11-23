package pe.gob.mininter.dirandro.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dirandro.dao.hibernate.SituacionProcesoHibernate;
import pe.gob.mininter.dirandro.model.DetExpedientePersona;
import pe.gob.mininter.dirandro.model.SituacionProceso;
import pe.gob.mininter.dirandro.service.SituacionProcesoService;
import pe.gob.mininter.dirandro.util.Busqueda;

@Service
public class SituacionProcesoServiceImpl extends BaseServiceImpl<SituacionProceso, Long> implements SituacionProcesoService {

	private static final long serialVersionUID = -6023109311267834442L;

	private SituacionProcesoHibernate situacionProcesoHibernate;
	
	@Autowired
	public SituacionProcesoServiceImpl(SituacionProcesoHibernate situacionProcesoHibernate) {
		super(situacionProcesoHibernate);
		this.situacionProcesoHibernate = situacionProcesoHibernate;
	}

	@Override
	public SituacionProceso obtenerSituacionProcesoxPersona(
			DetExpedientePersona persona) {
		Busqueda filtro = Busqueda.forClass(SituacionProceso.class);
		if(persona!=null){
			filtro.createAlias("procesado", "p");
			filtro.add(Restrictions.eq("p.id",persona.getId()));
		}
		List<SituacionProceso> list = situacionProcesoHibernate.buscar(filtro);
	
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

}
