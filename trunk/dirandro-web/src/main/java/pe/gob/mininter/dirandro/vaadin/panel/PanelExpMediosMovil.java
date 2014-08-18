package pe.gob.mininter.dirandro.vaadin.panel;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PanelExpMediosMovil extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlPrincipal;
	@AutoGenerated
	private Table table_1;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private TextField txtfechareg;
	@AutoGenerated
	private TextField txttipohecho;
	@AutoGenerated
	private TextField txtnomcaso;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private Button btnRegistrar;
	@AutoGenerated
	private ComboBox cmbMedioMovil;
	@AutoGenerated
	private TextField txtCrimen;
	@AutoGenerated
	private Label label_1;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelExpMediosMovil() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
	}

	@AutoGenerated
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
		
		// pnlPrincipal
		pnlPrincipal = buildPnlPrincipal();
		mainLayout.addComponent(pnlPrincipal);
		mainLayout.setComponentAlignment(pnlPrincipal, new Alignment(20));
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildPnlPrincipal() {
		// common part: create layout
		pnlPrincipal = new VerticalLayout();
		pnlPrincipal.setImmediate(false);
		pnlPrincipal.setWidth("-1px");
		pnlPrincipal.setHeight("-1px");
		pnlPrincipal.setMargin(true);
		pnlPrincipal.setSpacing(true);
		
		// label_1
		label_1 = new Label();
		label_1.setStyleName("h2");
		label_1.setImmediate(false);
		label_1.setWidth("260px");
		label_1.setHeight("-1px");
		label_1.setValue("Medios Moviles por Expediente");
		pnlPrincipal.addComponent(label_1);
		pnlPrincipal.setComponentAlignment(label_1, new Alignment(20));
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		pnlPrincipal.addComponent(horizontalLayout_1);
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		pnlPrincipal.addComponent(horizontalLayout_2);
		
		// table_1
		table_1 = new Table();
		table_1.setImmediate(false);
		table_1.setWidth("780px");
		table_1.setHeight("-1px");
		pnlPrincipal.addComponent(table_1);
		
		return pnlPrincipal;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("-1px");
		horizontalLayout_1.setHeight("-1px");
		horizontalLayout_1.setMargin(false);
		
		// txtCrimen
		txtCrimen = new TextField();
		txtCrimen.setCaption("Crimen");
		txtCrimen.setImmediate(false);
		txtCrimen.setWidth("-1px");
		txtCrimen.setHeight("-1px");
		txtCrimen.setRequired(true);
		horizontalLayout_1.addComponent(txtCrimen);
		
		// cmbMedioMovil
		cmbMedioMovil = new ComboBox();
		cmbMedioMovil.setCaption("Medio-Movil");
		cmbMedioMovil.setImmediate(false);
		cmbMedioMovil.setWidth("-1px");
		cmbMedioMovil.setHeight("-1px");
		cmbMedioMovil.setRequired(true);
		horizontalLayout_1.addComponent(cmbMedioMovil);
		
		// btnRegistrar
		btnRegistrar = new Button();
		btnRegistrar.setCaption("Registrar");
		btnRegistrar.setImmediate(true);
		btnRegistrar.setWidth("-1px");
		btnRegistrar.setHeight("-1px");
		horizontalLayout_1.addComponent(btnRegistrar);
		horizontalLayout_1
				.setComponentAlignment(btnRegistrar, new Alignment(9));
		
		return horizontalLayout_1;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_2() {
		// common part: create layout
		horizontalLayout_2 = new HorizontalLayout();
		horizontalLayout_2.setImmediate(false);
		horizontalLayout_2.setWidth("-1px");
		horizontalLayout_2.setHeight("-1px");
		horizontalLayout_2.setMargin(false);
		
		// txtnomcaso
		txtnomcaso = new TextField();
		txtnomcaso.setCaption("Nombre del caso");
		txtnomcaso.setImmediate(false);
		txtnomcaso.setWidth("-1px");
		txtnomcaso.setHeight("-1px");
		horizontalLayout_2.addComponent(txtnomcaso);
		
		// txttipohecho
		txttipohecho = new TextField();
		txttipohecho.setCaption("Tipo de hecho");
		txttipohecho.setImmediate(false);
		txttipohecho.setWidth("-1px");
		txttipohecho.setHeight("-1px");
		horizontalLayout_2.addComponent(txttipohecho);
		
		// txtfechareg
		txtfechareg = new TextField();
		txtfechareg.setCaption("Fecha de registro");
		txtfechareg.setImmediate(false);
		txtfechareg.setWidth("-1px");
		txtfechareg.setHeight("-1px");
		horizontalLayout_2.addComponent(txtfechareg);
		
		return horizontalLayout_2;
	}

}