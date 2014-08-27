package pe.gob.mininter.dirandro.vaadin.util.listener;

import java.io.Serializable;

import pe.gob.mininter.dirandro.vaadin.util.event.ColumnShownChangedEvent;

public interface ColumnShownChangedListener extends Serializable {

	void columnShownChanged(ColumnShownChangedEvent event);
}
