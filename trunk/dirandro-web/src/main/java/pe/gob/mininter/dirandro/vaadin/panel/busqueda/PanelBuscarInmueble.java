package pe.gob.mininter.dirandro.vaadin.panel.busqueda;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;

import pe.gob.mininter.dirandro.model.Distrito;
import pe.gob.mininter.dirandro.model.Inmueble;
import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.service.InmuebleService;
import pe.gob.mininter.dirandro.service.UbigeoService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.vaadin.util.ComboBoxLOVS;
import pe.gob.mininter.dirandro.vaadin.util.DirandroComponent;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;


@SuppressWarnings("serial")
public class PanelBuscarInmueble extends DirandroComponent implements ClickListener{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	
	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlPrincipal;
	@AutoGenerated
	private Table tblInmueble;
	@AutoGenerated
	private HorizontalLayout lytFiltro4;
	@AutoGenerated
	private Button btnBuscar;
	@AutoGenerated
	private TextField txtDimension;
	@AutoGenerated
	private TextField txtLatitud;
	@AutoGenerated
	private HorizontalLayout lytFiltro3;
	@AutoGenerated
	private TextField txtLongitud;
	@AutoGenerated
	private TextField txtObservaciones;
	@AutoGenerated
	private TextField txtValorTerreno;
	@AutoGenerated
	private TextField txtValorBien;
	@AutoGenerated
	private HorizontalLayout lytFiltro2;
	@AutoGenerated
	private TextField txtResolucion;
	@AutoGenerated
	private TextField txtOficinaRegistral;
	@AutoGenerated
	private TextField txtNroInscripcion;
	@AutoGenerated
	private ComboBox cmbUbicacion;
	@AutoGenerated
	private HorizontalLayout lytFiltro1;
	@AutoGenerated
	private TextField txtUrbanizacion;
	@AutoGenerated
	private TextField txtDireccion;
	@AutoGenerated
	private ComboBoxLOVS cmbTipoDireccion;
	@AutoGenerated
	private TextField txtDescripcion;
	private UbigeoService ubigeoService;
	private InmuebleService inmuebleService;
	
	private static final String COLUMN_ID = "COLUMN_ID";
	private static final String COLUMN_DESCRIPCION = "COLUMN_DESCRIPCION";
	private static final String COLUMN_TIPO_DIRECCION = "COLUMN_TIPO_DIRECCION";
	private static final String COLUMN_DIRECCION = "COLUMN_DIRECCION";
	private static final String COLUMN_URBANIZACION = "COLUMN_URBANIZACION";
	private static final String COLUMN_UBICACION = "COLUMN_UBICACION";
	private static final String COLUMN_NRO_INSCRIPCION = "COLUMN_NRO_INSCRIPCION";
	private static final String COLUMN_OFICINA_REGISTRAL = "COLUMN_OFICINA_REGISTRAL";
	private static final String COLUMN_RESOLUCION = "COLUMN_RESOLUCION";
	private static final String COLUMN_VALOR_BIEN = "COLUMN_VALOR_BIEN";
	private static final String COLUMN_VALOR_TERRENO = "COLUMN_VALOR_TERRENO";
	private static final String COLUMN_OBSERVACIONES = "COLUMN_OBSERVACIONES";
	private static final String COLUMN_LONGITUD = "COLUMN_LONGITUD";
	private static final String COLUMN_LATITUD = "COLUMN_LATITUD";
	private static final String COLUMN_DIMENSION = "COLUMN_DIMENSION";
	
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelBuscarInmueble(List<Opcion> acciones, String height) {
		super(acciones, height);
		buildMainLayout();
		ubigeoService=Injector.obtenerServicio(UbigeoService.class);
		inmuebleService=Injector.obtenerServicio(InmuebleService.class);
		setCompositionRoot(mainLayout);
		postConstruct();
		debugId();
	}
	
	private void debugId(){
		
	}
	
	public void postConstruct() {
		List<Distrito> distritos=ubigeoService.obtenerTodos();
		txtDescripcion.setInputPrompt("Descripcion");
		cmbTipoDireccion.setInputPrompt("Tipo Direccion");
		cmbTipoDireccion.setCodigoLista(Constante.LISTA.CODIGO.DIRECCION_TIPO);
		txtDireccion.setInputPrompt("Direccion");
		txtUrbanizacion.setInputPrompt("Urbanizacion");
		cmbUbicacion.setInputPrompt("Ubicacion");
		cmbUbicacion.setItemCaptionPropertyId("nombreCompleto");
		cmbUbicacion.setContainerDataSource(new BeanItemContainer<Distrito>(Distrito.class,  distritos));
		txtNroInscripcion.setInputPrompt("Nro Inscripcion");
		txtOficinaRegistral.setInputPrompt("Oficina Registral");
		txtResolucion.setInputPrompt("Resolucion");
		txtValorBien.setInputPrompt("Valor Bien");
		txtValorTerreno.setInputPrompt("Valor Terreno");
		txtObservaciones.setInputPrompt("Observaciones");
		txtLongitud.setInputPrompt("Longitud");
		txtLatitud.setInputPrompt("Latitud");
		txtDimension.setInputPrompt("Dimension");
		
		btnBuscar.addListener(this);
		
		tblInmueble.setColumnCollapsingAllowed(true);
		cargarTabla(null);
	}
	
	private void cargarTabla(List<Inmueble> inmuebles)
	{
		IndexedContainer container = new IndexedContainer();
        
        container.addContainerProperty(COLUMN_ID, Long.class,  null);
        container.addContainerProperty(COLUMN_DESCRIPCION, String.class,  null);
        container.addContainerProperty(COLUMN_TIPO_DIRECCION, String.class,  null);
        container.addContainerProperty(COLUMN_DIRECCION, String.class,  null);
        container.addContainerProperty(COLUMN_URBANIZACION, String.class,  null);
        container.addContainerProperty(COLUMN_UBICACION, String.class,  null);
        container.addContainerProperty(COLUMN_NRO_INSCRIPCION, String.class,  null);
        container.addContainerProperty(COLUMN_OFICINA_REGISTRAL, String.class,  null);
        container.addContainerProperty(COLUMN_RESOLUCION, String.class,  null);
        container.addContainerProperty(COLUMN_VALOR_BIEN, BigDecimal.class,  null);
        container.addContainerProperty(COLUMN_VALOR_TERRENO, BigDecimal.class,  null);
        container.addContainerProperty(COLUMN_OBSERVACIONES, String.class,  null);
        container.addContainerProperty(COLUMN_LONGITUD, String.class,  null);
        container.addContainerProperty(COLUMN_LATITUD, String.class,  null);
        container.addContainerProperty(COLUMN_DIMENSION, BigDecimal.class,  null);
        
        if(inmuebles!=null){
	        int con=1;
	        for (Inmueble inmueble: inmuebles) {
	                Item item = container.addItem(con++);
				    item.getItemProperty(COLUMN_ID).setValue(inmueble.getId());
				    item.getItemProperty(COLUMN_DESCRIPCION).setValue(inmueble.getDescripcion());
				    item.getItemProperty(COLUMN_TIPO_DIRECCION).setValue(inmueble.getTipoDireccion()!=null ? 
				    		inmueble.getTipoDireccion().getNombre() : null);
				    item.getItemProperty(COLUMN_DIRECCION).setValue(inmueble.getDireccion());
				    item.getItemProperty(COLUMN_URBANIZACION).setValue(inmueble.getUrbanizacion());
				    item.getItemProperty(COLUMN_UBICACION).setValue(inmueble.getUbgDistrito()!=null ? 
				    		inmueble.getUbgDistrito().getNombreCompleto() : null);
				    item.getItemProperty(COLUMN_NRO_INSCRIPCION).setValue(inmueble.getNroInscripcion());
				    item.getItemProperty(COLUMN_OFICINA_REGISTRAL).setValue(inmueble.getOficinaRegistral());
				    item.getItemProperty(COLUMN_RESOLUCION).setValue(inmueble.getResolucion());
				    item.getItemProperty(COLUMN_VALOR_BIEN).setValue(inmueble.getValorBien());
				    item.getItemProperty(COLUMN_VALOR_TERRENO).setValue(inmueble.getValorTerreno());
				    item.getItemProperty(COLUMN_OBSERVACIONES).setValue(inmueble.getObservaciones());
				    item.getItemProperty(COLUMN_LONGITUD).setValue(inmueble.getLongitud());
				    item.getItemProperty(COLUMN_LATITUD).setValue(inmueble.getLatitud());
				    item.getItemProperty(COLUMN_DIMENSION).setValue(inmueble.getDimension());
			}
        }
        
        tblInmueble.setContainerDataSource(container);
        tblInmueble.setVisibleColumns(new Object[]{COLUMN_DESCRIPCION, COLUMN_TIPO_DIRECCION, 
        		COLUMN_DIRECCION, COLUMN_URBANIZACION, COLUMN_UBICACION, COLUMN_NRO_INSCRIPCION, 
        		COLUMN_OFICINA_REGISTRAL, COLUMN_RESOLUCION, COLUMN_VALOR_BIEN, COLUMN_VALOR_TERRENO,
        		COLUMN_OBSERVACIONES, COLUMN_LONGITUD, COLUMN_LATITUD, COLUMN_DIMENSION});
        tblInmueble.setColumnWidth(COLUMN_DESCRIPCION, 100);
        tblInmueble.setColumnWidth(COLUMN_TIPO_DIRECCION, 100);
        tblInmueble.setColumnWidth(COLUMN_DIRECCION, 100);
        tblInmueble.setColumnWidth(COLUMN_URBANIZACION, 100);
        tblInmueble.setColumnWidth(COLUMN_UBICACION, 100);
        tblInmueble.setColumnWidth(COLUMN_NRO_INSCRIPCION, 100);
        tblInmueble.setColumnWidth(COLUMN_OFICINA_REGISTRAL, 100);
        tblInmueble.setColumnWidth(COLUMN_RESOLUCION, 100);
        tblInmueble.setColumnWidth(COLUMN_VALOR_BIEN, 100);
        tblInmueble.setColumnWidth(COLUMN_VALOR_TERRENO, 100);
        tblInmueble.setColumnWidth(COLUMN_OBSERVACIONES, 100);
        tblInmueble.setColumnWidth(COLUMN_LONGITUD, 100);
        tblInmueble.setColumnWidth(COLUMN_LATITUD, 100);
        tblInmueble.setColumnWidth(COLUMN_DIMENSION, 100);
        tblInmueble.setColumnHeader(COLUMN_DESCRIPCION, "Descripcion");
        tblInmueble.setColumnHeader(COLUMN_TIPO_DIRECCION, "Tipo Direccion");
        tblInmueble.setColumnHeader(COLUMN_DIRECCION, "Direccion");
        tblInmueble.setColumnHeader(COLUMN_URBANIZACION, "Urbanizacion");
        tblInmueble.setColumnHeader(COLUMN_UBICACION, "Ubicacion");
        tblInmueble.setColumnHeader(COLUMN_NRO_INSCRIPCION, "Nro Inscripcion");
        tblInmueble.setColumnHeader(COLUMN_OFICINA_REGISTRAL, "Oficina Registral");
        tblInmueble.setColumnHeader(COLUMN_RESOLUCION, "Resolucion");
        tblInmueble.setColumnHeader(COLUMN_VALOR_BIEN, "Valor Bien");
        tblInmueble.setColumnHeader(COLUMN_VALOR_TERRENO, "Valor Terreno");
        tblInmueble.setColumnHeader(COLUMN_OBSERVACIONES, "Observaciones");
        tblInmueble.setColumnHeader(COLUMN_LONGITUD, "Longitud");
        tblInmueble.setColumnHeader(COLUMN_LATITUD, "Latitud");
        tblInmueble.setColumnHeader(COLUMN_DIMENSION, "Dimension");
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnBuscar)){
			Inmueble inmueble=new Inmueble();
			inmueble.setDescripcion((String)txtDescripcion.getValue());
			inmueble.setTipoDireccion(cmbTipoDireccion.getValor());
			inmueble.setDireccion((String)txtDireccion.getValue());
			inmueble.setUrbanizacion((String)txtUrbanizacion.getValue());
			inmueble.setUbgDistrito((Distrito)cmbUbicacion.getValue());
			inmueble.setNroInscripcion((String)txtNroInscripcion.getValue());
			inmueble.setOficinaRegistral((String)txtOficinaRegistral.getValue());
			inmueble.setResolucion((String)txtResolucion.getValue());
			if(NumberUtils.isNumber((String)txtValorBien.getValue())){
				inmueble.setValorBien(new BigDecimal((String)txtValorBien.getValue()));
			}
			if(NumberUtils.isNumber((String)txtValorTerreno.getValue())){
				inmueble.setValorTerreno(new BigDecimal((String)txtValorTerreno.getValue()));
			}
			inmueble.setObservaciones((String)txtObservaciones.getValue());
			inmueble.setLongitud((String)txtLongitud.getValue());
			inmueble.setLatitud((String)txtLatitud.getValue());
			if(NumberUtils.isNumber((String)txtDimension.getValue())){
				inmueble.setDimension(new BigDecimal((String)txtDimension.getValue()));
			}
			cargarTabla(inmuebleService.buscar(inmueble));
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
		
		// tblInmueble
		tblInmueble = new Table();
		tblInmueble.setImmediate(false);
		tblInmueble.setWidth("730px");
		tblInmueble.setHeight("350px");
		pnlPrincipal.addComponent(tblInmueble);
		
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
		
		// txtDescripcion
		txtDescripcion = new TextField();
		txtDescripcion.setImmediate(false);
		txtDescripcion.setWidth("150px");
		txtDescripcion.setHeight("-1px");
		lytFiltro1.addComponent(txtDescripcion);
		
		// cmbTipoDireccion
		cmbTipoDireccion = new ComboBoxLOVS();
		cmbTipoDireccion.setImmediate(false);
		cmbTipoDireccion.setWidth("150px");
		cmbTipoDireccion.setHeight("-1px");
		lytFiltro1.addComponent(cmbTipoDireccion);
		
		// txtDireccion
		txtDireccion = new TextField();
		txtDireccion.setImmediate(false);
		txtDireccion.setWidth("150px");
		txtDireccion.setHeight("-1px");
		lytFiltro1.addComponent(txtDireccion);
		
		// txtUrbanizacion
		txtUrbanizacion = new TextField();
		txtUrbanizacion.setImmediate(false);
		txtUrbanizacion.setWidth("150px");
		txtUrbanizacion.setHeight("-1px");
		lytFiltro1.addComponent(txtUrbanizacion);
		
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
		
		// cmbUbicacion
		cmbUbicacion = new ComboBox();
		cmbUbicacion.setImmediate(false);
		cmbUbicacion.setWidth("150px");
		cmbUbicacion.setHeight("-1px");
		lytFiltro2.addComponent(cmbUbicacion);
		
		// txtNroInscripcion
		txtNroInscripcion = new TextField();
		txtNroInscripcion.setImmediate(false);
		txtNroInscripcion.setWidth("150px");
		txtNroInscripcion.setHeight("-1px");
		lytFiltro2.addComponent(txtNroInscripcion);
		
		// txtOficinaRegistral
		txtOficinaRegistral = new TextField();
		txtOficinaRegistral.setImmediate(false);
		txtOficinaRegistral.setWidth("150px");
		txtOficinaRegistral.setHeight("-1px");
		lytFiltro2.addComponent(txtOficinaRegistral);
		
		// txtResolucion
		txtResolucion = new TextField();
		txtResolucion.setImmediate(false);
		txtResolucion.setWidth("150px");
		txtResolucion.setHeight("-1px");
		lytFiltro2.addComponent(txtResolucion);
		
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
		
		// txtValorBien
		txtValorBien = new TextField();
		txtValorBien.setImmediate(false);
		txtValorBien.setWidth("150px");
		txtValorBien.setHeight("-1px");
		lytFiltro3.addComponent(txtValorBien);
		
		// txtValorTerreno
		txtValorTerreno = new TextField();
		txtValorTerreno.setImmediate(false);
		txtValorTerreno.setWidth("150px");
		txtValorTerreno.setHeight("-1px");
		lytFiltro3.addComponent(txtValorTerreno);
		
		// txtObservaciones
		txtObservaciones = new TextField();
		txtObservaciones.setImmediate(false);
		txtObservaciones.setWidth("150px");
		txtObservaciones.setHeight("-1px");
		lytFiltro3.addComponent(txtObservaciones);
		
		// txtLongitud
		txtLongitud = new TextField();
		txtLongitud.setImmediate(false);
		txtLongitud.setWidth("150px");
		txtLongitud.setHeight("-1px");
		lytFiltro3.addComponent(txtLongitud);
		
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
		
		// txtLatitud
		txtLatitud = new TextField();
		txtLatitud.setImmediate(false);
		txtLatitud.setWidth("150px");
		txtLatitud.setHeight("-1px");
		lytFiltro4.addComponent(txtLatitud);
		
		// txtDimension
		txtDimension = new TextField();
		txtDimension.setImmediate(false);
		txtDimension.setWidth("150px");
		txtDimension.setHeight("-1px");
		lytFiltro4.addComponent(txtDimension);
		
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
