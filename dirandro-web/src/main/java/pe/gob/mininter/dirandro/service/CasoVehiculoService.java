package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.DetCasoVehiculo;

public interface CasoVehiculoService extends BaseService<DetCasoVehiculo, Long> {

	public List<DetCasoVehiculo> buscar(DetCasoVehiculo caso);
	
}
