package pe.gob.mininter.dirandro.vaadin.panel.util;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;


public class PanelAgregarTelefono_Detalles extends CustomComponent{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlBody;
	@AutoGenerated
	private HorizontalLayout pnl6;
	@AutoGenerated
	private Button btnSalir;
	@AutoGenerated
	private Button btnAnadir;
	@AutoGenerated
	private HorizontalLayout pnl3;
	@AutoGenerated
	private Table table_1;
	@AutoGenerated
	private HorizontalLayout pnl2;
	@AutoGenerated
	private TextField txtDuracion;
	@AutoGenerated
	private ComboBox cbbHoraInicio;
	@AutoGenerated
	private HorizontalLayout pnl1;
	@AutoGenerated
	private TextField txtNumero;
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
	
	public PanelAgregarTelefono_Detalles(Long idParte) {
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
		mainLayout.setWidth("380px");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("380px");
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
		pnlBody.setCaption("Nuevo Teléfono");
		pnlBody.setImmediate(false);
		pnlBody.setWidth("380px");
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
		cbbTipo.setCaption("Tipo de Llamada");
		cbbTipo.setImmediate(false);
		cbbTipo.setWidth("100px");
		cbbTipo.setHeight("-1px");
		pnl1.addComponent(cbbTipo);
		
		// txtNumero
		txtNumero = new TextField();
		txtNumero.setCaption("Número");
		txtNumero.setImmediate(false);
		txtNumero.setWidth("150px");
		txtNumero.setHeight("-1px");
		pnl1.addComponent(txtNumero);
		
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
		
		// cbbHoraInicio
		cbbHoraInicio = new ComboBox();
		cbbHoraInicio.setCaption("Hora Inicio");
		cbbHoraInicio.setImmediate(false);
		cbbHoraInicio.setWidth("-1px");
		cbbHoraInicio.setHeight("-1px");
		pnl2.addComponent(cbbHoraInicio);
		
		// txtDuracion
		txtDuracion = new TextField();
		txtDuracion.setCaption("Duración");
		txtDuracion.setImmediate(false);
		txtDuracion.setWidth("-1px");
		txtDuracion.setHeight("-1px");
		pnl2.addComponent(txtDuracion);
		
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
		
		// table_1
		table_1 = new Table();
		table_1.setImmediate(false);
		table_1.setWidth("330px");
		table_1.setHeight("135px");
		pnl3.addComponent(table_1);
		
		return pnl3;
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
		
		// btnAnadir
		btnAnadir = new Button();
		btnAnadir.setCaption("Añadir");
		btnAnadir.setImmediate(true);
		btnAnadir.setWidth("-1px");
		btnAnadir.setHeight("-1px");
		pnl6.addComponent(btnAnadir);
		
		// btnSalir
		btnSalir = new Button();
		btnSalir.setCaption("Salir");
		btnSalir.setImmediate(true);
		btnSalir.setWidth("68px");
		btnSalir.setHeight("-1px");
		pnl6.addComponent(btnSalir);
		
		return pnl6;
	}

}