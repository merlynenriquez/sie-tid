package pe.gob.mininter.dirandro.vaadin.panel.mantenimiento;

import java.text.MessageFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.model.Persona;
import pe.gob.mininter.dirandro.model.Policia;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.PersonaService;
import pe.gob.mininter.dirandro.service.PoliciaService;
import pe.gob.mininter.dirandro.service.ValorService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.vaadin.dialogs.AlertDialog;
import pe.gob.mininter.dirandro.vaadin.panel.util.PanelAgregarPersona;
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
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class PanelMantenPolicia extends DirandroComponent implements TextChangeListener,ClickListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout pnlPrincipal;
	@AutoGenerated
	private VerticalLayout verticalLayout_3;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private Button btnEliminar;
	@AutoGenerated
	private Button btnAgregar;
	@AutoGenerated
	private ComboBox cmbCargo;
	@AutoGenerated
	private TextArea txaUnidad;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_6;
	@AutoGenerated
	private ComboBox cmbGrado;
	@AutoGenerated
	private TextField txtCip;
	@AutoGenerated
	private Label lblDatosPersona;
	@AutoGenerated
	private VerticalLayout verticalLayout_4;
	@AutoGenerated
	private HorizontalLayout pnlPolicia1;
	@AutoGenerated
	private Button btnAgregarPersona;
	@AutoGenerated
	private ComboBox cmbNombres;
	@AutoGenerated
	private Label label_2;
	@AutoGenerated
	private VerticalLayout verticalLayout_2;
	@AutoGenerated
	private Table tblPolicias;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private TextField txtFiltroCip;
	@AutoGenerated
	private TextField txtFiltroDni;
	@AutoGenerated
	private TextField txtFiltroApellidoMaterno;
	@AutoGenerated
	private TextField txtFiltroApellido;
	@AutoGenerated
	private TextField txtFiltroNombre;
	@AutoGenerated
	private Label label_1;
	
	private static final long serialVersionUID = 6703991780832879281L;
	
	private PanelAgregarPersona pnlAgregarPersona;
	private boolean flagNuevaEstado;

	private PoliciaService policiaService;
	private PersonaService personaService;
	private ValorService valorService;
	private Persona personaPopUp;
	private Long idPolicia;
	
	private List<Persona> lstPersonas;	
	private List<Valor> lstGrado;
	private List<Valor> lstCargo;
	
	public Persona getPersonaPopUp() {
		return personaPopUp;
	}

	public void setPersonaPopUp(Persona personaPopUp) {
		this.personaPopUp = personaPopUp;
	}
	
	public PanelMantenPolicia(List<Opcion> acciones, String height) {
		super(acciones, height);
		policiaService = Injector.obtenerServicio(PoliciaService.class);
		personaService = Injector.obtenerServicio(PersonaService.class);
		valorService = Injector.obtenerServicio(ValorService.class);
		buildMainLayout();
		setCompositionRoot(mainLayout);
		postConstruct();
		debugId();
	}
	private void debugId(){
		
	}
		
	public void postConstruct() {
		btnAgregarPersona.addListener((ClickListener)this);
		btnAgregarPersona.setIcon(Constante.ICONOS.CREATE);
		btnAgregar.addListener((ClickListener)this);
		
		lblDatosPersona.setVisible(false);
		lstPersonas = personaService.buscar(null);
		cmbNombres.setInputPrompt("Persona");
		cmbNombres.setItemCaptionPropertyId("nombreCompleto");
		cmbNombres.setImmediate(true);
		cmbNombres.setContainerDataSource(new BeanItemContainer<Persona>(Persona.class, lstPersonas));
		cmbNombres.addListener( new ValueChangeListener() {
		
			private static final long serialVersionUID = -6213576334461528840L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				cambiaPersona(event);
			}

			private void cambiaPersona(ValueChangeEvent event) {
				
				if( cmbNombres.getValue() != null){
					imprimirPersona((Persona)cmbNombres.getValue());
				}
			}			
		});
				
		txtFiltroNombre.addListener((TextChangeListener)this);
		txtFiltroApellido.addListener((TextChangeListener)this);
		txtFiltroApellidoMaterno.addListener((TextChangeListener)this);
		txtFiltroDni.addListener((TextChangeListener)this);
		txtFiltroCip.addListener((TextChangeListener)this);
		
		txtFiltroNombre.setImmediate(true);
		txtFiltroApellido.setImmediate(true);
		txtFiltroApellidoMaterno.setImmediate(true);
		txtFiltroDni.setImmediate(true);
		txtFiltroCip.setImmediate(true);
		
		habilitarEdicion(false);
		
		tblPolicias.setSelectable(true);
		tblPolicias.setImmediate(true);
		tblPolicias.setNullSelectionAllowed(true);
		tblPolicias.setNullSelectionItemId(null);
		tblPolicias.addListener(new ValueChangeListener() {
			private static final long serialVersionUID = -6124596484581515359L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				boolean esModoNuevo = tblPolicias.getValue() == null;
				limpiar();
				if(esModoNuevo){
					tblPolicias.setValue(null);
					habilitarEdicion(false);
					lblDatosPersona.setVisible(false);
				}else {
					habilitarEdicion(true);
					Item item = tblPolicias.getItem(tblPolicias.getValue());
					idPolicia = (Long) item.getItemProperty("id").getValue();
					lblDatosPersona.setVisible(true);
					txtCip.setValue(item.getItemProperty("cip").getValue());
					txaUnidad.setValue(item.getItemProperty("unidad").getValue());
					cmbNombres.select((Persona) item.getItemProperty("persona").getValue());
					
					for (Valor grado : lstGrado) {
						if (grado.getId().equals((Long) item.getItemProperty("grado.id").getValue()))
							cmbGrado.select(grado);
					}
					
					for (Valor cargo : lstCargo) {
						if (cargo.getId().equals((Long) item.getItemProperty("cargo.id").getValue()))
							cmbCargo.select(cargo);
					}
				}
			}
		});
		
		cargaListas();
		refrescar();
	}
	
	 private void imprimirPersona(Persona persona) {
			String plantilla = "<p><b>Tipo y Número de Documento:</b> {0} {1} <b>Nacionalidad:</b> {2} <b>Sexo:</b> {3}</p>";
			lblDatosPersona.setVisible(true);
			String sexoPersona = persona.getSexo().equals("M") ? "Masculino" : "Femenino";
			String html = MessageFormat.format(plantilla, persona.getTipoDocumento().getNombre(), persona.getNroDocumento(), persona.getNacionalidad().getNombre(), sexoPersona);
			lblDatosPersona.setValue(html);
		}
	
	private void cargaListas(){
		cmbGrado.setInputPrompt("Grado");				
		lstGrado = valorService.obtenerLista(Constante.LISTA.CODIGO.GRADO);		
		BeanItemContainer<Valor> bicLstGrado = new BeanItemContainer<Valor>(Valor.class,  lstGrado);		
		cmbGrado.setContainerDataSource(bicLstGrado);		
		cmbGrado.setItemCaptionPropertyId("nombre");
		
		cmbCargo.setInputPrompt("Cargo");				
		lstCargo = valorService.obtenerLista(Constante.LISTA.CODIGO.CARGO);		
		BeanItemContainer<Valor> bicLstCargo = new BeanItemContainer<Valor>(Valor.class,  lstCargo);		
		cmbCargo.setContainerDataSource(bicLstCargo);		
		cmbCargo.setItemCaptionPropertyId("nombre");
		
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
	
	private void cargarPolicias(List<Policia> listPolicias){
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("id", Long.class,  null);
		container.addContainerProperty("persona", Persona.class, null);
		container.addContainerProperty("persona.id", Long.class, null);
		container.addContainerProperty("nombres", String.class, null);
		container.addContainerProperty("paterno", String.class, null);
		container.addContainerProperty("materno", String.class, null);
		container.addContainerProperty("nroDocumento", String.class, null);
		container.addContainerProperty("cip", String.class, null);
		container.addContainerProperty("tipoDocumento", Valor.class, null);
		container.addContainerProperty("tipoDocumento.nombre", String.class, null);
		container.addContainerProperty("grado.id", Long.class, null);
		container.addContainerProperty("cargo.id", Long.class, null);
		container.addContainerProperty("unidad", String.class, null);
		
		tblPolicias.setContainerDataSource(container);
		tblPolicias.setVisibleColumns(new Object[]{"nombres", "paterno", "materno", "nroDocumento", "cip"});
	
		tblPolicias.setColumnWidth("nombres", 105);
		tblPolicias.setColumnWidth("paterno", 110);
		tblPolicias.setColumnWidth("materno", 105);
		tblPolicias.setColumnWidth("nroDocumento", 80);
		tblPolicias.setColumnWidth("cip", 70);
				
		tblPolicias.setColumnHeader("nombres", "Nombre");
		tblPolicias.setColumnHeader("paterno", "Paterno");
		tblPolicias.setColumnHeader("materno", "Materno");
		tblPolicias.setColumnHeader("nroDocumento", "Nro Documento");
		tblPolicias.setColumnHeader("cip", "CIP");
				
		int con=1;
		for (Policia policia : listPolicias){
			Item item = container.addItem(con++);
			item.getItemProperty("id").setValue(policia.getId());
			item.getItemProperty("persona").setValue(policia.getPersona());
			item.getItemProperty("persona.id").setValue(policia.getPersona().getId());
			item.getItemProperty("nombres").setValue(policia.getPersona().getNombres());
			item.getItemProperty("paterno").setValue(policia.getPersona().getApePaterno());
			item.getItemProperty("materno").setValue(policia.getPersona().getApeMaterno());
			item.getItemProperty("nroDocumento").setValue(policia.getPersona().getNroDocumento());
			item.getItemProperty("tipoDocumento").setValue(policia.getPersona().getTipoDocumento());
			item.getItemProperty("tipoDocumento.nombre").setValue(policia.getPersona().getTipoDocumento().getNombre());
			item.getItemProperty("cip").setValue(policia.getCip());
			item.getItemProperty("grado.id").setValue(policia.getGrado().getId());
			item.getItemProperty("cargo.id").setValue(policia.getCargo().getId());
			item.getItemProperty("unidad").setValue(policia.getUnidad());
		}
	}
	
	@Override
	public void buttonClick(ClickEvent event) {

		if (event.getButton().equals(btnAgregarPersona)) {
			cargarWindowPersona(new Persona());
		} else if (event.getButton().equals(btnAgregar)) {
			StringBuilder sbContenido = new StringBuilder();
			Policia policia =  new Policia();
			policia.setPersona((Persona)cmbNombres.getValue());
			policia.setCip(txtCip.getValue().toString());
			policia.setGrado(((Valor)cmbGrado.getValue()));
			policia.setCargo(((Valor)cmbCargo.getValue()));
			policia.setUnidad(txaUnidad.getValue().toString());
			
			if(flagNuevaEstado){
				policia.setId(idPolicia);
				policiaService.actualizar(policia);
				sbContenido.append("Policia : ").append(policia.getPersona().getNombreCompleto()).append(" se ha "+ Constante.OPERACION.ACTUALIZAR_REGISTRO+" satisfactoriamente.");
			}
			else{
				policiaService.crear(policia);
				sbContenido.append("Policia : ").append(policia.getPersona().getNombreCompleto()).append(" se ha "+ Constante.OPERACION.CREAR_REGISTRO+" satisfactoriamente.");
			}
			AlertDialog alertDialog = new  AlertDialog("Policia", sbContenido.toString(), "Aceptar", "400");
			getApplication().getMainWindow().addWindow(alertDialog);
			refrescar();
		}
	}	
	
	public void refrescar(){
		habilitarEdicion(false);
		limpiar();
		cargarPolicias(policiaService.buscar(null));
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
	

	public void obtenerDatosPersona() {
		lstPersonas = personaService.buscar(null);
		cmbNombres.setContainerDataSource(new BeanItemContainer<Persona>(Persona.class, lstPersonas));
		cmbNombres.select(personaPopUp);
	}
	
	@Override
	public void textChange(TextChangeEvent event) {
		Policia policia = new Policia();
		policia.setPersona(new Persona());

		if (event.getSource().equals(txtFiltroNombre)) {
			policia.getPersona().setNombres(event.getText());
		}else if (event.getSource().equals(txtFiltroApellido)) {		
			policia.getPersona().setApePaterno(event.getText());					
		} else if (event.getSource().equals(txtFiltroApellidoMaterno)) {
			policia.getPersona().setApeMaterno(event.getText());
		} else if (event.getSource().equals(txtFiltroDni)) {
			policia.getPersona().setNroDocumento(event.getText());
		} else if (event.getSource().equals(txtFiltroCip)) {
			policia.setCip(event.getText());
		}
	}
	
	private void limpiar(){
		cmbNombres.select(null);
		cmbCargo.select(null);
		cmbGrado.select(null);
		txtCip.setValue(StringUtils.EMPTY);
		txaUnidad.setValue(StringUtils.EMPTY);
		txtFiltroNombre.setValue(StringUtils.EMPTY);
		txtFiltroApellido.setValue(StringUtils.EMPTY);
		txtFiltroDni.setValue(StringUtils.EMPTY);
		txtFiltroCip.setValue(StringUtils.EMPTY);
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
		pnlPrincipal.setStyleName("whiteBackGround");
		pnlPrincipal.setImmediate(false);
		pnlPrincipal.setWidth("-1px");
		pnlPrincipal.setHeight("400px");
		pnlPrincipal.setMargin(true);
		pnlPrincipal.setSpacing(true);
		
		// verticalLayout_2
		verticalLayout_2 = buildVerticalLayout_2();
		pnlPrincipal.addComponent(verticalLayout_2);
		
		// verticalLayout_3
		verticalLayout_3 = buildVerticalLayout_3();
		pnlPrincipal.addComponent(verticalLayout_3);
		
		return pnlPrincipal;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_2() {
		// common part: create layout
		verticalLayout_2 = new VerticalLayout();
		verticalLayout_2.setImmediate(false);
		verticalLayout_2.setWidth("546px");
		verticalLayout_2.setHeight("-1px");
		verticalLayout_2.setMargin(false);
		
		// label_1
		label_1 = new Label();
		label_1.setStyleName("h2");
		label_1.setImmediate(false);
		label_1.setWidth("-1px");
		label_1.setHeight("-1px");
		label_1.setValue("Filtro de Búsqueda de Policías");
		verticalLayout_2.addComponent(label_1);
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		verticalLayout_2.addComponent(horizontalLayout_2);
		
		// tblPolicias
		tblPolicias = new Table();
		tblPolicias.setImmediate(false);
		tblPolicias.setWidth("537px");
		tblPolicias.setHeight("300px");
		verticalLayout_2.addComponent(tblPolicias);
		
		return verticalLayout_2;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_2() {
		// common part: create layout
		horizontalLayout_2 = new HorizontalLayout();
		horizontalLayout_2.setImmediate(false);
		horizontalLayout_2.setWidth("-1px");
		horizontalLayout_2.setHeight("-1px");
		horizontalLayout_2.setMargin(false);
		
		// txtFiltroNombre
		txtFiltroNombre = new TextField();
		txtFiltroNombre.setImmediate(false);
		txtFiltroNombre.setWidth("120px");
		txtFiltroNombre.setHeight("-1px");
		txtFiltroNombre.setInputPrompt("Nombre");
		horizontalLayout_2.addComponent(txtFiltroNombre);
		
		// txtFiltroApellido
		txtFiltroApellido = new TextField();
		txtFiltroApellido.setImmediate(false);
		txtFiltroApellido.setWidth("120px");
		txtFiltroApellido.setHeight("-1px");
		txtFiltroApellido.setInputPrompt("Apellido Paterno");
		horizontalLayout_2.addComponent(txtFiltroApellido);
		
		// txtFiltroApellidoMaterno
		txtFiltroApellidoMaterno = new TextField();
		txtFiltroApellidoMaterno.setImmediate(false);
		txtFiltroApellidoMaterno.setWidth("120px");
		txtFiltroApellidoMaterno.setHeight("-1px");
		txtFiltroApellidoMaterno.setInputPrompt("Apellido Materno");
		horizontalLayout_2.addComponent(txtFiltroApellidoMaterno);
		
		// txtFiltroDni
		txtFiltroDni = new TextField();
		txtFiltroDni.setImmediate(false);
		txtFiltroDni.setWidth("90px");
		txtFiltroDni.setHeight("-1px");
		txtFiltroDni.setInputPrompt("DNI");
		horizontalLayout_2.addComponent(txtFiltroDni);
		
		// txtFiltroCip
		txtFiltroCip = new TextField();
		txtFiltroCip.setImmediate(false);
		txtFiltroCip.setWidth("80px");
		txtFiltroCip.setHeight("-1px");
		txtFiltroCip.setInputPrompt("CIP");
		horizontalLayout_2.addComponent(txtFiltroCip);
		
		return horizontalLayout_2;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_3() {
		// common part: create layout
		verticalLayout_3 = new VerticalLayout();
		verticalLayout_3.setImmediate(false);
		verticalLayout_3.setWidth("-1px");
		verticalLayout_3.setHeight("-1px");
		verticalLayout_3.setMargin(false);
		verticalLayout_3.setSpacing(true);
		
		// label_2
		label_2 = new Label();
		label_2.setStyleName("h2");
		label_2.setImmediate(false);
		label_2.setWidth("-1px");
		label_2.setHeight("-1px");
		label_2.setValue("Administración de Policias");
		verticalLayout_3.addComponent(label_2);
		
		// verticalLayout_4
		verticalLayout_4 = buildVerticalLayout_4();
		verticalLayout_3.addComponent(verticalLayout_4);
		
		// lblDatosPersona
		lblDatosPersona = new Label();
		lblDatosPersona.setImmediate(false);
		lblDatosPersona.setWidth("270px");
		lblDatosPersona.setHeight("50px");
		lblDatosPersona.setContentMode(3);
		verticalLayout_3.addComponent(lblDatosPersona);
		
		// horizontalLayout_6
		horizontalLayout_6 = buildHorizontalLayout_6();
		verticalLayout_3.addComponent(horizontalLayout_6);
		
		// txaUnidad
		txaUnidad = new TextArea();
		txaUnidad.setCaption("Unidad");
		txaUnidad.setImmediate(false);
		txaUnidad.setWidth("246px");
		txaUnidad.setHeight("60px");
		txaUnidad.setRequired(true);
		verticalLayout_3.addComponent(txaUnidad);
		
		// cmbCargo
		cmbCargo = new ComboBox();
		cmbCargo.setCaption("Cargo");
		cmbCargo.setImmediate(false);
		cmbCargo.setWidth("246px");
		cmbCargo.setHeight("-1px");
		verticalLayout_3.addComponent(cmbCargo);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		verticalLayout_3.addComponent(horizontalLayout_1);
		verticalLayout_3.setComponentAlignment(horizontalLayout_1,
				new Alignment(20));
		
		return verticalLayout_3;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_4() {
		// common part: create layout
		verticalLayout_4 = new VerticalLayout();
		verticalLayout_4.setImmediate(false);
		verticalLayout_4.setWidth("-1px");
		verticalLayout_4.setHeight("-1px");
		verticalLayout_4.setMargin(false);
		
		// pnlPolicia1
		pnlPolicia1 = buildPnlPolicia1();
		verticalLayout_4.addComponent(pnlPolicia1);
		
		return verticalLayout_4;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlPolicia1() {
		// common part: create layout
		pnlPolicia1 = new HorizontalLayout();
		pnlPolicia1.setImmediate(false);
		pnlPolicia1.setWidth("-1px");
		pnlPolicia1.setHeight("-1px");
		pnlPolicia1.setMargin(false);
		pnlPolicia1.setSpacing(true);
		
		// cmbNombres
		cmbNombres = new ComboBox();
		cmbNombres.setCaption("Nombres y apellidos ");
		cmbNombres.setImmediate(false);
		cmbNombres.setWidth("230px");
		cmbNombres.setHeight("-1px");
		cmbNombres.setRequired(true);
		pnlPolicia1.addComponent(cmbNombres);
		
		// btnAgregarPersona
		btnAgregarPersona = new Button();
		btnAgregarPersona.setCaption(" ");
		btnAgregarPersona.setImmediate(true);
		btnAgregarPersona.setWidth("-1px");
		btnAgregarPersona.setHeight("-1px");
		pnlPolicia1.addComponent(btnAgregarPersona);
		pnlPolicia1.setComponentAlignment(btnAgregarPersona, new Alignment(24));
		
		return pnlPolicia1;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_6() {
		// common part: create layout
		horizontalLayout_6 = new HorizontalLayout();
		horizontalLayout_6.setImmediate(false);
		horizontalLayout_6.setWidth("-1px");
		horizontalLayout_6.setHeight("-1px");
		horizontalLayout_6.setMargin(false);
		horizontalLayout_6.setSpacing(true);
		
		// txtCip
		txtCip = new TextField();
		txtCip.setCaption("CIP");
		txtCip.setImmediate(false);
		txtCip.setWidth("80px");
		txtCip.setHeight("-1px");
		txtCip.setRequired(true);
		horizontalLayout_6.addComponent(txtCip);
		
		// cmbGrado
		cmbGrado = new ComboBox();
		cmbGrado.setCaption("Grado");
		cmbGrado.setImmediate(false);
		cmbGrado.setWidth("160px");
		cmbGrado.setHeight("-1px");
		cmbGrado.setRequired(true);
		horizontalLayout_6.addComponent(cmbGrado);
		
		return horizontalLayout_6;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("-1px");
		horizontalLayout_1.setHeight("-1px");
		horizontalLayout_1.setMargin(true);
		horizontalLayout_1.setSpacing(true);
		
		// btnAgregar
		btnAgregar = new Button();
		btnAgregar.setCaption("Agregar");
		btnAgregar.setImmediate(true);
		btnAgregar.setWidth("-1px");
		btnAgregar.setHeight("-1px");
		horizontalLayout_1.addComponent(btnAgregar);
		
		// btnEliminar
		btnEliminar = new Button();
		btnEliminar.setCaption("Eliminar");
		btnEliminar.setImmediate(true);
		btnEliminar.setWidth("-1px");
		btnEliminar.setHeight("-1px");
		horizontalLayout_1.addComponent(btnEliminar);
		
		return horizontalLayout_1;
	}

}
