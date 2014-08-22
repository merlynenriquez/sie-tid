package pe.gob.mininter.dirandro.vaadin.util;

import pe.gob.mininter.dirandro.exception.BaseException;

import com.vaadin.terminal.Terminal.ErrorEvent;

public class DirandroErrorEvent implements ErrorEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2743223776974432051L;
	private Throwable throwable;
	
	public DirandroErrorEvent(BaseException baseException) {
		this.throwable = new Exception(baseException);
	}

	@Override
	public Throwable getThrowable() {
		return throwable;
	}

}
