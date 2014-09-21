package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.DetExpedientePersona;
import pe.gob.mininter.dirandro.model.Expediente;

public interface ExpedientePersonaService extends BaseService<DetExpedientePersona, Long> {
	
	public List<DetExpedientePersona> buscar(DetExpedientePersona expPersona);

	public List<DetExpedientePersona> cargarIntervinientes(Expediente expediente);

}
