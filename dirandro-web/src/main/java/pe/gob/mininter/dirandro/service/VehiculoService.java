package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Vehiculo;

public interface VehiculoService extends BaseService<Vehiculo, Long> {

	List<Vehiculo> buscar(Vehiculo vehiculo);

}
