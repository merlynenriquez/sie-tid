package pe.gob.mininter.dirandro.vaadin.util;

import java.util.List;

import pe.gob.mininter.dirandro.model.Opcion;

import com.vaadin.ui.CustomComponent;

public abstract class HarecComponent extends CustomComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1355120342779674844L;
	
	private List<Opcion> acciones;
	
	public HarecComponent(List<Opcion> acciones)
	{
		this.acciones = acciones;
	}
	
	public abstract void postConstruct();
	
	protected Opcion obtenerAccion(String codigo)
	{
		if(acciones == null)
		{
			//TODO lanza excepcion
		}
		Opcion opcion = new Opcion();
		opcion.setCodigo(codigo);
		int index = acciones.indexOf(opcion);
		Opcion accion = acciones.get(index);		
		return accion;
	}
	
}
