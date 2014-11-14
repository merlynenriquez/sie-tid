package pe.gob.mininter.dirandro.vaadin.panel.caso;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PanelRegistroCasoDireccion extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout verticalLayout_1;
	@AutoGenerated
	private Table tblDirecciones;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private Button btnAgregar;
	@AutoGenerated
	private TextField txtReferencia;
	@AutoGenerated
	private TextField txtDireccin2;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private ComboBox cmbUbicacion;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelRegistroCasoDireccion() {
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
		
		// verticalLayout_1
		verticalLayout_1 = buildVerticalLayout_1();
		mainLayout.addComponent(verticalLayout_1);
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_1() {
		// common part: create layout
		verticalLayout_1 = new VerticalLayout();
		verticalLayout_1.setImmediate(false);
		verticalLayout_1.setWidth("100.0%");
		verticalLayout_1.setHeight("-1px");
		verticalLayout_1.setMargin(true);
		verticalLayout_1.setSpacing(true);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		verticalLayout_1.addComponent(horizontalLayout_1);
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		verticalLayout_1.addComponent(horizontalLayout_2);
		
		// tblDirecciones
		tblDirecciones = new Table();
		tblDirecciones.setImmediate(false);
		tblDirecciones.setWidth("100.0%");
		tblDirecciones.setHeight("200px");
		verticalLayout_1.addComponent(tblDirecciones);
		
		return verticalLayout_1;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("-1px");
		horizontalLayout_1.setHeight("-1px");
		horizontalLayout_1.setMargin(false);
		
		// cmbUbicacion
		cmbUbicacion = new ComboBox();
		cmbUbicacion.setCaption("Ubicación");
		cmbUbicacion.setImmediate(false);
		cmbUbicacion.setWidth("-1px");
		cmbUbicacion.setHeight("-1px");
		horizontalLayout_1.addComponent(cmbUbicacion);
		
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
		
		// txtDireccin2
		txtDireccin2 = new TextField();
		txtDireccin2.setCaption("Dirección");
		txtDireccin2.setImmediate(false);
		txtDireccin2.setWidth("200px");
		txtDireccin2.setHeight("-1px");
		txtDireccin2.setRequired(true);
		txtDireccin2.setInputPrompt("Dirección");
		horizontalLayout_2.addComponent(txtDireccin2);
		
		// txtReferencia
		txtReferencia = new TextField();
		txtReferencia.setCaption("Referencia");
		txtReferencia.setImmediate(false);
		txtReferencia.setWidth("300px");
		txtReferencia.setHeight("-1px");
		txtReferencia.setInputPrompt("Referencia");
		horizontalLayout_2.addComponent(txtReferencia);
		
		// btnAgregar
		btnAgregar = new Button();
		btnAgregar.setCaption("Agregar");
		btnAgregar.setImmediate(false);
		btnAgregar.setWidth("-1px");
		btnAgregar.setHeight("-1px");
		horizontalLayout_2.addComponent(btnAgregar);
		horizontalLayout_2.setComponentAlignment(btnAgregar, new Alignment(9));
		
		return horizontalLayout_2;
	}

}