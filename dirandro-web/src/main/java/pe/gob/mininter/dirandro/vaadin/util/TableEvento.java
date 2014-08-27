package pe.gob.mininter.dirandro.vaadin.util;

import java.lang.reflect.Method;
import java.util.Map;

import pe.gob.mininter.dirandro.vaadin.util.event.ColumnOrderChangedEvent;
import pe.gob.mininter.dirandro.vaadin.util.event.ColumnShownChangedEvent;
import pe.gob.mininter.dirandro.vaadin.util.event.ColumnSortChangedEvent;
import pe.gob.mininter.dirandro.vaadin.util.listener.ColumnOrderChangedListener;
import pe.gob.mininter.dirandro.vaadin.util.listener.ColumnShownChangedListener;
import pe.gob.mininter.dirandro.vaadin.util.listener.ColumnSortChangedListener;

import com.vaadin.data.Container;
import com.vaadin.ui.Table;

public class TableEvento extends Table {

	protected static Method LISTENER_METHOD_COLUMN_ORDER_CHANGED;

	protected static Method LISTENER_METHOD_COLUMN_SHOWN_CHANGED;

	protected static Method LISTENER_METHOD_COLUMN_SORT_CHANGED;

	private static final long serialVersionUID = 1L;
	static {
		try {
			LISTENER_METHOD_COLUMN_SHOWN_CHANGED = ColumnShownChangedListener.class
					.getDeclaredMethod("columnShownChanged",
							new Class[] { ColumnShownChangedEvent.class });
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
		try {
			LISTENER_METHOD_COLUMN_ORDER_CHANGED = ColumnOrderChangedListener.class
					.getDeclaredMethod("columnOrderChanged",
							new Class[] { ColumnOrderChangedEvent.class });
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
		try {
			LISTENER_METHOD_COLUMN_SORT_CHANGED = ColumnSortChangedListener.class
					.getDeclaredMethod("columnSortChanged",
							new Class[] { ColumnSortChangedEvent.class });
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}

	public TableEvento() {
		super();
	}

	public TableEvento(String caption) {
		super(caption);
	}

	public TableEvento(String caption, Container dataSource) {
		super(caption, dataSource);
	}

	public void addListener(ColumnOrderChangedListener listener) {
		addListener(ColumnOrderChangedEvent.class, listener,
				LISTENER_METHOD_COLUMN_ORDER_CHANGED);
	}

	public void addListener(ColumnShownChangedListener listener) {
		addListener(ColumnShownChangedEvent.class, listener,
				LISTENER_METHOD_COLUMN_SHOWN_CHANGED);
	}

	public void addListener(ColumnSortChangedListener listener) {
		addListener(ColumnSortChangedEvent.class, listener,
				LISTENER_METHOD_COLUMN_SORT_CHANGED);
	}
	
	public void removeListener(ColumnOrderChangedListener listener) {
		removeListener(ColumnOrderChangedEvent.class, listener,
				LISTENER_METHOD_COLUMN_ORDER_CHANGED);
	}
	
	public void removeListener(ColumnShownChangedListener listener) {
		removeListener(ColumnShownChangedEvent.class, listener,
				LISTENER_METHOD_COLUMN_SHOWN_CHANGED);
	}

	public void removeListener(ColumnSortChangedListener listener) {
		removeListener(ColumnSortChangedEvent.class, listener,
				LISTENER_METHOD_COLUMN_SORT_CHANGED);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vaadin.ui.Table#changeVariables(java.lang.Object, java.util.Map)
	 */
	@Override
	public void changeVariables(Object source, Map<String, Object> variables) {
		super.changeVariables(source, variables);

		if (variables.containsKey("collapsedcolumns")) {
			fireColumnShowChanged();
		}

		if (variables.containsKey("columnorder")) {
			fireColumnOrderChanged();
		}

		if (variables.containsKey("sortcolumn")
				|| variables.containsKey("sortascending")) {
			fireColumnSortChanged();
		}

	}

	protected void fireColumnOrderChanged() {
		fireEvent(new ColumnOrderChangedEvent(this));
	}

	protected void fireColumnShowChanged() {
		fireEvent(new ColumnShownChangedEvent(this));
	}

	protected void fireColumnSortChanged() {
		fireEvent(new ColumnSortChangedEvent(this));
	}

	/*public static final class ColumnOrderChangedEvent extends Event {

		private static final long serialVersionUID = 1L;

		public ColumnOrderChangedEvent(TableEvento source) {
			super(source);
		}
	}

	public interface ColumnOrderChangedListener extends Serializable {

		void columnOrderChanged(ColumnOrderChangedEvent event);
	}

	public static final class ColumnShownChangedEvent extends Event {

		private static final long serialVersionUID = 1L;

		public ColumnShownChangedEvent(TableEvento source) {
			super(source);
		}
	}

	public interface ColumnShownChangedListener extends Serializable {

		void columnShownChanged(ColumnShownChangedEvent event);
	}

	public static final class ColumnSortChangedEvent extends Event {

		private static final long serialVersionUID = 1L;

		public ColumnSortChangedEvent(TableEvento source) {
			super(source);
		}
	}

	public interface ColumnSortChangedListener extends Serializable {

		void columnSortChanged(ColumnSortChangedEvent event);
	}*/

}
