package pe.gob.mininter.dirandro.vaadin.util;

import pe.gob.mininter.dirandro.util.Constante;

public class ComboBoxTabla extends ComboBoxLOVS {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8219635513426361706L;
	
	public ComboBoxTabla() {
		super(Constante.LISTA.CODIGO.TABLAS);
	}
	
	@Override
	public void attach() {
		super.attach();
		setItemCaptionPropertyId("descripcion");
	}

}
