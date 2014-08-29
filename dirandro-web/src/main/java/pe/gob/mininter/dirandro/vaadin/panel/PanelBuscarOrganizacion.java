package pe.gob.mininter.dirandro.vaadin.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.model.Organizacion;
import pe.gob.mininter.dirandro.model.Usuario;
import pe.gob.mininter.dirandro.service.OrganizacionService;
import pe.gob.mininter.dirandro.util.HarecUtil;
import pe.gob.mininter.dirandro.vaadin.util.DirandroComponent;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PanelBuscarOrganizacion extends DirandroComponent implements TextChangeListener,ClickListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlPrincipal;
	@AutoGenerated
	private VerticalLayout verticalLayout_2;
	@AutoGenerated
	private Table tblOrganizaciones;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_3;
	@AutoGenerated
	private Button btnNuevo;
	@AutoGenerated
	private Button btnBuscar;
	@AutoGenerated
	private TextArea txtDescripcion;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private TextField txtUbicacionAct;
	@AutoGenerated
	private TextField txtZonaOperacion;
	@AutoGenerated
	private TextField txtIntegrantes;
	@AutoGenerated
	private TextField txtNombre;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	
	private OrganizacionService organizacionService;
	
	private Organizacion organizacion;
	
	private boolean flagNuevaEstado;
	
	public PanelBuscarOrganizacion(List<Opcion> acciones, String height) {
		super(acciones, height);
		
		organizacionService = Injector.obtenerServicio(OrganizacionService.class);
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		postConstruct();
		debugId();
	}
	private void debugId(){
		
	}
	
	public void postConstruct() {
		
		btnBuscar.addListener((ClickListener)this);
		btnNuevo.addListener((ClickListener)this);
		
		/*txtNombre.addListener((TextChangeListener)this);
		txtDescripcion.addListener((TextChangeListener)this);
		txtZonaOperacion.addListener((TextChangeListener)this);*/
		
		habilitarEdicion(false);
		
		tblOrganizaciones.setSelectable(true);
		tblOrganizaciones.setImmediate(true);
		tblOrganizaciones.setNullSelectionAllowed(true);
		tblOrganizaciones.setNullSelectionItemId(null);
		tblOrganizaciones.addListener(new ValueChangeListener() {
			private static final long serialVersionUID = -6124596484581515359L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				boolean esModoNuevo = tblOrganizaciones.getValue() == null;				
				if(esModoNuevo){
					organizacion = new Organizacion();
					tblOrganizaciones.setValue(null);
					habilitarEdicion(false);
				}else {
					habilitarEdicion(true);
					
					Item item = tblOrganizaciones.getItem(tblOrganizaciones.getValue());
					
					organizacion = organizacionService.obtener( new Long( item.getItemProperty("id").getValue().toString() ));
					
					txtNombre.setValue((organizacion.getNombre() != null) ? organizacion.getNombre() : "");
					txtIntegrantes.setValue((organizacion.getNroIntegrantes() != null) ? organizacion.getNroIntegrantes().toString() : "");
					txtZonaOperacion.setValue((organizacion.getZonaOperacion() != null) ? organizacion.getZonaOperacion() : "");
					txtUbicacionAct.setValue((organizacion.getUbicacionActivos() != null) ? organizacion.getUbicacionActivos() : "");
					txtDescripcion.setValue((organizacion.getDescripcion() != null) ? organizacion.getDescripcion() : "");
				}
			}
		});
		
		organizacion = new Organizacion();
		List<Organizacion> lista = organizacionService.listarOrganizaciones();
		cargarOrganizaciones(lista, true);		
		
	}
	
	private void habilitarEdicion(boolean flag){
		flagNuevaEstado = flag;
		if(flag){
			btnNuevo.setCaption("Actualizar");
		}
		else{
			btnNuevo.setCaption("Crear");
		}
	}

	@Override
	public void buttonClick(ClickEvent event) {

		if (event.getButton().equals(btnBuscar)) {
			//buscarOrganizacion();
		} else if (event.getButton().equals(btnNuevo)) {			
			if(flagNuevaEstado){
				actualizaOrganizacion();
			}
			else{
				registrarOrganizacion();
			}
			List<Organizacion> lista = organizacionService.listarOrganizaciones();
			cargarOrganizaciones(lista, true);
		}
		
	}
		
	private void registrarOrganizacion(){
		organizacion =  new Organizacion();
		
		organizacion.setNombre(txtNombre.getValue().toString());
		organizacion.setNroIntegrantes(new BigDecimal(this.txtIntegrantes.getValue().toString()));
		organizacion.setDescripcion(txtDescripcion.getValue().toString());
		organizacion.setZonaOperacion(txtZonaOperacion.getValue().toString());
		organizacion.setUbicacionActivos(txtUbicacionAct.getValue().toString());
		organizacion.setCreacion(new Date());
		organizacionService.crear(organizacion);
		
	}
	
	private void actualizaOrganizacion(){
		Usuario usuario = HarecUtil.obtenerUsuarioSesion();
				
		organizacion.setNombre(txtNombre.getValue().toString());
		organizacion.setDescripcion(txtDescripcion.getValue().toString());
		organizacion.setZonaOperacion(txtZonaOperacion.getValue().toString());
		
		organizacion.setCreador(usuario);
		organizacion.setCreacion(new Date());
		organizacion.setEdicion(new Date());
		organizacion.setEditor(usuario);
		
		organizacionService.actualizar(organizacion);
		
	}
	
	private void cargarOrganizaciones(List<Organizacion> listOrganizacion, boolean flagLimpiar){
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("id", Long.class,  null);

		container.addContainerProperty("nombre", String.class, null);
		container.addContainerProperty("descripcion", String.class, null);
		
		
		tblOrganizaciones.setContainerDataSource(container);
		tblOrganizaciones.setVisibleColumns(new Object[]{"nombre", "descripcion"});
	
		tblOrganizaciones.setColumnWidth("nombre", 150);
		tblOrganizaciones.setColumnWidth("descripcion", 250);
			
		tblOrganizaciones.setColumnHeader("nombre", "Organización");
		tblOrganizaciones.setColumnHeader("descripcion", "Descripción");

				
		int con=1;
		for (Organizacion o: listOrganizacion){
			Item item = container.addItem(con++);
			item.getItemProperty("id").setValue(o.getId());
			item.getItemProperty("nombre").setValue(o.getNombre() != null ? o.getNombre() : "" );
			item.getItemProperty("descripcion").setValue(o.getDescripcion() != null ? o.getDescripcion() : "");
			//item.getItemProperty("zonaOperacion").setValue(o.getZonaOperacion() != null ? o.getZonaOperacion() : "");
		}
		
		if(flagLimpiar){
			txtDescripcion.setValue("");
			txtNombre.setValue("");
			txtZonaOperacion.setValue("");
			txtIntegrantes.setValue("");
			txtUbicacionAct.setValue("");
		}
	}
	
	@Override
	public void textChange(TextChangeEvent event) {
		Organizacion o = new Organizacion();
		
		if (event.getSource().equals(this.txtNombre)) {
			o.setNombre(event.getText());
							
		}
		
		if (event.getSource().equals(this.txtDescripcion)) {		
			o.setDescripcion(event.getText());					
		}
		
		if (event.getSource().equals(this.txtZonaOperacion)) {		
			o.setZonaOperacion(event.getText());				
		}				
		
		List<Organizacion> lista = organizacionService.buscar(o);
		cargarOrganizaciones(lista, false);
		
	}
	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(true);
		
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
		pnlPrincipal.setImmediate(false);
		pnlPrincipal.setWidth("800px");
		pnlPrincipal.setHeight("320px");
		pnlPrincipal.setMargin(true);
		pnlPrincipal.setSpacing(true);
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		pnlPrincipal.addComponent(horizontalLayout_2);
		
		// horizontalLayout_3
		horizontalLayout_3 = buildHorizontalLayout_3();
		pnlPrincipal.addComponent(horizontalLayout_3);
		
		// verticalLayout_2
		verticalLayout_2 = buildVerticalLayout_2();
		pnlPrincipal.addComponent(verticalLayout_2);
		
		return pnlPrincipal;
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
		
		// txtNombre
		txtNombre = new TextField();
		txtNombre.setCaption("Nombre");
		txtNombre.setImmediate(false);
		txtNombre.setWidth("-1px");
		txtNombre.setHeight("-1px");
		horizontalLayout_2.addComponent(txtNombre);
		
		// txtIntegrantes
		txtIntegrantes = new TextField();
		txtIntegrantes.setCaption("# Integrantes");
		txtIntegrantes.setImmediate(false);
		txtIntegrantes.setWidth("-1px");
		txtIntegrantes.setHeight("-1px");
		horizontalLayout_2.addComponent(txtIntegrantes);
		
		// txtZonaOperacion
		txtZonaOperacion = new TextField();
		txtZonaOperacion.setCaption("Zona Operación");
		txtZonaOperacion.setImmediate(false);
		txtZonaOperacion.setWidth("-1px");
		txtZonaOperacion.setHeight("-1px");
		horizontalLayout_2.addComponent(txtZonaOperacion);
		
		// txtUbicacionAct
		txtUbicacionAct = new TextField();
		txtUbicacionAct.setCaption("Ubicación Activos");
		txtUbicacionAct.setImmediate(false);
		txtUbicacionAct.setWidth("-1px");
		txtUbicacionAct.setHeight("-1px");
		horizontalLayout_2.addComponent(txtUbicacionAct);
		
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
		
		// txtDescripcion
		txtDescripcion = new TextArea();
		txtDescripcion.setCaption("Descripción");
		txtDescripcion.setImmediate(false);
		txtDescripcion.setWidth("400px");
		txtDescripcion.setHeight("60px");
		horizontalLayout_3.addComponent(txtDescripcion);
		
		// btnBuscar
		btnBuscar = new Button();
		btnBuscar.setCaption("Buscar");
		btnBuscar.setImmediate(true);
		btnBuscar.setWidth("-1px");
		btnBuscar.setHeight("-1px");
		horizontalLayout_3.addComponent(btnBuscar);
		horizontalLayout_3.setComponentAlignment(btnBuscar, new Alignment(24));
		
		// btnNuevo
		btnNuevo = new Button();
		btnNuevo.setCaption("Nuevo");
		btnNuevo.setImmediate(true);
		btnNuevo.setWidth("-1px");
		btnNuevo.setHeight("-1px");
		horizontalLayout_3.addComponent(btnNuevo);
		horizontalLayout_3.setComponentAlignment(btnNuevo, new Alignment(24));
		
		return horizontalLayout_3;
	}
	@AutoGenerated
	private VerticalLayout buildVerticalLayout_2() {
		// common part: create layout
		verticalLayout_2 = new VerticalLayout();
		verticalLayout_2.setImmediate(false);
		verticalLayout_2.setWidth("-1px");
		verticalLayout_2.setHeight("-1px");
		verticalLayout_2.setMargin(false);
		verticalLayout_2.setSpacing(true);
		
		// tblOrganizaciones
		tblOrganizaciones = new Table();
		tblOrganizaciones.setImmediate(false);
		tblOrganizaciones.setWidth("592px");
		tblOrganizaciones.setHeight("120px");
		verticalLayout_2.addComponent(tblOrganizaciones);
		
		return verticalLayout_2;
	}

}
