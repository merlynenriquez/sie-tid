package pe.gob.mininter.dirandro.service;

import java.util.List;
import java.util.Map;

import pe.gob.mininter.dirandro.model.TipoHecho;

public interface TipoHechoService extends BaseService<TipoHecho, Long> {

	public List<TipoHecho> listarTipoHecho();

	public List<TipoHecho> buscar(TipoHecho delito);

	public TipoHecho buscarTipoHecho(Long id);

	public Map<String, List<TipoHecho>> listarTipoHechoMap();

	public Map<String, List<TipoHecho>> filtrarTipoHecho(List<TipoHecho> lstTipoHecho);

	public List<TipoHecho> buscarPadreHijos(TipoHecho tipoHecho);
	
	public List<TipoHecho> buscarPadres();
	
	public List<TipoHecho> buscarHijos(TipoHecho tipoHecho);
}
