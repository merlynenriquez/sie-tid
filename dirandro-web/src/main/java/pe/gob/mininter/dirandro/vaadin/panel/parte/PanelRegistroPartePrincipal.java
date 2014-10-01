package pe.gob.mininter.dirandro.vaadin.panel.parte;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.CentroPoblado;
import pe.gob.mininter.dirandro.model.Dependencia;
import pe.gob.mininter.dirandro.model.Distrito;
import pe.gob.mininter.dirandro.model.Documento;
import pe.gob.mininter.dirandro.model.Entidad;
import pe.gob.mininter.dirandro.model.Estado;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.Integrante;
import pe.gob.mininter.dirandro.model.Ruta;
import pe.gob.mininter.dirandro.model.TipoHecho;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.CentroPobladoService;
import pe.gob.mininter.dirandro.service.DependenciaService;
import pe.gob.mininter.dirandro.service.EntidadService;
import pe.gob.mininter.dirandro.service.EstadoService;
import pe.gob.mininter.dirandro.service.ExpedienteService;
import pe.gob.mininter.dirandro.service.IntegranteService;
import pe.gob.mininter.dirandro.service.TipoHechoService;
import pe.gob.mininter.dirandro.service.UbigeoService;
import pe.gob.mininter.dirandro.service.ValorService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;
import pe.gob.mininter.dirandro.vaadin.dialogs.AlertDialog;
import pe.gob.mininter.dirandro.vaadin.panel.documento.PanelDocumento;
import pe.gob.mininter.dirandro.vaadin.util.ComboBoxLOVS;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.AbstractSelect.Filtering;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PanelRegistroPartePrincipal extends CustomComponent implements  ClickListener {
	
	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;

	@AutoGenerated
	private VerticalLayout pnlPrincipal;

	@AutoGenerated
	private HorizontalLayout horizontalLayout_13;

	@AutoGenerated
	private Button btnLimpiar;

	@AutoGenerated
	private Button btnGrabar;

	@AutoGenerated
	private VerticalLayout verticalLayout_4;

	@AutoGenerated
	private VerticalLayout pnlHecho;

	@AutoGenerated
	private HorizontalLayout horizontalLayout_12;

	@AutoGenerated
	private ComboBox cmbInterviniente;

	@AutoGenerated
	private ComboBoxLOVS cmbTablaEntidad;

	@AutoGenerated
	private ComboBoxLOVS cmbCuenca;

	@AutoGenerated
	private HorizontalLayout horizontalLayout_10;

	@AutoGenerated
	private ComboBox cmbCentroPoblado;

	@AutoGenerated
	private ComboBox cmbJurisdiccion;

	@AutoGenerated
	private TextField txtReferencia;

	@AutoGenerated
	private HorizontalLayout horizontalLayout_8;

	@AutoGenerated
	private TextField txtDireccion;

	@AutoGenerated
	private ComboBoxLOVS cmbTipoDir;

	@AutoGenerated
	private ComboBox cmbLugarHecho;

	@AutoGenerated
	private HorizontalLayout horizontalLayout_7;

	@AutoGenerated
	private ComboBox cmbEstadoExp;

	@AutoGenerated
	private ComboBox cmbIntegrante;

	@AutoGenerated
	private HorizontalLayout horizontalLayout_5;

	@AutoGenerated
	private TextField txtDiasAtencionExp;

	@AutoGenerated
	private PopupDateField dtRegistroExp;

	@AutoGenerated
	private ComboBoxLOVS cmbFinalidad;

	@AutoGenerated
	private ComboBox cmbDependencia;

	@AutoGenerated
	private HorizontalLayout horizontalLayout_4;

	@AutoGenerated
	private ComboBox cmbHecho;

	@AutoGenerated
	private ComboBox cmbSubTipoHecho;

	@AutoGenerated
	private ComboBox cmbTipoHecho;

	@AutoGenerated
	private TextField txtNombreDelCaso;

	@AutoGenerated
	private TextArea txaDescripcion;

	@AutoGenerated
	private TextField txtAsuntoExp;

	@AutoGenerated
	private Label label_2;

	@AutoGenerated
	private PanelDocumento pnlDocumento;

	@AutoGenerated
	private Label label_1;

	@AutoGenerated
	private Label lblNroPartePolicial;

	/**
	 * 
	 */
	private static final long serialVersionUID = 5739776816223795834L;

	private CentroPobladoService centroPobladoService;
	private UbigeoService ubigeoService;
	private EntidadService entidadService;
	private EstadoService estadoService;
	private IntegranteService integranteService;
	private DependenciaService dependenciaService;
	private TipoHechoService tipoHechoService;
	private ExpedienteService expedienteService;
	private ValorService valorService;
	
	private Expediente expediente;
	private boolean inicializado=false;
	private List<TipoHecho> lstSubTipoHechos;
	private List<TipoHecho> lstHechos;
	private PanelRegistroParteDocumento pnlAgregarDocumento;
	private PanelRegistroParte pnlRegistroParte;
	
	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 */
	public PanelRegistroPartePrincipal() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		postConstruct();
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
		postConstruct();
		inicializado=true;
	}	

	public void postConstruct() {
		if( !inicializado){
			centroPobladoService = Injector.obtenerServicio(CentroPobladoService.class);
			ubigeoService = Injector.obtenerServicio(UbigeoService.class);
			entidadService = Injector.obtenerServicio(EntidadService.class);
			estadoService = Injector.obtenerServicio(EstadoService.class);
			integranteService = Injector.obtenerServicio(IntegranteService.class);
			dependenciaService = Injector.obtenerServicio(DependenciaService.class);
			tipoHechoService = Injector.obtenerServicio(TipoHechoService.class);
			expedienteService = Injector.obtenerServicio(ExpedienteService.class);
			valorService = Injector.obtenerServicio(ValorService.class);
			
			cmbFinalidad.setCodigoLista(Constante.LISTA.CODIGO.FINALIDAD);
			cmbTipoDir.setCodigoLista(Constante.LISTA.CODIGO.DIRECCION_TIPO);
			cmbCuenca.setCodigoLista(Constante.LISTA.CODIGO.CUENCA);
			cmbTablaEntidad.setCodigoLista(Constante.LISTA.CODIGO.TIPO_INTERVINIENTE);
			
			btnGrabar.addListener((ClickListener)this);
			btnLimpiar.addListener((ClickListener)this);
			
			cmbTipoHecho.setInputPrompt("Tipo del Hecho");
			cmbDependencia.setInputPrompt("Dependencia a Cargo");
			cmbFinalidad.setInputPrompt("Finalidad");
			cmbIntegrante.setInputPrompt("Instructor a Cargo");
			cmbEstadoExp.setInputPrompt("Estado del Expediente");
			cmbTipoDir.setInputPrompt("Tipo de Direccion");
			cmbJurisdiccion.setInputPrompt("Jurisdiccion Policial");
			cmbCentroPoblado.setInputPrompt("Centro Poblado");
			cmbCuenca.setInputPrompt("Cuenca");
			dtRegistroExp.setInputPrompt("Fecha del Registro");
			cmbSubTipoHecho.setInputPrompt("Tipo del Hecho");
			cmbHecho.setInputPrompt("Nombre del Hecho");
			
			cmbCentroPobladoCargar();
			cmbLugarHechoCargar();
			cmbJurisdiccionCargar();
			cmbEstadoExpCargar();
			cmbIntervinienteCargar();
			cmbDependenciaCargar();
			cmbTipoHechoCargar();
		}
	}
	
	private void cmbTipoHechoCargar() {
		List<TipoHecho> tipoHechos = tipoHechoService.buscarPadres();
		cmbTipoHecho.setContainerDataSource(new BeanItemContainer<TipoHecho>(TipoHecho.class,  tipoHechos));
		cmbTipoHecho.setItemCaptionPropertyId("nombre");
		cmbTipoHecho.setImmediate(true);
		cmbTipoHecho.addListener(new ValueChangeListener() {
			
			private static final long serialVersionUID = 2171696820534506487L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				lstSubTipoHechos = tipoHechoService.buscarHijos((TipoHecho) cmbTipoHecho.getValue());
				cmbSubTipoHecho.setContainerDataSource(new BeanItemContainer<TipoHecho>(TipoHecho.class,  lstSubTipoHechos));
				cmbSubTipoHecho.setItemCaptionPropertyId("nombre");
				cmbSubTipoHecho.addListener(new ValueChangeListener() {
					
					private static final long serialVersionUID = -76424440135408732L;

					@Override
					public void valueChange(ValueChangeEvent event) {
						lstHechos  = tipoHechoService.buscarHijos((TipoHecho) cmbSubTipoHecho.getValue());
						cmbHecho.setContainerDataSource(new BeanItemContainer<TipoHecho>(TipoHecho.class,  lstHechos));
						cmbHecho.setItemCaptionPropertyId("nombre");
					}
				});
			}
		});
	}

	private void cmbDependenciaCargar() {
		List<Dependencia> dependencias = dependenciaService.buscar(null);
		
		BeanItemContainer<Dependencia> containerDependencia = new BeanItemContainer<Dependencia>(Dependencia.class,  dependencias);
		cmbDependencia.setContainerDataSource(containerDependencia);
		cmbDependencia.setItemCaptionPropertyId("nombre");
		
	}

	private void cmbIntervinienteCargar() {
		List<Integrante> integrantes = integranteService.listarIntegrantes();
		
		BeanItemContainer<Integrante> containerIntegrante = new BeanItemContainer<Integrante>(Integrante.class,  integrantes);
		cmbInterviniente.setContainerDataSource(containerIntegrante);
		cmbInterviniente.setItemCaptionPropertyId("nombreCompletoIntegrante");
	}

	private void cmbEstadoExpCargar() {
		
		List<Estado> estados = estadoService.buscar(null);
		
		BeanItemContainer<Estado> containerEstado = new BeanItemContainer<Estado>(Estado.class,  estados);
		cmbEstadoExp.setContainerDataSource(containerEstado);
		cmbEstadoExp.setItemCaptionPropertyId("nombre");
		
	}

	private void cmbJurisdiccionCargar() {
		Entidad entidadBus = new Entidad();
		entidadBus.setTipo(new Valor());
		entidadBus.getTipo().setCodigo(Constante.VALOR.CODIGO.COMI);
		
		List<Entidad> entidades = entidadService.buscar(entidadBus);
		
		BeanItemContainer<Entidad> containerCentroPoblado = new BeanItemContainer<Entidad>(Entidad.class,  entidades);
		cmbJurisdiccion.setContainerDataSource(containerCentroPoblado);
		cmbJurisdiccion.setItemCaptionPropertyId("nombre");
		
	}

	private void cmbCentroPobladoCargar(){
		
		List<CentroPoblado> centroPoblados = centroPobladoService.buscar(new  CentroPoblado());
		
		BeanItemContainer<CentroPoblado> containerCentroPoblado = new BeanItemContainer<CentroPoblado>(CentroPoblado.class,  centroPoblados);
		cmbCentroPoblado.setContainerDataSource(containerCentroPoblado);
		cmbCentroPoblado.setItemCaptionPropertyId("nombre");
	}
	
	private void cmbLugarHechoCargar(){
		
		List<Distrito> distritos = ubigeoService.obtenerTodos();
		
		cmbLugarHecho.setInputPrompt("Distrito - Provincia - Departamento");
		cmbLugarHecho.setItemCaptionPropertyId("nombreCompleto");
		cmbLugarHecho.setContainerDataSource(new BeanItemContainer<Distrito>(Distrito.class,  distritos));
		cmbLugarHecho.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals( btnGrabar )) {
			buttonClickGrabar();
		} else if(event.getButton().equals( btnLimpiar )) {
			limpiar();
		} 
	}

	private void buttonClickGrabar() {
		Expediente expedienteTemp = null;
		
		if(expediente.esNuevo()) {
			expedienteTemp = new Expediente();
		}
		else {		
			expediente = expedienteService.obtener(expediente.getId());
			if(expediente != null){
				try {
					expedienteTemp = (Expediente) BeanUtils.cloneBean(expediente);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				expedienteTemp = new Expediente();
				pnlDocumento.setDocumento(null);
			}
		}
		
		obtenerFormularioExpediente(expedienteTemp);
		
		expediente = expedienteTemp;
		
		if(expediente.esNuevo()) {				
			
			Documento documento = pnlDocumento.getDocumento();
			documento.setEsInicial("1");
			Ruta ruta = new Ruta();
			if(documento.isRegistrable()){
				//TODO completar el llenado de Ruta
				ruta.setTablaOrigen(pnlDocumento.getProcedencia());
				ruta.setCodigoOrigen(pnlDocumento.getCodigoProcedencia());//Constante.VALOR.CODIGO.
				ruta.setFechaRecepcion(documento.getFechaRecepcion());				
			}
			ruta.setTablaDestino(valorService.obtenerValor(Constante.LISTA.CODIGO.TABLAS, Constante.VALOR.CODIGO.DEPENDENCIA));
			ruta.setCodigoDestino(expediente.getDependencia() != null ? expediente.getDependencia().getId() : null);
			ruta.setIntegrante(expediente.getIntegrante());
			ruta.setFechaEnvio(new Date());
			ruta.setUsuarioOrigen(null);
			ruta.setUsuarioRecepcion(HarecUtil.obtenerUsuarioSesion());
			expedienteService.registrarExpediente(expediente, documento, ruta);
			
			//String numeroParte = StringUtils.leftPad(String.valueOf(expediente.getId()), 10, "0");
			//expediente.setAutogenerado(numeroParte);
			
			
			pnlDocumento.setHabilitarCarga(false);
			escribirAutogenerado();
			pnlRegistroParte.habilitarTab(true);
		} 
		else {
			expedienteService.actualizar(expediente);
		}
		
		//expedienteService.actualizar(expediente);
		//pnlAgregarDocumento.cargarDocumentos();
		//cmbCentroPoblado.se
		
		pnlRegistroParte.setExpediente(expediente);
		pnlAgregarDocumento.setExpediente(expediente);
		
		StringBuilder sbContenido = new StringBuilder();
		sbContenido.append("Expediente Nº ").append(expediente.getAutogenerado()).append(" registrado.");
		
		AlertDialog alertDialog = new  AlertDialog("Registro de Parte", sbContenido.toString(), "Aceptar", "400");
		getApplication().getMainWindow().addWindow(alertDialog);
		
	}
	
	private void escribirAutogenerado() {
		lblNroPartePolicial.setValue("Nro. Autogenerado del Parte: " + expediente.getAutogenerado());
	}

	private void obtenerFormularioExpediente(Expediente expedienteTemp) {
		
		expedienteTemp.setNombreCaso((String)txtNombreDelCaso.getValue());
		expedienteTemp.setTipoHecho((TipoHecho)cmbTipoHecho.getValue());
		expedienteTemp.setDescripcion((String)txaDescripcion.getValue());
		expedienteTemp.setAsunto((String)txtAsuntoExp.getValue());
		expedienteTemp.setDependencia((Dependencia)cmbDependencia.getValue());
		expedienteTemp.setTipoFinalidad(cmbFinalidad.getValor());		
		expedienteTemp.setFechaRegistro((Date)dtRegistroExp.getValue());
		expedienteTemp.setDiasAtencion(StringUtils.isNotEmpty((String) txtDiasAtencionExp.getValue()) ? new BigDecimal((String) txtDiasAtencionExp.getValue()) : null);
		expedienteTemp.setEstado((Estado) cmbEstadoExp.getValue());
		expedienteTemp.setLugarHecho((Distrito) cmbLugarHecho.getValue());
		expedienteTemp.setTipoDireccion(cmbTipoDir.getValor());
		expedienteTemp.setDireccionHecho((String)txtDireccion.getValue());
		expedienteTemp.setReferenciaHecho((String)txtReferencia.getValue());
		expedienteTemp.setJurisdiccion((Entidad)cmbJurisdiccion.getValue());
		expedienteTemp.setCentroPoblado((CentroPoblado)cmbCentroPoblado.getValue());
		expedienteTemp.setCuenca(cmbCuenca.getValor());	
		expedienteTemp.setTablaInterviniente(cmbTablaEntidad.getValor());
		if(cmbInterviniente.getValue() != null) {
			expedienteTemp.setCodigoInterviniente(((Integrante)(cmbInterviniente.getValue())).getId());
		}		
	}
	
	public void cargarFormularioExpediente() {
		
		label_1.setVisible(false);
		pnlDocumento.setVisible(false);
		
		txtNombreDelCaso.setValue(expediente.getNombreCaso());
		cmbTipoHecho.select(expediente.getTipoHecho());
		txaDescripcion.setValue(expediente.getDescripcion());
		txtAsuntoExp.setValue(expediente.getAsunto());
		cmbDependencia.select(expediente.getDependencia());
		cmbFinalidad.select(expediente.getTipoFinalidad());
		dtRegistroExp.setValue(expediente.getFechaRegistro());
		txtDiasAtencionExp.setValue(expediente.getDiasAtencion() != null ? expediente.getDiasAtencion().toString() : StringUtils.EMPTY);
		cmbEstadoExp.select(expediente.getEstado());
		cmbLugarHecho.select(expediente.getLugarHecho());
		cmbTipoDir.select(expediente.getTipoDireccion());
		txtDireccion.setValue(expediente.getDireccionHecho());
		txtReferencia.setValue(expediente.getReferenciaHecho());
		cmbJurisdiccion.select(expediente.getJurisdiccion());
		cmbCentroPoblado.select(expediente.getCentroPoblado());
		cmbCuenca.select(expediente.getCuenca());	
		cmbTablaEntidad.select(expediente.getTablaInterviniente());
		Integrante integrante = new Integrante();
		integrante.setId(expediente.getCodigoInterviniente());
		cmbInterviniente.select(integrante);		
		
		escribirAutogenerado();
		
	}

	private void limpiar() {
		cmbInterviniente.setValue(null);
		cmbTablaEntidad.setValue(null);
		cmbCuenca.setValue(null);
		cmbCentroPoblado.setValue(null);
		cmbJurisdiccion.setValue(null);
		txtReferencia.setValue(null);
		txtDireccion.setValue(null);
		cmbTipoDir.setValue(null);
		cmbLugarHecho.setValue(null);
		cmbEstadoExp.setValue(null);
		txtDiasAtencionExp.setValue(null);
		dtRegistroExp.setValue(null);
		cmbFinalidad.setValue(null);
		cmbDependencia.setValue(null);
		txtAsuntoExp.setValue(null);
		txaDescripcion.setValue(null);
		cmbTipoHecho.setValue(null);
		txtNombreDelCaso.setValue(null);
		pnlDocumento.limpiar();
	}
	
	public PanelRegistroParteDocumento getPnlAgregarDocumento() {
		return pnlAgregarDocumento;
	}

	public void setPnlAgregarDocumento(
			PanelRegistroParteDocumento pnlAgregarDocumento) {
		this.pnlAgregarDocumento = pnlAgregarDocumento;
	}
	
	public void setPanelRegistroParte(PanelRegistroParte pnlRegistroParte) {
		this.pnlRegistroParte = pnlRegistroParte;
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
		pnlPrincipal.setMargin(true);
		pnlPrincipal.setSpacing(true);
		
		// lblNroPartePolicial
		lblNroPartePolicial = new Label();
		lblNroPartePolicial.setStyleName("boldRojo");
		lblNroPartePolicial.setImmediate(false);
		lblNroPartePolicial.setWidth("-1px");
		lblNroPartePolicial.setHeight("22px");
		lblNroPartePolicial.setValue("Nro. Autogenerado del Parte:");
		pnlPrincipal.addComponent(lblNroPartePolicial);
		
		// verticalLayout_4
		verticalLayout_4 = buildVerticalLayout_4();
		pnlPrincipal.addComponent(verticalLayout_4);
		
		// horizontalLayout_13
		horizontalLayout_13 = buildHorizontalLayout_13();
		pnlPrincipal.addComponent(horizontalLayout_13);
		pnlPrincipal.setComponentAlignment(horizontalLayout_13, new Alignment(
				20));
		
		return pnlPrincipal;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_4() {
		// common part: create layout
		verticalLayout_4 = new VerticalLayout();
		verticalLayout_4.setImmediate(false);
		verticalLayout_4.setWidth("-1px");
		verticalLayout_4.setHeight("-1px");
		verticalLayout_4.setMargin(false);
		
		// label_1
		label_1 = new Label();
		label_1.setStyleName("h1");
		label_1.setImmediate(false);
		label_1.setWidth("-1px");
		label_1.setHeight("-1px");
		label_1.setValue("Documento Inicial");
		verticalLayout_4.addComponent(label_1);
		
		// pnlDocumento
		pnlDocumento = new PanelDocumento();
		pnlDocumento.setImmediate(false);
		pnlDocumento.setWidth("-1px");
		pnlDocumento.setHeight("-1px");
		verticalLayout_4.addComponent(pnlDocumento);
		
		// label_2
		label_2 = new Label();
		label_2.setStyleName("h1");
		label_2.setImmediate(false);
		label_2.setWidth("-1px");
		label_2.setHeight("-1px");
		label_2.setValue("Hechos del Delito");
		verticalLayout_4.addComponent(label_2);
		
		// pnlHecho
		pnlHecho = buildPnlHecho();
		verticalLayout_4.addComponent(pnlHecho);
		
		return verticalLayout_4;
	}

	@AutoGenerated
	private VerticalLayout buildPnlHecho() {
		// common part: create layout
		pnlHecho = new VerticalLayout();
		pnlHecho.setImmediate(false);
		pnlHecho.setDescription("Datos correspondientes al Parte Policial");
		pnlHecho.setWidth("-1px");
		pnlHecho.setHeight("-1px");
		pnlHecho.setMargin(false);
		pnlHecho.setSpacing(true);
		
		// txtAsuntoExp
		txtAsuntoExp = new TextField();
		txtAsuntoExp.setCaption("Asunto");
		txtAsuntoExp.setImmediate(false);
		txtAsuntoExp.setWidth("600px");
		txtAsuntoExp.setHeight("-1px");
		txtAsuntoExp.setInputPrompt("Asunto del Expediente");
		txtAsuntoExp.setMaxLength(500);
		pnlHecho.addComponent(txtAsuntoExp);
		
		// txaDescripcion
		txaDescripcion = new TextArea();
		txaDescripcion.setCaption("Descripción del Caso");
		txaDescripcion.setImmediate(false);
		txaDescripcion.setWidth("700px");
		txaDescripcion.setHeight("50px");
		txaDescripcion.setInputPrompt("Breve descripción del Caso");
		pnlHecho.addComponent(txaDescripcion);
		
		// horizontalLayout_4
		horizontalLayout_4 = buildHorizontalLayout_4();
		pnlHecho.addComponent(horizontalLayout_4);
		
		// horizontalLayout_5
		horizontalLayout_5 = buildHorizontalLayout_5();
		pnlHecho.addComponent(horizontalLayout_5);
		
		// horizontalLayout_7
		horizontalLayout_7 = buildHorizontalLayout_7();
		pnlHecho.addComponent(horizontalLayout_7);
		
		// horizontalLayout_8
		horizontalLayout_8 = buildHorizontalLayout_8();
		pnlHecho.addComponent(horizontalLayout_8);
		
		// horizontalLayout_10
		horizontalLayout_10 = buildHorizontalLayout_10();
		pnlHecho.addComponent(horizontalLayout_10);
		
		// horizontalLayout_12
		horizontalLayout_12 = buildHorizontalLayout_12();
		pnlHecho.addComponent(horizontalLayout_12);
		
		return pnlHecho;
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
		
		// txtNombreDelCaso
		txtNombreDelCaso = new TextField();
		txtNombreDelCaso.setCaption("Nombre del Caso");
		txtNombreDelCaso.setImmediate(false);
		txtNombreDelCaso.setWidth("200px");
		txtNombreDelCaso.setHeight("-1px");
		txtNombreDelCaso.setInputPrompt("Nombre del Caso");
		horizontalLayout_4.addComponent(txtNombreDelCaso);
		
		// cmbTipoHecho
		cmbTipoHecho = new ComboBox();
		cmbTipoHecho.setCaption("Tipo de Hecho");
		cmbTipoHecho.setImmediate(false);
		cmbTipoHecho.setWidth("200px");
		cmbTipoHecho.setHeight("-1px");
		horizontalLayout_4.addComponent(cmbTipoHecho);
		
		// cmbSubTipoHecho
		cmbSubTipoHecho = new ComboBox();
		cmbSubTipoHecho.setCaption("Sub Tipo del Hecho");
		cmbSubTipoHecho.setImmediate(false);
		cmbSubTipoHecho.setWidth("200px");
		cmbSubTipoHecho.setHeight("-1px");
		horizontalLayout_4.addComponent(cmbSubTipoHecho);
		
		// cmbHecho
		cmbHecho = new ComboBox();
		cmbHecho.setCaption("Nombre del Hecho");
		cmbHecho.setImmediate(false);
		cmbHecho.setWidth("200px");
		cmbHecho.setHeight("-1px");
		horizontalLayout_4.addComponent(cmbHecho);
		
		return horizontalLayout_4;
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
		
		// cmbDependencia
		cmbDependencia = new ComboBox();
		cmbDependencia.setCaption("Dependencia");
		cmbDependencia.setImmediate(false);
		cmbDependencia.setWidth("300px");
		cmbDependencia.setHeight("-1px");
		horizontalLayout_5.addComponent(cmbDependencia);
		
		// cmbFinalidad
		cmbFinalidad = new ComboBoxLOVS();
		cmbFinalidad.setCaption("Finalidad");
		cmbFinalidad.setImmediate(false);
		cmbFinalidad.setWidth("200px");
		cmbFinalidad.setHeight("-1px");
		horizontalLayout_5.addComponent(cmbFinalidad);
		
		// dtRegistroExp
		dtRegistroExp = new PopupDateField();
		dtRegistroExp.setCaption("Fecha de Registro");
		dtRegistroExp.setImmediate(false);
		dtRegistroExp.setWidth("150px");
		dtRegistroExp.setHeight("-1px");
		dtRegistroExp.setInvalidAllowed(false);
		horizontalLayout_5.addComponent(dtRegistroExp);
		
		// txtDiasAtencionExp
		txtDiasAtencionExp = new TextField();
		txtDiasAtencionExp.setCaption("Dias de Atencion");
		txtDiasAtencionExp.setImmediate(false);
		txtDiasAtencionExp.setWidth("150px");
		txtDiasAtencionExp.setHeight("-1px");
		txtDiasAtencionExp.setInputPrompt("Dias de Atencion");
		horizontalLayout_5.addComponent(txtDiasAtencionExp);
		
		return horizontalLayout_5;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_7() {
		// common part: create layout
		horizontalLayout_7 = new HorizontalLayout();
		horizontalLayout_7.setImmediate(false);
		horizontalLayout_7.setWidth("-1px");
		horizontalLayout_7.setHeight("-1px");
		horizontalLayout_7.setMargin(false);
		horizontalLayout_7.setSpacing(true);
		
		// cmbIntegrante
		cmbIntegrante = new ComboBox();
		cmbIntegrante.setCaption("Instructor");
		cmbIntegrante.setImmediate(false);
		cmbIntegrante.setWidth("-1px");
		cmbIntegrante.setHeight("-1px");
		horizontalLayout_7.addComponent(cmbIntegrante);
		
		// cmbEstadoExp
		cmbEstadoExp = new ComboBox();
		cmbEstadoExp.setCaption("Estado");
		cmbEstadoExp.setImmediate(false);
		cmbEstadoExp.setWidth("-1px");
		cmbEstadoExp.setHeight("-1px");
		horizontalLayout_7.addComponent(cmbEstadoExp);
		
		return horizontalLayout_7;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_8() {
		// common part: create layout
		horizontalLayout_8 = new HorizontalLayout();
		horizontalLayout_8.setImmediate(false);
		horizontalLayout_8.setWidth("-1px");
		horizontalLayout_8.setHeight("-1px");
		horizontalLayout_8.setMargin(false);
		horizontalLayout_8.setSpacing(true);
		
		// cmbLugarHecho
		cmbLugarHecho = new ComboBox();
		cmbLugarHecho.setCaption("Lugar del Hecho");
		cmbLugarHecho.setImmediate(false);
		cmbLugarHecho.setWidth("300px");
		cmbLugarHecho.setHeight("-1px");
		horizontalLayout_8.addComponent(cmbLugarHecho);
		
		// cmbTipoDir
		cmbTipoDir = new ComboBoxLOVS();
		cmbTipoDir.setCaption("Tipo de Direccion");
		cmbTipoDir.setImmediate(false);
		cmbTipoDir.setWidth("200px");
		cmbTipoDir.setHeight("-1px");
		horizontalLayout_8.addComponent(cmbTipoDir);
		
		// txtDireccion
		txtDireccion = new TextField();
		txtDireccion.setCaption("Direccion del Hecho");
		txtDireccion.setImmediate(false);
		txtDireccion.setWidth("300px");
		txtDireccion.setHeight("-1px");
		txtDireccion.setInputPrompt("Direccion del Hecho");
		horizontalLayout_8.addComponent(txtDireccion);
		
		return horizontalLayout_8;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_10() {
		// common part: create layout
		horizontalLayout_10 = new HorizontalLayout();
		horizontalLayout_10.setImmediate(false);
		horizontalLayout_10.setWidth("-1px");
		horizontalLayout_10.setHeight("-1px");
		horizontalLayout_10.setMargin(false);
		horizontalLayout_10.setSpacing(true);
		
		// txtReferencia
		txtReferencia = new TextField();
		txtReferencia.setCaption("Referencia");
		txtReferencia.setImmediate(false);
		txtReferencia.setWidth("300px");
		txtReferencia.setHeight("-1px");
		txtReferencia.setInputPrompt("Referencia de la direccion");
		horizontalLayout_10.addComponent(txtReferencia);
		
		// cmbJurisdiccion
		cmbJurisdiccion = new ComboBox();
		cmbJurisdiccion.setCaption("Jurisdiccion");
		cmbJurisdiccion.setImmediate(false);
		cmbJurisdiccion.setWidth("200px");
		cmbJurisdiccion.setHeight("-1px");
		horizontalLayout_10.addComponent(cmbJurisdiccion);
		
		// cmbCentroPoblado
		cmbCentroPoblado = new ComboBox();
		cmbCentroPoblado.setCaption("Centro Poblado");
		cmbCentroPoblado.setImmediate(false);
		cmbCentroPoblado.setWidth("300px");
		cmbCentroPoblado.setHeight("-1px");
		horizontalLayout_10.addComponent(cmbCentroPoblado);
		
		return horizontalLayout_10;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_12() {
		// common part: create layout
		horizontalLayout_12 = new HorizontalLayout();
		horizontalLayout_12.setImmediate(false);
		horizontalLayout_12.setWidth("-1px");
		horizontalLayout_12.setHeight("-1px");
		horizontalLayout_12.setMargin(false);
		horizontalLayout_12.setSpacing(true);
		
		// cmbCuenca
		cmbCuenca = new ComboBoxLOVS();
		cmbCuenca.setCaption("Cuenca");
		cmbCuenca.setImmediate(false);
		cmbCuenca.setWidth("300px");
		cmbCuenca.setHeight("-1px");
		horizontalLayout_12.addComponent(cmbCuenca);
		
		// cmbTablaEntidad
		cmbTablaEntidad = new ComboBoxLOVS();
		cmbTablaEntidad.setCaption("Tipo de Interviniente");
		cmbTablaEntidad.setImmediate(false);
		cmbTablaEntidad.setWidth("200px");
		cmbTablaEntidad.setHeight("-1px");
		horizontalLayout_12.addComponent(cmbTablaEntidad);
		
		// cmbInterviniente
		cmbInterviniente = new ComboBox();
		cmbInterviniente.setCaption("Interviniente");
		cmbInterviniente.setImmediate(false);
		cmbInterviniente.setWidth("300px");
		cmbInterviniente.setHeight("-1px");
		horizontalLayout_12.addComponent(cmbInterviniente);
		
		return horizontalLayout_12;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_13() {
		// common part: create layout
		horizontalLayout_13 = new HorizontalLayout();
		horizontalLayout_13.setImmediate(false);
		horizontalLayout_13.setWidth("-1px");
		horizontalLayout_13.setHeight("-1px");
		horizontalLayout_13.setMargin(false);
		horizontalLayout_13.setSpacing(true);
		
		// btnGrabar
		btnGrabar = new Button();
		btnGrabar.setCaption("Grabar");
		btnGrabar.setImmediate(true);
		btnGrabar.setWidth("-1px");
		btnGrabar.setHeight("-1px");
		horizontalLayout_13.addComponent(btnGrabar);
		
		// btnLimpiar
		btnLimpiar = new Button();
		btnLimpiar.setCaption("Limpiar");
		btnLimpiar.setImmediate(true);
		btnLimpiar.setWidth("-1px");
		btnLimpiar.setHeight("-1px");
		horizontalLayout_13.addComponent(btnLimpiar);
		
		return horizontalLayout_13;
	}

}
