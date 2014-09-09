package pe.gob.mininter.dirandro.service;

import pe.gob.mininter.dirandro.model.Documento;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.Ruta;

public interface ExpedienteService extends BaseService<Expediente,Long> {
	
	void registrarExpediente(Expediente expediente, Documento documento, Ruta ruta);
	
	void agregarDocumento(Expediente expediente, Documento documento);

}
