package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.HojaremisionMuestra;

public interface HojaRemisionMuestraService extends BaseService<HojaremisionMuestra,Long>{
	
	public List<HojaremisionMuestra> buscar(HojaremisionMuestra hojaremisionMuestra);
	
}
