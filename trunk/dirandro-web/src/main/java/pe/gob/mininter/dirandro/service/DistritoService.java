package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Distrito;
import pe.gob.mininter.dirandro.model.Valor;

public interface DistritoService extends BaseService<Distrito, Long> {
	
	public List<Distrito> listarTodos();
	
	public void registrarDistrito(Distrito distrito);
	
	public void registrarDistrito(List<Distrito> listaDistrito, Valor estado);
	
	public void inactivarRegistros(List<Distrito> listaDistrito, Valor estado);

}
