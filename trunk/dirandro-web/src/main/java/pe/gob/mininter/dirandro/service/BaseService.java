package pe.gob.mininter.dirandro.service;

import java.io.Serializable;
import java.util.List;

import pe.gob.mininter.dirandro.util.Busqueda;

/**
 * Servicio base que contempla las implementaciones base.
 * 
 * @param <Entidad> Clase principal a tratar
 * @param <TipoLlave> Tipo de llave de la clase principal
 */
public interface BaseService<Entidad, TipoLlave> extends Serializable {

	/**
	 * Obtiene el recurso (Entidad) segun su indentificador (TipoLlave) 
	 * 
	 * @param id - indentificador para buscar
	 * @return Entidad según el id enviado.
	 */
	public Entidad obtener(TipoLlave id);

	/**
	 * Actualiza la entidad o recurso enviado como parametro.
	 * @param object - Entidad a actualizar
	 */
	public void actualizar(Entidad object);

	/**
	 * Graba una nueva entidad.
	 * @param object - Entidad a grabar
	 */
	public void crear(Entidad object);

	/**
	 * Graba la lista que se le envia como parametro, crea o actualiza entidades.
	 * @param list - Lista de entidades a grabar.
	 */
	public void grabarTodos(List<Entidad> list);
	
	/**
	 * Elimina la entidad enviada.
	 * @param object - Entidad a enviar.
	 */
	public void eliminar(Entidad object);

	/**
	 * Similar a "eliminar" 
	 * @param id - Id de la entidad a eliminar.
	 */
	public void eliminarXId(TipoLlave id);
	
	/**
	 * Eliminación en bloque.
	 * @param list - Lista de las entidades a eliminar.
	 */	
	public void eliminarTodos(List<Entidad> list);	
	
	/**
	 * Obtener una lista de cualquier entidad
	 * @return Lista de Entidades segun la clase
	 */
	public List<Entidad> obtenerTodos();
	
	/**
	 * 
	 * @param filtro - filtro que se le envia para poder hacer la busqueda
	 * @return Lista de Entidades segun la clase
	 */
	public List<Entidad> buscar(final Busqueda filtro);
	
	/**
	 * Obtiene el recurso (Entidad) segun su indentificador (codigo) 
	 * 
	 * @param id - indentificador para buscar
	 * @return Entidad según el codigo enviado.
	 */
	public Entidad obtenerPorCodigo(String codigo);
	
	
	
	
	
	

	

	
	
	

	

	
	
	

	
	
	
}
