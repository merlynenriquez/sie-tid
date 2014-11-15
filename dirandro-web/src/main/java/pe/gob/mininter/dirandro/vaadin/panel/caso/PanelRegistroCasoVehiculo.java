package pe.gob.mininter.dirandro.vaadin.panel.caso;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.Caso;
import pe.gob.mininter.dirandro.model.DetPerVehExp;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.Persona;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.model.Vehiculo;
import pe.gob.mininter.dirandro.service.ExpedienteVehiculoService;
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
	private TextField txtPlacaMontada;
	@AutoGenerated
	private ComboBoxLOVS cmbSituacion;
	@AutoGenerated
	private ComboBoxLOVS cmbEstado;
	@AutoGenerated
	private HorizontalLayout pnlVehiculosBody2;
	@AutoGenerated
	private ComboBoxLOVS cmbEstadoMotor;
	@AutoGenerated
	private ComboBoxLOVS cmbEstadoChasis;
	@AutoGenerated
	private ComboBox cmbPropietario;
	@AutoGenerated
	private ComboBox cmbPersonaIncautada;
	@AutoGenerated
	private HorizontalLayout pnlVehiculosBody1;
	@AutoGenerated
	private Button btnVehRegistrar;
	@AutoGenerated
	private ComboBox cmbVehVehiculo;
	private static final long serialVersionUID = -4639683924066371051L;

	private Caso caso;
	
	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
	}

	
	private ExpedienteVehiculoService expVehiculoService;
	private VehiculoService vehiculoService;
	private PersonaService personaService;
	
	private PanelAgregarVehiculo pnlAgregarVehiculo;
	private Vehiculo vehiculoPopUp;
	private Expediente expediente;
	private List<Persona> lstPersonas;
	private List<Vehiculo> lstVehiculos;
	private DetPerVehExp expVehiculo;
	private boolean inicializado=false;
	
	public PanelRegistroCasoVehiculo() {
		super();
		vehiculoService = Injector.obtenerServicio(VehiculoService.class);
		expVehiculoService = Injector.obtenerServicio(ExpedienteVehiculoService.class);
		personaService = Injector.obtenerServicio(PersonaService.class);
		buildMainLayout();
		setCompositionRoot(mainLayout);
		postConstruct();
	}
	
	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
		postConstruct();
	}

	public void setVehiculoPopUp(Vehiculo vehiculoPopUp) {
		this.vehiculoPopUp = vehiculoPopUp;
	}

	public void postConstruct() {
		if(expediente!=null && !expediente.esNuevo() && !inicializado){
			habilitarEdicion(false);
			cmbVehVehiculo.setInputPrompt("Busqueda de Vehículo por Placa");
			cmbPersonaIncautada.setInputPrompt("Persona relacionada al caso");
			cmbPropietario.setInputPrompt("Propietario del Vehiculo");
			cmbEstadoChasis.setInputPrompt("Condición del Chasis");
			cmbEstadoMotor.setInputPrompt("Condición del Motor");
			cmbEstado.setInputPrompt("Estado del Vehículo");
			cmbSituacion.setInputPrompt("Situación del Vehículo");
			cmbEstado.setRequired(true);
			cmbEstadoChasis.setRequired(true);
			cmbEstadoMotor.setRequired(true);
			cmbSituacion.setRequired(true);
			
			tblVehLista.setSelectable(true);
			tblVehLista.setImmediate(true);
			tblVehLista.setNullSelectionAllowed(true);
			tblVehLista.setNullSelectionItemId(null);
			
			cmbEstadoChasis.setCodigoLista(Constante.LISTA.CODIGO.ESTADO_OBJETOS);
			cmbEstadoMotor.setCodigoLista(Constante.LISTA.CODIGO.ESTADO_OBJETOS);
			cmbSituacion.setCodigoLista(Constante.LISTA.CODIGO.SITUACION_GENERAL);
			cmbEstado.setCodigoLista(Constante.LISTA.CODIGO.ESTADO_OBJETOS);
			
			cmbEstadoChasis.attach();
			cmbEstadoMotor.attach();
			cmbSituacion.attach();
			cmbEstado.attach();
			
			lstVehiculos = vehiculoService.buscar(null);
			actualizarVehiculo(lstVehiculos);
			btnVehRegistrar.addListener((ClickListener)this);
			btnRegistrarDetalle.addListener((ClickListener)this);
			lstPersonas =  personaService.buscar(null);
			cargarInvolucrados(lstPersonas);
			cargarPropietarios(lstPersonas);
			cargarExpVehiculos();
			
			tblVehLista.addListener(new ValueChangeListener() {
				
				private static final long serialVersionUID = -3416533772693474159L;
	
				@Override
				public void valueChange(ValueChangeEvent event) {
					boolean esModoNuevo = tblVehLista.getValue() == null;
					limpiar();
					habilitarEdicion(!esModoNuevo);
					if (!esModoNuevo) {
						Item item = tblVehLista.getItem(tblVehLista.getValue());
						expVehiculo.setId((Long) item.getItemProperty("id").getValue());
						txtPlacaMontada.setValue(item.getItemProperty("placaMontada").getValue() != null ? item.getItemProperty("placaMontada").getValue().toString() : StringUtils.EMPTY);
						txtTipodeUso.setValue(item.getItemProperty("tipoUso").getValue() != null ? item.getItemProperty("tipoUso").getValue().toString() : StringUtils.EMPTY);
						txaObservacion.setValue(item.getItemProperty("observacion").getValue() != null ? item.getItemProperty("observacion").getValue().toString() : StringUtils.EMPTY);
						
						cmbEstado.select(new Valor((Long) item.getItemProperty("estado.id").getValue()));
						cmbEstadoChasis.select(new Valor((Long) item.getItemProperty("estadoChasis.id").getValue()));
						cmbEstadoMotor.select(new Valor((Long) item.getItemProperty("estadoMotor.id").getValue()));
						cmbSituacion.select(new Valor((Long) item.getItemProperty("situacion.id").getValue()));
						cmbVehVehiculo.select((Vehiculo) item.getItemProperty("vehiculo").getValue());
						cmbPersonaIncautada.select((Persona) item.getItemProperty("personaImplicada").getValue());
						cmbPropietario.select((Persona) item.getItemProperty("propietario").getValue());
					}
				}
			});
			inicializado=true;
		}
	}
	
	private void cargarInvolucrados(List<Persona> lstInvolucrados){
		cmbPersonaIncautada.setContainerDataSource(new BeanItemContainer<Persona>(Persona.class,  lstInvolucrados));
		cmbPersonaIncautada.setItemCaptionPropertyId("nombreCompleto");
		cmbPersonaIncautada.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
		cmbPersonaIncautada.setImmediate(true);
	}
	
	private void cargarPropietarios(List<Persona> lstPropietarios){
		cmbPropietario.setContainerDataSource(new BeanItemContainer<Persona>(Persona.class,  lstPropietarios));
		cmbPropietario.setItemCaptionPropertyId("nombreCompleto");
		cmbPropietario.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
		cmbPropietario.setImmediate(true);
	}
	
	private void cargarExpVehiculos(){
		limpiar();
		List<DetPerVehExp> lstExpVehiculos = expVehiculoService.buscar(null);
		cargarExpVehiculos(lstExpVehiculos);
	}
	
	private void cargarExpVehiculos(List<DetPerVehExp> lstExpVehiculos) {
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("id", Long.class,  null);
		container.addContainerProperty("vehiculo", Vehiculo.class, null);
		container.addContainerProperty("vehiculo.id", Long.class, null);		
		container.addContainerProperty("vehiculo.placa", String.class, null);
		container.addContainerProperty("vehiculo.tipoTamano", String.class, null);
		container.addContainerProperty("vehiculo.fabricacion", String.class, null);
		container.addContainerProperty("estado.id", Long.class, null);
		container.addContainerProperty("estadoChasis.id", Long.class, null);
		container.addContainerProperty("estadoMotor.id", Long.class, null);
		container.addContainerProperty("situacion.id", Long.class, null);
		container.addContainerProperty("estadoChasis", String.class, null);
		container.addContainerProperty("estadoMotor", String.class, null);
		container.addContainerProperty("placaMontada", String.class, null);
		container.addContainerProperty("tipoUso", String.class, null);
		container.addContainerProperty("observacion", String.class, null);
		container.addContainerProperty("propietario.id", Long.class, null);
		container.addContainerProperty("propietario", Persona.class, null);
		container.addContainerProperty("personaImplicada.id", Long.class, null);
		container.addContainerProperty("personaImplicada", Persona.class, null);
		container.addContainerProperty("personaImplicada.nombre", String.class, null);
		
		tblVehLista.setContainerDataSource(container);
		tblVehLista.setVisibleColumns(new Object[]{"id","vehiculo.placa","vehiculo.tipoTamano","vehiculo.fabricacion","estadoChasis","estadoMotor","personaImplicada.nombre"});
		
		tblVehLista.setColumnHeader("id", "Id");
		tblVehLista.setColumnHeader("vehiculo.placa", "Placa");
		tblVehLista.setColumnHeader("vehiculo.tipoTamano", "Tamaño");
		tblVehLista.setColumnHeader("vehiculo.fabricacion", "Fabricación");
		tblVehLista.setColumnHeader("estadoChasis", "Estado Chasis");
		tblVehLista.setColumnHeader("estadoMotor", "Estado Motor");
		tblVehLista.setColumnHeader("personaImplicada.nombre", "Implicado");
		
		int con=1;
		for (DetPerVehExp expVehiculo : lstExpVehiculos){
			Item item = container.addItem(con++);
			item.getItemProperty("id").setValue(expVehiculo.getId());
			item.getItemProperty("vehiculo").setValue(expVehiculo.getVehiculo());
			item.getItemProperty("vehiculo.id").setValue(expVehiculo.getVehiculo() != null ? expVehiculo.getVehiculo().getId() : null);
			item.getItemProperty("vehiculo.placa").setValue(expVehiculo.getVehiculo().getPlaca());
			item.getItemProperty("vehiculo.tipoTamano").setValue(HarecUtil.valorNombreToEmpty(expVehiculo.getVehiculo().getTipoTamano()));
			item.getItemProperty("vehiculo.fabricacion").setValue(HarecUtil.valorNombreToEmpty(expVehiculo.getVehiculo().getPeriodoFabricacion()));
			item.getItemProperty("estado.id").setValue(HarecUtil.valorIdToEmpty(expVehiculo.getEstado()));
			item.getItemProperty("estadoChasis.id").setValue(HarecUtil.valorIdToEmpty(expVehiculo.getEstadoChasis()));
			item.getItemProperty("estadoMotor.id").setValue(HarecUtil.valorIdToEmpty(expVehiculo.getEstadoMotor()));
			item.getItemProperty("situacion.id").setValue(HarecUtil.valorIdToEmpty(expVehiculo.getSituacionLegal()));
			item.getItemProperty("estadoChasis").setValue(HarecUtil.valorNombreToEmpty(expVehiculo.getEstadoChasis()));
			item.getItemProperty("estadoMotor").setValue(HarecUtil.valorNombreToEmpty(expVehiculo.getEstadoMotor()));
			item.getItemProperty("placaMontada").setValue(expVehiculo.getPlacaMontada());
			item.getItemProperty("tipoUso").setValue(expVehiculo.getTipoUso());
			item.getItemProperty("observacion").setValue(expVehiculo.getObservaciones());
			if(expVehiculo.getPropietario()!=null){
				item.getItemProperty("propietario").setValue(expVehiculo.getPropietario());
				item.getItemProperty("propietario.id").setValue(expVehiculo.getPropietario().getId());
			}
			if(expVehiculo.getPersonaImplicada()!=null){
				item.getItemProperty("personaImplicada.id").setValue(expVehiculo.getPersonaImplicada().getId());
				item.getItemProperty("personaImplicada").setValue(expVehiculo.getPersonaImplicada());
				item.getItemProperty("personaImplicada.nombre").setValue(expVehiculo.getPersonaImplicada().getNombreCompleto());	
			}
		}
			
	}
	
	//** Acciones **//	
	@Override
	public void buttonClick(ClickEvent event) {
		if (event.getButton().equals(btnVehRegistrar)) {
			pnlAgregarVehiculo = new PanelAgregarVehiculo();
			if(this.getParent().getParent()!=null){
				pnlAgregarVehiculo.setParent(this.getParent().getParent());
			}else{
				pnlAgregarVehiculo.setParent(this.getParent());
			}
			Window window=new Window(){
				
				private static final long serialVersionUID = 1L;

				  protected void close() {
					  getApplication().getMainWindow().removeWindow(getWindow());
				  }};
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
			expVehiculo.setVehiculo((Vehiculo) cmbVehVehiculo.getValue());
			expVehiculo.setExpediente(expediente);
			expVehiculo.setEstado((Valor) cmbEstado.getValue());
			expVehiculo.setEstadoChasis((Valor) cmbEstadoChasis.getValue());
			expVehiculo.setEstadoMotor((Valor) cmbEstadoMotor.getValue() );
			expVehiculo.setSituacionLegal((Valor) cmbSituacion.getValue());
			expVehiculo.setPersonaImplicada((Persona) cmbPersonaIncautada.getValue());
			expVehiculo.setPropietario((Persona) cmbPropietario.getValue());
			expVehiculo.setObservaciones(txaObservacion.getValue() != null ? txaObservacion.getValue().toString() : StringUtils.EMPTY);
			expVehiculo.setPlacaMontada(txtPlacaMontada.getValue() != null ? txtPlacaMontada.getValue().toString() : StringUtils.EMPTY);
			expVehiculo.setTipoUso(txtTipodeUso.getValue() != null ? txtTipodeUso.getValue().toString() : StringUtils.EMPTY);
			
			if (expVehiculo.esNuevo()) {
				expVehiculoService.crear(expVehiculo);
			} else{
				expVehiculoService.actualizar(expVehiculo);
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
		expVehiculo = new DetPerVehExp();
		cmbVehVehiculo.select(null);
		cmbEstado.select(null);
		cmbEstadoChasis.select(null);
		cmbEstadoMotor.select(null);
		cmbPropietario.select(null);
		cmbPersonaIncautada.select(null);
		cmbSituacion.select(null);
		txaObservacion.setValue("");
		txtPlacaMontada.setValue("");
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
		
		// cmbPersonaIncautada
		cmbPersonaIncautada = new ComboBox();
		cmbPersonaIncautada.setCaption("Persona Incautada");
		cmbPersonaIncautada.setImmediate(false);
		cmbPersonaIncautada.setWidth("250px");
		cmbPersonaIncautada.setHeight("-1px");
		cmbPersonaIncautada.setRequired(true);
		pnlVehiculosBody2.addComponent(cmbPersonaIncautada);
		
		// cmbPropietario
		cmbPropietario = new ComboBox();
		cmbPropietario.setCaption("Propietario");
		cmbPropietario.setImmediate(false);
		cmbPropietario.setWidth("250px");
		cmbPropietario.setHeight("-1px");
		pnlVehiculosBody2.addComponent(cmbPropietario);
		
		// cmbEstadoChasis
		cmbEstadoChasis = new ComboBoxLOVS();
		cmbEstadoChasis.setCaption("Estado del Chasis");
		cmbEstadoChasis.setImmediate(false);
		cmbEstadoChasis.setWidth("180px");
		cmbEstadoChasis.setHeight("-1px");
		pnlVehiculosBody2.addComponent(cmbEstadoChasis);
		
		// cmbEstadoMotor
		cmbEstadoMotor = new ComboBoxLOVS();
		cmbEstadoMotor.setCaption("Estado del Motor");
		cmbEstadoMotor.setImmediate(false);
		cmbEstadoMotor.setWidth("180px");
		cmbEstadoMotor.setHeight("-1px");
		pnlVehiculosBody2.addComponent(cmbEstadoMotor);
		
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
		
		// cmbEstado
		cmbEstado = new ComboBoxLOVS();
		cmbEstado.setCaption("Estado");
		cmbEstado.setImmediate(false);
		cmbEstado.setWidth("210px");
		cmbEstado.setHeight("-1px");
		horizontalLayout_44.addComponent(cmbEstado);
		
		// cmbSituacion
		cmbSituacion = new ComboBoxLOVS();
		cmbSituacion.setCaption("Situación");
		cmbSituacion.setImmediate(false);
		cmbSituacion.setWidth("210px");
		cmbSituacion.setHeight("-1px");
		horizontalLayout_44.addComponent(cmbSituacion);
		
		// txtPlacaMontada
		txtPlacaMontada = new TextField();
		txtPlacaMontada.setCaption("Placa montada");
		txtPlacaMontada.setImmediate(false);
		txtPlacaMontada.setWidth("150px");
		txtPlacaMontada.setHeight("-1px");
		txtPlacaMontada.setInputPrompt("Nro. de la Placa");
		horizontalLayout_44.addComponent(txtPlacaMontada);
		
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
