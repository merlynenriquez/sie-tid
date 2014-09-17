package pe.gob.mininter.dirandro.vaadin.panel;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class PanelRegistroParteVehiculo extends CustomComponent implements ClickListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	
	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlVehiculosBody;
	@AutoGenerated
	private Table tblVehLista;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_44;
	@AutoGenerated
	private Button btnVehAgregar;
	@AutoGenerated
	private ComboBox cmbEstadoChasis;
	@AutoGenerated
	private ComboBox cmbVehEstado;
	@AutoGenerated
	private TextField txtVehPlacaMontada;
	@AutoGenerated
	private TextField txtVehTipodeUso;
	@AutoGenerated
	private HorizontalLayout pnlVehiculosBody2;
	@AutoGenerated
	private ComboBox cmbVehEstadoMotor;
	@AutoGenerated
	private ComboBox cmbVehSituacion;
	@AutoGenerated
	private ComboBox cmbVehPropietario;
	@AutoGenerated
	private ComboBox cmbVehPersonaIncautada;
	@AutoGenerated
	private HorizontalLayout pnlVehiculosBody1;
	@AutoGenerated
	private Button btnVehRegistrar;
	@AutoGenerated
	private ComboBox cbbVehVehiculo;
	private static final long serialVersionUID = -4639683924066371051L;
		
	private PanelAgregarVehiculo pnlAgregarVehiculo;
	
	public PanelRegistroParteVehiculo() {
		super();
		buildMainLayout();
		setCompositionRoot(mainLayout);
		postConstruct();
	}
	
	public void postConstruct() {
		btnVehRegistrar.addListener((ClickListener)this);
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals( btnVehRegistrar )){
			
			pnlAgregarVehiculo = new PanelAgregarVehiculo(1L);
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
			getWindow().addWindow(window);
			
		}
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
		
		// tblVehLista
		tblVehLista = new Table();
		tblVehLista.setImmediate(false);
		tblVehLista.setWidth("870px");
		tblVehLista.setHeight("-1px");
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
		
		// cbbVehVehiculo
		cbbVehVehiculo = new ComboBox();
		cbbVehVehiculo.setCaption("Vehículo");
		cbbVehVehiculo.setImmediate(false);
		cbbVehVehiculo.setWidth("250px");
		cbbVehVehiculo.setHeight("-1px");
		pnlVehiculosBody1.addComponent(cbbVehVehiculo);
		
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
		
		// cmbVehPersonaIncautada
		cmbVehPersonaIncautada = new ComboBox();
		cmbVehPersonaIncautada.setCaption("Persona Incautada");
		cmbVehPersonaIncautada.setImmediate(false);
		cmbVehPersonaIncautada.setWidth("250px");
		cmbVehPersonaIncautada.setHeight("-1px");
		pnlVehiculosBody2.addComponent(cmbVehPersonaIncautada);
		
		// cmbVehPropietario
		cmbVehPropietario = new ComboBox();
		cmbVehPropietario.setCaption("Propietario");
		cmbVehPropietario.setImmediate(false);
		cmbVehPropietario.setWidth("250px");
		cmbVehPropietario.setHeight("-1px");
		pnlVehiculosBody2.addComponent(cmbVehPropietario);
		
		// cmbVehSituacion
		cmbVehSituacion = new ComboBox();
		cmbVehSituacion.setCaption("Situación");
		cmbVehSituacion.setImmediate(false);
		cmbVehSituacion.setWidth("-1px");
		cmbVehSituacion.setHeight("-1px");
		cmbVehSituacion.setRequired(true);
		pnlVehiculosBody2.addComponent(cmbVehSituacion);
		
		// cmbVehEstadoMotor
		cmbVehEstadoMotor = new ComboBox();
		cmbVehEstadoMotor.setCaption("Estado del Motor");
		cmbVehEstadoMotor.setImmediate(false);
		cmbVehEstadoMotor.setWidth("-1px");
		cmbVehEstadoMotor.setHeight("-1px");
		pnlVehiculosBody2.addComponent(cmbVehEstadoMotor);
		
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
		
		// txtVehTipodeUso
		txtVehTipodeUso = new TextField();
		txtVehTipodeUso.setCaption("Tipo de uso");
		txtVehTipodeUso.setImmediate(false);
		txtVehTipodeUso.setWidth("-1px");
		txtVehTipodeUso.setHeight("-1px");
		horizontalLayout_44.addComponent(txtVehTipodeUso);
		
		// txtVehPlacaMontada
		txtVehPlacaMontada = new TextField();
		txtVehPlacaMontada.setCaption("Placa montada");
		txtVehPlacaMontada.setImmediate(false);
		txtVehPlacaMontada.setWidth("-1px");
		txtVehPlacaMontada.setHeight("-1px");
		horizontalLayout_44.addComponent(txtVehPlacaMontada);
		
		// cmbVehEstado
		cmbVehEstado = new ComboBox();
		cmbVehEstado.setCaption("Estado");
		cmbVehEstado.setImmediate(false);
		cmbVehEstado.setWidth("-1px");
		cmbVehEstado.setHeight("-1px");
		cmbVehEstado.setRequired(true);
		horizontalLayout_44.addComponent(cmbVehEstado);
		
		// cmbEstadoChasis
		cmbEstadoChasis = new ComboBox();
		cmbEstadoChasis.setCaption("Estado del Chasis");
		cmbEstadoChasis.setImmediate(false);
		cmbEstadoChasis.setWidth("-1px");
		cmbEstadoChasis.setHeight("-1px");
		horizontalLayout_44.addComponent(cmbEstadoChasis);
		
		// btnVehAgregar
		btnVehAgregar = new Button();
		btnVehAgregar.setCaption("Registrar");
		btnVehAgregar.setImmediate(true);
		btnVehAgregar.setWidth("-1px");
		btnVehAgregar.setHeight("-1px");
		horizontalLayout_44.addComponent(btnVehAgregar);
		horizontalLayout_44.setComponentAlignment(btnVehAgregar, new Alignment(
				10));
		
		return horizontalLayout_44;
	}

}
