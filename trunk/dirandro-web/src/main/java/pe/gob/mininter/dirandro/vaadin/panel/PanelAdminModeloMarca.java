package pe.gob.mininter.dirandro.vaadin.panel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.ModeloMarca;
import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.ModeloMarcaService;
import pe.gob.mininter.dirandro.service.ValorService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.vaadin.dialogs.ConfirmDialog;
import pe.gob.mininter.dirandro.vaadin.util.DirandroComponent;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.TreeTable;
import com.vaadin.ui.VerticalLayout;

public class PanelAdminModeloMarca extends DirandroComponent implements ClickListener{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout PanelSecundario;
	@AutoGenerated
	private HorizontalLayout PanelContenido;
	@AutoGenerated
	private VerticalLayout PanelParametroContenido;
	@AutoGenerated
	private HorizontalLayout PanelBtnContenido;
	@AutoGenerated
	private Button btnEliminar;
	@AutoGenerated
	private Button btnCrear;
	@AutoGenerated
	private TextField txtModelo;
	@AutoGenerated
	private ComboBox cmbMarca;
	@AutoGenerated
	private ComboBox cmbTipo;
	@AutoGenerated
	private ComboBox cmbCategoria;
	@AutoGenerated
	private VerticalLayout PanelContieneTabla;
	@AutoGenerated
	private VerticalLayout PanelTabla;
	@AutoGenerated
	private TreeTable treeModeloMarca;
	@AutoGenerated
	private HorizontalLayout PanelFiltroTabla;
	@AutoGenerated
	private TextField txtFiltroTipo;
	@AutoGenerated
	private TextField txtFiltroModelo;
	/**
	 * 
	 */
	private ModeloMarcaService modeloMarcaService; 
	private ValorService valorService;
	
	private static final long serialVersionUID = 6956146995873234612L;
	private List<Valor> lstCategorias;
	private List<ModeloMarca> lstTiposModeloMarca;
	private List<ModeloMarca> lstModeloMarca;
	
	private boolean flagNuevaEntidad;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelAdminModeloMarca(List<Opcion> acciones,String height) {
		super(acciones,height);
		valorService = Injector.obtenerServicio(ValorService.class);
		modeloMarcaService = Injector.obtenerServicio(ModeloMarcaService.class);		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		postConstruct();	
	}

	@Override
	public void postConstruct() {
		
		lstCategorias = valorService.obtenerLista(Constante.LISTA.CODIGO.MARCAS_TIPO);
		this.cmbCategoria.setInputPrompt("Categoria");
		this.cmbCategoria.setImmediate(true);
		this.cmbCategoria.setContainerDataSource(new BeanItemContainer<Valor>(Valor.class,  lstCategorias));		
		this.cmbCategoria.setItemCaptionPropertyId("nombre");
		this.cmbCategoria.addListener(new Property.ValueChangeListener() {            
			private static final long serialVersionUID = 1L;
			@Override
            public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
				ModeloMarca modeloMarca = new ModeloMarca();
    			Valor tipo = (Valor)cmbCategoria.getValue();    			
    			modeloMarca.setTipo(tipo);
    			lstTiposModeloMarca = modeloMarcaService.buscar(modeloMarca);
    			cmbTipo.setContainerDataSource(new BeanItemContainer<ModeloMarca>(ModeloMarca.class,lstTiposModeloMarca));
            }
        });

		this.cmbTipo.setItemCaptionPropertyId("nombre");
		this.cmbTipo.setImmediate(true);
		this.cmbTipo.setInputPrompt("Tipo");
		this.cmbTipo.addListener(new Property.ValueChangeListener() {            
			private static final long serialVersionUID = 1L;
			@Override
            public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {				 
				lstModeloMarca = null;
				if(cmbTipo.getValue() == null){
					lstModeloMarca = new ArrayList<ModeloMarca>();
				}else{
					ModeloMarca modeloMarca = new ModeloMarca();
					Valor tipo = (Valor)cmbCategoria.getValue();
					modeloMarca.setTipo(tipo);
					modeloMarca.setPadre((ModeloMarca)cmbTipo.getValue());
					lstModeloMarca = modeloMarcaService.buscar(modeloMarca);
				}
				cmbMarca.setContainerDataSource(new BeanItemContainer<ModeloMarca>(ModeloMarca.class,lstModeloMarca));
            }
        });
		
		this.cmbMarca.setImmediate(true);
		this.cmbMarca.setItemCaptionPropertyId("nombre");
		this.cmbMarca.setInputPrompt("Marca");
		
		this.btnCrear.setIcon(Constante.ICONOS.SAVE);
		this.btnEliminar.setIcon(Constante.ICONOS.DELETE);
		
		this.btnCrear.addListener((ClickListener)this);
		this.btnEliminar.addListener((ClickListener)this);
		
		this.txtFiltroModelo.addShortcutListener(new ShortcutListener("", KeyCode.ENTER, null) {			
			private static final long serialVersionUID = 4068232062569621771L;
			@Override
			public void handleAction(Object sender, Object target) {
				shortCutEnter(sender, target);
			}
		});
		
		this.txtFiltroTipo.addShortcutListener(new ShortcutListener("", KeyCode.ENTER, null) {			
			private static final long serialVersionUID = 4068232062569621771L;
			@Override
			public void handleAction(Object sender, Object target) {
				shortCutEnter(sender, target);
			}
		});		
		
		treeModeloMarca.setSelectable(true);
		treeModeloMarca.setImmediate(true);
		treeModeloMarca.setNullSelectionAllowed(true);
		treeModeloMarca.setNullSelectionItemId(null);				
		
		treeModeloMarca.addListener(new ValueChangeListener() {
			
			private static final long serialVersionUID = -6124596484581515359L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				boolean esModoNuevo = treeModeloMarca.getValue() == null;
				if(esModoNuevo){
					cmbCategoria.setEnabled(true);
					cmbTipo.setEnabled(true);
					cmbMarca.setEnabled(true);
					treeModeloMarca.setValue(null);
					txtModelo.setValue("");
					habilitarEdicion(!esModoNuevo);
					cmbTipo.select(null);
				}else {
					habilitarEdicion(!esModoNuevo);
					Item item = treeModeloMarca.getItem(treeModeloMarca.getValue());
					Valor valor = null;
					if(item.getItemProperty("tipo.id").getValue()!=null){						
						valor =  new Valor();
						valor.setId( Long.parseLong(item.getItemProperty("tipo.id").getValue().toString()));					
					}
					cmbCategoria.select(valor);										
					ModeloMarca modeloMarcaPadre = null;					
					if(item.getItemProperty("padre").getValue()!=null){
						modeloMarcaPadre = (ModeloMarca)item.getItemProperty("padre").getValue();						
						
						for(ModeloMarca model : lstTiposModeloMarca){
							if(modeloMarcaPadre.getPadre().getId().equals(model.getId()))
								cmbTipo.select(model);	
						}
						
						if(cmbTipo.getValue() != null ){
							for(ModeloMarca model : lstModeloMarca){
								if(modeloMarcaPadre.getId().equals(model.getId()))
								 cmbMarca.select(model);	
							}									
						}else{
							for(ModeloMarca model : lstTiposModeloMarca){
								if(modeloMarcaPadre.getId().equals(model.getId()))
									cmbTipo.select(model);	
							}
							cmbMarca.select(null);
						}
					}else{
						cmbTipo.select(null);
						cmbMarca.select(null);
					}
					txtModelo.setValue(item.getItemProperty("nombre").getValue());
					cmbCategoria.setEnabled(false);
					cmbTipo.setEnabled(false);
					cmbMarca.setEnabled(false);
				}				
			}
		});		
		refrescar("modelomarca");		
	}
	private void shortCutEnter(Object sender, Object target){
		ModeloMarca modeloMarca = null;
		List<ModeloMarca> lstModeloMarcas = new ArrayList<ModeloMarca>();
		if (StringUtils.isNotBlank(target.toString())) {
			modeloMarca = new ModeloMarca();
			if(this.txtFiltroModelo.equals(target)){
				if(StringUtils.isNotBlank(this.txtFiltroModelo.getValue().toString())){
					modeloMarca.setNombre(this.txtFiltroModelo.getValue().toString());
				}				
			}
			if(this.txtFiltroTipo.equals(target)){
				if(StringUtils.isNotBlank(this.txtFiltroTipo.getValue().toString())){
					Valor tipo = new Valor();
					tipo.setNombre(this.txtFiltroTipo.getValue().toString());
					modeloMarca.setTipo(tipo);
				}
			}
			lstModeloMarcas = modeloMarcaService.buscarPadreHijos(modeloMarca);				
			Map<String,List<ModeloMarca>> map = modeloMarcaService.filtrarModelosMarcas(lstModeloMarcas);				
			cargarModeloMarca(map);				
		}else {
			refrescar("modelomarca");
		}
	}

	private void habilitarEdicion(boolean flag){
		flagNuevaEntidad = !flag;
		btnEliminar.setVisible(flag);
		if(flag){
			btnCrear.setCaption("Actualizar");
		}
		else{
			btnCrear.setCaption("Crear");
		}
	}
	
	public void limpiar(String nombre){
		if(nombre.equals("modelomarca")){
			this.txtModelo.setValue("");
		} 
	}
	private void recorrer(String nombre, Map<String, List<ModeloMarca>> map, Long objPadre, HierarchicalContainer hwContainer) {//ok		
		Item item = null;
		for (ModeloMarca dependencia : map.get(nombre)) {			
			item = hwContainer.addItem(dependencia.getId());
			item.getItemProperty("id").setValue(dependencia.getId());
			item.getItemProperty("nombre").setValue(dependencia.getNombre());			
			item.getItemProperty("padre").setValue(dependencia.getPadre() == null ? null : dependencia.getPadre());
			item.getItemProperty("padre.id").setValue(dependencia.getPadre() == null ? null : dependencia.getPadre().getId());
			item.getItemProperty("tipo.nombre").setValue(dependencia.getTipo() == null ? null : dependencia.getTipo().getNombre());
			item.getItemProperty("tipo.id").setValue(dependencia.getTipo() == null ? null : dependencia.getTipo().getId());
			
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
	private void cargarModeloMarca(Map<String,List<ModeloMarca>> map ){
		HierarchicalContainer hwContainer = new HierarchicalContainer();
		hwContainer.addContainerProperty("id", Long.class, 0L);
		hwContainer.addContainerProperty("nombre", String.class, "");			
		hwContainer.addContainerProperty("padre", ModeloMarca.class, null);		
		hwContainer.addContainerProperty("padre.id", Long.class, 0L);
		hwContainer.addContainerProperty("tipo.nombre", String.class, 0L);
		hwContainer.addContainerProperty("tipo.id", Long.class, 0L);
		
		if(map.get(Constante.OPCION.KEY_PADRE) != null){
			recorrer(Constante.OPCION.KEY_PADRE, map, null, hwContainer);
		}
		this.treeModeloMarca.setContainerDataSource(hwContainer);		
		this.treeModeloMarca.setItemCaptionPropertyId("nombre");		
		this.treeModeloMarca.setVisibleColumns(new Object[]{"nombre","tipo.nombre"});
		this.treeModeloMarca.setColumnWidth("nombre", 245);		
		this.treeModeloMarca.setColumnWidth("tipo.nombre", 140);		
		this.treeModeloMarca.setColumnHeader("tipo.nombre", "Categoria");
		
		for (Object id : this.treeModeloMarca.rootItemIds()){
			this.treeModeloMarca.setCollapsed(id, false);//expandItemsRecursively(id);
        }		
		for (Object itemId: this.treeModeloMarca.getItemIds())
			this.treeModeloMarca.setCollapsed(itemId, false);	
	}
	
	private void refrescar(String nombre){
		cmbCategoria.setEnabled(true);
		cmbTipo.setEnabled(true);
		cmbMarca.setEnabled(true);
		habilitarEdicion(false);
		limpiar(nombre);
		if(nombre.equals("modelomarca")){
			this.cmbCategoria.select(null);
			Map<String,List<ModeloMarca>> map = modeloMarcaService.listarModeloMarcas();
			cargarModeloMarca(map);
		}
	}
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(this.btnCrear)){		
			ModeloMarca modeloMarca = new ModeloMarca();
			modeloMarca.setNombre((String)this.txtModelo.getValue());
			if( cmbMarca.getValue() == null ){
				modeloMarca.setPadre((ModeloMarca)cmbTipo.getValue());
			}else{
				modeloMarca.setPadre((ModeloMarca)cmbMarca.getValue());
			}
			modeloMarca.setTipo((Valor)cmbCategoria.getValue());		
			if(flagNuevaEntidad){
				modeloMarcaService.crear(modeloMarca);				
			}
			else{
				Item item = treeModeloMarca.getItem(treeModeloMarca.getValue());				
				modeloMarca.setId(Long.parseLong(item.getItemProperty("id").getValue().toString()));
				modeloMarcaService.actualizar(modeloMarca);
			}
			refrescar("modelomarca");			
		}
		if(event.getButton().equals(btnEliminar)){
			ConfirmDialog.show(getApplication().getMainWindow() , "¿Seguro de Eliminar el Registro?", new ConfirmDialog.Listener() {				
				private static final long serialVersionUID = 1L;
				public void onClose(ConfirmDialog dialog) {
	                if (dialog.isConfirmed()) {
	                	Item item = treeModeloMarca.getItem(treeModeloMarca.getValue());			
	        			modeloMarcaService.eliminarXId(Long.parseLong(item.getItemProperty("id").getValue().toString()));
	        			refrescar("modelomarca");
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
		mainLayout.setMargin(true);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("-1px");
		
		// PanelSecundario
		PanelSecundario = buildPanelSecundario();
		mainLayout.addComponent(PanelSecundario);
		mainLayout.setComponentAlignment(PanelSecundario, new Alignment(20));
		
		return mainLayout;
	}

	@AutoGenerated
	private HorizontalLayout buildPanelSecundario() {
		// common part: create layout
		PanelSecundario = new HorizontalLayout();
		PanelSecundario.setStyleName("whiteBackGround");
		PanelSecundario.setImmediate(false);
		PanelSecundario.setWidth("-1px");
		PanelSecundario.setHeight("325px");
		PanelSecundario.setMargin(true);
		PanelSecundario.setSpacing(true);
		
		// PanelContenido
		PanelContenido = buildPanelContenido();
		PanelSecundario.addComponent(PanelContenido);
		PanelSecundario
				.setComponentAlignment(PanelContenido, new Alignment(20));
		
		return PanelSecundario;
	}

	@AutoGenerated
	private HorizontalLayout buildPanelContenido() {
		// common part: create layout
		PanelContenido = new HorizontalLayout();
		PanelContenido.setImmediate(false);
		PanelContenido.setWidth("690px");
		PanelContenido.setHeight("-1px");
		PanelContenido.setMargin(false);
		PanelContenido.setSpacing(true);
		
		// PanelContieneTabla
		PanelContieneTabla = buildPanelContieneTabla();
		PanelContenido.addComponent(PanelContieneTabla);
		
		// PanelParametroContenido
		PanelParametroContenido = buildPanelParametroContenido();
		PanelContenido.addComponent(PanelParametroContenido);
		
		return PanelContenido;
	}

	@AutoGenerated
	private VerticalLayout buildPanelContieneTabla() {
		// common part: create layout
		PanelContieneTabla = new VerticalLayout();
		PanelContieneTabla.setStyleName("h2");
		PanelContieneTabla.setCaption("Filtro de Busqueda");
		PanelContieneTabla.setImmediate(false);
		PanelContieneTabla.setWidth("420px");
		PanelContieneTabla.setHeight("324px");
		PanelContieneTabla.setMargin(false);
		
		// PanelFiltroTabla
		PanelFiltroTabla = buildPanelFiltroTabla();
		PanelContieneTabla.addComponent(PanelFiltroTabla);
		
		// PanelTabla
		PanelTabla = buildPanelTabla();
		PanelContieneTabla.addComponent(PanelTabla);
		
		return PanelContieneTabla;
	}

	@AutoGenerated
	private HorizontalLayout buildPanelFiltroTabla() {
		// common part: create layout
		PanelFiltroTabla = new HorizontalLayout();
		PanelFiltroTabla.setImmediate(false);
		PanelFiltroTabla.setWidth("-1px");
		PanelFiltroTabla.setHeight("-1px");
		PanelFiltroTabla.setMargin(false);
		
		// txtFiltroModelo
		txtFiltroModelo = new TextField();
		txtFiltroModelo.setImmediate(false);
		txtFiltroModelo.setWidth("260px");
		txtFiltroModelo.setHeight("-1px");
		txtFiltroModelo.setInputPrompt("Nombre");
		PanelFiltroTabla.addComponent(txtFiltroModelo);
		
		// txtFiltroTipo
		txtFiltroTipo = new TextField();
		txtFiltroTipo.setImmediate(false);
		txtFiltroTipo.setWidth("160px");
		txtFiltroTipo.setHeight("-1px");
		txtFiltroTipo.setInputPrompt("Tipo");
		PanelFiltroTabla.addComponent(txtFiltroTipo);
		
		return PanelFiltroTabla;
	}

	@AutoGenerated
	private VerticalLayout buildPanelTabla() {
		// common part: create layout
		PanelTabla = new VerticalLayout();
		PanelTabla.setImmediate(false);
		PanelTabla.setWidth("-1px");
		PanelTabla.setHeight("-1px");
		PanelTabla.setMargin(false);
		
		// treeModeloMarca
		treeModeloMarca = new TreeTable();
		treeModeloMarca.setImmediate(false);
		treeModeloMarca.setWidth("420px");
		treeModeloMarca.setHeight("300px");
		PanelTabla.addComponent(treeModeloMarca);
		
		return PanelTabla;
	}

	@AutoGenerated
	private VerticalLayout buildPanelParametroContenido() {
		// common part: create layout
		PanelParametroContenido = new VerticalLayout();
		PanelParametroContenido.setStyleName("h2");
		PanelParametroContenido.setCaption("Administración de Tipos de Hechos");
		PanelParametroContenido.setImmediate(false);
		PanelParametroContenido.setWidth("-1px");
		PanelParametroContenido.setHeight("-1px");
		PanelParametroContenido.setMargin(false);
		PanelParametroContenido.setSpacing(true);
		
		// cmbCategoria
		cmbCategoria = new ComboBox();
		cmbCategoria.setCaption("Categoria");
		cmbCategoria.setImmediate(false);
		cmbCategoria.setWidth("-1px");
		cmbCategoria.setHeight("-1px");
		PanelParametroContenido.addComponent(cmbCategoria);
		
		// cmbTipo
		cmbTipo = new ComboBox();
		cmbTipo.setCaption("Tipo");
		cmbTipo.setImmediate(false);
		cmbTipo.setWidth("-1px");
		cmbTipo.setHeight("-1px");
		PanelParametroContenido.addComponent(cmbTipo);
		
		// cmbMarca
		cmbMarca = new ComboBox();
		cmbMarca.setCaption("Marca");
		cmbMarca.setImmediate(false);
		cmbMarca.setWidth("-1px");
		cmbMarca.setHeight("-1px");
		PanelParametroContenido.addComponent(cmbMarca);
		
		// txtModelo
		txtModelo = new TextField();
		txtModelo.setCaption("Modelo");
		txtModelo.setImmediate(false);
		txtModelo.setWidth("250px");
		txtModelo.setHeight("-1px");
		txtModelo.setRequired(true);
		txtModelo.setInputPrompt("Modelo");
		PanelParametroContenido.addComponent(txtModelo);
		
		// PanelBtnContenido
		PanelBtnContenido = buildPanelBtnContenido();
		PanelParametroContenido.addComponent(PanelBtnContenido);
		PanelParametroContenido.setComponentAlignment(PanelBtnContenido,
				new Alignment(10));
		
		return PanelParametroContenido;
	}

	@AutoGenerated
	private HorizontalLayout buildPanelBtnContenido() {
		// common part: create layout
		PanelBtnContenido = new HorizontalLayout();
		PanelBtnContenido.setImmediate(false);
		PanelBtnContenido.setWidth("220px");
		PanelBtnContenido.setHeight("62px");
		PanelBtnContenido.setMargin(true);
		
		// btnCrear
		btnCrear = new Button();
		btnCrear.setCaption("Crear");
		btnCrear.setImmediate(true);
		btnCrear.setWidth("-1px");
		btnCrear.setHeight("-1px");
		PanelBtnContenido.addComponent(btnCrear);
		
		// btnEliminar
		btnEliminar = new Button();
		btnEliminar.setCaption("Eiminar");
		btnEliminar.setImmediate(true);
		btnEliminar.setWidth("-1px");
		btnEliminar.setHeight("-1px");
		PanelBtnContenido.addComponent(btnEliminar);
		
		return PanelBtnContenido;
	}
}