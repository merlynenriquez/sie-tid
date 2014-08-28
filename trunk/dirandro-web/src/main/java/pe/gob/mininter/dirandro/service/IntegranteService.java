package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Integrante;

public interface IntegranteService extends BaseService<Integrante, Long>  {

	public List<Integrante> listarIntegrantes();
	
	public List<Integrante> buscar(Integrante integrante);
	
}
