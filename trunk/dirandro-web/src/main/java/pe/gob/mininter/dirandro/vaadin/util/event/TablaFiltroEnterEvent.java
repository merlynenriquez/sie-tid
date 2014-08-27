package pe.gob.mininter.dirandro.vaadin.util.event;

import java.util.Map;

import pe.gob.mininter.dirandro.vaadin.util.TablaFiltro;

public class TablaFiltroEnterEvent {
	
	private Map<String, Object> datos;
	private Object sender;
	private Object target;
	private TablaFiltro tablaFiltro;

	public void setDatos(Map<String, Object> datos) {
		this.datos = datos;
	}

	public Map<String, Object> getDatos() {
		return datos;
	}

	public Object getSender() {
		return sender;
	}

	public void setSender(Object sender) {
		this.sender = sender;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public TablaFiltro getTablaFiltro() {
		return tablaFiltro;
	}

	public void setTablaFiltro(TablaFiltro tablaFiltro) {
		this.tablaFiltro = tablaFiltro;
	}

}
