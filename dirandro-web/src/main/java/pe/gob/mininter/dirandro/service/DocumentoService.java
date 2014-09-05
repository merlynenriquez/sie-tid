package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Documento;
import pe.gob.mininter.dirandro.model.Expediente;

public interface DocumentoService extends BaseService<Documento, Long> {
	
	List<Documento> obtenerDocumentosDelExpediente(Expediente expediente);

}
