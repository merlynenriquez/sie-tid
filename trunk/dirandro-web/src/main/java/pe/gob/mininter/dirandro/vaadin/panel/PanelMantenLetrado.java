package pe.gob.mininter.dirandro.vaadin.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import pe.gob.mininter.dirandro.model.Letrado;
import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.model.Pais;
import pe.gob.mininter.dirandro.model.Persona;
import pe.gob.mininter.dirandro.model.Usuario;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.LetradoService;
import pe.gob.mininter.dirandro.service.PersonaService;
import pe.gob.mininter.dirandro.service.PoliciaService;
import pe.gob.mininter.dirandro.service.UbigeoService;
import pe.gob.mininter.dirandro.service.ValorService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;
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


public class PanelMantenLetrado extends DirandroComponent implements TextChangeListener,ClickListener {
	
	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout pnlPrincipal;
	@AutoGenerated
	private VerticalLayout pnlDatos;
	@AutoGenerated
	private VerticalLayout pnlDatos1;
	@AutoGenerated
	private Button btnAgregar;
	@AutoGenerated
	private TextField txtColegiatura;
	@AutoGenerated
	private ComboBox cmbTipo;
	@AutoGenerated
	private HorizontalLayout pnlDatos1_3;
	@AutoGenerated
	private TextField txtNacionalidad;
	@AutoGenerated
	private TextField txtSexo;
	@AutoGenerated
	private HorizontalLayout pnlDatos1_2;
	@AutoGenerated
	private TextField txtNumero;
	@AutoGenerated
	private TextField txtTipoDoc;
	@AutoGenerated
	private HorizontalLayout pnlDatos1_1;
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
	 * 
	 */
	private static final long serialVersionUID = -2300724647915630886L;
	private List<Valor> lstTipoDocumento;
		
	private List<Valor> lstSexo;
	
	private List<Pais> lstNacionalidad;
	
	private List<Valor> lstTipoLetrado;
	
	private PoliciaService policiaService;
	
	private PanelAgregarPersona pnlAgregarPersona;
	
	private ValorService valorService;
	
	private LetradoService letradoService;	
	
	private PersonaService personaService;
	
	private UbigeoService ubigeoService;
	
	
	
	private boolean flagNuevaEstado;
	
	private Letrado letrado;
	
	List<Persona> lstPersonas;
	
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
		
		valorService = Injector.obtenerServicio(ValorService.class);
		
		letradoService = Injector.obtenerServicio(LetradoService.class);		
		
		personaService = Injector.obtenerServicio(PersonaService.class);
		
		ubigeoService = Injector.obtenerServicio(UbigeoService.class );
		
		postConstruct();
		debugId();
	}
	
	private void debugId(){
		
	}
	
	public void postConstruct() {
		
		btnNuevo.addListener((ClickListener)this);
		btnAgregar.addListener((ClickListener)this);
		btnNuevo.setIcon(Constante.ICONOS.CREATE);
		//cmbTipoDoc.setEnabled(false);
		//cargarParametros(parametros, true);
		cargaLista();
		habilitarEdicion(false);
		
		this.txtfiltroNomLetrado.addListener((TextChangeListener)this);
		this.txtfiltroApellidoLetrado.addListener((TextChangeListener)this);
		this.txtfiltroNroDniLetrado.addListener((TextChangeListener)this);
		
		tblLetrados.setSelectable(true);
		tblLetrados.setImmediate(true);
		tblLetrados.setNullSelectionAllowed(true);
		tblLetrados.setNullSelectionItemId(null);
		tblLetrados.addListener(new ValueChangeListener() {
			
			private static final long serialVersionUID = 7962790507398071986L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				boolean esModoNuevo = tblLetrados.getValue() == null;
				if(esModoNuevo){
					tblLetrados.setValue(null);
					habilitarEdicion(false);
				}
				else{
					habilitarEdicion(true);
					Item item = tblLetrados.getItem(tblLetrados.getValue());
					
					letrado = letradoService.obtener(new Long( item.getItemProperty("id").getValue().toString() ));
					
					txtColegiatura.setValue(letrado.getNroColegiatura());
					
					Valor tipo = valorService.obtener(Long.parseLong(letrado.getTipo().toString()));
					
					cmbTipo.setValue(tipo);
					
					Long idPersona = letrado.getPerPersona().getId();
					Persona p = BuscarPersonaenLista(idPersona);
					cmbPersona.setValue(p);
					
					txtTipoDoc.setValue(letrado.getPerPersona().getTipoDocumento().getNombre());
					txtNumero.setValue(letrado.getPerPersona().getNroDocumento());
					
					txtSexo.setValue(letrado.getPerPersona().getSexo() == "F" ? "Femenino" : "Masculino");
					
					txtNacionalidad.setValue(letrado.getPerPersona().getNacionalidad().getNombre());
															
				}
			}
		});
				
		letrado = new Letrado();
		letrado.setPerPersona( new Persona());
		
		List<Letrado> lista = letradoService.listarLetrado();
		cargarLetrados(lista, true);			
	}
	
	private Persona BuscarPersonaenLista(Long Id)
	{
		for(int n=0; n<this.lstPersonas.size(); n++)
		{
			if(this.lstPersonas.get(n).getId() == Id)
				return this.lstPersonas.get(n);
		}
		
		return null;
	}
	
	public void cargaLista(){
		
		/*cmbTipoDoc.setInputPrompt("tipoDocumento");				
		lstTipoDocumento = valorService.obtenerLista(Constante.LISTA.CODIGO.DOCUMENTO_TIPO);		
		BeanItemContainer<Valor> bicTipoDocumentos = new BeanItemContainer<Valor>(Valor.class,  lstTipoDocumento);		
		cmbTipoDoc.setContainerDataSource(bicTipoDocumentos);		
		cmbTipoDoc.setItemCaptionPropertyId("nombre");*/
		
		cmbTipo.setInputPrompt("tipoLetrado");				
		lstTipoLetrado = valorService.obtenerLista(Constante.LISTA.CODIGO.TIPO_LETRADO);		
		BeanItemContainer<Valor> bicTipoLetrado = new BeanItemContainer<Valor>(Valor.class,  lstTipoLetrado);		
		cmbTipo.setContainerDataSource(bicTipoLetrado);		
		cmbTipo.setItemCaptionPropertyId("nombre");
		
		/*lstNacionalidad = ubigeoService.obtenerPaises();
		cmbNacionalidad.setInputPrompt("Nacionalidad");
		cmbNacionalidad.setItemCaptionPropertyId("nombre");
		cmbNacionalidad.setContainerDataSource(new BeanItemContainer<Pais>(Pais.class, lstNacionalidad));*/
		
		/*cbmSexo.setInputPrompt("sexo");
		lstSexo = valorService.obtenerLista(Constante.LISTA.CODIGO.SEXO);
		cbmSexo.setContainerDataSource(new BeanItemContainer<Valor>(Valor.class, lstSexo));
		cbmSexo.setItemCaptionPropertyId("nombre");*/
		
		lstPersonas = personaService.buscar(null);
		cmbPersona.setInputPrompt("Persona");
		cmbPersona.setItemCaptionPropertyId("nombreCompleto");
		cmbPersona.setContainerDataSource(new BeanItemContainer<Persona>(Persona.class, lstPersonas));
		
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
	
	private void cargarLetrados(List<Letrado> listLetrado, boolean flagLimpiar){
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("id", Long.class,  null);

		container.addContainerProperty("nombres", String.class, null);
		container.addContainerProperty("ape_paterno", String.class, null);
		container.addContainerProperty("nro_documento", String.class, null);
		
		tblLetrados.setContainerDataSource(container);
		tblLetrados.setVisibleColumns(new Object[]{"nombres", "ape_paterno", "nro_documento"});
	
		tblLetrados.setColumnWidth("nombres", 105);
		tblLetrados.setColumnWidth("ape_paterno", 110);
		tblLetrados.setColumnWidth("nro_documento", 105);
				
		tblLetrados.setColumnHeader("nombres", "Nombre");
		tblLetrados.setColumnHeader("ape_paterno", "Paterno");
		
		int con=1;
		for (Letrado p: listLetrado){
			Item item = container.addItem(con++);
			item.getItemProperty("id").setValue(p.getId());
			item.getItemProperty("nombres").setValue(p.getPerPersona().getNombres() );
			item.getItemProperty("ape_paterno").setValue(p.getPerPersona().getApePaterno());
			item.getItemProperty("nro_documento").setValue(p.getPerPersona().getNroDocumento() );
		}		
		if(flagLimpiar){
			txtfiltroNomLetrado.setValue("");
			txtfiltroApellidoLetrado.setValue("");
			txtfiltroNroDniLetrado.setValue("");
		}
	}
		
	private void cargarWindowRegistro(Long idParte){
		pnlAgregarPersona = new PanelAgregarPersona(idParte);
		Window window=new Window(){
			
		      protected void close() {
		    	  
		      }};
		      
		//Enlazo los controles del Padre al Hijo
		this.pnlAgregarPersona.setParent_txtNumeroDocumento(this.txtNumero);
		this.pnlAgregarPersona.setParent_cmbNombres(this.cmbPersona);
		this.pnlAgregarPersona.setParent_txtTipoDocumento(this.txtTipoDoc);
		this.pnlAgregarPersona.setParent_txtSexo(this.txtSexo);
		this.pnlAgregarPersona.setParent_txtNacionalidad(this.txtNacionalidad);
		
		window.setCaption("Registrar Persona");
		pnlAgregarPersona.setPersona(letrado.getPerPersona());
		window.addComponent(pnlAgregarPersona);
		window.setModal(true);
		window.setResizable(false);
		window.setWidth("650px");
		window.setHeight("-1px");
		getWindow().addWindow(window);
		
	}
		
	@Override
	public void buttonClick(ClickEvent event) {
		
		if (event.getButton().equals(btnNuevo)) {
			cargarWindowRegistro(1L);
		} else if (event.getButton().equals(btnAgregar)) {			
			if(flagNuevaEstado){
				actualizaLetrado();
			}
			else{
				registrarLetrado();
			}
			List<Letrado> lista = letradoService.listarLetrado();
			cargarLetrados(lista, true);
		}
	}
	
	private void registrarLetrado(){
		Usuario usuario = HarecUtil.obtenerUsuarioSesion();
		letrado =  new Letrado();
		
		letrado.setPerPersona((Persona)cmbPersona.getValue());
		letrado.setTipo(new BigDecimal(((Valor)cmbTipo.getValue()).getId()));
		letrado.setNroColegiatura(txtColegiatura.getValue().toString());	
		letrado.setCreador(usuario);
		letrado.setCreacion(new Date());
		letrado.setEditor(usuario);
		letrado.setEdicion(new Date());
		
		letradoService.crear(letrado);
		
	}
	
	private void actualizaLetrado(){
				
		Usuario usuario = HarecUtil.obtenerUsuarioSesion();
		
		letrado.setPerPersona((Persona)cmbPersona.getValue());
		letrado.setTipo(new BigDecimal(((Valor)cmbTipo.getValue()).getId()));
		letrado.setNroColegiatura(txtColegiatura.getValue().toString());	
		letrado.setCreador(usuario);
		letrado.setCreacion(new Date());
		letrado.setEditor(usuario);
		letrado.setEdicion(new Date());
		
		letradoService.actualizar(letrado);
		
	}
	
	
	@Override
	public void textChange(TextChangeEvent event) {
		Letrado l= new Letrado();
		l.setPerPersona(new Persona());		
		
			if (event.getSource().equals(this.txtfiltroNomLetrado)) {
				l.getPerPersona().setNombres(event.getText());
								
			}
			
				if (event.getSource().equals(this.txtfiltroApellidoLetrado)) {		
					l.getPerPersona().setApePaterno(event.getText());					
				}
				
				
					if (event.getSource().equals(this.txtfiltroNroDniLetrado)) {		
						l.getPerPersona().setNroDocumento(event.getText());					
					}			
			
		List<Letrado> lista = letradoService.buscar(l);
		cargarLetrados(lista, false);
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
		lblFiltro.setValue("Filtro de Letrados");
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
		
		// pnlDatos1
		pnlDatos1 = buildPnlDatos1();
		pnlDatos.addComponent(pnlDatos1);
		
		return pnlDatos;
	}

	@AutoGenerated
	private VerticalLayout buildPnlDatos1() {
		// common part: create layout
		pnlDatos1 = new VerticalLayout();
		pnlDatos1.setImmediate(false);
		pnlDatos1.setWidth("-1px");
		pnlDatos1.setHeight("-1px");
		pnlDatos1.setMargin(false);
		
		// pnlDatos1_1
		pnlDatos1_1 = buildPnlDatos1_1();
		pnlDatos1.addComponent(pnlDatos1_1);
		
		// pnlDatos1_2
		pnlDatos1_2 = buildPnlDatos1_2();
		pnlDatos1.addComponent(pnlDatos1_2);
		
		// pnlDatos1_3
		pnlDatos1_3 = buildPnlDatos1_3();
		pnlDatos1.addComponent(pnlDatos1_3);
		
		// cmbTipo
		cmbTipo = new ComboBox();
		cmbTipo.setCaption("Tipo Letrado");
		cmbTipo.setImmediate(false);
		cmbTipo.setWidth("106px");
		cmbTipo.setHeight("-1px");
		cmbTipo.setRequired(true);
		pnlDatos1.addComponent(cmbTipo);
		
		// txtColegiatura
		txtColegiatura = new TextField();
		txtColegiatura.setCaption("Colegiatura");
		txtColegiatura.setImmediate(false);
		txtColegiatura.setWidth("106px");
		txtColegiatura.setHeight("-1px");
		pnlDatos1.addComponent(txtColegiatura);
		
		// btnAgregar
		btnAgregar = new Button();
		btnAgregar.setCaption("Agregar");
		btnAgregar.setImmediate(true);
		btnAgregar.setWidth("-1px");
		btnAgregar.setHeight("-1px");
		pnlDatos1.addComponent(btnAgregar);
		pnlDatos1.setComponentAlignment(btnAgregar, new Alignment(48));
		
		return pnlDatos1;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlDatos1_1() {
		// common part: create layout
		pnlDatos1_1 = new HorizontalLayout();
		pnlDatos1_1.setImmediate(false);
		pnlDatos1_1.setWidth("-1px");
		pnlDatos1_1.setHeight("-1px");
		pnlDatos1_1.setMargin(false);
		
		// cmbPersona
		cmbPersona = new ComboBox();
		cmbPersona.setCaption("Nombre Apellido Letrado");
		cmbPersona.setImmediate(false);
		cmbPersona.setWidth("230px");
		cmbPersona.setHeight("-1px");
		cmbPersona.setRequired(true);
		pnlDatos1_1.addComponent(cmbPersona);
		
		// btnNuevo
		btnNuevo = new Button();
		btnNuevo.setCaption("Nuevo");
		btnNuevo.setImmediate(true);
		btnNuevo.setWidth("-1px");
		btnNuevo.setHeight("-1px");
		pnlDatos1_1.addComponent(btnNuevo);
		pnlDatos1_1.setComponentAlignment(btnNuevo, new Alignment(24));
		
		return pnlDatos1_1;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlDatos1_2() {
		// common part: create layout
		pnlDatos1_2 = new HorizontalLayout();
		pnlDatos1_2.setImmediate(false);
		pnlDatos1_2.setWidth("-1px");
		pnlDatos1_2.setHeight("-1px");
		pnlDatos1_2.setMargin(false);
		
		// txtTipoDoc
		txtTipoDoc = new TextField();
		txtTipoDoc.setCaption("Tipo Documento");
		txtTipoDoc.setImmediate(false);
		txtTipoDoc.setWidth("-1px");
		txtTipoDoc.setHeight("-1px");
		pnlDatos1_2.addComponent(txtTipoDoc);
		
		// txtNumero
		txtNumero = new TextField();
		txtNumero.setCaption("Número");
		txtNumero.setImmediate(false);
		txtNumero.setWidth("-1px");
		txtNumero.setHeight("-1px");
		pnlDatos1_2.addComponent(txtNumero);
		
		return pnlDatos1_2;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlDatos1_3() {
		// common part: create layout
		pnlDatos1_3 = new HorizontalLayout();
		pnlDatos1_3.setImmediate(false);
		pnlDatos1_3.setWidth("-1px");
		pnlDatos1_3.setHeight("-1px");
		pnlDatos1_3.setMargin(false);
		
		// txtSexo
		txtSexo = new TextField();
		txtSexo.setCaption("Sexo");
		txtSexo.setImmediate(false);
		txtSexo.setWidth("80px");
		txtSexo.setHeight("-1px");
		pnlDatos1_3.addComponent(txtSexo);
		
		// txtNacionalidad
		txtNacionalidad = new TextField();
		txtNacionalidad.setCaption("Nacionalidad");
		txtNacionalidad.setImmediate(false);
		txtNacionalidad.setWidth("180px");
		txtNacionalidad.setHeight("-1px");
		pnlDatos1_3.addComponent(txtNacionalidad);
		
		return pnlDatos1_3;
	}
	

}
