package pe.gob.mininter.dirandro.vaadin.util;

import pe.gob.mininter.dirandro.exception.BaseException;

import com.vaadin.terminal.Terminal.ErrorEvent;

public class HarecErrorEvent implements ErrorEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2743223776974432051L;
	private Throwable throwable;
	
	public HarecErrorEvent(BaseException baseException) {
		this.throwable = new Exception(baseException);
	}

	@Override
	public Throwable getThrowable() {
		return throwable;
	}

}
