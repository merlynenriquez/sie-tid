package pe.gob.mininter.dirandro.exception;


public class ValidacionException extends AlertaException {

	private static final long serialVersionUID = 2558693133828625388L;
	
	private static final String TITULO_DEFECTO = "Validación de Formulario";

	public ValidacionException(String codigoMensaje, Object[] args) {
		super(TITULO_DEFECTO, codigoMensaje, args);
	}
	
	public ValidacionException(String titulo, String codigoMensaje, Object[] args) {
		super(titulo, codigoMensaje, args);
	}
	
	public ValidacionException(String codigoMensaje, Object[] args, Throwable cause) {
		super(TITULO_DEFECTO, codigoMensaje, args, cause);
	}
	
}
