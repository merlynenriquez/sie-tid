package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.DetDroga;

public interface DetalleDrogaService extends BaseService<DetDroga, Long> {

	public List<DetDroga> buscar(DetDroga detalleDroga);
	
}