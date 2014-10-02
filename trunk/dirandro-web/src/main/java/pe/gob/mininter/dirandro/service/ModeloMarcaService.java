package pe.gob.mininter.dirandro.service;

import java.util.List;
import java.util.Map;

import pe.gob.mininter.dirandro.model.ModeloMarca;
import pe.gob.mininter.dirandro.model.Valor;

public interface ModeloMarcaService extends BaseService<ModeloMarca,Long>{
	
	public List<ModeloMarca> buscar(ModeloMarca modeloMarca);
	
	public List<ModeloMarca> buscarPorTipo(ModeloMarca modeloMarca,Valor valor);
	
	public List<ModeloMarca> listarMarcas();
	
	public Map<String,List<ModeloMarca>> listarModeloMarcas();
	
	public Map<String,List<ModeloMarca>> filtrarModelosMarcas(List<ModeloMarca> modelosMarcas);
	
	public List<ModeloMarca> buscarPadreHijos(ModeloMarca modeloMarca);
	
	public List<ModeloMarca> buscarPadres(ModeloMarca modeloMarca,Valor valor);
	
	public List<ModeloMarca> buscarHijos(ModeloMarca modelo);
	
	public List<ModeloMarca> buscarPadres();
}
