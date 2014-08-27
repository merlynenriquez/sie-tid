package pe.gob.mininter.dirandro.vaadin.util.event;

import java.util.Map;

import pe.gob.mininter.dirandro.vaadin.util.TablaFiltro;

import com.vaadin.ui.Component.Event;

public class FiltroChangedEvent extends Event {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5061060718602014206L;
	
	private Map<String, Object> filtros;

	public FiltroChangedEvent(TablaFiltro source) {
		super(source);
		filtros = source.getValues();
	}
	
	public Map<String, Object> getFiltros()
	{
		return filtros;
	}
	
}
