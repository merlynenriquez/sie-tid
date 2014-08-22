package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Imagen;

public interface ImagenService  extends BaseService<Imagen,Long>{
	
	public Imagen registrarImagenAdjunta(Imagen imagen);

	public List<Imagen> buscar(Imagen imagen);
	
}