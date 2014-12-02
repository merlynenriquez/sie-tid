package pe.gob.mininter.dirandro.vaadin.panel.inteligencia;

import java.math.BigDecimal;
import java.util.List;

import pe.gob.mininter.dirandro.model.DetOrganizacion;
import pe.gob.mininter.dirandro.model.Inteligencia;
import pe.gob.mininter.dirandro.model.Organizacion;
import pe.gob.mininter.dirandro.service.DetOrganizacionService;
import pe.gob.mininter.dirandro.service.OrganizacionService;
import pe.gob.mininter.dirandro.vaadin.panel.util.PanelAgregarOrganizacionInteligencia;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
public class PanelRegistroInteligenciaOrganizacion extends CustomComponent implements ClickListener{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlPrincipal;
	@AutoGenerated
	private Table tblOrganizacion;
	@AutoGenerated
	private HorizontalLayout lytFormulario;
	@AutoGenerated
	private Button btnAgregar;
	@AutoGenerated
	private Button btnNuevo;
	@AutoGenerated
	private ComboBox cmbOrganizacion;
	private DetOrganizacionService detOrganizacionService;
	private OrganizacionService organizacionService;
	
	private Inteligencia inteligencia;
	
	public static final String COLUMNA_NOMBRE = "nombre";
	public static final String COLUMNA_CAMPO = "campo";
	public static final String COLUMNA_NRO_INTEGRANTE = "nroIntegrante";
	public static final String COLUMNA_ZONA_OPERACION = "zonaOperacion";
	public static final String COLUMNA_UBICACION_ACTIVO = "ubicacionActivo";
	public static final String COLUMNA_OPCION = "opcion";
	
	public Inteligencia getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(Inteligencia inteligencia) {
		this.inteligencia = inteligencia;
	}
	
	public PanelRegistroInteligenciaOrganizacion() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		detOrganizacionService=Injector.obtenerServicio(DetOrganizacionService.class);
		organizacionService=Injector.obtenerServicio(OrganizacionService.class);
		postConstruct();
	}

	public void postConstruct(){
		
		actualizaListaOrganizacion();

		btnNuevo.addListener(this);
		btnAgregar.addListener(this);
		
		cargarDatos();
		
	}
	
	private void cargarDatos(){
		DetOrganizacion detOrganizacionBuscar=new DetOrganizacion();
		detOrganizacionBuscar.setInteligencia(inteligencia);
		List<DetOrganizacion> detOrganizaciones=detOrganizacionService.buscar(detOrganizacionBuscar);
		
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty(COLUMNA_NOMBRE, String.class,  null);
        container.addContainerProperty(COLUMNA_CAMPO, String.class,  null);
        container.addContainerProperty(COLUMNA_NRO_INTEGRANTE, BigDecimal.class,  null);
        container.addContainerProperty(COLUMNA_ZONA_OPERACION, String.class,  null);
        container.addContainerProperty(COLUMNA_UBICACION_ACTIVO, String.class,  null);
        container.addContainerProperty(COLUMNA_OPCION, Button.class,  null);
        
        int con=1;
		for (final DetOrganizacion detOrganizacion : detOrganizaciones) {
			Item item=container.addItem(con++);
			item.getItemProperty(COLUMNA_NOMBRE).setValue(detOrganizacion.getOrganizacion().getNombre());
			item.getItemProperty(COLUMNA_CAMPO).setValue(detOrganizacion.getOrganizacion().getCampo());
			item.getItemProperty(COLUMNA_NRO_INTEGRANTE).setValue(detOrganizacion.getOrganizacion().getNroIntegrantes());
			item.getItemProperty(COLUMNA_ZONA_OPERACION).setValue(detOrganizacion.getOrganizacion().getZonaOperacion());
			item.getItemProperty(COLUMNA_UBICACION_ACTIVO).setValue(detOrganizacion.getOrganizacion().getUbicacionActivos());
			Button eliminar=new Button();
			eliminar.setCaption("Eliminar");
			eliminar.addListener(new ClickListener() {
				
				@Override
				public void buttonClick(ClickEvent event) {
					detOrganizacionService.eliminar(detOrganizacion);
					cargarDatos();
				}
			});
			item.getItemProperty(COLUMNA_OPCION).
			setValue(eliminar);
		}
        
		tblOrganizacion.setContainerDataSource(container);
        tblOrganizacion.setVisibleColumns(new Object[]{COLUMNA_NOMBRE, COLUMNA_CAMPO, COLUMNA_NRO_INTEGRANTE, COLUMNA_ZONA_OPERACION, COLUMNA_UBICACION_ACTIVO, COLUMNA_OPCION});
        tblOrganizacion.setColumnWidth(COLUMNA_NOMBRE, 100);
        tblOrganizacion.setColumnWidth(COLUMNA_CAMPO, 100);
        tblOrganizacion.setColumnWidth(COLUMNA_NRO_INTEGRANTE, 100);
        tblOrganizacion.setColumnWidth(COLUMNA_ZONA_OPERACION, 100);
        tblOrganizacion.setColumnWidth(COLUMNA_UBICACION_ACTIVO, 100);
        tblOrganizacion.setColumnWidth(COLUMNA_OPCION, 100);
        tblOrganizacion.setColumnHeader(COLUMNA_NOMBRE, "Nombre");
        tblOrganizacion.setColumnHeader(COLUMNA_CAMPO, "Campo");
        tblOrganizacion.setColumnHeader(COLUMNA_NRO_INTEGRANTE, "Nro Integrante");
        tblOrganizacion.setColumnHeader(COLUMNA_ZONA_OPERACION, "Zona Operacion");
        tblOrganizacion.setColumnHeader(COLUMNA_UBICACION_ACTIVO, "Ubicacion Activo");
        tblOrganizacion.setColumnHeader(COLUMNA_OPCION, "Opcion");
	}
	
	public void actualizaListaOrganizacion() {
		List<Organizacion> organizaciones=organizacionService.buscar(null);
		cmbOrganizacion.setInputPrompt("Organizacion");
		cmbOrganizacion.setItemCaptionPropertyId("nombre");
		cmbOrganizacion.setContainerDataSource(new BeanItemContainer<Organizacion>(Organizacion.class,  organizaciones));
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnAgregar)){
			if(cmbOrganizacion.getValue()!=null){
				DetOrganizacion detOrganizacion=new DetOrganizacion();
				detOrganizacion.setInteligencia(inteligencia);
				detOrganizacion.setOrganizacion((Organizacion)cmbOrganizacion.getValue());
				detOrganizacionService.crear(detOrganizacion);
				cmbOrganizacion.setValue(null);
				cargarDatos();
			}
		}
		if(event.getButton().equals(btnNuevo)){
			final PanelAgregarOrganizacionInteligencia panelAgregarOrganizacionInteligencia = new PanelAgregarOrganizacionInteligencia();

			Window window=new Window(){
				
				private static final long serialVersionUID = 1L;

					protected void close() {
						getApplication().getMainWindow().removeWindow(getWindow());
					}

					@Override
					public void detach() {
						actualizaListaOrganizacion();
						if(panelAgregarOrganizacionInteligencia.getOrganizacion()!=null){
						cmbOrganizacion.select(panelAgregarOrganizacionInteligencia.getOrganizacion());
						}
				  	}
			};
			window.setCaption("Registrar Organizacion");
			window.addComponent(panelAgregarOrganizacionInteligencia);
			window.setModal(true);
			window.setResizable(false);
			window.setWidth("550px");
			window.setHeight("-1px");
			getApplication().getMainWindow().addWindow(window);
		}
	}
	
	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(true);
		
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
		
		// tblOrganizacion
		tblOrganizacion = new Table();
		tblOrganizacion.setImmediate(false);
		tblOrganizacion.setWidth("750px");
		tblOrganizacion.setHeight("200px");
		pnlPrincipal.addComponent(tblOrganizacion);
		
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
		
		// cmbOrganizacion
		cmbOrganizacion = new ComboBox();
		cmbOrganizacion.setImmediate(false);
		cmbOrganizacion.setWidth("-1px");
		cmbOrganizacion.setHeight("-1px");
		lytFormulario.addComponent(cmbOrganizacion);
		
		// btnNuevo
		btnNuevo = new Button();
		btnNuevo.setCaption("Nuevo");
		btnNuevo.setImmediate(false);
		btnNuevo.setWidth("-1px");
		btnNuevo.setHeight("-1px");
		lytFormulario.addComponent(btnNuevo);
		
		// btnAgregar
		btnAgregar = new Button();
		btnAgregar.setCaption("Agregar");
		btnAgregar.setImmediate(true);
		btnAgregar.setWidth("-1px");
		btnAgregar.setHeight("-1px");
		lytFormulario.addComponent(btnAgregar);
		
		return lytFormulario;
	}

}
