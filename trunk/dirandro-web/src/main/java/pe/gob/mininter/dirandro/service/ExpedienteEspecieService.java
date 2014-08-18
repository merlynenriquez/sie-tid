

package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Especie;

public interface ExpedienteEspecieService  extends BaseService<Especie,Long>{
	
	public List<Especie> buscar(Especie especie);
		
}