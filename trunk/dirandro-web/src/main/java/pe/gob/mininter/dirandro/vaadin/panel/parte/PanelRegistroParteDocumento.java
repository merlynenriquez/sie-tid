package pe.gob.mininter.dirandro.vaadin.panel.parte;

import java.util.List;

import pe.gob.mininter.dirandro.model.Documento;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.service.DocumentoService;
import pe.gob.mininter.dirandro.service.ExpedienteService;
import pe.gob.mininter.dirandro.vaadin.dialogs.AlertDialog;
import pe.gob.mininter.dirandro.vaadin.panel.documento.PanelDocumento;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class PanelRegistroParteDocumento extends CustomComponent implements ClickListener {

	@AutoGenerated
	private VerticalLayout mainLayout;

	@AutoGenerated
	private Table tblDocumento;

	@AutoGenerated
	private HorizontalLayout pnlBotonera;

	@AutoGenerated
	private Button btnAgregar;

	@AutoGenerated
	private PanelDocumento pnlDocumento;

	/**
	 * 
	 */
	private static final long serialVersionUID = 9178653485992433542L;
	
	private Expediente expediente;
	private DocumentoService documentoService;	
	private IndexedContainer container;
	
	private static final String COLUMN_NUMERO_DOCUMENTO = "NRO_DOCUMENTO";
	private static final String COLUMN_TIPO_DOCUMENTO = "TIPO_DOCUMENTO";
	private static final String COLUMN_ASUNTO = "ASUNTO";
	private static final String COLUMN_DIAS_ATENCION = "DIAS_ATENCION";
	private static final String COLUMN_FOLIOS = "FOLIOS";
	private static final String COLUMN_PRIORIDAD = "PRIORIDAD";
	private static final String COLUMN_ES_INICIAL = "ES_INICIAL";
	private static final String COLUMN_DOCUMENTO = "DOCUMENTO";
	
	private static final String ES_INICAL = "1";
	private boolean inicializado=false;
	private ExpedienteService expedienteService;
	
	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelRegistroParteDocumento() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		
		documentoService = Injector.obtenerServicio(DocumentoService.class);
		expedienteService = Injector.obtenerServicio(ExpedienteService.class);
		
		postConstruct();

	}

	/**
	 * Metodo que recibe el expediente<br> 
	 * Carga los datos del panel en base al expediente recibido<br>
	 * Deja huella de la inicializacion para no volver a recargar los datos
	 * @param expediente
	 */
	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
		postConstruct();
		inicializado=true;
	}
	
	private void postConstruct() {
		if(!inicializado){
			this.container = new IndexedContainer();
			container.addContainerProperty(COLUMN_NUMERO_DOCUMENTO, String.class,  null);
			container.addContainerProperty(COLUMN_TIPO_DOCUMENTO, String.class,  null);
			container.addContainerProperty(COLUMN_ASUNTO, String.class,  null);
			container.addContainerProperty(COLUMN_DIAS_ATENCION, Integer.class,  null);
			container.addContainerProperty(COLUMN_FOLIOS, Integer.class,  null);
			container.addContainerProperty(COLUMN_PRIORIDAD, String.class,  null);
			container.addContainerProperty(COLUMN_ES_INICIAL, CheckBox.class,  null);
			container.addContainerProperty(COLUMN_DOCUMENTO, Documento.class,  null);
			
			tblDocumento.setContainerDataSource(container);
			
			tblDocumento.setColumnHeader(COLUMN_NUMERO_DOCUMENTO, "Nro. Documento");
			tblDocumento.setColumnHeader(COLUMN_TIPO_DOCUMENTO, "Tipo Documento");
			tblDocumento.setColumnHeader(COLUMN_ASUNTO, "Asunto");
			tblDocumento.setColumnHeader(COLUMN_DIAS_ATENCION, "Días de Atención");
			tblDocumento.setColumnHeader(COLUMN_FOLIOS, "Nro. Folio");
			tblDocumento.setColumnHeader(COLUMN_PRIORIDAD, "Prioridad");
			tblDocumento.setColumnHeader(COLUMN_ES_INICIAL, "Es inicial");
			
			tblDocumento.setVisibleColumns(new Object[]{COLUMN_NUMERO_DOCUMENTO, 
					COLUMN_TIPO_DOCUMENTO, COLUMN_ASUNTO, COLUMN_DIAS_ATENCION, 
					COLUMN_FOLIOS, COLUMN_PRIORIDAD, COLUMN_ES_INICIAL});
			
			btnAgregar.addListener( (ClickListener) this);
			cargarDocumentos();
		}
	}

	public void cargarDocumentos() {
		if(expediente != null) {
			List<Documento> documentos = documentoService.obtenerDocumentosDelExpediente(expediente);
			
			container.removeAllItems();//Limpiando la tabla.
			
			for (Documento documento : documentos) {
				Item item = container.addItem(documento.getId());
				item.getItemProperty(COLUMN_NUMERO_DOCUMENTO).setValue(documento.getNroDocumento());
				item.getItemProperty(COLUMN_TIPO_DOCUMENTO).setValue(documento.getTipoDocumento().getNombre());
				item.getItemProperty(COLUMN_ASUNTO).setValue(documento.getAsunto());
				item.getItemProperty(COLUMN_DIAS_ATENCION).setValue(documento.getDiasAtencion());
				item.getItemProperty(COLUMN_FOLIOS).setValue(documento.getFolios());
				item.getItemProperty(COLUMN_PRIORIDAD).setValue(documento.getPrioridad().getNombre());
				item.getItemProperty(COLUMN_ES_INICIAL).setValue(crearCheckBox(documento.getEsInicial()));
				item.getItemProperty(COLUMN_DOCUMENTO).setValue(documento);
				
			}
		}
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnAgregar)) {
			buttonClickBtnAgregar();
		}
		
	}

	private void buttonClickBtnAgregar() {
		pnlDocumento.setDocumento(null);
		Documento documento = pnlDocumento.getDocumento();
		documento.setEsInicial("0");
		
		expedienteService.agregarDocumento(expediente, pnlDocumento.getDocumento());
		
		AlertDialog alertDialog = new  AlertDialog("Registro de Documento", "Se ha registrado el documento correctamente", "Aceptar", "400");
		getApplication().getMainWindow().addWindow(alertDialog);
		
		cargarDocumentos();
		pnlDocumento.limpiar();
	}

	private CheckBox crearCheckBox(String esInicial) {
		CheckBox chk = new CheckBox();
		chk.setValue(ES_INICAL.equals(esInicial));		
		chk.setEnabled(false);
		return chk;
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// pnlDocumento
		pnlDocumento = new PanelDocumento();
		pnlDocumento.setImmediate(false);
		pnlDocumento.setWidth("100.0%");
		pnlDocumento.setHeight("100.0%");
		mainLayout.addComponent(pnlDocumento);
		mainLayout.setExpandRatio(pnlDocumento, 1.0f);
		
		// pnlBotonera
		pnlBotonera = buildPnlBotonera();
		mainLayout.addComponent(pnlBotonera);
		
		// tblDocumento
		tblDocumento = new Table();
		tblDocumento.setImmediate(false);
		tblDocumento.setWidth("800px");
		tblDocumento.setHeight("-1px");
		mainLayout.addComponent(tblDocumento);
		
		return mainLayout;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlBotonera() {
		// common part: create layout
		pnlBotonera = new HorizontalLayout();
		pnlBotonera.setImmediate(false);
		pnlBotonera.setWidth("-1px");
		pnlBotonera.setHeight("-1px");
		pnlBotonera.setMargin(false);
		
		// btnAgregar
		btnAgregar = new Button();
		btnAgregar.setCaption("Agregar");
		btnAgregar.setImmediate(true);
		btnAgregar.setWidth("-1px");
		btnAgregar.setHeight("-1px");
		pnlBotonera.addComponent(btnAgregar);
		
		return pnlBotonera;
	}

}
