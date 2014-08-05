package pe.gob.mininter.dirandro.exception;

public abstract class AlertaException extends BaseException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1510861540995268568L;

	public AlertaException(String titulo, String codigoMensaje, Object[] args) {
		super(titulo, codigoMensaje, args);
	}
	
	public AlertaException(String titulo, String codigoMensaje, Object[] args, Throwable cause) {
		super(titulo, codigoMensaje, args, cause);
	}
}
