package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Empresa;

public interface EmpresaService extends BaseService<Empresa,Long>{
	
	public List<Empresa> buscar(Empresa empresa);
	List<Empresa> listarEmpresas();
	public Empresa obtener(Long id);	
	
}
