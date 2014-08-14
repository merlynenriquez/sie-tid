package pe.gob.mininter.dirandro.vaadin.panel;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PanelAgregarDireccion extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private Button button_3;
	@AutoGenerated
	private Button button_2;
	@AutoGenerated
	private VerticalLayout verticalLayout_2;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private Button button_1;
	@AutoGenerated
	private TextField textField_3;
	@AutoGenerated
	private TextField textField_1;
	@AutoGenerated
	private Label label_1;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelAgregarDireccion() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("600px");
		mainLayout.setHeight("110px");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("600px");
		setHeight("110px");
		
		// label_1
		label_1 = new Label();
		label_1.setImmediate(false);
		label_1.setWidth("120px");
		label_1.setHeight("-1px");
		label_1.setValue("Nueva Dirección");
		mainLayout.addComponent(label_1);
		mainLayout.setComponentAlignment(label_1, new Alignment(20));
		
		// verticalLayout_2
		verticalLayout_2 = buildVerticalLayout_2();
		mainLayout.addComponent(verticalLayout_2);
		mainLayout.setComponentAlignment(verticalLayout_2, new Alignment(20));
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		mainLayout.addComponent(horizontalLayout_2);
		mainLayout.setComponentAlignment(horizontalLayout_2, new Alignment(20));
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_2() {
		// common part: create layout
		verticalLayout_2 = new VerticalLayout();
		verticalLayout_2.setImmediate(false);
		verticalLayout_2.setWidth("584px");
		verticalLayout_2.setHeight("-1px");
		verticalLayout_2.setMargin(false);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		verticalLayout_2.addComponent(horizontalLayout_1);
		
		return verticalLayout_2;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("582px");
		horizontalLayout_1.setHeight("49px");
		horizontalLayout_1.setMargin(false);
		
		// textField_1
		textField_1 = new TextField();
		textField_1.setCaption("Dirección");
		textField_1.setImmediate(false);
		textField_1.setWidth("-1px");
		textField_1.setHeight("-1px");
		horizontalLayout_1.addComponent(textField_1);
		
		// textField_3
		textField_3 = new TextField();
		textField_3.setCaption("Distrito/Provincia/Departamento");
		textField_3.setImmediate(false);
		textField_3.setWidth("350px");
		textField_3.setHeight("-1px");
		horizontalLayout_1.addComponent(textField_3);
		
		// button_1
		button_1 = new Button();
		button_1.setCaption("Buscar");
		button_1.setImmediate(false);
		button_1.setWidth("-1px");
		button_1.setHeight("-1px");
		horizontalLayout_1.addComponent(button_1);
		horizontalLayout_1.setComponentAlignment(button_1, new Alignment(48));
		
		return horizontalLayout_1;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_2() {
		// common part: create layout
		horizontalLayout_2 = new HorizontalLayout();
		horizontalLayout_2.setImmediate(false);
		horizontalLayout_2.setWidth("161px");
		horizontalLayout_2.setHeight("-1px");
		horizontalLayout_2.setMargin(false);
		
		// button_2
		button_2 = new Button();
		button_2.setCaption("Grabar");
		button_2.setImmediate(false);
		button_2.setWidth("-1px");
		button_2.setHeight("-1px");
		horizontalLayout_2.addComponent(button_2);
		
		// button_3
		button_3 = new Button();
		button_3.setCaption("Cancelar");
		button_3.setImmediate(false);
		button_3.setWidth("-1px");
		button_3.setHeight("-1px");
		horizontalLayout_2.addComponent(button_3);
		
		return horizontalLayout_2;
	}

}
