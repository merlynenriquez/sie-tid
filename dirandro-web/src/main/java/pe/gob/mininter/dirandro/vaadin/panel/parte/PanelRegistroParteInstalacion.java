package pe.gob.mininter.dirandro.vaadin.panel.parte;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.CentroPoblado;
import pe.gob.mininter.dirandro.model.Distrito;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.Instalacion;
import pe.gob.mininter.dirandro.model.Organizacion;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.CentroPobladoService;
import pe.gob.mininter.dirandro.service.InstalacionService;
import pe.gob.mininter.dirandro.service.OrganizacionService;
import pe.gob.mininter.dirandro.service.UbigeoService;
import pe.gob.mininter.dirandro.util.BeanValidar;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;
import pe.gob.mininter.dirandro.vaadin.dialogs.AlertDialog;
import pe.gob.mininter.dirandro.vaadin.util.ComboBoxLOVS;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
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
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PanelRegistroParteInstalacion extends CustomComponent implements ClickListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	
	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlInstalaciones;
	@AutoGenerated
	private VerticalLayout verticalLayout_9;
	@AutoGenerated
	private Table tblInstalaciones;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private Button btnGrabar;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private TextArea txtDescripcion;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_30;
	@AutoGenerated
	private TextField txtRadio;
	@AutoGenerated
	private TextField txtAncho;
	@AutoGenerated
	private TextField txtAlto;
	@AutoGenerated
	private TextField txtLargo;
	@AutoGenerated
	private TextField txtLatitud;
	@AutoGenerated
	private TextField txtLongitud;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_29;
	@AutoGenerated
	private TextField txtZonaProduccion;
	@AutoGenerated
	private ComboBox cmbUbicacion;
	@AutoGenerated
	private ComboBoxLOVS cmbSituacion;
	@AutoGenerated
	private ComboBox cmbCentroPoblado;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_28;
	@AutoGenerated
	private TextField txtNombre;
	@AutoGenerated
	private ComboBox cmbOrganizacion;
	@AutoGenerated
	private ComboBoxLOVS cmbTipoInstalacion;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */

	private static final long serialVersionUID = -4639683924066371051L;

	private Instalacion instalacion;
	private Expediente expediente;
	
	private InstalacionService instalacionService;
	private CentroPobladoService centroPobladoService;
	private OrganizacionService organizacionService;
	private UbigeoService ubigeoService;
	
	private List<Distrito> lstDistrito;
	private List<CentroPoblado> centroPoblados;
	private List<Organizacion> lOrganizaciones;
	private boolean inicializado=false;
	
	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
		postConstruct();
	}

	public PanelRegistroParteInstalacion() {
		buildMainLayout();
		ubigeoService = Injector.obtenerServicio(UbigeoService.class );
		centroPobladoService = Injector.obtenerServicio(CentroPobladoService.class);
		instalacionService =  Injector.obtenerServicio(InstalacionService.class);
		organizacionService = Injector.obtenerServicio(OrganizacionService.class);
		setCompositionRoot(mainLayout);
		postConstruct();
	}
	
	public void postConstruct() {
		if(expediente!=null && !expediente.esNuevo() && !inicializado){
			
			cmbTipoInstalacion.setInputPrompt("Tipo Instalacion");
			cmbTipoInstalacion.setRequired(true);
			cmbTipoInstalacion.setCodigoLista(Constante.LISTA.CODIGO.TIPO_INSTALACION);
			cmbTipoInstalacion.attach();
			
			cmbSituacion.setInputPrompt("Situacion");
			cmbSituacion.setRequired(true);
			cmbSituacion.setCodigoLista(Constante.LISTA.CODIGO.SITUACION_GENERAL);
			cmbSituacion.attach();
			
			lOrganizaciones = organizacionService.listarOrganizaciones();
			cmbOrganizacion.setInputPrompt("Organizaciones Delictivas");
			cmbOrganizacion.setItemCaptionPropertyId("nombre");
			cmbOrganizacion.setContainerDataSource(new BeanItemContainer<Organizacion>(Organizacion.class,  lOrganizaciones));
			
			centroPoblados = centroPobladoService.buscar( new CentroPoblado());
			cmbCentroPoblado.setInputPrompt("Centro Poblado");
			cmbCentroPoblado.setItemCaptionPropertyId("nombre");
			cmbCentroPoblado.setContainerDataSource(new BeanItemContainer<CentroPoblado>(CentroPoblado.class,  centroPoblados));
			
			lstDistrito = ubigeoService.obtenerTodos();
			cmbUbicacion.setInputPrompt("Distrito - Provincia - Departamento");
			cmbUbicacion.setItemCaptionPropertyId("nombreCompleto");
			cmbUbicacion.setContainerDataSource(new BeanItemContainer<Distrito>(Distrito.class,  lstDistrito));
			cmbUbicacion.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
			
			tblInstalaciones.setSelectable(true);
			tblInstalaciones.setImmediate(true);
			tblInstalaciones.setNullSelectionAllowed(true);
			tblInstalaciones.setNullSelectionItemId(null);
			tblInstalaciones.addListener(new ValueChangeListener() {
				
				private static final long serialVersionUID = 7962790507398071986L;
	
				@Override
				public void valueChange(ValueChangeEvent event) {
					boolean esModoNuevo = tblInstalaciones.getValue() == null;
					limpiar();
					if(esModoNuevo){
						tblInstalaciones.setValue(null);
						habilitarEdicion(false);
					}else{
						habilitarEdicion(true);
						Item item = tblInstalaciones.getItem(tblInstalaciones.getValue());
						instalacion.setId((Long) item.getItemProperty("id").getValue());
						
						txtAlto.setValue(HarecUtil.nullToEmpty(item.getItemProperty("alto").getValue()));
						txtAncho.setValue(HarecUtil.nullToEmpty(item.getItemProperty("ancho").getValue()));
						txtLargo.setValue(HarecUtil.nullToEmpty(item.getItemProperty("largo").getValue()));
						txtLatitud.setValue(HarecUtil.nullToEmpty(item.getItemProperty("latitud").getValue()));
						txtLongitud.setValue(HarecUtil.nullToEmpty(item.getItemProperty("longitud").getValue()));
						txtNombre.setValue(HarecUtil.nullToEmpty(item.getItemProperty("nombre").getValue()));
						txtRadio.setValue(HarecUtil.nullToEmpty(item.getItemProperty("radio").getValue()));
						txtZonaProduccion.setValue(HarecUtil.nullToEmpty(item.getItemProperty("zonaProduccion").getValue()));
						txtDescripcion.setValue(HarecUtil.nullToEmpty(item.getItemProperty("descripcion").getValue()));
						
						cmbTipoInstalacion.select(new Valor((Long)item.getItemProperty("tipo.id").getValue()));
						cmbSituacion.select(new Valor((Long)item.getItemProperty("situacion.id").getValue()));
						
						for (CentroPoblado cp: centroPoblados) {
							if (cp.getId().equals((Long) item.getItemProperty("cp.id").getValue())) {
								cmbCentroPoblado.select(cp);
								break;
							}
						}
						for (Distrito dis: lstDistrito) {
							if (dis.getId().equals((Long) item.getItemProperty("ubicacion.id").getValue())) {
								cmbUbicacion.select(dis);
								break;
							}
						}
						for (Organizacion org: lOrganizaciones) {
							if (org.getId().equals((Long) item.getItemProperty("organizacion.id").getValue())) {
								cmbOrganizacion.select(org);
								break;
							}
						}
					}
				}
			});	
			
			btnGrabar.addListener((ClickListener)this);
			refrescar();
			inicializado=true;
		}
	}
	
	private void cargarTablaInstalaciones( ){
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("id", Long.class,  null);
		container.addContainerProperty("tipo.id", Long.class, null);
		container.addContainerProperty("tipo.nombre", String.class, null);
		container.addContainerProperty("organizacion.id", Long.class, null);
		container.addContainerProperty("organizacion.nombre", String.class, null);
		container.addContainerProperty("nombre", String.class, null);
		container.addContainerProperty("descripcion", String.class, null);
		container.addContainerProperty("cp.id", Long.class, null);
		container.addContainerProperty("cp.nombre", String.class, null);
		container.addContainerProperty("situacion.id", Long.class, null);
		container.addContainerProperty("situacion.nombre", String.class, null);
		container.addContainerProperty("latitud", String.class, null);
		container.addContainerProperty("longitud", String.class, null);
		container.addContainerProperty("alto", String.class, null);
		container.addContainerProperty("ancho", String.class, null);
		container.addContainerProperty("largo", String.class, null);
		container.addContainerProperty("ubicacion.id", Long.class, null);
		container.addContainerProperty("ubicacion.nombre", String.class, null);
		container.addContainerProperty("zonaProduccion", String.class, null);
		container.addContainerProperty("radio", String.class, null);
		
		tblInstalaciones.setContainerDataSource(container);
		tblInstalaciones.setVisibleColumns(new Object[]{"tipo.nombre", "nombre", "organizacion.nombre","zonaProduccion"});
				
		tblInstalaciones.setColumnHeader("tipo.nombre", "Tipo de Instalacion");
		tblInstalaciones.setColumnHeader("nombre", "Instalacion");
		tblInstalaciones.setColumnHeader("organizacion.nombre", "Organizacion");
		tblInstalaciones.setColumnHeader("zonaProduccion", "Zona de Produccion");
		
		List<Instalacion> lstInstalaciones = instalacionService.buscar(instalacion);
		int con=1;
		for (Instalacion instalacion : lstInstalaciones){
			Item item = container.addItem(con++);
			item.getItemProperty("id").setValue(instalacion.getId());
			
			item.getItemProperty("organizacion.id").setValue(instalacion.getOrganizacionDelictiva()!=null?instalacion.getOrganizacionDelictiva().getId():null);
			item.getItemProperty("organizacion.nombre").setValue(instalacion.getOrganizacionDelictiva()!=null?instalacion.getOrganizacionDelictiva().getNombre():StringUtils.EMPTY);
			item.getItemProperty("cp.id").setValue(instalacion.getExpCentroPoblado()!=null?instalacion.getExpCentroPoblado().getId():null);
			item.getItemProperty("cp.nombre").setValue(instalacion.getExpCentroPoblado()!=null?instalacion.getExpCentroPoblado().getNombre():StringUtils.EMPTY);
			
			item.getItemProperty("tipo.id").setValue(HarecUtil.valorIdToEmpty(instalacion.getTipo()));
			item.getItemProperty("tipo.nombre").setValue(HarecUtil.valorNombreToEmpty(instalacion.getTipo()));
			item.getItemProperty("situacion.id").setValue(HarecUtil.valorIdToEmpty(instalacion.getSituacion()));
			item.getItemProperty("situacion.nombre").setValue(HarecUtil.valorNombreToEmpty(instalacion.getSituacion()));
			
			item.getItemProperty("ubicacion.id").setValue(instalacion.getDistrito()!=null?instalacion.getDistrito().getId():null);
			item.getItemProperty("ubicacion.nombre").setValue(instalacion.getDistrito()!=null?instalacion.getDistrito().getNombre():StringUtils.EMPTY);
			item.getItemProperty("nombre").setValue(instalacion.getNombre());
			item.getItemProperty("descripcion").setValue(instalacion.getDescripcion());
			item.getItemProperty("latitud").setValue(instalacion.getLatitud());
			item.getItemProperty("longitud").setValue(instalacion.getLongitud());
			item.getItemProperty("alto").setValue(instalacion.getAlturaMt());
			item.getItemProperty("ancho").setValue(instalacion.getAlturaMt());
			item.getItemProperty("largo").setValue(instalacion.getLargoMt());
			item.getItemProperty("radio").setValue(instalacion.getRadio());
			item.getItemProperty("zonaProduccion").setValue(HarecUtil.nullToEmpty(instalacion.getZonaProduccion()));
			
		}
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		
		if(event.getButton().equals( btnGrabar )) {
			buttonClickGrabar();
		}
	}

	public void buttonClickGrabar(){

		instalacion.setExpediente(expediente);
		
		instalacion.setAlturaMt(HarecUtil.toBigDecimal(txtAlto.getValue()));
		instalacion.setAnchoMt(HarecUtil.toBigDecimal(txtAncho.getValue()));
		instalacion.setLargoMt(HarecUtil.toBigDecimal(txtLargo.getValue()));
		instalacion.setRadio(HarecUtil.toInteger(txtRadio.getValue()));
		
		instalacion.setDescripcion((String)txtDescripcion.getValue());
		instalacion.setDistrito((Distrito)cmbUbicacion.getValue());
		instalacion.setLatitud((String)txtLatitud.getValue());
		instalacion.setLongitud((String)txtLongitud.getValue());
		instalacion.setNombre((String)txtNombre.getValue());
		instalacion.setExpCentroPoblado((CentroPoblado)cmbCentroPoblado.getValue());
		instalacion.setOrganizacionDelictiva((Organizacion)cmbOrganizacion.getValue());
		instalacion.setSituacion((Valor)cmbSituacion.getValue());
		instalacion.setTipo((Valor)cmbTipoInstalacion.getValue());
		instalacion.setZonaProduccion((String)txtZonaProduccion.getValue());
		
		HarecUtil.validar(getWindow(), instalacion, new BeanValidar[]{
			new BeanValidar("tipo", new Object[]{"Tipo de instalación"}, cmbTipoInstalacion),
			new BeanValidar("organizacionDelictiva", new Object[]{"Organización Delictiva"}, cmbOrganizacion),
        	new BeanValidar("nombre", new Object[]{"Nombre"}, txtNombre),
        	new BeanValidar("situacion", new Object[]{"Situacion"}, cmbSituacion),
        });
		
		if(instalacion.esNuevo()){
			instalacionService.crear(instalacion);
		}else{
			instalacionService.actualizar(instalacion);
		}
		
		AlertDialog alertDialog = new  AlertDialog("Registro de Instalacion", "Se ha registrado la intalacion correctamente", "Aceptar", "400");
		getApplication().getMainWindow().addWindow(alertDialog);
		refrescar();
	}
	

	public void refrescar(){
		habilitarEdicion(false);
		limpiar();
		cargarTablaInstalaciones();
	}
	
	
	private void habilitarEdicion(boolean flag){
		if(flag){
			btnGrabar.setCaption("Actualizar");
		}
		else{
			btnGrabar.setCaption("Crear");
		}
	}
	
	public void limpiar(){
		instalacion = new Instalacion();
		instalacion.setExpediente(expediente);
		txtAlto.setValue("");
		txtAncho.setValue("");
		txtLargo.setValue("");
		txtLatitud.setValue("");
		txtLongitud.setValue("");
		txtNombre.setValue("");
		cmbCentroPoblado.select(null);
		cmbOrganizacion.select(null);
		cmbSituacion.select(null);
		cmbTipoInstalacion.select(null);
		cmbUbicacion.select(null);
		txtZonaProduccion.setValue("");
		txtRadio.setValue("");
		txtDescripcion.setValue("");
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
		
		// pnlInstalaciones
		pnlInstalaciones = buildPnlInstalaciones();
		mainLayout.addComponent(pnlInstalaciones);
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildPnlInstalaciones() {
		// common part: create layout
		pnlInstalaciones = new VerticalLayout();
		pnlInstalaciones.setImmediate(false);
		pnlInstalaciones.setWidth("-1px");
		pnlInstalaciones.setHeight("-1px");
		pnlInstalaciones.setMargin(false);
		
		// verticalLayout_9
		verticalLayout_9 = buildVerticalLayout_9();
		pnlInstalaciones.addComponent(verticalLayout_9);
		
		return pnlInstalaciones;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_9() {
		// common part: create layout
		verticalLayout_9 = new VerticalLayout();
		verticalLayout_9.setImmediate(false);
		verticalLayout_9.setWidth("-1px");
		verticalLayout_9.setHeight("-1px");
		verticalLayout_9.setMargin(true);
		verticalLayout_9.setSpacing(true);
		
		// horizontalLayout_28
		horizontalLayout_28 = buildHorizontalLayout_28();
		verticalLayout_9.addComponent(horizontalLayout_28);
		
		// horizontalLayout_29
		horizontalLayout_29 = buildHorizontalLayout_29();
		verticalLayout_9.addComponent(horizontalLayout_29);
		
		// horizontalLayout_30
		horizontalLayout_30 = buildHorizontalLayout_30();
		verticalLayout_9.addComponent(horizontalLayout_30);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		verticalLayout_9.addComponent(horizontalLayout_1);
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		verticalLayout_9.addComponent(horizontalLayout_2);
		verticalLayout_9.setComponentAlignment(horizontalLayout_2,
				new Alignment(20));
		
		// tblInstalaciones
		tblInstalaciones = new Table();
		tblInstalaciones.setImmediate(false);
		tblInstalaciones.setWidth("900px");
		tblInstalaciones.setHeight("150px");
		verticalLayout_9.addComponent(tblInstalaciones);
		
		return verticalLayout_9;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_28() {
		// common part: create layout
		horizontalLayout_28 = new HorizontalLayout();
		horizontalLayout_28.setImmediate(false);
		horizontalLayout_28.setWidth("-1px");
		horizontalLayout_28.setHeight("-1px");
		horizontalLayout_28.setMargin(false);
		horizontalLayout_28.setSpacing(true);
		
		// cmbTipoInstalacion
		cmbTipoInstalacion = new ComboBoxLOVS();
		cmbTipoInstalacion.setCaption("Tipo de Instalacion");
		cmbTipoInstalacion.setImmediate(false);
		cmbTipoInstalacion.setWidth("200px");
		cmbTipoInstalacion.setHeight("-1px");
		horizontalLayout_28.addComponent(cmbTipoInstalacion);
		
		// cmbOrganizacion
		cmbOrganizacion = new ComboBox();
		cmbOrganizacion.setCaption("Organizacion");
		cmbOrganizacion.setImmediate(false);
		cmbOrganizacion.setWidth("250px");
		cmbOrganizacion.setHeight("-1px");
		cmbOrganizacion.setRequired(true);
		horizontalLayout_28.addComponent(cmbOrganizacion);
		
		// txtNombre
		txtNombre = new TextField();
		txtNombre.setCaption("Nombre");
		txtNombre.setImmediate(false);
		txtNombre.setWidth("420px");
		txtNombre.setHeight("-1px");
		txtNombre.setRequired(true);
		txtNombre
				.setInputPrompt("Nombre con el que se conoce a la instalacion");
		txtNombre.setMaxLength(200);
		horizontalLayout_28.addComponent(txtNombre);
		
		return horizontalLayout_28;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_29() {
		// common part: create layout
		horizontalLayout_29 = new HorizontalLayout();
		horizontalLayout_29.setImmediate(false);
		horizontalLayout_29.setWidth("-1px");
		horizontalLayout_29.setHeight("-1px");
		horizontalLayout_29.setMargin(false);
		horizontalLayout_29.setSpacing(true);
		
		// cmbCentroPoblado
		cmbCentroPoblado = new ComboBox();
		cmbCentroPoblado.setCaption("Centro Poblado");
		cmbCentroPoblado.setImmediate(false);
		cmbCentroPoblado.setWidth("200px");
		cmbCentroPoblado.setHeight("-1px");
		horizontalLayout_29.addComponent(cmbCentroPoblado);
		
		// cmbSituacion
		cmbSituacion = new ComboBoxLOVS();
		cmbSituacion.setCaption("Situacion");
		cmbSituacion.setImmediate(false);
		cmbSituacion.setWidth("150px");
		cmbSituacion.setHeight("-1px");
		horizontalLayout_29.addComponent(cmbSituacion);
		
		// cmbUbicacion
		cmbUbicacion = new ComboBox();
		cmbUbicacion.setCaption("Ubicacion");
		cmbUbicacion.setImmediate(false);
		cmbUbicacion.setWidth("-1px");
		cmbUbicacion.setHeight("-1px");
		horizontalLayout_29.addComponent(cmbUbicacion);
		
		// txtZonaProduccion
		txtZonaProduccion = new TextField();
		txtZonaProduccion.setCaption("Zona de Producción");
		txtZonaProduccion.setImmediate(false);
		txtZonaProduccion.setWidth("-1px");
		txtZonaProduccion.setHeight("-1px");
		txtZonaProduccion.setInputPrompt("Zona de Producción");
		txtZonaProduccion.setMaxLength(200);
		horizontalLayout_29.addComponent(txtZonaProduccion);
		
		return horizontalLayout_29;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_30() {
		// common part: create layout
		horizontalLayout_30 = new HorizontalLayout();
		horizontalLayout_30.setImmediate(false);
		horizontalLayout_30.setWidth("-1px");
		horizontalLayout_30.setHeight("-1px");
		horizontalLayout_30.setMargin(false);
		horizontalLayout_30.setSpacing(true);
		
		// txtLongitud
		txtLongitud = new TextField();
		txtLongitud.setCaption("Longitud");
		txtLongitud.setImmediate(false);
		txtLongitud.setWidth("140px");
		txtLongitud.setHeight("-1px");
		txtLongitud.setInputPrompt("Longitud");
		txtLongitud.setMaxLength(15);
		horizontalLayout_30.addComponent(txtLongitud);
		
		// txtLatitud
		txtLatitud = new TextField();
		txtLatitud.setCaption("Latitud");
		txtLatitud.setImmediate(false);
		txtLatitud.setWidth("140px");
		txtLatitud.setHeight("-1px");
		txtLatitud.setInputPrompt("Latitud");
		txtLatitud.setMaxLength(15);
		horizontalLayout_30.addComponent(txtLatitud);
		
		// txtLargo
		txtLargo = new TextField();
		txtLargo.setCaption("Largo");
		txtLargo.setImmediate(false);
		txtLargo.setWidth("140px");
		txtLargo.setHeight("-1px");
		txtLargo.setInputPrompt("Largo");
		txtLargo.setMaxLength(4);
		horizontalLayout_30.addComponent(txtLargo);
		
		// txtAlto
		txtAlto = new TextField();
		txtAlto.setCaption("Alto");
		txtAlto.setImmediate(false);
		txtAlto.setWidth("140px");
		txtAlto.setHeight("-1px");
		txtAlto.setInputPrompt("Alto");
		txtAlto.setMaxLength(4);
		horizontalLayout_30.addComponent(txtAlto);
		
		// txtAncho
		txtAncho = new TextField();
		txtAncho.setCaption("Ancho");
		txtAncho.setImmediate(false);
		txtAncho.setWidth("140px");
		txtAncho.setHeight("-1px");
		txtAncho.setInputPrompt("Ancho");
		txtAncho.setMaxLength(4);
		horizontalLayout_30.addComponent(txtAncho);
		
		// txtRadio
		txtRadio = new TextField();
		txtRadio.setCaption("Radio");
		txtRadio.setImmediate(false);
		txtRadio.setWidth("140px");
		txtRadio.setHeight("-1px");
		txtRadio.setInputPrompt("Radio");
		txtRadio.setMaxLength(4);
		horizontalLayout_30.addComponent(txtRadio);
		
		return horizontalLayout_30;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("-1px");
		horizontalLayout_1.setHeight("-1px");
		horizontalLayout_1.setMargin(false);
		
		// txtDescripcion
		txtDescripcion = new TextArea();
		txtDescripcion.setCaption("Descripción");
		txtDescripcion.setImmediate(false);
		txtDescripcion.setWidth("900px");
		txtDescripcion.setHeight("100px");
		txtDescripcion.setInputPrompt("Descripción");
		txtDescripcion.setMaxLength(2000);
		horizontalLayout_1.addComponent(txtDescripcion);
		
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
		
		// btnGrabar
		btnGrabar = new Button();
		btnGrabar.setCaption("Grabar");
		btnGrabar.setImmediate(true);
		btnGrabar.setWidth("-1px");
		btnGrabar.setHeight("-1px");
		horizontalLayout_2.addComponent(btnGrabar);
		horizontalLayout_2.setComponentAlignment(btnGrabar, new Alignment(20));
		
		return horizontalLayout_2;
	}

}
