package pe.gob.mininter.dirandro.vaadin.panel;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PanelOficioSolicitadoEmpresa extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlPrincipal;
	@AutoGenerated
	private Table tblOficinaSolicitado;
	@AutoGenerated
	private HorizontalLayout lytFormulario;
	@AutoGenerated
	private VerticalLayout lytFormularioFila2;
	@AutoGenerated
	private VerticalLayout lytFormularioAdjunto;
	@AutoGenerated
	private Table tblAdjunto;
	@AutoGenerated
	private HorizontalLayout lytAdjunto;
	@AutoGenerated
	private HorizontalLayout lytTipoResultado;
	@AutoGenerated
	private ComboBox cmbTipoResultado;
	@AutoGenerated
	private Label lblTipoResultado;
	@AutoGenerated
	private HorizontalLayout lytFechaParte;
	@AutoGenerated
	private PopupDateField dtFechaParte;
	@AutoGenerated
	private Label lblFechaParte;
	@AutoGenerated
	private VerticalLayout lytFormularioFila1;
	@AutoGenerated
	private HorizontalLayout lytObservacion;
	@AutoGenerated
	private TextArea txtAObservacion;
	@AutoGenerated
	private Label lblObservacion;
	@AutoGenerated
	private HorizontalLayout lytUnidad;
	@AutoGenerated
	private ComboBox cmbUnidad;
	@AutoGenerated
	private Label lblUnidad;
	@AutoGenerated
	private HorizontalLayout lytNroParte;
	@AutoGenerated
	private TextField txtNroParte;
	@AutoGenerated
	private Label lblNroParte;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelOficioSolicitadoEmpresa() {
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
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildPnlPrincipal() {
		// common part: create layout
		pnlPrincipal = new VerticalLayout();
		pnlPrincipal.setImmediate(false);
		pnlPrincipal.setWidth("-1px");
		pnlPrincipal.setHeight("-1px");
		pnlPrincipal.setMargin(false);
		pnlPrincipal.setSpacing(true);
		
		// lytFormulario
		lytFormulario = buildLytFormulario();
		pnlPrincipal.addComponent(lytFormulario);
		
		// tblOficinaSolicitado
		tblOficinaSolicitado = new Table();
		tblOficinaSolicitado.setImmediate(false);
		tblOficinaSolicitado.setWidth("600px");
		tblOficinaSolicitado.setHeight("200px");
		pnlPrincipal.addComponent(tblOficinaSolicitado);
		
		return pnlPrincipal;
	}

	@AutoGenerated
	private HorizontalLayout buildLytFormulario() {
		// common part: create layout
		lytFormulario = new HorizontalLayout();
		lytFormulario.setImmediate(false);
		lytFormulario.setWidth("-1px");
		lytFormulario.setHeight("-1px");
		lytFormulario.setMargin(false);
		lytFormulario.setSpacing(true);
		
		// lytFormularioFila1
		lytFormularioFila1 = buildLytFormularioFila1();
		lytFormulario.addComponent(lytFormularioFila1);
		
		// lytFormularioFila2
		lytFormularioFila2 = buildLytFormularioFila2();
		lytFormulario.addComponent(lytFormularioFila2);
		
		return lytFormulario;
	}

	@AutoGenerated
	private VerticalLayout buildLytFormularioFila1() {
		// common part: create layout
		lytFormularioFila1 = new VerticalLayout();
		lytFormularioFila1.setImmediate(false);
		lytFormularioFila1.setWidth("-1px");
		lytFormularioFila1.setHeight("-1px");
		lytFormularioFila1.setMargin(false);
		lytFormularioFila1.setSpacing(true);
		
		// lytNroParte
		lytNroParte = buildLytNroParte();
		lytFormularioFila1.addComponent(lytNroParte);
		
		// lytUnidad
		lytUnidad = buildLytUnidad();
		lytFormularioFila1.addComponent(lytUnidad);
		
		// lytObservacion
		lytObservacion = buildLytObservacion();
		lytFormularioFila1.addComponent(lytObservacion);
		
		return lytFormularioFila1;
	}

	@AutoGenerated
	private HorizontalLayout buildLytNroParte() {
		// common part: create layout
		lytNroParte = new HorizontalLayout();
		lytNroParte.setImmediate(false);
		lytNroParte.setWidth("-1px");
		lytNroParte.setHeight("-1px");
		lytNroParte.setMargin(false);
		lytNroParte.setSpacing(true);
		
		// lblNroParte
		lblNroParte = new Label();
		lblNroParte.setImmediate(false);
		lblNroParte.setWidth("100px");
		lblNroParte.setHeight("-1px");
		lblNroParte.setValue("N° de Parte");
		lytNroParte.addComponent(lblNroParte);
		
		// txtNroParte
		txtNroParte = new TextField();
		txtNroParte.setImmediate(false);
		txtNroParte.setWidth("150px");
		txtNroParte.setHeight("-1px");
		lytNroParte.addComponent(txtNroParte);
		
		return lytNroParte;
	}

	@AutoGenerated
	private HorizontalLayout buildLytUnidad() {
		// common part: create layout
		lytUnidad = new HorizontalLayout();
		lytUnidad.setImmediate(false);
		lytUnidad.setWidth("-1px");
		lytUnidad.setHeight("-1px");
		lytUnidad.setMargin(false);
		lytUnidad.setSpacing(true);
		
		// lblUnidad
		lblUnidad = new Label();
		lblUnidad.setImmediate(false);
		lblUnidad.setWidth("100px");
		lblUnidad.setHeight("-1px");
		lblUnidad.setValue("Unidad");
		lytUnidad.addComponent(lblUnidad);
		
		// cmbUnidad
		cmbUnidad = new ComboBox();
		cmbUnidad.setImmediate(false);
		cmbUnidad.setWidth("150px");
		cmbUnidad.setHeight("-1px");
		lytUnidad.addComponent(cmbUnidad);
		
		return lytUnidad;
	}

	@AutoGenerated
	private HorizontalLayout buildLytObservacion() {
		// common part: create layout
		lytObservacion = new HorizontalLayout();
		lytObservacion.setImmediate(false);
		lytObservacion.setWidth("-1px");
		lytObservacion.setHeight("-1px");
		lytObservacion.setMargin(false);
		lytObservacion.setSpacing(true);
		
		// lblObservacion
		lblObservacion = new Label();
		lblObservacion.setImmediate(false);
		lblObservacion.setWidth("100px");
		lblObservacion.setHeight("-1px");
		lblObservacion.setValue("Observacion");
		lytObservacion.addComponent(lblObservacion);
		
		// txtAObservacion
		txtAObservacion = new TextArea();
		txtAObservacion.setImmediate(false);
		txtAObservacion.setWidth("250px");
		txtAObservacion.setHeight("150px");
		lytObservacion.addComponent(txtAObservacion);
		
		return lytObservacion;
	}

	@AutoGenerated
	private VerticalLayout buildLytFormularioFila2() {
		// common part: create layout
		lytFormularioFila2 = new VerticalLayout();
		lytFormularioFila2.setImmediate(false);
		lytFormularioFila2.setWidth("-1px");
		lytFormularioFila2.setHeight("-1px");
		lytFormularioFila2.setMargin(false);
		lytFormularioFila2.setSpacing(true);
		
		// lytFechaParte
		lytFechaParte = buildLytFechaParte();
		lytFormularioFila2.addComponent(lytFechaParte);
		
		// lytTipoResultado
		lytTipoResultado = buildLytTipoResultado();
		lytFormularioFila2.addComponent(lytTipoResultado);
		
		// lytFormularioAdjunto
		lytFormularioAdjunto = buildLytFormularioAdjunto();
		lytFormularioFila2.addComponent(lytFormularioAdjunto);
		
		return lytFormularioFila2;
	}

	@AutoGenerated
	private HorizontalLayout buildLytFechaParte() {
		// common part: create layout
		lytFechaParte = new HorizontalLayout();
		lytFechaParte.setImmediate(false);
		lytFechaParte.setWidth("-1px");
		lytFechaParte.setHeight("-1px");
		lytFechaParte.setMargin(false);
		lytFechaParte.setSpacing(true);
		
		// lblFechaParte
		lblFechaParte = new Label();
		lblFechaParte.setImmediate(false);
		lblFechaParte.setWidth("100px");
		lblFechaParte.setHeight("-1px");
		lblFechaParte.setValue("Fecha de Parte");
		lytFechaParte.addComponent(lblFechaParte);
		
		// dtFechaParte
		dtFechaParte = new PopupDateField();
		dtFechaParte.setImmediate(false);
		dtFechaParte.setWidth("150px");
		dtFechaParte.setHeight("-1px");
		lytFechaParte.addComponent(dtFechaParte);
		
		return lytFechaParte;
	}

	@AutoGenerated
	private HorizontalLayout buildLytTipoResultado() {
		// common part: create layout
		lytTipoResultado = new HorizontalLayout();
		lytTipoResultado.setImmediate(false);
		lytTipoResultado.setWidth("-1px");
		lytTipoResultado.setHeight("-1px");
		lytTipoResultado.setMargin(false);
		lytTipoResultado.setSpacing(true);
		
		// lblTipoResultado
		lblTipoResultado = new Label();
		lblTipoResultado.setImmediate(false);
		lblTipoResultado.setWidth("100px");
		lblTipoResultado.setHeight("-1px");
		lblTipoResultado.setValue("Tipo Resultado");
		lytTipoResultado.addComponent(lblTipoResultado);
		
		// cmbTipoResultado
		cmbTipoResultado = new ComboBox();
		cmbTipoResultado.setImmediate(false);
		cmbTipoResultado.setWidth("150px");
		cmbTipoResultado.setHeight("-1px");
		lytTipoResultado.addComponent(cmbTipoResultado);
		
		return lytTipoResultado;
	}

	@AutoGenerated
	private VerticalLayout buildLytFormularioAdjunto() {
		// common part: create layout
		lytFormularioAdjunto = new VerticalLayout();
		lytFormularioAdjunto.setImmediate(false);
		lytFormularioAdjunto.setWidth("-1px");
		lytFormularioAdjunto.setHeight("-1px");
		lytFormularioAdjunto.setMargin(false);
		
		// lytAdjunto
		lytAdjunto = new HorizontalLayout();
		lytAdjunto.setImmediate(false);
		lytAdjunto.setWidth("-1px");
		lytAdjunto.setHeight("-1px");
		lytAdjunto.setMargin(false);
		lytFormularioAdjunto.addComponent(lytAdjunto);
		
		// tblAdjunto
		tblAdjunto = new Table();
		tblAdjunto.setImmediate(false);
		tblAdjunto.setWidth("250px");
		tblAdjunto.setHeight("120px");
		lytFormularioAdjunto.addComponent(tblAdjunto);
		
		return lytFormularioAdjunto;
	}

}
