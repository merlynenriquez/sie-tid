package pe.gob.mininter.dirandro.vaadin.util.event;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.Component;
import com.vaadin.ui.Component.Event;
import com.vaadin.ui.TextField;

public class DateFieldChangedEvent extends Event implements ValueChangeEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4209201511773961687L;

	public DateFieldChangedEvent(Component source) {
		super(source);
	}

	@Override
	public Property getProperty() {
		if(getComponent() instanceof AbstractField)
		{
			return ((AbstractField)getComponent()).getPropertyDataSource();
		}
		return null;
	}

}
