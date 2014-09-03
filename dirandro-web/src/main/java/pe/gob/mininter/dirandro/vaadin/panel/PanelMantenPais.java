package pe.gob.mininter.dirandro.vaadin.panel;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.model.Pais;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.EstadoService;
import pe.gob.mininter.dirandro.service.PaisService;
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
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.TreeTable;
import com.vaadin.ui.VerticalLayout;

public class PanelMantenPais extends DirandroComponent implements ClickListener{

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
	private Button btnEliminar;
	@AutoGenerated
	private Button btnRegistrar;
	@AutoGenerated
	private ComboBox cmbEstado;
	@AutoGenerated
	private ComboBox cmbNivel;
	@AutoGenerated
	private TextField txtNacionalidad;
	@AutoGenerated
	private TextField txtNombre;
	@AutoGenerated
	private Label lblAdministracionPais;
	@AutoGenerated
	private VerticalLayout pnlListadoEstado;
	@AutoGenerated
	private TreeTable treePaises;
	@AutoGenerated
	private TextField txtFiltroPais;
	@AutoGenerated
	private Label lblFiltroBusqueda;
	
	private static final long serialVersionUID = 8017458567665421578L;
	
	private PaisService paisService;
	private ValorService valorService;
	private boolean flagNuevoPais;
	
	private List<Valor> lstEstados;
	private List<Pais> lstPaises;
	private Long idPais;
	
	public PanelMantenPais(List<Opcion> acciones, String height){
		super(acciones, height);
		valorService = Injector.obtenerServicio(ValorService.class);
		paisService = Injector.obtenerServicio(PaisService.class);
		buildMainLayout();
		setCompositionRoot(mainLayout);
		postConstruct();
	}
	
	@Override
	public void postConstruct() {
		inicializa();
		refrescar();
	}
	
	private void inicializa(){
		btnRegistrar.setImmediate(true);
		btnRegistrar.addListener((ClickListener)this);
		
		treePaises.setSelectable(true);
		treePaises.setImmediate(true);
		treePaises.setNullSelectionAllowed(true);
		treePaises.setNullSelectionItemId(null);
		treePaises.addListener(new ValueChangeListener() {
			
			private static final long serialVersionUID = -6304846159688598798L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				boolean esModoNuevo = treePaises.getValue() == null;
				limpiar();
				if(esModoNuevo){
					treePaises.setValue(null);
					habilitarEdicion(!esModoNuevo);
				}else {					
					Item item = treePaises.getItem(treePaises.getValue());
					idPais = (Long) item.getItemProperty("id").getValue();
					txtNombre.setValue(item.getItemProperty("nombre").getValue());
					txtNacionalidad.setValue(item.getItemProperty("nacionalidad").getValue() != null ? item.getItemProperty("nacionalidad").getValue() : StringUtils.EMPTY);
					
					Pais nacionalidad = (Pais) item.getItemProperty("padre").getValue();
					
					if (nacionalidad != null) {
						txtNacionalidad.setVisible(false);
					}else {
						txtNacionalidad.setVisible(true);
					}
					
					for (Pais pais : lstPaises) {
						if (pais.getId().equals((Long) item.getItemProperty("padre.id").getValue())) {
							cmbNivel.select(pais);
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
		
		lstEstados = valorService.obtenerLista(Constante.LISTA.CODIGO.ESTADO);
		cmbEstado.setContainerDataSource(new BeanItemContainer<Valor>(Valor.class, lstEstados));
		cmbEstado.setInputPrompt("Estado");
		cmbEstado.setItemCaptionPropertyId("nombre");
		cmbEstado.setImmediate(true);
		
		lstPaises = paisService.buscar(null);
		cmbNivel.setContainerDataSource(new BeanItemContainer<Pais>(Pais.class, lstPaises));
		cmbNivel.setInputPrompt("Pais al que pertenece");
		cmbNivel.setItemCaptionPropertyId("nombre");
		cmbNivel.setImmediate(true);
		
	}
	
	private void cargarPaises(Map<String, List<Pais>> mapPaises){
		HierarchicalContainer hwContainer = new HierarchicalContainer();
		hwContainer.addContainerProperty("id", Long.class, 0L);
		hwContainer.addContainerProperty("nombre", String.class, "");
		hwContainer.addContainerProperty("codigo", String.class, "");
		hwContainer.addContainerProperty("abreviatura", String.class, "");
		hwContainer.addContainerProperty("nacionalidad", String.class, "");
		hwContainer.addContainerProperty("padre", Pais.class, null);		
		hwContainer.addContainerProperty("padre.id", Long.class, 0L);
		hwContainer.addContainerProperty("estado", Valor.class, null);
		hwContainer.addContainerProperty("estado.id", Long.class, null);
		
		if(mapPaises.get(Constante.OPCION.KEY_PADRE) != null){
			recorrer(Constante.OPCION.KEY_PADRE, mapPaises, null, hwContainer);
		}
		
		treePaises.setContainerDataSource(hwContainer);
		treePaises.setItemCaptionPropertyId("nombre");		
		treePaises.setVisibleColumns(new Object[]{"nombre"});
		
		for (Object id : treePaises.rootItemIds()){
			treePaises.setCollapsed(id, false);
        }
		
		for (Object itemId: treePaises.getItemIds())
			treePaises.setCollapsed(itemId, false);
	}
	
	private void recorrer(String nombre, Map<String, List<Pais>> map, Long objPadre, HierarchicalContainer hwContainer) {		
		Item item = null;
		for (Pais pais : map.get(nombre)) {			
			item = hwContainer.addItem(pais.getId());
			item.getItemProperty("id").setValue(pais.getId());
			item.getItemProperty("nombre").setValue(pais.getNombre());
			item.getItemProperty("abreviatura").setValue(pais.getNacionalidad());
			item.getItemProperty("nacionalidad").setValue(pais.getNacionalidad());
			item.getItemProperty("padre").setValue(pais.getPadre()== null ? null : pais.getPadre());
			item.getItemProperty("padre.id").setValue(pais.getPadre()== null ? null : pais.getPadre().getId());
			item.getItemProperty("estado").setValue(pais.getEstado() == null ? null : pais.getEstado());
			item.getItemProperty("estado.id").setValue(pais.getEstado() == null ? null : pais.getEstado().getId());
			
			if (!nombre.equals(Constante.OPCION.KEY_PADRE)){
				hwContainer.setParent(pais.getId(), objPadre);
			}
			if (map.get(pais.getId().toString()) != null) {
				recorrer(pais.getId().toString(), map, pais.getId(),hwContainer);
			} else {
				hwContainer.setChildrenAllowed(pais.getId().toString(), false);
			}
		}
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnRegistrar)){
			Pais pais = new Pais();
			pais.setNombre((String) txtNombre.getValue());
			pais.setEstado((Valor) cmbEstado.getValue());
			if (cmbNivel.getValue() != null) pais.setPadre((Pais) cmbNivel.getValue());			
			pais.setNacionalidad(txtNacionalidad.getValue() != null ? txtNacionalidad.getValue().toString() : StringUtils.EMPTY);
			
			if (flagNuevoPais) {
				paisService.crear(pais);
			}else {
				pais.setId(idPais);
				paisService.actualizar(pais);
			}
			refrescar();
		}
	}	
	
	private void refrescar(){
		habilitarEdicion(false);
		limpiar();
		Map<String,List<Pais>> mapPaises = paisService.listarPaises();
		cargarPaises(mapPaises);
	}
	
	private void habilitarEdicion(boolean flag){
		flagNuevoPais = !flag;
		if(flag){
			btnRegistrar.setCaption("Actualizar");
		}
		else{
			txtNacionalidad.setVisible(true);
			btnRegistrar.setCaption("Crear");
		}
	}
	
	private void limpiar(){		
		txtNombre.setValue("");
		txtNacionalidad.setValue("");		
		cmbNivel.select(null);
		cmbEstado.select(null);
		idPais = null;
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
		pnlListadoEstado.setWidth("560px");
		pnlListadoEstado.setHeight("-1px");
		pnlListadoEstado.setMargin(false);
		
		// lblFiltroBusqueda
		lblFiltroBusqueda = new Label();
		lblFiltroBusqueda.setStyleName("h2");
		lblFiltroBusqueda.setImmediate(false);
		lblFiltroBusqueda.setWidth("-1px");
		lblFiltroBusqueda.setHeight("-1px");
		lblFiltroBusqueda.setValue("Fitro de Busqueda de Paises");
		pnlListadoEstado.addComponent(lblFiltroBusqueda);
		
		// txtFiltroPais
		txtFiltroPais = new TextField();
		txtFiltroPais.setImmediate(false);
		txtFiltroPais.setWidth("550px");
		txtFiltroPais.setHeight("-1px");
		txtFiltroPais.setInputPrompt("Filtro de Busqueda");
		pnlListadoEstado.addComponent(txtFiltroPais);
		
		// treePaises
		treePaises = new TreeTable();
		treePaises.setImmediate(false);
		treePaises.setWidth("550px");
		treePaises.setHeight("300px");
		pnlListadoEstado.addComponent(treePaises);
		
		return pnlListadoEstado;
	}

	@AutoGenerated
	private VerticalLayout buildPnlDatosEstado() {
		// common part: create layout
		pnlDatosEstado = new VerticalLayout();
		pnlDatosEstado.setStyleName("h1");
		pnlDatosEstado.setImmediate(false);
		pnlDatosEstado.setWidth("-1px");
		pnlDatosEstado.setHeight("-1px");
		pnlDatosEstado.setMargin(false);
		pnlDatosEstado.setSpacing(true);
		
		// lblAdministracionPais
		lblAdministracionPais = new Label();
		lblAdministracionPais.setStyleName("h2");
		lblAdministracionPais.setImmediate(false);
		lblAdministracionPais.setWidth("-1px");
		lblAdministracionPais.setHeight("-1px");
		lblAdministracionPais.setValue("Administración de Paises");
		pnlDatosEstado.addComponent(lblAdministracionPais);
		
		// txtNombre
		txtNombre = new TextField();
		txtNombre.setCaption("Nombre");
		txtNombre.setImmediate(false);
		txtNombre.setWidth("220px");
		txtNombre.setHeight("-1px");
		txtNombre.setRequired(true);
		txtNombre.setInputPrompt("Nombre");
		pnlDatosEstado.addComponent(txtNombre);
		
		// txtNacionalidad
		txtNacionalidad = new TextField();
		txtNacionalidad.setCaption("Nacionalidad");
		txtNacionalidad.setImmediate(false);
		txtNacionalidad.setWidth("220px");
		txtNacionalidad.setHeight("-1px");
		txtNacionalidad.setInputPrompt("Nacionalidad del Pais");
		pnlDatosEstado.addComponent(txtNacionalidad);
		
		// cmbNivel
		cmbNivel = new ComboBox();
		cmbNivel.setCaption("Ciudad del Pais");
		cmbNivel.setImmediate(false);
		cmbNivel.setWidth("-1px");
		cmbNivel.setHeight("-1px");
		pnlDatosEstado.addComponent(cmbNivel);
		
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
	private HorizontalLayout buildPnlEstadoBotones() {
		// common part: create layout
		pnlEstadoBotones = new HorizontalLayout();
		pnlEstadoBotones.setImmediate(false);
		pnlEstadoBotones.setWidth("-1px");
		pnlEstadoBotones.setHeight("-1px");
		pnlEstadoBotones.setMargin(false);
		pnlEstadoBotones.setSpacing(true);
		
		// btnRegistrar
		btnRegistrar = new Button();
		btnRegistrar.setCaption("Registrar");
		btnRegistrar.setImmediate(true);
		btnRegistrar.setWidth("-1px");
		btnRegistrar.setHeight("-1px");
		pnlEstadoBotones.addComponent(btnRegistrar);
		
		// btnEliminar
		btnEliminar = new Button();
		btnEliminar.setCaption("Eliminar");
		btnEliminar.setImmediate(true);
		btnEliminar.setWidth("-1px");
		btnEliminar.setHeight("-1px");
		pnlEstadoBotones.addComponent(btnEliminar);
		
		return pnlEstadoBotones;
	}
}
