package pe.gob.mininter.dirandro.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HarecAdjuntarException extends ErrorException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -698940024960663252L;
	
	private static final String TITULO_DEFECTO = "Dato Indeterminado";

	public HarecAdjuntarException(String codigoMensaje,
			FileNotFoundException cause) {
		super(TITULO_DEFECTO, codigoMensaje, null, cause);
	}
	
	public HarecAdjuntarException(String codigoMensaje, Object[] args,
			IOException cause) {
		super(TITULO_DEFECTO, codigoMensaje, args, cause);
	}

}
