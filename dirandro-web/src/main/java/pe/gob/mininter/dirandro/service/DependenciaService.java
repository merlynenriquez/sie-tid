package pe.gob.mininter.dirandro.service;

import java.util.List;
import java.util.Map;

import pe.gob.mininter.dirandro.model.Dependencia;

public interface DependenciaService  extends BaseService<Dependencia, Long>{
	
	public List<Dependencia> buscar(Dependencia dependencia);

	public Map<String, List<Dependencia>> listarDependencias();

	public Map<String, List<Dependencia>> filtrarDependencias(List<Dependencia> lstDependencias);

	public List<Dependencia> buscarPadreHijos(Dependencia dependencia);
	
	public List<Dependencia> buscarHijos(Dependencia dependencia);  

	public Dependencia buscarDependencia(Long id);
	
	public Dependencia buscarPadre(Long id);
	
}
