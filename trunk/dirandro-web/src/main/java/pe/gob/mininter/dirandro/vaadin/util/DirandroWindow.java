package pe.gob.mininter.dirandro.vaadin.util;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.vaadin.ui.Window;

public class DirandroWindow extends Window implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6605983558113106678L;
	
	private String codigo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public int hashCode() {
		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder(3, 7);
		hashCodeBuilder.append(codigo);
		return hashCodeBuilder.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean equals = false;
		if (obj instanceof DirandroWindow) {
			DirandroWindow bean = (DirandroWindow) obj;
			equals = (new EqualsBuilder().append(codigo, bean.codigo))
					.isEquals();
		}
		return equals;
	}

}
