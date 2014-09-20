package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.DetPerTelExp;

public interface ExpedienteTelefonoService  extends BaseService<DetPerTelExp,Long>{
	
	public List<DetPerTelExp> buscar(DetPerTelExp detTelefono);
		
}