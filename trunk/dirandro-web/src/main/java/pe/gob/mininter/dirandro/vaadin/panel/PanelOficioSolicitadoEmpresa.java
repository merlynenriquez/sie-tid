package pe.gob.mininter.dirandro.vaadin.panel;

import java.util.List;

import pe.gob.mininter.dirandro.model.Empresa;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.OficioSolicitado;
import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.service.EmpresaService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.vaadin.util.AdjuntarReceiver;
import pe.gob.mininter.dirandro.vaadin.util.ComboBoxLOVS;
import pe.gob.mininter.dirandro.vaadin.util.DirandroComponent;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
public class PanelOficioSolicitadoEmpresa extends DirandroComponent implements ClickListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlPrincipal;
	@AutoGenerated
	private Table tblOficinaSolicitado;
	@AutoGenerated
	private HorizontalLayout lytBotones;
	@AutoGenerated
	private Button btnGuardar;
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
	private ComboBoxLOVS cmbTipo;
	@AutoGenerated
	private HorizontalLayout lytTipoResultado;
	@AutoGenerated
	private ComboBoxLOVS cmbTipoResultado;
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
	private Expediente expediente;
	private EmpresaService empresaService;
	private AdjuntarReceiver receiver=new AdjuntarReceiver();
	private Upload uploadDocumento = new Upload(null, receiver);
	
	public static final String COLUMNA_TIPO = "tipo";
	public static final String COLUMNA_NOMBRE = "nombre";
	
	public static final String COLUMNA_UNIDAD = "unidad";
	public static final String COLUMNA_TIPO_RESULTADO = "tipo_resultado";
	public static final String COLUMNA_OBSERVACION = "observacion";
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelOficioSolicitadoEmpresa(List<Opcion> acciones, String height, Expediente expediente) {
		super(acciones, height);
		buildMainLayout();
		setCompositionRoot(mainLayout);
		this.expediente=expediente;
		empresaService=Injector.obtenerServicio(EmpresaService.class);
		postConstruct();
	}

	public void postConstruct() {
		lytAdjunto.addComponent(uploadDocumento);
		uploadDocumento.setButtonCaption("Agregar Archivo");
		
		txtNroParte.setInputPrompt("Nro Parte");
		txtNroParte.setValue(expediente.getAutogenerado());
		txtNroParte.setEnabled(false);
		dtFechaParte.setInputPrompt("Fecha Parte");
		dtFechaParte.setValue(expediente.getFechaRegistro());
		dtFechaParte.setEnabled(false);
		
		List<Empresa> empresas=empresaService.buscar(null);
		cmbUnidad.setInputPrompt("Unidad");
		cmbUnidad.setItemCaptionPropertyId("razonSocial");
		cmbUnidad.setContainerDataSource(new BeanItemContainer<Empresa>(Empresa.class,  empresas));
		
		cmbTipoResultado.setInputPrompt("Tipo Resultado");
		cmbTipoResultado.setCodigoLista(Constante.LISTA.CODIGO.ADJUNTO_TIPO);
		cmbTipo.setInputPrompt("Tipo");
		cmbTipo.setCodigoLista(Constante.LISTA.CODIGO.ADJUNTO_TIPO);
		
		btnGuardar.addListener(this);
		
		IndexedContainer container = new IndexedContainer();
        
        container.addContainerProperty(COLUMNA_TIPO, String.class,  null);
        container.addContainerProperty(COLUMNA_NOMBRE, String.class,  null);
        
        tblAdjunto.setContainerDataSource(container);
        tblAdjunto.setVisibleColumns(new Object[]{COLUMNA_TIPO, COLUMNA_NOMBRE});
        tblAdjunto.setColumnWidth(COLUMNA_TIPO, 100);
        tblAdjunto.setColumnWidth(COLUMNA_NOMBRE, 100);
        tblAdjunto.setColumnHeader(COLUMNA_TIPO, "Tipo");
        tblAdjunto.setColumnHeader(COLUMNA_NOMBRE, "Nombre");
        
        container = new IndexedContainer();
        
        container.addContainerProperty(COLUMNA_UNIDAD, String.class,  null);
        container.addContainerProperty(COLUMNA_TIPO_RESULTADO, String.class,  null);
        container.addContainerProperty(COLUMNA_OBSERVACION, String.class,  null);
        
        tblOficinaSolicitado.setContainerDataSource(container);
        tblOficinaSolicitado.setVisibleColumns(new Object[]{COLUMNA_UNIDAD, COLUMNA_TIPO_RESULTADO, COLUMNA_OBSERVACION});
        tblOficinaSolicitado.setColumnWidth(COLUMNA_UNIDAD, 100);
        tblOficinaSolicitado.setColumnWidth(COLUMNA_TIPO_RESULTADO, 100);
        tblOficinaSolicitado.setColumnWidth(COLUMNA_OBSERVACION, 100);
        tblOficinaSolicitado.setColumnHeader(COLUMNA_UNIDAD, "Unidad");
        tblOficinaSolicitado.setColumnHeader(COLUMNA_TIPO_RESULTADO, "Tipo Resultado");
        tblOficinaSolicitado.setColumnHeader(COLUMNA_OBSERVACION, "Observacion");
		
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnGuardar)){
			OficioSolicitado oficioSolicitado=new OficioSolicitado();
			oficioSolicitado.setExpediente(expediente);
			Empresa empresa=(Empresa)cmbUnidad.getValue();
			oficioSolicitado.setUnidad(empresa);
			oficioSolicitado.setTipoResultado(cmbTipoResultado.getValor());
			oficioSolicitado.setObservacion((String)txtAObservacion.getValue());
		}
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
		
		// lytBotones
		lytBotones = buildLytBotones();
		pnlPrincipal.addComponent(lytBotones);
		pnlPrincipal.setComponentAlignment(lytBotones, new Alignment(20));
		
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
		dtFechaParte.setResolution(4);
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
		cmbTipoResultado = new ComboBoxLOVS();
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
		lytFormularioAdjunto.setSpacing(true);
		
		// lytAdjunto
		lytAdjunto = buildLytAdjunto();
		lytFormularioAdjunto.addComponent(lytAdjunto);
		
		// tblAdjunto
		tblAdjunto = new Table();
		tblAdjunto.setImmediate(false);
		tblAdjunto.setWidth("250px");
		tblAdjunto.setHeight("120px");
		lytFormularioAdjunto.addComponent(tblAdjunto);
		
		return lytFormularioAdjunto;
	}

	@AutoGenerated
	private HorizontalLayout buildLytAdjunto() {
		// common part: create layout
		lytAdjunto = new HorizontalLayout();
		lytAdjunto.setImmediate(false);
		lytAdjunto.setWidth("-1px");
		lytAdjunto.setHeight("-1px");
		lytAdjunto.setMargin(false);
		
		// cmbTipo
		cmbTipo = new ComboBoxLOVS();
		cmbTipo.setImmediate(false);
		cmbTipo.setWidth("100px");
		cmbTipo.setHeight("-1px");
		lytAdjunto.addComponent(cmbTipo);
		
		return lytAdjunto;
	}

	@AutoGenerated
	private HorizontalLayout buildLytBotones() {
		// common part: create layout
		lytBotones = new HorizontalLayout();
		lytBotones.setImmediate(false);
		lytBotones.setWidth("-1px");
		lytBotones.setHeight("-1px");
		lytBotones.setMargin(false);
		
		// btnGuardar
		btnGuardar = new Button();
		btnGuardar.setCaption("Agregar");
		btnGuardar.setImmediate(false);
		btnGuardar.setWidth("-1px");
		btnGuardar.setHeight("-1px");
		lytBotones.addComponent(btnGuardar);
		
		return lytBotones;
	}

}
