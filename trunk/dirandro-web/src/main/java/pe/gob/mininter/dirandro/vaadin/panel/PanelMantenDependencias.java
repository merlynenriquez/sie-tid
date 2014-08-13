package pe.gob.mininter.dirandro.vaadin.panel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.Dependencia;
import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.model.Predecesor;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.DependenciaService;
import pe.gob.mininter.dirandro.service.PredecesorService;
import pe.gob.mininter.dirandro.service.ValorService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.vaadin.dialogs.ConfirmDialog;
import pe.gob.mininter.dirandro.vaadin.util.HarecComponent;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutListener;
import com.vaadin.ui.AbstractSelect.Filtering;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.TreeTable;
import com.vaadin.ui.VerticalLayout;

public class PanelMantenDependencias extends HarecComponent implements ClickListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;

	@AutoGenerated
	private HorizontalLayout pnlPrincipal;

	@AutoGenerated
	private TabSheet tabSheet;

	@AutoGenerated
	private VerticalLayout verticalLayout_2;

	@AutoGenerated
	private HorizontalLayout horizontalLayout_5;

	@AutoGenerated
	private Button btnEliminarPredecesor;

	@AutoGenerated
	private Button btnCrearPredecesor;

	@AutoGenerated
	private Table tblPredecesorDependencias;

	@AutoGenerated
	private ComboBox cmbPredecesorDependencia;

	@AutoGenerated
	private VerticalLayout pnlDependencia;

	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;

	@AutoGenerated
	private Button btnEliminar;

	@AutoGenerated
	private Button btnCrear;

	@AutoGenerated
	private ComboBox cmbEstado;

	@AutoGenerated
	private ComboBox cmbPadre;

	@AutoGenerated
	private TextField txtAbreviatura;

	@AutoGenerated
	private TextField txtNombre;

	@AutoGenerated
	private TextField txtCodigo;

	@AutoGenerated
	private VerticalLayout pnlDependenciasListado;

	@AutoGenerated
	private TreeTable treeDependencia;

	@AutoGenerated
	private TextField txtFilterNombre;

	@AutoGenerated
	private Label lblFiltroBusqueda;

	private static final long serialVersionUID = 466649518706418032L;
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	private DependenciaService dependenciasService;
	private PredecesorService predecesorService;
	private ValorService valorService;
	
	private boolean flagNuevaDependencia;
	private boolean flagNuevaPredecesor;	
	private List<Valor> estados;
	
	public PanelMantenDependencias(List<Opcion> acciones, String height) {
		super(acciones, height);
		valorService = Injector.obtenerServicio(ValorService.class);
		predecesorService = Injector.obtenerServicio(PredecesorService.class);
		dependenciasService = Injector.obtenerServicio(DependenciaService.class);
		buildMainLayout();
		setCompositionRoot(mainLayout);
		postConstruct();		
	}
	
	private void refrescar(String nombre){
		habilitarEdicion(false);
		limpiar(nombre);
		if(nombre.equals("dependencia")){
			Map<String,List<Dependencia>> map = dependenciasService.listarDependencias();
			cargarDependencias(map);
		}
	}

	@Override
	public void postConstruct() {
		pnlPrincipal.setStyleName("backColor");
		
		btnCrear.addListener((ClickListener)this);
		btnEliminar.addListener((ClickListener)this);
		btnCrearPredecesor.addListener((ClickListener)this);
		btnEliminarPredecesor.addListener((ClickListener)this);
			
		btnCrear.setIcon(Constante.ICONOS.SAVE);
		btnEliminar.setIcon(Constante.ICONOS.DELETE);
		btnCrearPredecesor.setIcon(Constante.ICONOS.SAVE);
		btnEliminarPredecesor.setIcon(Constante.ICONOS.DELETE);
		
		treeDependencia.setSelectable(true);
		treeDependencia.setImmediate(true);
		treeDependencia.setNullSelectionAllowed(true);
		treeDependencia.setNullSelectionItemId(null);
		
		tblPredecesorDependencias.setSelectable(true);
		tblPredecesorDependencias.setImmediate(true);
		tblPredecesorDependencias.setNullSelectionAllowed(true);
		tblPredecesorDependencias.setNullSelectionItemId(null);
		
		txtFilterNombre.addShortcutListener(new ShortcutListener("", KeyCode.ENTER, null) {			
			private static final long serialVersionUID = 4068232062569621771L;
			@Override
			public void handleAction(Object sender, Object target) {
				shortCutEnter(sender, target);
			}
		});
			
		cmbPadre.setItemCaptionPropertyId("nombre");
		cmbPadre.setInputPrompt("Padre");		
		cmbPredecesorDependencia.setItemCaptionPropertyId("nombre");
		cmbPredecesorDependencia.setInputPrompt("Dependencia");
		
		tblPredecesorDependencias.addListener(new ValueChangeListener() {
			private static final long serialVersionUID = -6124596484581515359L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				boolean esModoNuevo = tblPredecesorDependencias.getValue() == null;
				if(esModoNuevo){
					tblPredecesorDependencias.setValue(null);
					habilitarEdicionPredecesor(!esModoNuevo);
				}else {					
					Item item = tblPredecesorDependencias.getItem(tblPredecesorDependencias.getValue());												
					cmbPredecesorDependencia.select((Dependencia)item.getItemProperty("predecesor").getValue());
					habilitarEdicionPredecesor(!esModoNuevo);
				}
			}
		});
		
		treeDependencia.addListener(new ValueChangeListener() {
			private static final long serialVersionUID = -6124596484581515359L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				boolean esModoNuevo = treeDependencia.getValue() == null;
				if(esModoNuevo){
					treeDependencia.setValue(null);
					habilitarEdicion(!esModoNuevo);
				}else {					
					Item item = treeDependencia.getItem(treeDependencia.getValue());
					txtCodigo.setValue(item.getItemProperty("codigo").getValue());
					txtNombre.setValue(item.getItemProperty("nombre").getValue());
					txtAbreviatura.setValue(item.getItemProperty("abreviatura").getValue());
					cmbPadre.select(item.getItemProperty("padre"));
					Dependencia dependenciaPadre = null;					
					if( item.getItemProperty("padre").getValue()!= null){						
						dependenciaPadre = new Dependencia(); 
						dependenciaPadre.setId((Long)item.getItemProperty("padre.id").getValue());						
					}
					Valor valor = null;					
					if( item.getItemProperty("estado").getValue()!= null){						
						valor =  (Valor)item.getItemProperty("estado").getValue();						
					}
					cmbEstado.select(valor);
					cmbPadre.select(dependenciaPadre);
					habilitarEdicion(!esModoNuevo);
					flagNuevaPredecesor = true;
					//Obtenemos el listado de los predecesores
					Predecesor predecesor =  new Predecesor();
					Dependencia dependencia  =  new Dependencia();
					dependencia.setId( Long.parseLong(item.getItemProperty("id").getValue().toString())); 					
					predecesor.setDependencia(dependencia);
					cargarPredecesorCombo();
					cargarPredecesores(predecesorService.buscar(predecesor),true);
				}
			}
		});
		cmbEstado.setInputPrompt("Estado");
		
		estados = valorService.obtenerLista(Constante.LISTA.CODIGO.ESTADO);		
		BeanItemContainer<Valor> bicEstados = new BeanItemContainer<Valor>(Valor.class,  estados);		
		cmbEstado.setContainerDataSource(bicEstados);
		
		cmbEstado.setItemCaptionPropertyId("nombre");
		cargarDependenciaCombo();
		refrescar("dependencia");
	}
	private void habilitarEdicionPredecesor(boolean flag){
		flagNuevaPredecesor = !flag;
		btnEliminarPredecesor.setVisible(flag);
		if(flag){
			btnCrearPredecesor.setCaption("Actualizar");
		}
		else{
			btnCrearPredecesor.setCaption("Crear");
		}
	}
	private void cargarPredecesores(List<Predecesor> lstPredecesores, boolean flagLimpiar){
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("id", Long.class,  null);
		container.addContainerProperty("predecesor.nombre", String.class, null);
		container.addContainerProperty("predecesor", Dependencia.class, null);
		
		tblPredecesorDependencias.setContainerDataSource(container);
		tblPredecesorDependencias.setVisibleColumns(new Object[]{"predecesor.nombre"});		
		tblPredecesorDependencias.setColumnWidth("predecesor.nombre", 650);		
		tblPredecesorDependencias.setColumnHeader("predecesor.nombre", "Dependencia");		
				
		int con=1;
		for (Predecesor predecesor: lstPredecesores){
			Item item = container.addItem(con++);
			item.getItemProperty("id").setValue(predecesor.getId());
			item.getItemProperty("predecesor.nombre").setValue(predecesor.getPredecedor().getNombre());
			item.getItemProperty("predecesor").setValue(predecesor.getPredecedor());			
		}
		if(flagLimpiar){			
			cmbPredecesorDependencia.select(null);	
		}	
	}
	private void cargarPredecesorCombo(){
		Dependencia dependencia = new Dependencia();
		Valor valor =  new Valor();
		valor.setId(2L);
		dependencia.setEstado(valor);
		List<Dependencia> listasPredecesores = dependenciasService.buscar(dependencia);
		BeanItemContainer<Dependencia> bicPredecesores = new BeanItemContainer<Dependencia>(Dependencia.class,  listasPredecesores);
		cmbPredecesorDependencia.setContainerDataSource(bicPredecesores);
		cmbPredecesorDependencia.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
	}
	private void cargarDependenciaCombo(){
		List<Dependencia> listas = dependenciasService.buscar(null);
		BeanItemContainer<Dependencia> bicDependencias = new BeanItemContainer<Dependencia>(Dependencia.class,  listas);
		cmbPadre.setContainerDataSource(bicDependencias);	
		cmbPadre.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);		
	}
	
	private void cargarDependencias(Map<String,List<Dependencia>> map){			
		
		HierarchicalContainer hwContainer = new HierarchicalContainer();
		hwContainer.addContainerProperty("id", Long.class, 0L);
		hwContainer.addContainerProperty("nombre", String.class, "");
		hwContainer.addContainerProperty("codigo", String.class, "");
		hwContainer.addContainerProperty("abreviatura", String.class, "");	
		hwContainer.addContainerProperty("padre", Dependencia.class, null);		
		hwContainer.addContainerProperty("padre.id", Long.class, 0L);
		hwContainer.addContainerProperty("estado", Valor.class, null);
		
		if(map.get(Constante.OPCION.KEY_PADRE) != null){
			recorrer(Constante.OPCION.KEY_PADRE, map, null, hwContainer);
		}
		
		treeDependencia.setContainerDataSource(hwContainer);
		treeDependencia.setItemCaptionPropertyId("nombre");		
		treeDependencia.setVisibleColumns(new Object[]{"nombre"});
		
		for (Object id : treeDependencia.rootItemIds()){
			treeDependencia.setCollapsed(id, false);
        }
		
		for (Object itemId: treeDependencia.getItemIds())
			treeDependencia.setCollapsed(itemId, false);	

	}
	
	private void recorrer(String nombre, Map<String, List<Dependencia>> map, Long objPadre, HierarchicalContainer hwContainer) {//ok		
		Item item = null;
		for (Dependencia dependencia : map.get(nombre)) {			
			item = hwContainer.addItem(dependencia.getId());
			item.getItemProperty("id").setValue(dependencia.getId());
			item.getItemProperty("codigo").setValue(dependencia.getCodigo());
			item.getItemProperty("nombre").setValue(dependencia.getNombre());
			item.getItemProperty("abreviatura").setValue(dependencia.getAbreviatura());
			item.getItemProperty("padre").setValue(dependencia.getPadre()== null ? null : dependencia.getPadre());
			item.getItemProperty("padre.id").setValue(dependencia.getPadre()== null ? null : dependencia.getPadre().getId());
			item.getItemProperty("estado").setValue(dependencia.getEstado() == null ? null : dependencia.getEstado());
			
			if (!nombre.equals(Constante.OPCION.KEY_PADRE)){
				hwContainer.setParent(dependencia.getId(), objPadre);
			}
			if (map.get(dependencia.getId().toString()) != null) {
				recorrer(dependencia.getId().toString(), map, dependencia.getId(),hwContainer);
			} else {
				hwContainer.setChildrenAllowed(dependencia.getId().toString(), false);
			}
		}
	}
	
	private void habilitarEdicion(boolean flag){
		flagNuevaDependencia = !flag;
		btnEliminar.setVisible(flag);
		if(flag){
			btnCrear.setCaption("Actualizar");
		}
		else{
			btnCrear.setCaption("Crear");
		}
	}
	
	private void limpiar(String nombre){		
		if(nombre.equals("dependencia")){
			txtCodigo.setValue("");
			txtNombre.setValue("");
			txtAbreviatura.setValue("");
			cmbPadre.select(null);
			cmbEstado.select(null);
		}				
	}
	
	private void shortCutEnter(Object sender, Object target){
		Dependencia dependencia = null;
		List<Dependencia> lstDependencias = new ArrayList<Dependencia>();
		
		if (StringUtils.isNotBlank(target.toString())) {
			if(txtFilterNombre.equals(target)){
				dependencia = new Dependencia();
				if(StringUtils.isNotBlank(txtFilterNombre.getValue().toString())){
					dependencia.setNombre(txtFilterNombre.getValue().toString());
				}
				lstDependencias = dependenciasService.buscarPadreHijos(dependencia);				
				Map<String,List<Dependencia>> map = dependenciasService.filtrarDependencias(lstDependencias);
				cargarDependencias(map);
			}
		}else {
			refrescar("dependencia");
		}
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnCrear)){
			Dependencia dependencia = new Dependencia();
			
			dependencia.setCodigo((String)txtCodigo.getValue());
			dependencia.setNombre((String)txtNombre.getValue());
			dependencia.setAbreviatura((String)txtAbreviatura.getValue());
			if(cmbPadre.getValue()!=null)
				dependencia.setPadre((Dependencia)cmbPadre.getValue());			
			dependencia.setEstado((Valor) cmbEstado.getValue());
			if(flagNuevaDependencia){
				dependenciasService.crear(dependencia);
				cargarDependenciaCombo();
			}
			else{
				Item item = treeDependencia.getItem(treeDependencia.getValue());
				dependencia.setId(Long.parseLong(item.getItemProperty("id").getValue().toString()));
				dependenciasService.actualizar(dependencia);
			}
			refrescar("dependencia");
		}
		if(event.getButton().equals(btnEliminar)){
			ConfirmDialog.show(getApplication().getMainWindow(),"¿Desea elimiar el registro?", new ConfirmDialog.Listener() {				
				private static final long serialVersionUID = 1L;
				public void onClose(ConfirmDialog dialog) {
	                if (dialog.isConfirmed()) {
	                	Item item = treeDependencia.getItem(treeDependencia.getValue());
	        			dependenciasService.eliminarXId(Long.parseLong(item.getItemProperty("id").getValue().toString()));
	        			refrescar("dependencia");
	        			cargarDependenciaCombo();
	                }
	            }
	        });
		}	
		if(event.getButton().equals(btnCrearPredecesor)){			
			Predecesor predecesor =  new Predecesor();
			Item item = treeDependencia.getItem(treeDependencia.getValue());
			Long varId = Long.parseLong((item.getItemProperty("id").getValue().toString()));
			Dependencia dependencia = dependenciasService.obtener(varId);
			predecesor.setDependencia(dependencia);
			predecesor.setPredecedor((Dependencia)cmbPredecesorDependencia.getValue());
			if(flagNuevaPredecesor){
				predecesorService.crear(predecesor);
			}else{
				Item itemPredecesor = tblPredecesorDependencias.getItem(tblPredecesorDependencias.getValue());
				predecesor.setId( Long.parseLong( itemPredecesor.getItemProperty("id").getValue().toString()));
				predecesorService.actualizar(predecesor);
			}						
			//actualizamos los predecesores
			predecesor.setPredecedor(null);
			cargarPredecesores(predecesorService.buscar(predecesor),true);	
		}
		if(event.getButton().equals(btnEliminarPredecesor)){
			ConfirmDialog.show(getApplication().getMainWindow() , "¿Desea Eliminar Predecesor?", new ConfirmDialog.Listener() {				
				private static final long serialVersionUID = 1L;
				public void onClose(ConfirmDialog dialog) {
	                if (dialog.isConfirmed()) {
	                	Item itemPredecesor = tblPredecesorDependencias.getItem(tblPredecesorDependencias.getValue());
	                	predecesorService.eliminarXId(Long.parseLong( itemPredecesor.getItemProperty("id").getValue().toString()));
	                	
	                	Predecesor predecesor =  new Predecesor();
	        			Item item = treeDependencia.getItem(treeDependencia.getValue());
	        			Long varId = Long.parseLong((item.getItemProperty("id").getValue().toString()));
	        			Dependencia dependencia = dependenciasService.obtener(varId);
	        			predecesor.setDependencia(dependencia);
	        			cargarPredecesores(predecesorService.buscar(predecesor),true);	
	                }
	            }
	        });
		}
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(false);
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
		pnlPrincipal.setImmediate(false);
		pnlPrincipal.setWidth("-1px");
		pnlPrincipal.setHeight("-1px");
		pnlPrincipal.setMargin(true);
		pnlPrincipal.setSpacing(true);
		
		// pnlDependenciasListado
		pnlDependenciasListado = buildPnlDependenciasListado();
		pnlPrincipal.addComponent(pnlDependenciasListado);
		
		// tabSheet
		tabSheet = buildTabSheet();
		pnlPrincipal.addComponent(tabSheet);
		
		return pnlPrincipal;
	}

	@AutoGenerated
	private VerticalLayout buildPnlDependenciasListado() {
		// common part: create layout
		pnlDependenciasListado = new VerticalLayout();
		pnlDependenciasListado.setImmediate(false);
		pnlDependenciasListado.setWidth("565px");
		pnlDependenciasListado.setHeight("-1px");
		pnlDependenciasListado.setMargin(false);
		
		// lblFiltroBusqueda
		lblFiltroBusqueda = new Label();
		lblFiltroBusqueda.setStyleName("h1");
		lblFiltroBusqueda.setImmediate(false);
		lblFiltroBusqueda.setWidth("-1px");
		lblFiltroBusqueda.setHeight("-1px");
		lblFiltroBusqueda.setValue("Filtro de Busqueda");
		pnlDependenciasListado.addComponent(lblFiltroBusqueda);
		
		// txtFilterNombre
		txtFilterNombre = new TextField();
		txtFilterNombre.setImmediate(false);
		txtFilterNombre.setWidth("535px");
		txtFilterNombre.setHeight("-1px");
		txtFilterNombre.setInputPrompt("Nombre");
		pnlDependenciasListado.addComponent(txtFilterNombre);
		
		// treeDependencia
		treeDependencia = new TreeTable();
		treeDependencia.setImmediate(false);
		treeDependencia.setWidth("550px");
		treeDependencia.setHeight("360px");
		pnlDependenciasListado.addComponent(treeDependencia);
		
		return pnlDependenciasListado;
	}

	@AutoGenerated
	private TabSheet buildTabSheet() {
		// common part: create layout
		tabSheet = new TabSheet();
		tabSheet.setStyleName("h1");
		tabSheet.setCaption("Administración");
		tabSheet.setImmediate(true);
		tabSheet.setWidth("400px");
		tabSheet.setHeight("385px");
		
		// pnlDependencia
		pnlDependencia = buildPnlDependencia();
		tabSheet.addTab(pnlDependencia, "Dependencia", null);
		
		// verticalLayout_2
		verticalLayout_2 = buildVerticalLayout_2();
		tabSheet.addTab(verticalLayout_2, "Predecesores", null);
		
		return tabSheet;
	}

	@AutoGenerated
	private VerticalLayout buildPnlDependencia() {
		// common part: create layout
		pnlDependencia = new VerticalLayout();
		pnlDependencia.setImmediate(false);
		pnlDependencia.setWidth("-1px");
		pnlDependencia.setHeight("-1px");
		pnlDependencia.setMargin(true);
		pnlDependencia.setSpacing(true);
		
		// txtCodigo
		txtCodigo = new TextField();
		txtCodigo.setCaption("Código");
		txtCodigo.setImmediate(false);
		txtCodigo.setWidth("-1px");
		txtCodigo.setHeight("-1px");
		txtCodigo.setRequired(true);
		txtCodigo.setInputPrompt("Código de Referencia");
		pnlDependencia.addComponent(txtCodigo);
		
		// txtNombre
		txtNombre = new TextField();
		txtNombre.setCaption("Nombre");
		txtNombre.setImmediate(false);
		txtNombre.setWidth("350px");
		txtNombre.setHeight("-1px");
		txtNombre.setRequired(true);
		txtNombre
				.setInputPrompt("Nombre de la dependecia segun el organigrama");
		pnlDependencia.addComponent(txtNombre);
		
		// txtAbreviatura
		txtAbreviatura = new TextField();
		txtAbreviatura.setCaption("Abreviatura");
		txtAbreviatura.setImmediate(false);
		txtAbreviatura.setWidth("200px");
		txtAbreviatura.setHeight("-1px");
		txtAbreviatura.setRequired(true);
		txtAbreviatura.setInputPrompt("Abreviatura de la dependencia");
		pnlDependencia.addComponent(txtAbreviatura);
		
		// cmbPadre
		cmbPadre = new ComboBox();
		cmbPadre.setCaption("Sub-Nivel");
		cmbPadre.setImmediate(false);
		cmbPadre.setWidth("350px");
		cmbPadre.setHeight("-1px");
		pnlDependencia.addComponent(cmbPadre);
		
		// cmbEstado
		cmbEstado = new ComboBox();
		cmbEstado.setCaption("Estado");
		cmbEstado.setImmediate(false);
		cmbEstado.setWidth("-1px");
		cmbEstado.setHeight("-1px");
		cmbEstado.setRequired(true);
		pnlDependencia.addComponent(cmbEstado);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		pnlDependencia.addComponent(horizontalLayout_1);
		pnlDependencia.setComponentAlignment(horizontalLayout_1, new Alignment(
				20));
		
		return pnlDependencia;
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
		
		// btnCrear
		btnCrear = new Button();
		btnCrear.setCaption("Grabar");
		btnCrear.setImmediate(true);
		btnCrear.setWidth("-1px");
		btnCrear.setHeight("-1px");
		horizontalLayout_1.addComponent(btnCrear);
		
		// btnEliminar
		btnEliminar = new Button();
		btnEliminar.setCaption("Eliminar");
		btnEliminar.setImmediate(true);
		btnEliminar.setWidth("-1px");
		btnEliminar.setHeight("-1px");
		horizontalLayout_1.addComponent(btnEliminar);
		
		return horizontalLayout_1;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_2() {
		// common part: create layout
		verticalLayout_2 = new VerticalLayout();
		verticalLayout_2.setImmediate(false);
		verticalLayout_2.setWidth("-1px");
		verticalLayout_2.setHeight("-1px");
		verticalLayout_2.setMargin(true);
		verticalLayout_2.setSpacing(true);
		
		// cmbPredecesorDependencia
		cmbPredecesorDependencia = new ComboBox();
		cmbPredecesorDependencia.setCaption("Dependencia predecesora");
		cmbPredecesorDependencia.setImmediate(false);
		cmbPredecesorDependencia.setWidth("249px");
		cmbPredecesorDependencia.setHeight("-1px");
		cmbPredecesorDependencia.setRequired(true);
		verticalLayout_2.addComponent(cmbPredecesorDependencia);
		
		// tblPredecesorDependencias
		tblPredecesorDependencias = new Table();
		tblPredecesorDependencias.setImmediate(false);
		tblPredecesorDependencias.setWidth("360px");
		tblPredecesorDependencias.setHeight("200px");
		verticalLayout_2.addComponent(tblPredecesorDependencias);
		
		// horizontalLayout_5
		horizontalLayout_5 = buildHorizontalLayout_5();
		verticalLayout_2.addComponent(horizontalLayout_5);
		verticalLayout_2.setComponentAlignment(horizontalLayout_5,
				new Alignment(48));
		
		return verticalLayout_2;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_5() {
		// common part: create layout
		horizontalLayout_5 = new HorizontalLayout();
		horizontalLayout_5.setImmediate(false);
		horizontalLayout_5.setWidth("-1px");
		horizontalLayout_5.setHeight("-1px");
		horizontalLayout_5.setMargin(true);
		horizontalLayout_5.setSpacing(true);
		
		// btnCrearPredecesor
		btnCrearPredecesor = new Button();
		btnCrearPredecesor.setCaption("Crear");
		btnCrearPredecesor.setImmediate(true);
		btnCrearPredecesor.setWidth("-1px");
		btnCrearPredecesor.setHeight("-1px");
		horizontalLayout_5.addComponent(btnCrearPredecesor);
		
		// btnEliminarPredecesor
		btnEliminarPredecesor = new Button();
		btnEliminarPredecesor.setCaption("Eliminar");
		btnEliminarPredecesor.setImmediate(true);
		btnEliminarPredecesor.setWidth("-1px");
		btnEliminarPredecesor.setHeight("-1px");
		horizontalLayout_5.addComponent(btnEliminarPredecesor);
		
		return horizontalLayout_5;
	}

}