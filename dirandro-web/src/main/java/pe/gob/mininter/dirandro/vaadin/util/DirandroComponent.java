package pe.gob.mininter.dirandro.vaadin.util;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.Opcion;

import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.ui.AbstractTextField;
import com.vaadin.ui.CustomComponent;

public abstract class DirandroComponent extends CustomComponent {

	private static final long serialVersionUID = 1355120342779674844L;

	private List<Opcion> acciones;
	private String height;
	public boolean modificaAltura = false;

	public DirandroComponent(List<Opcion> acciones, String height) {
		this.acciones = acciones;
		this.height = height;
	}

	public abstract void postConstruct();

	protected Opcion obtenerAccion(String codigo) {
		if (acciones == null) {
			// TODO lanza excepcion
		}
		Opcion opcion = new Opcion();
		opcion.setCodigo(codigo);
		int index = acciones.indexOf(opcion);
		if (index != -1) {
			Opcion accion = acciones.get(index);
			return accion;
		} else {
			return null;
		}
	}

	@Override
	public void attach() {
		super.attach();
		setHeight(height);
	}

	public static String getString(AbstractTextField txtInput) {
		String valor = (String) txtInput.getValue();
		if (valor != null) {
			return valor.trim();
		}
		return null;
	}

	public static String getString(TextChangeEvent txtInput) {
		String valor = txtInput.getText();
		if (valor != null) {
			return valor;
		}
		return null;
	}

	public static Integer getInteger(AbstractTextField txtInput) {
		String valor = (String) txtInput.getValue();
		if (valor != null && !StringUtils.isEmpty(valor)) {
			if (StringUtils.isNumeric(valor))
				return Integer.parseInt(valor);
		}
		return null;
	}

	public static Integer getInteger(TextChangeEvent txtInput) {
		String valor = txtInput.getText();
		if (valor != null && !StringUtils.isEmpty(valor)) {
			if (StringUtils.isNumeric(valor))
				return Integer.parseInt(valor);
		}
		return null;
	}

	public static Long getLong(AbstractTextField txtInput) {
		String valor = (String) txtInput.getValue();
		if (valor != null && !StringUtils.isEmpty(valor)) {
			if (StringUtils.isNumeric(valor))
				return Long.parseLong(valor);
		}
		return null;
	}

	public static Long getLong(TextChangeEvent txtInput) {
		String valor = txtInput.getText();
		if (valor != null && !StringUtils.isEmpty(valor)) {
			if (StringUtils.isNumeric(valor))
				return Long.parseLong(valor);
		}
		return null;
	}

}
