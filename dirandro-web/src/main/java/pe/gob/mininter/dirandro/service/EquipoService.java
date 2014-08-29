package pe.gob.mininter.dirandro.service;

import java.util.List;
import java.util.Map;

import pe.gob.mininter.dirandro.model.Equipo;

public interface EquipoService extends BaseService<Equipo,Long>{
	
	public List<Equipo> buscar(Equipo equipo);
	
	public Map<String, List<Equipo>> listarEquipos();
	
	public Map<String, List<Equipo>> filtrarEquipos(List<Equipo> lstEquipo);
	
}
