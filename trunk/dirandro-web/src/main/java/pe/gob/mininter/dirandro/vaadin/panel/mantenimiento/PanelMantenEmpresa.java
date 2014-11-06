package pe.gob.mininter.dirandro.vaadin.panel.mantenimiento;

import java.text.MessageFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.Empresa;
import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.model.Persona;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.EmpresaService;
import pe.gob.mininter.dirandro.service.PersonaService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.vaadin.dialogs.AlertDialog;
import pe.gob.mininter.dirandro.vaadin.panel.util.PanelAgregarPersona;
import pe.gob.mininter.dirandro.vaadin.util.ComboBoxLOVS;
import pe.gob.mininter.dirandro.vaadin.util.DirandroComponent;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class PanelMantenEmpresa extends DirandroComponent implements TextChangeListener,ClickListener {

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
	private ComboBoxLOVS cmbEstado;
	@AutoGenerated
	private TextField txtTelefono;
	@AutoGenerated
	private Label lblDatosPersona;
	@AutoGenerated
	private HorizontalLayout pnl2_1_1;
	@AutoGenerated
	private Button btnCrearRepresentante;
	@AutoGenerated
	private ComboBox cmbRepresentante;
	@AutoGenerated
	private TextField txtPartida;
	@AutoGenerated
	private TextField txtDireccion;
	@AutoGenerated
	private TextField txtRuc;
	@AutoGenerated
	private TextField txtRazonSocial;
	@AutoGenerated
	private Label lblAdministracion;
	@AutoGenerated
	private VerticalLayout pnl1;
	@AutoGenerated
	private Table tblEmpresas;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_6;
	@AutoGenerated
	private TextField txtFiltroDireccion;
	@AutoGenerated
	private TextField txtFiltroRazonSocial;
	@AutoGenerated
	private TextField txtFiltroRUC;
	@AutoGenerated
	private Label lblFiltro;
	private static final long serialVersionUID = 151693891606391910L;
	
	private PersonaService personaService;
	private List<Persona> lstRepresentantes;
	private EmpresaService empresaService;
	private boolean flagNuevaEstado;
	private PanelAgregarPersona pnlAgregarPersona;
	private Long idEmpresa;
	
	private Persona personaPopUp;
	public Persona getPersonaPopUp() {
		return personaPopUp;
	}

	public void setPersonaPopUp(Persona value) {
		this.personaPopUp = value;
	}
	
	
	public PanelMantenEmpresa(List<Opcion> acciones, String height) {
		super(acciones, height);
		personaService = Injector.obtenerServicio(PersonaService.class);
		empresaService = Injector.obtenerServicio(EmpresaService.class);
		buildMainLayout();
		setCompositionRoot(mainLayout);
		postConstruct();
		debugId();
	}
	private void debugId(){
		
	}
	public void postConstruct() {
		
		btnAgregar.addListener((ClickListener)this);
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
		txtFiltroRazonSocial.setImmediate(true);
				
		habilitarEdicion(false);
	
		lstRepresentantes = personaService.buscar(null);
		
		tblEmpresas.setSelectable(true);
		tblEmpresas.setImmediate(true);
		tblEmpresas.setNullSelectionAllowed(true);
		tblEmpresas.setNullSelectionItemId(null);
		tblEmpresas.addListener(new ValueChangeListener() {
			private static final long serialVersionUID = -6124596484581515359L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				boolean esModoNuevo = tblEmpresas.getValue() == null;
				limpiar();
				if(esModoNuevo){
					tblEmpresas.setValue(null);
					habilitarEdicion(false);
					lblDatosPersona.setVisible(false);
				}else {
					habilitarEdicion(true);
					Item item = tblEmpresas.getItem(tblEmpresas.getValue());
					idEmpresa = (Long) item.getItemProperty("id").getValue();
					txtRuc.setValue(item.getItemProperty("ruc").getValue() != null ? item.getItemProperty("ruc").getValue().toString() : StringUtils.EMPTY);
					txtRazonSocial.setValue(item.getItemProperty("razon_social").getValue() != null ? item.getItemProperty("razon_social").getValue().toString() : StringUtils.EMPTY);
					txtDireccion.setValue(item.getItemProperty("direccion").getValue() != null ? item.getItemProperty("direccion").getValue().toString() : StringUtils.EMPTY);
					txtPartida.setValue(item.getItemProperty("partida").getValue() != null ? item.getItemProperty("partida").getValue().toString() : StringUtils.EMPTY);
					txtTelefono.setValue(item.getItemProperty("telefono").getValue() != null ? item.getItemProperty("telefono").getValue().toString() : StringUtils.EMPTY);
					cmbRepresentante.select((Persona) item.getItemProperty("representante").getValue());
					if ((Persona) item.getItemProperty("representante").getValue() != null) {
						lblDatosPersona.setVisible(true);
					}else {
						lblDatosPersona.setVisible(false);
					}
					cmbEstado.select(new Valor((Long) item.getItemProperty("estado.id").getValue()));
				}
			}
		});
	
		refrescar();
		cargaListas();
	}
	
	private void habilitarEdicion(boolean flag){
		flagNuevaEstado = flag;
		if(flag){
			btnAgregar.setCaption("Actualizar");
		}
		else{
			btnAgregar.setCaption("Crear");
		}
	}

	private void cargaListas(){
		lstRepresentantes = personaService.buscar(null);
		cmbRepresentante.setItemCaptionPropertyId("nombreCompleto");
		cmbRepresentante.setImmediate(true);
		cmbRepresentante.setContainerDataSource(new BeanItemContainer<Persona>(Persona.class, lstRepresentantes));
		cmbRepresentante.addListener(new ValueChangeListener() {
			
			private static final long serialVersionUID = -4699194280620323711L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				if( cmbRepresentante.getValue() != null){
					imprimirPersona((Persona) cmbRepresentante.getValue());
					lblDatosPersona.setVisible(true);
				}else {
					lblDatosPersona.setVisible(false);
				}
			}
		});
	}

	@Override
	public void textChange(TextChangeEvent event) {
		
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		if (event.getButton().equals(btnCrearRepresentante)) {
			cargarWindowPersona(new Persona());
		} else if (event.getButton().equals(btnAgregar)) {
			StringBuilder sbContenido = new StringBuilder();
			Empresa empresa = new Empresa();
			empresa.setRazonSocial(txtRazonSocial.getValue().toString());
			empresa.setRuc(txtRuc.getValue().toString());
			empresa.setDireccion(txtDireccion.getValue().toString());
			empresa.setPartidaRegistral(txtPartida.getValue().toString());
			empresa.setRepresentante((Persona) cmbRepresentante.getValue());
			empresa.setTelefono(txtTelefono.getValue().toString());
			empresa.setEstado((Valor) cmbEstado.getValue());

			if(flagNuevaEstado){
				empresa.setId(idEmpresa);
				empresaService.actualizar(empresa);
				sbContenido.append("Empresa : ").append(empresa.getRazonSocial()).append(" se ha "+ Constante.OPERACION.ACTUALIZAR_REGISTRO+" satisfactoriamente.");
			}
			else{
				empresaService.crear(empresa);
				sbContenido.append("Empresa : ").append(empresa.getRazonSocial()).append(" se ha "+ Constante.OPERACION.CREAR_REGISTRO+" satisfactoriamente.");	
			}
			AlertDialog alertDialog = new  AlertDialog("Empresa", sbContenido.toString(), "Aceptar", "400");
			getApplication().getMainWindow().addWindow(alertDialog);
			refrescar();
		}
	}
	
	public void refrescar(){
		habilitarEdicion(false);
		limpiar();
		cargarEmpresas(empresaService.listarEmpresas());
	}
	
	private void imprimirPersona(Persona persona) {
		String plantilla = "<p><b>Tipo y Número de Documento:</b> {0} {1} <b>Nacionalidad:</b> {2} <b>Sexo:</b> {3}</p>";
		lblDatosPersona.setVisible(true);
		String sexoPersona = persona.getSexo().equals("M") ? "Masculino" : "Femenino";
		String html = MessageFormat.format(plantilla, persona.getTipoDocumento().getNombre(), persona.getNroDocumento(), persona.getNacionalidad().getNombre(), sexoPersona);
		lblDatosPersona.setValue(html);
	}
	
	private void limpiar() {
		txtDireccion.setValue(StringUtils.EMPTY);
		txtPartida.setValue(StringUtils.EMPTY);
		txtRazonSocial.setValue(StringUtils.EMPTY);
		txtRuc.setValue(StringUtils.EMPTY);
		txtTelefono.setValue(StringUtils.EMPTY);
		cmbEstado.select(null);
		cmbRepresentante.select(null);
		txtFiltroRazonSocial.setValue(StringUtils.EMPTY);
		txtFiltroDireccion.setValue(StringUtils.EMPTY);
		txtFiltroRUC.setValue(StringUtils.EMPTY);
	}

	private void cargarWindowPersona(Persona persona) {
		pnlAgregarPersona = new PanelAgregarPersona(this, persona);
		pnlAgregarPersona.setParent(this.getParent());
		
		final Window window=new Window(){
			
			private static final long serialVersionUID = 1L;

			protected void close() {
		    	getApplication().getMainWindow().removeWindow(getWindow());
			}
		};
		      
		window.setCaption("Registrar Persona");
		window.addComponent(pnlAgregarPersona);
		window.setModal(true);
		window.setResizable(false);
		window.setWidth("650px");
		window.setHeight("-1.0");
		getApplication().getMainWindow().addWindow(window);
	}
	
	private void cargarEmpresas(List<Empresa> lstEmpresas){
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("id", Long.class,  null);
		container.addContainerProperty("ruc", String.class, null);
		container.addContainerProperty("direccion", String.class, null);
		container.addContainerProperty("telefono", String.class, null);
		container.addContainerProperty("partida", String.class, null);
		container.addContainerProperty("razon_social", String.class, null);
		container.addContainerProperty("estado.id", Long.class, null);
		container.addContainerProperty("representante", Persona.class, null);
		container.addContainerProperty("representante.nombre", String.class, null);
		
		tblEmpresas.setContainerDataSource(container);
		tblEmpresas.setVisibleColumns(new Object[]{"ruc", "razon_social", "direccion"});
	
		tblEmpresas.setColumnWidth("ruc", 85);
		tblEmpresas.setColumnWidth("razon_social", 215);
		tblEmpresas.setColumnWidth("rep_legal", 170);
						
		tblEmpresas.setColumnHeader("ruc", "Ruc");
		tblEmpresas.setColumnHeader("razon_social", "Razon Social");
		tblEmpresas.setColumnHeader("representante.nombre", "Representante Legal");
				
		int con=1;
		for (Empresa p: lstEmpresas){
			Item item = container.addItem(con++);
			item.getItemProperty("id").setValue(p.getId());
			item.getItemProperty("ruc").setValue(p.getRuc());
			item.getItemProperty("telefono").setValue(p.getTelefono());
			item.getItemProperty("partida").setValue(p.getPartidaRegistral());
			item.getItemProperty("direccion").setValue(p.getDireccion());
			item.getItemProperty("razon_social").setValue(p.getRazonSocial());
			item.getItemProperty("estado.id").setValue(p.getEstado().getId());
			item.getItemProperty("representante").setValue(p.getRepresentante());
			item.getItemProperty("representante.nombre").setValue(p.getRepresentante() != null ? p.getRepresentante().getNombreCompleto() : StringUtils.EMPTY);
		}
	}
	public void obtenerDatosPersona() {
		lstRepresentantes = personaService.buscar(null);
		cmbRepresentante.setContainerDataSource(new BeanItemContainer<Persona>(Persona.class, lstRepresentantes));
		
		for (Persona persona : lstRepresentantes) {
			if (persona.getId().equals(personaPopUp.getId()))
				cmbRepresentante.select(persona);
		}
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
		lblFiltro.setValue("Filtro Empresas");
		pnl1.addComponent(lblFiltro);
		
		// horizontalLayout_6
		horizontalLayout_6 = buildHorizontalLayout_6();
		pnl1.addComponent(horizontalLayout_6);
		
		// tblEmpresas
		tblEmpresas = new Table();
		tblEmpresas.setImmediate(false);
		tblEmpresas.setWidth("485px");
		tblEmpresas.setHeight("400px");
		tblEmpresas.setRequired(true);
		pnl1.addComponent(tblEmpresas);
		
		return pnl1;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_6() {
		// common part: create layout
		horizontalLayout_6 = new HorizontalLayout();
		horizontalLayout_6.setImmediate(false);
		horizontalLayout_6.setWidth("-1px");
		horizontalLayout_6.setHeight("-1px");
		horizontalLayout_6.setMargin(false);
		
		// txtFiltroRUC
		txtFiltroRUC = new TextField();
		txtFiltroRUC.setImmediate(false);
		txtFiltroRUC.setWidth("100px");
		txtFiltroRUC.setHeight("-1px");
		txtFiltroRUC.setInputPrompt("RUC");
		horizontalLayout_6.addComponent(txtFiltroRUC);
		
		// txtFiltroRazonSocial
		txtFiltroRazonSocial = new TextField();
		txtFiltroRazonSocial.setImmediate(false);
		txtFiltroRazonSocial.setWidth("215px");
		txtFiltroRazonSocial.setHeight("-1px");
		txtFiltroRazonSocial.setInputPrompt("Razón Social");
		horizontalLayout_6.addComponent(txtFiltroRazonSocial);
		
		// txtFiltroDireccion
		txtFiltroDireccion = new TextField();
		txtFiltroDireccion.setImmediate(false);
		txtFiltroDireccion.setWidth("170px");
		txtFiltroDireccion.setHeight("-1px");
		txtFiltroDireccion.setInputPrompt("Dirección");
		horizontalLayout_6.addComponent(txtFiltroDireccion);
		
		return horizontalLayout_6;
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
		lblAdministracion.setValue("Administración Empresa");
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
		
		// txtRazonSocial
		txtRazonSocial = new TextField();
		txtRazonSocial.setCaption("Razón Social");
		txtRazonSocial.setImmediate(false);
		txtRazonSocial.setWidth("300px");
		txtRazonSocial.setHeight("-1px");
		txtRazonSocial.setRequired(true);
		txtRazonSocial.setInputPrompt("Nombre o Razón Social");
		txtRazonSocial.setMaxLength(400);
		pnl2_1.addComponent(txtRazonSocial);
		
		// txtRuc
		txtRuc = new TextField();
		txtRuc.setCaption("RUC");
		txtRuc.setImmediate(false);
		txtRuc.setWidth("200px");
		txtRuc.setHeight("-1px");
		txtRuc.setRequired(true);
		txtRuc.setInputPrompt("Nro. de Ruc");
		txtRuc.setMaxLength(11);
		pnl2_1.addComponent(txtRuc);
		
		// txtDireccion
		txtDireccion = new TextField();
		txtDireccion.setCaption("Dirección");
		txtDireccion.setImmediate(false);
		txtDireccion.setWidth("300px");
		txtDireccion.setHeight("-1px");
		txtDireccion.setRequired(true);
		txtDireccion.setInputPrompt("Dirección de la Persona Jurídica");
		txtDireccion.setMaxLength(500);
		pnl2_1.addComponent(txtDireccion);
		
		// txtPartida
		txtPartida = new TextField();
		txtPartida.setCaption("Partida Reg");
		txtPartida.setImmediate(false);
		txtPartida.setWidth("200px");
		txtPartida.setHeight("-1px");
		txtPartida.setInputPrompt("Nro de la Partida Registral");
		txtPartida.setMaxLength(50);
		pnl2_1.addComponent(txtPartida);
		
		// pnl2_1_1
		pnl2_1_1 = buildPnl2_1_1();
		pnl2_1.addComponent(pnl2_1_1);
		
		// lblDatosPersona
		lblDatosPersona = new Label();
		lblDatosPersona.setImmediate(false);
		lblDatosPersona.setWidth("280px");
		lblDatosPersona.setHeight("40px");
		lblDatosPersona.setValue(" ");
		lblDatosPersona.setContentMode(3);
		pnl2_1.addComponent(lblDatosPersona);
		
		// txtTelefono
		txtTelefono = new TextField();
		txtTelefono.setCaption("Teléfono");
		txtTelefono.setImmediate(false);
		txtTelefono.setWidth("139px");
		txtTelefono.setHeight("-1px");
		txtTelefono.setInputPrompt("Nro de Teléfono");
		txtTelefono.setMaxLength(30);
		pnl2_1.addComponent(txtTelefono);
		
		// cmbEstado
		cmbEstado = new ComboBoxLOVS();
		cmbEstado.setCaption("Estado");
		cmbEstado.setImmediate(false);
		cmbEstado.setWidth("-1px");
		cmbEstado.setHeight("-1px");
		pnl2_1.addComponent(cmbEstado);
		
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

	@AutoGenerated
	private HorizontalLayout buildPnl2_1_1() {
		// common part: create layout
		pnl2_1_1 = new HorizontalLayout();
		pnl2_1_1.setImmediate(false);
		pnl2_1_1.setWidth("-1px");
		pnl2_1_1.setHeight("-1px");
		pnl2_1_1.setMargin(false);
		pnl2_1_1.setSpacing(true);
		
		// cmbRepresentante
		cmbRepresentante = new ComboBox();
		cmbRepresentante.setCaption("Representante Legal");
		cmbRepresentante.setImmediate(false);
		cmbRepresentante.setWidth("250px");
		cmbRepresentante.setHeight("-1px");
		cmbRepresentante.setRequired(true);
		pnl2_1_1.addComponent(cmbRepresentante);
		
		// btnCrearRepresentante
		btnCrearRepresentante = new Button();
		btnCrearRepresentante.setCaption(" ");
		btnCrearRepresentante.setImmediate(true);
		btnCrearRepresentante.setWidth("-1px");
		btnCrearRepresentante.setHeight("-1px");
		pnl2_1_1.addComponent(btnCrearRepresentante);
		pnl2_1_1.setComponentAlignment(btnCrearRepresentante, new Alignment(10));
		
		return pnl2_1_1;
	}

}