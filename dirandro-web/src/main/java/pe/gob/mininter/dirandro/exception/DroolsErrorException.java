package pe.gob.mininter.dirandro.exception;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;

import pe.gob.mininter.dirandro.util.Constante;

public class DroolsErrorException extends ErrorException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1700223009967406158L;
	
	private static final Log logger = LogFactory.getLog(DroolsErrorException.class);

	public DroolsErrorException(KnowledgeBuilderErrors errors ) {
		
		super("Error Compilación Reglas", Constante.CODIGO_MENSAJE.ERROR_VALIDACION, null);

		String newline = System.getProperty("line.separator");
		
		StringBuilder str = new StringBuilder();
		
		for (KnowledgeBuilderError knowledgeBuilderError : errors) {
			String error = generarMensaje(knowledgeBuilderError);
			System.err.println(error);
			logger.error(error);
			str.append(error).append(newline);
		}
		
		setArgs(new Object[]{str.toString()});
		
	}

	private String generarMensaje(KnowledgeBuilderError knowledgeBuilderError) {
		
		String newline = System.getProperty("line.separator");
		
		StringBuilder str = new StringBuilder();
		str.append("Mensaje:").append(knowledgeBuilderError.getMessage()).append(newline);
		str.append("Lineas:").append(ToStringBuilder.reflectionToString(knowledgeBuilderError.getLines(),
				ToStringStyle.MULTI_LINE_STYLE));
		
		return str.toString();
	}
	
}
