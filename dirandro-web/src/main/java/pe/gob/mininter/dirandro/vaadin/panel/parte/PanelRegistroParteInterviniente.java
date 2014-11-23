package pe.gob.mininter.dirandro.vaadin.panel.parte;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.DetExpedientePersona;
import pe.gob.mininter.dirandro.model.Empresa;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.Letrado;
import pe.gob.mininter.dirandro.model.Organizacion;
import pe.gob.mininter.dirandro.model.Persona;
import pe.gob.mininter.dirandro.model.Policia;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.EmpresaService;
import pe.gob.mininter.dirandro.service.ExpedientePersonaService;
import pe.gob.mininter.dirandro.service.LetradoService;
import pe.gob.mininter.dirandro.service.OrganizacionService;
import pe.gob.mininter.dirandro.service.PersonaService;
import pe.gob.mininter.dirandro.service.PoliciaService;
import pe.gob.mininter.dirandro.util.BeanValidar;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;
import pe.gob.mininter.dirandro.vaadin.dialogs.AlertDialog;
import pe.gob.mininter.dirandro.vaadin.panel.PanelAbogadoPersona;
import pe.gob.mininter.dirandro.vaadin.panel.PanelSituacionProceso;
import pe.gob.mininter.dirandro.vaadin.panel.util.PanelAgregarEmpresa;
import pe.gob.mininter.dirandro.vaadin.panel.util.PanelAgregarPersona;
import pe.gob.mininter.dirandro.vaadin.util.ComboBoxLOVS;
import pe.gob.mininter.dirandro.vaadin.util.Injector;
import pe.gob.mininter.dirandro.vaadin.util.listener.PanelAgregarEmpresaListener;
import pe.gob.mininter.dirandro.vaadin.util.listener.PanelAgregarPersonaListener;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class PanelRegistroParteInterviniente extends CustomComponent implements ClickListener, PanelAgregarPersonaListener, PanelAgregarEmpresaListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout verticalLayout_3;
	@AutoGenerated
	private Table tblIntervinientes;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_34;
	@AutoGenerated
	private Button btnRIAgregar;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private CheckBox chkRequisitoria;
	@AutoGenerated
	private TextField txtInterAlias;
	@AutoGenerated
	private ComboBoxLOVS cmbInterSituacion;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_32;
	@AutoGenerated
	private PopupDateField dtInterFechaInter;
	@AutoGenerated
	private ComboBoxLOVS cmbInterOcupacion;
	@AutoGenerated
	private ComboBox cmbInterOrganizacion;
	@AutoGenerated
	private ComboBoxLOVS cmbInterEstadoDato;
	@AutoGenerated
	private HorizontalLayout lytDatos;
	@AutoGenerated
	private Label lblDatosInterviniente;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_3;
	@AutoGenerated
	private ComboBoxLOVS cmbParticipacion;
	@AutoGenerated
	private Button btnRIBuscar;
	@AutoGenerated
	private ComboBox cmbIntervinientes;
	@AutoGenerated
	private ComboBoxLOVS cmbTipoParticipacion;
	private static final long serialVersionUID = 5321154660254559464L;

	private static final Logger logger = Logger.getLogger(PanelRegistroParteInterviniente.class);
	private PersonaService personaService;
	private EmpresaService empresaService;
	private PoliciaService policiaService;
	private LetradoService letradoService;
	private ExpedientePersonaService expedientePersonaService;
	private OrganizacionService organizacionService;

	private Expediente expediente;
	private List<Empresa> lstEmpresas;
	private List<Persona> lstPersonas;
	private List<Policia> lstPolicias;
	private List<Letrado> lstLetrados;

	private static final String OPCION_PERSONA = "PER_PERSONA";
	private static final String OPCION_POLICIA = "PER_POLICIA";
	private static final String OPCION_LETRADO = "PER_LETRADO";
	private static final String OPCION_EMPRESA = "PER_EMPRESA";

	private String listaSeleccionada = OPCION_PERSONA;
	private boolean inicializado=false;
	private IndexedContainer container;

	private DetExpedientePersona detExpedientePersona;
	
	private static final String COLUMN_TABLA_INTERVINIENTE = "COLUMN_TABLA_INTERVINIENTE";
	private static final String COLUMN_TIPO_INTERVINIENTE = "COLUMN_TIPO_INTERVINIENTE";
	private static final String COLUMN_PARTICIPACION = "COLUMN_PARTICIPACION";
	private static final String COLUMN_INTERVINIENTE = "COLUMN_INTERVINIENTE";
	private static final String COLUMN_ID_INTERVINIENTE = "COLUMN_ID_INTERVINIENTE";
	private static final String COLUMN_ESTADO_DATO = "COLUMN_ESTADO_DATO";
	private static final String COLUMN_ORGANIZACION = "COLUMN_ORGANIZACION";
	private static final String COLUMN_OCUPACION = "COLUMN_OCUPACION";
	private static final String COLUMN_FECHA_INTERVENCION = "COLUMN_FECHA_INTERVENCION";
	private static final String COLUMN_SITUACION = "COLUMN_SITUACION";
	private static final String COLUMN_ALIAS = "COLUMN_ALIAS";
	private static final String COLUMN_EXP_INTERVINIENTE = "COLUMN_EXP_INTERVINIENTE";
	private static final String COLUMN_ABOGADOS = "COLUMN_ABOGADOS";
	private static final String COLUMN_PROCESO = "COLUMN_PROCESO";

	public PanelRegistroParteInterviniente() {
		buildMainLayout();

		personaService = Injector.obtenerServicio(PersonaService.class);
		empresaService = Injector.obtenerServicio(EmpresaService.class);
		organizacionService = Injector.obtenerServicio(OrganizacionService.class);
		expedientePersonaService = Injector.obtenerServicio(ExpedientePersonaService.class);
		policiaService = Injector.obtenerServicio(PoliciaService.class);
		letradoService  = Injector.obtenerServicio(LetradoService.class);
		
		setCompositionRoot(mainLayout);
		postConstruct();
	}

	@Override
	public void attach() {
		super.attach();
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
		postConstruct();
	}

	public void postConstruct() {
		if(expediente!=null && !expediente.esNuevo() && !inicializado){
			limpiarTodo();
			dtInterFechaInter.setInputPrompt("Fecha de la Intervencion");
			cmbInterEstadoDato.setCodigoLista(Constante.LISTA.CODIGO.TIPO_EST_DATO);
			cmbInterEstadoDato.setInputPrompt("Estado del Dato");
			cmbInterEstadoDato.setRequired(true);
			cmbInterEstadoDato.attach();
			cmbInterOcupacion.setCodigoLista(Constante.LISTA.CODIGO.OCUP_INTERV);
			cmbInterOcupacion.setInputPrompt("Ocupación");
			cmbInterOcupacion.attach();
			cmbInterSituacion.setCodigoLista(Constante.LISTA.CODIGO.SIT_PROCESADO);
			cmbInterSituacion.setInputPrompt("Situación");
			cmbInterSituacion.setRequired(true);
			cmbInterSituacion.attach();
			
			cmbParticipacion.setCodigoLista(Constante.LISTA.CODIGO.PARTICIPA_INT);
			cmbParticipacion.setInputPrompt("Tipo de Participación");
			cmbParticipacion.setRequired(true);
			cmbParticipacion.attach();
			

			cmbTipoParticipacion.setInputPrompt("Tipo de Participante");
			cmbTipoParticipacion.setCodigoLista(Constante.LISTA.CODIGO.TIPO_PARTICIPAC);
			cmbTipoParticipacion.setRequired(true);
			cmbTipoParticipacion.attach();
			cmbTipoParticipacion.setImmediate(true);
			cmbTipoParticipacion.addListener(new ValueChangeListener() {
				
				private static final long serialVersionUID = 4944319484424744679L;

				@Override
				public void valueChange(ValueChangeEvent event) {
					tipoIntervinienteValueChange(event);
				} 
				
			});
			cargarCmbInterOrganizacion();
	
			btnRIBuscar.setIcon(Constante.ICONOS.CREATE);
			btnRIBuscar.addListener((ClickListener) this);
			btnRIAgregar.addListener((ClickListener) this);
		
			cmbIntervinientes.setInputPrompt("Incautado a:");
			cmbIntervinientes.setItemCaptionPropertyId("nombreCompleto");
			cmbIntervinientes.setImmediate(true);
			cargaComboPersonaIncautada(OPCION_PERSONA);	
			cmbIntervinientes.addListener(new ValueChangeListener() {
				private static final long serialVersionUID = 2720977948538256976L;
	
				@Override
				public void valueChange(ValueChangeEvent event) {
					cmbIntervinientesValueChange(event);
				}
	
			});

			tblIntervinientes.setSelectable(true);
			tblIntervinientes.setImmediate(true);
			tblIntervinientes.setNullSelectionAllowed(true);
			tblIntervinientes.setNullSelectionItemId(null);
			tblIntervinientes.addListener(new ValueChangeListener() {
				
				private static final long serialVersionUID = 4944319484424744679L;

				@Override
				public void valueChange(ValueChangeEvent event) {
					boolean esModoNuevo = tblIntervinientes.getValue() == null;
					limpiarTodo();
					habilitarEdicion(!esModoNuevo);
					if(esModoNuevo){
						tblIntervinientes.setValue(null);
					}else{
						Item item = tblIntervinientes.getItem(tblIntervinientes.getValue());
						
						DetExpedientePersona detalle = (DetExpedientePersona)item.getItemProperty(COLUMN_EXP_INTERVINIENTE).getValue(); 
						detExpedientePersona.setId(detalle.getId());
						txtInterAlias.setValue(HarecUtil.nullToEmpty(detalle.getAlias()));
						cmbInterSituacion.select(detalle.getSituacion());
						dtInterFechaInter.setValue(detalle.getIntervencion());
						cmbInterOcupacion.setValue(detalle.getOcupacion());
						cmbInterOrganizacion.setValue(detalle.getOrganizacion());
						
						cmbInterEstadoDato.setValue(detalle.getEstadoDato());
						cmbTipoParticipacion.setValue(detalle.getTipoParticipacion());
						cmbParticipacion.setValue(detalle.getParticipacion());
						logger.debug("requisioriado" + detalle.getRequisitoria());
						if(detalle.getRequisitoria()!=null){
							chkRequisitoria.setValue(detalle.getRequisitoria().intValue()>0?true:false);
						}else{
							chkRequisitoria.setValue(false);	
						}
						String tabla = item.getItemProperty(COLUMN_TABLA_INTERVINIENTE).getValue().toString();
						logger.debug("es de la tabla " + tabla);
						if(tabla.equals(OPCION_EMPRESA)){
							cmbIntervinientes.setValue(detalle.getEmpresaInvolucrada());
						}
						if(tabla.equals(OPCION_POLICIA)){
							cmbIntervinientes.setValue(detalle.getPolicia());
						}
						if(tabla.equals(OPCION_PERSONA)){
							cmbIntervinientes.setValue(detalle.getInvolucrado());
						}
						if(tabla.equals(OPCION_LETRADO)){
							cmbIntervinientes.setValue(detalle.getLetrado());
						}
					}		
				}
			});
	
			containerTabla();
			cargarIntervinientes();
			inicializado=true;
			lblDatosInterviniente.setValue(StringUtils.EMPTY);
		}
	}

	
	private void cargarCmbInterOrganizacion() {
		List<Organizacion> organizaciones = organizacionService.buscar(null);
		BeanItemContainer<Organizacion> containerOrganizacion = new BeanItemContainer<Organizacion>(
		Organizacion.class, organizaciones);
		cmbInterOrganizacion.setContainerDataSource(containerOrganizacion);
		cmbInterOrganizacion.setInputPrompt("Organizacion Delictiva");
		cmbInterOrganizacion.setItemCaptionPropertyId("nombre");

	}

	private void containerTabla() {
		this.container = new IndexedContainer();

		container.addContainerProperty(COLUMN_TIPO_INTERVINIENTE, String.class,null);
		container.addContainerProperty(COLUMN_TABLA_INTERVINIENTE, String.class,null);
		container.addContainerProperty(COLUMN_PARTICIPACION, String.class,null);
		container.addContainerProperty(COLUMN_INTERVINIENTE, String.class, null);
		container.addContainerProperty(COLUMN_ID_INTERVINIENTE, Long.class, null);
		container.addContainerProperty(COLUMN_ESTADO_DATO, String.class, null);
		container.addContainerProperty(COLUMN_ORGANIZACION, String.class, null);
		container.addContainerProperty(COLUMN_OCUPACION, String.class, null);
		container.addContainerProperty(COLUMN_FECHA_INTERVENCION, String.class, null);
		container.addContainerProperty(COLUMN_SITUACION, String.class, null);
		container.addContainerProperty(COLUMN_ALIAS, String.class, null);
		container.addContainerProperty(COLUMN_EXP_INTERVINIENTE, DetExpedientePersona.class, null);
		container.addContainerProperty(COLUMN_ABOGADOS, Button.class, null);
		container.addContainerProperty(COLUMN_PROCESO, Button.class, null);
		
		tblIntervinientes.setContainerDataSource(container);

		tblIntervinientes.setColumnHeader(COLUMN_TIPO_INTERVINIENTE, "Tipo Participante");
		tblIntervinientes.setColumnHeader(COLUMN_PARTICIPACION, "Participación");
		tblIntervinientes.setColumnHeader(COLUMN_INTERVINIENTE, "Interviniente");
		tblIntervinientes.setColumnHeader(COLUMN_ESTADO_DATO, "Est. Dato");
		tblIntervinientes.setColumnHeader(COLUMN_ORGANIZACION, "Organización");
		tblIntervinientes.setColumnHeader(COLUMN_OCUPACION, "Ocupación");
		tblIntervinientes.setColumnHeader(COLUMN_FECHA_INTERVENCION, "Fecha Int.");
		tblIntervinientes.setColumnHeader(COLUMN_SITUACION, "Siguación"); 
		tblIntervinientes.setColumnHeader(COLUMN_ALIAS, "Alias");
		tblIntervinientes.setColumnHeader(COLUMN_ABOGADOS, "");
		tblIntervinientes.setColumnHeader(COLUMN_PROCESO, "");

		tblIntervinientes.setVisibleColumns(new Object[] {
				COLUMN_TIPO_INTERVINIENTE,COLUMN_PARTICIPACION, COLUMN_INTERVINIENTE,
				COLUMN_ESTADO_DATO, COLUMN_ORGANIZACION, COLUMN_OCUPACION,
				COLUMN_FECHA_INTERVENCION, COLUMN_SITUACION, COLUMN_ALIAS, 
				COLUMN_ABOGADOS, COLUMN_PROCESO});

		tblIntervinientes.setColumnWidth(COLUMN_TIPO_INTERVINIENTE, 100);
		tblIntervinientes.setColumnWidth(COLUMN_PARTICIPACION, 100);
		tblIntervinientes.setColumnWidth(COLUMN_INTERVINIENTE, 140);
		tblIntervinientes.setColumnWidth(COLUMN_ESTADO_DATO, 90);
		tblIntervinientes.setColumnWidth(COLUMN_ORGANIZACION, 90);
		tblIntervinientes.setColumnWidth(COLUMN_OCUPACION, 90);
		tblIntervinientes.setColumnWidth(COLUMN_FECHA_INTERVENCION, 70);
		tblIntervinientes.setColumnWidth(COLUMN_SITUACION, 100);
		tblIntervinientes.setColumnWidth(COLUMN_ALIAS, 80);
		tblIntervinientes.setColumnWidth(COLUMN_ABOGADOS, 70);
		tblIntervinientes.setColumnWidth(COLUMN_PROCESO, 70);
	}

	public void cargarIntervinientes() {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		container.removeAllItems();

		List<DetExpedientePersona> intervinientes = expedientePersonaService.cargarIntervinientes(expediente);
		for (final DetExpedientePersona interviniente : intervinientes) {
			Item item = container.addItem(interviniente.getId());
			String tabla = HarecUtil.valorCodigoToEmpty(interviniente.getTipoParticipacion());
			logger.debug("setear objeto de participante: "+tabla+" "+interviniente.getCodigoParticipante());
			if(tabla.equals(OPCION_EMPRESA)){
				interviniente.setEmpresaInvolucrada(empresaService.obtener(interviniente.getCodigoParticipante()));
			}
			if(tabla.equals(OPCION_POLICIA)){
				interviniente.setPolicia(policiaService.obtener(interviniente.getCodigoParticipante()));
			}
			if(tabla.equals(OPCION_PERSONA)){
				interviniente.setInvolucrado(personaService.obtener(interviniente.getCodigoParticipante()));
			}
			if(tabla.equals(OPCION_LETRADO)){
				interviniente.setLetrado(letradoService.obtener(interviniente.getCodigoParticipante()));
			}
			item.getItemProperty(COLUMN_TIPO_INTERVINIENTE).setValue(HarecUtil.valorNombreToEmpty(interviniente.getTipoParticipacion()));
			item.getItemProperty(COLUMN_TABLA_INTERVINIENTE).setValue(HarecUtil.valorCodigoToEmpty(interviniente.getTipoParticipacion()));
			item.getItemProperty(COLUMN_PARTICIPACION).setValue(HarecUtil.valorNombreToEmpty(interviniente.getParticipacion()));
			item.getItemProperty(COLUMN_INTERVINIENTE).setValue(interviniente.getNombreCompleto());
			item.getItemProperty(COLUMN_ID_INTERVINIENTE).setValue(interviniente.getCodigoParticipante());
			item.getItemProperty(COLUMN_ESTADO_DATO).setValue(interviniente.getEstadoDato() != null ? interviniente.getEstadoDato().getNombre() : StringUtils.EMPTY);
			item.getItemProperty(COLUMN_ORGANIZACION).setValue(interviniente.getOrganizacion() != null ? interviniente.getOrganizacion().getNombre() : StringUtils.EMPTY);
			item.getItemProperty(COLUMN_OCUPACION).setValue(interviniente.getOcupacion() != null ? interviniente.getOcupacion().getNombre() : StringUtils.EMPTY);
			item.getItemProperty(COLUMN_FECHA_INTERVENCION).setValue(interviniente.getIntervencion() != null ? df.format(interviniente.getIntervencion()) : StringUtils.EMPTY);
			item.getItemProperty(COLUMN_SITUACION).setValue(interviniente.getSituacion() != null ? interviniente.getSituacion().getNombre() : StringUtils.EMPTY);
			item.getItemProperty(COLUMN_ALIAS).setValue(interviniente.getAlias());
			item.getItemProperty(COLUMN_EXP_INTERVINIENTE).setValue(interviniente);
			Button abogado=new Button();
			abogado.setCaption("Abogados");
			abogado.addListener(new ClickListener() {
				private static final long serialVersionUID = -2810346866475578492L;

				@Override
				public void buttonClick(ClickEvent event) {
					PanelAbogadoPersona panelAbogadoPersona=new PanelAbogadoPersona(interviniente);
					Window wdAbogado = new Window();
					
					wdAbogado.setModal(true);
					wdAbogado.setResizable(false);
					wdAbogado.addComponent(panelAbogadoPersona);
						
					wdAbogado.setCaption("Abogados");
					wdAbogado.setWidth("500px");
					getApplication().getMainWindow().getWindow().addWindow(wdAbogado);
				}
			});
			item.getItemProperty(COLUMN_ABOGADOS).setValue(abogado);
			Button proceso=new Button();
			proceso.setCaption("Proceso");
			proceso.addListener(new ClickListener() {
				private static final long serialVersionUID = -2810346866475578492L;

				@Override
				public void buttonClick(ClickEvent event) {
					PanelSituacionProceso panelSituacionProceso=
							new PanelSituacionProceso(interviniente);
					Window wdProceso = new Window();
					
					wdProceso.setModal(true);
					wdProceso.setResizable(false);
					wdProceso.addComponent(panelSituacionProceso);
						
					wdProceso.setCaption("Proceso");
					wdProceso.setWidth("880px");
					getApplication().getMainWindow().getWindow().addWindow(wdProceso);
				}
			});
			item.getItemProperty(COLUMN_PROCESO).setValue(proceso);
		}
	}

	private void cargarWindowPersona() {

		PanelAgregarPersona pnlAgregarPersona = new PanelAgregarPersona();
		pnlAgregarPersona
				.setPanelAgregarPersonaReponder((PanelAgregarPersonaListener) this);

		final Window window = new Window() {

			private static final long serialVersionUID = 1L;

			protected void close() {
				getApplication().getMainWindow().removeWindow(getWindow());
			}
		};

		window.setCaption("Registrar Persona");
		window.addComponent(pnlAgregarPersona);
		window.setModal(true);
		window.setResizable(false);
		window.setWidth("650px");
		window.setHeight("-1.0");
		getApplication().getMainWindow().addWindow(window);

	}

	private void cargarWindowEmpresa() {
		PanelAgregarEmpresa panelAgregarEmpresa = new PanelAgregarEmpresa();
		panelAgregarEmpresa
				.setPanelAgregarEmpresaListener((PanelAgregarEmpresaListener) this);

		final Window window = new Window() {

			private static final long serialVersionUID = 1L;

			protected void close() {
				getApplication().getMainWindow().removeWindow(getWindow());
			}
		};

		window.setCaption("Registrar Persona");
		window.addComponent(panelAgregarEmpresa);
		window.setModal(true);
		window.setResizable(false);
		window.setWidth("650px");
		window.setHeight("-1.0");
		getApplication().getMainWindow().addWindow(window);
	}

	private void cmbIntervinientesValueChange(ValueChangeEvent event) {
		limpiarPersonaEmpresa();
		if (event.getProperty().getValue() != null) {
				
			if (cmbTipoParticipacion.getValor().getCodigo().equals(OPCION_PERSONA)) {
				imprimir((Persona) event.getProperty().getValue());
				return;
			} 
			if (cmbTipoParticipacion.getValor().getCodigo().equals(OPCION_EMPRESA)) {
				imprimir((Empresa) event.getProperty().getValue());
				return;
			}
			if (cmbTipoParticipacion.getValor().getCodigo().equals(OPCION_POLICIA)) {
				imprimir((Policia) event.getProperty().getValue());
				return;
			}
			if (cmbTipoParticipacion.getValor().getCodigo().equals(OPCION_LETRADO)) {
				imprimir((Letrado) event.getProperty().getValue());
				return;
			}
		}
	}

	private void tipoIntervinienteValueChange(ValueChangeEvent event) {
		Valor sel = (Valor)event.getProperty().getValue();
		cmbIntervinientes.select(null);
		if(sel!=null){
			cargaComboPersonaIncautada(sel.getCodigo());
		}	
		limpiarPersonaEmpresa();
	}

	private void cargaComboPersonaIncautada(String opcion) {
		if (opcion.equals(OPCION_PERSONA)) {
			listaSeleccionada = OPCION_PERSONA;
			if (lstPersonas == null)
				lstPersonas = personaService.buscar(null);
			cmbIntervinientes.setItemCaptionPropertyId("nombreCompleto");
			cmbIntervinientes.setContainerDataSource(new BeanItemContainer<Persona>(Persona.class, lstPersonas));
			return;
		} 
		if (opcion.equals(OPCION_EMPRESA)) {
			listaSeleccionada = OPCION_EMPRESA;
			cmbIntervinientes.setItemCaptionPropertyId("razonSocial");
			if (lstEmpresas == null)
				lstEmpresas = empresaService.buscar(null);
			cmbIntervinientes.setContainerDataSource(new BeanItemContainer<Empresa>(Empresa.class, lstEmpresas));
			return;
		}else{
			//TODO ocultar controles  y pre selecccionar los combos por que para policias y letados no aplica esto
			//cmbInterSituacion.select( new Valor() );
			//cmbInterEstadoDato.select( new Valor() );
			
			if (opcion.equals(OPCION_POLICIA)) {
				listaSeleccionada = OPCION_POLICIA;
				cmbIntervinientes.setItemCaptionPropertyId("nombreCompleto");
				if (lstPolicias == null)
					lstPolicias = policiaService.buscar(null);
				cmbIntervinientes.setContainerDataSource(new BeanItemContainer<Policia>(Policia.class, lstPolicias));
				return;
			}
			if (opcion.equals(OPCION_LETRADO)) {
				listaSeleccionada = OPCION_LETRADO;
				cmbIntervinientes.setItemCaptionPropertyId("nombreCompleto");
				if (lstLetrados == null)
					lstLetrados = letradoService.buscar(null);
				cmbIntervinientes.setContainerDataSource(new BeanItemContainer<Letrado>(Letrado.class, lstLetrados));
				return;
			}
		}
		
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if (event.getButton().equals(btnRIBuscar)) {

			if (cmbTipoParticipacion.getValor().getCodigo().equals(OPCION_PERSONA)) {
				cargarWindowPersona();
			} else {
				cargarWindowEmpresa();
			}

		} else if (event.getButton().equals(btnRIAgregar)) {
			buttonClickBtnRIAgregar();
		}

	}

	private void buttonClickBtnRIAgregar() {
		
		detExpedientePersona.setExpediente(expediente);
		detExpedientePersona.setAlias((String) txtInterAlias.getValue());
		logger.debug(" requisitoria " +  chkRequisitoria.getValue() + " " +  ((Boolean)chkRequisitoria.getValue()?1:0 ) );
		detExpedientePersona.setRequisitoria(new BigDecimal((Boolean)chkRequisitoria.getValue()?1:0 ));
		
		detExpedientePersona.setTipoParticipacion(cmbTipoParticipacion.getValor());
		detExpedientePersona.setParticipacion(cmbParticipacion.getValor());
		
		detExpedientePersona.setEstadoDato(cmbInterEstadoDato.getValor());
		detExpedientePersona.setOrganizacion((Organizacion) cmbInterOrganizacion.getValue());
		detExpedientePersona.setOcupacion(cmbInterOcupacion.getValor());
		detExpedientePersona.setSituacion(cmbInterSituacion.getValor());
		detExpedientePersona.setIntervencion((Date) dtInterFechaInter.getValue());
		
		
		Long idParticipante = null;
		if(cmbTipoParticipacion.getValor()!=null && cmbIntervinientes.getValue()!=null ){
			if (cmbTipoParticipacion.getValor().getCodigo().equals(OPCION_PERSONA)) {
				idParticipante = ((Persona) cmbIntervinientes.getValue()).getId();
			} 
			if (cmbTipoParticipacion.getValor().getCodigo().equals(OPCION_POLICIA)) {
				idParticipante =((Policia) cmbIntervinientes.getValue()).getId();
			}
			if (cmbTipoParticipacion.getValor().getCodigo().equals(OPCION_EMPRESA)) {
				idParticipante =((Empresa) cmbIntervinientes.getValue()).getId();
			}
			if (cmbTipoParticipacion.getValor().getCodigo().equals(OPCION_LETRADO)) {
				idParticipante =((Letrado) cmbIntervinientes.getValue()).getId();
			}
			detExpedientePersona.setCodigoParticipante(idParticipante);	
		}
		
		   HarecUtil.validar(getWindow(), detExpedientePersona, new BeanValidar[]{
				new BeanValidar("tipoParticipacion", new Object[]{"Tipo de Participante"}, cmbTipoParticipacion),
				new BeanValidar("codigoParticipante", new Object[]{"Participante"}, cmbIntervinientes),
				new BeanValidar("participacion", new Object[]{"Participación"}, cmbParticipacion),
				new BeanValidar("estadoDato", new Object[]{"Estado del dato"}, cmbInterEstadoDato),
            new BeanValidar("situacion", new Object[]{"Situacion"}, cmbInterSituacion)});
		
        AlertDialog alertDialog = null;
        if(detExpedientePersona.esNuevo()){
        	expedientePersonaService.crear(detExpedientePersona);	
        	alertDialog = new  AlertDialog("Registro de Persona", "Se ha registrado a la persona correctamente", "Aceptar", "400");
        }else{
        	expedientePersonaService.actualizar(detExpedientePersona);
        	alertDialog = new  AlertDialog("Registro de Persona", "Se ha actualizado a la persona correctamente", "Aceptar", "400");
        }
		getApplication().getMainWindow().addWindow(alertDialog);
		
		cargarIntervinientes();
		limpiarTodo();

	}

	private void habilitarEdicion(boolean flag) {
		if(flag){
			btnRIAgregar.setCaption("Actualizar Interviniente");
		}else{
			btnRIAgregar.setCaption("Agregar Interviniente");
		}
	}
	
	private void limpiarPersonaEmpresa() {
		lytDatos.setVisible(false);
		lblDatosInterviniente.setVisible(false);
		lblDatosInterviniente.setValue("");
	}

	private void limpiarTodo() {
		habilitarEdicion(false);
		detExpedientePersona = new DetExpedientePersona();
		lstPersonas = personaService.buscar(null);
		cargaComboPersonaIncautada(OPCION_PERSONA);
		cmbInterEstadoDato.select(null);
		cmbInterOcupacion.select(null);
		cmbInterOrganizacion.select(null);
		cmbInterSituacion.select(null);
		txtInterAlias.setValue(StringUtils.EMPTY);
		dtInterFechaInter.setValue(null);
		chkRequisitoria.setValue(false);
		cmbParticipacion.select(null);
		cmbTipoParticipacion.select(null);
	}

	@Override
	public void setPersonaPopUp(Persona persona) {

		lstPersonas = personaService.buscar(null);
	//	rbTipoInterviniente.select(OPCION_PERSONA);
		cargaComboPersonaIncautada(OPCION_PERSONA);

		cmbIntervinientes.select(persona);
		imprimir(persona);
	}

	
	@Override
	public void setEmpresaPopUp(Empresa empresa) {
		lstEmpresas = empresaService.buscar(null);
	//	rbTipoInterviniente.select(OPCION_EMPRESA);
		cargaComboPersonaIncautada(OPCION_EMPRESA);

		cmbIntervinientes.select(empresa);
		imprimir(empresa);
	}

	private void imprimir(Persona persona) {
		String plantilla = "<p><b>Tipo y Número de Documento:</b> {0} {1} <b>Nombres Completos:</b> {2} <b>Nacionalidad:</b> {3} <b>Sexo:</b> {4}</p>";

		lytDatos.setVisible(true);
		String html = MessageFormat.format(plantilla, persona
				.getTipoDocumento().getNombre(),
				persona.getNroDocumento(),
				persona.getNombreCompleto(),
				persona.getNacionalidad().getNombre(),
				persona.getSexo());

		lytDatos.setVisible(true);
		lblDatosInterviniente.setVisible(true);
		lblDatosInterviniente.setValue(html);

	}
	
	private void imprimir(Empresa empresa) {

		String plantilla = "<p><b>Ruc:</b> {0} <b>Razón Social:</b> {1} <b>Partida:</b> {2} <b>Teléfono:</b> {3}</p>";

		lytDatos.setVisible(true);
		String html = MessageFormat.format(plantilla, empresa.getRuc(), // 0
				empresa.getRazonSocial(), // 1
				empresa.getPartidaRegistral(), // 2
				empresa.getTelefono());// 4

		lytDatos.setVisible(true);
		lblDatosInterviniente.setVisible(true);
		lblDatosInterviniente.setValue(html);
	}
	
	private void imprimir(Policia policia) {
		String plantilla = "<p><b>Tipo y Número de Documento:</b> {0} {1} <b>Nombres Completos:</b> {2} <b>Nacionalidad:</b> {3} <b>Sexo:</b> {4}</p>";

		Persona persona = policia.getPersona();
		lytDatos.setVisible(true);
		String html = MessageFormat.format(plantilla, persona
				.getTipoDocumento().getNombre(),
				persona.getNroDocumento(),
				persona.getNombreCompleto(),
				persona.getNacionalidad().getNombre(),
				persona.getSexo());

		lytDatos.setVisible(true);
		lblDatosInterviniente.setVisible(true);
		lblDatosInterviniente.setValue(html);

	}
	
	private void imprimir(Letrado letrado) {
		String plantilla = "<p><b>Tipo y Número de Documento:</b> {0} {1} <b>Nombres Completos:</b> {2} <b>Nacionalidad:</b> {3} <b>Sexo:</b> {4}</p>";

		Persona persona = letrado.getPersona();
		
		lytDatos.setVisible(true);
		String html = MessageFormat.format(plantilla, persona
				.getTipoDocumento().getNombre(),
				persona.getNroDocumento(),
				persona.getNombreCompleto(),
				persona.getNacionalidad().getNombre(),
				persona.getSexo());

		lytDatos.setVisible(true);
		lblDatosInterviniente.setVisible(true);
		lblDatosInterviniente.setValue(html);

	}
	
	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("-1px");
		
		// verticalLayout_3
		verticalLayout_3 = buildVerticalLayout_3();
		mainLayout.addComponent(verticalLayout_3);
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_3() {
		// common part: create layout
		verticalLayout_3 = new VerticalLayout();
		verticalLayout_3.setImmediate(false);
		verticalLayout_3.setWidth("-1px");
		verticalLayout_3.setHeight("-1px");
		verticalLayout_3.setMargin(true);
		verticalLayout_3.setSpacing(true);
		
		// horizontalLayout_3
		horizontalLayout_3 = buildHorizontalLayout_3();
		verticalLayout_3.addComponent(horizontalLayout_3);
		
		// lytDatos
		lytDatos = buildLytDatos();
		verticalLayout_3.addComponent(lytDatos);
		
		// horizontalLayout_32
		horizontalLayout_32 = buildHorizontalLayout_32();
		verticalLayout_3.addComponent(horizontalLayout_32);
		
		// horizontalLayout_34
		horizontalLayout_34 = buildHorizontalLayout_34();
		verticalLayout_3.addComponent(horizontalLayout_34);
		
		// tblIntervinientes
		tblIntervinientes = new Table();
		tblIntervinientes.setImmediate(false);
		tblIntervinientes.setWidth("900px");
		tblIntervinientes.setHeight("350px");
		verticalLayout_3.addComponent(tblIntervinientes);
		
		return verticalLayout_3;
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
		
		// cmbTipoParticipacion
		cmbTipoParticipacion = new ComboBoxLOVS();
		cmbTipoParticipacion.setCaption("Tipo de Participante");
		cmbTipoParticipacion.setImmediate(false);
		cmbTipoParticipacion.setDescription("Tipo de Participante");
		cmbTipoParticipacion.setWidth("-1px");
		cmbTipoParticipacion.setHeight("-1px");
		horizontalLayout_3.addComponent(cmbTipoParticipacion);
		
		// cmbIntervinientes
		cmbIntervinientes = new ComboBox();
		cmbIntervinientes.setCaption("Interviniente");
		cmbIntervinientes.setImmediate(false);
		cmbIntervinientes.setWidth("350px");
		cmbIntervinientes.setHeight("-1px");
		cmbIntervinientes.setRequired(true);
		horizontalLayout_3.addComponent(cmbIntervinientes);
		
		// btnRIBuscar
		btnRIBuscar = new Button();
		btnRIBuscar.setCaption(" ");
		btnRIBuscar.setImmediate(true);
		btnRIBuscar.setWidth("-1px");
		btnRIBuscar.setHeight("-1px");
		horizontalLayout_3.addComponent(btnRIBuscar);
		horizontalLayout_3.setComponentAlignment(btnRIBuscar, new Alignment(9));
		
		// cmbParticipacion
		cmbParticipacion = new ComboBoxLOVS();
		cmbParticipacion.setCaption("Participación");
		cmbParticipacion.setImmediate(false);
		cmbParticipacion.setWidth("-1px");
		cmbParticipacion.setHeight("-1px");
		horizontalLayout_3.addComponent(cmbParticipacion);
		
		return horizontalLayout_3;
	}

	@AutoGenerated
	private HorizontalLayout buildLytDatos() {
		// common part: create layout
		lytDatos = new HorizontalLayout();
		lytDatos.setImmediate(false);
		lytDatos.setWidth("-1px");
		lytDatos.setHeight("-1px");
		lytDatos.setMargin(false);
		lytDatos.setSpacing(true);
		
		// lblDatosInterviniente
		lblDatosInterviniente = new Label();
		lblDatosInterviniente.setImmediate(false);
		lblDatosInterviniente.setWidth("100.0%");
		lblDatosInterviniente.setHeight("100.0%");
		lblDatosInterviniente.setValue("Label");
		lblDatosInterviniente.setContentMode(3);
		lytDatos.addComponent(lblDatosInterviniente);
		
		return lytDatos;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_32() {
		// common part: create layout
		horizontalLayout_32 = new HorizontalLayout();
		horizontalLayout_32.setImmediate(false);
		horizontalLayout_32.setWidth("-1px");
		horizontalLayout_32.setHeight("-1px");
		horizontalLayout_32.setMargin(false);
		horizontalLayout_32.setSpacing(true);
		
		// cmbInterEstadoDato
		cmbInterEstadoDato = new ComboBoxLOVS();
		cmbInterEstadoDato.setCaption("Estado del dato");
		cmbInterEstadoDato.setImmediate(false);
		cmbInterEstadoDato.setWidth("-1px");
		cmbInterEstadoDato.setHeight("-1px");
		horizontalLayout_32.addComponent(cmbInterEstadoDato);
		
		// cmbInterOrganizacion
		cmbInterOrganizacion = new ComboBox();
		cmbInterOrganizacion.setCaption("Organización");
		cmbInterOrganizacion.setImmediate(false);
		cmbInterOrganizacion.setWidth("-1px");
		cmbInterOrganizacion.setHeight("-1px");
		horizontalLayout_32.addComponent(cmbInterOrganizacion);
		
		// cmbInterOcupacion
		cmbInterOcupacion = new ComboBoxLOVS();
		cmbInterOcupacion.setCaption("Ocupación");
		cmbInterOcupacion.setImmediate(false);
		cmbInterOcupacion.setWidth("-1px");
		cmbInterOcupacion.setHeight("-1px");
		horizontalLayout_32.addComponent(cmbInterOcupacion);
		
		// dtInterFechaInter
		dtInterFechaInter = new PopupDateField();
		dtInterFechaInter.setCaption("Fecha Intervención");
		dtInterFechaInter.setImmediate(false);
		dtInterFechaInter.setWidth("150px");
		dtInterFechaInter.setHeight("-1px");
		dtInterFechaInter.setInvalidAllowed(false);
		dtInterFechaInter.setResolution(4);
		horizontalLayout_32.addComponent(dtInterFechaInter);
		
		return horizontalLayout_32;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_34() {
		// common part: create layout
		horizontalLayout_34 = new HorizontalLayout();
		horizontalLayout_34.setImmediate(false);
		horizontalLayout_34.setWidth("870px");
		horizontalLayout_34.setHeight("-1px");
		horizontalLayout_34.setMargin(false);
		horizontalLayout_34.setSpacing(true);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		horizontalLayout_34.addComponent(horizontalLayout_1);
		
		// btnRIAgregar
		btnRIAgregar = new Button();
		btnRIAgregar.setCaption("Agregar Interviniente");
		btnRIAgregar.setImmediate(true);
		btnRIAgregar.setWidth("-1px");
		btnRIAgregar.setHeight("-1px");
		horizontalLayout_34.addComponent(btnRIAgregar);
		horizontalLayout_34.setComponentAlignment(btnRIAgregar, new Alignment(
				10));
		
		return horizontalLayout_34;
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
		
		// cmbInterSituacion
		cmbInterSituacion = new ComboBoxLOVS();
		cmbInterSituacion.setCaption("Situación");
		cmbInterSituacion.setImmediate(false);
		cmbInterSituacion.setWidth("-1px");
		cmbInterSituacion.setHeight("-1px");
		horizontalLayout_1.addComponent(cmbInterSituacion);
		
		// txtInterAlias
		txtInterAlias = new TextField();
		txtInterAlias.setCaption("Alias");
		txtInterAlias.setImmediate(false);
		txtInterAlias.setWidth("-1px");
		txtInterAlias.setHeight("-1px");
		txtInterAlias.setInputPrompt("Alias del Implicado");
		horizontalLayout_1.addComponent(txtInterAlias);
		
		// chkRequisitoria
		chkRequisitoria = new CheckBox();
		chkRequisitoria.setCaption("Tiene Requisitoria");
		chkRequisitoria.setImmediate(false);
		chkRequisitoria.setWidth("-1px");
		chkRequisitoria.setHeight("-1px");
		horizontalLayout_1.addComponent(chkRequisitoria);
		horizontalLayout_1.setComponentAlignment(chkRequisitoria,
				new Alignment(33));
		
		return horizontalLayout_1;
	}

}
