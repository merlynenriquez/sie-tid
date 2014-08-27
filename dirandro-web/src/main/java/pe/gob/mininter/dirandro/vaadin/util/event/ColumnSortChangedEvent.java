package pe.gob.mininter.dirandro.vaadin.util.event;

import com.vaadin.ui.Component;
import com.vaadin.ui.Component.Event;

public class ColumnSortChangedEvent extends Event {

	/**
	 * 
	 */
	private static final long serialVersionUID = 253045717275302141L;

	public ColumnSortChangedEvent(Component source) {
		super(source);
	}

}
