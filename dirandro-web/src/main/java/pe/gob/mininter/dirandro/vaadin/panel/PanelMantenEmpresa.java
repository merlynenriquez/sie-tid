package pe.gob.mininter.dirandro.vaadin.panel;

import java.util.List;

import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.vaadin.util.HarecComponent;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PanelMantenEmpresa extends HarecComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout pnlPrincipal;
	@AutoGenerated
	private VerticalLayout verticalLayout_3;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_5;
	@AutoGenerated
	private Button button_1;
	@AutoGenerated
	private VerticalLayout verticalLayout_4;
	@AutoGenerated
	private ComboBox cmbEstado;
	@AutoGenerated
	private TextField txtTelefono;
	@AutoGenerated
	private TextField txtPartida;
	@AutoGenerated
	private TextField txtDireccion;
	@AutoGenerated
	private TextField txtRuc;
	@AutoGenerated
	private TextField txtRazonSocial;
	@AutoGenerated
	private Label label_2;
	@AutoGenerated
	private VerticalLayout verticalLayout_2;
	@AutoGenerated
	private Table table_2;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_6;
	@AutoGenerated
	private TextField textField_8;
	@AutoGenerated
	private TextField textField_7;
	@AutoGenerated
	private Label label_1;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelMantenEmpresa(List<Opcion> acciones, String height) {
		super(acciones, height);
		buildMainLayout();
		setCompositionRoot(mainLayout);
		postConstruct();
		debugId();
	}
	private void debugId(){
		
	}
	public void postConstruct() {
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
		
		// pnlPrincipal
		pnlPrincipal = buildPnlPrincipal();
		mainLayout.addComponent(pnlPrincipal);
		mainLayout.setComponentAlignment(pnlPrincipal, new Alignment(20));
		
		return mainLayout;
	}
	@AutoGenerated
	private HorizontalLayout buildPnlPrincipal() {
		// common part: create layout
		pnlPrincipal = new HorizontalLayout();
		pnlPrincipal.setStyleName("backColor");
		pnlPrincipal.setImmediate(false);
		pnlPrincipal.setWidth("680px");
		pnlPrincipal.setHeight("380px");
		pnlPrincipal.setMargin(false);
		
		// verticalLayout_2
		verticalLayout_2 = buildVerticalLayout_2();
		pnlPrincipal.addComponent(verticalLayout_2);
		
		// verticalLayout_3
		verticalLayout_3 = buildVerticalLayout_3();
		pnlPrincipal.addComponent(verticalLayout_3);
		
		return pnlPrincipal;
	}
	@AutoGenerated
	private VerticalLayout buildVerticalLayout_2() {
		// common part: create layout
		verticalLayout_2 = new VerticalLayout();
		verticalLayout_2.setImmediate(false);
		verticalLayout_2.setWidth("-1px");
		verticalLayout_2.setHeight("320px");
		verticalLayout_2.setMargin(false);
		
		// label_1
		label_1 = new Label();
		label_1.setStyleName("h2");
		label_1.setImmediate(false);
		label_1.setWidth("142px");
		label_1.setHeight("-1px");
		label_1.setValue("Filtro Empresas");
		verticalLayout_2.addComponent(label_1);
		verticalLayout_2.setComponentAlignment(label_1, new Alignment(20));
		
		// horizontalLayout_6
		horizontalLayout_6 = buildHorizontalLayout_6();
		verticalLayout_2.addComponent(horizontalLayout_6);
		
		// table_2
		table_2 = new Table();
		table_2.setImmediate(false);
		table_2.setWidth("650px");
		table_2.setHeight("-1px");
		table_2.setRequired(true);
		verticalLayout_2.addComponent(table_2);
		
		return verticalLayout_2;
	}
	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_6() {
		// common part: create layout
		horizontalLayout_6 = new HorizontalLayout();
		horizontalLayout_6.setImmediate(false);
		horizontalLayout_6.setWidth("-1px");
		horizontalLayout_6.setHeight("-1px");
		horizontalLayout_6.setMargin(false);
		
		// textField_7
		textField_7 = new TextField();
		textField_7.setImmediate(false);
		textField_7.setWidth("-1px");
		textField_7.setHeight("-1px");
		textField_7.setInputPrompt("RUC");
		horizontalLayout_6.addComponent(textField_7);
		
		// textField_8
		textField_8 = new TextField();
		textField_8.setImmediate(false);
		textField_8.setWidth("-1px");
		textField_8.setHeight("-1px");
		textField_8.setInputPrompt("Razón Social");
		horizontalLayout_6.addComponent(textField_8);
		
		return horizontalLayout_6;
	}
	@AutoGenerated
	private VerticalLayout buildVerticalLayout_3() {
		// common part: create layout
		verticalLayout_3 = new VerticalLayout();
		verticalLayout_3.setImmediate(false);
		verticalLayout_3.setWidth("-1px");
		verticalLayout_3.setHeight("360px");
		verticalLayout_3.setMargin(false);
		
		// label_2
		label_2 = new Label();
		label_2.setStyleName("h2");
		label_2.setImmediate(false);
		label_2.setWidth("234px");
		label_2.setHeight("-1px");
		label_2.setValue("Administración Empresa");
		verticalLayout_3.addComponent(label_2);
		verticalLayout_3.setComponentAlignment(label_2, new Alignment(20));
		
		// verticalLayout_4
		verticalLayout_4 = buildVerticalLayout_4();
		verticalLayout_3.addComponent(verticalLayout_4);
		
		// horizontalLayout_5
		horizontalLayout_5 = buildHorizontalLayout_5();
		verticalLayout_3.addComponent(horizontalLayout_5);
		verticalLayout_3.setComponentAlignment(horizontalLayout_5,
				new Alignment(20));
		
		return verticalLayout_3;
	}
	@AutoGenerated
	private VerticalLayout buildVerticalLayout_4() {
		// common part: create layout
		verticalLayout_4 = new VerticalLayout();
		verticalLayout_4.setImmediate(false);
		verticalLayout_4.setWidth("290px");
		verticalLayout_4.setHeight("-1px");
		verticalLayout_4.setMargin(false);
		verticalLayout_4.setSpacing(true);
		
		// txtRazonSocial
		txtRazonSocial = new TextField();
		txtRazonSocial.setCaption("Razón Social");
		txtRazonSocial.setImmediate(false);
		txtRazonSocial.setWidth("-1px");
		txtRazonSocial.setHeight("-1px");
		verticalLayout_4.addComponent(txtRazonSocial);
		
		// txtRuc
		txtRuc = new TextField();
		txtRuc.setCaption("RUC");
		txtRuc.setImmediate(false);
		txtRuc.setWidth("-1px");
		txtRuc.setHeight("-1px");
		txtRuc.setRequired(true);
		verticalLayout_4.addComponent(txtRuc);
		
		// txtDireccion
		txtDireccion = new TextField();
		txtDireccion.setCaption("Dirección");
		txtDireccion.setImmediate(false);
		txtDireccion.setWidth("286px");
		txtDireccion.setHeight("-1px");
		txtDireccion.setRequired(true);
		verticalLayout_4.addComponent(txtDireccion);
		
		// txtPartida
		txtPartida = new TextField();
		txtPartida.setCaption("Partida Reg");
		txtPartida.setImmediate(false);
		txtPartida.setWidth("-1px");
		txtPartida.setHeight("-1px");
		verticalLayout_4.addComponent(txtPartida);
		
		// txtTelefono
		txtTelefono = new TextField();
		txtTelefono.setCaption("Teléfono");
		txtTelefono.setImmediate(false);
		txtTelefono.setWidth("139px");
		txtTelefono.setHeight("-1px");
		verticalLayout_4.addComponent(txtTelefono);
		
		// cmbEstado
		cmbEstado = new ComboBox();
		cmbEstado.setCaption("Estado");
		cmbEstado.setImmediate(false);
		cmbEstado.setWidth("136px");
		cmbEstado.setHeight("-1px");
		cmbEstado.setRequired(true);
		verticalLayout_4.addComponent(cmbEstado);
		
		return verticalLayout_4;
	}
	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_5() {
		// common part: create layout
		horizontalLayout_5 = new HorizontalLayout();
		horizontalLayout_5.setImmediate(false);
		horizontalLayout_5.setWidth("116px");
		horizontalLayout_5.setHeight("-1px");
		horizontalLayout_5.setMargin(false);
		
		// button_1
		button_1 = new Button();
		button_1.setCaption("Agregar");
		button_1.setImmediate(true);
		button_1.setWidth("-1px");
		button_1.setHeight("-1px");
		horizontalLayout_5.addComponent(button_1);
		
		return horizontalLayout_5;
	}

}
