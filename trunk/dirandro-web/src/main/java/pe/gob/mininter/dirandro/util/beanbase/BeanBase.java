package pe.gob.mininter.dirandro.util.beanbase;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public abstract class BeanBase implements Serializable {

	private static final long serialVersionUID = -106090697239179889L;

	@Override
	public String toString() {
		return "";//ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
