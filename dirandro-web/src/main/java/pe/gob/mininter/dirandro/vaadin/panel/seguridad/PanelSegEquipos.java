package pe.gob.mininter.dirandro.vaadin.panel.seguridad;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pe.gob.mininter.dirandro.model.Dependencia;
import pe.gob.mininter.dirandro.model.Integrante;
import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.model.Policia;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.IntegranteService;
import pe.gob.mininter.dirandro.service.PoliciaService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;
import pe.gob.mininter.dirandro.vaadin.panel.mantenimiento.PanelMantenDependencia;
import pe.gob.mininter.dirandro.vaadin.util.ComboBoxLOVS;
import pe.gob.mininter.dirandro.vaadin.util.DirandroComponent;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class PanelSegEquipos extends DirandroComponent implements ClickListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	
	@AutoGenerated
	private VerticalLayout mainLayout;

	@AutoGenerated
	private VerticalLayout pnlPrincipal;

	@AutoGenerated
	private HorizontalLayout pnlValorContenido;

	@AutoGenerated
	private VerticalLayout pnlGrabarIntegrante;

	@AutoGenerated
	private HorizontalLayout pnlValorFila5;

	@AutoGenerated
	private Button btnEliminarIntegrante;

	@AutoGenerated
	private Button btnGrabarIntegrante;

	@AutoGenerated
	private CheckBox cbLider;

	@AutoGenerated
	private ComboBox cmbNombreIntegrante;

	@AutoGenerated
	private ComboBoxLOVS cmbFuncionIntegrante;

	@AutoGenerated
	private ComboBoxLOVS cmbEstadoIntegrante;

	@AutoGenerated
	private Label lblIntegrante;

	@AutoGenerated
	private VerticalLayout pnlIntegrantes;

	@AutoGenerated
	private Table tblIntegrantes;

	@AutoGenerated
	private Label lblIntegrantes;

	@AutoGenerated
	private HorizontalLayout pnlDependencias;

	@AutoGenerated
	private PanelMantenDependencia pnlDependencia;

	private static final long serialVersionUID = -5759281628746296754L;
	
	protected static final Log logger = LogFactory.getLog(PanelSegEquipos.class);
	
	//** Servicios Utilizados
	private IntegranteService integranteService;	
	private PoliciaService policiaService;
	private Dependencia dependencia;
	
	//** Variables Globales
	private boolean flagNuevoIntegrante;
	private Integer conta = 1;
	private Long idIntegrante;
	
	private IndexedContainer containerIntegrantes = null;
	
	public PanelSegEquipos(List<Opcion> acciones, String height) {
		super(acciones, height);
		integranteService = Injector.obtenerServicio(IntegranteService.class);	
		policiaService = Injector.obtenerServicio(PoliciaService.class);
		buildMainLayout();
		setCompositionRoot(mainLayout);		
		postConstruct();
		debugId();
	}
	
	public Dependencia getDependencia() {
		return dependencia;
	}

	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
		limpiar();
		refrescar();
	}

	private void debugId(){
		mainLayout.setDebugId("mainLayout");
		pnlValorContenido.setDebugId("pnlValorContenido");
		pnlGrabarIntegrante.setDebugId("pnlGrabarIntegrante");
		pnlValorFila5.setDebugId("pnlValorFila5");
		btnEliminarIntegrante.setDebugId("btnEliminarIntegrante");
		btnGrabarIntegrante.setDebugId("btnGrabarIntegrante");
		cmbNombreIntegrante.setDebugId("cmbNombreIntegrante");
		cmbEstadoIntegrante.setDebugId("cmbEstadoIntegrante");
		cmbFuncionIntegrante.setDebugId("cmbFuncionIntegrante");
		pnlIntegrantes.setDebugId("pnlIntegrantes");
		tblIntegrantes.setDebugId("tblIntegrantes");
		lblIntegrantes.setDebugId("lblIntegrantes");
	}
	
	public void postConstruct() {
		inicializarVariables();
		inicializarIntegrantes();
		pnlDependencia.setPnlPadre(this);
	}
	
	//** Inicializar Variables Globales **// 
	private void inicializarVariables(){
		cargarIntegrantes(new ArrayList<Integrante>());
		
		cmbEstadoIntegrante.setCodigoLista(Constante.LISTA.CODIGO.ESTADO);
		cmbEstadoIntegrante.setInputPrompt("Estado");
		
		cmbFuncionIntegrante.setCodigoLista(Constante.LISTA.CODIGO.TIPO_FUNCION);
		cmbFuncionIntegrante.setInputPrompt("Funcion");
		
		List<Policia> lstPolicias = policiaService.buscar(null);
		cmbNombreIntegrante.setContainerDataSource(new BeanItemContainer<Policia>(Policia.class, lstPolicias));
		cmbNombreIntegrante.setInputPrompt("Nombre del Policia");
		cmbNombreIntegrante.setItemCaptionPropertyId("nombreCompleto");
		
		btnGrabarIntegrante.addListener((ClickListener)this);
		btnGrabarIntegrante.setIcon(Constante.ICONOS.SAVE);	
		btnEliminarIntegrante.addListener((ClickListener)this);
		btnEliminarIntegrante.setIcon(Constante.ICONOS.DELETE);
	}
	
	//Inicializar Integrantes **//
	private void inicializarIntegrantes(){
		
		pnlValorContenido.setVisible(true);
		habilitarEdicion("integrante", false);
		
		tblIntegrantes.setSelectable(true);
		tblIntegrantes.setImmediate(true);
		tblIntegrantes.setNullSelectionAllowed(true);
		tblIntegrantes.setNullSelectionItemId(null);

		tblIntegrantes.addListener(new Table.ValueChangeListener() {
			
			private static final long serialVersionUID = -4721770533858762047L;

			public void valueChange(ValueChangeEvent event) {

				boolean esModoNuevo = tblIntegrantes.getValue() == null;
				limpiar();
				 
				if (esModoNuevo) {
                    habilitarEdicion("integrante", false);
                }else {
                	habilitarEdicion("integrante", true);
                	Item item = tblIntegrantes.getItem(tblIntegrantes.getValue());
                	
                	idIntegrante = (Long) item.getItemProperty("id").getValue();
                	
                	Valor estado = new Valor();
                	estado.setId( HarecUtil.toLong( item.getItemProperty("estado.id").getValue() ) );
                	cmbEstadoIntegrante.select( estado );
                	
                	
                	cbLider.setValue(  item.getItemProperty("lider").getValue() );
                	
                	Valor funcion = new Valor();
                	funcion.setId( HarecUtil.toLong( item.getItemProperty("funcion.id").getValue() ) );
                	cmbFuncionIntegrante.select( funcion );
                
                	logger.debug("integrante "+HarecUtil.toLong( item.getItemProperty("integrante.id").getValue() ));
                	Policia pol = new Policia();
                	pol.setId( HarecUtil.toLong( item.getItemProperty("integrante.id").getValue() ) );
                	cmbNombreIntegrante.setValue(pol);
				}
            }
        });
	}
	
	private IndexedContainer cargarContainerIntegrantes(){
		containerIntegrantes = new IndexedContainer();
		containerIntegrantes.addContainerProperty("id", Long.class,  null);
		containerIntegrantes.addContainerProperty("integrante.id", Long.class, null);
		containerIntegrantes.addContainerProperty("integrante.nombreCompleto", String.class,  null);	
		containerIntegrantes.addContainerProperty("estado.id", Long.class, null);
		containerIntegrantes.addContainerProperty("estado.nombre", String.class, null);
		containerIntegrantes.addContainerProperty("funcion.id", Long.class, null);
		containerIntegrantes.addContainerProperty("funcion.codigo", String.class, null);
		containerIntegrantes.addContainerProperty("funcion.nombre", String.class, null);
		containerIntegrantes.addContainerProperty("lider", Boolean.class, null);
		return containerIntegrantes;
	}
		
	private void cargarIntegrantes(List<Integrante> lstIntegrantes ){
		
		tblIntegrantes.setContainerDataSource(cargarContainerIntegrantes());
		tblIntegrantes.setVisibleColumns(new Object[]{"id", "integrante.nombreCompleto", "funcion.nombre", "estado.nombre"});		
				
		tblIntegrantes.setColumnWidth("integrante.nombreCompleto", 200);	
		tblIntegrantes.setColumnWidth("estado.nombre", 45);
		tblIntegrantes.setColumnWidth("funcion.nombre", 200);		
				
		tblIntegrantes.setColumnHeader("integrante.nombreCompleto", "Integrante");
		tblIntegrantes.setColumnHeader("estado.nombre", "Estado");
		tblIntegrantes.setColumnHeader("funcion.nombre", "Funcion");
		
		for (Integrante integrante: lstIntegrantes){
			Item item = containerIntegrantes.addItem(conta++);
			item.getItemProperty("id").setValue(integrante.getId());
			/*
			item.getItemProperty("integrante.usuario").setValue(integrante.getUsuario().getUsuario());
			*/
			item.getItemProperty("integrante.id").setValue(integrante.getPolicia().getId());
			item.getItemProperty("integrante.nombreCompleto").setValue(integrante.getNombreCompletoIntegrante());
			item.getItemProperty("estado.id").setValue(integrante.getEstado() == null ? null : integrante.getEstado().getId());
			item.getItemProperty("estado.nombre").setValue(integrante.getEstado() == null ? null : integrante.getEstado().getNombre());
			item.getItemProperty("funcion.id").setValue(integrante.getFuncion() == null ? null : integrante.getFuncion().getId());
			item.getItemProperty("funcion.codigo").setValue(integrante.getFuncion() == null ? null : integrante.getFuncion().getCodigo());
			item.getItemProperty("funcion.nombre").setValue(integrante.getFuncion() == null ? null : integrante.getFuncion().getNombre());
			item.getItemProperty("lider").setValue( integrante.getEsLider() == 1 ? true:false );
		}
	}
	
	//** Acciones de los Botones
	@Override
	public void buttonClick(ClickEvent event) {	
		
		if (event.getButton().equals(btnGrabarIntegrante))
			buttonClickGrabarIntegrante();
		
		if (event.getButton().equals(btnEliminarIntegrante))
			buttonClickEliminarIntegrante();
	}
	
	private void buttonClickGrabarIntegrante(){
		logger.debug(" dependencia "+dependencia.getNombre());
		
		Integrante integrante = new Integrante();
		integrante.setEstado((Valor)cmbEstadoIntegrante.getValue());
		integrante.setFuncion((Valor)cmbFuncionIntegrante.getValue());
		integrante.setDependencia(dependencia);
		integrante.setPolicia((Policia)cmbNombreIntegrante.getValue());
		integrante.setEsLider( (Boolean)cbLider.getValue() ? 1 : 0 );
		
		if(flagNuevoIntegrante){
			integranteService.crear(integrante);
		}else{
			integrante.setId(idIntegrante);
			integranteService.actualizar(integrante);
		}
		limpiar();
		refrescar();
	
	}
	
	private void buttonClickEliminarIntegrante(){
		integranteService.eliminarXId(idIntegrante);
        refrescar();
	}
	
	private void limpiar(){
		cmbNombreIntegrante.setValue(null);
		cmbEstadoIntegrante.setValue(null);
		cmbFuncionIntegrante.setValue(null);
		cbLider.setValue( false );
	}
	
	private void refrescar(){
		Integrante nuevoInt = new Integrante();
		nuevoInt.setDependencia(dependencia);
		List<Integrante> lstIntegrantes = integranteService.buscar(nuevoInt);
		cargarIntegrantes(lstIntegrantes);
	}
	
	private void habilitarEdicion(String nombre, boolean flag){
		if (nombre.equals("equipo")) {
			//flagNuevoEquipo = !flag;
			/*btnEliminarEquipo.setVisible(flag);
			if (flag) {
				btnGrabarEquipo.setCaption("Actualizar");
				btnGrabarIntegrante.setEnabled(true);
			} else {
				btnGrabarEquipo.setCaption("Crear");
				btnGrabarIntegrante.setEnabled(false);
			}*/
		} else if (nombre.equals("integrante")) {
			flagNuevoIntegrante = !flag;
			btnEliminarIntegrante.setVisible(flag);
			if (flag) {
				btnGrabarIntegrante.setCaption("Actualizar");
			} else {
				btnGrabarIntegrante.setCaption("Crear");
			}
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
	private VerticalLayout buildPnlPrincipal() {
		// common part: create layout
		pnlPrincipal = new VerticalLayout();
		pnlPrincipal.setStyleName("whiteBackGround");
		pnlPrincipal.setImmediate(false);
		pnlPrincipal.setWidth("-1px");
		pnlPrincipal.setHeight("-1px");
		pnlPrincipal.setMargin(false);
		pnlPrincipal.setSpacing(true);
		
		// pnlDependencias
		pnlDependencias = buildPnlDependencias();
		pnlPrincipal.addComponent(pnlDependencias);
		
		// pnlValorContenido
		pnlValorContenido = buildPnlValorContenido();
		pnlPrincipal.addComponent(pnlValorContenido);
		
		return pnlPrincipal;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlDependencias() {
		// common part: create layout
		pnlDependencias = new HorizontalLayout();
		pnlDependencias.setImmediate(false);
		pnlDependencias.setWidth("-1px");
		pnlDependencias.setHeight("-1px");
		pnlDependencias.setMargin(false);
		pnlDependencias.setSpacing(true);
		
		// pnlDependencia
		pnlDependencia = new PanelMantenDependencia(null, "-1px");
		pnlDependencia.setImmediate(false);
		pnlDependencia.setWidth("-1px");
		pnlDependencia.setHeight("-1px");
		pnlDependencias.addComponent(pnlDependencia);
		
		return pnlDependencias;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlValorContenido() {
		// common part: create layout
		pnlValorContenido = new HorizontalLayout();
		pnlValorContenido.setImmediate(false);
		pnlValorContenido.setWidth("-1px");
		pnlValorContenido.setHeight("-1px");
		pnlValorContenido.setMargin(true);
		pnlValorContenido.setSpacing(true);
		
		// pnlIntegrantes
		pnlIntegrantes = buildPnlIntegrantes();
		pnlValorContenido.addComponent(pnlIntegrantes);
		
		// pnlGrabarIntegrante
		pnlGrabarIntegrante = buildPnlGrabarIntegrante();
		pnlValorContenido.addComponent(pnlGrabarIntegrante);
		
		return pnlValorContenido;
	}

	@AutoGenerated
	private VerticalLayout buildPnlIntegrantes() {
		// common part: create layout
		pnlIntegrantes = new VerticalLayout();
		pnlIntegrantes.setImmediate(false);
		pnlIntegrantes.setWidth("-1px");
		pnlIntegrantes.setHeight("-1px");
		pnlIntegrantes.setMargin(false);
		
		// lblIntegrantes
		lblIntegrantes = new Label();
		lblIntegrantes.setStyleName("h2");
		lblIntegrantes.setImmediate(false);
		lblIntegrantes.setWidth("600px");
		lblIntegrantes.setHeight("-1px");
		lblIntegrantes.setValue("Integrantes por equipo");
		pnlIntegrantes.addComponent(lblIntegrantes);
		
		// tblIntegrantes
		tblIntegrantes = new Table();
		tblIntegrantes.setImmediate(false);
		tblIntegrantes.setWidth("590px");
		tblIntegrantes.setHeight("250px");
		pnlIntegrantes.addComponent(tblIntegrantes);
		
		return pnlIntegrantes;
	}

	@AutoGenerated
	private VerticalLayout buildPnlGrabarIntegrante() {
		// common part: create layout
		pnlGrabarIntegrante = new VerticalLayout();
		pnlGrabarIntegrante.setImmediate(false);
		pnlGrabarIntegrante.setWidth("-1px");
		pnlGrabarIntegrante.setHeight("-1px");
		pnlGrabarIntegrante.setMargin(false);
		pnlGrabarIntegrante.setSpacing(true);
		
		// lblIntegrante
		lblIntegrante = new Label();
		lblIntegrante.setStyleName("h2");
		lblIntegrante.setImmediate(false);
		lblIntegrante.setWidth("-1px");
		lblIntegrante.setHeight("-1px");
		lblIntegrante.setValue("Administracion de Integrantes");
		pnlGrabarIntegrante.addComponent(lblIntegrante);
		
		// cmbEstadoIntegrante
		cmbEstadoIntegrante = new ComboBoxLOVS();
		cmbEstadoIntegrante.setCaption("Estado");
		cmbEstadoIntegrante.setImmediate(false);
		cmbEstadoIntegrante.setWidth("-1px");
		cmbEstadoIntegrante.setHeight("-1px");
		pnlGrabarIntegrante.addComponent(cmbEstadoIntegrante);
		
		// cmbFuncionIntegrante
		cmbFuncionIntegrante = new ComboBoxLOVS();
		cmbFuncionIntegrante.setCaption("Funcion");
		cmbFuncionIntegrante.setImmediate(false);
		cmbFuncionIntegrante.setWidth("-1px");
		cmbFuncionIntegrante.setHeight("-1px");
		pnlGrabarIntegrante.addComponent(cmbFuncionIntegrante);
		
		// cmbNombreIntegrante
		cmbNombreIntegrante = new ComboBox();
		cmbNombreIntegrante.setCaption("Policia Integrante");
		cmbNombreIntegrante.setImmediate(false);
		cmbNombreIntegrante.setWidth("250px");
		cmbNombreIntegrante.setHeight("-1px");
		cmbNombreIntegrante.setRequired(true);
		pnlGrabarIntegrante.addComponent(cmbNombreIntegrante);
		
		// cbLider
		cbLider = new CheckBox();
		cbLider.setCaption("es Líder");
		cbLider.setImmediate(false);
		cbLider.setDescription("indica si es el lider del equipo");
		cbLider.setWidth("-1px");
		cbLider.setHeight("-1px");
		pnlGrabarIntegrante.addComponent(cbLider);
		
		// pnlValorFila5
		pnlValorFila5 = buildPnlValorFila5();
		pnlGrabarIntegrante.addComponent(pnlValorFila5);
		pnlGrabarIntegrante.setComponentAlignment(pnlValorFila5, new Alignment(
				20));
		
		return pnlGrabarIntegrante;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlValorFila5() {
		// common part: create layout
		pnlValorFila5 = new HorizontalLayout();
		pnlValorFila5.setCaption(" ");
		pnlValorFila5.setImmediate(false);
		pnlValorFila5.setWidth("-1px");
		pnlValorFila5.setHeight("-1px");
		pnlValorFila5.setMargin(false);
		pnlValorFila5.setSpacing(true);
		
		// btnGrabarIntegrante
		btnGrabarIntegrante = new Button();
		btnGrabarIntegrante.setCaption("Actualizar");
		btnGrabarIntegrante.setImmediate(true);
		btnGrabarIntegrante.setWidth("-1px");
		btnGrabarIntegrante.setHeight("-1px");
		pnlValorFila5.addComponent(btnGrabarIntegrante);
		
		// btnEliminarIntegrante
		btnEliminarIntegrante = new Button();
		btnEliminarIntegrante.setCaption("Eliminar");
		btnEliminarIntegrante.setImmediate(true);
		btnEliminarIntegrante.setWidth("-1px");
		btnEliminarIntegrante.setHeight("-1px");
		pnlValorFila5.addComponent(btnEliminarIntegrante);
		
		return pnlValorFila5;
	}

}
