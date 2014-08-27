package pe.gob.mininter.dirandro.vaadin.util.container;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.vaadin.data.util.IndexedContainer;

public class TablaFiltroIndexedContainer extends IndexedContainer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6355375036381697923L;
	private Map<Object, Columna> mapColumnas;
	
	public boolean addContainerProperty(Object propertyId, Class<?> type,
			Object defaultValue, String nombre, TipoComponente tipoComponente, boolean busquedaPuntual,
			float ancho) {
		return addContainerProperty(propertyId, type, defaultValue, nombre, tipoComponente, busquedaPuntual, ancho, null);
	}
	
	public boolean addContainerProperty(Object propertyId, Class<?> type,
			Object defaultValue, String nombre, TipoComponente tipoComponente, boolean busquedaPuntual,
			float ancho, String formato) {
		if(mapColumnas == null)
		{
			mapColumnas = new LinkedHashMap<Object, Columna>();			
		}
		mapColumnas.put(propertyId, new Columna(propertyId, nombre, tipoComponente, busquedaPuntual, ancho, formato));
		return super.addContainerProperty(propertyId, type, defaultValue);
	}
	
	public enum TipoComponente
	{
		TEXT,DATEPICKER
	}
	
	public class Columna implements Serializable
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = -2759841946633689777L;
		private Object propertyId;
		private String nombre;
		private TipoComponente tipoComponente;
		private boolean busquedaPuntual;
		private float ancho;
		private String formato;
		
		public Columna(Object propertyId, String nombre, TipoComponente tipoComponente, boolean busquedaPuntual,
				float ancho) {
			this(propertyId, nombre, tipoComponente, busquedaPuntual, ancho, null);
		}
		
		public Columna(Object propertyId, String nombre, TipoComponente tipoComponente, boolean busquedaPuntual,
				float ancho, String formato) {
			this.propertyId = propertyId;
			this.nombre = nombre;
			this.tipoComponente = tipoComponente;
			this.busquedaPuntual = busquedaPuntual;
			this.ancho = ancho;
			this.formato = formato;
		}

		public String getNombre() {
			return nombre;
		}

		public TipoComponente getTipoComponente() {
			return tipoComponente;
		}

		public boolean isBusquedaPuntual() {
			return busquedaPuntual;
		}

		public float getAncho() {
			return ancho;
		}

		public Object getPropertyId() {
			return propertyId;
		}

		public void setFormato(String formato) {
			this.formato = formato;
		}	
		
	}
	
	public List<Columna> getColumnas()
	{
		Set<Entry<Object, Columna>> sets = mapColumnas.entrySet();
		Iterator<Entry<Object, Columna>> iterator = sets.iterator();
		List<Columna> columnas = new ArrayList<Columna>();
		while(iterator.hasNext())
		{
			Entry<Object, Columna> entry = iterator.next();
			columnas.add(entry.getValue());
		}
		return columnas;
	}
	
	public Columna getColumna(Object propertyId)
	{
		return mapColumnas.get(propertyId);
	}
	
	public Columna getColumnaPorNombre(String nombre)
	{
		List<Columna> columnas = getColumnas();
		for (Columna columna : columnas) {
			if(columna.getNombre().equals(nombre))
			{
				return mapColumnas.get(columna.getPropertyId());
			}
		}
		return null;
	}

}
