package pe.gob.mininter.dirandro.vaadin.panel;

import java.util.List;

import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.vaadin.util.HarecComponent;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;


public class PanelMantenLetrado extends HarecComponent {
	
	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout pnlPrincipal;
	@AutoGenerated
	private VerticalLayout pnlDatos;
	@AutoGenerated
	private VerticalLayout verticalLayout_2;
	@AutoGenerated
	private Button btnAgregar;
	@AutoGenerated
	private TextField txtColegiatura;
	@AutoGenerated
	private ComboBox cmbTipo;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_3;
	@AutoGenerated
	private ComboBox cmbNacionalidad;
	@AutoGenerated
	private ComboBox cbmSexo;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private TextField txtNumero;
	@AutoGenerated
	private ComboBox cmbTipoDoc;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_4;
	@AutoGenerated
	private Button btnNuevo;
	@AutoGenerated
	private ComboBox cmbPersona;
	@AutoGenerated
	private Label lblLetrado;
	@AutoGenerated
	private VerticalLayout pnlLista;
	@AutoGenerated
	private Table tblLetrados;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private TextField txtfiltroNroDniLetrado;
	@AutoGenerated
	private TextField txtfiltroApellidoLetrado;
	@AutoGenerated
	private TextField txtfiltroNomLetrado;
	@AutoGenerated
	private Label lblFiltro;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelMantenLetrado(List<Opcion> acciones, String height) {
		super(acciones, height);
		buildMainLayout();
		setCompositionRoot(mainLayout);
		postConstruct();
		debugId();
	}
	
	private void debugId(){
		
	}
	public void postConstruct() {
		cmbTipoDoc.setEnabled(false);
		
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
	private HorizontalLayout buildPnlPrincipal() {
		// common part: create layout
		pnlPrincipal = new HorizontalLayout();
		pnlPrincipal.setStyleName("backColor");
		pnlPrincipal.setImmediate(false);
		pnlPrincipal.setWidth("-1px");
		pnlPrincipal.setHeight("320px");
		pnlPrincipal.setMargin(true);
		pnlPrincipal.setSpacing(true);
		
		// pnlLista
		pnlLista = buildPnlLista();
		pnlPrincipal.addComponent(pnlLista);
		
		// pnlDatos
		pnlDatos = buildPnlDatos();
		pnlPrincipal.addComponent(pnlDatos);
		pnlPrincipal.setComponentAlignment(pnlDatos, new Alignment(20));
		
		return pnlPrincipal;
	}

	@AutoGenerated
	private VerticalLayout buildPnlLista() {
		// common part: create layout
		pnlLista = new VerticalLayout();
		pnlLista.setImmediate(false);
		pnlLista.setWidth("-1px");
		pnlLista.setHeight("-1px");
		pnlLista.setMargin(true);
		
		// lblFiltro
		lblFiltro = new Label();
		lblFiltro.setStyleName("h2");
		lblFiltro.setImmediate(false);
		lblFiltro.setWidth("157px");
		lblFiltro.setHeight("-1px");
		lblFiltro.setValue("Filtro de Letrado");
		pnlLista.addComponent(lblFiltro);
		pnlLista.setComponentAlignment(lblFiltro, new Alignment(24));
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		pnlLista.addComponent(horizontalLayout_1);
		
		// tblLetrados
		tblLetrados = new Table();
		tblLetrados.setImmediate(false);
		tblLetrados.setWidth("434px");
		tblLetrados.setHeight("-1px");
		pnlLista.addComponent(tblLetrados);
		
		return pnlLista;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("434px");
		horizontalLayout_1.setHeight("-1px");
		horizontalLayout_1.setMargin(false);
		
		// txtfiltroNomLetrado
		txtfiltroNomLetrado = new TextField();
		txtfiltroNomLetrado.setImmediate(false);
		txtfiltroNomLetrado.setWidth("-1px");
		txtfiltroNomLetrado.setHeight("-1px");
		txtfiltroNomLetrado.setInputPrompt("Nombre");
		horizontalLayout_1.addComponent(txtfiltroNomLetrado);
		
		// txtfiltroApellidoLetrado
		txtfiltroApellidoLetrado = new TextField();
		txtfiltroApellidoLetrado.setImmediate(false);
		txtfiltroApellidoLetrado.setWidth("-1px");
		txtfiltroApellidoLetrado.setHeight("-1px");
		txtfiltroApellidoLetrado.setInputPrompt("Apellido");
		horizontalLayout_1.addComponent(txtfiltroApellidoLetrado);
		
		// txtfiltroNroDniLetrado
		txtfiltroNroDniLetrado = new TextField();
		txtfiltroNroDniLetrado.setImmediate(false);
		txtfiltroNroDniLetrado.setWidth("-1px");
		txtfiltroNroDniLetrado.setHeight("-1px");
		txtfiltroNroDniLetrado.setInputPrompt("Num Tipo Doc");
		horizontalLayout_1.addComponent(txtfiltroNroDniLetrado);
		
		return horizontalLayout_1;
	}

	@AutoGenerated
	private VerticalLayout buildPnlDatos() {
		// common part: create layout
		pnlDatos = new VerticalLayout();
		pnlDatos.setStyleName("h2");
		pnlDatos.setImmediate(false);
		pnlDatos.setWidth("-1px");
		pnlDatos.setHeight("-1px");
		pnlDatos.setMargin(false);
		
		// lblLetrado
		lblLetrado = new Label();
		lblLetrado.setStyleName("h2");
		lblLetrado.setImmediate(false);
		lblLetrado.setWidth("187px");
		lblLetrado.setHeight("-1px");
		lblLetrado.setValue("Administración Letrado");
		pnlDatos.addComponent(lblLetrado);
		
		// verticalLayout_2
		verticalLayout_2 = buildVerticalLayout_2();
		pnlDatos.addComponent(verticalLayout_2);
		
		return pnlDatos;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_2() {
		// common part: create layout
		verticalLayout_2 = new VerticalLayout();
		verticalLayout_2.setImmediate(false);
		verticalLayout_2.setWidth("-1px");
		verticalLayout_2.setHeight("-1px");
		verticalLayout_2.setMargin(false);
		
		// horizontalLayout_4
		horizontalLayout_4 = buildHorizontalLayout_4();
		verticalLayout_2.addComponent(horizontalLayout_4);
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		verticalLayout_2.addComponent(horizontalLayout_2);
		
		// horizontalLayout_3
		horizontalLayout_3 = buildHorizontalLayout_3();
		verticalLayout_2.addComponent(horizontalLayout_3);
		
		// cmbTipo
		cmbTipo = new ComboBox();
		cmbTipo.setCaption("Tipo Letrado");
		cmbTipo.setImmediate(false);
		cmbTipo.setWidth("106px");
		cmbTipo.setHeight("-1px");
		cmbTipo.setRequired(true);
		verticalLayout_2.addComponent(cmbTipo);
		
		// txtColegiatura
		txtColegiatura = new TextField();
		txtColegiatura.setCaption("Colegiatura");
		txtColegiatura.setImmediate(false);
		txtColegiatura.setWidth("106px");
		txtColegiatura.setHeight("-1px");
		verticalLayout_2.addComponent(txtColegiatura);
		
		// btnAgregar
		btnAgregar = new Button();
		btnAgregar.setCaption("Agregar");
		btnAgregar.setImmediate(true);
		btnAgregar.setWidth("-1px");
		btnAgregar.setHeight("-1px");
		verticalLayout_2.addComponent(btnAgregar);
		verticalLayout_2.setComponentAlignment(btnAgregar, new Alignment(48));
		
		return verticalLayout_2;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_4() {
		// common part: create layout
		horizontalLayout_4 = new HorizontalLayout();
		horizontalLayout_4.setImmediate(false);
		horizontalLayout_4.setWidth("-1px");
		horizontalLayout_4.setHeight("-1px");
		horizontalLayout_4.setMargin(false);
		
		// cmbPersona
		cmbPersona = new ComboBox();
		cmbPersona.setCaption("Nombre Apellido Letrado");
		cmbPersona.setImmediate(false);
		cmbPersona.setWidth("230px");
		cmbPersona.setHeight("-1px");
		cmbPersona.setRequired(true);
		horizontalLayout_4.addComponent(cmbPersona);
		
		// btnNuevo
		btnNuevo = new Button();
		btnNuevo.setCaption("Nuevo");
		btnNuevo.setImmediate(true);
		btnNuevo.setWidth("-1px");
		btnNuevo.setHeight("-1px");
		horizontalLayout_4.addComponent(btnNuevo);
		horizontalLayout_4.setComponentAlignment(btnNuevo, new Alignment(24));
		
		return horizontalLayout_4;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_2() {
		// common part: create layout
		horizontalLayout_2 = new HorizontalLayout();
		horizontalLayout_2.setImmediate(false);
		horizontalLayout_2.setWidth("-1px");
		horizontalLayout_2.setHeight("-1px");
		horizontalLayout_2.setMargin(false);
		
		// cmbTipoDoc
		cmbTipoDoc = new ComboBox();
		cmbTipoDoc.setCaption("Tipo Doc");
		cmbTipoDoc.setImmediate(false);
		cmbTipoDoc.setWidth("101px");
		cmbTipoDoc.setHeight("-1px");
		horizontalLayout_2.addComponent(cmbTipoDoc);
		
		// txtNumero
		txtNumero = new TextField();
		txtNumero.setCaption("Número");
		txtNumero.setImmediate(false);
		txtNumero.setWidth("-1px");
		txtNumero.setHeight("-1px");
		horizontalLayout_2.addComponent(txtNumero);
		
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
		
		// cbmSexo
		cbmSexo = new ComboBox();
		cbmSexo.setCaption("Sexo");
		cbmSexo.setImmediate(false);
		cbmSexo.setWidth("101px");
		cbmSexo.setHeight("-1px");
		horizontalLayout_3.addComponent(cbmSexo);
		
		// cmbNacionalidad
		cmbNacionalidad = new ComboBox();
		cmbNacionalidad.setCaption("Nacionalidad");
		cmbNacionalidad.setImmediate(false);
		cmbNacionalidad.setWidth("190px");
		cmbNacionalidad.setHeight("-1px");
		horizontalLayout_3.addComponent(cmbNacionalidad);
		
		return horizontalLayout_3;
	}

}
