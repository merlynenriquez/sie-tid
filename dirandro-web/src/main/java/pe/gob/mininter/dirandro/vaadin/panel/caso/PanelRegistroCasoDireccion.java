package pe.gob.mininter.dirandro.vaadin.panel.caso;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import pe.gob.mininter.dirandro.model.Caso;
import pe.gob.mininter.dirandro.model.DetCasoDireccion;
import pe.gob.mininter.dirandro.model.Direccion;
import pe.gob.mininter.dirandro.model.Distrito;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.CasoDireccionService;
import pe.gob.mininter.dirandro.service.UbigeoService;
import pe.gob.mininter.dirandro.util.BeanValidar;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;
import pe.gob.mininter.dirandro.vaadin.dialogs.AlertDialog;
import pe.gob.mininter.dirandro.vaadin.util.ComboBoxLOVS;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.AbstractSelect.Filtering;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PanelRegistroCasoDireccion extends CustomComponent  implements ClickListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout verticalLayout_1;
	@AutoGenerated
	private Table tblDirecciones;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_4;
	@AutoGenerated
	private TextArea txtDetalleUso;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_3;
	@AutoGenerated
	private ComboBoxLOVS cmbTipoUso;
	@AutoGenerated
	private ComboBoxLOVS cmbSituacion;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private Button btnAgregar;
	@AutoGenerated
	private TextField txtReferencia;
	@AutoGenerated
	private TextField txtDireccin2;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private ComboBox cmbUbicacion;

	
	private static final String COLUMN_ID = "ID";
	private static final String COLUMN_DIRECCION = "DIRECCION";
	private static final String COLUMN_DIRECCION_OBJ = "DIRECCION_OBJ";
	private static final String COLUMN_REFERENCIA = "REFERENCIA";
	private static final String COLUMN_UBICACION = "UBICACION_ID";
	private static final String COLUMN_UBICACION_NOMBRE = "UBICACION_NOMBRE";
	private static final String COLUMN_SITUACION = "SITUACION_ID";
	private static final String COLUMN_SITUACION_NOMBRE = "SITUACION_NOMBRE";
	private static final String COLUMN_TIPO_USO = "TIPO_USO_ID";
	private static final String COLUMN_TIPO_USO_NOMBRE = "TIPO_USO_NOMBRE";
	private static final String COLUMN_TIPO_USO_DETALLE = "TIPO_USO_DETALLE";
	
	private static final long serialVersionUID = 5050037855079683040L;
	private static final Logger logger = Logger.getLogger(PanelRegistroCasoDireccion.class);
	private CasoDireccionService casoDireccionService;
	private boolean inicializado=false;
	private UbigeoService ubigeoService;
	private Caso caso;
	private DetCasoDireccion casoDireccion;
	
	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
		postConstruct();
	}

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelRegistroCasoDireccion() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		casoDireccionService = Injector.obtenerServicio(CasoDireccionService.class);
		ubigeoService = Injector.obtenerServicio(UbigeoService.class);
		postConstruct();
	}

	private void postConstruct(){
		if(caso!=null && !caso.esNuevo() && !inicializado){

		List<Distrito> distritos = ubigeoService.obtenerTodos();
		
		cmbSituacion.setInputPrompt("Situación");
		cmbSituacion.setRequired(true);
		cmbSituacion.setCodigoLista(Constante.LISTA.CODIGO.SITUACION_GENERAL);
		cmbSituacion.attach();

		cmbTipoUso.setInputPrompt("Tipo de Uso");
		cmbTipoUso.setRequired(true);
		cmbTipoUso.setCodigoLista(Constante.LISTA.CODIGO.INMUEBLE_TIPO_USO);
		cmbTipoUso.attach();
		
		cmbUbicacion.setInputPrompt("Distrito - Provincia - Departamento");
		cmbUbicacion.setItemCaptionPropertyId("nombreCompleto");
		cmbUbicacion.setContainerDataSource(new BeanItemContainer<Distrito>(Distrito.class,  distritos));
		cmbUbicacion.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
		
		tblDirecciones.setSelectable(true);
		tblDirecciones.setImmediate(true);
		tblDirecciones.setNullSelectionAllowed(true);
		tblDirecciones.setNullSelectionItemId(null);
		tblDirecciones.addListener(new ValueChangeListener() {
			
			private static final long serialVersionUID = 7962790507398071986L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				boolean esModoNuevo = tblDirecciones.getValue() == null;
				limpiar();
				if(esModoNuevo){
					tblDirecciones.setValue(null);
					habilitarEdicion(false);
				}else{
					habilitarEdicion(true);
					Item item = tblDirecciones.getItem(tblDirecciones.getValue());
				
					casoDireccion.setId((Long) item.getItemProperty(COLUMN_ID).getValue());					
					casoDireccion.setDireccion((Direccion) item.getItemProperty(COLUMN_DIRECCION_OBJ).getValue());
					
					txtDireccin2.setValue(item.getItemProperty(COLUMN_DIRECCION).getValue());
					txtReferencia.setValue(item.getItemProperty(COLUMN_REFERENCIA).getValue());
					cmbUbicacion.select((Distrito)item.getItemProperty(COLUMN_UBICACION).getValue());
					cmbTipoUso.select((Valor)item.getItemProperty(COLUMN_TIPO_USO).getValue());
					cmbSituacion.select((Valor)item.getItemProperty(COLUMN_SITUACION).getValue());
					txtDetalleUso.setValue(item.getItemProperty(COLUMN_TIPO_USO_DETALLE).getValue());
					
				}
			}
		});	
		
		btnAgregar.addListener((ClickListener)this);
		cargarTabla();
		limpiar();
		habilitarEdicion(false);
		inicializado = true;	
	
		}
	}

	private void cargarTabla( ){
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty(COLUMN_ID, Long.class,  null);
		container.addContainerProperty(COLUMN_DIRECCION, String.class, null);
		container.addContainerProperty(COLUMN_DIRECCION_OBJ, Direccion.class, null);
		container.addContainerProperty(COLUMN_REFERENCIA, String.class, null);
		container.addContainerProperty(COLUMN_UBICACION, Distrito.class, null);
		container.addContainerProperty(COLUMN_UBICACION_NOMBRE, String.class, null);
		container.addContainerProperty(COLUMN_SITUACION, Valor.class, null);
		container.addContainerProperty(COLUMN_SITUACION_NOMBRE, String.class, null);
		container.addContainerProperty(COLUMN_TIPO_USO, Valor.class, null);
		container.addContainerProperty(COLUMN_TIPO_USO_NOMBRE, String.class, null);
		container.addContainerProperty(COLUMN_TIPO_USO_DETALLE, String.class, null);
		
		tblDirecciones.setContainerDataSource(container);
		tblDirecciones.setVisibleColumns(new Object[]{COLUMN_DIRECCION,COLUMN_UBICACION_NOMBRE,COLUMN_REFERENCIA});

		tblDirecciones.setColumnHeader(COLUMN_DIRECCION, "Dirección");
		tblDirecciones.setColumnHeader(COLUMN_UBICACION_NOMBRE, "Ubicación");
		tblDirecciones.setColumnHeader(COLUMN_REFERENCIA, "Referencia");
		
		DetCasoDireccion det = new DetCasoDireccion();
		det.setCaso(caso);
		List<DetCasoDireccion> lstCasoDireccion = casoDireccionService.buscar(det);
		
		int con=1;
		for (DetCasoDireccion detarma : lstCasoDireccion){
			Item item = container.addItem(con++);
			item.getItemProperty(COLUMN_ID).setValue(detarma.getId());
			item.getItemProperty(COLUMN_DIRECCION).setValue(detarma.getDireccion()!=null?HarecUtil.nullToEmpty(detarma.getDireccion().getDireccion()):StringUtils.EMPTY);
			item.getItemProperty(COLUMN_DIRECCION_OBJ).setValue(detarma.getDireccion());
			item.getItemProperty(COLUMN_REFERENCIA).setValue(detarma.getDireccion()!=null?HarecUtil.nullToEmpty(detarma.getDireccion().getReferencia()):StringUtils.EMPTY);
			item.getItemProperty(COLUMN_UBICACION).setValue(detarma.getDireccion().getDistrito());
			item.getItemProperty(COLUMN_UBICACION_NOMBRE).setValue(detarma.getDireccion().getDistrito()!=null?HarecUtil.nullToEmpty(detarma.getDireccion().getDistrito().getNombreCompleto()):null);
			item.getItemProperty(COLUMN_SITUACION).setValue(detarma.getSituacion());
			item.getItemProperty(COLUMN_SITUACION_NOMBRE).setValue(HarecUtil.valorNombreToEmpty(detarma.getSituacion()));
			item.getItemProperty(COLUMN_TIPO_USO).setValue(detarma.getTipoUso());
			item.getItemProperty(COLUMN_TIPO_USO_NOMBRE).setValue(HarecUtil.valorNombreToEmpty(detarma.getTipoUso()));
			item.getItemProperty(COLUMN_TIPO_USO_DETALLE).setValue(detarma.getDetalleUso());
		}
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnAgregar)){
			grabarCasoDireccion();
		}
	}
	
	private void grabarCasoDireccion(){
		
		Direccion dir = casoDireccion.getDireccion();
		dir.setDistrito((Distrito)cmbUbicacion.getValue());
		dir.setDireccion((String)txtDireccin2.getValue());
		dir.setReferencia((String)txtReferencia.getValue());
		casoDireccion.setDireccion(dir);
		casoDireccion.setDetalleUso((String)txtDetalleUso.getValue());
		casoDireccion.setTipoUso(cmbTipoUso.getValor());
		casoDireccion.setSituacion(cmbSituacion.getValor());
		logger.debug("valida direccion");
		HarecUtil.validar(getWindow(), dir, new BeanValidar[]{
        	new BeanValidar("distrito", new Object[]{"Ubicación"}, cmbUbicacion),
        	new BeanValidar("direccion", new Object[]{"Dirección"}, txtDireccin2),
        	new BeanValidar("referencia", new Object[]{"Referencia"}, txtReferencia)        	
        });
		logger.debug("valida detalledireccion");
		HarecUtil.validar(getWindow(), casoDireccion, new BeanValidar[]{
        	new BeanValidar("direccion", new Object[]{"Dirección"}, cmbUbicacion),
        	new BeanValidar("situacion", new Object[]{"Situación"}, cmbSituacion),
        	new BeanValidar("tipoUso", new Object[]{"Tipo de Uso"}, cmbTipoUso)
        });
		
		AlertDialog alertDialog = null;
		if(casoDireccion.esNuevo()){
			casoDireccionService.registrar(casoDireccion);
			alertDialog = new  AlertDialog("Registro de Dirección", "Se ha registrado la dirección correctamente", "Aceptar", "400");
		}else{
			casoDireccionService.actualizar(casoDireccion);
			alertDialog = new  AlertDialog("Registro de Dirección", "Se ha actualizado la dirección correctamente", "Aceptar", "400");
		}
		
		getApplication().getMainWindow().addWindow(alertDialog);
		limpiar();
		cargarTabla();
		
	}
	
	private void habilitarEdicion(boolean flag){
		if(flag){
			btnAgregar.setCaption("Actualizar");
		}else{
			btnAgregar.setCaption("Agregar");
		}
	}
	
	public void limpiar(){
		casoDireccion = new DetCasoDireccion();
		casoDireccion.setDireccion(new Direccion());
		casoDireccion.setCaso(caso);
		cmbUbicacion.select(null);
		cmbSituacion.select(null);
		cmbTipoUso.select(null);
		txtDireccin2.setValue("");
		txtReferencia.setValue("");
		txtDetalleUso.setValue("");
	}
	
	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// verticalLayout_1
		verticalLayout_1 = buildVerticalLayout_1();
		mainLayout.addComponent(verticalLayout_1);
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_1() {
		// common part: create layout
		verticalLayout_1 = new VerticalLayout();
		verticalLayout_1.setImmediate(false);
		verticalLayout_1.setWidth("100.0%");
		verticalLayout_1.setHeight("-1px");
		verticalLayout_1.setMargin(true);
		verticalLayout_1.setSpacing(true);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		verticalLayout_1.addComponent(horizontalLayout_1);
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		verticalLayout_1.addComponent(horizontalLayout_2);
		
		// horizontalLayout_3
		horizontalLayout_3 = buildHorizontalLayout_3();
		verticalLayout_1.addComponent(horizontalLayout_3);
		
		// horizontalLayout_4
		horizontalLayout_4 = buildHorizontalLayout_4();
		verticalLayout_1.addComponent(horizontalLayout_4);
		
		// tblDirecciones
		tblDirecciones = new Table();
		tblDirecciones.setImmediate(false);
		tblDirecciones.setWidth("600px");
		tblDirecciones.setHeight("200px");
		verticalLayout_1.addComponent(tblDirecciones);
		
		return verticalLayout_1;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("-1px");
		horizontalLayout_1.setHeight("-1px");
		horizontalLayout_1.setMargin(false);
		
		// cmbUbicacion
		cmbUbicacion = new ComboBox();
		cmbUbicacion.setCaption("Ubicación");
		cmbUbicacion.setImmediate(false);
		cmbUbicacion.setWidth("-1px");
		cmbUbicacion.setHeight("-1px");
		horizontalLayout_1.addComponent(cmbUbicacion);
		
		return horizontalLayout_1;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_2() {
		// common part: create layout
		horizontalLayout_2 = new HorizontalLayout();
		horizontalLayout_2.setImmediate(false);
		horizontalLayout_2.setWidth("-1px");
		horizontalLayout_2.setHeight("-1px");
		horizontalLayout_2.setMargin(false);
		
		// txtDireccin2
		txtDireccin2 = new TextField();
		txtDireccin2.setCaption("Dirección");
		txtDireccin2.setImmediate(false);
		txtDireccin2.setWidth("200px");
		txtDireccin2.setHeight("-1px");
		txtDireccin2.setRequired(true);
		txtDireccin2.setInputPrompt("Dirección");
		txtDireccin2.setMaxLength(250);
		horizontalLayout_2.addComponent(txtDireccin2);
		
		// txtReferencia
		txtReferencia = new TextField();
		txtReferencia.setCaption("Referencia");
		txtReferencia.setImmediate(false);
		txtReferencia.setWidth("300px");
		txtReferencia.setHeight("-1px");
		txtReferencia.setInputPrompt("Referencia");
		txtReferencia.setMaxLength(500);
		horizontalLayout_2.addComponent(txtReferencia);
		
		// btnAgregar
		btnAgregar = new Button();
		btnAgregar.setCaption("Agregar");
		btnAgregar.setImmediate(true);
		btnAgregar.setWidth("-1px");
		btnAgregar.setHeight("-1px");
		horizontalLayout_2.addComponent(btnAgregar);
		horizontalLayout_2.setComponentAlignment(btnAgregar, new Alignment(9));
		
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
		horizontalLayout_3.setSpacing(true);
		
		// cmbSituacion
		cmbSituacion = new ComboBoxLOVS();
		cmbSituacion.setCaption("Situación");
		cmbSituacion.setImmediate(false);
		cmbSituacion.setWidth("-1px");
		cmbSituacion.setHeight("-1px");
		horizontalLayout_3.addComponent(cmbSituacion);
		
		// cmbTipoUso
		cmbTipoUso = new ComboBoxLOVS();
		cmbTipoUso.setCaption("Tipo de Uso");
		cmbTipoUso.setImmediate(false);
		cmbTipoUso.setWidth("-1px");
		cmbTipoUso.setHeight("-1px");
		horizontalLayout_3.addComponent(cmbTipoUso);
		
		return horizontalLayout_3;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_4() {
		// common part: create layout
		horizontalLayout_4 = new HorizontalLayout();
		horizontalLayout_4.setImmediate(false);
		horizontalLayout_4.setWidth("-1px");
		horizontalLayout_4.setHeight("-1px");
		horizontalLayout_4.setMargin(false);
		horizontalLayout_4.setSpacing(true);
		
		// txtDetalleUso
		txtDetalleUso = new TextArea();
		txtDetalleUso.setCaption("Detalle del uso");
		txtDetalleUso.setImmediate(false);
		txtDetalleUso.setWidth("600px");
		txtDetalleUso.setHeight("50px");
		txtDetalleUso.setInputPrompt("Detalle del uso");
		txtDetalleUso.setMaxLength(2000);
		horizontalLayout_4.addComponent(txtDetalleUso);
		
		return horizontalLayout_4;
	}

}
