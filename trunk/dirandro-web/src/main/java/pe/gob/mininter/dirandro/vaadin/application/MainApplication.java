package pe.gob.mininter.dirandro.vaadin.application;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;

import pe.gob.mininter.dirandro.exception.AlertaException;
import pe.gob.mininter.dirandro.exception.ErrorException;
import pe.gob.mininter.dirandro.exception.MensajeException;
import pe.gob.mininter.dirandro.exception.NotificacionException;
import pe.gob.mininter.dirandro.model.Usuario;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;
import pe.gob.mininter.dirandro.vaadin.panel.PanelLogin;
import pe.gob.mininter.dirandro.vaadin.panel.PanelPrincipal;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.Application;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;

//@Configurable
public class MainApplication extends Application {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Log logger = LogFactory.getLog(MainApplication.class);
	
	private Window windowHarec;
	
	private MessageSource messageSource;
	
	private boolean flagConsulta;

	@Override
	public void init() {	
		
		messageSource = Injector.obtenerServicio(MessageSource.class);
		logger.debug(" messages " + messageSource) ;
		//TODO setTheme("harec");
		
		windowHarec = new Window();	
		
		Usuario usuario = HarecUtil.obtenerUsuarioSesion();
		if(usuario== null){
			PanelLogin panelLogin= new PanelLogin( windowHarec );
			windowHarec.removeAllComponents();
			windowHarec.setCaption("Login Dirandro");
			windowHarec.addComponent(panelLogin);
		}else{
			cargarPanelPrincipal();
		}
		
		setMainWindow(windowHarec);
		
	}
	
	public void cargarPanelPrincipal(){
		windowHarec.removeAllComponents();

		PanelPrincipal panelPrincipal = new PanelPrincipal();
		panelPrincipal.setFlagConsulta(flagConsulta);
		panelPrincipal.prepararPanelPrincipal();
		
		panelPrincipal.setWidth("100%");
		panelPrincipal.setHeight("100%");
		
		windowHarec.setCaption("Dirandro");
		windowHarec.getContent().setHeight("100%");
		windowHarec.getLayout().setMargin(false);
		windowHarec.addComponent(panelPrincipal);

	}
	
	@Override
	public void terminalError(com.vaadin.terminal.Terminal.ErrorEvent event) {
		String defaultMessage = "Mensaje no especificado";
		if(event.getThrowable().getCause() instanceof NotificacionException)
		{
			resolverNotificacionException((NotificacionException)event.getThrowable().getCause(), defaultMessage);
		}
		if(event.getThrowable().getCause() instanceof MensajeException)
		{
			resolverMensajeException((MensajeException) event.getThrowable().getCause(), defaultMessage);
		}
		else if(event.getThrowable().getCause() instanceof AlertaException)
		{
			resolverAlertaException((AlertaException) event.getThrowable().getCause(), defaultMessage);
		}
		else if(event.getThrowable().getCause() instanceof ErrorException)
		{
			resolverErrorException((ErrorException) event.getThrowable().getCause(), defaultMessage);
		}
		else
		{
			resolverException(event.getThrowable().getCause(), defaultMessage);
			super.terminalError(event);
		}
		resolverException(event.getThrowable().getCause(), defaultMessage);
		super.terminalError(event);
	}
	
	private void resolverNotificacionException(NotificacionException notificacionException,
			String defaultMessage) {
		
		String mensaje = messageSource.getMessage(
        		notificacionException.getCodigoMensaje(), 
        		notificacionException.getArgs(), 
        		defaultMessage, this.getLocale());
		
		windowHarec.showNotification(
				notificacionException.getTitulo(),
				mensaje,
                Notification.TYPE_TRAY_NOTIFICATION);
		logger.info("HAREC Notificación [" + notificacionException.getTitulo() + "=" + mensaje + "]");
	}
	
	private void resolverAlertaException(AlertaException alertaException,
			String defaultMessage) {
		
		String mensaje = messageSource.getMessage(
				alertaException.getCodigoMensaje(), 
				alertaException.getArgs(), 
        		defaultMessage, this.getLocale());
		
		windowHarec.showNotification(
				alertaException.getTitulo(),
				mensaje,
                Notification.TYPE_WARNING_MESSAGE);
		logger.info("HAREC Alerta [" + alertaException.getTitulo() + "=" + mensaje + "]");
	}
	
	private void resolverMensajeException(MensajeException mensajeException,
			String defaultMessage) {
		
		String mensaje = messageSource.getMessage(
				mensajeException.getCodigoMensaje(), 
				mensajeException.getArgs(), 
        		defaultMessage, this.getLocale());
		
		windowHarec.showNotification(
				mensajeException.getTitulo(),
				mensaje,
                Notification.TYPE_HUMANIZED_MESSAGE);
		logger.info("HAREC Mensaje [" + mensajeException.getTitulo() + "=" + mensaje + "]");
	}
	
	private void resolverErrorException(ErrorException errorException,
			String defaultMessage) {
		
		String mensaje = messageSource.getMessage(
				errorException.getCodigoMensaje(), 
				errorException.getArgs(), 
        		defaultMessage, this.getLocale());
		
		windowHarec.showNotification(
				errorException.getTitulo(),
				mensaje,
                Notification.TYPE_ERROR_MESSAGE);		
		
		logger.error("HAREC Error [" + errorException.getTitulo() + "=" + mensaje + "]", errorException);
	}
	
	private void resolverException(Throwable cause, String defaultMessage) {
		windowHarec.showNotification(
                "ERROR inesperado",
                messageSource.getMessage(
                		Constante.CODIGO_MENSAJE.ERROR_GENERICO , 
                		null, 
                		defaultMessage, this.getLocale()),
                Notification.TYPE_ERROR_MESSAGE);
		logger.error("HAREC: Error inesperado", cause);
	}
	
	public static SystemMessages getSystemMessages() {
		CustomizedSystemMessages customizedSystemMessages = new CustomizedSystemMessages();
		
		customizedSystemMessages.setSessionExpiredCaption("Sesión expirada");
		customizedSystemMessages.setSessionExpiredMessage("Anote la información no guardada y haga <u>click aquí</u> para continuar.");
		customizedSystemMessages.setSessionExpiredNotificationEnabled(true);
		customizedSystemMessages.setSessionExpiredURL(null);
		
		return customizedSystemMessages;
	}

}
