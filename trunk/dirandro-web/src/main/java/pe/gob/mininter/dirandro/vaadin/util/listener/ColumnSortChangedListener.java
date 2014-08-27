package pe.gob.mininter.dirandro.vaadin.util.listener;

import java.io.Serializable;

import pe.gob.mininter.dirandro.vaadin.util.event.ColumnSortChangedEvent;

public interface ColumnSortChangedListener extends Serializable {

	void columnSortChanged(ColumnSortChangedEvent event);
	
}
