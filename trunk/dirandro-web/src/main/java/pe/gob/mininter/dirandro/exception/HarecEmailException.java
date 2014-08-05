package pe.gob.mininter.dirandro.exception;

import java.io.IOException;

import javax.mail.internet.AddressException;

import org.apache.commons.mail.EmailException;

public class HarecEmailException extends ErrorException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -698940024960663252L;
	
	private static final String TITULO_DEFECTO = "Dato Indeterminado";

	public HarecEmailException(String codigoMensaje, Object[] args,
			AddressException cause) {
		super(TITULO_DEFECTO, codigoMensaje, args, cause);
	}
	
	public HarecEmailException(String codigoMensaje, Object[] args,
			EmailException cause) {
		super(TITULO_DEFECTO, codigoMensaje, args, cause);
	}
	
	public HarecEmailException(String codigoMensaje, Object[] args,
			IOException cause) {
		super(TITULO_DEFECTO, codigoMensaje, args, cause);
	}

}
