package pe.gob.mininter.dirandro.vaadin.util.listener;

import java.io.Serializable;

import pe.gob.mininter.dirandro.vaadin.util.event.FiltroChangedEvent;

public interface FiltroChangedListener extends Serializable {

	void filtroChanged(FiltroChangedEvent event);
	
}
