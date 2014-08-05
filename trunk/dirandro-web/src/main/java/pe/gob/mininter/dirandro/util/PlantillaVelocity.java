package pe.gob.mininter.dirandro.util;

import java.io.Serializable;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class PlantillaVelocity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6008139078185735601L;
	
	private VelocityEngine velocityEngine;
	
	public PlantillaVelocity() {
		
		velocityEngine = new VelocityEngine();
		velocityEngine.setProperty("resource.loader", "class");
		velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		velocityEngine.init();
	}
	
	public String enviarFormato( Map<String, Object> hashmap, String plantilla ){
		Template template = null;
		
	
		VelocityContext context = new VelocityContext();	
		
		@SuppressWarnings("rawtypes")
		Iterator iterator = hashmap.entrySet().iterator();
		while (iterator.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry mapEntry = (Map.Entry) iterator.next();
			context.put(mapEntry.getKey().toString(), mapEntry.getValue());
		}
		
		template = velocityEngine.getTemplate( plantilla );
			
		StringWriter writer = new StringWriter();
		template.merge( context, writer );
		return writer.toString();
	}
	
	
	
	
	
	
	
	
	
    
    
    
    
    
    
    
    

    
	
}
