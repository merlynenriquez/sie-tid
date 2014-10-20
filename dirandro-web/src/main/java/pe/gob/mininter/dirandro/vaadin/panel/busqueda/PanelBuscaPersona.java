package pe.gob.mininter.dirandro.vaadin.panel.busqueda;

import java.util.List;

import pe.gob.mininter.dirandro.model.Arma;
import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.service.ArmaService;
import pe.gob.mininter.dirandro.service.ModeloMarcaService;
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
public class PanelBuscaPersona extends DirandroComponent implements ClickListener{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	
	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlPrincipal;
	@AutoGenerated
	private Table tblDocumento;
	@AutoGenerated
	private HorizontalLayout lytFiltro3;
	@AutoGenerated
	private Button btnBuscar;
	@AutoGenerated
	private TextField txtAlias;
	@AutoGenerated
	private ComboBox cmbSituacion;
	@AutoGenerated
	private PopupDateField dtIntervencion;
	@AutoGenerated
	private ComboBox cmbOcupacion;
	@AutoGenerated
	private HorizontalLayout lytFiltro2;
	@AutoGenerated
	private TextField txtOrganizacion;
	@AutoGenerated
	private CheckBox chkRequisitoria;
	@AutoGenerated
	private TextField txtExpediente;
	@AutoGenerated
	private ComboBox cmbEstado;
	@AutoGenerated
	private HorizontalLayout lytFiltro1;
	@AutoGenerated
	private ComboBox cmbTipoParticipacion;
	@AutoGenerated
	private ComboBox cmbParticipacion;
	@AutoGenerated
	private TextField txtEmpresa;
	@AutoGenerated
	private TextField txtInvolucrado;
	//private Expedientep armaService;
	
	private static final String COLUMN_ID = "COLUMN_ID";
	private static final String COLUMN_INVOLUCRADO = "COLUMN_INVOLUCRADO";
	private static final String COLUMN_EMPRESA = "COLUMN_EMPRESA";
	private static final String COLUMN_PARTICIPACION = "COLUMN_PARTICIPACION";
	private static final String COLUMN_TIPO_PARTICIPACION = "COLUMN_TIPO_PARTICIPACION";
	private static final String COLUMN_ESTADO_DATO = "COLUMN_ESTADO_DATO";
	private static final String COLUMN_EXPEDIENTE = "COLUMN_EXPEDIENTE";
	private static final String COLUMN_REQUISITORIA = "COLUMN_REQUISITORIA";
	private static final String COLUMN_ORGANIZACION = "COLUMN_ORGANIZACION";
	private static final String COLUMN_OCUPACION = "COLUMN_OCUPACION";
	private static final String COLUMN_INTERVENCION = "COLUMN_INTERVENCION";
	private static final String COLUMN_SITUACION = "COLUMN_SITUACION";
	private static final String COLUMN_ALIAS = "COLUMN_ALIAS";
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelBuscaPersona(List<Opcion> acciones, String height) {
		super(acciones, height);
		buildMainLayout();
		//armaService = Injector.obtenerServicio(ArmaService.class);
		setCompositionRoot(mainLayout);
		postConstruct();
		debugId();
	}
	
	private void debugId(){
		
	}
	
	public void postConstruct() {
		/*List<ModeloMarca> modeloMarcas=modeloMarcaService.buscarHijos(new ModeloMarca(Constante.MODELO_MARCA.ARMAS.TIPOS));
		cmbModelo.setInputPrompt("Modelo");
		cmbModelo.setItemCaptionPropertyId("nombre");
		cmbModelo.setContainerDataSource(new BeanItemContainer<ModeloMarca>(ModeloMarca.class,  modeloMarcas));*/
		/*cmbClasificacion.setInputPrompt("Clasificacion");
		cmbClasificacion.setCodigoLista(Constante.LISTA.CODIGO.TIPO_CALIBRE);*/
		/*cmbEstadoSerie.setInputPrompt("Estado Serie");
		cmbEstadoSerie.setCodigoLista(Constante.LISTA.CODIGO.ARMA_ESTADO_SERIE);
		cmbCalibre.setInputPrompt("Calibre");
		cmbCalibre.setCodigoLista(Constante.LISTA.CODIGO.TIPO_CALIBRE);
		
		btnBuscar.addListener(this);
		
		tblArma.setColumnCollapsingAllowed(true);
		cargarTabla(null);*/
	}
	
		
	private void cargarTabla(List<Arma> armas)
	{
		IndexedContainer container = new IndexedContainer();
        
        container.addContainerProperty(COLUMN_ID, Long.class,  null);
        container.addContainerProperty(COLUMN_INVOLUCRADO, String.class,  null);
        container.addContainerProperty(COLUMN_EMPRESA, String.class,  null);
        container.addContainerProperty(COLUMN_PARTICIPACION, String.class,  null);
        container.addContainerProperty(COLUMN_TIPO_PARTICIPACION, String.class,  null);
        container.addContainerProperty(COLUMN_ESTADO_DATO, String.class,  null);
        container.addContainerProperty(COLUMN_EXPEDIENTE, String.class,  null);
        container.addContainerProperty(COLUMN_REQUISITORIA, String.class,  null);
        container.addContainerProperty(COLUMN_ORGANIZACION, String.class,  null);
        container.addContainerProperty(COLUMN_OCUPACION, String.class,  null);
        container.addContainerProperty(COLUMN_INTERVENCION, String.class,  null);
        container.addContainerProperty(COLUMN_SITUACION, String.class,  null);
        container.addContainerProperty(COLUMN_ALIAS, String.class,  null);
        
        if(armas!=null){
	        int con=1;
	        for (Arma arma: armas) {
	                Item item = container.addItem(con++);
				    item.getItemProperty(COLUMN_ID).setValue(arma.getId());
				    /*item.getItemProperty(COLUMN_MODELO).setValue(arma.getModelo()!=null ? 
				    		arma.getModelo().getNombre() : null);
				    item.getItemProperty(COLUMN_EST_SERIE).setValue(arma.getEstadoSerie()!=null ? 
				    		arma.getEstadoSerie().getNombre() : null);
				    item.getItemProperty(COLUMN_NRO_SERIE).setValue(arma.getNroSerie());
				    item.getItemProperty(COLUMN_CALIBRE).setValue(arma.getCalibre()!=null ? 
				    		arma.getCalibre().getNombre() : null);
				    item.getItemProperty(COLUMN_INTERNAMIENTO).setValue(arma.getInternamiento());*/
	        }
        }
        
        tblDocumento.setContainerDataSource(container);
        tblDocumento.setVisibleColumns(new Object[]{COLUMN_INVOLUCRADO, COLUMN_EMPRESA, COLUMN_PARTICIPACION, COLUMN_TIPO_PARTICIPACION, 
        		COLUMN_ESTADO_DATO, COLUMN_EXPEDIENTE, COLUMN_REQUISITORIA, COLUMN_ORGANIZACION, 
        		COLUMN_OCUPACION, COLUMN_INTERVENCION, COLUMN_SITUACION, COLUMN_ALIAS});
        tblDocumento.setColumnWidth(COLUMN_INVOLUCRADO, 100);
        tblDocumento.setColumnWidth(COLUMN_EMPRESA, 100);
        tblDocumento.setColumnWidth(COLUMN_PARTICIPACION, 100);
        tblDocumento.setColumnWidth(COLUMN_TIPO_PARTICIPACION, 100);
        tblDocumento.setColumnWidth(COLUMN_ESTADO_DATO, 100);
        tblDocumento.setColumnWidth(COLUMN_EXPEDIENTE, 100);
        tblDocumento.setColumnWidth(COLUMN_REQUISITORIA, 100);
        tblDocumento.setColumnWidth(COLUMN_ORGANIZACION, 100);
        tblDocumento.setColumnWidth(COLUMN_OCUPACION, 100);
        tblDocumento.setColumnWidth(COLUMN_INTERVENCION, 100);
        tblDocumento.setColumnWidth(COLUMN_SITUACION, 100);
        tblDocumento.setColumnWidth(COLUMN_ALIAS, 100);
        tblDocumento.setColumnHeader(COLUMN_INVOLUCRADO, "Involucrado");
        tblDocumento.setColumnHeader(COLUMN_EMPRESA, "Empresa");
        tblDocumento.setColumnHeader(COLUMN_PARTICIPACION, "Participacion");
        tblDocumento.setColumnHeader(COLUMN_TIPO_PARTICIPACION, "Tipo Participacion");
        tblDocumento.setColumnHeader(COLUMN_ESTADO_DATO, "Estado Dato");
        tblDocumento.setColumnHeader(COLUMN_EXPEDIENTE, "Expediente");
        tblDocumento.setColumnHeader(COLUMN_REQUISITORIA, "Requisitoria");
        tblDocumento.setColumnHeader(COLUMN_ORGANIZACION, "Organizacion");
        tblDocumento.setColumnHeader(COLUMN_OCUPACION, "Ocupacion");
        tblDocumento.setColumnHeader(COLUMN_INTERVENCION, "Intervencion");
        tblDocumento.setColumnHeader(COLUMN_SITUACION, "Situacion");
        tblDocumento.setColumnHeader(COLUMN_ALIAS, "Alias");
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		/*if(event.getButton().equals(btnBuscar)){
			Arma arma=new Arma();
			arma.setModelo((ModeloMarca)cmbModelo.getValue());
			arma.setEstadoSerie(cmbEstadoSerie.getValor());
			arma.setNroSerie((String)txtNumeroSerie.getValue());
			arma.setCalibre(cmbCalibre.getValor());
			arma.setInternamiento((String)txtInternamiento.getValue());
			cargarTabla(armaService.buscar(arma));
		}*/
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
		
		// txtInvolucrado
		txtInvolucrado = new TextField();
		txtInvolucrado.setImmediate(false);
		txtInvolucrado.setWidth("150px");
		txtInvolucrado.setHeight("-1px");
		lytFiltro1.addComponent(txtInvolucrado);
		
		// txtEmpresa
		txtEmpresa = new TextField();
		txtEmpresa.setImmediate(false);
		txtEmpresa.setWidth("150px");
		txtEmpresa.setHeight("-1px");
		lytFiltro1.addComponent(txtEmpresa);
		
		// cmbParticipacion
		cmbParticipacion = new ComboBox();
		cmbParticipacion.setImmediate(false);
		cmbParticipacion.setWidth("150px");
		cmbParticipacion.setHeight("-1px");
		lytFiltro1.addComponent(cmbParticipacion);
		
		// cmbTipoParticipacion
		cmbTipoParticipacion = new ComboBox();
		cmbTipoParticipacion.setImmediate(false);
		cmbTipoParticipacion.setWidth("150px");
		cmbTipoParticipacion.setHeight("-1px");
		lytFiltro1.addComponent(cmbTipoParticipacion);
		
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
		
		// cmbEstado
		cmbEstado = new ComboBox();
		cmbEstado.setImmediate(false);
		cmbEstado.setWidth("150px");
		cmbEstado.setHeight("-1px");
		lytFiltro2.addComponent(cmbEstado);
		
		// txtExpediente
		txtExpediente = new TextField();
		txtExpediente.setImmediate(false);
		txtExpediente.setWidth("150px");
		txtExpediente.setHeight("-1px");
		lytFiltro2.addComponent(txtExpediente);
		
		// chkRequisitoria
		chkRequisitoria = new CheckBox();
		chkRequisitoria.setCaption("Requisitoria");
		chkRequisitoria.setImmediate(false);
		chkRequisitoria.setWidth("150px");
		chkRequisitoria.setHeight("-1px");
		lytFiltro2.addComponent(chkRequisitoria);
		
		// txtOrganizacion
		txtOrganizacion = new TextField();
		txtOrganizacion.setImmediate(false);
		txtOrganizacion.setWidth("150px");
		txtOrganizacion.setHeight("-1px");
		lytFiltro2.addComponent(txtOrganizacion);
		
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
		
		// cmbOcupacion
		cmbOcupacion = new ComboBox();
		cmbOcupacion.setImmediate(false);
		cmbOcupacion.setWidth("150px");
		cmbOcupacion.setHeight("-1px");
		lytFiltro3.addComponent(cmbOcupacion);
		
		// dtIntervencion
		dtIntervencion = new PopupDateField();
		dtIntervencion.setImmediate(false);
		dtIntervencion.setWidth("150px");
		dtIntervencion.setHeight("-1px");
		lytFiltro3.addComponent(dtIntervencion);
		
		// cmbSituacion
		cmbSituacion = new ComboBox();
		cmbSituacion.setImmediate(false);
		cmbSituacion.setWidth("150px");
		cmbSituacion.setHeight("-1px");
		lytFiltro3.addComponent(cmbSituacion);
		
		// txtAlias
		txtAlias = new TextField();
		txtAlias.setImmediate(false);
		txtAlias.setWidth("150px");
		txtAlias.setHeight("-1px");
		lytFiltro3.addComponent(txtAlias);
		
		// btnBuscar
		btnBuscar = new Button();
		btnBuscar.setCaption("Buscar");
		btnBuscar.setImmediate(true);
		btnBuscar.setWidth("-1px");
		btnBuscar.setHeight("-1px");
		lytFiltro3.addComponent(btnBuscar);
		
		return lytFiltro3;
	}	

}
