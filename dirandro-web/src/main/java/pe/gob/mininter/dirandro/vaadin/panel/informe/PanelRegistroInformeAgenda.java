package pe.gob.mininter.dirandro.vaadin.panel.informe;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import pe.gob.mininter.dirandro.model.Agenda;
import pe.gob.mininter.dirandro.model.Dependencia;
import pe.gob.mininter.dirandro.model.Informe;
import pe.gob.mininter.dirandro.model.Notificacion;
import pe.gob.mininter.dirandro.service.AgendaService;
import pe.gob.mininter.dirandro.service.DependenciaService;
import pe.gob.mininter.dirandro.service.NotificacionService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.vaadin.util.ComboBoxLOVS;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
public class PanelRegistroInformeAgenda extends CustomComponent implements ClickListener{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlPrincipal;
	@AutoGenerated
	private Table tblAgenda;
	@AutoGenerated
	private HorizontalLayout lytFormulario3;
	@AutoGenerated
	private Button btnGuardar;
	@AutoGenerated
	private HorizontalLayout lytFormulario2;
	@AutoGenerated
	private PopupDateField dtFechaEmision;
	@AutoGenerated
	private Label lblFechaEmision;
	@AutoGenerated
	private ComboBox cmbUnidadProcuraduria;
	@AutoGenerated
	private Label lblUnidadProcuraduria;
	@AutoGenerated
	private HorizontalLayout lytFormulario1;
	@AutoGenerated
	private ComboBoxLOVS cmbTipoAgenda;
	@AutoGenerated
	private Label lblTipoAgenda;
	@AutoGenerated
	private ComboBox cmbNotificacion;
	@AutoGenerated
	private Label lblNotificacion;
	private AgendaService agendaService;
	private DependenciaService dependenciaService;
	private NotificacionService notificacionService;
	
	private Informe informe;
	
	public Informe getInforme() {
		return informe;
	}

	public void setInforme(Informe informe) {
		this.informe = informe;
	}

	public static final String COLUMNA_NOTIFICACION = "notificacion";
	public static final String COLUMNA_TIPO_AGENDA = "tipo_agenda";
	public static final String COLUMNA_UNIDAD_PROCURADURIA = "unidad_procuraduria";
	public static final String COLUMNA_FECHA_EMISION = "fecha_emision";
	public static final String COLUMNA_OPCION_ELIMINAR = "eliminar";
	public static final String COLUMNA_OPCION_ACTOR = "actor";
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelRegistroInformeAgenda() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		agendaService=Injector.obtenerServicio(AgendaService.class);
		dependenciaService=Injector.obtenerServicio(DependenciaService.class);
		notificacionService=Injector.obtenerServicio(NotificacionService.class);
		postConstruct();
	}

	public void postConstruct() {
		
		cmbTipoAgenda.setCodigoLista(Constante.LISTA.CODIGO.ESTADO);
		cmbTipoAgenda.setInputPrompt("Tipo Notificacion");

		List<Dependencia> dependencias = dependenciaService.buscar(null);
		
		BeanItemContainer<Dependencia> containerDependencia = new BeanItemContainer<Dependencia>(Dependencia.class,  dependencias);
		cmbUnidadProcuraduria.setContainerDataSource(containerDependencia);
		cmbUnidadProcuraduria.setItemCaptionPropertyId("nombre");
		
		Notificacion notificacionBuscar=new Notificacion();
		notificacionBuscar.setInforme(informe);
		List<Notificacion> notificaciones=notificacionService.buscar(notificacionBuscar);
		BeanItemContainer<Notificacion> containerNotificacion = new BeanItemContainer<Notificacion>(Notificacion.class, notificaciones);
		cmbNotificacion.setContainerDataSource(containerNotificacion);
		cmbNotificacion.setItemCaptionPropertyId("completo");
		
		btnGuardar.addListener(this);
	
		cargarDatos();
		
	}
	
	private void limpiar(){
		cmbNotificacion.setValue(null);
		cmbTipoAgenda.setValue(null);
		cmbUnidadProcuraduria.setValue(null);
		dtFechaEmision.setValue(null);
	}
	
	private void cargarDatos(){
		Agenda agendaBuscar=new Agenda();
		Notificacion notificacion=new Notificacion();
		notificacion.setInforme(informe);
		agendaBuscar.setNotificacion(notificacion);
		List<Agenda> agendas=agendaService.buscar(agendaBuscar);
		
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty(COLUMNA_NOTIFICACION, String.class,  null);
		container.addContainerProperty(COLUMNA_TIPO_AGENDA, String.class,  null);
        container.addContainerProperty(COLUMNA_UNIDAD_PROCURADURIA, String.class,  null);
        container.addContainerProperty(COLUMNA_FECHA_EMISION, String.class,  null);
        container.addContainerProperty(COLUMNA_OPCION_ELIMINAR, Button.class,  null);
        container.addContainerProperty(COLUMNA_OPCION_ACTOR, Button.class,  null);
        
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        
        int con=1;
		for (final Agenda agenda : agendas) {
			Item item=container.addItem(con++);
			item.getItemProperty(COLUMNA_NOTIFICACION).setValue(agenda.getNotificacion()==null?null:agenda.getNotificacion().getCompleto());
			item.getItemProperty(COLUMNA_TIPO_AGENDA).setValue(agenda.getTipoAgenda()==null?null:agenda.getTipoAgenda().getNombre());
			item.getItemProperty(COLUMNA_UNIDAD_PROCURADURIA).setValue(agenda.getDependencia()==null?null:agenda.getDependencia().getNombre());
			item.getItemProperty(COLUMNA_FECHA_EMISION).setValue(agenda.getFechaEmision()==null?null:df.format(agenda.getFechaEmision()));
			Button eliminar=new Button();
			eliminar.setCaption("Eliminar");
			eliminar.addListener(new ClickListener() {
				
				@Override
				public void buttonClick(ClickEvent event) {
					agendaService.eliminar(agenda);
					cargarDatos();
				}
			});
			item.getItemProperty(COLUMNA_OPCION_ELIMINAR).
			setValue(eliminar);
			Button actor=new Button();
			actor.setCaption("Actor");
			actor.addListener(new ClickListener() {
				
				@Override
				public void buttonClick(ClickEvent event) {
					
					PanelRegistroInformeActorAgenda panelRegistroInformeActorAgenda=new PanelRegistroInformeActorAgenda(agenda);
					
					Window wdActor = new Window();
					
					wdActor.setModal(true);
					wdActor.setResizable(false);
					wdActor.addComponent(panelRegistroInformeActorAgenda);
						
					wdActor.setCaption("Actor");
					wdActor.setWidth("1050px");
					getApplication().getMainWindow().getWindow().addWindow(wdActor);
				}
			});
			item.getItemProperty(COLUMNA_OPCION_ACTOR).
			setValue(actor);
		}
        
        tblAgenda.setContainerDataSource(container);
        tblAgenda.setVisibleColumns(new Object[]{COLUMNA_NOTIFICACION, COLUMNA_TIPO_AGENDA, 
        		COLUMNA_UNIDAD_PROCURADURIA, COLUMNA_FECHA_EMISION, 
        		COLUMNA_OPCION_ELIMINAR, COLUMNA_OPCION_ACTOR});
        tblAgenda.setColumnWidth(COLUMNA_NOTIFICACION, 100);
        tblAgenda.setColumnWidth(COLUMNA_TIPO_AGENDA, 100);
        tblAgenda.setColumnWidth(COLUMNA_UNIDAD_PROCURADURIA, 100);
        tblAgenda.setColumnWidth(COLUMNA_FECHA_EMISION, 100);
        tblAgenda.setColumnWidth(COLUMNA_OPCION_ELIMINAR, 100);
        tblAgenda.setColumnWidth(COLUMNA_OPCION_ACTOR, 100);
        tblAgenda.setColumnHeader(COLUMNA_NOTIFICACION, "Notificacion");
        tblAgenda.setColumnHeader(COLUMNA_TIPO_AGENDA, "Tipo");
        tblAgenda.setColumnHeader(COLUMNA_UNIDAD_PROCURADURIA, "Unidad");
        tblAgenda.setColumnHeader(COLUMNA_FECHA_EMISION, "F. Emision");
        tblAgenda.setColumnHeader(COLUMNA_OPCION_ELIMINAR, "");
        tblAgenda.setColumnHeader(COLUMNA_OPCION_ACTOR, "");
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnGuardar)){
			Agenda agenda=new Agenda();
			agenda.setNotificacion((Notificacion)cmbNotificacion.getValue());
			agenda.setTipoAgenda(cmbTipoAgenda.getValor());
			agenda.setDependencia((Dependencia)cmbUnidadProcuraduria.getValue());
			agenda.setFechaEmision((Date)dtFechaEmision.getValue());
			agendaService.crear(agenda);
			limpiar();
			cargarDatos();
		}
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
		
		// pnlPrincipal
		pnlPrincipal = buildPnlPrincipal();
		mainLayout.addComponent(pnlPrincipal);
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildPnlPrincipal() {
		// common part: create layout
		pnlPrincipal = new VerticalLayout();
		pnlPrincipal.setImmediate(false);
		pnlPrincipal.setWidth("-1px");
		pnlPrincipal.setHeight("-1px");
		pnlPrincipal.setMargin(false);
		pnlPrincipal.setSpacing(true);
		
		// lytFormulario1
		lytFormulario1 = buildLytFormulario1();
		pnlPrincipal.addComponent(lytFormulario1);
		
		// lytFormulario2
		lytFormulario2 = buildLytFormulario2();
		pnlPrincipal.addComponent(lytFormulario2);
		
		// lytFormulario3
		lytFormulario3 = buildLytFormulario3();
		pnlPrincipal.addComponent(lytFormulario3);
		pnlPrincipal.setComponentAlignment(lytFormulario3, new Alignment(20));
		
		// tblAgenda
		tblAgenda = new Table();
		tblAgenda.setImmediate(false);
		tblAgenda.setWidth("800px");
		tblAgenda.setHeight("200px");
		pnlPrincipal.addComponent(tblAgenda);
		
		return pnlPrincipal;
	}

	@AutoGenerated
	private HorizontalLayout buildLytFormulario1() {
		// common part: create layout
		lytFormulario1 = new HorizontalLayout();
		lytFormulario1.setImmediate(false);
		lytFormulario1.setWidth("-1px");
		lytFormulario1.setHeight("-1px");
		lytFormulario1.setMargin(false);
		lytFormulario1.setSpacing(true);
		
		// lblNotificacion
		lblNotificacion = new Label();
		lblNotificacion.setImmediate(false);
		lblNotificacion.setWidth("160px");
		lblNotificacion.setHeight("-1px");
		lblNotificacion.setValue("Notificacion");
		lytFormulario1.addComponent(lblNotificacion);
		
		// cmbNotificacion
		cmbNotificacion = new ComboBox();
		cmbNotificacion.setImmediate(false);
		cmbNotificacion.setWidth("150px");
		cmbNotificacion.setHeight("-1px");
		lytFormulario1.addComponent(cmbNotificacion);
		
		// lblTipoAgenda
		lblTipoAgenda = new Label();
		lblTipoAgenda.setImmediate(false);
		lblTipoAgenda.setWidth("160px");
		lblTipoAgenda.setHeight("-1px");
		lblTipoAgenda.setValue("Tipo Agenda");
		lytFormulario1.addComponent(lblTipoAgenda);
		
		// cmbTipoAgenda
		cmbTipoAgenda = new ComboBoxLOVS();
		cmbTipoAgenda.setImmediate(false);
		cmbTipoAgenda.setWidth("150px");
		cmbTipoAgenda.setHeight("-1px");
		lytFormulario1.addComponent(cmbTipoAgenda);
		
		return lytFormulario1;
	}

	@AutoGenerated
	private HorizontalLayout buildLytFormulario2() {
		// common part: create layout
		lytFormulario2 = new HorizontalLayout();
		lytFormulario2.setImmediate(false);
		lytFormulario2.setWidth("-1px");
		lytFormulario2.setHeight("-1px");
		lytFormulario2.setMargin(false);
		lytFormulario2.setSpacing(true);
		
		// lblUnidadProcuraduria
		lblUnidadProcuraduria = new Label();
		lblUnidadProcuraduria.setImmediate(false);
		lblUnidadProcuraduria.setWidth("160px");
		lblUnidadProcuraduria.setHeight("-1px");
		lblUnidadProcuraduria.setValue("Unidad Procuraduria");
		lytFormulario2.addComponent(lblUnidadProcuraduria);
		
		// cmbUnidadProcuraduria
		cmbUnidadProcuraduria = new ComboBox();
		cmbUnidadProcuraduria.setImmediate(false);
		cmbUnidadProcuraduria.setWidth("150px");
		cmbUnidadProcuraduria.setHeight("-1px");
		lytFormulario2.addComponent(cmbUnidadProcuraduria);
		
		// lblFechaEmision
		lblFechaEmision = new Label();
		lblFechaEmision.setImmediate(false);
		lblFechaEmision.setWidth("160px");
		lblFechaEmision.setHeight("-1px");
		lblFechaEmision.setValue("Fecha Emision Agenda");
		lytFormulario2.addComponent(lblFechaEmision);
		
		// dtFechaEmision
		dtFechaEmision = new PopupDateField();
		dtFechaEmision.setImmediate(false);
		dtFechaEmision.setWidth("150px");
		dtFechaEmision.setHeight("-1px");
		dtFechaEmision.setResolution(4);
		lytFormulario2.addComponent(dtFechaEmision);
		
		return lytFormulario2;
	}

	@AutoGenerated
	private HorizontalLayout buildLytFormulario3() {
		// common part: create layout
		lytFormulario3 = new HorizontalLayout();
		lytFormulario3.setImmediate(false);
		lytFormulario3.setWidth("-1px");
		lytFormulario3.setHeight("-1px");
		lytFormulario3.setMargin(false);
		lytFormulario3.setSpacing(true);
		
		// btnGuardar
		btnGuardar = new Button();
		btnGuardar.setCaption("Agregar");
		btnGuardar.setImmediate(true);
		btnGuardar.setWidth("-1px");
		btnGuardar.setHeight("-1px");
		lytFormulario3.addComponent(btnGuardar);
		
		return lytFormulario3;
	}

}
