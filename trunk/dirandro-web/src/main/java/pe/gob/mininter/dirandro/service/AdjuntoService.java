package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Adjunto;

public interface AdjuntoService extends BaseService<Adjunto,Long>{
	
	public List<Adjunto> buscar(Adjunto adjunto);
	
}
