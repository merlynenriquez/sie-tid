package pe.gob.mininter.dirandro.exception;


public class BloqueoException extends AlertaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2558693133828625388L;
	
	private static final String TITULO_DEFECTO = "Bloqueo de requerimiento: ";

	public BloqueoException(String codigoMensaje, Object[] args) {
		super(TITULO_DEFECTO, codigoMensaje, args);
	}
}
