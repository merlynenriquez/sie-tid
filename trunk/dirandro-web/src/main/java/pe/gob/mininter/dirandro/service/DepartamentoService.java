package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Departamento;
import pe.gob.mininter.dirandro.model.Valor;

public interface DepartamentoService extends BaseService<Departamento, Long> {
	
	public List<Departamento> listarTodos();
	
	public void registrarDepartamento(Departamento departamento);
	
	public void registrarDepartamento(List<Departamento> listaDepartamento, Valor estado);
	
	public void inactivarRegistros(List<Departamento> listaDepartamento, Valor estado);
	
}
 