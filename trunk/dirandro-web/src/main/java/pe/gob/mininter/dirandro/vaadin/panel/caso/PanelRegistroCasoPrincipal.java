package pe.gob.mininter.dirandro.vaadin.panel.caso;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PanelRegistroCasoPrincipal extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout lytButton;
	@AutoGenerated
	private Button btnLimpiar;
	@AutoGenerated
	private Button btnGrabar;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_5;
	@AutoGenerated
	private PopupDateField dtSituacion;
	@AutoGenerated
	private Label label_5;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_3;
	@AutoGenerated
	private ComboBox cmbSituacion;
	@AutoGenerated
	private Label label_3;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private TextArea txtDescrpcion;
	@AutoGenerated
	private Label label_2;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private TextField txtNombre;
	@AutoGenerated
	private Label label_1;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_4;
	@AutoGenerated
	private Label lblNumero;
	@AutoGenerated
	private Label label_4;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelRegistroCasoPrincipal() {
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
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("-1px");
		
		// horizontalLayout_4
		horizontalLayout_4 = buildHorizontalLayout_4();
		mainLayout.addComponent(horizontalLayout_4);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		mainLayout.addComponent(horizontalLayout_1);
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		mainLayout.addComponent(horizontalLayout_2);
		
		// horizontalLayout_3
		horizontalLayout_3 = buildHorizontalLayout_3();
		mainLayout.addComponent(horizontalLayout_3);
		
		// horizontalLayout_5
		horizontalLayout_5 = buildHorizontalLayout_5();
		mainLayout.addComponent(horizontalLayout_5);
		
		// lytButton
		lytButton = buildLytButton();
		mainLayout.addComponent(lytButton);
		
		return mainLayout;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_4() {
		// common part: create layout
		horizontalLayout_4 = new HorizontalLayout();
		horizontalLayout_4.setImmediate(false);
		horizontalLayout_4.setWidth("-1px");
		horizontalLayout_4.setHeight("-1px");
		horizontalLayout_4.setMargin(false);
		horizontalLayout_4.setSpacing(true);
		
		// label_4
		label_4 = new Label();
		label_4.setImmediate(false);
		label_4.setWidth("150px");
		label_4.setHeight("-1px");
		label_4.setValue("Número de Caso");
		horizontalLayout_4.addComponent(label_4);
		
		// lblNumero
		lblNumero = new Label();
		lblNumero.setImmediate(false);
		lblNumero.setWidth("300px");
		lblNumero.setHeight("-1px");
		horizontalLayout_4.addComponent(lblNumero);
		
		return horizontalLayout_4;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("-1px");
		horizontalLayout_1.setHeight("-1px");
		horizontalLayout_1.setMargin(false);
		horizontalLayout_1.setSpacing(true);
		
		// label_1
		label_1 = new Label();
		label_1.setImmediate(false);
		label_1.setWidth("150px");
		label_1.setHeight("-1px");
		label_1.setValue("Nombre del caso:");
		horizontalLayout_1.addComponent(label_1);
		
		// txtNombre
		txtNombre = new TextField();
		txtNombre.setImmediate(false);
		txtNombre.setWidth("300px");
		txtNombre.setHeight("-1px");
		txtNombre.setInputPrompt("Nombre del Caso");
		horizontalLayout_1.addComponent(txtNombre);
		
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
		horizontalLayout_2.setSpacing(true);
		
		// label_2
		label_2 = new Label();
		label_2.setImmediate(false);
		label_2.setWidth("150px");
		label_2.setHeight("-1px");
		label_2.setValue("Descripción del Caso");
		horizontalLayout_2.addComponent(label_2);
		
		// txtDescrpcion
		txtDescrpcion = new TextArea();
		txtDescrpcion.setImmediate(false);
		txtDescrpcion.setWidth("300px");
		txtDescrpcion.setHeight("-1px");
		txtDescrpcion.setInputPrompt("Descripción del caso ");
		horizontalLayout_2.addComponent(txtDescrpcion);
		
		return horizontalLayout_2;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_3() {
		// common part: create layout
		horizontalLayout_3 = new HorizontalLayout();
		horizontalLayout_3.setImmediate(false);
		horizontalLayout_3.setWidth("-1px");
		horizontalLayout_3.setHeight("-1px");
		horizontalLayout_3.setMargin(false);
		horizontalLayout_3.setSpacing(true);
		
		// label_3
		label_3 = new Label();
		label_3.setImmediate(false);
		label_3.setWidth("150px");
		label_3.setHeight("-1px");
		label_3.setValue("Situación del Caso");
		horizontalLayout_3.addComponent(label_3);
		
		// cmbSituacion
		cmbSituacion = new ComboBox();
		cmbSituacion.setImmediate(false);
		cmbSituacion.setWidth("200px");
		cmbSituacion.setHeight("-1px");
		horizontalLayout_3.addComponent(cmbSituacion);
		
		return horizontalLayout_3;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_5() {
		// common part: create layout
		horizontalLayout_5 = new HorizontalLayout();
		horizontalLayout_5.setImmediate(false);
		horizontalLayout_5.setWidth("-1px");
		horizontalLayout_5.setHeight("-1px");
		horizontalLayout_5.setMargin(false);
		horizontalLayout_5.setSpacing(true);
		
		// label_5
		label_5 = new Label();
		label_5.setImmediate(false);
		label_5.setWidth("150px");
		label_5.setHeight("-1px");
		label_5.setValue("Fecha de Situación");
		horizontalLayout_5.addComponent(label_5);
		
		// dtSituacion
		dtSituacion = new PopupDateField();
		dtSituacion.setImmediate(false);
		dtSituacion.setWidth("200px");
		dtSituacion.setHeight("-1px");
		dtSituacion.setResolution(4);
		horizontalLayout_5.addComponent(dtSituacion);
		
		return horizontalLayout_5;
	}

	@AutoGenerated
	private HorizontalLayout buildLytButton() {
		// common part: create layout
		lytButton = new HorizontalLayout();
		lytButton.setImmediate(false);
		lytButton.setWidth("100.0%");
		lytButton.setHeight("-1px");
		lytButton.setMargin(false);
		
		// btnGrabar
		btnGrabar = new Button();
		btnGrabar.setCaption("Grabar");
		btnGrabar.setImmediate(true);
		btnGrabar.setWidth("-1px");
		btnGrabar.setHeight("-1px");
		lytButton.addComponent(btnGrabar);
		lytButton.setComponentAlignment(btnGrabar, new Alignment(6));
		
		// btnLimpiar
		btnLimpiar = new Button();
		btnLimpiar.setCaption("Limpiar");
		btnLimpiar.setImmediate(true);
		btnLimpiar.setWidth("-1px");
		btnLimpiar.setHeight("-1px");
		lytButton.addComponent(btnLimpiar);
		
		return lytButton;
	}

}