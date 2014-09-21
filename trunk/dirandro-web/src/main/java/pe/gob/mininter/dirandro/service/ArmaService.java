package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Arma;

public interface ArmaService extends BaseService<Arma,Long>{
	
	public List<Arma> buscar(Arma arma);
	
}
