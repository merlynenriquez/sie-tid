package pe.gob.mininter.dirandro.vaadin.panel.mantenimiento;

import java.util.List;

import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.vaadin.util.DirandroComponent;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PanelMantenAerodromo extends DirandroComponent {

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
	private Button btnAgregar;
	@AutoGenerated
	private ComboBox cmbUbicacion;
	@AutoGenerated
	private ComboBox cmbAeronaveMaxima;
	@AutoGenerated
	private ComboBox cmbEmpresa;
	@AutoGenerated
	private TextField txtNombre;
	@AutoGenerated
	private Label lblAdministracion;
	@AutoGenerated
	private VerticalLayout pnl1;
	@AutoGenerated
	private Table tblAerodromo;
	@AutoGenerated
	private Label lblFiltro;
	public PanelMantenAerodromo(List<Opcion> acciones, String height) {
		super(acciones, height);
		buildMainLayout();
		setCompositionRoot(mainLayout);
		postConstruct();
		debugId();
	}
	private void debugId(){
		
	}
	public void postConstruct() {
		
		/*btnAgregar.addListener((ClickListener)this);
		btnCrearRepresentante.addListener((ClickListener)this);
		btnCrearRepresentante.setIcon(Constante.ICONOS.CREATE);
		cmbEstado.setCodigoLista(Constante.LISTA.CODIGO.ESTADO);
		cmbEstado.setRequired(true);
		lblDatosPersona.setVisible(false);
		
		cmbRepresentante.setInputPrompt("Persona");
		cmbEstado.setInputPrompt("Estado");
				
		txtFiltroRUC.addListener((TextChangeListener)this);
		txtFiltroDireccion.addListener((TextChangeListener)this);
		txtFiltroRazonSocial.addListener((TextChangeListener)this);
		
		txtFiltroRUC.setImmediate(true);
		txtFiltroDireccion.setImmediate(true);
		txtFiltroRazonSocial.setImmediate(true);*/
				
		
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
		tblAerodromo = new Table();
		tblAerodromo.setImmediate(false);
		tblAerodromo.setWidth("485px");
		tblAerodromo.setHeight("400px");
		tblAerodromo.setRequired(true);
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
		cmbAeronaveMaxima = new ComboBox();
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
		
		// btnAgregar
		btnAgregar = new Button();
		btnAgregar.setCaption("Agregar");
		btnAgregar.setImmediate(true);
		btnAgregar.setWidth("-1px");
		btnAgregar.setHeight("-1px");
		pnl2_1.addComponent(btnAgregar);
		pnl2_1.setComponentAlignment(btnAgregar, new Alignment(20));
		
		return pnl2_1;
	}

}
