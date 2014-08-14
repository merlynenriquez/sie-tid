package pe.gob.mininter.dirandro.vaadin.panel;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.Estado;
import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.EstadoService;
import pe.gob.mininter.dirandro.service.ValorService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.vaadin.util.HarecComponent;
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

public class PanelMantenEstado extends HarecComponent implements TextChangeListener,ClickListener{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout pnlPrincipal;
	@AutoGenerated
	private VerticalLayout pnlDatosEstado;
	@AutoGenerated
	private HorizontalLayout pnlEstadoBotones;
	@AutoGenerated
	private Button btnCrearEstado;
	@AutoGenerated
	private ComboBox cmbEstado;
	@AutoGenerated
	private TextField txtDescripcion;
	@AutoGenerated
	private TextField txtNombre;
	@AutoGenerated
	private HorizontalLayout pnlEstadoCodigo;
	@AutoGenerated
	private TextField txtCodigo;
	@AutoGenerated
	private Label lblIdEstado;
	@AutoGenerated
	private VerticalLayout pnlListadoEstado;
	@AutoGenerated
	private Table tblEstado;
	@AutoGenerated
	private HorizontalLayout pnlEstadoFiltros;
	@AutoGenerated
	private TextField txtFiltroDescripcion;
	@AutoGenerated
	private TextField txtFiltroNombre;
	@AutoGenerated
	private TextField txtFiltroCodigo;
	@AutoGenerated
	private Label lblFiltroBusqueda;
	private static final long serialVersionUID = 8017458567665421578L;
	
	private EstadoService estadoService;
	private ValorService valorService;
	private boolean flagNuevaEstado;
	
	public PanelMantenEstado(List<Opcion> acciones, String height){
		super(acciones, height);
		estadoService = Injector.obtenerServicio(EstadoService.class);
		valorService = Injector.obtenerServicio(ValorService.class);
		buildMainLayout();
		setCompositionRoot(mainLayout);
		postConstruct(); 
	}
	
	@Override
	public void postConstruct() {
		
		btnCrearEstado.setIcon(Constante.ICONOS.SAVE);
		
		btnCrearEstado.addListener((ClickListener)this);
		lblIdEstado.setValue("");
		
		cmbEstado.setInputPrompt("Estado");
		cmbEstado.setItemCaptionPropertyId("nombre");
		
		txtFiltroCodigo.addListener((TextChangeListener)this);
		txtFiltroNombre.addListener((TextChangeListener)this);
		txtFiltroDescripcion.addListener((TextChangeListener)this);
		
		txtFiltroCodigo.setImmediate(true);
		txtFiltroNombre.setImmediate(true);
		txtFiltroDescripcion.setImmediate(true);
		
		habilitarEdicion(false);
		
		tblEstado.setSelectable(true);
		tblEstado.setImmediate(true);
		tblEstado.setNullSelectionAllowed(true);
		tblEstado.setNullSelectionItemId(null);
		tblEstado.addListener(new ValueChangeListener() {
			private static final long serialVersionUID = -6124596484581515359L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				boolean esModoNuevo = tblEstado.getValue() == null;				
				if(esModoNuevo){
					tblEstado.setValue(null);
					habilitarEdicion(!esModoNuevo);
				}else {
					habilitarEdicion(!esModoNuevo);
					Item item = tblEstado.getItem(tblEstado.getValue());
					lblIdEstado.setValue(item.getItemProperty("id").getValue());
					txtCodigo.setValue(item.getItemProperty("codigo").getValue());
					txtNombre.setValue(item.getItemProperty("nombre").getValue());
					txtDescripcion.setValue(item.getItemProperty("descripcion").getValue());
					cmbEstado.setValue((Valor)item.getItemProperty("estado").getValue());
				}
			}
		});
		
		List<Valor> ltEstados = valorService.obtenerLista(Constante.LISTA.CODIGO.ESTADO);		
		BeanItemContainer<Valor> bicEstados = new BeanItemContainer<Valor>(Valor.class,  ltEstados);		
		cmbEstado.setContainerDataSource(bicEstados);
		
		List<Estado> estados= estadoService.buscar(null);
		cargarEstados(estados, true);
	}
	
	private void habilitarEdicion(boolean flag){
		flagNuevaEstado = !flag;
		if(flag){
			btnCrearEstado.setCaption("Actualizar");
		}
		else{
			btnCrearEstado.setCaption("Crear");
		}
	}
	
	private void cargarEstados(List<Estado> lstEstados,boolean flagLimpiar){
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("id", Long.class,  null);
		container.addContainerProperty("codigo", String.class, null);
		container.addContainerProperty("nombre", String.class, null);
		container.addContainerProperty("descripcion", String.class, null);
		container.addContainerProperty("estado", Valor.class, null);
		
		tblEstado.setContainerDataSource(container);
		tblEstado.setVisibleColumns(new Object[]{"codigo","nombre","descripcion"});
	
		tblEstado.setColumnWidth("codigo", 110);
		tblEstado.setColumnWidth("nombre", 115);
		tblEstado.setColumnWidth("descripcion", 170);
				
		tblEstado.setColumnHeader("codigo", "Código");
		tblEstado.setColumnHeader("nombre", "Nombre");
		tblEstado.setColumnHeader("descripcion", "Descripción");
				
		int con=1;
		for (Estado estado: lstEstados){
			Item item = container.addItem(con++);
			item.getItemProperty("id").setValue(estado.getId());
			item.getItemProperty("codigo").setValue(estado.getCodigo() );
			item.getItemProperty("nombre").setValue(estado.getNombre() );
			item.getItemProperty("descripcion").setValue(estado.getDescripcion());
			item.getItemProperty("estado").setValue(estado.getEstadoExpediente());
		}		
		if(flagLimpiar){
			txtFiltroNombre.setValue("");
			txtFiltroDescripcion.setValue("");			
		}
	}
	
	private void refrescar(){
		habilitarEdicion(false);
		limpiar();
		List<Estado> lstPersonas = estadoService.buscar(null);
		cargarEstados(lstPersonas, true);
	}
	private void limpiar(){
		lblIdEstado.setValue("");
		txtCodigo.setValue("");
		txtNombre.setValue("");
		txtDescripcion.setValue("");
	}	
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnCrearEstado)){
			Estado estado = new Estado();
			estado.setCodigo((String)txtCodigo.getValue());
			estado.setDescripcion((String)txtDescripcion.getValue());
			estado.setNombre((String)txtNombre.getValue());
			estado.setEstadoExpediente( (Valor)cmbEstado.getValue());			
			if(flagNuevaEstado){
				estadoService.crear(estado);
			}
			else{
				estado.setId(Long.parseLong(lblIdEstado.getValue().toString()));
				estadoService.actualizar(estado);
			}
			refrescar();
		}
	}
	
	@Override
	public void textChange(TextChangeEvent event) {
		Estado estado= new Estado();		
		estado.setCodigo(txtCodigo.getValue().toString());
		estado.setNombre(txtFiltroNombre.getValue().toString());
		estado.setDescripcion(txtFiltroDescripcion.getValue().toString());
			
		if (StringUtils.isNotBlank(event.getText())) {
			if (event.getSource().equals(txtFiltroCodigo)) {
				estado.setCodigo(event.getText());
			}else{
				if (event.getSource().equals(txtFiltroNombre)) {		
					estado.setNombre(event.getText());					
				}else{
					if (event.getSource().equals(txtFiltroDescripcion)) {		
						estado.setDescripcion(event.getText());					
					}
				}
			}
		}		
		List<Estado> estados = estadoService.buscar(estado);
		cargarEstados(estados, false);
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
		pnlPrincipal.setHeight("-1px");
		pnlPrincipal.setMargin(true);
		pnlPrincipal.setSpacing(true);
		
		// pnlListadoEstado
		pnlListadoEstado = buildPnlListadoEstado();
		pnlPrincipal.addComponent(pnlListadoEstado);
		
		// pnlDatosEstado
		pnlDatosEstado = buildPnlDatosEstado();
		pnlPrincipal.addComponent(pnlDatosEstado);
		
		return pnlPrincipal;
	}

	@AutoGenerated
	private VerticalLayout buildPnlListadoEstado() {
		// common part: create layout
		pnlListadoEstado = new VerticalLayout();
		pnlListadoEstado.setImmediate(false);
		pnlListadoEstado.setWidth("-1px");
		pnlListadoEstado.setHeight("-1px");
		pnlListadoEstado.setMargin(false);
		
		// lblFiltroBusqueda
		lblFiltroBusqueda = new Label();
		lblFiltroBusqueda.setStyleName("h1");
		lblFiltroBusqueda.setImmediate(false);
		lblFiltroBusqueda.setWidth("-1px");
		lblFiltroBusqueda.setHeight("-1px");
		lblFiltroBusqueda.setValue("Filtro de Busqueda");
		pnlListadoEstado.addComponent(lblFiltroBusqueda);
		
		// pnlEstadoFiltros
		pnlEstadoFiltros = buildPnlEstadoFiltros();
		pnlListadoEstado.addComponent(pnlEstadoFiltros);
		
		// tblEstado
		tblEstado = new Table();
		tblEstado.setImmediate(false);
		tblEstado.setWidth("470px");
		tblEstado.setHeight("236px");
		pnlListadoEstado.addComponent(tblEstado);
		
		return pnlListadoEstado;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlEstadoFiltros() {
		// common part: create layout
		pnlEstadoFiltros = new HorizontalLayout();
		pnlEstadoFiltros.setImmediate(false);
		pnlEstadoFiltros.setWidth("-1px");
		pnlEstadoFiltros.setHeight("-1px");
		pnlEstadoFiltros.setMargin(false);
		
		// txtFiltroCodigo
		txtFiltroCodigo = new TextField();
		txtFiltroCodigo.setImmediate(false);
		txtFiltroCodigo.setWidth("-1px");
		txtFiltroCodigo.setHeight("-1px");
		txtFiltroCodigo.setInputPrompt("Código");
		pnlEstadoFiltros.addComponent(txtFiltroCodigo);
		
		// txtFiltroNombre
		txtFiltroNombre = new TextField();
		txtFiltroNombre.setImmediate(false);
		txtFiltroNombre.setWidth("-1px");
		txtFiltroNombre.setHeight("-1px");
		txtFiltroNombre.setInputPrompt("Nombre");
		pnlEstadoFiltros.addComponent(txtFiltroNombre);
		
		// txtFiltroDescripcion
		txtFiltroDescripcion = new TextField();
		txtFiltroDescripcion.setImmediate(false);
		txtFiltroDescripcion.setWidth("178px");
		txtFiltroDescripcion.setHeight("-1px");
		txtFiltroDescripcion.setInputPrompt("Descripción");
		pnlEstadoFiltros.addComponent(txtFiltroDescripcion);
		
		return pnlEstadoFiltros;
	}

	@AutoGenerated
	private VerticalLayout buildPnlDatosEstado() {
		// common part: create layout
		pnlDatosEstado = new VerticalLayout();
		pnlDatosEstado.setStyleName("h1");
		pnlDatosEstado.setCaption("Administración de Estados");
		pnlDatosEstado.setImmediate(false);
		pnlDatosEstado.setWidth("-1px");
		pnlDatosEstado.setHeight("-1px");
		pnlDatosEstado.setMargin(true);
		pnlDatosEstado.setSpacing(true);
		
		// pnlEstadoCodigo
		pnlEstadoCodigo = buildPnlEstadoCodigo();
		pnlDatosEstado.addComponent(pnlEstadoCodigo);
		
		// txtNombre
		txtNombre = new TextField();
		txtNombre.setCaption("Nombre");
		txtNombre.setImmediate(false);
		txtNombre.setWidth("220px");
		txtNombre.setHeight("-1px");
		txtNombre.setRequired(true);
		txtNombre.setInputPrompt("Nombre del Estado");
		pnlDatosEstado.addComponent(txtNombre);
		
		// txtDescripcion
		txtDescripcion = new TextField();
		txtDescripcion.setCaption("Descripción");
		txtDescripcion.setImmediate(false);
		txtDescripcion.setWidth("220px");
		txtDescripcion.setHeight("-1px");
		txtDescripcion.setRequired(true);
		txtDescripcion.setInputPrompt("Descripcion Breve de la acción ");
		pnlDatosEstado.addComponent(txtDescripcion);
		
		// cmbEstado
		cmbEstado = new ComboBox();
		cmbEstado.setCaption("Estado");
		cmbEstado.setImmediate(false);
		cmbEstado.setWidth("-1px");
		cmbEstado.setHeight("-1px");
		cmbEstado.setRequired(true);
		pnlDatosEstado.addComponent(cmbEstado);
		
		// pnlEstadoBotones
		pnlEstadoBotones = buildPnlEstadoBotones();
		pnlDatosEstado.addComponent(pnlEstadoBotones);
		pnlDatosEstado.setComponentAlignment(pnlEstadoBotones,
				new Alignment(48));
		
		return pnlDatosEstado;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlEstadoCodigo() {
		// common part: create layout
		pnlEstadoCodigo = new HorizontalLayout();
		pnlEstadoCodigo.setImmediate(false);
		pnlEstadoCodigo.setWidth("-1px");
		pnlEstadoCodigo.setHeight("-1px");
		pnlEstadoCodigo.setMargin(false);
		pnlEstadoCodigo.setSpacing(true);
		
		// lblIdEstado
		lblIdEstado = new Label();
		lblIdEstado.setImmediate(false);
		lblIdEstado.setWidth("-1px");
		lblIdEstado.setHeight("-1px");
		lblIdEstado.setValue("id");
		pnlEstadoCodigo.addComponent(lblIdEstado);
		pnlEstadoCodigo.setComponentAlignment(lblIdEstado, new Alignment(9));
		
		// txtCodigo
		txtCodigo = new TextField();
		txtCodigo.setCaption("Código");
		txtCodigo.setImmediate(false);
		txtCodigo.setWidth("-1px");
		txtCodigo.setHeight("-1px");
		txtCodigo.setRequired(true);
		txtCodigo.setInputPrompt("Código Unico");
		pnlEstadoCodigo.addComponent(txtCodigo);
		
		return pnlEstadoCodigo;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlEstadoBotones() {
		// common part: create layout
		pnlEstadoBotones = new HorizontalLayout();
		pnlEstadoBotones.setImmediate(false);
		pnlEstadoBotones.setWidth("-1px");
		pnlEstadoBotones.setHeight("-1px");
		pnlEstadoBotones.setMargin(false);
		pnlEstadoBotones.setSpacing(true);
		
		// btnCrearEstado
		btnCrearEstado = new Button();
		btnCrearEstado.setCaption("Crear");
		btnCrearEstado.setImmediate(true);
		btnCrearEstado.setWidth("-1px");
		btnCrearEstado.setHeight("-1px");
		pnlEstadoBotones.addComponent(btnCrearEstado);
		
		return pnlEstadoBotones;
	}
}
