package pe.gob.mininter.dirandro.service;

import java.util.List;
import java.util.Map;

import pe.gob.mininter.dirandro.model.TipoEspecie;

public interface TipoEspecieService extends BaseService<TipoEspecie, Long> {

	public List<TipoEspecie> listarTipoEspecie();
	
	public List<TipoEspecie> buscar(TipoEspecie tipoEspecie);
	
	public Map<String, List<TipoEspecie>> listarTipoEspecieMap();
	
	public Map<String, List<TipoEspecie>> filtrarTipoEspecie(List<TipoEspecie> lstTipoEspecie) ;
	
	public List<TipoEspecie> buscarPadreHijos(TipoEspecie tipoEspecie);
	
	public List<TipoEspecie> buscarPadres();

	public List<TipoEspecie> buscarHijos(TipoEspecie especie);
	
}
