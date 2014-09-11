package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Documento;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.Ruta;
import pe.gob.mininter.dirandro.util.FormBandejaTrabajo;

public interface ExpedienteService extends BaseService<Expediente,Long> {
	
	void registrarExpediente(Expediente expediente, Documento documento, Ruta ruta);
	
	void agregarDocumento(Expediente expediente, Documento documento);
	
	List<Expediente> obtenerBandejaDeTrabajo(FormBandejaTrabajo form);

}
