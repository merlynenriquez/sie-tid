package pe.gob.mininter.dirandro.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import pe.gob.mininter.dirandro.util.Busqueda;

public interface BaseHibernate<Entidad, TipoLlave> extends Serializable {

	public Entidad obtener(TipoLlave id);

	public void actualizar(Entidad object);

	public void crear(Entidad object);
	
	public void grabarTodos(List<Entidad> list);

	public void eliminar(Entidad object);

	public void eliminarXId(TipoLlave id);
	
	public 	void eliminarTodos(List<Entidad> list);

	public List<Entidad> obtenerTodos();
	
	public List<Entidad> buscar(final Busqueda filtro);
	
	public boolean contiene(TipoLlave tipoLlave);

}