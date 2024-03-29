package pe.gob.mininter.dirandro.vaadin.panel.caso;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.Caso;
import pe.gob.mininter.dirandro.model.DetCasoVehiculo;
import pe.gob.mininter.dirandro.model.Persona;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.model.Vehiculo;
import pe.gob.mininter.dirandro.service.CasoVehiculoService;
import pe.gob.mininter.dirandro.service.PersonaService;
import pe.gob.mininter.dirandro.service.VehiculoService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;
import pe.gob.mininter.dirandro.vaadin.dialogs.AlertDialog;
import pe.gob.mininter.dirandro.vaadin.panel.util.PanelAgregarVehiculo;
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
import com.vaadin.ui.Window;

public class PanelRegistroCasoVehiculo extends CustomComponent implements ClickListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	
	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlVehiculosBody;
	@AutoGenerated
	private Table tblVehLista;
	@AutoGenerated
	private Button btnRegistrarDetalle;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private TextArea txaObservacion;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_44;
	@AutoGenerated
	private TextField txtTipodeUso;
	@AutoGenerated
	private ComboBoxLOVS cmbParticipacion;
	@AutoGenerated
	private HorizontalLayout pnlVehiculosBody2;
	@AutoGenerated
	private ComboBoxLOVS cmbEstadoDato;
	@AutoGenerated
	private ComboBox cmbPropietario;
	@AutoGenerated
	private HorizontalLayout pnlVehiculosBody1;
	@AutoGenerated
	private Button btnVehRegistrar;
	@AutoGenerated
	private ComboBox cmbVehVehiculo;
	private static final long serialVersionUID = -4639683924066371051L;

	private Caso caso;
	private CasoVehiculoService casoVehiculoService;
	private VehiculoService vehiculoService;
	private PersonaService personaService;
	
	private PanelAgregarVehiculo pnlAgregarVehiculo;
	private Vehiculo vehiculoPopUp;
	private List<Persona> lstPersonas;
	private List<Vehiculo> lstVehiculos;
	private DetCasoVehiculo casoVehiculo;
	private boolean inicializado=false;
	
	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
		postConstruct();
	}

	public PanelRegistroCasoVehiculo() {
		super();
		vehiculoService = Injector.obtenerServicio(VehiculoService.class);
		casoVehiculoService = Injector.obtenerServicio(CasoVehiculoService.class);
		personaService = Injector.obtenerServicio(PersonaService.class);
		buildMainLayout();
		setCompositionRoot(mainLayout);
		postConstruct();
	}
	
	public void setVehiculoPopUp(Vehiculo vehiculoPopUp) {
		this.vehiculoPopUp = vehiculoPopUp;
	}

	public void postConstruct() {
		if(caso!=null && !caso.esNuevo() && !inicializado){
			habilitarEdicion(false);
			cmbVehVehiculo.setInputPrompt("Busqueda de Vehículo por Placa");
			cmbPropietario.setInputPrompt("Propietario del Vehiculo");
			cmbEstadoDato.setInputPrompt("Estado del Dato");
			cmbEstadoDato.setRequired(true);
			
			cmbEstadoDato.setCodigoLista(Constante.LISTA.CODIGO.TIPO_EST_DATO);
			
			cmbEstadoDato.attach();
			
			lstVehiculos = vehiculoService.buscar(null);
			actualizarVehiculo(lstVehiculos);
			btnVehRegistrar.addListener((ClickListener)this);
			btnRegistrarDetalle.addListener((ClickListener)this);
			lstPersonas =  personaService.buscar(null);
			cargarPropietarios(lstPersonas);
			cargarExpVehiculos();
			

			tblVehLista.setSelectable(true);
			tblVehLista.setImmediate(true);
			tblVehLista.setNullSelectionAllowed(true);
			tblVehLista.setNullSelectionItemId(null);
			tblVehLista.addListener(new ValueChangeListener() {
				
				private static final long serialVersionUID = -3416533772693474159L;
	
				@Override
				public void valueChange(ValueChangeEvent event) {
					boolean esModoNuevo = tblVehLista.getValue() == null;
					limpiar();
					habilitarEdicion(!esModoNuevo);
					if (!esModoNuevo) {
						Item item = tblVehLista.getItem(tblVehLista.getValue());
						casoVehiculo.setId((Long) item.getItemProperty("id").getValue());
						txtTipodeUso.setValue(item.getItemProperty("tipoUso").getValue() != null ? item.getItemProperty("tipoUso").getValue().toString() : StringUtils.EMPTY);
						txaObservacion.setValue(item.getItemProperty("observacion").getValue() != null ? item.getItemProperty("observacion").getValue().toString() : StringUtils.EMPTY);
						
						cmbEstadoDato.select(new Valor((Long) item.getItemProperty("estado.id").getValue()));
						cmbVehVehiculo.select(new Vehiculo((Long)item.getItemProperty("vehiculo.id").getValue()));
						cmbPropietario.select(new Persona((Long)item.getItemProperty("propietario.id").getValue()));
						cmbParticipacion.select(new Valor((Long) item.getItemProperty("participacion.id").getValue()));
					}
				}
			});
			inicializado=true;
		}
	}
	
	private void cargarPropietarios(List<Persona> lstPropietarios){
		cmbPropietario.setContainerDataSource(new BeanItemContainer<Persona>(Persona.class,  lstPropietarios));
		cmbPropietario.setItemCaptionPropertyId("nombreCompleto");
		cmbPropietario.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
		cmbPropietario.setImmediate(true);
	}
	
	private void cargarExpVehiculos(){
		limpiar();
		DetCasoVehiculo det = new DetCasoVehiculo();
		det.setCaso(caso);
		List<DetCasoVehiculo> lstExpVehiculos = casoVehiculoService.buscar(det);
		cargarExpVehiculos(lstExpVehiculos);
	}
	
	private void cargarExpVehiculos(List<DetCasoVehiculo> lstExpVehiculos) {
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("id", Long.class,  null);
		container.addContainerProperty("vehiculo.id", Long.class, null);		
		container.addContainerProperty("vehiculo.placa", String.class, null);
		container.addContainerProperty("vehiculo.tipoTamano", String.class, null);
		container.addContainerProperty("vehiculo.fabricacion", String.class, null);
		container.addContainerProperty("estado.id", Long.class, null);
		container.addContainerProperty("estado.nombre", String.class, null);
		container.addContainerProperty("tipoUso", String.class, null);
		container.addContainerProperty("observacion", String.class, null);
		container.addContainerProperty("propietario.id", Long.class, null);
		container.addContainerProperty("propietario.nombre", String.class, null);
		container.addContainerProperty("participacion.id", Long.class, null);
		container.addContainerProperty("participacion.nombre", String.class, null);
		
		tblVehLista.setContainerDataSource(container);
		tblVehLista.setVisibleColumns(new Object[]{"id","vehiculo.placa","vehiculo.tipoTamano","vehiculo.fabricacion","estado.nombre","propietario.nombre","participacion.nombre"});
		
		tblVehLista.setColumnHeader("id", "Id");
		tblVehLista.setColumnHeader("vehiculo.placa", "Placa");
		tblVehLista.setColumnHeader("vehiculo.tipoTamano", "Tamaño");
		tblVehLista.setColumnHeader("vehiculo.fabricacion", "Fabricación");
		tblVehLista.setColumnHeader("estado.nombre", "Estado del Dato");
		tblVehLista.setColumnHeader("propietario.nombre", "Propietario");
		tblVehLista.setColumnHeader("participacion.nombre", "Participacion");
		
		int con=1;
		for (DetCasoVehiculo casoVehiculo : lstExpVehiculos){
			Item item = container.addItem(con++);
			item.getItemProperty("id").setValue(casoVehiculo.getId());
			//item.getItemProperty("vehiculo").setValue(casoVehiculo.getVehiculo());
			item.getItemProperty("vehiculo.id").setValue(casoVehiculo.getVehiculo() != null ? casoVehiculo.getVehiculo().getId() : null);
			item.getItemProperty("vehiculo.placa").setValue(casoVehiculo.getVehiculo().getPlaca());
			item.getItemProperty("vehiculo.tipoTamano").setValue(HarecUtil.valorNombreToEmpty(casoVehiculo.getVehiculo().getTipoTamano()));
			item.getItemProperty("vehiculo.fabricacion").setValue(HarecUtil.valorNombreToEmpty(casoVehiculo.getVehiculo().getPeriodoFabricacion()));
			item.getItemProperty("estado.id").setValue(HarecUtil.valorIdToEmpty(casoVehiculo.getEstadoDato()));
			item.getItemProperty("estado.nombre").setValue(HarecUtil.valorNombreToEmpty(casoVehiculo.getEstadoDato()));
			item.getItemProperty("tipoUso").setValue(casoVehiculo.getTipoUso());
			item.getItemProperty("observacion").setValue(casoVehiculo.getObservacion());
			if(casoVehiculo.getPropietario()!=null){
				item.getItemProperty("propietario.id").setValue(casoVehiculo.getPropietario().getId());
				item.getItemProperty("propietario.nombre").setValue(casoVehiculo.getPropietario().getNombreCompleto());
			}
			if(casoVehiculo.getParticipacion()!=null){
				item.getItemProperty("participacion.id").setValue(HarecUtil.valorIdToEmpty(casoVehiculo.getParticipacion()));
				item.getItemProperty("participacion.nombre").setValue(HarecUtil.valorNombreToEmpty(casoVehiculo.getParticipacion()));
			}
		}
			
	}
	
	//** Acciones **//	
	@Override
	public void buttonClick(ClickEvent event) {
		if (event.getButton().equals(btnVehRegistrar)) {
			pnlAgregarVehiculo = new PanelAgregarVehiculo();

			Window window=new Window(){
				
				private static final long serialVersionUID = 1L;

				  protected void close() {
					  getApplication().getMainWindow().removeWindow(getWindow());
				  }
				  @Override
					public void detach() {
					  if(pnlAgregarVehiculo.getVehiculo()!=null)
							setVehiculoPopUp(pnlAgregarVehiculo.getVehiculo());
						actualizarVehiculo(vehiculoService.buscar(null));
					}
			};
			window.setCaption("Registrar Vehículo");
			window.addComponent(pnlAgregarVehiculo);
			window.setModal(true);
			window.setResizable(false);
			window.setWidth("550px");
			window.setHeight("-1px");
			getApplication().getMainWindow().addWindow(window);
		}
		if (event.getButton().equals(btnRegistrarDetalle)) {
			
			//TODO: Cambiar para el pase de produccion
			casoVehiculo.setVehiculo((Vehiculo) cmbVehVehiculo.getValue());
			casoVehiculo.setEstadoDato((Valor) cmbEstadoDato.getValue());
			casoVehiculo.setPropietario((Persona) cmbPropietario.getValue());
			casoVehiculo.setObservacion(txaObservacion.getValue() != null ? txaObservacion.getValue().toString() : StringUtils.EMPTY);
			casoVehiculo.setTipoUso(txtTipodeUso.getValue() != null ? txtTipodeUso.getValue().toString() : StringUtils.EMPTY);
			
			if (casoVehiculo.esNuevo()) {
				casoVehiculoService.crear(casoVehiculo);
			} else{
				casoVehiculoService.actualizar(casoVehiculo);
			}
			
			AlertDialog alertDialog = new  AlertDialog("Registro de Vehículo", "Se ha registrado el vehículo correctamente", "Aceptar", "400");
			getApplication().getMainWindow().addWindow(alertDialog);
			cargarExpVehiculos();
		}
	}
	
	//** Utilitarios **//	
	public void actualizarVehiculo(List<Vehiculo> lstVehiculos) {
		cmbVehVehiculo.setContainerDataSource(new BeanItemContainer<Vehiculo>(Vehiculo.class,  lstVehiculos));
		cmbVehVehiculo.setItemCaptionPropertyId("placa");
		cmbVehVehiculo.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
		cmbVehVehiculo.setImmediate(true);
		
		if (vehiculoPopUp != null) {
			for (Vehiculo vehiculo : lstVehiculos) {
				if (vehiculo.getId().equals(vehiculoPopUp.getId())){
					cmbVehVehiculo.select(vehiculo);
					break;
				}
			}
		}
	}
	
	private void habilitarEdicion(boolean flag){
		if(flag){
			btnRegistrarDetalle.setCaption("Actualizar");
		}
		else{
			btnRegistrarDetalle.setCaption("Registrar");
		}
	}

	private void limpiar(){
		casoVehiculo = new DetCasoVehiculo();
		casoVehiculo.setCaso(caso);
		
		cmbVehVehiculo.select(null);
		cmbEstadoDato.select(null);
		cmbPropietario.select(null);
		txaObservacion.setValue("");
		txtTipodeUso.setValue("");
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("-1px");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("-1px");
		setHeight("-1px");
		
		// pnlVehiculosBody
		pnlVehiculosBody = buildPnlVehiculosBody();
		mainLayout.addComponent(pnlVehiculosBody);
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildPnlVehiculosBody() {
		// common part: create layout
		pnlVehiculosBody = new VerticalLayout();
		pnlVehiculosBody.setImmediate(false);
		pnlVehiculosBody.setWidth("-1px");
		pnlVehiculosBody.setHeight("-1px");
		pnlVehiculosBody.setMargin(true);
		pnlVehiculosBody.setSpacing(true);
		
		// pnlVehiculosBody1
		pnlVehiculosBody1 = buildPnlVehiculosBody1();
		pnlVehiculosBody.addComponent(pnlVehiculosBody1);
		
		// pnlVehiculosBody2
		pnlVehiculosBody2 = buildPnlVehiculosBody2();
		pnlVehiculosBody.addComponent(pnlVehiculosBody2);
		
		// horizontalLayout_44
		horizontalLayout_44 = buildHorizontalLayout_44();
		pnlVehiculosBody.addComponent(horizontalLayout_44);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		pnlVehiculosBody.addComponent(horizontalLayout_1);
		
		// btnRegistrarDetalle
		btnRegistrarDetalle = new Button();
		btnRegistrarDetalle.setCaption("Registrar");
		btnRegistrarDetalle.setImmediate(true);
		btnRegistrarDetalle.setWidth("-1px");
		btnRegistrarDetalle.setHeight("-1px");
		pnlVehiculosBody.addComponent(btnRegistrarDetalle);
		pnlVehiculosBody.setComponentAlignment(btnRegistrarDetalle,
				new Alignment(20));
		
		// tblVehLista
		tblVehLista = new Table();
		tblVehLista.setImmediate(false);
		tblVehLista.setWidth("900px");
		tblVehLista.setHeight("350px");
		pnlVehiculosBody.addComponent(tblVehLista);
		pnlVehiculosBody.setComponentAlignment(tblVehLista, new Alignment(20));
		
		return pnlVehiculosBody;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlVehiculosBody1() {
		// common part: create layout
		pnlVehiculosBody1 = new HorizontalLayout();
		pnlVehiculosBody1.setImmediate(false);
		pnlVehiculosBody1.setWidth("-1px");
		pnlVehiculosBody1.setHeight("-1px");
		pnlVehiculosBody1.setMargin(false);
		pnlVehiculosBody1.setSpacing(true);
		
		// cmbVehVehiculo
		cmbVehVehiculo = new ComboBox();
		cmbVehVehiculo.setCaption("Vehículo");
		cmbVehVehiculo.setImmediate(false);
		cmbVehVehiculo.setWidth("250px");
		cmbVehVehiculo.setHeight("-1px");
		cmbVehVehiculo.setRequired(true);
		pnlVehiculosBody1.addComponent(cmbVehVehiculo);
		
		// btnVehRegistrar
		btnVehRegistrar = new Button();
		btnVehRegistrar.setCaption("Agregar");
		btnVehRegistrar.setImmediate(true);
		btnVehRegistrar.setWidth("-1px");
		btnVehRegistrar.setHeight("-1px");
		pnlVehiculosBody1.addComponent(btnVehRegistrar);
		pnlVehiculosBody1.setComponentAlignment(btnVehRegistrar, new Alignment(
				9));
		
		return pnlVehiculosBody1;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlVehiculosBody2() {
		// common part: create layout
		pnlVehiculosBody2 = new HorizontalLayout();
		pnlVehiculosBody2.setImmediate(false);
		pnlVehiculosBody2.setWidth("-1px");
		pnlVehiculosBody2.setHeight("-1px");
		pnlVehiculosBody2.setMargin(false);
		pnlVehiculosBody2.setSpacing(true);
		
		// cmbPropietario
		cmbPropietario = new ComboBox();
		cmbPropietario.setCaption("Propietario");
		cmbPropietario.setImmediate(false);
		cmbPropietario.setWidth("250px");
		cmbPropietario.setHeight("-1px");
		pnlVehiculosBody2.addComponent(cmbPropietario);
		
		// cmbEstadoDato
		cmbEstadoDato = new ComboBoxLOVS();
		cmbEstadoDato.setCaption("Estado del Dato");
		cmbEstadoDato.setImmediate(false);
		cmbEstadoDato.setWidth("180px");
		cmbEstadoDato.setHeight("-1px");
		pnlVehiculosBody2.addComponent(cmbEstadoDato);
		
		return pnlVehiculosBody2;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_44() {
		// common part: create layout
		horizontalLayout_44 = new HorizontalLayout();
		horizontalLayout_44.setImmediate(false);
		horizontalLayout_44.setWidth("-1px");
		horizontalLayout_44.setHeight("-1px");
		horizontalLayout_44.setMargin(false);
		horizontalLayout_44.setSpacing(true);
		
		// cmbParticipacion
		cmbParticipacion = new ComboBoxLOVS();
		cmbParticipacion.setCaption("Participación");
		cmbParticipacion.setImmediate(false);
		cmbParticipacion.setWidth("210px");
		cmbParticipacion.setHeight("-1px");
		horizontalLayout_44.addComponent(cmbParticipacion);
		
		// txtTipodeUso
		txtTipodeUso = new TextField();
		txtTipodeUso.setCaption("Tipo de uso");
		txtTipodeUso.setImmediate(false);
		txtTipodeUso.setWidth("300px");
		txtTipodeUso.setHeight("-1px");
		txtTipodeUso.setInputPrompt("Tipo de Uso del Vehiculo");
		horizontalLayout_44.addComponent(txtTipodeUso);
		
		return horizontalLayout_44;
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
		
		// txaObservacion
		txaObservacion = new TextArea();
		txaObservacion.setCaption("Observaciones");
		txaObservacion.setImmediate(false);
		txaObservacion.setWidth("900px");
		txaObservacion.setHeight("70px");
		txaObservacion
				.setInputPrompt("Observaciones Adicionales al Vehículo Intervenido");
		horizontalLayout_1.addComponent(txaObservacion);
		
		return horizontalLayout_1;
	}

}
