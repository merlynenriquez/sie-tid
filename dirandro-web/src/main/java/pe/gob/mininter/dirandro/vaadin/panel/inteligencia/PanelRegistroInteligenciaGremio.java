package pe.gob.mininter.dirandro.vaadin.panel.inteligencia;

import pe.gob.mininter.dirandro.model.DetGremioCocalero;
import pe.gob.mininter.dirandro.model.GremioCocalero;
import pe.gob.mininter.dirandro.model.Inteligencia;
import pe.gob.mininter.dirandro.service.GremioService;
import pe.gob.mininter.dirandro.vaadin.panel.util.PanelAgregarGremio;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.AbstractSelect.Filtering;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class PanelRegistroInteligenciaGremio extends CustomComponent  implements ClickListener{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlPrincipal;
	@AutoGenerated
	private Table tblGremio;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private Button btnAgregar;
	@AutoGenerated
	private Button btnNuevo;
	@AutoGenerated
	private ComboBox cmbGremio;
	@AutoGenerated
	private Label label_1;
	
	private IndexedContainer container;
	private Inteligencia inteligencia;
	private DetGremioCocalero detalleGremio;
	
	private boolean inicializado=false;
	private GremioService gremioService;
	
	private PanelAgregarGremio panelAgregarGremio;
	
	public Inteligencia getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(Inteligencia inteligencia) {
		this.inteligencia = inteligencia;
		System.out.println("seteada inteligencia");
		postConstruct();
	}

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelRegistroInteligenciaGremio() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		gremioService = Injector.obtenerServicio(GremioService.class);
		postConstruct();
	}

	private void postConstruct(){
		if(inteligencia!=null && !inteligencia.esNuevo() && !inicializado){
			
			cmbGremio.setInputPrompt("Gremio Cocalero");
			cmbGremio.setItemCaptionPropertyId("nombre");
			actualizaListaGremios(); 
			
			tblGremio.setSelectable(true);
			tblGremio.setImmediate(true);
			tblGremio.setNullSelectionAllowed(true);
			tblGremio.setNullSelectionItemId(null);
			tblGremio.addListener(new ValueChangeListener() {
				
				private static final long serialVersionUID = -3416533772693474159L;
	
				@Override
				public void valueChange(ValueChangeEvent event) {
					boolean esModoNuevo = tblGremio.getValue() == null;
					limpiar();
					habilitarEdicion(!esModoNuevo);
					if (!esModoNuevo) {
						Item item = tblGremio.getItem(tblGremio.getValue());
//						casoVehiculo.setId((Long) item.getItemProperty("id").getValue());
//						txtTipodeUso.setValue(item.getItemProperty("tipoUso").getValue() != null ? item.getItemProperty("tipoUso").getValue().toString() : StringUtils.EMPTY);
//						txaObservacion.setValue(item.getItemProperty("observacion").getValue() != null ? item.getItemProperty("observacion").getValue().toString() : StringUtils.EMPTY);
//						
//						cmbEstadoDato.select(new Valor((Long) item.getItemProperty("estado.id").getValue()));
//						cmbVehVehiculo.select(new Vehiculo((Long)item.getItemProperty("vehiculo.id").getValue()));
//						cmbPropietario.select(new Persona((Long)item.getItemProperty("propietario.id").getValue()));
//						cmbParticipacion.select(new Valor((Long) item.getItemProperty("participacion.id").getValue()));
					}
				}
			});
			
			btnAgregar.addListener((ClickListener)this);
			btnNuevo.addListener((ClickListener)this);
			
			limpiar();
			habilitarEdicion(false);
			inicializado=true;
			
		}
	}
		
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnAgregar)) {
		
			return;
		}
		if(event.getButton().equals(btnNuevo)) {
			panelAgregarGremio = new PanelAgregarGremio();

			Window window=new Window(){
				
				private static final long serialVersionUID = 1L;

				  protected void close() {
					  getApplication().getMainWindow().removeWindow(getWindow());
				  }
				  @Override
					public void detach() {
					  
					  actualizaListaGremios();
					  if(panelAgregarGremio.getGremioCocalero()!=null)
							cmbGremio.select(panelAgregarGremio.getGremioCocalero());
						
					}
			};
			window.setCaption("Registrar Gremio");
			window.addComponent(panelAgregarGremio);
			window.setModal(true);
			window.setResizable(false);
			window.setWidth("550px");
			window.setHeight("-1px");
			getApplication().getMainWindow().addWindow(window);

			return;
		}
	}

	public void actualizaListaGremios() {
		cmbGremio.setContainerDataSource(new BeanItemContainer<GremioCocalero>(GremioCocalero.class,  gremioService.buscar(null)));
		cmbGremio.setItemCaptionPropertyId("nombre");
		cmbGremio.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
		cmbGremio.setImmediate(true);
	}
	
	private void limpiar(){
		detalleGremio = new DetGremioCocalero();
		detalleGremio.setInteligencia(inteligencia);
		cmbGremio.select(null);
	}
	
	private void habilitarEdicion(boolean flag){
		if(flag){
			btnAgregar.setCaption("Actualizar");
		}
		else{
			btnAgregar.setCaption("Registrar");
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
		
		// label_1
		label_1 = new Label();
		label_1.setImmediate(false);
		label_1.setWidth("-1px");
		label_1.setHeight("-1px");
		label_1.setValue("Referencia del Documento Inteligencia:");
		pnlPrincipal.addComponent(label_1);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		pnlPrincipal.addComponent(horizontalLayout_1);
		
		// tblGremio
		tblGremio = new Table();
		tblGremio.setImmediate(false);
		tblGremio.setWidth("600px");
		tblGremio.setHeight("200px");
		pnlPrincipal.addComponent(tblGremio);
		
		return pnlPrincipal;
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
		
		// cmbGremio
		cmbGremio = new ComboBox();
		cmbGremio.setImmediate(false);
		cmbGremio.setWidth("-1px");
		cmbGremio.setHeight("-1px");
		horizontalLayout_1.addComponent(cmbGremio);
		
		// btnNuevo
		btnNuevo = new Button();
		btnNuevo.setCaption("Nuevo");
		btnNuevo.setImmediate(true);
		btnNuevo.setWidth("-1px");
		btnNuevo.setHeight("-1px");
		horizontalLayout_1.addComponent(btnNuevo);
		
		// btnAgregar
		btnAgregar = new Button();
		btnAgregar.setCaption("Agregar");
		btnAgregar.setImmediate(true);
		btnAgregar.setWidth("-1px");
		btnAgregar.setHeight("-1px");
		horizontalLayout_1.addComponent(btnAgregar);
		
		return horizontalLayout_1;
	}

}
