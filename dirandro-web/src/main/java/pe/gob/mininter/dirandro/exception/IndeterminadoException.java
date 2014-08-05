package pe.gob.mininter.dirandro.exception;

import org.apache.commons.lang.StringUtils;

public class IndeterminadoException extends ErrorException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2290862193086193022L;
	
	private static final String TITULO_DEFECTO = "Dato Indeterminado";
	private static final String KEY_MESSAGE = "error.indeterminado";
	//TODO completar este exception
/*
	public IndeterminadoException(Busqueda filtro) {
		super(TITULO_DEFECTO, KEY_MESSAGE, new Object[]{filtro != null ? filtro.toString() : StringUtils.EMPTY});
	}
	*/
	public IndeterminadoException(Object valor) {
		super(TITULO_DEFECTO, KEY_MESSAGE, new Object[]{valor});
	}

}
