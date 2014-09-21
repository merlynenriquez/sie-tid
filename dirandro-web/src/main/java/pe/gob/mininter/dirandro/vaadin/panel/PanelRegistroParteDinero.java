package pe.gob.mininter.dirandro.vaadin.panel;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PanelRegistroParteDinero extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	
	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private Table table_4;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_25;
	@AutoGenerated
	private Button button_3;
	@AutoGenerated
	private OptionGroup optionGroup_1;
	@AutoGenerated
	private TextField textField_18;
	@AutoGenerated
	private ComboBox comboBox_12;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_24;
	@AutoGenerated
	private TextField textField_19;
	@AutoGenerated
	private ComboBox comboBox_11;
	@AutoGenerated
	private ComboBox comboBox_10;
	@AutoGenerated
	private TextField textField_17;
	@AutoGenerated
	private ComboBox comboBox_9;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */

	private static final long serialVersionUID = -4639683924066371051L;
	
	public PanelRegistroParteDinero() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		postConstruct();
	}
	
	public void postConstruct() {
		
	}
	
	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("-1px");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true);
		
		// top-level component properties
		setWidth("-1px");
		setHeight("-1px");
		
		// horizontalLayout_24
		horizontalLayout_24 = buildHorizontalLayout_24();
		mainLayout.addComponent(horizontalLayout_24);
		
		// horizontalLayout_25
		horizontalLayout_25 = buildHorizontalLayout_25();
		mainLayout.addComponent(horizontalLayout_25);
		
		// table_4
		table_4 = new Table();
		table_4.setImmediate(false);
		table_4.setWidth("870px");
		table_4.setHeight("250px");
		mainLayout.addComponent(table_4);
		
		return mainLayout;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_24() {
		// common part: create layout
		horizontalLayout_24 = new HorizontalLayout();
		horizontalLayout_24.setImmediate(false);
		horizontalLayout_24.setWidth("-1px");
		horizontalLayout_24.setHeight("-1px");
		horizontalLayout_24.setMargin(false);
		horizontalLayout_24.setSpacing(true);
		
		// comboBox_9
		comboBox_9 = new ComboBox();
		comboBox_9.setCaption("Moneda");
		comboBox_9.setImmediate(false);
		comboBox_9.setWidth("-1px");
		comboBox_9.setHeight("-1px");
		horizontalLayout_24.addComponent(comboBox_9);
		
		// textField_17
		textField_17 = new TextField();
		textField_17.setCaption("Monto");
		textField_17.setImmediate(false);
		textField_17.setWidth("-1px");
		textField_17.setHeight("-1px");
		textField_17.setInputPrompt("Monto");
		textField_17.setMaxLength(8);
		horizontalLayout_24.addComponent(textField_17);
		
		// comboBox_10
		comboBox_10 = new ComboBox();
		comboBox_10.setCaption("Situacion");
		comboBox_10.setImmediate(false);
		comboBox_10.setWidth("-1px");
		comboBox_10.setHeight("-1px");
		horizontalLayout_24.addComponent(comboBox_10);
		
		// comboBox_11
		comboBox_11 = new ComboBox();
		comboBox_11.setCaption("Tipo de Cuenta");
		comboBox_11.setImmediate(false);
		comboBox_11.setWidth("-1px");
		comboBox_11.setHeight("-1px");
		horizontalLayout_24.addComponent(comboBox_11);
		
		// textField_19
		textField_19 = new TextField();
		textField_19.setCaption("Numero de Cuenta");
		textField_19.setImmediate(false);
		textField_19.setWidth("200px");
		textField_19.setHeight("-1px");
		textField_19.setInputPrompt("Numero de Cuenta");
		textField_19.setMaxLength(20);
		horizontalLayout_24.addComponent(textField_19);
		
		return horizontalLayout_24;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_25() {
		// common part: create layout
		horizontalLayout_25 = new HorizontalLayout();
		horizontalLayout_25.setImmediate(false);
		horizontalLayout_25.setWidth("-1px");
		horizontalLayout_25.setHeight("-1px");
		horizontalLayout_25.setMargin(false);
		horizontalLayout_25.setSpacing(true);
		
		// comboBox_12
		comboBox_12 = new ComboBox();
		comboBox_12.setCaption("Banco");
		comboBox_12.setImmediate(false);
		comboBox_12.setWidth("-1px");
		comboBox_12.setHeight("-1px");
		horizontalLayout_25.addComponent(comboBox_12);
		
		// textField_18
		textField_18 = new TextField();
		textField_18.setCaption("Numero de Tarjeta");
		textField_18.setImmediate(false);
		textField_18.setWidth("200px");
		textField_18.setHeight("-1px");
		textField_18.setInputPrompt("Numero de Tarjeta");
		textField_18.setMaxLength(24);
		horizontalLayout_25.addComponent(textField_18);
		
		// optionGroup_1
		optionGroup_1 = new OptionGroup();
		optionGroup_1.setCaption("Autenticidad");
		optionGroup_1.setImmediate(false);
		optionGroup_1.setWidth("-1px");
		optionGroup_1.setHeight("20px");
		horizontalLayout_25.addComponent(optionGroup_1);
		
		// button_3
		button_3 = new Button();
		button_3.setCaption("Registrar");
		button_3.setImmediate(true);
		button_3.setWidth("-1px");
		button_3.setHeight("-1px");
		horizontalLayout_25.addComponent(button_3);
		horizontalLayout_25.setComponentAlignment(button_3, new Alignment(10));
		
		return horizontalLayout_25;
	}

}
