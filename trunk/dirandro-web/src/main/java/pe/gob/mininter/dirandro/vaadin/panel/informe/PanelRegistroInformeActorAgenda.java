package pe.gob.mininter.dirandro.vaadin.panel.informe;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.Agenda;
import pe.gob.mininter.dirandro.model.AgendaActor;
import pe.gob.mininter.dirandro.model.Persona;
import pe.gob.mininter.dirandro.service.AgendaActorService;
import pe.gob.mininter.dirandro.service.PersonaService;
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
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
public class PanelRegistroInformeActorAgenda extends CustomComponent implements ClickListener{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlPrincipal;
	@AutoGenerated
	private Table tblActorAgenda;
	@AutoGenerated
	private Button btnGuardar;
	@AutoGenerated
	private HorizontalLayout lytFormulario3;
	@AutoGenerated
	private ComboBoxLOVS cmbEstadoDiligencia;
	@AutoGenerated
	private Label lblEstadoDiligencia;
	@AutoGenerated
	private TextField txtHoraDiligencia;
	@AutoGenerated
	private Label lblHoraDiligencia;
	@AutoGenerated
	private HorizontalLayout lytFormulario2;
	@AutoGenerated
	private PopupDateField dtFechaDiligencia;
	@AutoGenerated
	private Label lblFechaDiligencia;
	@AutoGenerated
	private TextField txtLugarDiligencia;
	@AutoGenerated
	private Label lblLugarDiligencia;
	@AutoGenerated
	private HorizontalLayout lytFormulario1;
	@AutoGenerated
	private ComboBoxLOVS cmbMotivo;
	@AutoGenerated
	private Label lblMotivo;
	@AutoGenerated
	private ComboBox cmbActor;
	@AutoGenerated
	private Label lblActor;
	@AutoGenerated
	private Label lblFormulario;
	@AutoGenerated
	private HorizontalLayout lytDatosAgenda2;
	@AutoGenerated
	private TextField txtFechaEmision;
	@AutoGenerated
	private Label lblFechaEmision;
	@AutoGenerated
	private TextField txtUnidadProcuraduria;
	@AutoGenerated
	private Label lblUnidadProcuraduria;
	@AutoGenerated
	private HorizontalLayout lytDatosAgenda1;
	@AutoGenerated
	private TextField txtTipoAgenda;
	@AutoGenerated
	private Label lblTipoAgenda;
	@AutoGenerated
	private TextField txtNotificacion;
	@AutoGenerated
	private Label lblNotificacion;
	@AutoGenerated
	private Label lblDatosAgenda;
	private Agenda agenda;
	private List<Persona> actores;
	private PersonaService personaService;
	private AgendaActorService agendaActorService;
	
	public static final String COLUMNA_ACTOR = "actor";
	public static final String COLUMNA_MOTIVO = "motivo";
	public static final String COLUMNA_LUGAR = "lugar";
	public static final String COLUMNA_FECHA = "fecha";
	public static final String COLUMNA_HORA = "hora";
	public static final String COLUMNA_ESTADO = "estado";
	public static final String COLUMNA_OPCION_ELIMINAR = "eliminar";
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelRegistroInformeActorAgenda(Agenda agenda) {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		personaService=Injector.obtenerServicio(PersonaService.class);
		agendaActorService=Injector.obtenerServicio(AgendaActorService.class);
		this.agenda=agenda;
		postConstruct();
	}

	public void postConstruct() {
		
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		
		txtNotificacion.setValue(agenda.getNotificacion()==null?null:agenda.getNotificacion().getCompleto());
		txtNotificacion.setNullRepresentation(StringUtils.EMPTY);
		txtNotificacion.setEnabled(false);
		txtTipoAgenda.setValue(agenda.getTipoAgenda()==null?null:agenda.getTipoAgenda().getNombre());
		txtTipoAgenda.setNullRepresentation(StringUtils.EMPTY);
		txtTipoAgenda.setEnabled(false);
		txtUnidadProcuraduria.setValue(agenda.getDependencia()==null?null:agenda.getDependencia().getNombre());
		txtUnidadProcuraduria.setNullRepresentation(StringUtils.EMPTY);
		txtUnidadProcuraduria.setEnabled(false);
		txtFechaEmision.setValue(agenda.getFechaEmision()==null?null:df.format(agenda.getFechaEmision()));
		txtFechaEmision.setNullRepresentation(StringUtils.EMPTY);
		txtFechaEmision.setEnabled(false);
		
		actores = personaService.buscar(null);
		cmbActor.setItemCaptionPropertyId("nombreCompleto");
		cmbActor.setContainerDataSource(new BeanItemContainer<Persona>(Persona.class,  actores));
		
		cmbMotivo.setCodigoLista(Constante.LISTA.CODIGO.ESTADO);
		cmbMotivo.setInputPrompt("Motivo");
		
		txtHoraDiligencia.setNullRepresentation(StringUtils.EMPTY);
		txtLugarDiligencia.setNullRepresentation(StringUtils.EMPTY);
		
		cmbEstadoDiligencia.setCodigoLista(Constante.LISTA.CODIGO.ESTADO);
		cmbEstadoDiligencia.setInputPrompt("Estado");
		
		btnGuardar.addListener(this);
	
		cargarDatos();
		
	}
	
	private void limpiar(){
		cmbActor.setValue(null);
		cmbMotivo.setValue(null);
		txtLugarDiligencia.setValue(null);
		dtFechaDiligencia.setValue(null);
		txtHoraDiligencia.setValue(null);
		cmbEstadoDiligencia.setValue(null);
	}
	
	private void cargarDatos(){
		AgendaActor agendaActorBuscar=new AgendaActor();
		agendaActorBuscar.setAgenda(agenda);
		List<AgendaActor> agendaActores=agendaActorService.buscar(agendaActorBuscar);
		
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty(COLUMNA_ACTOR, String.class,  null);
        container.addContainerProperty(COLUMNA_MOTIVO, String.class,  null);
        container.addContainerProperty(COLUMNA_LUGAR, String.class,  null);
        container.addContainerProperty(COLUMNA_FECHA, String.class,  null);
        container.addContainerProperty(COLUMNA_HORA, String.class,  null);
        container.addContainerProperty(COLUMNA_ESTADO, String.class,  null);
        container.addContainerProperty(COLUMNA_OPCION_ELIMINAR, Button.class,  null);
        
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        DateFormat df2=new SimpleDateFormat("HH:mm");
        
        int con=1;
		for (final AgendaActor agendaActor : agendaActores) {
			Item item=container.addItem(con++);
			for (Persona persona : actores) {
				if(persona.getId()==agendaActor.getActor()){
					item.getItemProperty(COLUMNA_ACTOR).setValue(persona.getNombreCompleto());
				}
			}
			item.getItemProperty(COLUMNA_MOTIVO).setValue(agendaActor.getMotivo()==null?null:agendaActor.getMotivo().getNombre());
			item.getItemProperty(COLUMNA_LUGAR).setValue(agendaActor.getLugar());
			item.getItemProperty(COLUMNA_FECHA).setValue(agendaActor.getFecha()==null?null:df.format(agendaActor.getFecha()));
			item.getItemProperty(COLUMNA_HORA).setValue(agendaActor.getHora()==null?null:df2.format(agendaActor.getHora()));
			item.getItemProperty(COLUMNA_ESTADO).setValue(agendaActor.getEstado()==null?null:agendaActor.getEstado().getNombre());
			Button eliminar=new Button();
			eliminar.setCaption("Eliminar");
			eliminar.addListener(new ClickListener() {
				
				@Override
				public void buttonClick(ClickEvent event) {
					agendaActorService.eliminar(agendaActor);
					cargarDatos();
				}
			});
			item.getItemProperty(COLUMNA_OPCION_ELIMINAR).
			setValue(eliminar);
		}
        
        tblActorAgenda.setContainerDataSource(container);
        tblActorAgenda.setVisibleColumns(new Object[]{COLUMNA_ACTOR, 
        		COLUMNA_MOTIVO, COLUMNA_LUGAR, 
        		COLUMNA_FECHA, COLUMNA_HORA,
        		COLUMNA_ESTADO, COLUMNA_OPCION_ELIMINAR});
        tblActorAgenda.setColumnWidth(COLUMNA_ACTOR, 100);
        tblActorAgenda.setColumnWidth(COLUMNA_MOTIVO, 100);
        tblActorAgenda.setColumnWidth(COLUMNA_LUGAR, 100);
        tblActorAgenda.setColumnWidth(COLUMNA_FECHA, 100);
        tblActorAgenda.setColumnWidth(COLUMNA_HORA, 100);
        tblActorAgenda.setColumnWidth(COLUMNA_ESTADO, 100);
        tblActorAgenda.setColumnWidth(COLUMNA_OPCION_ELIMINAR, 100);
        tblActorAgenda.setColumnHeader(COLUMNA_ACTOR, "Actor");
        tblActorAgenda.setColumnHeader(COLUMNA_MOTIVO, "Motivo");
        tblActorAgenda.setColumnHeader(COLUMNA_LUGAR, "Lugar");
        tblActorAgenda.setColumnHeader(COLUMNA_FECHA, "Fecha");
        tblActorAgenda.setColumnHeader(COLUMNA_HORA, "Hora");
        tblActorAgenda.setColumnHeader(COLUMNA_ESTADO, "Estado");
        tblActorAgenda.setColumnHeader(COLUMNA_OPCION_ELIMINAR, "");
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnGuardar)){
			AgendaActor agendaActor=new AgendaActor();
			agendaActor.setAgenda(agenda);
			Persona persona=(Persona)cmbActor.getValue();
			agendaActor.setActor(persona.getId());
			agendaActor.setMotivo(cmbMotivo.getValor());
			agendaActor.setLugar((String)txtLugarDiligencia.getValue());
			agendaActor.setFecha((Date)dtFechaDiligencia.getValue());
			agendaActor.setHora((Date)dtFechaDiligencia.getValue());
			agendaActor.setEstado(cmbEstadoDiligencia.getValor());
			agendaActorService.crear(agendaActor);
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
		
		// lblDatosAgenda
		lblDatosAgenda = new Label();
		lblDatosAgenda.setStyleName("h2");
		lblDatosAgenda.setImmediate(false);
		lblDatosAgenda.setWidth("-1px");
		lblDatosAgenda.setHeight("-1px");
		lblDatosAgenda.setValue("Datos de la Agenda");
		pnlPrincipal.addComponent(lblDatosAgenda);
		
		// lytDatosAgenda1
		lytDatosAgenda1 = buildLytDatosAgenda1();
		pnlPrincipal.addComponent(lytDatosAgenda1);
		
		// lytDatosAgenda2
		lytDatosAgenda2 = buildLytDatosAgenda2();
		pnlPrincipal.addComponent(lytDatosAgenda2);
		
		// lblFormulario
		lblFormulario = new Label();
		lblFormulario.setStyleName("h2");
		lblFormulario.setImmediate(false);
		lblFormulario.setWidth("-1px");
		lblFormulario.setHeight("-1px");
		lblFormulario.setValue("Formulario");
		pnlPrincipal.addComponent(lblFormulario);
		
		// lytFormulario1
		lytFormulario1 = buildLytFormulario1();
		pnlPrincipal.addComponent(lytFormulario1);
		
		// lytFormulario2
		lytFormulario2 = buildLytFormulario2();
		pnlPrincipal.addComponent(lytFormulario2);
		
		// lytFormulario3
		lytFormulario3 = buildLytFormulario3();
		pnlPrincipal.addComponent(lytFormulario3);
		
		// btnGuardar
		btnGuardar = new Button();
		btnGuardar.setCaption("Agregar");
		btnGuardar.setImmediate(true);
		btnGuardar.setWidth("-1px");
		btnGuardar.setHeight("-1px");
		pnlPrincipal.addComponent(btnGuardar);
		pnlPrincipal.setComponentAlignment(btnGuardar, new Alignment(20));
		
		// tblActorAgenda
		tblActorAgenda = new Table();
		tblActorAgenda.setImmediate(false);
		tblActorAgenda.setWidth("800px");
		tblActorAgenda.setHeight("200px");
		pnlPrincipal.addComponent(tblActorAgenda);
		
		return pnlPrincipal;
	}

	@AutoGenerated
	private HorizontalLayout buildLytDatosAgenda1() {
		// common part: create layout
		lytDatosAgenda1 = new HorizontalLayout();
		lytDatosAgenda1.setImmediate(false);
		lytDatosAgenda1.setWidth("-1px");
		lytDatosAgenda1.setHeight("-1px");
		lytDatosAgenda1.setMargin(false);
		lytDatosAgenda1.setSpacing(true);
		
		// lblNotificacion
		lblNotificacion = new Label();
		lblNotificacion.setImmediate(false);
		lblNotificacion.setWidth("160px");
		lblNotificacion.setHeight("-1px");
		lblNotificacion.setValue("Notificacion");
		lytDatosAgenda1.addComponent(lblNotificacion);
		
		// txtNotificacion
		txtNotificacion = new TextField();
		txtNotificacion.setImmediate(false);
		txtNotificacion.setWidth("150px");
		txtNotificacion.setHeight("-1px");
		lytDatosAgenda1.addComponent(txtNotificacion);
		
		// lblTipoAgenda
		lblTipoAgenda = new Label();
		lblTipoAgenda.setImmediate(false);
		lblTipoAgenda.setWidth("160px");
		lblTipoAgenda.setHeight("-1px");
		lblTipoAgenda.setValue("Tipo Agenda");
		lytDatosAgenda1.addComponent(lblTipoAgenda);
		
		// txtTipoAgenda
		txtTipoAgenda = new TextField();
		txtTipoAgenda.setImmediate(false);
		txtTipoAgenda.setWidth("150px");
		txtTipoAgenda.setHeight("-1px");
		lytDatosAgenda1.addComponent(txtTipoAgenda);
		
		return lytDatosAgenda1;
	}

	@AutoGenerated
	private HorizontalLayout buildLytDatosAgenda2() {
		// common part: create layout
		lytDatosAgenda2 = new HorizontalLayout();
		lytDatosAgenda2.setImmediate(false);
		lytDatosAgenda2.setWidth("-1px");
		lytDatosAgenda2.setHeight("-1px");
		lytDatosAgenda2.setMargin(false);
		lytDatosAgenda2.setSpacing(true);
		
		// lblUnidadProcuraduria
		lblUnidadProcuraduria = new Label();
		lblUnidadProcuraduria.setImmediate(false);
		lblUnidadProcuraduria.setWidth("160px");
		lblUnidadProcuraduria.setHeight("-1px");
		lblUnidadProcuraduria.setValue("Unidad Procuraduria");
		lytDatosAgenda2.addComponent(lblUnidadProcuraduria);
		
		// txtUnidadProcuraduria
		txtUnidadProcuraduria = new TextField();
		txtUnidadProcuraduria.setImmediate(false);
		txtUnidadProcuraduria.setWidth("150px");
		txtUnidadProcuraduria.setHeight("-1px");
		lytDatosAgenda2.addComponent(txtUnidadProcuraduria);
		
		// lblFechaEmision
		lblFechaEmision = new Label();
		lblFechaEmision.setImmediate(false);
		lblFechaEmision.setWidth("160px");
		lblFechaEmision.setHeight("-1px");
		lblFechaEmision.setValue("Fecha Emision Agenda");
		lytDatosAgenda2.addComponent(lblFechaEmision);
		
		// txtFechaEmision
		txtFechaEmision = new TextField();
		txtFechaEmision.setImmediate(false);
		txtFechaEmision.setWidth("150px");
		txtFechaEmision.setHeight("-1px");
		lytDatosAgenda2.addComponent(txtFechaEmision);
		
		return lytDatosAgenda2;
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
		
		// lblActor
		lblActor = new Label();
		lblActor.setImmediate(false);
		lblActor.setWidth("100px");
		lblActor.setHeight("-1px");
		lblActor.setValue("Actor");
		lytFormulario1.addComponent(lblActor);
		
		// cmbActor
		cmbActor = new ComboBox();
		cmbActor.setImmediate(false);
		cmbActor.setWidth("150px");
		cmbActor.setHeight("-1px");
		lytFormulario1.addComponent(cmbActor);
		
		// lblMotivo
		lblMotivo = new Label();
		lblMotivo.setImmediate(false);
		lblMotivo.setWidth("100px");
		lblMotivo.setHeight("-1px");
		lblMotivo.setValue("Motivo");
		lytFormulario1.addComponent(lblMotivo);
		
		// cmbMotivo
		cmbMotivo = new ComboBoxLOVS();
		cmbMotivo.setImmediate(false);
		cmbMotivo.setWidth("150px");
		cmbMotivo.setHeight("-1px");
		lytFormulario1.addComponent(cmbMotivo);
		
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
		
		// lblLugarDiligencia
		lblLugarDiligencia = new Label();
		lblLugarDiligencia.setImmediate(false);
		lblLugarDiligencia.setWidth("100px");
		lblLugarDiligencia.setHeight("-1px");
		lblLugarDiligencia.setValue("Lugar Diligencia");
		lytFormulario2.addComponent(lblLugarDiligencia);
		
		// txtLugarDiligencia
		txtLugarDiligencia = new TextField();
		txtLugarDiligencia.setImmediate(false);
		txtLugarDiligencia.setWidth("150px");
		txtLugarDiligencia.setHeight("-1px");
		lytFormulario2.addComponent(txtLugarDiligencia);
		
		// lblFechaDiligencia
		lblFechaDiligencia = new Label();
		lblFechaDiligencia.setImmediate(false);
		lblFechaDiligencia.setWidth("100px");
		lblFechaDiligencia.setHeight("-1px");
		lblFechaDiligencia.setValue("Fecha Diligencia");
		lytFormulario2.addComponent(lblFechaDiligencia);
		
		// dtFechaDiligencia
		dtFechaDiligencia = new PopupDateField();
		dtFechaDiligencia.setImmediate(false);
		dtFechaDiligencia.setWidth("150px");
		dtFechaDiligencia.setHeight("-1px");
		dtFechaDiligencia.setResolution(4);
		lytFormulario2.addComponent(dtFechaDiligencia);
		
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
		
		// lblHoraDiligencia
		lblHoraDiligencia = new Label();
		lblHoraDiligencia.setImmediate(false);
		lblHoraDiligencia.setWidth("100px");
		lblHoraDiligencia.setHeight("-1px");
		lblHoraDiligencia.setValue("Hora Diligencia");
		lytFormulario3.addComponent(lblHoraDiligencia);
		
		// txtHoraDiligencia
		txtHoraDiligencia = new TextField();
		txtHoraDiligencia.setImmediate(false);
		txtHoraDiligencia.setWidth("150px");
		txtHoraDiligencia.setHeight("-1px");
		lytFormulario3.addComponent(txtHoraDiligencia);
		
		// lblEstadoDiligencia
		lblEstadoDiligencia = new Label();
		lblEstadoDiligencia.setImmediate(false);
		lblEstadoDiligencia.setWidth("100px");
		lblEstadoDiligencia.setHeight("-1px");
		lblEstadoDiligencia.setValue("Estado Diligencia");
		lytFormulario3.addComponent(lblEstadoDiligencia);
		
		// cmbEstadoDiligencia
		cmbEstadoDiligencia = new ComboBoxLOVS();
		cmbEstadoDiligencia.setImmediate(false);
		cmbEstadoDiligencia.setWidth("150px");
		cmbEstadoDiligencia.setHeight("-1px");
		lytFormulario3.addComponent(cmbEstadoDiligencia);
		
		return lytFormulario3;
	}

}
