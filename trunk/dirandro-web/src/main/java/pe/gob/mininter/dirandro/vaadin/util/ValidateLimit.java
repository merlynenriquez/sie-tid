package pe.gob.mininter.dirandro.vaadin.util;

import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.AbstractTextField;
import com.vaadin.ui.AbstractTextField.TextChangeEventMode;

public class ValidateLimit implements TextChangeListener{


	private static final long serialVersionUID = 1L;
	AbstractTextField txtInput;
	int size;
	
	public ValidateLimit(AbstractTextField txtInput,int size) {
		this.txtInput=txtInput;
		this.size=size;
		txtInput.setTextChangeEventMode(TextChangeEventMode.EAGER);
		txtInput.setMaxLength(size);
	}
	@Override
	public void textChange(TextChangeEvent event) {
		 ValidacionComponente.validarTamanho(txtInput, event.getText(), size);
	}

}
