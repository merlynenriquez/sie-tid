package pe.gob.mininter.dirandro.vaadin.util;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class YesNoDialog extends Window implements ClickListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1600892060106128960L;
	
	private Callback callback;
	//private Button yes = new Button("Si", this);
	//private Button no = new Button("No", this);
	
	private VerticalLayout mainLayout;

	private HorizontalLayout pnlBotonera;

	private Button no;

	private Button yes;

	private VerticalLayout pnlMensaje;

	private Label lblMensaje;

	public YesNoDialog(String caption, String question, Callback callback) {
		super(caption);

		setModal(true);

		this.callback = callback;

		/*if (question != null) {
			addComponent(new Label(question));
		}

		OrderedLayout hl = new OrderedLayout(
				OrderedLayout.ORIENTATION_HORIZONTAL);
		hl.addComponent(yes);
		hl.addComponent(no);
		addComponent(hl);
		((OrderedLayout) getLayout()).setComponentAlignment(hl,
				OrderedLayout.ALIGNMENT_RIGHT, OrderedLayout.ALIGNMENT_BOTTOM);
		*/
		buildMainLayout();
		addComponent(mainLayout);
		
		if (question != null) {
			lblMensaje.setValue(question);
		}
		yes.addListener(this);
		no.addListener(this);
		//setCompositionRoot(mainLayout);
	}

	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// pnlMensaje
		pnlMensaje = buildPnlMensaje();
		mainLayout.addComponent(pnlMensaje);
		mainLayout.setComponentAlignment(pnlMensaje, new Alignment(48));
		
		// pnlBotonera
		pnlBotonera = buildPnlBotonera();
		mainLayout.addComponent(pnlBotonera);
		mainLayout.setComponentAlignment(pnlBotonera, new Alignment(48));
		
		return mainLayout;
	}

	private VerticalLayout buildPnlMensaje() {
		// common part: create layout
		pnlMensaje = new VerticalLayout();
		pnlMensaje.setImmediate(false);
		pnlMensaje.setWidth("-1px");
		pnlMensaje.setHeight("-1px");
		pnlMensaje.setMargin(false);
		
		// lblMensaje
		lblMensaje = new Label();
		lblMensaje.setImmediate(false);
		lblMensaje.setWidth("-1px");
		lblMensaje.setHeight("-1px");
		lblMensaje.setValue("Label");
		pnlMensaje.addComponent(lblMensaje);
		pnlMensaje.setComponentAlignment(lblMensaje, new Alignment(48));
		
		return pnlMensaje;
	}

	private HorizontalLayout buildPnlBotonera() {
		// common part: create layout
		pnlBotonera = new HorizontalLayout();
		pnlBotonera.setImmediate(false);
		pnlBotonera.setWidth("-1px");
		pnlBotonera.setHeight("-1px");
		pnlBotonera.setMargin(false);
		
		// yes
		yes = new Button();
		yes.setCaption("Si");
		yes.setImmediate(true);
		yes.setWidth("-1px");
		yes.setHeight("-1px");
		pnlBotonera.addComponent(yes);
		pnlBotonera.setComponentAlignment(yes, new Alignment(48));
		
		// no
		no = new Button();
		no.setCaption("No");
		no.setImmediate(true);
		no.setWidth("-1px");
		no.setHeight("-1px");
		pnlBotonera.addComponent(no);
		pnlBotonera.setComponentAlignment(no, new Alignment(48));
		
		return pnlBotonera;
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if (getParent() != null) {
			((Window) getParent()).removeWindow(this);
		}
		callback.onDialogResult(event.getButton().equals(yes));
	}

	public interface Callback {

		public void onDialogResult(boolean resultIsYes);
	}

}
