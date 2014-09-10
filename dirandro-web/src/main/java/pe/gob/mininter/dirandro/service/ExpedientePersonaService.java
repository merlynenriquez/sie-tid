package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.DetExpedientePersona;

public interface ExpedientePersonaService extends BaseService<DetExpedientePersona, Long> {
	
	public List<DetExpedientePersona> buscar(DetExpedientePersona expPersona);

}
