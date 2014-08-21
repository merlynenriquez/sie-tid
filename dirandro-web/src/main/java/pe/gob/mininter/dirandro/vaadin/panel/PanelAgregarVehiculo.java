package pe.gob.mininter.dirandro.vaadin.panel;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;


public class PanelAgregarVehiculo extends CustomComponent{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlBody;
	@AutoGenerated
	private HorizontalLayout pnl6;
	@AutoGenerated
	private Button btnCancelar;
	@AutoGenerated
	private Button btnGrabar;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private TextField txtObs;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private Button btnBuscar;
	@AutoGenerated
	private ComboBox cbbPropietario;
	@AutoGenerated
	private HorizontalLayout pnl3;
	@AutoGenerated
	private TextField txtModeloEspecifico;
	@AutoGenerated
	private ComboBox cbbModelo;
	@AutoGenerated
	private ComboBox cbbColor;
	@AutoGenerated
	private HorizontalLayout pnl2;
	@AutoGenerated
	private ComboBox cbbAnio;
	@AutoGenerated
	private TextField txtPlaca;
	@AutoGenerated
	private TextField txtSerieChasis;
	@AutoGenerated
	private HorizontalLayout pnl1;
	@AutoGenerated
	private TextField txtSerieMotor;
	@AutoGenerated
	private ComboBox cbbCilindros;
	@AutoGenerated
	private ComboBox cnnTransmision;
	@AutoGenerated
	private ComboBox cbbTipo;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 * @param idParte 
	 */
	
	public PanelAgregarVehiculo(Long idParte) {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		postConstruct();
		debugId();
	}
	private void debugId(){
		
	}
	public void postConstruct() {
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("500px");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("500px");
		setHeight("-1px");
		
		// pnlBody
		pnlBody = buildPnlBody();
		mainLayout.addComponent(pnlBody);
		mainLayout.setComponentAlignment(pnlBody, new Alignment(20));
		
		return mainLayout;
	}
	@AutoGenerated
	private VerticalLayout buildPnlBody() {
		// common part: create layout
		pnlBody = new VerticalLayout();
		pnlBody.setCaption("Nuevo Vehículo");
		pnlBody.setImmediate(false);
		pnlBody.setWidth("-1px");
		pnlBody.setHeight("-1px");
		pnlBody.setMargin(true);
		pnlBody.setSpacing(true);
		
		// pnl1
		pnl1 = buildPnl1();
		pnlBody.addComponent(pnl1);
		
		// pnl2
		pnl2 = buildPnl2();
		pnlBody.addComponent(pnl2);
		
		// pnl3
		pnl3 = buildPnl3();
		pnlBody.addComponent(pnl3);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		pnlBody.addComponent(horizontalLayout_1);
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		pnlBody.addComponent(horizontalLayout_2);
		
		// pnl6
		pnl6 = buildPnl6();
		pnlBody.addComponent(pnl6);
		pnlBody.setComponentAlignment(pnl6, new Alignment(20));
		
		return pnlBody;
	}
	@AutoGenerated
	private HorizontalLayout buildPnl1() {
		// common part: create layout
		pnl1 = new HorizontalLayout();
		pnl1.setImmediate(false);
		pnl1.setWidth("-1px");
		pnl1.setHeight("-1px");
		pnl1.setMargin(false);
		pnl1.setSpacing(true);
		
		// cbbTipo
		cbbTipo = new ComboBox();
		cbbTipo.setCaption("Tipo Tamaño");
		cbbTipo.setImmediate(false);
		cbbTipo.setWidth("100px");
		cbbTipo.setHeight("-1px");
		pnl1.addComponent(cbbTipo);
		
		// cnnTransmision
		cnnTransmision = new ComboBox();
		cnnTransmision.setCaption("Transmisión");
		cnnTransmision.setImmediate(false);
		cnnTransmision.setWidth("100px");
		cnnTransmision.setHeight("-1px");
		pnl1.addComponent(cnnTransmision);
		
		// cbbCilindros
		cbbCilindros = new ComboBox();
		cbbCilindros.setCaption("Cilindros");
		cbbCilindros.setImmediate(false);
		cbbCilindros.setWidth("100px");
		cbbCilindros.setHeight("-1px");
		pnl1.addComponent(cbbCilindros);
		
		// txtSerieMotor
		txtSerieMotor = new TextField();
		txtSerieMotor.setCaption("Serie del Motor");
		txtSerieMotor.setImmediate(false);
		txtSerieMotor.setWidth("150px");
		txtSerieMotor.setHeight("-1px");
		pnl1.addComponent(txtSerieMotor);
		
		return pnl1;
	}
	@AutoGenerated
	private HorizontalLayout buildPnl2() {
		// common part: create layout
		pnl2 = new HorizontalLayout();
		pnl2.setImmediate(false);
		pnl2.setWidth("-1px");
		pnl2.setHeight("-1px");
		pnl2.setMargin(false);
		pnl2.setSpacing(true);
		
		// txtSerieChasis
		txtSerieChasis = new TextField();
		txtSerieChasis.setCaption("Serie del Chasis");
		txtSerieChasis.setImmediate(false);
		txtSerieChasis.setWidth("150px");
		txtSerieChasis.setHeight("-1px");
		pnl2.addComponent(txtSerieChasis);
		
		// txtPlaca
		txtPlaca = new TextField();
		txtPlaca.setCaption("Placa");
		txtPlaca.setImmediate(false);
		txtPlaca.setWidth("-1px");
		txtPlaca.setHeight("-1px");
		pnl2.addComponent(txtPlaca);
		
		// cbbAnio
		cbbAnio = new ComboBox();
		cbbAnio.setCaption("Año");
		cbbAnio.setImmediate(false);
		cbbAnio.setWidth("100px");
		cbbAnio.setHeight("-1px");
		pnl2.addComponent(cbbAnio);
		
		return pnl2;
	}
	@AutoGenerated
	private HorizontalLayout buildPnl3() {
		// common part: create layout
		pnl3 = new HorizontalLayout();
		pnl3.setImmediate(false);
		pnl3.setWidth("-1px");
		pnl3.setHeight("-1px");
		pnl3.setMargin(false);
		pnl3.setSpacing(true);
		
		// cbbColor
		cbbColor = new ComboBox();
		cbbColor.setCaption("Color");
		cbbColor.setImmediate(false);
		cbbColor.setWidth("100px");
		cbbColor.setHeight("-1px");
		pnl3.addComponent(cbbColor);
		
		// cbbModelo
		cbbModelo = new ComboBox();
		cbbModelo.setCaption("Modelo");
		cbbModelo.setImmediate(false);
		cbbModelo.setWidth("-1px");
		cbbModelo.setHeight("-1px");
		pnl3.addComponent(cbbModelo);
		
		// txtModeloEspecifico
		txtModeloEspecifico = new TextField();
		txtModeloEspecifico.setCaption("Modelo Especifico");
		txtModeloEspecifico.setImmediate(false);
		txtModeloEspecifico.setWidth("193px");
		txtModeloEspecifico.setHeight("24px");
		pnl3.addComponent(txtModeloEspecifico);
		
		return pnl3;
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
		
		// cbbPropietario
		cbbPropietario = new ComboBox();
		cbbPropietario.setCaption("Propietario");
		cbbPropietario.setImmediate(false);
		cbbPropietario.setWidth("225px");
		cbbPropietario.setHeight("-1px");
		horizontalLayout_1.addComponent(cbbPropietario);
		
		// btnBuscar
		btnBuscar = new Button();
		btnBuscar.setCaption("Buscar");
		btnBuscar.setImmediate(true);
		btnBuscar.setWidth("-1px");
		btnBuscar.setHeight("-1px");
		horizontalLayout_1.addComponent(btnBuscar);
		horizontalLayout_1.setComponentAlignment(btnBuscar, new Alignment(24));
		
		return horizontalLayout_1;
	}
	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_2() {
		// common part: create layout
		horizontalLayout_2 = new HorizontalLayout();
		horizontalLayout_2.setImmediate(false);
		horizontalLayout_2.setWidth("-1px");
		horizontalLayout_2.setHeight("-1px");
		horizontalLayout_2.setMargin(false);
		
		// txtObs
		txtObs = new TextField();
		txtObs.setCaption("Observaciones");
		txtObs.setImmediate(false);
		txtObs.setWidth("462px");
		txtObs.setHeight("75px");
		horizontalLayout_2.addComponent(txtObs);
		
		return horizontalLayout_2;
	}
	@AutoGenerated
	private HorizontalLayout buildPnl6() {
		// common part: create layout
		pnl6 = new HorizontalLayout();
		pnl6.setImmediate(false);
		pnl6.setWidth("-1px");
		pnl6.setHeight("-1px");
		pnl6.setMargin(false);
		pnl6.setSpacing(true);
		
		// btnGrabar
		btnGrabar = new Button();
		btnGrabar.setCaption("Grabar");
		btnGrabar.setImmediate(true);
		btnGrabar.setWidth("-1px");
		btnGrabar.setHeight("-1px");
		pnl6.addComponent(btnGrabar);
		
		// btnCancelar
		btnCancelar = new Button();
		btnCancelar.setCaption("Cancelar");
		btnCancelar.setImmediate(true);
		btnCancelar.setWidth("-1px");
		btnCancelar.setHeight("-1px");
		pnl6.addComponent(btnCancelar);
		
		return pnl6;
	}

}
