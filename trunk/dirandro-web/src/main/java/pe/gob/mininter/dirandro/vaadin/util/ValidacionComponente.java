package pe.gob.mininter.dirandro.vaadin.util;

import com.vaadin.ui.AbstractTextField;

public abstract class ValidacionComponente {
	
	private ValidacionComponente() {
		
	}

	public static void validarTamanho(AbstractTextField textField,String texto, int tamanho){
		if(texto.length()<=tamanho){
			textField.setValue(texto);
		}else{
			textField.setValue(textField.getValue());
		}
	}
	
}
