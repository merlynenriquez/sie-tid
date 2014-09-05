package pe.gob.mininter.dirandro.util;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.runtime.RuntimeSingleton;
import org.apache.velocity.runtime.parser.ParseException;
import org.apache.velocity.runtime.parser.node.SimpleNode;

public class PlantillaVelocity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -829586504392865496L;
	private VelocityEngine velocityEngine;
	
	public PlantillaVelocity() {
		init(null);
	}
	
	public PlantillaVelocity(String path) {
		init(path);
	}
	
	public void init(String path)
	{
		velocityEngine = new VelocityEngine();
		
		Properties props = new Properties();
		props.put("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.SimpleLog4JLogSystem");
		props.put("runtime.log.logsystem.log4j.category", "velocity");
		props.put("runtime.log.logsystem.log4j.logger", "velocity");
		//BEGIN CDA - OML 17.06.2014  aplicando encoding a la plantilla
		props.put("input.encoding", "UTF-8");
		props.put("output.encoding", "UTF-8");
		props.put("default.contentType", "UTF-8");
		//END CDA - OML 17.06.2014  
		
		if(StringUtils.isBlank(path))
		{
			props.put("resource.loader", "class");
			props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		}
		else
		{
			props.put("resource.loader", "file");
			props.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
			props.put("file.resource.loader.path", path.trim());
			props.put("file.resource.loader.cache", "false");
			props.put("file.resource.loader.modificationCheckInterval", "0");
			
		}
		velocityEngine.init(props);
	}
	
	@SuppressWarnings("rawtypes")
	public String enviarFormato( Map<String, Object> hashmap, String plantilla ){
		Template template = null;
		
	
		VelocityContext context = new VelocityContext();	
		
		Iterator iterator = hashmap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry mapEntry = (Map.Entry) iterator.next();
			context.put(mapEntry.getKey().toString(), mapEntry.getValue());
		}
		
		template = velocityEngine.getTemplate( plantilla, "UTF-8" );
		
		StringWriter writer = new StringWriter();
		template.merge( context, writer );
		try
		{
			return writer.toString();
		}
		finally
		{
			try {
				writer.close();
			} catch (IOException e) {
				throw new RuntimeException("Error al cerrar el recurso.", e);//FIXME mejorar esta excepcion generica
			}
		}
	}
	
	public String obtenerFormatoString( Map<String, Object> hashmap, String formato )
	{
		RuntimeServices runtimeServices = RuntimeSingleton.getRuntimeServices();            
        StringReader reader = new StringReader(formato);
        SimpleNode node = null;
		try {
			node = runtimeServices.parse(reader, "Template_Temporal");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Template template = new Template();
        template.setRuntimeServices(runtimeServices);
        template.setData(node);
        template.initDocument();
        
        VelocityContext context = new VelocityContext();	
		
		Iterator<Entry<String, Object>> iterator = hashmap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Object> mapEntry = iterator.next();
			context.put(mapEntry.getKey().toString(), mapEntry.getValue());
		}
        
        StringWriter writer = new StringWriter();
		template.merge( context, writer );
		
		try
		{
			return writer.toString();
		}
		finally
		{
			try {
				writer.close();
			} catch (IOException e) {
				throw new RuntimeException("Error al cerrar el recurso.", e);//FIXME mejorar esta excepcion generica
			}
		}
	}	
}
