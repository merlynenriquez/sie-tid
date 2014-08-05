package pe.gob.mininter.dirandro.vaadin.util;

import java.util.List;

import pe.gob.mininter.dirandro.model.Opcion;

import com.vaadin.terminal.Resource;
import com.vaadin.ui.MenuBar;

public class HarecMenuBar extends MenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1427715714828794433L;
	
	public HarecMenuItem addItem(String codigo, List<Opcion> opciones, String caption, Command command) {
		HarecMenuItem newItem = new HarecMenuItem(caption, null, command, codigo, opciones);
		getItems().add((MenuItem)newItem);
        requestRepaint();
		return newItem;
	}
	
	public class HarecMenuItem extends MenuItem {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 5969520527426095863L;
		
		private String codigo;
		private List<Opcion> acciones;

		public HarecMenuItem(String caption, Resource icon,
				Command command, String codigo, List<Opcion> acciones) {
			super(caption, icon, command);
			this.codigo = codigo;
			this.acciones = acciones;
		}

		public String getCodigo() {
			return codigo;
		}

		public List<Opcion> getAcciones() {
			return acciones;
		}

		public HarecMenuItem addItem(String codigo, List<Opcion> acciones,
				String caption, Command command) {
			MenuItem menuItem = super.addItem(caption, command);
			int index = getChildren().indexOf(menuItem);
			
			HarecMenuItem newItem = new HarecMenuItem(caption, null, command, codigo, acciones);
			newItem.setParent(this);
			getChildren().set(index, newItem);
			requestRepaint();
			return newItem;
		}

	}

}
