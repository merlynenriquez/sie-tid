package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Droga;
import pe.gob.mininter.dirandro.model.Expediente;

public interface DrogaService extends BaseService<Droga, Long> {
	
	List<Droga> obtenerDrogasExpediente(Expediente expediente);

}
