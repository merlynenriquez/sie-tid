package pe.gob.mininter.dirandro.vaadin.panel.mantenimiento;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.model.TipoHecho;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.TipoHechoService;
import pe.gob.mininter.dirandro.service.ValorService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.vaadin.util.DirandroComponent;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutListener;
import com.vaadin.ui.AbstractSelect.Filtering;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.TreeTable;
import com.vaadin.ui.VerticalLayout;

public class PanelMantenTipoHecho extends DirandroComponent implements TextChangeListener, ValueChangeListener, ClickListener{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout pnlPrincipal;
	@AutoGenerated
	private VerticalLayout verticalLayout_4;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_3;
	@AutoGenerated
	private Button btnEliminar;
	@AutoGenerated
	private Button btnAgregar;
	@AutoGenerated
	private ComboBox cmbEstado;
	@AutoGenerated
	private ComboBox cmbDelitoPadre;
	@AutoGenerated
	private TextField txtNombre;
	@AutoGenerated
	private VerticalLayout verticalLayout_3;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_4;
	@AutoGenerated
	private TreeTable treeTipoHecho;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private TextField txtFiltroNombre;
	/**
	 * 
	 */
	private static final long serialVersionUID = 168507277037628930L;
	private TipoHechoService tipoHechoService;
	private ValorService valorService;
	private TipoHecho tipoHecho;
	private List<TipoHecho> lstTipoHechoPadre;
	private boolean flagNuevaEstado;
	private List<Valor> lstEstados;
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelMantenTipoHecho(List<Opcion> acciones, String height) {
		super(acciones, height);
		tipoHechoService = Injector.obtenerServicio(TipoHechoService.class);
		valorService = Injector.obtenerServicio(ValorService.class);
		buildMainLayout();
		setCompositionRoot(mainLayout);
		postConstruct();
		debugId();
	}
	
	private void debugId(){
		
	}
	
	public void postConstruct() {
		btnAgregar.setIcon(Constante.ICONOS.SAVE);
		btnEliminar.setIcon(Constante.ICONOS.DELETE);
		habilitarEdicion(false);
		
		txtFiltroNombre.setInputPrompt("Tipo de Hecho");
	    txtFiltroNombre.setImmediate(true);
	    txtFiltroNombre.addShortcutListener(new ShortcutListener("", KeyCode.ENTER, null) {
			
			private static final long serialVersionUID = 4068232062569621771L;

			@Override
			public void handleAction(Object sender, Object target) {
				shortCutEnter(sender, target);
			}
		});
	    
		treeTipoHecho.setSelectable(true);
		treeTipoHecho.setImmediate(true);
		treeTipoHecho.setNullSelectionAllowed(true);
		treeTipoHecho.setNullSelectionItemId(null);
		treeTipoHecho.addListener(new ValueChangeListener() {
			private static final long serialVersionUID = -6124596484581515359L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				boolean esModoNuevo = treeTipoHecho.getValue() == null;
				limpiar();
				if(esModoNuevo){
					treeTipoHecho.setValue(null);
					habilitarEdicion(!esModoNuevo);
				}else {					
					Item item = treeTipoHecho.getItem(treeTipoHecho.getValue());
					tipoHecho.setId(Long.valueOf(item.getItemProperty("id").getValue().toString()));
					txtNombre.setValue(item.getItemProperty("nombre").getValue());
					
					for (TipoHecho tipo : lstTipoHechoPadre) {
						if(tipo.getId().equals((Long)item.getItemProperty("padre.id").getValue())){
							cmbDelitoPadre.select(tipo);
							break;
						}
					}
						
					for (Valor estado : lstEstados) {
						if(estado.getId().equals((Long)item.getItemProperty("estado.id").getValue())){
							cmbEstado.select(estado);
							break;
						}
					}
					
					habilitarEdicion(!esModoNuevo);
					
				}
			}
		});
		//TODO: validar que cargue bien el combo de padres
		lstTipoHechoPadre = tipoHechoService.listarTipoHecho();
		cmbDelitoPadre.setInputPrompt("Padre");
		cmbDelitoPadre.setContainerDataSource( new BeanItemContainer<TipoHecho>(TipoHecho.class, lstTipoHechoPadre));
		cmbDelitoPadre.setItemCaptionPropertyId("nombre");
		cmbDelitoPadre.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
		
		lstEstados = valorService.obtenerLista(Constante.LISTA.CODIGO.ESTADO);
		cmbEstado.setContainerDataSource( new BeanItemContainer<Valor>(Valor.class,  lstEstados));
		cmbEstado.setItemCaptionPropertyId("nombre");
		cmbEstado.setInputPrompt("Estado");
		
		btnAgregar.addListener((ClickListener)this);
		btnEliminar.addListener((ClickListener)this);
		refrescar();
	}

	private void refrescar(){
		habilitarEdicion(false);
		limpiar();
		cargarTiposDeHechos(tipoHechoService.listarTipoHechoMap());
	}
	
	private void limpiar(){
		///lblIdEntidad.setValue("");
		flagNuevaEstado=true;
		tipoHecho = new TipoHecho();
		cmbDelitoPadre.select(null);
		cmbEstado.select(null);
		txtNombre.setValue("");
		
	}	

	private void habilitarEdicion(boolean flag){
		flagNuevaEstado = !flag;
		btnEliminar.setVisible(flag);
		if(flag){
			btnAgregar.setCaption("Actualizar");
		}
		else{
			btnAgregar.setCaption("Crear");
		}
	}
	
	private void cargarTiposDeHechos(Map<String,List<TipoHecho>> map){

		HierarchicalContainer hwContainer = new HierarchicalContainer();

		hwContainer.addContainerProperty("id", Long.class, 0L);
		hwContainer.addContainerProperty("nombre", String.class, "");
		hwContainer.addContainerProperty("estado", Valor.class, null);
		hwContainer.addContainerProperty("estado.id", Long.class, null);
		hwContainer.addContainerProperty("padre", TipoHecho.class, null);
		hwContainer.addContainerProperty("padre.id", Long.class, null);		
		
		if(map.get(Constante.OPCION.KEY_PADRE) != null){
			recorrer(Constante.OPCION.KEY_PADRE, map, null, hwContainer);
		}
		treeTipoHecho.setContainerDataSource(hwContainer);		
		treeTipoHecho.setItemCaptionPropertyId("nombre");
		
		treeTipoHecho.setVisibleColumns(new Object[]{"nombre"});
		
		for (Object id : treeTipoHecho.rootItemIds()) 
			treeTipoHecho.setCollapsed(id, false);
		
		for (Object itemId: treeTipoHecho.getItemIds())
			treeTipoHecho.setCollapsed(itemId, false);
		
		treeTipoHecho.setPageLength(treeTipoHecho.size());

	}

	private void recorrer(String nombre, Map<String, List<TipoHecho>> map, Long objPadre, HierarchicalContainer hwContainer) {
		Item item = null;
		for (TipoHecho delito : map.get(nombre)) {
			
			item = hwContainer.addItem(delito.getId());
			item.getItemProperty("id").setValue(delito.getId());
			item.getItemProperty("nombre").setValue(delito.getNombre());
			item.getItemProperty("estado").setValue(delito.getEstado() == null ? null : delito.getEstado());
			item.getItemProperty("estado.id").setValue(delito.getEstado().getId() == null ? null: delito.getEstado().getId());
			item.getItemProperty("padre").setValue(delito.getPadre() == null ? null : delito.getPadre());
			item.getItemProperty("padre.id").setValue(delito.getPadre() == null ? null: delito.getPadre().getId());
			
			if (!nombre.equals(Constante.OPCION.KEY_PADRE)) {
				hwContainer.setParent(delito.getId(), objPadre);
			}
			if (map.get(delito.getId().toString()) != null) {
				recorrer(delito.getId().toString(), map, delito.getId(),hwContainer);
			} else {
				hwContainer.setChildrenAllowed(delito.getId().toString(), false);
			}
		}
	}

	private void shortCutEnter(Object sender, Object target){
		TipoHecho delito = null;
		if (StringUtils.isNotBlank(target.toString())) {
			if(txtFiltroNombre.equals(target)){
				delito = new TipoHecho();
				if(StringUtils.isNotBlank(txtFiltroNombre.getValue().toString())){
					delito.setNombre(txtFiltroNombre.getValue().toString());
				}
				Map<String,List<TipoHecho>> map = tipoHechoService.filtrarTipoHecho(tipoHechoService.buscarPadreHijos(delito));
				cargarTiposDeHechos(map);
			}
		}else {
			refrescar();
		}
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnAgregar)){
			
			tipoHecho.setNombre(txtNombre.getValue().toString());
			tipoHecho.setEstado((Valor)cmbEstado.getValue());
			tipoHecho.setPadre((TipoHecho)cmbDelitoPadre.getValue());
			
			if(flagNuevaEstado){
				tipoHechoService.crear(tipoHecho);
			}else{
				tipoHechoService.actualizar(tipoHecho);
			}
		}
		if(event.getButton().equals(btnEliminar)){
			tipoHechoService.eliminarXId(tipoHecho.getId());
		}
		refrescar();
	}
	@Override
	public void valueChange(ValueChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void textChange(TextChangeEvent event) {
		// TODO Auto-generated method stub
		
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
		pnlPrincipal.setHeight("-1px");
		pnlPrincipal.setMargin(true);
		pnlPrincipal.setSpacing(true);
		
		// verticalLayout_3
		verticalLayout_3 = buildVerticalLayout_3();
		pnlPrincipal.addComponent(verticalLayout_3);
		
		// verticalLayout_4
		verticalLayout_4 = buildVerticalLayout_4();
		pnlPrincipal.addComponent(verticalLayout_4);
		
		return pnlPrincipal;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_3() {
		// common part: create layout
		verticalLayout_3 = new VerticalLayout();
		verticalLayout_3.setStyleName("h2");
		verticalLayout_3.setCaption("Filtro de Busqueda");
		verticalLayout_3.setImmediate(false);
		verticalLayout_3.setWidth("-1px");
		verticalLayout_3.setHeight("-1px");
		verticalLayout_3.setMargin(false);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		verticalLayout_3.addComponent(horizontalLayout_1);
		
		// horizontalLayout_4
		horizontalLayout_4 = buildHorizontalLayout_4();
		verticalLayout_3.addComponent(horizontalLayout_4);
		
		return verticalLayout_3;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("100.0%");
		horizontalLayout_1.setHeight("-1px");
		horizontalLayout_1.setMargin(false);
		horizontalLayout_1.setSpacing(true);
		
		// txtFiltroNombre
		txtFiltroNombre = new TextField();
		txtFiltroNombre.setImmediate(false);
		txtFiltroNombre.setWidth("100.0%");
		txtFiltroNombre.setHeight("-1px");
		txtFiltroNombre.setInputPrompt("Tipo de Hecho");
		horizontalLayout_1.addComponent(txtFiltroNombre);
		
		return horizontalLayout_1;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_4() {
		// common part: create layout
		horizontalLayout_4 = new HorizontalLayout();
		horizontalLayout_4.setImmediate(false);
		horizontalLayout_4.setWidth("-1px");
		horizontalLayout_4.setHeight("-1px");
		horizontalLayout_4.setMargin(false);
		
		// treeTipoHecho
		treeTipoHecho = new TreeTable();
		treeTipoHecho.setImmediate(false);
		treeTipoHecho.setWidth("500px");
		treeTipoHecho.setHeight("350px");
		horizontalLayout_4.addComponent(treeTipoHecho);
		
		return horizontalLayout_4;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_4() {
		// common part: create layout
		verticalLayout_4 = new VerticalLayout();
		verticalLayout_4.setStyleName("h2");
		verticalLayout_4.setCaption("Administración de Tipos de Hechos");
		verticalLayout_4.setImmediate(false);
		verticalLayout_4.setWidth("-1px");
		verticalLayout_4.setHeight("-1px");
		verticalLayout_4.setMargin(true);
		verticalLayout_4.setSpacing(true);
		
		// txtNombre
		txtNombre = new TextField();
		txtNombre.setCaption("Nombre");
		txtNombre.setImmediate(false);
		txtNombre.setWidth("300px");
		txtNombre.setHeight("-1px");
		txtNombre.setRequired(true);
		txtNombre.setInputPrompt("Nombre del Tipo de Hecho");
		verticalLayout_4.addComponent(txtNombre);
		
		// cmbDelitoPadre
		cmbDelitoPadre = new ComboBox();
		cmbDelitoPadre.setCaption("Nivel Superior");
		cmbDelitoPadre.setImmediate(false);
		cmbDelitoPadre.setWidth("-1px");
		cmbDelitoPadre.setHeight("-1px");
		verticalLayout_4.addComponent(cmbDelitoPadre);
		
		// cmbEstado
		cmbEstado = new ComboBox();
		cmbEstado.setCaption("Estado");
		cmbEstado.setImmediate(false);
		cmbEstado.setWidth("-1px");
		cmbEstado.setHeight("-1px");
		cmbEstado.setRequired(true);
		verticalLayout_4.addComponent(cmbEstado);
		
		// horizontalLayout_3
		horizontalLayout_3 = buildHorizontalLayout_3();
		verticalLayout_4.addComponent(horizontalLayout_3);
		verticalLayout_4.setComponentAlignment(horizontalLayout_3,
				new Alignment(20));
		
		return verticalLayout_4;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_3() {
		// common part: create layout
		horizontalLayout_3 = new HorizontalLayout();
		horizontalLayout_3.setImmediate(false);
		horizontalLayout_3.setWidth("-1px");
		horizontalLayout_3.setHeight("-1px");
		horizontalLayout_3.setMargin(true);
		horizontalLayout_3.setSpacing(true);
		
		// btnAgregar
		btnAgregar = new Button();
		btnAgregar.setCaption("Agregar");
		btnAgregar.setImmediate(true);
		btnAgregar.setWidth("-1px");
		btnAgregar.setHeight("-1px");
		horizontalLayout_3.addComponent(btnAgregar);
		
		// btnEliminar
		btnEliminar = new Button();
		btnEliminar.setCaption("Eliminar");
		btnEliminar.setImmediate(true);
		btnEliminar.setWidth("-1px");
		btnEliminar.setHeight("-1px");
		horizontalLayout_3.addComponent(btnEliminar);
		
		return horizontalLayout_3;
	}
	
}