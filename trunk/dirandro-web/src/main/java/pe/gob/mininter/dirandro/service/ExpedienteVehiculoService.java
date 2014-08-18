package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.DetPerVehExp;

public interface ExpedienteVehiculoService  extends BaseService<DetPerVehExp,Long>{
	
	public List<DetPerVehExp> buscar(DetPerVehExp detPerVehExp);
		
}