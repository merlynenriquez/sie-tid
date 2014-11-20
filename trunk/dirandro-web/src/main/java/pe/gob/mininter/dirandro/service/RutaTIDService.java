package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.RutaTid;

public interface RutaTIDService extends BaseService<RutaTid, Long> {
	
	public List<RutaTid> buscar(RutaTid rutaTid);
	

}
