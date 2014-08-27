package pe.gob.mininter.dirandro.vaadin.util.event;

import com.vaadin.ui.Component;
import com.vaadin.ui.Component.Event;

public class ColumnShownChangedEvent extends Event {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4239473515083418892L;

	public ColumnShownChangedEvent(Component source) {
		super(source);
	}
	
}
