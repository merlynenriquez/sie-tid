package pe.gob.mininter.dirandro.service;

import pe.gob.mininter.dirandro.model.Detalle;

public interface DetallePersonaService extends BaseService<Detalle,Long>{

	//public List<Detalle> buscar(Detalle detalle);
	//Map<String,List<Detalle>> listarDetalle();

	public Detalle obtener(Long id);

	public Detalle obtenerPorPersona(Long idPersona);	
	
}
