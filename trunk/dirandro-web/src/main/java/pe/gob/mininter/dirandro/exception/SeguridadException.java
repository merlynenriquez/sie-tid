package pe.gob.mininter.dirandro.exception;

public class SeguridadException extends ErrorException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2290862193086193022L;
	
	private static final String TITULO_DEFECTO = "Validación de Formulario";

	public SeguridadException(String codigoMensaje, Object[] args,
			Throwable cause) {
		super(TITULO_DEFECTO, codigoMensaje, args, cause);
	}

}
