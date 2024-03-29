package pe.gob.mininter.dirandro.vaadin.panel.busqueda;

import java.util.List;

import pe.gob.mininter.dirandro.model.Adjunto;
import pe.gob.mininter.dirandro.model.Documento;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.DocumentoService;
import pe.gob.mininter.dirandro.service.ModeloMarcaService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;
import pe.gob.mininter.dirandro.vaadin.util.ComboBoxLOVS;
import pe.gob.mininter.dirandro.vaadin.util.DirandroComponent;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class PanelBuscarDocumentos extends DirandroComponent implements ClickListener{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	
	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlPrincipal;
	@AutoGenerated
	private Table tblDocumento;
	@AutoGenerated
	private HorizontalLayout lytFiltro4;
	@AutoGenerated
	private Button btnBuscar;
	@AutoGenerated
	private CheckBox chkEsInicial;
	@AutoGenerated
	private HorizontalLayout lytFiltro3;
	@AutoGenerated
	private ComboBoxLOVS cmbPrioridad;
	@AutoGenerated
	private TextField txtAdjunto;
	@AutoGenerated
	private TextField txtFolio;
	@AutoGenerated
	private PopupDateField dtFechaDocumento;
	@AutoGenerated
	private HorizontalLayout lytFiltro2;
	@AutoGenerated
	private PopupDateField dtFechaRecepcion;
	@AutoGenerated
	private TextField txtDiasAtencion;
	@AutoGenerated
	private TextField txtAsunto;
	@AutoGenerated
	private TextField txtNroDocumento;
	@AutoGenerated
	private HorizontalLayout lytFiltro1;
	@AutoGenerated
	private ComboBoxLOVS cmbTipoDocumento;
	@AutoGenerated
	private TextField txtCodigoOrigen;
	@AutoGenerated
	private ComboBoxLOVS cmbTablaOrigen;
	@AutoGenerated
	private TextField txtExpediente;
	private ModeloMarcaService modeloMarcaService;
	private DocumentoService documentoService;
	
	private static final String COLUMN_ID = "COLUMN_ID";
	private static final String COLUMN_EXPEDIENTE = "COLUMN_EXPEDIENTE";
	private static final String COLUMN_TABLA_ORIGEN = "COLUMN_TABLA_ORIGEN";
	private static final String COLUMN_CODIGO_ORIGEN = "COLUMN_CODIGO_ORIGEN";
	private static final String COLUMN_TIPO_DOCUMENTO = "COLUMN_TIPO_DOCUMENTO";
	private static final String COLUMN_NRO_DOCUMENTO = "COLUMN_NRO_DOCUMENTO";
	private static final String COLUMN_ASUNTO = "COLUMN_ASUNTO";
	private static final String COLUMN_DIAS_ATENCION = "COLUMN_DIAS_ATENCION";
	private static final String COLUMN_FECHA_RECEPCION = "COLUMN_FECHA_RECEPCION";
	private static final String COLUMN_FECHA_DOCUMENTO = "COLUMN_FECHA_DOCUMENTO";
	private static final String COLUMN_FOLIOS = "COLUMN_FOLIOS";
	private static final String COLUMN_ADJUNTO = "COLUMN_ADJUNTO";
	private static final String COLUMN_PRIORIDAD = "COLUMN_PRIORIDAD";
	private static final String COLUMN_ES_INICIAL = "COLUMN_ES_INICIAL";
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelBuscarDocumentos(List<Opcion> acciones, String height) {
		super(acciones, height);
		buildMainLayout();
		modeloMarcaService = Injector.obtenerServicio(ModeloMarcaService.class);
		documentoService = Injector.obtenerServicio(DocumentoService.class);
		setCompositionRoot(mainLayout);
		postConstruct();
		debugId();
	}
	
	private void debugId(){
		
	}
	
	public void postConstruct() {
		txtExpediente.setInputPrompt("Expediente");
		cmbTablaOrigen.setInputPrompt("Tabla Origen");
		cmbTablaOrigen.setCodigoLista(Constante.LISTA.CODIGO.TABLAS);
		txtCodigoOrigen.setInputPrompt("Codigo Origen");
		cmbTipoDocumento.setInputPrompt("Tipo Documento");
		cmbTipoDocumento.setCodigoLista(Constante.LISTA.CODIGO.DOCUMENTO_TIPO);
		txtNroDocumento.setInputPrompt("Nro Documento");
		txtAsunto.setInputPrompt("Asunto");
		txtDiasAtencion.setInputPrompt("Dias Atencion");
		dtFechaRecepcion.setInputPrompt("Fecha Recepcion");
		dtFechaDocumento.setInputPrompt("Fecha Documento");
		txtFolio.setInputPrompt("Folios");
		txtAdjunto.setInputPrompt("Adjunto");
		cmbPrioridad.setInputPrompt("Prioridad");
		cmbPrioridad.setCodigoLista(Constante.LISTA.CODIGO.PRIORIDAD);
		
		btnBuscar.addListener(this);
		
		tblDocumento.setColumnCollapsingAllowed(true);
		cargarTabla(null);
	}
	
		
	private void cargarTabla(List<Documento> documentos)
	{
		IndexedContainer container = new IndexedContainer();
        
        container.addContainerProperty(COLUMN_ID, Long.class,  null);
        container.addContainerProperty(COLUMN_EXPEDIENTE, String.class,  null);
        container.addContainerProperty(COLUMN_TABLA_ORIGEN, String.class,  null);
        container.addContainerProperty(COLUMN_CODIGO_ORIGEN, String.class,  null);
        container.addContainerProperty(COLUMN_TIPO_DOCUMENTO, String.class,  null);
        container.addContainerProperty(COLUMN_NRO_DOCUMENTO, String.class,  null);
        container.addContainerProperty(COLUMN_ASUNTO, String.class,  null);
        container.addContainerProperty(COLUMN_DIAS_ATENCION, String.class,  null);
        container.addContainerProperty(COLUMN_FECHA_RECEPCION, String.class,  null);
        container.addContainerProperty(COLUMN_FECHA_DOCUMENTO, String.class,  null);
        container.addContainerProperty(COLUMN_FOLIOS, String.class,  null);
        container.addContainerProperty(COLUMN_ADJUNTO, String.class,  null);
        container.addContainerProperty(COLUMN_PRIORIDAD, String.class,  null);
        container.addContainerProperty(COLUMN_ES_INICIAL, String.class,  null);
        
        if(documentos!=null){
	        int con=1;
	        for (Documento documento: documentos) {
	                Item item = container.addItem(con++);
				    item.getItemProperty(COLUMN_ID).setValue(documento.getId());
				    item.getItemProperty(COLUMN_EXPEDIENTE).setValue(documento.getExpediente()!=null ? 
				    		documento.getExpediente().getAutogenerado() : null);
				    item.getItemProperty(COLUMN_TABLA_ORIGEN).setValue(documento.getTablaOrigen()!=null ? 
				    		documento.getTablaOrigen().getNombre() : null);
				    item.getItemProperty(COLUMN_CODIGO_ORIGEN).setValue(documento.getCodigoOrigen());
				    item.getItemProperty(COLUMN_TIPO_DOCUMENTO).setValue(documento.getTipoDocumento()!=null ? 
				    		documento.getTipoDocumento().getNombre() : null);
				    item.getItemProperty(COLUMN_NRO_DOCUMENTO).setValue(documento.getNroDocumento());
				    item.getItemProperty(COLUMN_ASUNTO).setValue(documento.getAsunto());
				    item.getItemProperty(COLUMN_DIAS_ATENCION).setValue(documento.getDiasAtencion());
				    item.getItemProperty(COLUMN_FECHA_RECEPCION).setValue(documento.getFechaRecepcion());
				    item.getItemProperty(COLUMN_FECHA_DOCUMENTO).setValue(documento.getFechaDocumento());
				    item.getItemProperty(COLUMN_FOLIOS).setValue(documento.getFolios());
				    item.getItemProperty(COLUMN_ADJUNTO).setValue(documento.getAdjunto()!=null ? 
				    		documento.getAdjunto().getNombre() : null);
				    item.getItemProperty(COLUMN_PRIORIDAD).setValue(documento.getPrioridad()!=null ? 
				    		documento.getPrioridad().getNombre() : null);
				    item.getItemProperty(COLUMN_ES_INICIAL).setValue(documento.getEsInicial());
	        }
        }
        
        tblDocumento.setContainerDataSource(container);
        tblDocumento.setVisibleColumns(new Object[]{COLUMN_EXPEDIENTE, COLUMN_TABLA_ORIGEN, COLUMN_CODIGO_ORIGEN, 
        		COLUMN_TIPO_DOCUMENTO, COLUMN_NRO_DOCUMENTO, COLUMN_ASUNTO, COLUMN_DIAS_ATENCION, COLUMN_FECHA_RECEPCION, 
        		COLUMN_FECHA_DOCUMENTO, COLUMN_FOLIOS, COLUMN_ADJUNTO, COLUMN_PRIORIDAD, COLUMN_ES_INICIAL});
        tblDocumento.setColumnWidth(COLUMN_EXPEDIENTE, 100);
        tblDocumento.setColumnWidth(COLUMN_TABLA_ORIGEN, 100);
        tblDocumento.setColumnWidth(COLUMN_CODIGO_ORIGEN, 100);
        tblDocumento.setColumnWidth(COLUMN_TIPO_DOCUMENTO, 100);
        tblDocumento.setColumnWidth(COLUMN_NRO_DOCUMENTO, 100);
        tblDocumento.setColumnWidth(COLUMN_ASUNTO, 100);
        tblDocumento.setColumnWidth(COLUMN_DIAS_ATENCION, 100);
        tblDocumento.setColumnWidth(COLUMN_FECHA_RECEPCION, 100);
        tblDocumento.setColumnWidth(COLUMN_FECHA_DOCUMENTO, 100);
        tblDocumento.setColumnWidth(COLUMN_FOLIOS, 100);
        tblDocumento.setColumnWidth(COLUMN_ADJUNTO, 100);
        tblDocumento.setColumnWidth(COLUMN_PRIORIDAD, 100);
        tblDocumento.setColumnWidth(COLUMN_ES_INICIAL, 100);
        tblDocumento.setColumnHeader(COLUMN_EXPEDIENTE, "Expediente");
        tblDocumento.setColumnHeader(COLUMN_TABLA_ORIGEN, "Tabla Origen");
        tblDocumento.setColumnHeader(COLUMN_CODIGO_ORIGEN, "Codigo Origen");
        tblDocumento.setColumnHeader(COLUMN_TIPO_DOCUMENTO, "Tipo Documento");
        tblDocumento.setColumnHeader(COLUMN_NRO_DOCUMENTO, "Nro Documento");
        tblDocumento.setColumnHeader(COLUMN_ASUNTO, "Asunto");
        tblDocumento.setColumnHeader(COLUMN_DIAS_ATENCION, "Dias Atencion");
        tblDocumento.setColumnHeader(COLUMN_FECHA_RECEPCION, "Fecha Recepcion");
        tblDocumento.setColumnHeader(COLUMN_FECHA_DOCUMENTO, "Fecha Documento");
        tblDocumento.setColumnHeader(COLUMN_FOLIOS, "Folios");
        tblDocumento.setColumnHeader(COLUMN_ADJUNTO, "Adjunto");
        tblDocumento.setColumnHeader(COLUMN_PRIORIDAD, "Prioridad");
        tblDocumento.setColumnHeader(COLUMN_ES_INICIAL, "Inicial");
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnBuscar)){
			Documento documento=new Documento();
			Expediente expediente =new Expediente();
			expediente.setAutogenerado((String)txtExpediente.getValue());
			documento.setExpediente(expediente);
			documento.setTablaOrigen(cmbTablaOrigen.getValor());
			documento.setCodigoOrigen(HarecUtil.toLong(txtCodigoOrigen));
			documento.setTipoDocumento(cmbTipoDocumento.getValor());
			documento.setNroDocumento((String)txtNroDocumento.getValue());
			documento.setAsunto((String)txtAsunto.getValue());
			documento.setDiasAtencion(HarecUtil.toBigDecimal(txtDiasAtencion));
			documento.setFolios(HarecUtil.toBigDecimal(txtFolio));
			Adjunto adjunto=new Adjunto();
			adjunto.setNombre((String)txtAdjunto.getValue());
			documento.setAdjunto(adjunto);
			documento.setPrioridad(cmbPrioridad.getValor());
			cargarTabla(documentoService.buscar(documento));
		}
	}
	
	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(false);
		
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
	private VerticalLayout buildPnlPrincipal() {
		// common part: create layout
		pnlPrincipal = new VerticalLayout();
		pnlPrincipal.setStyleName("whiteBackGround");
		pnlPrincipal.setImmediate(false);
		pnlPrincipal.setWidth("800px");
		pnlPrincipal.setHeight("-1px");
		pnlPrincipal.setMargin(true);
		pnlPrincipal.setSpacing(true);
		
		// lytFiltro1
		lytFiltro1 = buildLytFiltro1();
		pnlPrincipal.addComponent(lytFiltro1);
		
		// lytFiltro2
		lytFiltro2 = buildLytFiltro2();
		pnlPrincipal.addComponent(lytFiltro2);
		
		// lytFiltro3
		lytFiltro3 = buildLytFiltro3();
		pnlPrincipal.addComponent(lytFiltro3);
		
		// lytFiltro4
		lytFiltro4 = buildLytFiltro4();
		pnlPrincipal.addComponent(lytFiltro4);
		
		// tblDocumento
		tblDocumento = new Table();
		tblDocumento.setImmediate(false);
		tblDocumento.setWidth("730px");
		tblDocumento.setHeight("350px");
		pnlPrincipal.addComponent(tblDocumento);
		
		return pnlPrincipal;
	}

	@AutoGenerated
	private HorizontalLayout buildLytFiltro1() {
		// common part: create layout
		lytFiltro1 = new HorizontalLayout();
		lytFiltro1.setImmediate(false);
		lytFiltro1.setWidth("-1px");
		lytFiltro1.setHeight("-1px");
		lytFiltro1.setMargin(false);
		lytFiltro1.setSpacing(true);
		
		// txtExpediente
		txtExpediente = new TextField();
		txtExpediente.setImmediate(false);
		txtExpediente.setWidth("150px");
		txtExpediente.setHeight("-1px");
		lytFiltro1.addComponent(txtExpediente);
		
		// cmbTablaOrigen
		cmbTablaOrigen = new ComboBoxLOVS();
		cmbTablaOrigen.setImmediate(false);
		cmbTablaOrigen.setWidth("150px");
		cmbTablaOrigen.setHeight("-1px");
		lytFiltro1.addComponent(cmbTablaOrigen);
		
		// txtCodigoOrigen
		txtCodigoOrigen = new TextField();
		txtCodigoOrigen.setImmediate(false);
		txtCodigoOrigen.setWidth("150px");
		txtCodigoOrigen.setHeight("-1px");
		lytFiltro1.addComponent(txtCodigoOrigen);
		
		// cmbTipoDocumento
		cmbTipoDocumento = new ComboBoxLOVS();
		cmbTipoDocumento.setImmediate(false);
		cmbTipoDocumento.setWidth("150px");
		cmbTipoDocumento.setHeight("-1px");
		lytFiltro1.addComponent(cmbTipoDocumento);
		
		return lytFiltro1;
	}

	@AutoGenerated
	private HorizontalLayout buildLytFiltro2() {
		// common part: create layout
		lytFiltro2 = new HorizontalLayout();
		lytFiltro2.setImmediate(false);
		lytFiltro2.setWidth("-1px");
		lytFiltro2.setHeight("-1px");
		lytFiltro2.setMargin(false);
		lytFiltro2.setSpacing(true);
		
		// txtNroDocumento
		txtNroDocumento = new TextField();
		txtNroDocumento.setImmediate(false);
		txtNroDocumento.setWidth("150px");
		txtNroDocumento.setHeight("-1px");
		lytFiltro2.addComponent(txtNroDocumento);
		
		// txtAsunto
		txtAsunto = new TextField();
		txtAsunto.setImmediate(false);
		txtAsunto.setWidth("150px");
		txtAsunto.setHeight("-1px");
		lytFiltro2.addComponent(txtAsunto);
		
		// txtDiasAtencion
		txtDiasAtencion = new TextField();
		txtDiasAtencion.setImmediate(false);
		txtDiasAtencion.setWidth("150px");
		txtDiasAtencion.setHeight("-1px");
		lytFiltro2.addComponent(txtDiasAtencion);
		
		// dtFechaRecepcion
		dtFechaRecepcion = new PopupDateField();
		dtFechaRecepcion.setImmediate(false);
		dtFechaRecepcion.setWidth("150px");
		dtFechaRecepcion.setHeight("-1px");
		lytFiltro2.addComponent(dtFechaRecepcion);
		
		return lytFiltro2;
	}

	@AutoGenerated
	private HorizontalLayout buildLytFiltro3() {
		// common part: create layout
		lytFiltro3 = new HorizontalLayout();
		lytFiltro3.setImmediate(false);
		lytFiltro3.setWidth("-1px");
		lytFiltro3.setHeight("-1px");
		lytFiltro3.setMargin(false);
		lytFiltro3.setSpacing(true);
		
		// dtFechaDocumento
		dtFechaDocumento = new PopupDateField();
		dtFechaDocumento.setImmediate(false);
		dtFechaDocumento.setWidth("150px");
		dtFechaDocumento.setHeight("-1px");
		lytFiltro3.addComponent(dtFechaDocumento);
		
		// txtFolio
		txtFolio = new TextField();
		txtFolio.setImmediate(false);
		txtFolio.setWidth("150px");
		txtFolio.setHeight("-1px");
		lytFiltro3.addComponent(txtFolio);
		
		// txtAdjunto
		txtAdjunto = new TextField();
		txtAdjunto.setImmediate(false);
		txtAdjunto.setWidth("150px");
		txtAdjunto.setHeight("-1px");
		lytFiltro3.addComponent(txtAdjunto);
		
		// cmbPrioridad
		cmbPrioridad = new ComboBoxLOVS();
		cmbPrioridad.setImmediate(false);
		cmbPrioridad.setWidth("150px");
		cmbPrioridad.setHeight("-1px");
		lytFiltro3.addComponent(cmbPrioridad);
		
		return lytFiltro3;
	}

	@AutoGenerated
	private HorizontalLayout buildLytFiltro4() {
		// common part: create layout
		lytFiltro4 = new HorizontalLayout();
		lytFiltro4.setImmediate(false);
		lytFiltro4.setWidth("-1px");
		lytFiltro4.setHeight("-1px");
		lytFiltro4.setMargin(false);
		lytFiltro4.setSpacing(true);
		
		// chkEsInicial
		chkEsInicial = new CheckBox();
		chkEsInicial.setCaption("Inicial");
		chkEsInicial.setImmediate(false);
		chkEsInicial.setWidth("150px");
		chkEsInicial.setHeight("-1px");
		lytFiltro4.addComponent(chkEsInicial);
		
		// btnBuscar
		btnBuscar = new Button();
		btnBuscar.setCaption("Buscar");
		btnBuscar.setImmediate(true);
		btnBuscar.setWidth("-1px");
		btnBuscar.setHeight("-1px");
		lytFiltro4.addComponent(btnBuscar);
		
		return lytFiltro4;
	}	

}
