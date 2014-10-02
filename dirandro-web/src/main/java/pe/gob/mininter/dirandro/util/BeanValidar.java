package pe.gob.mininter.dirandro.util;

import com.vaadin.ui.AbstractField;

public class BeanValidar {

	private String propiedad;
    private Object[] args;
    private AbstractField objecto;
    
    public BeanValidar(String propiedad, Object[] args, AbstractField objecto) {
            super();
            this.propiedad = propiedad;
            this.args = args;
            this.objecto = objecto;
    }
    
    public BeanValidar(String propiedad, Object[] args) {
            super();
            this.propiedad = propiedad;
            this.args = args;
    }
    
    public String getPropiedad() {
            return propiedad;
    }
    public void setPropiedad(String propiedad) {
            this.propiedad = propiedad;
    }
    public Object[] getArgs() {
            return args;
    }
    public void setArgs(Object[] args) {
            this.args = args;
    }
    public AbstractField getObjecto() {
            return objecto;
    }
    public void setObjecto(AbstractField objecto) {
            this.objecto = objecto;
    }
	
}
