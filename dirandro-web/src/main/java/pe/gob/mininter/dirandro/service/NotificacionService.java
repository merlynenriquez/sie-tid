package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Notificacion;

public interface NotificacionService extends BaseService<Notificacion, Long> {

	List<Notificacion> buscar(Notificacion notificacion);
	
}
