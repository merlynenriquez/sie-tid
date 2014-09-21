package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.DetPerArmExp;

public interface ExpedienteArmaService extends BaseService<DetPerArmExp,Long>{
	
	public List<DetPerArmExp> buscar(DetPerArmExp arma);
	
}
