package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.DetPerInmExp;

public interface ExpedienteInmuebleService  extends BaseService<DetPerInmExp,String>{
	public List<DetPerInmExp> buscar(DetPerInmExp inmueble);
}