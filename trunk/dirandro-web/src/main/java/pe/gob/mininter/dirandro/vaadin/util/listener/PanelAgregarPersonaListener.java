package pe.gob.mininter.dirandro.vaadin.util.listener;

import java.io.Serializable;

import pe.gob.mininter.dirandro.model.Persona;

public interface PanelAgregarPersonaListener extends Serializable {

	void setPersonaPopUp(Persona persona);
}
