package pe.gob.mininter.dirandro.service;

import pe.gob.mininter.dirandro.model.DetExpedientePersona;
import pe.gob.mininter.dirandro.model.SituacionProceso;

public interface SituacionProcesoService extends BaseService<SituacionProceso, Long> {
	
	SituacionProceso obtenerSituacionProcesoxPersona(DetExpedientePersona persona);
	
}
