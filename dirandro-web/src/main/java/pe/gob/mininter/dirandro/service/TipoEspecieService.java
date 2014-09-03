package pe.gob.mininter.dirandro.service;

import java.util.List;
import java.util.Map;

import pe.gob.mininter.dirandro.model.TipoEspecie;

public interface TipoEspecieService extends BaseService<TipoEspecie, Long> {

	List<TipoEspecie> listarTipoEspecie();
	public List<TipoEspecie> buscar(TipoEspecie tipoEspecie);
	public TipoEspecie buscarTipoEspecie(Long id);
	public Map<String, List<TipoEspecie>> listarTipoEspecieMap();
	public Map<String, List<TipoEspecie>> filtrarTipoEspecie(List<TipoEspecie> lstTipoEspecie) ;
	public List<TipoEspecie> buscarPadreHijos(TipoEspecie tipoEspecie);
}
