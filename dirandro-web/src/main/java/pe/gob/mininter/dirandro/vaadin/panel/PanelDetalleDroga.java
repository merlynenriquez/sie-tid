package pe.gob.mininter.dirandro.vaadin.panel;

import java.util.List;

import pe.gob.mininter.dirandro.model.DetDroga;
import pe.gob.mininter.dirandro.model.Droga;
import pe.gob.mininter.dirandro.model.Persona;
import pe.gob.mininter.dirandro.service.DetalleDrogaService;
import pe.gob.mininter.dirandro.service.PersonaService;
import pe.gob.mininter.dirandro.util.BeanValidar;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;
import pe.gob.mininter.dirandro.vaadin.dialogs.AlertDialog;
import pe.gob.mininter.dirandro.vaadin.util.ComboBoxLOVS;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class PanelDetalleDroga extends CustomComponent implements ClickListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_6;
	@AutoGenerated
	private Table tblDetalleImplicados;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_4;
	@AutoGenerated
	private Button btnGrabar;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_5;
	@AutoGenerated
	private ComboBoxLOVS cmbEstadoParticipacion;
	@AutoGenerated
	private ComboBoxLOVS cmbParticipacion;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_3;
	@AutoGenerated
	private ComboBox cmbImplicado;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private ComboBoxLOVS cmbTransporte;
	@AutoGenerated
	private ComboBoxLOVS cmbModalidad;
	@AutoGenerated
	private Label lblDroga;
	
	private static final long serialVersionUID = -4076198478455334619L;
	
	private DetalleDrogaService detalleDrogaService;
	private PersonaService personaService;
	private List<DetDroga> lstDetalleDrogas;
	private DetDroga detalleDroga;
	
	private static final String COLUMN_ID_DETALLE = "COLUMN_ID_DETALLE";
	private static final String COLUMN_TIPO_TRANSPORTE = "COLUMN_TIPO_TRANSPORTE";
	private static final String COLUMN_TIPO_MODALIDAD = "COLUMN_TIPO_MODALIDAD";
	private static final String COLUMN_IMPLICADO = "COLUMN_IMPLICADO";
	private static final String COLUMN_DROGA = "COLUMN_IMPLICADO";
	
	public PanelDetalleDroga() {
		buildMainLayout();
		detalleDrogaService = Injector.obtenerServicio(DetalleDrogaService.class);
		personaService = Injector.obtenerServicio(PersonaService.class);
		setCompositionRoot(mainLayout);
		postConstruct();
	}
	
	public void recibirDroga(Droga droga){
		lblDroga.setValue(droga.getTipoDroga().getNombre());
		detalleDroga = new DetDroga();
		detalleDroga.setDroga(droga);
		refrescar();
	}

	private void postConstruct() {
		cmbModalidad.setInputPrompt("Modalidad de Transporte");
		cmbTransporte.setInputPrompt("Tipo de Transporte");
		cmbParticipacion.setInputPrompt("Tipo de Participacion");
		cmbEstadoParticipacion.setInputPrompt("Estado Participacion");
		
		cmbModalidad.setCodigoLista(Constante.LISTA.CODIGO.MODALIDAD_DROGA);
		cmbTransporte.setCodigoLista(Constante.LISTA.CODIGO.TRANSPORTE_DROGA);
		cmbParticipacion.setCodigoLista(Constante.LISTA.CODIGO.PARTICIPACION);
		cmbEstadoParticipacion.setCodigoLista(Constante.LISTA.CODIGO.ESTADO_PARTICIPACION);
		
		List<Persona> lstPersonas = personaService.buscar(null);
		cmbImplicado.setInputPrompt("Implicado");
		cmbImplicado.setItemCaptionPropertyId("nombreCompleto");
		cmbImplicado.setImmediate(true);
		cmbImplicado.setContainerDataSource(new BeanItemContainer<Persona>(Persona.class, lstPersonas));
			
		btnGrabar.addListener((ClickListener) this);
		btnGrabar.setImmediate(true);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if (event.getButton().equals(btnGrabar)) {
			detalleDroga.setModalidad(cmbModalidad.getValor());
			detalleDroga.setTransporte(cmbTransporte.getValor());
			detalleDroga.setPersonaImplicada(cmbImplicado.getValue() != null ? (Persona) cmbImplicado.getValue() : null);
			detalleDroga.setEstadoParticipacion(cmbEstadoParticipacion.getValor());
			detalleDroga.setParticipacion(cmbParticipacion.getValor());
			HarecUtil.validar(getWindow(), detalleDroga, new BeanValidar[]{
					new BeanValidar("transporte", new Object[]{"Tipo de Transporte"}, cmbTransporte),
                 new BeanValidar("modalidad", new Object[]{"Modalidad del Transporte"}, cmbModalidad),
                 new BeanValidar("personaImplicada", new Object[]{"Implicado"}, cmbImplicado)});
			
			detalleDrogaService.crear(detalleDroga);
			
			AlertDialog alertDialog = new  AlertDialog("Registro de Armas", "Se ha registrado el detalle de la droga correctamente", "Aceptar", "400");
			getApplication().getMainWindow().addWindow(alertDialog);
			refrescar();
		}
		
	}
	
	private void refrescar() {
		cargarDetalleDrogas();
		limpiar();
	}
	
	private void cargarDetalleDrogas(){
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty(COLUMN_ID_DETALLE, Long.class,  null);
		container.addContainerProperty(COLUMN_DROGA, String.class, null);
		container.addContainerProperty(COLUMN_TIPO_MODALIDAD, String.class, null);
		container.addContainerProperty(COLUMN_TIPO_TRANSPORTE, String.class, null);
		container.addContainerProperty(COLUMN_IMPLICADO, String.class, null);
		
		lstDetalleDrogas = detalleDrogaService.buscar(detalleDroga);
		tblDetalleImplicados.setContainerDataSource(container);
		tblDetalleImplicados.setVisibleColumns(new Object[]{COLUMN_DROGA, COLUMN_TIPO_MODALIDAD, COLUMN_TIPO_TRANSPORTE});
				
		tblDetalleImplicados.setColumnHeader(COLUMN_DROGA, "Nombre Droga");
		tblDetalleImplicados.setColumnHeader(COLUMN_TIPO_MODALIDAD, "Tipo de Modalidad");
		tblDetalleImplicados.setColumnHeader(COLUMN_TIPO_TRANSPORTE, "Tipo de Transporte");
				
		int con=1;
		for (DetDroga detalle : lstDetalleDrogas) {
			Item item = container.addItem(con++);
			item.getItemProperty(COLUMN_ID_DETALLE).setValue(detalle.getId());
			item.getItemProperty(COLUMN_DROGA).setValue(detalle.getDroga().getTipoDroga().getNombre());
			item.getItemProperty(COLUMN_TIPO_MODALIDAD).setValue(detalle.getModalidad().getNombre());
			item.getItemProperty(COLUMN_TIPO_TRANSPORTE).setValue(detalle.getTransporte().getNombre());
		}		
		
	}
	
	private void limpiar() {
		cmbEstadoParticipacion.select(null);
		cmbModalidad.select(null);
		cmbImplicado.select(null);
		cmbParticipacion.select(null);
		cmbTransporte.select(null);
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("-1px");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true);
		
		// top-level component properties
		setWidth("-1px");
		setHeight("-1px");
		
		// lblDroga
		lblDroga = new Label();
		lblDroga.setImmediate(false);
		lblDroga.setWidth("-1px");
		lblDroga.setHeight("-1px");
		lblDroga.setValue("Droga: ");
		lblDroga.setContentMode(3);
		mainLayout.addComponent(lblDroga);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		mainLayout.addComponent(horizontalLayout_1);
		
		// horizontalLayout_3
		horizontalLayout_3 = buildHorizontalLayout_3();
		mainLayout.addComponent(horizontalLayout_3);
		
		// horizontalLayout_5
		horizontalLayout_5 = buildHorizontalLayout_5();
		mainLayout.addComponent(horizontalLayout_5);
		
		// horizontalLayout_4
		horizontalLayout_4 = buildHorizontalLayout_4();
		mainLayout.addComponent(horizontalLayout_4);
		mainLayout.setComponentAlignment(horizontalLayout_4, new Alignment(20));
		
		// horizontalLayout_6
		horizontalLayout_6 = buildHorizontalLayout_6();
		mainLayout.addComponent(horizontalLayout_6);
		
		return mainLayout;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("-1px");
		horizontalLayout_1.setHeight("-1px");
		horizontalLayout_1.setMargin(false);
		horizontalLayout_1.setSpacing(true);
		
		// cmbModalidad
		cmbModalidad = new ComboBoxLOVS();
		cmbModalidad.setCaption("Modalidad");
		cmbModalidad.setImmediate(false);
		cmbModalidad.setWidth("200px");
		cmbModalidad.setHeight("-1px");
		horizontalLayout_1.addComponent(cmbModalidad);
		
		// cmbTransporte
		cmbTransporte = new ComboBoxLOVS();
		cmbTransporte.setCaption("Tipo de Transporte");
		cmbTransporte.setImmediate(false);
		cmbTransporte.setWidth("200px");
		cmbTransporte.setHeight("-1px");
		horizontalLayout_1.addComponent(cmbTransporte);
		
		return horizontalLayout_1;
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
		
		// cmbImplicado
		cmbImplicado = new ComboBox();
		cmbImplicado.setCaption("Persona ");
		cmbImplicado.setImmediate(false);
		cmbImplicado.setWidth("400px");
		cmbImplicado.setHeight("-1px");
		horizontalLayout_3.addComponent(cmbImplicado);
		
		return horizontalLayout_3;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_5() {
		// common part: create layout
		horizontalLayout_5 = new HorizontalLayout();
		horizontalLayout_5.setImmediate(false);
		horizontalLayout_5.setWidth("-1px");
		horizontalLayout_5.setHeight("-1px");
		horizontalLayout_5.setMargin(false);
		horizontalLayout_5.setSpacing(true);
		
		// cmbParticipacion
		cmbParticipacion = new ComboBoxLOVS();
		cmbParticipacion.setCaption("Participación");
		cmbParticipacion.setImmediate(false);
		cmbParticipacion.setWidth("-1px");
		cmbParticipacion.setHeight("-1px");
		horizontalLayout_5.addComponent(cmbParticipacion);
		
		// cmbEstadoParticipacion
		cmbEstadoParticipacion = new ComboBoxLOVS();
		cmbEstadoParticipacion.setCaption("Estado de la Participación");
		cmbEstadoParticipacion.setImmediate(false);
		cmbEstadoParticipacion.setWidth("-1px");
		cmbEstadoParticipacion.setHeight("-1px");
		horizontalLayout_5.addComponent(cmbEstadoParticipacion);
		
		return horizontalLayout_5;
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
		
		// btnGrabar
		btnGrabar = new Button();
		btnGrabar.setCaption("Grabar");
		btnGrabar.setImmediate(true);
		btnGrabar.setWidth("-1px");
		btnGrabar.setHeight("-1px");
		horizontalLayout_4.addComponent(btnGrabar);
		horizontalLayout_4.setComponentAlignment(btnGrabar, new Alignment(20));
		
		return horizontalLayout_4;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_6() {
		// common part: create layout
		horizontalLayout_6 = new HorizontalLayout();
		horizontalLayout_6.setImmediate(false);
		horizontalLayout_6.setWidth("-1px");
		horizontalLayout_6.setHeight("-1px");
		horizontalLayout_6.setMargin(false);
		
		// tblDetalleImplicados
		tblDetalleImplicados = new Table();
		tblDetalleImplicados.setImmediate(false);
		tblDetalleImplicados.setWidth("450px");
		tblDetalleImplicados.setHeight("200px");
		horizontalLayout_6.addComponent(tblDetalleImplicados);
		
		return horizontalLayout_6;
	}
}
