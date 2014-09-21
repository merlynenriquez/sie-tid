package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.NoIdentificado;

public interface NoIdentificadoService extends BaseService<NoIdentificado, Long> {

	List<NoIdentificado> cargarDelExpediente(Expediente expediente);

}
