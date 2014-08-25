package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Organizacion;

public interface OrganizacionService extends BaseService<Organizacion,Long>{
	
	public List<Organizacion> buscar(Organizacion organizacion);
	List<Organizacion> listarOrganizaciones();
	public Organizacion obtener(Long id);	
	
}
