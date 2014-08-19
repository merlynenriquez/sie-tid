package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Provincia;
import pe.gob.mininter.dirandro.model.Valor;

public interface ProvinciaService extends BaseService<Provincia, Long> {

	public List<Provincia> listarTodos();
	
	public void registrarProvincia(Provincia provincia);
	
	public void registrarProvincia(List<Provincia> listaProvincia, Valor estado);
	
	public void inactivarRegistros(List<Provincia> listaProvincia, Valor estado);
}
