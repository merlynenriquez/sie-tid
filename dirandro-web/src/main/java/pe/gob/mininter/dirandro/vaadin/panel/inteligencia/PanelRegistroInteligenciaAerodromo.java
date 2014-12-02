package pe.gob.mininter.dirandro.vaadin.panel.inteligencia;

import java.util.List;

import pe.gob.mininter.dirandro.model.Aerodromo;
import pe.gob.mininter.dirandro.model.DetAerodromo;
import pe.gob.mininter.dirandro.model.Inteligencia;
import pe.gob.mininter.dirandro.service.AerodromoService;
import pe.gob.mininter.dirandro.service.DetAerodromoService;
import pe.gob.mininter.dirandro.vaadin.panel.util.PanelAgregarAerodromo;
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
public class PanelRegistroInteligenciaAerodromo extends CustomComponent implements ClickListener{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlPrincipal;
	@AutoGenerated
	private Table tblAerodromo;
	@AutoGenerated
	private HorizontalLayout lytFormulario;
	@AutoGenerated
	private Button btnAgregar;
	@AutoGenerated
	private Button btnNuevo;
	@AutoGenerated
	private ComboBox cmbAerodromo;
	private DetAerodromoService detAerodromoService;
	private AerodromoService aerodromoService;
	
	private Inteligencia inteligencia;
	
	public static final String COLUMNA_NOMBRE = "nombre";
	public static final String COLUMNA_EMPRESA = "empresa";
	public static final String COLUMNA_AERONAVE_MAXIMA = "aeronaveMaxima";
	public static final String COLUMNA_UBICACION = "ubicacion";
	public static final String COLUMNA_OPCION = "opcion";
	
	public Inteligencia getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(Inteligencia inteligencia) {
		this.inteligencia = inteligencia;
	}

	public PanelRegistroInteligenciaAerodromo() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		detAerodromoService=Injector.obtenerServicio(DetAerodromoService.class);
		aerodromoService=Injector.obtenerServicio(AerodromoService.class);
		postConstruct();
	}

	public void postConstruct(){
		
		actualizaListaAerodromo();
		
		btnNuevo.addListener(this);
		btnAgregar.addListener(this);
		
		cargarDatos();
		
	}
	
	private void cargarDatos(){
		DetAerodromo detAerodromoBuscar=new DetAerodromo();
		detAerodromoBuscar.setIntInteligencia(inteligencia);
		List<DetAerodromo> detAerodromos=detAerodromoService.buscar(detAerodromoBuscar);
		
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty(COLUMNA_NOMBRE, String.class,  null);
        container.addContainerProperty(COLUMNA_EMPRESA, String.class,  null);
        container.addContainerProperty(COLUMNA_AERONAVE_MAXIMA, String.class,  null);
        container.addContainerProperty(COLUMNA_UBICACION, String.class,  null);
        container.addContainerProperty(COLUMNA_OPCION, Button.class,  null);
        
        int con=1;
		for (final DetAerodromo detAerodromo : detAerodromos) {
			Item item=container.addItem(con++);
			item.getItemProperty(COLUMNA_NOMBRE).setValue(detAerodromo.getIntAerodromo().getNombre());
			item.getItemProperty(COLUMNA_EMPRESA).
			setValue(detAerodromo.getIntAerodromo().getEmpresa()==null?null:detAerodromo.getIntAerodromo().getEmpresa().getRazonSocial());
			item.getItemProperty(COLUMNA_AERONAVE_MAXIMA).
			setValue(detAerodromo.getIntAerodromo().getAeronaveMaxima()==null?null:detAerodromo.getIntAerodromo().getAeronaveMaxima().getNombre());
			item.getItemProperty(COLUMNA_UBICACION).
			setValue(detAerodromo.getIntAerodromo().getUbicacion()==null?null:detAerodromo.getIntAerodromo().getUbicacion().getNombreCompleto());
			Button eliminar=new Button();
			eliminar.setCaption("Eliminar");
			eliminar.addListener(new ClickListener() {
				
				@Override
				public void buttonClick(ClickEvent event) {
					detAerodromoService.eliminar(detAerodromo);
					cargarDatos();
				}
			});
			item.getItemProperty(COLUMNA_OPCION).
			setValue(eliminar);
		}
        
        tblAerodromo.setContainerDataSource(container);
        tblAerodromo.setVisibleColumns(new Object[]{COLUMNA_NOMBRE, COLUMNA_EMPRESA, COLUMNA_AERONAVE_MAXIMA, COLUMNA_UBICACION, COLUMNA_OPCION});
        tblAerodromo.setColumnWidth(COLUMNA_NOMBRE, 100);
        tblAerodromo.setColumnWidth(COLUMNA_EMPRESA, 100);
        tblAerodromo.setColumnWidth(COLUMNA_AERONAVE_MAXIMA, 100);
        tblAerodromo.setColumnWidth(COLUMNA_UBICACION, 100);
        tblAerodromo.setColumnWidth(COLUMNA_OPCION, 100);
        tblAerodromo.setColumnHeader(COLUMNA_NOMBRE, "Nombre");
        tblAerodromo.setColumnHeader(COLUMNA_EMPRESA, "Empresa");
        tblAerodromo.setColumnHeader(COLUMNA_AERONAVE_MAXIMA, "Aeronave Maxima");
        tblAerodromo.setColumnHeader(COLUMNA_UBICACION, "Ubicacion");
        tblAerodromo.setColumnHeader(COLUMNA_OPCION, "Opcion");
	}
	
	public void actualizaListaAerodromo() {
		List<Aerodromo> aerodromos=aerodromoService.buscar(null);
		cmbAerodromo.setInputPrompt("Aerodromo");
		cmbAerodromo.setItemCaptionPropertyId("nombre");
		cmbAerodromo.setContainerDataSource(new BeanItemContainer<Aerodromo>(Aerodromo.class,  aerodromos));
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnAgregar)){
			if(cmbAerodromo.getValue()!=null){
				DetAerodromo detAerodromo=new DetAerodromo();
				detAerodromo.setIntInteligencia(inteligencia);
				detAerodromo.setIntAerodromo((Aerodromo)cmbAerodromo.getValue());
				detAerodromoService.crear(detAerodromo);
				cmbAerodromo.setValue(null);
				cargarDatos();
			}
		}
		if(event.getButton().equals(btnNuevo)){
			final PanelAgregarAerodromo panelAgregarAerodromo = new PanelAgregarAerodromo();

			Window window=new Window(){
				
				private static final long serialVersionUID = 1L;

					protected void close() {
						getApplication().getMainWindow().removeWindow(getWindow());
					}

					@Override
					public void detach() {
						actualizaListaAerodromo();
						if(panelAgregarAerodromo.getAerodromo()!=null){
						cmbAerodromo.select(panelAgregarAerodromo.getAerodromo());
						}
				  	}
			};
			window.setCaption("Registrar Aerodromo");
			window.addComponent(panelAgregarAerodromo);
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
		
		// tblAerodromo
		tblAerodromo = new Table();
		tblAerodromo.setImmediate(false);
		tblAerodromo.setWidth("600px");
		tblAerodromo.setHeight("200px");
		pnlPrincipal.addComponent(tblAerodromo);
		
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
		
		// cmbAerodromo
		cmbAerodromo = new ComboBox();
		cmbAerodromo.setImmediate(false);
		cmbAerodromo.setWidth("-1px");
		cmbAerodromo.setHeight("-1px");
		lytFormulario.addComponent(cmbAerodromo);
		
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
