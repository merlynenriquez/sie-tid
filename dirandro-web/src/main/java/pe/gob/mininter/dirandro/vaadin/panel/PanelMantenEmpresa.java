package pe.gob.mininter.dirandro.vaadin.panel;

import java.util.List;

import pe.gob.mininter.dirandro.model.Empresa;
import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.model.Persona;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.EmpresaService;
import pe.gob.mininter.dirandro.service.PersonaService;
import pe.gob.mininter.dirandro.service.ValorService;
import pe.gob.mininter.dirandro.util.Constante;
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
	private HorizontalLayout pnl2_2;
	@AutoGenerated
	private Button btnAgregar;
	@AutoGenerated
	private VerticalLayout pnl2_1;
	@AutoGenerated
	private ComboBox cmbEstado;
	@AutoGenerated
	private TextField txtTelefono;
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
	private Label label_2;
	@AutoGenerated
	private VerticalLayout pnl1;
	@AutoGenerated
	private Table tblEmpresas;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_6;
	@AutoGenerated
	private TextField txtFiltroRepresentanteLegal;
	@AutoGenerated
	private TextField txtFiltroRazonSocial;
	@AutoGenerated
	private TextField txtFiltroRUC;
	@AutoGenerated
	private Label label_1;

	private static final long serialVersionUID = 151693891606391910L;
	
	private PersonaService personaService;
	private Empresa empresa;
	private List<Persona> lstRepresentantes;
	private List<Valor> lstEstado;
	private ValorService valorService;
	private EmpresaService empresaService;
	private boolean flagNuevaEstado;
	private PanelAgregarPersona pnlAgregarPersona;
	
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
		valorService = Injector.obtenerServicio(ValorService.class);
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
				
		txtFiltroRUC.addListener((TextChangeListener)this);
		txtFiltroRepresentanteLegal.addListener((TextChangeListener)this);
		txtFiltroRazonSocial.addListener((TextChangeListener)this);
		
		txtFiltroRUC.setImmediate(true);
		txtFiltroRepresentanteLegal.setImmediate(true);
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
				if(esModoNuevo){
					empresa = new Empresa();
					tblEmpresas.setValue(null);
					habilitarEdicion(false);
				}else {
					habilitarEdicion(true);
					
					Item item = tblEmpresas.getItem(tblEmpresas.getValue());
					
					empresa = empresaService.obtener( new Long( item.getItemProperty("id").getValue().toString() ));
										
					txtRuc.setValue(empresa.getRuc());
					txtRazonSocial.setValue(empresa.getRazonSocial());
					txtDireccion.setValue(empresa.getDireccion());
					txtPartida.setValue(empresa.getPartidaRegistral());			
					txtTelefono.setValue(empresa.getTelefono());										
					cmbEstado.setValue(empresa.getEstado());
					
					Long idPersona = empresa.getPerPersona().getId();
					Persona p = BuscarPersonaenLista(idPersona);
					cmbRepresentante.setValue(p);
										
				}
			}
		});
		
		empresa = new Empresa();
		empresa.setPerPersona( new Persona() );
		List<Empresa> lista = empresaService.listarEmpresas();
		cargarEmpresas(lista, true);
		cargaListas();
	}
	
	private Persona BuscarPersonaenLista(Long Id)
	{
		for(int n=0; n<this.lstRepresentantes.size(); n++)
		{
			if(this.lstRepresentantes.get(n).getId() == Id)
				return this.lstRepresentantes.get(n);
		}
		
		return null;
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
		cmbRepresentante.setInputPrompt("Persona");
		cmbRepresentante.setItemCaptionPropertyId("nombreCompleto");
		cmbRepresentante.setImmediate(true);
		cmbRepresentante.setContainerDataSource(new BeanItemContainer<Persona>(Persona.class, lstRepresentantes));
				
		cmbEstado.setInputPrompt("Estado");				
		lstEstado = valorService.obtenerLista(Constante.LISTA.CODIGO.ESTADO);		
		BeanItemContainer<Valor> bicLstGrado = new BeanItemContainer<Valor>(Valor.class,  lstEstado);		
		cmbEstado.setContainerDataSource(bicLstGrado);		
		cmbEstado.setItemCaptionPropertyId("nombre");
		
	}

	@Override
	public void textChange(TextChangeEvent event) {
		Empresa e = new Empresa();
		e.setPerPersona(new Persona());
		
		if (event.getSource().equals(this.txtFiltroRUC)) {
			e.setRuc(event.getText());
		}
		else
		if (event.getSource().equals(this.txtFiltroRazonSocial)) {		
			e.setRazonSocial(event.getText());
		}
		else
		if (event.getSource().equals(this.txtFiltroRepresentanteLegal)) {				
			e.getPerPersona().setNombres(event.getText());
		}
		
		List<Empresa> lista = empresaService.buscar(e);
		cargarEmpresas(lista, false);
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		
		if (event.getButton().equals(btnCrearRepresentante)) {
			cargarWindowPersona(new Persona());
		} else if (event.getButton().equals(btnAgregar)) {			
			if(flagNuevaEstado){
				actualizaEmpresa();
			}
			else{
				registrarEmpresa();
			}
			List<Empresa> lista = empresaService.listarEmpresas();
			cargarEmpresas(lista, true);
		}
		
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
	
	private void registrarEmpresa(){
		empresa =  new Empresa();
		
		empresa.setRazonSocial(txtRazonSocial.getValue().toString());
		empresa.setRuc(this.txtRuc.getValue().toString());
		empresa.setDireccion(txtDireccion.getValue().toString());
		empresa.setPartidaRegistral(txtPartida.getValue().toString());
		empresa.setPerPersona((Persona)cmbRepresentante.getValue());
		empresa.setTelefono(txtTelefono.getValue().toString());
		empresa.setEstado((Valor)cmbEstado.getValue());
		empresaService.crear(empresa);
		
	}
	
	private void actualizaEmpresa(){
		//TODO: Corregir
		empresa.setRazonSocial(txtRazonSocial.getValue().toString());
		empresa.setDireccion(txtDireccion.getValue().toString());
		empresa.setPartidaRegistral(txtPartida.getValue().toString());
		empresa.setPerPersona((Persona)cmbRepresentante.getValue());
		empresa.setTelefono(txtTelefono.getValue().toString());
		empresa.setEstado((Valor)cmbEstado.getValue());
		empresaService.actualizar(empresa);
		
	}
	
	private void cargarEmpresas(List<Empresa> listEmpresas, boolean flagLimpiar){
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("id", Long.class,  null);

		container.addContainerProperty("ruc", String.class, null);
		container.addContainerProperty("razon_social", String.class, null);
		container.addContainerProperty("rep_legal", String.class, null);
		
		tblEmpresas.setContainerDataSource(container);
		tblEmpresas.setVisibleColumns(new Object[]{"ruc", "razon_social", "rep_legal"});
	
		tblEmpresas.setColumnWidth("ruc", 85);
		tblEmpresas.setColumnWidth("razon_social", 150);
		tblEmpresas.setColumnWidth("rep_legal", 150);
				
		tblEmpresas.setColumnHeader("ruc", "Ruc");
		tblEmpresas.setColumnHeader("razon_social", "Razon Social");
		tblEmpresas.setColumnHeader("rep_legal", "Representante Legal");
				
		int con=1;
		for (Empresa p: listEmpresas){
			Item item = container.addItem(con++);
			item.getItemProperty("id").setValue(p.getId());
			item.getItemProperty("ruc").setValue(p.getRuc() );
			item.getItemProperty("razon_social").setValue(p.getRazonSocial());
			item.getItemProperty("rep_legal").setValue(p.getPerPersona().getNombreCompleto());
		}		
		if(flagLimpiar){
			
			txtRazonSocial.setValue("");
			this.txtRuc.setValue("");
			txtDireccion.setValue("");
			txtPartida.setValue("");			
			txtTelefono.setValue("");			
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
		pnlPrincipal.setWidth("900px");
		pnlPrincipal.setHeight("380px");
		pnlPrincipal.setMargin(false);
		
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
		pnl1.setHeight("320px");
		pnl1.setMargin(false);
		
		// label_1
		label_1 = new Label();
		label_1.setStyleName("h2");
		label_1.setImmediate(false);
		label_1.setWidth("142px");
		label_1.setHeight("-1px");
		label_1.setValue("Filtro Empresas");
		pnl1.addComponent(label_1);
		pnl1.setComponentAlignment(label_1, new Alignment(20));
		
		// horizontalLayout_6
		horizontalLayout_6 = buildHorizontalLayout_6();
		pnl1.addComponent(horizontalLayout_6);
		
		// tblEmpresas
		tblEmpresas = new Table();
		tblEmpresas.setImmediate(false);
		tblEmpresas.setWidth("485px");
		tblEmpresas.setHeight("-1px");
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
		txtFiltroRazonSocial.setWidth("160px");
		txtFiltroRazonSocial.setHeight("-1px");
		txtFiltroRazonSocial.setInputPrompt("Razón Social");
		horizontalLayout_6.addComponent(txtFiltroRazonSocial);
		
		// txtFiltroRepresentanteLegal
		txtFiltroRepresentanteLegal = new TextField();
		txtFiltroRepresentanteLegal.setImmediate(false);
		txtFiltroRepresentanteLegal.setWidth("170px");
		txtFiltroRepresentanteLegal.setHeight("-1px");
		txtFiltroRepresentanteLegal.setInputPrompt("Representante Legal");
		horizontalLayout_6.addComponent(txtFiltroRepresentanteLegal);
		
		return horizontalLayout_6;
	}
	@AutoGenerated
	private VerticalLayout buildPnl2() {
		// common part: create layout
		pnl2 = new VerticalLayout();
		pnl2.setImmediate(false);
		pnl2.setWidth("-1px");
		pnl2.setHeight("360px");
		pnl2.setMargin(false);
		
		// label_2
		label_2 = new Label();
		label_2.setStyleName("h2");
		label_2.setImmediate(false);
		label_2.setWidth("234px");
		label_2.setHeight("-1px");
		label_2.setValue("Administración Empresa");
		pnl2.addComponent(label_2);
		pnl2.setComponentAlignment(label_2, new Alignment(20));
		
		// pnl2_1
		pnl2_1 = buildPnl2_1();
		pnl2.addComponent(pnl2_1);
		
		// pnl2_2
		pnl2_2 = buildPnl2_2();
		pnl2.addComponent(pnl2_2);
		pnl2.setComponentAlignment(pnl2_2, new Alignment(9));
		
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
		txtRazonSocial.setMaxLength(400);
		pnl2_1.addComponent(txtRazonSocial);
		
		// txtRuc
		txtRuc = new TextField();
		txtRuc.setCaption("RUC");
		txtRuc.setImmediate(false);
		txtRuc.setWidth("-1px");
		txtRuc.setHeight("-1px");
		txtRuc.setRequired(true);
		txtRuc.setMaxLength(11);
		pnl2_1.addComponent(txtRuc);
		
		// txtDireccion
		txtDireccion = new TextField();
		txtDireccion.setCaption("Dirección");
		txtDireccion.setImmediate(false);
		txtDireccion.setWidth("300px");
		txtDireccion.setHeight("-1px");
		txtDireccion.setRequired(true);
		txtDireccion.setMaxLength(500);
		pnl2_1.addComponent(txtDireccion);
		
		// txtPartida
		txtPartida = new TextField();
		txtPartida.setCaption("Partida Reg");
		txtPartida.setImmediate(false);
		txtPartida.setWidth("-1px");
		txtPartida.setHeight("-1px");
		txtPartida.setMaxLength(50);
		pnl2_1.addComponent(txtPartida);
		
		// pnl2_1_1
		pnl2_1_1 = buildPnl2_1_1();
		pnl2_1.addComponent(pnl2_1_1);
		
		// txtTelefono
		txtTelefono = new TextField();
		txtTelefono.setCaption("Teléfono");
		txtTelefono.setImmediate(false);
		txtTelefono.setWidth("139px");
		txtTelefono.setHeight("-1px");
		txtTelefono.setMaxLength(30);
		pnl2_1.addComponent(txtTelefono);
		
		// cmbEstado
		cmbEstado = new ComboBox();
		cmbEstado.setCaption("Estado");
		cmbEstado.setImmediate(false);
		cmbEstado.setWidth("136px");
		cmbEstado.setHeight("-1px");
		cmbEstado.setRequired(true);
		pnl2_1.addComponent(cmbEstado);
		
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
		btnCrearRepresentante.setImmediate(true);
		btnCrearRepresentante.setWidth("-1px");
		btnCrearRepresentante.setHeight("-1px");
		pnl2_1_1.addComponent(btnCrearRepresentante);
		pnl2_1_1.setComponentAlignment(btnCrearRepresentante, new Alignment(10));
		
		return pnl2_1_1;
	}
	@AutoGenerated
	private HorizontalLayout buildPnl2_2() {
		// common part: create layout
		pnl2_2 = new HorizontalLayout();
		pnl2_2.setImmediate(false);
		pnl2_2.setWidth("116px");
		pnl2_2.setHeight("-1px");
		pnl2_2.setMargin(false);
		
		// btnAgregar
		btnAgregar = new Button();
		btnAgregar.setCaption("Agregar");
		btnAgregar.setImmediate(true);
		btnAgregar.setWidth("-1px");
		btnAgregar.setHeight("-1px");
		pnl2_2.addComponent(btnAgregar);
		
		return pnl2_2;
	}
	
	public void obtenerDatosPersona() {
		lstRepresentantes = personaService.buscar(null);
		cmbRepresentante.setContainerDataSource(new BeanItemContainer<Persona>(Persona.class, lstRepresentantes));
		
		for (Persona persona : lstRepresentantes) {
			if (persona.getId().equals(personaPopUp.getId()))
				cmbRepresentante.select(persona);
		}
	}

}
