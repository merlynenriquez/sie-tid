package pe.gob.mininter.dirandro.vaadin.util.listener;

import java.io.Serializable;

import pe.gob.mininter.dirandro.vaadin.util.event.ColumnOrderChangedEvent;

public interface ColumnOrderChangedListener extends Serializable {

	void columnOrderChanged(ColumnOrderChangedEvent event);
	
}
