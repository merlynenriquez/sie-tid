package pe.gob.mininter.dirandro.exception;

public abstract class BaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1606430053395108926L;
	
	private String titulo;
	private String codigoMensaje;
	private Object[] args;
	
	private static final String TITULO_DEFECTO = "Error no especificado";
	
	public BaseException(String codigoMensaje, Object[] args) {
		this.titulo = TITULO_DEFECTO;
		this.codigoMensaje = codigoMensaje;
		this.args = args;
	}
	
	public BaseException(String titulo, String codigoMensaje, Object[] args) {
		this.titulo = titulo;
		this.codigoMensaje = codigoMensaje;
		this.args = args;
	}

	public BaseException(String codigoMensaje, Object[] args, Throwable cause) {
		super(cause);
		this.titulo = TITULO_DEFECTO;
		this.codigoMensaje = codigoMensaje;
		this.args = args;
	}
	
	public BaseException(String titulo, String codigoMensaje, Object[] args, Throwable cause) {
		super(cause);
		this.titulo = titulo;
		this.codigoMensaje = codigoMensaje;
		this.args = args;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getCodigoMensaje() {
		return codigoMensaje;
	}

	public Object[] getArgs() {
		return args;
	}

	protected void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	protected void setCodigoMensaje(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}

	protected void setArgs(Object[] args) {
		this.args = args;
	}

}
