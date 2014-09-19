package pe.gob.mininter.dirandro.vaadin.panel;

import java.math.BigDecimal;
import java.util.List;

import pe.gob.mininter.dirandro.model.Empresa;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.ModeloMarca;
import pe.gob.mininter.dirandro.model.Municion;
import pe.gob.mininter.dirandro.model.Persona;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.EmpresaService;
import pe.gob.mininter.dirandro.service.ExpedienteService;
import pe.gob.mininter.dirandro.service.ModeloMarcaService;
import pe.gob.mininter.dirandro.service.MunicionService;
import pe.gob.mininter.dirandro.service.PersonaService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;
import pe.gob.mininter.dirandro.vaadin.dialogs.AlertDialog;
import pe.gob.mininter.dirandro.vaadin.util.ComboBoxLOVS;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PanelRegistroParteMunicion extends CustomComponent implements ClickListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	
	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlMunicionesCuerpo;
	@AutoGenerated
	private Table tblMuniLista;
	@AutoGenerated
	private HorizontalLayout pnlMunicionesBody6;
	@AutoGenerated
	private Button btnMuniRegistrar;
	@AutoGenerated
	private HorizontalLayout pnlMunicionesBody5;
	@AutoGenerated
	private TextArea txtMuniObservacion;
	@AutoGenerated
	private HorizontalLayout pnlMunicionesBody4;
	@AutoGenerated
	private ComboBoxLOVS cmbMuniSituacion;
	@AutoGenerated
	private ComboBoxLOVS cmbMuniEstado;
	@AutoGenerated
	private TextField txtCantidad;
	@AutoGenerated
	private TextField txtMuniMedida;
	@AutoGenerated
	private ComboBox cmbMuniTipoMedida;
	@AutoGenerated
	private HorizontalLayout pnlMunicionesBody3;
	@AutoGenerated
	private TextField txtMuniDescripcion;
	@AutoGenerated
	private HorizontalLayout pnlMunicionesBody2;
	@AutoGenerated
	private ComboBox cmbMuniPersonaIncautada;
	@AutoGenerated
	private OptionGroup rbTipoPersona;
	@AutoGenerated
	private HorizontalLayout pnlMunicionesBody1;
	@AutoGenerated
	private ComboBox cmbMuniMarca;
	@AutoGenerated
	private ComboBox cmbMuniTipo;
	@AutoGenerated
	private ComboBoxLOVS cmbCalibre;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */

	private static final long serialVersionUID = -4639683924066371051L;
	private Expediente expediente;
	private Municion municion;
	private MunicionService municionService;
	private ModeloMarcaService modeloMarcaService;
	private PersonaService personaService;
	private EmpresaService empresaService;
	
	private List<ModeloMarca> lstTiposMedidas;
	private List<ModeloMarca> lstTiposMunicion;
	private List<ModeloMarca> lstMarcas;
	
	private List<Empresa> lstEmpresas;
	private List<Persona> lstPersonas;
	private String listaSeleccionada="persona";
	
	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}
		
	public PanelRegistroParteMunicion() {
		super();
		buildMainLayout();
		municionService = Injector.obtenerServicio(MunicionService.class);
		modeloMarcaService = Injector.obtenerServicio(ModeloMarcaService.class);
		personaService = Injector.obtenerServicio(PersonaService.class);
		empresaService = Injector.obtenerServicio(EmpresaService.class);
		setCompositionRoot(mainLayout);
		postConstruct();
	}
	
	public void postConstruct() {

		ExpedienteService expedienteService = Injector.obtenerServicio(ExpedienteService.class);
		expediente=expedienteService.obtener(1l);
		
		cmbMuniEstado.setInputPrompt("Estado");
		cmbMuniEstado.setCodigoLista(Constante.LISTA.CODIGO.ESTADO);
		cmbCalibre.setInputPrompt("Calibre");
		cmbCalibre.setCodigoLista(Constante.LISTA.CODIGO.TIPO_CALIBRE);
		cmbMuniSituacion.setInputPrompt("Situacion");
		cmbMuniSituacion.setCodigoLista(Constante.LISTA.CODIGO.SITUACION_GENERAL);
		
		cmbMuniTipo.setInputPrompt("Tipo Municion");
		cmbMuniTipo.setItemCaptionPropertyId("nombre");
		lstTiposMunicion = modeloMarcaService.buscarHijos(new ModeloMarca(Constante.MODELO_MARCA.MUNICIONES.AUTO));
		cmbMuniTipo.setContainerDataSource(new BeanItemContainer<ModeloMarca>(ModeloMarca.class,  lstTiposMunicion));
		cmbMuniTipo.setImmediate(true);
		cmbMuniTipo.addListener(new Property.ValueChangeListener() {            
			private static final long serialVersionUID = 1L;
			@Override
            public void valueChange(ValueChangeEvent event) {				 
				lstMarcas = modeloMarcaService.buscarHijos((ModeloMarca)cmbMuniTipo.getValue());
				cmbMuniMarca.setContainerDataSource(new BeanItemContainer<ModeloMarca>(ModeloMarca.class,lstMarcas));
            }
        });
		
		//marca
		cmbMuniMarca.setInputPrompt("Marcas");
		cmbMuniMarca.setItemCaptionPropertyId("nombre");
		
		cmbMuniTipoMedida.setInputPrompt("Tipo Medida");
		cmbMuniTipoMedida.setItemCaptionPropertyId("nombre");
		lstTiposMedidas = modeloMarcaService.buscarHijos(new ModeloMarca(Constante.MODELO_MARCA.MUNICIONES.PRESENTACIONES));
		cmbMuniTipoMedida.setContainerDataSource(new BeanItemContainer<ModeloMarca>(ModeloMarca.class,  lstTiposMedidas));
		
		rbTipoPersona.addItem("Persona");
		rbTipoPersona.addItem("Empresa");
		rbTipoPersona.select("Persona");
		rbTipoPersona.setImmediate(true);
		rbTipoPersona.addListener(new ValueChangeListener() {
			private static final long serialVersionUID = 2720977948538256976L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				rbTipoPersonaValueChange(event);
			}
		});
		
		cmbMuniPersonaIncautada.setInputPrompt("Incautado a:");
		cmbMuniPersonaIncautada.setItemCaptionPropertyId("nombreCompleto");
		cmbMuniPersonaIncautada.setImmediate(true);
		cargaComboPersonaIncautada("persona");
		
		tblMuniLista.setSelectable(true);
		tblMuniLista.setImmediate(true);
		tblMuniLista.setNullSelectionAllowed(true);
		tblMuniLista.setNullSelectionItemId(null);
		tblMuniLista.addListener(new ValueChangeListener() {
			
			private static final long serialVersionUID = 7962790507398071986L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				boolean esModoNuevo = tblMuniLista.getValue() == null;
				limpiar();
				if(esModoNuevo){
					tblMuniLista.setValue(null);
					habilitarEdicion(false);
				}else{
					habilitarEdicion(true);
					Item item = tblMuniLista.getItem(tblMuniLista.getValue());
				
					municion.setId((Long) item.getItemProperty("id").getValue());					
					txtMuniDescripcion.setValue(item.getItemProperty("descripcion").getValue());
					txtMuniObservacion.setValue(item.getItemProperty("observacion").getValue());
					txtMuniMedida.setValue(item.getItemProperty("medida").getValue());
					txtCantidad.setValue(item.getItemProperty("cantidad").getValue());
					
					cmbCalibre.select(new Valor((Long)item.getItemProperty("calibre.id").getValue()));
					cmbMuniEstado.select(new Valor((Long)item.getItemProperty("estado.id").getValue()));
					cmbMuniSituacion.select(new Valor((Long)item.getItemProperty("situacion.id").getValue()));
					cmbMuniTipo.select(new ModeloMarca((Long)item.getItemProperty("tipo.id").getValue()));
					cmbMuniMarca.select(new ModeloMarca((Long)item.getItemProperty("marca.id").getValue()));
					cmbMuniTipoMedida.select(new ModeloMarca((Long)item.getItemProperty("tipoMedida.id").getValue()));
					
					if(item.getItemProperty("persona.id").getValue()!=null){
						listaSeleccionada="persona";
						rbTipoPersona.select("Persona");
						cmbMuniPersonaIncautada.select(new Persona((Long)item.getItemProperty("persona.id").getValue()));
					}else{
						listaSeleccionada="empresa";
						rbTipoPersona.select("Empresa");
						if(lstEmpresas==null){
							lstEmpresas = empresaService.listarEmpresas();
						}
						cmbMuniPersonaIncautada.select(new Empresa((Long)item.getItemProperty("empresa.id").getValue()));
					}
				}
			}
		});	
		
		btnMuniRegistrar.addListener((ClickListener)this);
		
		refrescar();
		
	}

	private void rbTipoPersonaValueChange(ValueChangeEvent event){		
		boolean opcion = event.getProperty().getValue().equals("Persona");
		cmbMuniPersonaIncautada.select(null);
		if(opcion){
			cargaComboPersonaIncautada("persona");
		}else{
			cargaComboPersonaIncautada("empresa");
		}
	}
	
	private void cargaComboPersonaIncautada(String opcion){
		if(opcion.equals("persona")){
			listaSeleccionada="persona";
			if(lstPersonas ==null)
				lstPersonas = personaService.buscar( null );
			cmbMuniPersonaIncautada.setItemCaptionPropertyId("nombreCompleto");
			cmbMuniPersonaIncautada.setContainerDataSource(new BeanItemContainer<Persona>(Persona.class,  lstPersonas));
		}else{
			listaSeleccionada="empresa";
			cmbMuniPersonaIncautada.setItemCaptionPropertyId("razonSocial");
			if(lstEmpresas==null)
				lstEmpresas = empresaService.buscar( null );
			cmbMuniPersonaIncautada.setContainerDataSource(new BeanItemContainer<Empresa>(Empresa.class,  lstEmpresas));
		}
	}
	
	private void cargarTablaInmuebles( ){
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("id", Long.class,  null);
		container.addContainerProperty("persona.id", Long.class, null);
		container.addContainerProperty("persona.nombre", String.class, null);
		container.addContainerProperty("empresa.id", Long.class, null);
		container.addContainerProperty("empresa.nombre", String.class, null);
		container.addContainerProperty("calibre.id", Long.class, null);
		container.addContainerProperty("calibre.nombre", String.class, null);
		container.addContainerProperty("tipo.id", Long.class, null);
		container.addContainerProperty("tipo.nombre", String.class, null);
		container.addContainerProperty("marca.id", Long.class, null);
		container.addContainerProperty("marca.nombre", String.class, null);
		container.addContainerProperty("tipoMedida.id", Long.class, null);
		container.addContainerProperty("tipoMedida.nombre", String.class, null);
		container.addContainerProperty("situacion.id", Long.class, null);
		container.addContainerProperty("situacion.nombre", String.class, null);
		container.addContainerProperty("medida", String.class, null);
		container.addContainerProperty("cantidad", String.class, null);
		container.addContainerProperty("estado.id", Long.class, null);
		container.addContainerProperty("estado.nombre", String.class, null);
		container.addContainerProperty("descripcion", String.class, null);
		container.addContainerProperty("observacion", String.class, null);
		
		tblMuniLista.setContainerDataSource(container);
		tblMuniLista.setVisibleColumns(new Object[]{"persona.nombre", "empresa.nombre", "calibre.nombre","tipo.nombre","marca.nombre"});

		tblMuniLista.setColumnHeader("persona.nombre", "Persona");
		tblMuniLista.setColumnHeader("empresa.nombre", "Empresa");
		tblMuniLista.setColumnHeader("calibre.nombre", "Calibre");
		tblMuniLista.setColumnHeader("tipo.nombre", "Tipo");
		tblMuniLista.setColumnHeader("marca.nombre", "Marca");
		
		Municion munin = new Municion();
		munin.setExpediente(expediente);
		List<Municion> lstinmuebles = municionService.buscar(munin);
		int con=1;
		for (Municion municion : lstinmuebles){
			Item item = container.addItem(con++);
			item.getItemProperty("id").setValue(municion.getId());
			item.getItemProperty("persona.id").setValue(municion.getPersonaImplicada()!=null?HarecUtil.nullToEmpty(municion.getPersonaImplicada().getId()):null);
			item.getItemProperty("persona.nombre").setValue(municion.getPersonaImplicada()!=null?HarecUtil.nullToEmpty(municion.getPersonaImplicada().getNombreCompleto()):null);
			item.getItemProperty("empresa.id").setValue(municion.getEmpresaImplicada()!=null?HarecUtil.nullToEmpty(municion.getEmpresaImplicada().getId()):null);
			item.getItemProperty("empresa.nombre").setValue(municion.getEmpresaImplicada()!=null?HarecUtil.nullToEmpty(municion.getEmpresaImplicada().getRazonSocial()):null);
			item.getItemProperty("calibre.id").setValue(HarecUtil.nullToEmpty(municion.getCalibre().getId()));
			item.getItemProperty("calibre.nombre").setValue(HarecUtil.nullToEmpty(municion.getCalibre().getNombre()));
			
			if(municion.getMarca()!=null){
				item.getItemProperty("tipo.id").setValue(municion.getMarca().getPadre()!=null?HarecUtil.nullToEmpty(municion.getMarca().getPadre().getId()):null);
				item.getItemProperty("tipo.nombre").setValue(municion.getMarca().getPadre()!=null?HarecUtil.nullToEmpty(municion.getMarca().getPadre().getNombre()):null);
			}
			
			item.getItemProperty("marca.id").setValue(municion.getMarca()!=null?HarecUtil.nullToEmpty(municion.getMarca().getId()):null);
			item.getItemProperty("marca.nombre").setValue(municion.getMarca()!=null?HarecUtil.nullToEmpty(municion.getMarca().getNombre()):null);
				
			item.getItemProperty("tipoMedida.id").setValue(municion.getTipoMedida()!=null?HarecUtil.nullToEmpty(municion.getTipoMedida().getId()):null);
			item.getItemProperty("tipoMedida.nombre").setValue(municion.getTipoMedida()!=null?HarecUtil.nullToEmpty(municion.getTipoMedida().getNombre()):null);
			
			item.getItemProperty("situacion.id").setValue(HarecUtil.nullToEmpty(municion.getSituacion().getId()));
			item.getItemProperty("situacion.nombre").setValue(HarecUtil.nullToEmpty(municion.getSituacion().getNombre()));
			item.getItemProperty("estado.id").setValue(HarecUtil.nullToEmpty(municion.getEstado().getId()));
			item.getItemProperty("estado.nombre").setValue(HarecUtil.nullToEmpty(municion.getEstado().getNombre()));
			item.getItemProperty("medida").setValue(HarecUtil.nullToEmpty(municion.getMedida()));
			item.getItemProperty("cantidad").setValue(HarecUtil.nullToEmpty(municion.getCantidad()));
			item.getItemProperty("descripcion").setValue(HarecUtil.nullToEmpty(municion.getDescripcion()));
			item.getItemProperty("observacion").setValue(HarecUtil.nullToEmpty(municion.getObservacion()));
		}
	}
	
	public void refrescar(){
		habilitarEdicion(false);
		limpiar();
		cargarTablaInmuebles();
	}
	
	private void habilitarEdicion(boolean flag){
		if(flag){
			btnMuniRegistrar.setCaption("Actualizar");
		}
		else{
			btnMuniRegistrar.setCaption("Crear");
		}
	}
	
	public void limpiar(){
		municion = new Municion(0l);
		municion.setExpediente(expediente);
		txtMuniDescripcion.setValue("");
		txtMuniMedida.setValue("");
		txtMuniObservacion.setValue("");
		txtCantidad.setValue("");
		cmbMuniEstado.select(null);
		cmbMuniMarca.select(null);
		cmbMuniPersonaIncautada.select(null);
	
		cmbCalibre.select(null);
		cmbMuniSituacion.select(null);
		cmbMuniTipo.select(null);
		cmbMuniTipoMedida.select(null);
		rbTipoPersona.select("Persona");		
		cargaComboPersonaIncautada("persona");
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		
		if(event.getButton().equals( btnMuniRegistrar )){
			
			municion.setExpediente(expediente);
			
			municion.setDescripcion(HarecUtil.nullToEmpty(txtMuniDescripcion.getValue()));
			municion.setObservacion(HarecUtil.nullToEmpty(txtMuniObservacion.getValue()));
			municion.setMedida(!HarecUtil.nullToEmpty(txtMuniMedida.getValue()).equals("") ? new BigDecimal((String)txtMuniMedida.getValue()):null);
			municion.setCantidad(!HarecUtil.nullToEmpty(txtCantidad.getValue()).equals("") ? Integer.valueOf((String)txtCantidad.getValue()):null);
			municion.setMarca((ModeloMarca)cmbMuniMarca.getValue());
			if(listaSeleccionada.equals("persona")){
				municion.setPersonaImplicada((Persona)cmbMuniPersonaIncautada.getValue());	
			}else{
				municion.setEmpresaImplicada((Empresa)cmbMuniPersonaIncautada.getValue());	
			}
			municion.setCalibre(cmbCalibre.getValor());
			municion.setEstado(cmbMuniEstado.getValor());
			municion.setSituacion(cmbMuniSituacion.getValor());
			municion.setTipoMedida((ModeloMarca)cmbMuniTipoMedida.getValue());
			if(municion.getId()==0)
				municionService.crear(municion);
			else
				municionService.actualizar(municion);
			refrescar();
			AlertDialog alertDialog = new  AlertDialog("Registro de Munición", "Se ha registrado la munición correctamente", "Aceptar", "400");
			getApplication().getMainWindow().addWindow(alertDialog);
			
		}
		
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("-1px");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("-1px");
		setHeight("-1px");
		
		// pnlMunicionesCuerpo
		pnlMunicionesCuerpo = buildPnlMunicionesCuerpo();
		mainLayout.addComponent(pnlMunicionesCuerpo);
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildPnlMunicionesCuerpo() {
		// common part: create layout
		pnlMunicionesCuerpo = new VerticalLayout();
		pnlMunicionesCuerpo.setImmediate(false);
		pnlMunicionesCuerpo.setWidth("-1px");
		pnlMunicionesCuerpo.setHeight("-1px");
		pnlMunicionesCuerpo.setMargin(true);
		pnlMunicionesCuerpo.setSpacing(true);
		
		// pnlMunicionesBody1
		pnlMunicionesBody1 = buildPnlMunicionesBody1();
		pnlMunicionesCuerpo.addComponent(pnlMunicionesBody1);
		
		// pnlMunicionesBody2
		pnlMunicionesBody2 = buildPnlMunicionesBody2();
		pnlMunicionesCuerpo.addComponent(pnlMunicionesBody2);
		
		// pnlMunicionesBody3
		pnlMunicionesBody3 = buildPnlMunicionesBody3();
		pnlMunicionesCuerpo.addComponent(pnlMunicionesBody3);
		
		// pnlMunicionesBody4
		pnlMunicionesBody4 = buildPnlMunicionesBody4();
		pnlMunicionesCuerpo.addComponent(pnlMunicionesBody4);
		
		// pnlMunicionesBody5
		pnlMunicionesBody5 = buildPnlMunicionesBody5();
		pnlMunicionesCuerpo.addComponent(pnlMunicionesBody5);
		
		// pnlMunicionesBody6
		pnlMunicionesBody6 = buildPnlMunicionesBody6();
		pnlMunicionesCuerpo.addComponent(pnlMunicionesBody6);
		pnlMunicionesCuerpo.setComponentAlignment(pnlMunicionesBody6,
				new Alignment(20));
		
		// tblMuniLista
		tblMuniLista = new Table();
		tblMuniLista.setImmediate(false);
		tblMuniLista.setWidth("900px");
		tblMuniLista.setHeight("150px");
		pnlMunicionesCuerpo.addComponent(tblMuniLista);
		
		return pnlMunicionesCuerpo;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlMunicionesBody1() {
		// common part: create layout
		pnlMunicionesBody1 = new HorizontalLayout();
		pnlMunicionesBody1.setImmediate(false);
		pnlMunicionesBody1.setWidth("-1px");
		pnlMunicionesBody1.setHeight("-1px");
		pnlMunicionesBody1.setMargin(false);
		pnlMunicionesBody1.setSpacing(true);
		
		// cmbCalibre
		cmbCalibre = new ComboBoxLOVS();
		cmbCalibre.setCaption("Calibre");
		cmbCalibre.setImmediate(false);
		cmbCalibre.setWidth("280px");
		cmbCalibre.setHeight("-1px");
		pnlMunicionesBody1.addComponent(cmbCalibre);
		
		// cmbMuniTipo
		cmbMuniTipo = new ComboBox();
		cmbMuniTipo.setCaption("Tipo de Munición");
		cmbMuniTipo.setImmediate(false);
		cmbMuniTipo.setWidth("280px");
		cmbMuniTipo.setHeight("-1px");
		cmbMuniTipo.setRequired(true);
		pnlMunicionesBody1.addComponent(cmbMuniTipo);
		
		// cmbMuniMarca
		cmbMuniMarca = new ComboBox();
		cmbMuniMarca.setCaption("Marca");
		cmbMuniMarca.setImmediate(false);
		cmbMuniMarca.setWidth("280px");
		cmbMuniMarca.setHeight("-1px");
		cmbMuniMarca.setRequired(true);
		pnlMunicionesBody1.addComponent(cmbMuniMarca);
		
		return pnlMunicionesBody1;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlMunicionesBody2() {
		// common part: create layout
		pnlMunicionesBody2 = new HorizontalLayout();
		pnlMunicionesBody2.setImmediate(false);
		pnlMunicionesBody2.setWidth("-1px");
		pnlMunicionesBody2.setHeight("-1px");
		pnlMunicionesBody2.setMargin(false);
		pnlMunicionesBody2.setSpacing(true);
		
		// rbTipoPersona
		rbTipoPersona = new OptionGroup();
		rbTipoPersona.setStyleName("horizontal");
		rbTipoPersona.setCaption("Tipo ");
		rbTipoPersona.setImmediate(false);
		rbTipoPersona.setWidth("200px");
		rbTipoPersona.setHeight("25px");
		pnlMunicionesBody2.addComponent(rbTipoPersona);
		
		// cmbMuniPersonaIncautada
		cmbMuniPersonaIncautada = new ComboBox();
		cmbMuniPersonaIncautada.setCaption("Persona incautada");
		cmbMuniPersonaIncautada.setImmediate(false);
		cmbMuniPersonaIncautada.setWidth("300px");
		cmbMuniPersonaIncautada.setHeight("-1px");
		pnlMunicionesBody2.addComponent(cmbMuniPersonaIncautada);
		
		return pnlMunicionesBody2;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlMunicionesBody3() {
		// common part: create layout
		pnlMunicionesBody3 = new HorizontalLayout();
		pnlMunicionesBody3.setImmediate(false);
		pnlMunicionesBody3.setWidth("-1px");
		pnlMunicionesBody3.setHeight("-1px");
		pnlMunicionesBody3.setMargin(false);
		pnlMunicionesBody3.setSpacing(true);
		
		// txtMuniDescripcion
		txtMuniDescripcion = new TextField();
		txtMuniDescripcion.setCaption("Descripción");
		txtMuniDescripcion.setImmediate(false);
		txtMuniDescripcion.setWidth("550px");
		txtMuniDescripcion.setHeight("-1px");
		txtMuniDescripcion.setRequired(true);
		txtMuniDescripcion.setInputPrompt("Descripción");
		pnlMunicionesBody3.addComponent(txtMuniDescripcion);
		
		return pnlMunicionesBody3;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlMunicionesBody4() {
		// common part: create layout
		pnlMunicionesBody4 = new HorizontalLayout();
		pnlMunicionesBody4.setImmediate(false);
		pnlMunicionesBody4.setWidth("-1px");
		pnlMunicionesBody4.setHeight("-1px");
		pnlMunicionesBody4.setMargin(false);
		pnlMunicionesBody4.setSpacing(true);
		
		// cmbMuniTipoMedida
		cmbMuniTipoMedida = new ComboBox();
		cmbMuniTipoMedida.setCaption("Tipo de Medida");
		cmbMuniTipoMedida.setImmediate(false);
		cmbMuniTipoMedida.setWidth("-1px");
		cmbMuniTipoMedida.setHeight("-1px");
		pnlMunicionesBody4.addComponent(cmbMuniTipoMedida);
		
		// txtMuniMedida
		txtMuniMedida = new TextField();
		txtMuniMedida.setCaption("Medida");
		txtMuniMedida.setImmediate(false);
		txtMuniMedida.setWidth("155px");
		txtMuniMedida.setHeight("-1px");
		txtMuniMedida.setInputPrompt("Unidad de medida");
		pnlMunicionesBody4.addComponent(txtMuniMedida);
		
		// txtCantidad
		txtCantidad = new TextField();
		txtCantidad.setCaption("Cantidad");
		txtCantidad.setImmediate(false);
		txtCantidad.setWidth("-1px");
		txtCantidad.setHeight("-1px");
		txtCantidad.setInputPrompt("Cantidad");
		pnlMunicionesBody4.addComponent(txtCantidad);
		
		// cmbMuniEstado
		cmbMuniEstado = new ComboBoxLOVS();
		cmbMuniEstado.setCaption("Estado");
		cmbMuniEstado.setImmediate(false);
		cmbMuniEstado.setWidth("200px");
		cmbMuniEstado.setHeight("-1px");
		pnlMunicionesBody4.addComponent(cmbMuniEstado);
		
		// cmbMuniSituacion
		cmbMuniSituacion = new ComboBoxLOVS();
		cmbMuniSituacion.setCaption("Situacion");
		cmbMuniSituacion.setImmediate(false);
		cmbMuniSituacion.setWidth("200px");
		cmbMuniSituacion.setHeight("-1px");
		pnlMunicionesBody4.addComponent(cmbMuniSituacion);
		
		return pnlMunicionesBody4;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlMunicionesBody5() {
		// common part: create layout
		pnlMunicionesBody5 = new HorizontalLayout();
		pnlMunicionesBody5.setImmediate(false);
		pnlMunicionesBody5.setWidth("-1px");
		pnlMunicionesBody5.setHeight("-1px");
		pnlMunicionesBody5.setMargin(false);
		
		// txtMuniObservacion
		txtMuniObservacion = new TextArea();
		txtMuniObservacion.setCaption("Observación");
		txtMuniObservacion.setImmediate(false);
		txtMuniObservacion.setWidth("900px");
		txtMuniObservacion.setHeight("80px");
		txtMuniObservacion.setInputPrompt("Observaciones");
		txtMuniObservacion.setMaxLength(500);
		pnlMunicionesBody5.addComponent(txtMuniObservacion);
		
		return pnlMunicionesBody5;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlMunicionesBody6() {
		// common part: create layout
		pnlMunicionesBody6 = new HorizontalLayout();
		pnlMunicionesBody6.setImmediate(false);
		pnlMunicionesBody6.setWidth("-1px");
		pnlMunicionesBody6.setHeight("-1px");
		pnlMunicionesBody6.setMargin(false);
		
		// btnMuniRegistrar
		btnMuniRegistrar = new Button();
		btnMuniRegistrar.setCaption("Registrar");
		btnMuniRegistrar.setImmediate(true);
		btnMuniRegistrar.setWidth("-1px");
		btnMuniRegistrar.setHeight("-1px");
		pnlMunicionesBody6.addComponent(btnMuniRegistrar);
		
		return pnlMunicionesBody6;
	}

}
