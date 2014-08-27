package pe.gob.mininter.dirandro.vaadin.util.event;

import com.vaadin.ui.Component;
import com.vaadin.ui.Component.Event;

public class ColumnOrderChangedEvent extends Event {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5344719090947148511L;
	
	public ColumnOrderChangedEvent(Component source) {
		super(source);
	}

}
