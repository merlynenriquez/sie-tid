package pe.gob.mininter.dirandro.vaadin.panel.documento;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.Dependencia;
import pe.gob.mininter.dirandro.model.Droga;
import pe.gob.mininter.dirandro.model.Especie;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.Hojaremision;
import pe.gob.mininter.dirandro.model.HojaremisionMuestra;
import pe.gob.mininter.dirandro.model.ModeloMarca;
import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.model.Persona;
import pe.gob.mininter.dirandro.model.Policia;
import pe.gob.mininter.dirandro.service.DependenciaService;
import pe.gob.mininter.dirandro.service.DrogaService;
import pe.gob.mininter.dirandro.service.ExpedienteEspecieService;
import pe.gob.mininter.dirandro.service.ExpedienteService;
import pe.gob.mininter.dirandro.service.HojaRemisionMuestraService;
import pe.gob.mininter.dirandro.service.HojaRemisionService;
import pe.gob.mininter.dirandro.service.ModeloMarcaService;
import pe.gob.mininter.dirandro.service.PersonaService;
import pe.gob.mininter.dirandro.service.PoliciaService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;
import pe.gob.mininter.dirandro.vaadin.dialogs.AlertDialog;
import pe.gob.mininter.dirandro.vaadin.util.ComboBoxLOVS;
import pe.gob.mininter.dirandro.vaadin.util.DirandroComponent;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.AbstractSelect.Filtering;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PanelRegistroHojaRem extends DirandroComponent implements ClickListener{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlPrincipal;
	@AutoGenerated
	private VerticalLayout pnlDetalle;
	@AutoGenerated
	private Table tblMuestras;
	@AutoGenerated
	private VerticalLayout verticalLayout_3;
	@AutoGenerated
	private Button btnAgregar;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_8;
	@AutoGenerated
	private TextField txtxPesoDevuelto;
	@AutoGenerated
	private TextField txtPesoAnalisis;
	@AutoGenerated
	private TextField txtPesoNeto;
	@AutoGenerated
	private TextField txtPesoBruto;
	@AutoGenerated
	private TextField txtCantidad;
	@AutoGenerated
	private ComboBox cmbUnidadMedida;
	@AutoGenerated
	private ComboBox cmbTipoUnidadMedida;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_9;
	@AutoGenerated
	private TextField txtDescripcion;
	@AutoGenerated
	private ComboBox cmbDroga;
	@AutoGenerated
	private ComboBox cmbEspecie;
	@AutoGenerated
	private VerticalLayout pnlHoja;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_7;
	@AutoGenerated
	private Button btnCancelar;
	@AutoGenerated
	private Button btnGrabar;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_10;
	@AutoGenerated
	private TextArea txtObservacion;
	@AutoGenerated
	private TextArea txtTraslado;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_3;
	@AutoGenerated
	private TextField txtCostoTraslado;
	@AutoGenerated
	private TextField txtLicencia;
	@AutoGenerated
	private ComboBox cmbCustodio;
	@AutoGenerated
	private ComboBox cmbConductor;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private PopupDateField dtFechaRecepcion;
	@AutoGenerated
	private PopupDateField dtFechTraslado;
	@AutoGenerated
	private PopupDateField dtFechaEmision;
	@AutoGenerated
	private TextField txtOficio;
	@AutoGenerated
	private HorizontalLayout lytDestino;
	@AutoGenerated
	private ComboBox cmbDepartamentoDestino;
	@AutoGenerated
	private ComboBox cmbDivisionDestino;
	@AutoGenerated
	private ComboBox cmbDireccionDestino;
	@AutoGenerated
	private HorizontalLayout lytOrigen;
	@AutoGenerated
	private ComboBox cmbDepartamentoOrigen;
	@AutoGenerated
	private ComboBox cmbDivisionOrigen;
	@AutoGenerated
	private ComboBox cmbDireccionOrigen;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private TextField txtPlaca;
	@AutoGenerated
	private ComboBox cmbMarca;
	@AutoGenerated
	private ComboBox cmbExpediente;
	@AutoGenerated
	private ComboBoxLOVS cmbTipoHr;
	@AutoGenerated
	private TextField txtNumero;
	private static final long serialVersionUID = -7562551645185429070L;
	
	private HojaRemisionService hojaRemisionService;
	private ModeloMarcaService modeloMarcaService;
	private DependenciaService dependenciaService;
	private PersonaService personaService;
	private PoliciaService policiaService;
	private ExpedienteService expedienteService;
	private ExpedienteEspecieService especieService;
	private DrogaService drogaService; 
	private HojaRemisionMuestraService hojaRemisionMuestraService;
	
	private List<ModeloMarca> lstMarcas;
	private List<ModeloMarca> lstTipoMedidas;
	private List<ModeloMarca> lstMedidas;
	private List<Policia> lstCustodios;
	private List<Persona> lstConductores;
	private List<Especie> lstEspecies;
	private List<Droga> lstDroga;
	private List<Expediente> lstExpedientes;
	private List<Dependencia> lstDirecciones;
	private List<Dependencia> lstOrigenDivisiones;
	private List<Dependencia> lstOrigenDepartamentos;
	private List<Dependencia> lstDestinoDivisiones;
	private List<Dependencia> lstDestinoDepartamentos;
	private Hojaremision hojaremision;
	private HojaremisionMuestra muestra;
	
	private IndexedContainer container;
	
	private final static String LIMPIAR_HOJA = "hoja";
	private final static String LIMPIAR_MUESTRA = "muestra";
	
	private static final String COLUMN_ID = "COLUMN_ID"; 
	private static final String COLUMN_PESO_BRUTO = "COLUMN_PESO_BRUTO";
	private static final String COLUMN_PESO_NETO = "COLUMN_PESO_NETO";
	private static final String COLUMN_DESCRIPCION = "COLUMN_DESCRIPCION";
	
	public PanelRegistroHojaRem(List<Opcion> acciones, String height) {
		super(acciones, height);
		buildMainLayout();
		modeloMarcaService = Injector.obtenerServicio(ModeloMarcaService.class);
		hojaRemisionService = Injector.obtenerServicio(HojaRemisionService.class);
		hojaRemisionMuestraService = Injector.obtenerServicio(HojaRemisionMuestraService.class);
		dependenciaService = Injector.obtenerServicio(DependenciaService.class);
		personaService = Injector.obtenerServicio(PersonaService.class);
		policiaService = Injector.obtenerServicio(PoliciaService.class);
		expedienteService = Injector.obtenerServicio(ExpedienteService.class);
		especieService  = Injector.obtenerServicio(ExpedienteEspecieService.class);
		drogaService  = Injector.obtenerServicio(DrogaService.class);
		policiaService = Injector.obtenerServicio(PoliciaService.class);
		setCompositionRoot(mainLayout);
		postConstruct();
		debugId();
	}
	private void debugId(){
		
	}
	
	@Override
	public void attach() {
		// TODO Auto-generated method stub
		super.attach();
		if(!hojaremision.esNuevo()){
			txtNumero.setValue(hojaremision.getNumero());
			cmbTipoHr.setValue(hojaremision.getTipoHr());
			cmbExpediente.setValue(hojaremision.getExpediente());
			cmbMarca.setValue(hojaremision.getVehiculoMarca());
			txtPlaca.setValue(hojaremision.getVehiculoPlaca());
			if(hojaremision.getOrigen()!=null){
				cmbDireccionOrigen.setValue(hojaremision.getOrigen().getPadre().getPadre());
				cmbDivisionOrigen.setValue(hojaremision.getOrigen().getPadre());
				cmbDepartamentoOrigen.setValue(hojaremision.getOrigen());
			}
			if(hojaremision.getDestino()!=null){
				cmbDireccionDestino.setValue(hojaremision.getDestino().getPadre().getPadre());
				cmbDivisionDestino.setValue(hojaremision.getDestino().getPadre());
				cmbDepartamentoDestino.setValue(hojaremision.getDestino());
			}
			txtOficio.setValue(hojaremision.getOficio());
			dtFechaEmision.setValue(hojaremision.getFechaEmision());
			dtFechTraslado.setValue(hojaremision.getFechaTraslado());
			dtFechaRecepcion.setValue(hojaremision.getFechaRecepcion());
			cmbConductor.setValue(hojaremision.getConductor());
			cmbCustodio.setValue(hojaremision.getCustodio());
			txtLicencia.setValue(hojaremision.getNroLicencia());
			txtCostoTraslado.setValue(hojaremision.getCostoTraslado());
			txtTraslado.setValue(hojaremision.getMotivoTraslado());
			txtObservacion.setValue(hojaremision.getObservacion());
			cargaPanelDetalle();
			cargarTablaMuestra();		
		}
	}
	public void postConstruct() {
		mainLayout.setStyleName("backColor");
		
		lstMarcas = modeloMarcaService.buscarHijos(new ModeloMarca(Constante.MODELO_MARCA.TRANSPORTE.AUTO));
		lstDirecciones = dependenciaService.buscarPadres();
		lstCustodios = policiaService.buscar(null);
		lstConductores = personaService.buscar(null);
		lstExpedientes = expedienteService.buscar(null);
		
		cmbTipoHr.setInputPrompt("Tipo de Hoja de Remisión");
		cmbTipoHr.setCodigoLista(Constante.LISTA.CODIGO.TIPO_HR);
		
		cmbMarca.setInputPrompt("Tipo Explosivo");
		cmbMarca.setItemCaptionPropertyId("nombre");
		cmbMarca.setContainerDataSource(new BeanItemContainer<ModeloMarca>(ModeloMarca.class,  lstMarcas));
		
		cmbExpediente.setInputPrompt("Expediente");
		cmbExpediente.setItemCaptionPropertyId("autogenerado");
		cmbExpediente.setContainerDataSource(new BeanItemContainer<Expediente>(Expediente.class, lstExpedientes));
		
		cmbConductor.setInputPrompt("Conductor");
		cmbConductor.setItemCaptionPropertyId("nombreCompleto");
		cmbConductor.setContainerDataSource(new BeanItemContainer<Persona>(Persona.class,  lstConductores));
		
		cmbCustodio.setInputPrompt("Custodio");
		cmbCustodio.setItemCaptionPropertyId("nombreCompleto");
		cmbCustodio.setContainerDataSource(new BeanItemContainer<Policia>(Policia.class,  lstCustodios));
		
		cmbDireccionOrigen.setInputPrompt("Direcciones Generales");
		cmbDireccionOrigen.setContainerDataSource( new BeanItemContainer<Dependencia>(Dependencia.class, lstDirecciones));
		cmbDireccionOrigen.setItemCaptionPropertyId("nombre");
		cmbDireccionOrigen.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
		cmbDireccionOrigen.setImmediate(true);
		cmbDireccionOrigen.addListener(new ValueChangeListener() {
			
			private static final long serialVersionUID = 7001130723844844247L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				cargarOrigenDivisionesChange(event);
			}
		});
		
		cmbDireccionDestino.setInputPrompt("Direcciones Generales");
		cmbDireccionDestino.setContainerDataSource( new BeanItemContainer<Dependencia>(Dependencia.class, lstDirecciones));
		cmbDireccionDestino.setItemCaptionPropertyId("nombre");
		cmbDireccionDestino.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
		cmbDireccionDestino.setImmediate(true);
		cmbDireccionDestino.addListener(new ValueChangeListener() {
			
			private static final long serialVersionUID = 3822620489296278368L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				cargarDestinoDivisionesChange(event);
			}
		});

		pnlDetalle.setVisible(false);
		btnAgregar.addListener(this);
		btnCancelar.setVisible(false);
		btnGrabar.addListener(this);
		refrescar();
		cargarContainer();
	}
	
	public void setHojaremision(Hojaremision hojaremision){
		this.hojaremision=hojaremision;
	}
	
	private void cargarOrigenDivisionesChange(ValueChangeEvent event){
		lstOrigenDivisiones = dependenciaService.buscarHijos((Dependencia) cmbDireccionOrigen.getValue());
		llenarComboOrigenDivision(lstOrigenDivisiones);
	}
	
	private void llenarComboOrigenDivision(List<Dependencia> lstDivisiones){		
		cmbDivisionOrigen.setContainerDataSource(new BeanItemContainer<Dependencia>(Dependencia.class, lstDivisiones));
		cmbDivisionOrigen.setItemCaptionPropertyId("nombre");
		cmbDivisionOrigen.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
		cmbDivisionOrigen.setImmediate(true);
		cmbDivisionOrigen.addListener(new ValueChangeListener() {
			
			private static final long serialVersionUID = -4721770533858762047L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				cargarOrigenDepartamentosChange(event);
			}
			
			private void cargarOrigenDepartamentosChange(ValueChangeEvent event){
				lstOrigenDepartamentos = dependenciaService.buscarHijos((Dependencia) cmbDivisionOrigen.getValue());
				cmbDepartamentoOrigen.setContainerDataSource(new BeanItemContainer<Dependencia>(Dependencia.class,  lstOrigenDepartamentos));
				cmbDepartamentoOrigen.setItemCaptionPropertyId("abreviatura");
			}
		});
	}
	
	private void cargarDestinoDivisionesChange(ValueChangeEvent event){
		lstDestinoDivisiones = dependenciaService.buscarHijos((Dependencia) cmbDireccionDestino.getValue());
		llenarComboDestinoDivision(lstDestinoDivisiones);
	}
	
	private void llenarComboDestinoDivision(List<Dependencia> lstDivisiones){		
		cmbDivisionDestino.setContainerDataSource(new BeanItemContainer<Dependencia>(Dependencia.class, lstDivisiones));
		cmbDivisionDestino.setItemCaptionPropertyId("nombre");
		cmbDivisionDestino.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
		cmbDivisionDestino.setImmediate(true);
		cmbDivisionDestino.addListener(new ValueChangeListener() {
			
			private static final long serialVersionUID = -4721770533858762047L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				cargarDestinoDepartamentosChange(event);
			}
			
			private void cargarDestinoDepartamentosChange(ValueChangeEvent event){
				lstDestinoDepartamentos = dependenciaService.buscarHijos((Dependencia) cmbDivisionDestino.getValue());
				cmbDepartamentoDestino.setContainerDataSource(new BeanItemContainer<Dependencia>(Dependencia.class,  lstDestinoDepartamentos));
				cmbDepartamentoDestino.setItemCaptionPropertyId("abreviatura");
			}
		});
	}
	
	private void cargarContainer() {
		container = new IndexedContainer();
		container.addContainerProperty(COLUMN_ID, Long.class,  null);
		container.addContainerProperty(COLUMN_PESO_BRUTO, Double.class, null);
		container.addContainerProperty(COLUMN_PESO_NETO, Double.class, null);
		container.addContainerProperty(COLUMN_DESCRIPCION, String.class, null);
		
		tblMuestras.setContainerDataSource(container);
		tblMuestras.setVisibleColumns(new Object[] {COLUMN_ID, COLUMN_PESO_BRUTO, COLUMN_PESO_NETO, COLUMN_DESCRIPCION });
		
		tblMuestras.setColumnHeader(COLUMN_PESO_BRUTO, "Peso Bruto");
		tblMuestras.setColumnHeader(COLUMN_PESO_NETO, "Peso Neto");
		tblMuestras.setColumnHeader(COLUMN_DESCRIPCION, "Descripción");
	}
	
	public void cargarTablaMuestra() {
		//expImporte.setExpediente(expediente);
		List<HojaremisionMuestra> lstMuestras = hojaRemisionMuestraService.buscar(null);
		container.removeAllItems();
		
		for (HojaremisionMuestra hrMuestra : lstMuestras) {
			Item item = container.addItem(hrMuestra.getId());
			item.getItemProperty(COLUMN_ID).setValue(hrMuestra.getId());
			item.getItemProperty(COLUMN_PESO_BRUTO).setValue(hrMuestra.getCanPesoBruto());
			item.getItemProperty(COLUMN_PESO_NETO).setValue(hrMuestra.getCanPesoNeto());
			item.getItemProperty(COLUMN_DESCRIPCION).setValue(hrMuestra.getDescripcion());
		}
	}
	
	public void refrescar(){
		//habilitarEdicion(false);
		limpiar(LIMPIAR_HOJA);
	}
	
	private void habilitarEdicion(boolean flag){
		if(flag){
			btnGrabar.setCaption("Actualizar");
		}else{
			btnGrabar.setCaption("Crear");
		}
	}

	public void limpiar(String tipo){
		
		if(tipo.equals(LIMPIAR_HOJA)){
			hojaremision = new Hojaremision();
			txtCostoTraslado.setValue("");
			txtLicencia.setValue("");
			txtNumero.setValue("");
			txtObservacion.setValue("");
			txtOficio.setValue("");
			txtPlaca.setValue("");
			txtTraslado.setValue("");
			
			cmbConductor.select(null);
			cmbCustodio.select(null);
			cmbDepartamentoDestino.select(null);
			cmbDepartamentoOrigen.select(null);
			cmbDireccionDestino.select(null);
			cmbDireccionOrigen.select(null);
			cmbDivisionDestino.select(null);
			cmbDivisionOrigen.select(null);
			
			cmbExpediente.select(null);
			cmbMarca.select(null);
			cmbTipoHr.select(null);
		}else{
			muestra = new HojaremisionMuestra();
			txtPesoAnalisis.setValue("");
			txtPesoBruto.setValue("");
			txtPesoNeto.setValue("");
			txtxPesoDevuelto.setValue("");
			txtDescripcion.setValue("");
			cmbDroga.select(null);
			cmbEspecie.select(null);
			cmbTipoUnidadMedida.select(null);
			cmbUnidadMedida.select(null);
		}
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnGrabar)){
			btnGrabarClic();
		}
		if (event.getButton().equals(btnAgregar)) {
			btnAgregaDetalleClic();
		}
	}

	private void btnGrabarClic(){
		
		hojaremision.setConductor((Persona)cmbConductor.getValue());
		hojaremision.setCostoTraslado(!StringUtils.isEmpty((String)txtCostoTraslado.getValue())? new BigDecimal((String)txtCostoTraslado.getValue()):null);
		hojaremision.setCustodio((Policia)cmbCustodio.getValue());
		hojaremision.setDestino((Dependencia)cmbDepartamentoDestino.getValue());
		hojaremision.setExpediente((Expediente)cmbExpediente.getValue());
		hojaremision.setFechaEmision((Date)dtFechaEmision.getValue());
		hojaremision.setFechaRecepcion((Date)dtFechaRecepcion.getValue());
		hojaremision.setFechaTraslado((Date)dtFechTraslado.getValue());
		hojaremision.setMotivoTraslado(HarecUtil.nullToEmpty(txtTraslado.getValue()));
		hojaremision.setNroLicencia(HarecUtil.nullToEmpty(txtLicencia.getValue()));
		hojaremision.setNumero(HarecUtil.nullToEmpty(txtNumero.getValue()));
		hojaremision.setObservacion(HarecUtil.nullToEmpty(txtObservacion.getValue()));
		hojaremision.setOficio(HarecUtil.nullToEmpty(txtOficio.getValue()));
		hojaremision.setOrigen((Dependencia)cmbDepartamentoOrigen.getValue());
		hojaremision.setTipoHr(cmbTipoHr.getValor());
		hojaremision.setVehiculoMarca((ModeloMarca)cmbMarca.getValue());
		hojaremision.setVehiculoPlaca(HarecUtil.nullToEmpty(txtPlaca.getValue()));
		
		if(hojaremision.esNuevo()){
			hojaRemisionService.crear(hojaremision);
			cargaPanelDetalle();
		}else{
			hojaRemisionService.actualizar(hojaremision);
		}
	
		AlertDialog alertDialog = new  AlertDialog("Registro de Hoja de Remisión", "Se ha registrado la Hoja de Remisión correctamente", "Aceptar", "400");
		getApplication().getMainWindow().addWindow(alertDialog);
	
	}
	
	private void cargaPanelDetalle(){

		pnlDetalle.setVisible(true);
		
		if(hojaremision.getExpediente()!=null){
			
			Especie e = new Especie();
			e.setExpediente(hojaremision.getExpediente());
			
			lstDestinoDepartamentos = dependenciaService.buscarHijos((Dependencia) cmbDivisionDestino.getValue());
			lstDroga = drogaService.obtenerDrogasExpediente(hojaremision.getExpediente());
			lstEspecies = especieService.buscar(e);
			lstTipoMedidas = modeloMarcaService.buscarHijos(new ModeloMarca(Constante.MODELO_MARCA.MEDIDA.COD_MEDIDA));
			
			cmbEspecie.setInputPrompt("Especies del Expediente");
			cmbEspecie.setItemCaptionPropertyId("nombre");
			cmbEspecie.setContainerDataSource(new BeanItemContainer<Especie>(Especie.class,  lstEspecies));
			
			cmbDroga.setInputPrompt("Droga del Expediente");
			cmbDroga.setItemCaptionPropertyId("datos");
			cmbDroga.setContainerDataSource(new BeanItemContainer<Droga>(Droga.class,  lstDroga));
			
			cmbTipoUnidadMedida.setInputPrompt("Tipo Unidad de Medida");
			cmbTipoUnidadMedida.setItemCaptionPropertyId("nombre");
			cmbTipoUnidadMedida.setContainerDataSource(new BeanItemContainer<ModeloMarca>(ModeloMarca.class,  lstTipoMedidas));
			cmbTipoUnidadMedida.setImmediate(true);
			cmbTipoUnidadMedida.addListener(new Property.ValueChangeListener() {            
				private static final long serialVersionUID = 1L;
				@Override
	            public void valueChange(ValueChangeEvent event) {				 
					lstMedidas = modeloMarcaService.buscarHijos((ModeloMarca)cmbTipoUnidadMedida.getValue());
					cmbUnidadMedida.setContainerDataSource(new BeanItemContainer<ModeloMarca>(ModeloMarca.class,lstMedidas));
	            }
	        });
			
			cmbUnidadMedida.setInputPrompt("Unidad de Medida");
			cmbUnidadMedida.setItemCaptionPropertyId("nombre");
			
		}
	}
	
	public void btnAgregaDetalleClic(){
		muestra = new HojaremisionMuestra();
		muestra.setCanPesoAnalisis(txtPesoAnalisis.getValue() != null ? Double.parseDouble(txtPesoAnalisis.getValue().toString()) : null);
		muestra.setCanPesoBruto(txtPesoBruto.getValue() != null ? Double.valueOf(txtPesoBruto.getValue().toString()) : null);
		muestra.setCanPesoDevuelto(txtxPesoDevuelto.getValue() != null ? Double.valueOf(txtxPesoDevuelto.getValue().toString()) : null);
		muestra.setCanPesoNeto(txtPesoNeto.getValue() != null ? Double.valueOf(txtPesoNeto.getValue().toString()) : null);
		muestra.setCantidad(txtCantidad.getValue() != null ? Integer.parseInt(txtCantidad.getValue().toString()) : null);
		muestra.setDescripcion(HarecUtil.nullToEmpty(txtDescripcion.getValue()));
		muestra.setDroga((Droga)cmbDroga.getValue());
		muestra.setEspecie((Especie)cmbEspecie.getValue());
		muestra.setTipoMedida((ModeloMarca) cmbUnidadMedida.getValue());
		muestra.setHojaRemision(hojaremision);
		hojaRemisionMuestraService.crear(muestra);
		cargarTablaMuestra();
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
	private VerticalLayout buildPnlPrincipal() {
		// common part: create layout
		pnlPrincipal = new VerticalLayout();
		pnlPrincipal.setStyleName("whiteBackGround");
		pnlPrincipal.setImmediate(false);
		pnlPrincipal.setWidth("-1px");
		pnlPrincipal.setHeight("-1px");
		pnlPrincipal.setMargin(false);
		pnlPrincipal.setSpacing(true);
		
		// pnlHoja
		pnlHoja = buildPnlHoja();
		pnlPrincipal.addComponent(pnlHoja);
		
		// pnlDetalle
		pnlDetalle = buildPnlDetalle();
		pnlPrincipal.addComponent(pnlDetalle);
		
		return pnlPrincipal;
	}
	@AutoGenerated
	private VerticalLayout buildPnlHoja() {
		// common part: create layout
		pnlHoja = new VerticalLayout();
		pnlHoja.setImmediate(false);
		pnlHoja.setWidth("950px");
		pnlHoja.setHeight("-1px");
		pnlHoja.setMargin(true);
		pnlHoja.setSpacing(true);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		pnlHoja.addComponent(horizontalLayout_1);
		
		// lytOrigen
		lytOrigen = buildLytOrigen();
		pnlHoja.addComponent(lytOrigen);
		
		// lytDestino
		lytDestino = buildLytDestino();
		pnlHoja.addComponent(lytDestino);
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		pnlHoja.addComponent(horizontalLayout_2);
		
		// horizontalLayout_3
		horizontalLayout_3 = buildHorizontalLayout_3();
		pnlHoja.addComponent(horizontalLayout_3);
		
		// horizontalLayout_10
		horizontalLayout_10 = buildHorizontalLayout_10();
		pnlHoja.addComponent(horizontalLayout_10);
		
		// horizontalLayout_7
		horizontalLayout_7 = buildHorizontalLayout_7();
		pnlHoja.addComponent(horizontalLayout_7);
		pnlHoja.setComponentAlignment(horizontalLayout_7, new Alignment(20));
		
		return pnlHoja;
	}
	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("-1px");
		horizontalLayout_1.setHeight("-1px");
		horizontalLayout_1.setMargin(false);
		horizontalLayout_1.setSpacing(true);
		
		// txtNumero
		txtNumero = new TextField();
		txtNumero.setCaption("Número");
		txtNumero.setImmediate(false);
		txtNumero.setWidth("120px");
		txtNumero.setHeight("-1px");
		txtNumero.setRequired(true);
		txtNumero.setInputPrompt("Número");
		txtNumero.setMaxLength(50);
		horizontalLayout_1.addComponent(txtNumero);
		
		// cmbTipoHr
		cmbTipoHr = new ComboBoxLOVS();
		cmbTipoHr.setCaption("Tipo");
		cmbTipoHr.setImmediate(false);
		cmbTipoHr.setWidth("150px");
		cmbTipoHr.setHeight("-1px");
		horizontalLayout_1.addComponent(cmbTipoHr);
		
		// cmbExpediente
		cmbExpediente = new ComboBox();
		cmbExpediente.setCaption("Expediente");
		cmbExpediente.setImmediate(false);
		cmbExpediente.setWidth("150px");
		cmbExpediente.setHeight("-1px");
		cmbExpediente.setRequired(true);
		horizontalLayout_1.addComponent(cmbExpediente);
		
		// cmbMarca
		cmbMarca = new ComboBox();
		cmbMarca.setCaption("Marca");
		cmbMarca.setImmediate(false);
		cmbMarca.setWidth("180px");
		cmbMarca.setHeight("-1px");
		horizontalLayout_1.addComponent(cmbMarca);
		
		// txtPlaca
		txtPlaca = new TextField();
		txtPlaca.setCaption("Vehículo placa");
		txtPlaca.setImmediate(false);
		txtPlaca.setWidth("150px");
		txtPlaca.setHeight("-1px");
		txtPlaca.setRequired(true);
		txtPlaca.setInputPrompt("Vehículo placa");
		txtPlaca.setMaxLength(50);
		horizontalLayout_1.addComponent(txtPlaca);
		
		return horizontalLayout_1;
	}
	@AutoGenerated
	private HorizontalLayout buildLytOrigen() {
		// common part: create layout
		lytOrigen = new HorizontalLayout();
		lytOrigen.setImmediate(false);
		lytOrigen.setWidth("-1px");
		lytOrigen.setHeight("-1px");
		lytOrigen.setMargin(false);
		lytOrigen.setSpacing(true);
		
		// cmbDireccionOrigen
		cmbDireccionOrigen = new ComboBox();
		cmbDireccionOrigen.setCaption("Direccion Origen");
		cmbDireccionOrigen.setImmediate(false);
		cmbDireccionOrigen.setWidth("250px");
		cmbDireccionOrigen.setHeight("-1px");
		cmbDireccionOrigen.setRequired(true);
		lytOrigen.addComponent(cmbDireccionOrigen);
		
		// cmbDivisionOrigen
		cmbDivisionOrigen = new ComboBox();
		cmbDivisionOrigen.setCaption("División");
		cmbDivisionOrigen.setImmediate(false);
		cmbDivisionOrigen.setWidth("300px");
		cmbDivisionOrigen.setHeight("-1px");
		cmbDivisionOrigen.setRequired(true);
		lytOrigen.addComponent(cmbDivisionOrigen);
		
		// cmbDepartamentoOrigen
		cmbDepartamentoOrigen = new ComboBox();
		cmbDepartamentoOrigen.setCaption("Departamento");
		cmbDepartamentoOrigen.setImmediate(false);
		cmbDepartamentoOrigen.setWidth("250px");
		cmbDepartamentoOrigen.setHeight("-1px");
		cmbDepartamentoOrigen.setRequired(true);
		lytOrigen.addComponent(cmbDepartamentoOrigen);
		
		return lytOrigen;
	}
	@AutoGenerated
	private HorizontalLayout buildLytDestino() {
		// common part: create layout
		lytDestino = new HorizontalLayout();
		lytDestino.setImmediate(false);
		lytDestino.setWidth("-1px");
		lytDestino.setHeight("-1px");
		lytDestino.setMargin(false);
		lytDestino.setSpacing(true);
		
		// cmbDireccionDestino
		cmbDireccionDestino = new ComboBox();
		cmbDireccionDestino.setCaption("Dirección Destino");
		cmbDireccionDestino.setImmediate(false);
		cmbDireccionDestino.setWidth("250px");
		cmbDireccionDestino.setHeight("-1px");
		cmbDireccionDestino.setRequired(true);
		lytDestino.addComponent(cmbDireccionDestino);
		
		// cmbDivisionDestino
		cmbDivisionDestino = new ComboBox();
		cmbDivisionDestino.setCaption("División");
		cmbDivisionDestino.setImmediate(false);
		cmbDivisionDestino.setWidth("300px");
		cmbDivisionDestino.setHeight("-1px");
		cmbDivisionDestino.setRequired(true);
		lytDestino.addComponent(cmbDivisionDestino);
		
		// cmbDepartamentoDestino
		cmbDepartamentoDestino = new ComboBox();
		cmbDepartamentoDestino.setCaption("Departamento");
		cmbDepartamentoDestino.setImmediate(false);
		cmbDepartamentoDestino.setWidth("250px");
		cmbDepartamentoDestino.setHeight("-1px");
		cmbDepartamentoDestino.setRequired(true);
		lytDestino.addComponent(cmbDepartamentoDestino);
		
		return lytDestino;
	}
	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_2() {
		// common part: create layout
		horizontalLayout_2 = new HorizontalLayout();
		horizontalLayout_2.setImmediate(false);
		horizontalLayout_2.setWidth("-1px");
		horizontalLayout_2.setHeight("-1px");
		horizontalLayout_2.setMargin(false);
		horizontalLayout_2.setSpacing(true);
		
		// txtOficio
		txtOficio = new TextField();
		txtOficio.setCaption("Oficio");
		txtOficio.setImmediate(false);
		txtOficio.setWidth("350px");
		txtOficio.setHeight("-1px");
		txtOficio.setInputPrompt("Oficio");
		txtOficio.setMaxLength(200);
		horizontalLayout_2.addComponent(txtOficio);
		
		// dtFechaEmision
		dtFechaEmision = new PopupDateField();
		dtFechaEmision.setCaption("Fecha Emisión");
		dtFechaEmision.setImmediate(false);
		dtFechaEmision.setWidth("150px");
		dtFechaEmision.setHeight("-1px");
		dtFechaEmision.setRequired(true);
		dtFechaEmision.setResolution(4);
		horizontalLayout_2.addComponent(dtFechaEmision);
		
		// dtFechTraslado
		dtFechTraslado = new PopupDateField();
		dtFechTraslado.setCaption("Fecha Traslado");
		dtFechTraslado.setImmediate(false);
		dtFechTraslado.setWidth("150px");
		dtFechTraslado.setHeight("-1px");
		dtFechTraslado.setResolution(4);
		horizontalLayout_2.addComponent(dtFechTraslado);
		
		// dtFechaRecepcion
		dtFechaRecepcion = new PopupDateField();
		dtFechaRecepcion.setCaption("Fecha Recepción");
		dtFechaRecepcion.setImmediate(false);
		dtFechaRecepcion.setWidth("150px");
		dtFechaRecepcion.setHeight("-1px");
		dtFechaRecepcion.setResolution(4);
		horizontalLayout_2.addComponent(dtFechaRecepcion);
		
		return horizontalLayout_2;
	}
	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_3() {
		// common part: create layout
		horizontalLayout_3 = new HorizontalLayout();
		horizontalLayout_3.setImmediate(false);
		horizontalLayout_3.setWidth("-1px");
		horizontalLayout_3.setHeight("-1px");
		horizontalLayout_3.setMargin(false);
		horizontalLayout_3.setSpacing(true);
		
		// cmbConductor
		cmbConductor = new ComboBox();
		cmbConductor.setCaption("Conductor");
		cmbConductor.setImmediate(false);
		cmbConductor.setWidth("300px");
		cmbConductor.setHeight("-1px");
		cmbConductor.setRequired(true);
		horizontalLayout_3.addComponent(cmbConductor);
		
		// cmbCustodio
		cmbCustodio = new ComboBox();
		cmbCustodio.setCaption("Custodio");
		cmbCustodio.setImmediate(false);
		cmbCustodio.setWidth("220px");
		cmbCustodio.setHeight("-1px");
		cmbCustodio.setRequired(true);
		horizontalLayout_3.addComponent(cmbCustodio);
		
		// txtLicencia
		txtLicencia = new TextField();
		txtLicencia.setCaption("Licencia");
		txtLicencia.setImmediate(false);
		txtLicencia.setWidth("150px");
		txtLicencia.setHeight("-1px");
		txtLicencia.setRequired(true);
		txtLicencia.setInputPrompt("Licencia");
		txtLicencia.setMaxLength(50);
		horizontalLayout_3.addComponent(txtLicencia);
		
		// txtCostoTraslado
		txtCostoTraslado = new TextField();
		txtCostoTraslado.setCaption("Costo Traslado");
		txtCostoTraslado.setImmediate(false);
		txtCostoTraslado.setWidth("150px");
		txtCostoTraslado.setHeight("-1px");
		txtCostoTraslado.setInputPrompt("Costo Traslado");
		horizontalLayout_3.addComponent(txtCostoTraslado);
		
		return horizontalLayout_3;
	}
	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_10() {
		// common part: create layout
		horizontalLayout_10 = new HorizontalLayout();
		horizontalLayout_10.setImmediate(false);
		horizontalLayout_10.setWidth("-1px");
		horizontalLayout_10.setHeight("-1px");
		horizontalLayout_10.setMargin(false);
		horizontalLayout_10.setSpacing(true);
		
		// txtTraslado
		txtTraslado = new TextArea();
		txtTraslado.setCaption("Motivo Traslado");
		txtTraslado.setImmediate(false);
		txtTraslado.setWidth("420px");
		txtTraslado.setHeight("60px");
		txtTraslado.setRequired(true);
		txtTraslado.setInputPrompt("Motivo Traslado");
		txtTraslado.setMaxLength(400);
		horizontalLayout_10.addComponent(txtTraslado);
		
		// txtObservacion
		txtObservacion = new TextArea();
		txtObservacion.setCaption("Observación");
		txtObservacion.setImmediate(false);
		txtObservacion.setWidth("420px");
		txtObservacion.setHeight("60px");
		txtObservacion.setInputPrompt("Observación");
		txtObservacion.setMaxLength(200);
		horizontalLayout_10.addComponent(txtObservacion);
		
		return horizontalLayout_10;
	}
	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_7() {
		// common part: create layout
		horizontalLayout_7 = new HorizontalLayout();
		horizontalLayout_7.setImmediate(false);
		horizontalLayout_7.setWidth("199px");
		horizontalLayout_7.setHeight("-1px");
		horizontalLayout_7.setMargin(false);
		horizontalLayout_7.setSpacing(true);
		
		// btnGrabar
		btnGrabar = new Button();
		btnGrabar.setCaption("Grabar");
		btnGrabar.setImmediate(true);
		btnGrabar.setWidth("-1px");
		btnGrabar.setHeight("-1px");
		horizontalLayout_7.addComponent(btnGrabar);
		
		// btnCancelar
		btnCancelar = new Button();
		btnCancelar.setCaption("Cancelar");
		btnCancelar.setImmediate(true);
		btnCancelar.setWidth("74px");
		btnCancelar.setHeight("-1px");
		horizontalLayout_7.addComponent(btnCancelar);
		
		return horizontalLayout_7;
	}
	@AutoGenerated
	private VerticalLayout buildPnlDetalle() {
		// common part: create layout
		pnlDetalle = new VerticalLayout();
		pnlDetalle.setImmediate(false);
		pnlDetalle.setWidth("950px");
		pnlDetalle.setHeight("-1px");
		pnlDetalle.setMargin(false);
		
		// verticalLayout_3
		verticalLayout_3 = buildVerticalLayout_3();
		pnlDetalle.addComponent(verticalLayout_3);
		
		// tblMuestras
		tblMuestras = new Table();
		tblMuestras.setImmediate(false);
		tblMuestras.setWidth("900px");
		tblMuestras.setHeight("200px");
		pnlDetalle.addComponent(tblMuestras);
		
		return pnlDetalle;
	}
	@AutoGenerated
	private VerticalLayout buildVerticalLayout_3() {
		// common part: create layout
		verticalLayout_3 = new VerticalLayout();
		verticalLayout_3.setImmediate(false);
		verticalLayout_3.setWidth("-1px");
		verticalLayout_3.setHeight("-1px");
		verticalLayout_3.setMargin(true);
		verticalLayout_3.setSpacing(true);
		
		// horizontalLayout_9
		horizontalLayout_9 = buildHorizontalLayout_9();
		verticalLayout_3.addComponent(horizontalLayout_9);
		
		// horizontalLayout_8
		horizontalLayout_8 = buildHorizontalLayout_8();
		verticalLayout_3.addComponent(horizontalLayout_8);
		
		// btnAgregar
		btnAgregar = new Button();
		btnAgregar.setCaption("Agregar");
		btnAgregar.setImmediate(true);
		btnAgregar.setWidth("-1px");
		btnAgregar.setHeight("-1px");
		verticalLayout_3.addComponent(btnAgregar);
		verticalLayout_3.setComponentAlignment(btnAgregar, new Alignment(20));
		
		return verticalLayout_3;
	}
	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_9() {
		// common part: create layout
		horizontalLayout_9 = new HorizontalLayout();
		horizontalLayout_9.setImmediate(false);
		horizontalLayout_9.setWidth("-1px");
		horizontalLayout_9.setHeight("-1px");
		horizontalLayout_9.setMargin(false);
		horizontalLayout_9.setSpacing(true);
		
		// cmbEspecie
		cmbEspecie = new ComboBox();
		cmbEspecie.setCaption("Especie");
		cmbEspecie.setImmediate(false);
		cmbEspecie.setWidth("200px");
		cmbEspecie.setHeight("-1px");
		cmbEspecie.setRequired(true);
		horizontalLayout_9.addComponent(cmbEspecie);
		
		// cmbDroga
		cmbDroga = new ComboBox();
		cmbDroga.setCaption("Droga");
		cmbDroga.setImmediate(false);
		cmbDroga.setWidth("200px");
		cmbDroga.setHeight("-1px");
		horizontalLayout_9.addComponent(cmbDroga);
		
		// txtDescripcion
		txtDescripcion = new TextField();
		txtDescripcion.setCaption("Descripción");
		txtDescripcion.setImmediate(false);
		txtDescripcion.setWidth("400px");
		txtDescripcion.setHeight("-1px");
		txtDescripcion.setRequired(true);
		txtDescripcion.setInputPrompt("Descripción");
		horizontalLayout_9.addComponent(txtDescripcion);
		
		return horizontalLayout_9;
	}
	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_8() {
		// common part: create layout
		horizontalLayout_8 = new HorizontalLayout();
		horizontalLayout_8.setImmediate(false);
		horizontalLayout_8.setWidth("-1px");
		horizontalLayout_8.setHeight("-1px");
		horizontalLayout_8.setMargin(false);
		horizontalLayout_8.setSpacing(true);
		
		// cmbTipoUnidadMedida
		cmbTipoUnidadMedida = new ComboBox();
		cmbTipoUnidadMedida.setCaption("Tipo de Unidad de Medida");
		cmbTipoUnidadMedida.setImmediate(false);
		cmbTipoUnidadMedida.setWidth("130px");
		cmbTipoUnidadMedida.setHeight("-1px");
		horizontalLayout_8.addComponent(cmbTipoUnidadMedida);
		
		// cmbUnidadMedida
		cmbUnidadMedida = new ComboBox();
		cmbUnidadMedida.setCaption("Unidad de medida");
		cmbUnidadMedida.setImmediate(false);
		cmbUnidadMedida.setWidth("120px");
		cmbUnidadMedida.setHeight("-1px");
		horizontalLayout_8.addComponent(cmbUnidadMedida);
		
		// txtCantidad
		txtCantidad = new TextField();
		txtCantidad.setCaption("Cantidad");
		txtCantidad.setImmediate(false);
		txtCantidad.setWidth("80px");
		txtCantidad.setHeight("-1px");
		txtCantidad.setInputPrompt("Cantidad");
		horizontalLayout_8.addComponent(txtCantidad);
		
		// txtPesoBruto
		txtPesoBruto = new TextField();
		txtPesoBruto.setCaption("Cantidad peso bruto");
		txtPesoBruto.setImmediate(false);
		txtPesoBruto.setWidth("120px");
		txtPesoBruto.setHeight("-1px");
		txtPesoBruto.setInputPrompt("Peso bruto");
		horizontalLayout_8.addComponent(txtPesoBruto);
		
		// txtPesoNeto
		txtPesoNeto = new TextField();
		txtPesoNeto.setCaption("Cantidad peso neto");
		txtPesoNeto.setImmediate(false);
		txtPesoNeto.setWidth("120px");
		txtPesoNeto.setHeight("-1px");
		txtPesoNeto.setInputPrompt("Peso neto");
		horizontalLayout_8.addComponent(txtPesoNeto);
		
		// txtPesoAnalisis
		txtPesoAnalisis = new TextField();
		txtPesoAnalisis.setCaption("Cantidad peso analisis");
		txtPesoAnalisis.setImmediate(false);
		txtPesoAnalisis.setWidth("135px");
		txtPesoAnalisis.setHeight("-1px");
		txtPesoAnalisis.setInputPrompt("Peso analisis");
		horizontalLayout_8.addComponent(txtPesoAnalisis);
		
		// txtxPesoDevuelto
		txtxPesoDevuelto = new TextField();
		txtxPesoDevuelto.setCaption("Cantidad peso devuelto");
		txtxPesoDevuelto.setImmediate(false);
		txtxPesoDevuelto.setWidth("130px");
		txtxPesoDevuelto.setHeight("-1px");
		txtxPesoDevuelto.setInputPrompt("Peso devuleto");
		horizontalLayout_8.addComponent(txtxPesoDevuelto);
		
		return horizontalLayout_8;
	}




}
