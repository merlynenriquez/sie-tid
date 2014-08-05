package pe.gob.mininter.dirandro.exception;

public abstract class MensajeException extends BaseException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1510861540995268568L;

	public MensajeException(String titulo, String codigoMensaje, Object[] args) {
		super(titulo, codigoMensaje, args);
	}
	
}
