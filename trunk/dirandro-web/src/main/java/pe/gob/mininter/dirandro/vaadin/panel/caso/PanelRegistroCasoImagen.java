package pe.gob.mininter.dirandro.vaadin.panel.caso;

import pe.gob.mininter.dirandro.vaadin.util.ComboBoxLOVS;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ProgressIndicator;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class PanelRegistroCasoImagen extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout verticalLayout_1;
	@AutoGenerated
	private Table tblAdjunto;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private Label lblDatosAdjunto;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private Button btnAgregar;
	@AutoGenerated
	private Button btnCancelar;
	@AutoGenerated
	private ProgressIndicator progressIndicator_1;
	@AutoGenerated
	private ComboBoxLOVS cmbTipoAdjunto;
	@AutoGenerated
	private Label label_1;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelRegistroCasoImagen() {
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
		
		// tblAdjunto
		tblAdjunto = new Table();
		tblAdjunto.setImmediate(false);
		tblAdjunto.setWidth("100.0%");
		tblAdjunto.setHeight("200px");
		verticalLayout_1.addComponent(tblAdjunto);
		
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
		
		// label_1
		label_1 = new Label();
		label_1.setImmediate(false);
		label_1.setWidth("-1px");
		label_1.setHeight("-1px");
		label_1.setValue("Tipo de Adjunto");
		horizontalLayout_1.addComponent(label_1);
		
		// cmbTipoAdjunto
		cmbTipoAdjunto = new ComboBoxLOVS();
		cmbTipoAdjunto.setImmediate(false);
		cmbTipoAdjunto.setWidth("100px");
		cmbTipoAdjunto.setHeight("-1px");
		horizontalLayout_1.addComponent(cmbTipoAdjunto);
		
		// progressIndicator_1
		progressIndicator_1 = new ProgressIndicator();
		progressIndicator_1.setImmediate(false);
		progressIndicator_1.setWidth("-1px");
		progressIndicator_1.setHeight("-1px");
		horizontalLayout_1.addComponent(progressIndicator_1);
		
		// btnCancelar
		btnCancelar = new Button();
		btnCancelar.setCaption("Cancelar");
		btnCancelar.setImmediate(false);
		btnCancelar.setWidth("-1px");
		btnCancelar.setHeight("-1px");
		horizontalLayout_1.addComponent(btnCancelar);
		
		// btnAgregar
		btnAgregar = new Button();
		btnAgregar.setCaption("Agregar");
		btnAgregar.setImmediate(false);
		btnAgregar.setWidth("-1px");
		btnAgregar.setHeight("-1px");
		horizontalLayout_1.addComponent(btnAgregar);
		
		return horizontalLayout_1;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_2() {
		// common part: create layout
		horizontalLayout_2 = new HorizontalLayout();
		horizontalLayout_2.setImmediate(false);
		horizontalLayout_2.setWidth("100.0%");
		horizontalLayout_2.setHeight("-1px");
		horizontalLayout_2.setMargin(false);
		
		// lblDatosAdjunto
		lblDatosAdjunto = new Label();
		lblDatosAdjunto.setImmediate(false);
		lblDatosAdjunto.setWidth("100.0%");
		lblDatosAdjunto.setHeight("-1px");
		lblDatosAdjunto.setValue("Label");
		horizontalLayout_2.addComponent(lblDatosAdjunto);
		
		return horizontalLayout_2;
	}

}