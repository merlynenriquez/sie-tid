package pe.gob.mininter.dirandro.exception;

public abstract class ErrorException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8339508402196328494L;

	public ErrorException(String titulo, String codigoMensaje, Object[] args, Throwable cause) {
		super(titulo, codigoMensaje, args, cause);
	}

	public ErrorException(String titulo, String codigoMensaje, Object[] args) {
		super(titulo, codigoMensaje, args);
	}

}
