package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.ExpedienteDelito;

public interface ExpedienteDelitoService extends BaseService<ExpedienteDelito, Long> {
	
	public List<ExpedienteDelito> buscar(ExpedienteDelito expDelito);

}
