package pe.gob.mininter.dirandro.vaadin.panel.util;

import pe.gob.mininter.dirandro.model.Dependencia;

/**
 * interface para las ventanas que utilizaran el componente de dependencia
 * @author ecampos
 *
 */
public interface DependenciaSelector {

	public Dependencia getDependencia();
	public void setDependencia(Dependencia dependencia);
	
}
