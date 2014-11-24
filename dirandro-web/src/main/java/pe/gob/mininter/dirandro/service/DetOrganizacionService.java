package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.DetOrganizacion;

public interface DetOrganizacionService extends BaseService<DetOrganizacion, Long> {

	List<DetOrganizacion> buscar(DetOrganizacion detOrganizacion);
	
}
