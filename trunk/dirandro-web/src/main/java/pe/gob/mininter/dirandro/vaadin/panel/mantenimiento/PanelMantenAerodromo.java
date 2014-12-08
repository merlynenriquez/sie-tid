package pe.gob.mininter.dirandro.vaadin.panel.mantenimiento;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.Aerodromo;
import pe.gob.mininter.dirandro.model.Distrito;
import pe.gob.mininter.dirandro.model.Empresa;
import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.AerodromoService;
import pe.gob.mininter.dirandro.service.EmpresaService;
import pe.gob.mininter.dirandro.service.UbigeoService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.vaadin.util.ComboBoxLOVS;
import pe.gob.mininter.dirandro.vaadin.util.DirandroComponent;
import pe.gob.mininter.dirandro.vaadin.util.Injector;
import pe.gob.mininter.dirandro.vaadin.util.TablaFiltro;
import pe.gob.mininter.dirandro.vaadin.util.container.TablaFiltroIndexedContainer;
import pe.gob.mininter.dirandro.vaadin.util.container.TablaFiltroIndexedContainer.TipoComponente;
import pe.gob.mininter.dirandro.vaadin.util.event.TablaFiltroEnterEvent;
import pe.gob.mininter.dirandro.vaadin.util.listener.TablaFiltroEnterListener;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class PanelMantenAerodromo extends DirandroComponent implements TablaFiltroEnterListener,ClickListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout pnlPrincipal;
	@AutoGenerated
	private VerticalLayout pnl2;
	@AutoGenerated
	private VerticalLayout pnl2_1;
	@AutoGenerated
	private HorizontalLayout lytBotones;
	@AutoGenerated
	private Button btnEliminar;
	@AutoGenerated
	private Button btnGuardar;
	@AutoGenerated
	private ComboBox cmbUbicacion;
	@AutoGenerated
	private ComboBoxLOVS cmbAeronaveMaxima;
	@AutoGenerated
	private ComboBox cmbEmpresa;
	@AutoGenerated
	private TextField txtNombre;
	@AutoGenerated
	private Label lblAdministracion;
	@AutoGenerated
	private VerticalLayout pnl1;
	@AutoGenerated
	private TablaFiltro tblAerodromo;
	@AutoGenerated
	private Label lblFiltro;
	private TablaFiltroIndexedContainer container;
	private Long id;
	private AerodromoService aerodromoService;
	private EmpresaService empresaService;
	private UbigeoService ubigeoService;
	
	public static final String COLUMNA_AERODROMO = "aerodromo";
	public static final String COLUMNA_NOMBRE = "nombre";
	public static final String COLUMNA_EMPRESA = "empresa";
	public static final String COLUMNA_AERONAVE_MAXIMA = "aeronaveMaxima";
	public static final String COLUMNA_UBICACION = "ubicacion";
	
	public PanelMantenAerodromo(List<Opcion> acciones, String height) {
		super(acciones, height);
		buildMainLayout();
		setCompositionRoot(mainLayout);
		aerodromoService=Injector.obtenerServicio(AerodromoService.class);
		empresaService=Injector.obtenerServicio(EmpresaService.class);
		ubigeoService=Injector.obtenerServicio(UbigeoService.class);
		postConstruct();
		debugId();
	}
	private void debugId(){
		
	}
	public void postConstruct() {
	
		txtNombre.setInputPrompt("Nombre");
		txtNombre.setNullRepresentation(StringUtils.EMPTY);
		
		List<Empresa> empresas=empresaService.buscar(null);
		cmbEmpresa.setInputPrompt("Empresa");
		cmbEmpresa.setItemCaptionPropertyId("razonSocial");
		cmbEmpresa.setContainerDataSource(new BeanItemContainer<Empresa>(Empresa.class,  empresas));
		
		cmbAeronaveMaxima.setCodigoLista(Constante.LISTA.CODIGO.AERO_MAX);
		cmbAeronaveMaxima.setInputPrompt("Aeronave Maxima");

		List<Distrito> distritos=ubigeoService.obtenerTodos();
		cmbUbicacion.setInputPrompt("Ubicacion");
		cmbUbicacion.setItemCaptionPropertyId("nombreCompleto");
		cmbUbicacion.setContainerDataSource(new BeanItemContainer<Distrito>(Distrito.class,  distritos));
		
		btnGuardar.addListener(this);
		btnEliminar.addListener(this);
		btnEliminar.setVisible(false);
		
        container = new TablaFiltroIndexedContainer();
		container.addContainerProperty(COLUMNA_AERODROMO, Aerodromo.class,  null);
		container.addContainerProperty(COLUMNA_NOMBRE, String.class, null,"Nombre",TipoComponente.TEXT,true,100);
		container.addContainerProperty(COLUMNA_EMPRESA, String.class, null,"Empresa",TipoComponente.TEXT,true,100);
		container.addContainerProperty(COLUMNA_AERONAVE_MAXIMA, String.class, null,"Aeronave Maxima", TipoComponente.TEXT, true,100);
		container.addContainerProperty(COLUMNA_UBICACION, String.class, null,"Ubicacion",TipoComponente.TEXT,true,100);
		
		tblAerodromo.setContainerDataSource(container);
		
		tblAerodromo.setSelectable(true);
		tblAerodromo.setImmediate(true);
		tblAerodromo.addListener((TablaFiltroEnterListener)this);
		tblAerodromo.addListener(new ValueChangeListener() {
			
			@Override
			public void valueChange(ValueChangeEvent event) {
				limpiar();
				if(tblAerodromo.getValue()!=null){
					Item item=tblAerodromo.getItem(tblAerodromo.getValue());
					Aerodromo aerodromo=(Aerodromo)item.getItemProperty(COLUMNA_AERODROMO).getValue();
					id=aerodromo.getId();
					txtNombre.setValue(aerodromo.getNombre());
					cmbEmpresa.setValue(aerodromo.getEmpresa());
					cmbAeronaveMaxima.setValue(aerodromo.getAeronaveMaxima());
					cmbUbicacion.setValue(aerodromo.getUbicacion());
					btnGuardar.setCaption("Modificar");
					btnEliminar.setVisible(true);
				}
			}
		});
		buscarAerodromo(null);
		
	}
	
	private void buscarAerodromo(Map<String, Object> map){
		Aerodromo aerodromoBuscar=new Aerodromo();
		if(map!=null){
			aerodromoBuscar.setNombre((String)map.get(COLUMNA_NOMBRE));
			Empresa empresa=new Empresa();
			empresa.setRazonSocial((String)map.get(COLUMNA_EMPRESA));
			aerodromoBuscar.setEmpresa(empresa);
			Valor aeronaveMaxima=new Valor();
			aeronaveMaxima.setNombre((String)map.get(COLUMNA_AERONAVE_MAXIMA));
			aerodromoBuscar.setAeronaveMaxima(aeronaveMaxima);
			Distrito ubicacion=new Distrito();
			ubicacion.setNombre((String)map.get(COLUMNA_UBICACION));
			aerodromoBuscar.setUbicacion(ubicacion);
		}
		List<Aerodromo> aerodromos=aerodromoService.buscar(aerodromoBuscar);
		container.removeAllItems();
		int con=1;
		for (Aerodromo aerodromo : aerodromos) {
			Item item = container.addItem(con++);
			item.getItemProperty(COLUMNA_AERODROMO).setValue(aerodromo);
			item.getItemProperty(COLUMNA_NOMBRE).setValue(aerodromo.getNombre());
			item.getItemProperty(COLUMNA_EMPRESA).
			setValue(aerodromo.getEmpresa()==null?null:aerodromo.getEmpresa().getRazonSocial());
			item.getItemProperty(COLUMNA_AERONAVE_MAXIMA).
			setValue(aerodromo.getAeronaveMaxima()==null?null:aerodromo.getAeronaveMaxima().getNombre());
			item.getItemProperty(COLUMNA_UBICACION).
			setValue(aerodromo.getUbicacion()==null?null:aerodromo.getUbicacion().getNombreCompleto());
		}
	}

	private void limpiar(){
		id=null;
		txtNombre.setValue(null);
		cmbEmpresa.setValue(null);
		cmbAeronaveMaxima.setValue(null);
		cmbUbicacion.setValue(null);
		btnGuardar.setCaption("Agregar");
		btnEliminar.setVisible(false);
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnGuardar)){
			Aerodromo aerodromo=new Aerodromo();
			aerodromo.setId(id);
			aerodromo.setNombre((String)txtNombre.getValue());
			aerodromo.setEmpresa((Empresa)cmbEmpresa.getValue());
			aerodromo.setAeronaveMaxima(cmbAeronaveMaxima.getValor());
			aerodromo.setUbicacion((Distrito)cmbUbicacion.getValue());
			if(aerodromo.getId()==null){
				aerodromoService.crear(aerodromo);
			}else{
				aerodromoService.actualizar(aerodromo);
			}
			limpiar();
			tblAerodromo.setValue(null);
			buscarAerodromo(tblAerodromo.getValues());
		}
		if(event.getButton().equals(btnEliminar)){
			aerodromoService.eliminarXId(id);
			limpiar();
			tblAerodromo.setValue(null);
			buscarAerodromo(tblAerodromo.getValues());
		}
	}
	@Override
	public void handleEnterAction(TablaFiltroEnterEvent event) {
		buscarAerodromo(event.getDatos());
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
	private HorizontalLayout buildPnlPrincipal() {
		// common part: create layout
		pnlPrincipal = new HorizontalLayout();
		pnlPrincipal.setStyleName("whiteBackGround");
		pnlPrincipal.setImmediate(false);
		pnlPrincipal.setWidth("-1px");
		pnlPrincipal.setHeight("-1px");
		pnlPrincipal.setMargin(true);
		
		// pnl1
		pnl1 = buildPnl1();
		pnlPrincipal.addComponent(pnl1);
		
		// pnl2
		pnl2 = buildPnl2();
		pnlPrincipal.addComponent(pnl2);
		
		return pnlPrincipal;
	}
	@AutoGenerated
	private VerticalLayout buildPnl1() {
		// common part: create layout
		pnl1 = new VerticalLayout();
		pnl1.setImmediate(false);
		pnl1.setWidth("-1px");
		pnl1.setHeight("-1px");
		pnl1.setMargin(false);
		
		// lblFiltro
		lblFiltro = new Label();
		lblFiltro.setStyleName("h2");
		lblFiltro.setImmediate(false);
		lblFiltro.setWidth("500px");
		lblFiltro.setHeight("-1px");
		lblFiltro.setValue("Filtro Aerodromo");
		pnl1.addComponent(lblFiltro);
		
		// tblAerodromo
		tblAerodromo = new TablaFiltro();
		tblAerodromo.setImmediate(false);
		tblAerodromo.setWidth("485px");
		tblAerodromo.setHeight("400px");
		pnl1.addComponent(tblAerodromo);
		
		return pnl1;
	}
	@AutoGenerated
	private VerticalLayout buildPnl2() {
		// common part: create layout
		pnl2 = new VerticalLayout();
		pnl2.setImmediate(false);
		pnl2.setWidth("-1px");
		pnl2.setHeight("-1px");
		pnl2.setMargin(false);
		pnl2.setSpacing(true);
		
		// lblAdministracion
		lblAdministracion = new Label();
		lblAdministracion.setStyleName("h2");
		lblAdministracion.setImmediate(false);
		lblAdministracion.setWidth("234px");
		lblAdministracion.setHeight("-1px");
		lblAdministracion.setValue("Administración Aerodromo");
		pnl2.addComponent(lblAdministracion);
		
		// pnl2_1
		pnl2_1 = buildPnl2_1();
		pnl2.addComponent(pnl2_1);
		
		return pnl2;
	}
	@AutoGenerated
	private VerticalLayout buildPnl2_1() {
		// common part: create layout
		pnl2_1 = new VerticalLayout();
		pnl2_1.setImmediate(false);
		pnl2_1.setWidth("-1px");
		pnl2_1.setHeight("-1px");
		pnl2_1.setMargin(false);
		pnl2_1.setSpacing(true);
		
		// txtNombre
		txtNombre = new TextField();
		txtNombre.setCaption("Nombre");
		txtNombre.setImmediate(false);
		txtNombre.setWidth("300px");
		txtNombre.setHeight("-1px");
		pnl2_1.addComponent(txtNombre);
		
		// cmbEmpresa
		cmbEmpresa = new ComboBox();
		cmbEmpresa.setCaption("Empresa");
		cmbEmpresa.setImmediate(false);
		cmbEmpresa.setWidth("300px");
		cmbEmpresa.setHeight("-1px");
		pnl2_1.addComponent(cmbEmpresa);
		
		// cmbAeronaveMaxima
		cmbAeronaveMaxima = new ComboBoxLOVS();
		cmbAeronaveMaxima.setCaption("Aeronave Maxima");
		cmbAeronaveMaxima.setImmediate(false);
		cmbAeronaveMaxima.setWidth("300px");
		cmbAeronaveMaxima.setHeight("-1px");
		pnl2_1.addComponent(cmbAeronaveMaxima);
		
		// cmbUbicacion
		cmbUbicacion = new ComboBox();
		cmbUbicacion.setCaption("Ubicacion");
		cmbUbicacion.setImmediate(false);
		cmbUbicacion.setWidth("300px");
		cmbUbicacion.setHeight("-1px");
		pnl2_1.addComponent(cmbUbicacion);
		
		// lytBotones
		lytBotones = buildLytBotones();
		pnl2_1.addComponent(lytBotones);
		pnl2_1.setComponentAlignment(lytBotones, new Alignment(20));
		
		return pnl2_1;
	}
	@AutoGenerated
	private HorizontalLayout buildLytBotones() {
		// common part: create layout
		lytBotones = new HorizontalLayout();
		lytBotones.setImmediate(false);
		lytBotones.setWidth("-1px");
		lytBotones.setHeight("-1px");
		lytBotones.setMargin(false);
		lytBotones.setSpacing(true);
		
		// btnGuardar
		btnGuardar = new Button();
		btnGuardar.setCaption("Agregar");
		btnGuardar.setImmediate(true);
		btnGuardar.setWidth("-1px");
		btnGuardar.setHeight("-1px");
		lytBotones.addComponent(btnGuardar);
		
		// btnEliminar
		btnEliminar = new Button();
		btnEliminar.setCaption("Eliminar");
		btnEliminar.setImmediate(false);
		btnEliminar.setWidth("-1px");
		btnEliminar.setHeight("-1px");
		lytBotones.addComponent(btnEliminar);
		
		return lytBotones;
	}

}
