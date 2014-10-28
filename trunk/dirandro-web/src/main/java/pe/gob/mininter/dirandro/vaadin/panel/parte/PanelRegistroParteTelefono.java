package pe.gob.mininter.dirandro.vaadin.panel.parte;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.DetExpedientePersona;
import pe.gob.mininter.dirandro.model.DetPerTelExp;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.Numero;
import pe.gob.mininter.dirandro.model.Persona;
import pe.gob.mininter.dirandro.model.Telefono;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.ExpedientePersonaService;
import pe.gob.mininter.dirandro.service.ExpedienteTelefonoService;
import pe.gob.mininter.dirandro.service.NumeroService;
import pe.gob.mininter.dirandro.service.PersonaService;
import pe.gob.mininter.dirandro.service.TelefonoService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;
import pe.gob.mininter.dirandro.vaadin.panel.util.PanelAgregarNumero;
import pe.gob.mininter.dirandro.vaadin.panel.util.PanelAgregarTelefono;
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
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class PanelRegistroParteTelefono extends CustomComponent implements ClickListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	
	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlPrincipal;
	@AutoGenerated
	private Table tblTelLista;
	@AutoGenerated
	private Button btnRegistrar;
	@AutoGenerated
	private TextArea txaObservacion;
	@AutoGenerated
	private HorizontalLayout pnlTelefonos2;
	@AutoGenerated
	private ComboBoxLOVS cmbOperadora;
	@AutoGenerated
	private ComboBoxLOVS cmbSituacion;
	@AutoGenerated
	private ComboBoxLOVS cmbEstado;
	@AutoGenerated
	private ComboBox cmbPropietario;
	@AutoGenerated
	private ComboBox cmbPersonaImplicada;
	@AutoGenerated
	private HorizontalLayout pnlTelefonos1;
	@AutoGenerated
	private Button btnRegistrarEquipo;
	@AutoGenerated
	private ComboBox cmbEquipo;
	@AutoGenerated
	private Button btnRegistrarTelefono;
	@AutoGenerated
	private ComboBox cmbNumeroTel;
	private static final long serialVersionUID = 5025374354898750230L;
	
	private ExpedientePersonaService expPersonaService;
	private NumeroService numeroService;
	private PersonaService personaService;
	private ExpedienteTelefonoService expTelefonoService;
	private TelefonoService telefonoService;
	private Expediente expediente;

	private List<Persona> lstPropietarios;
	private PanelAgregarTelefono pnlAgregarTelefono;
	private PanelAgregarNumero pnlAgregarNumero;
	private boolean inicializado=false;
	private DetPerTelExp detTelefono;
	private DetExpedientePersona detPersona;
	
	public PanelRegistroParteTelefono() {
		buildMainLayout();
		expTelefonoService = Injector.obtenerServicio(ExpedienteTelefonoService.class);
		numeroService = Injector.obtenerServicio(NumeroService.class);
		personaService = Injector.obtenerServicio(PersonaService.class);
		expPersonaService = Injector.obtenerServicio(ExpedientePersonaService.class);
		telefonoService = Injector.obtenerServicio(TelefonoService.class);
		setCompositionRoot(mainLayout);
		postConstruct();
	}
	
	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
		this.detTelefono=new DetPerTelExp();
		this.detTelefono.setExpediente(expediente);
		this.detPersona=new DetExpedientePersona();
		this.detPersona.setExpediente(expediente);
		postConstruct();
	}

	public void postConstruct() {
		if(expediente!=null && !expediente.esNuevo() && !inicializado){
			lstPropietarios =  personaService.buscar(null);
			cmbEquipo.setInputPrompt("Equipo Incautado");
			cmbEstado.setInputPrompt("Estado del Bien");
			cmbNumeroTel.setInputPrompt("Nro de Teléfono");
			cmbOperadora.setInputPrompt("Operadora");
			cmbPersonaImplicada.setInputPrompt("Persona Implicada con el Número");
			cmbPropietario.setInputPrompt("Propietario del Equipo");
			cmbSituacion.setInputPrompt("Situacion del Bien");
			cmbEquipo.setInputPrompt("Seleccionar Equipo por Serie");
			
			cmbEstado.setRequired(true);
			cmbSituacion.setRequired(true);
			
			cmbSituacion.setCodigoLista(Constante.LISTA.CODIGO.SITUACION_GENERAL);
			cmbSituacion.attach();
			cmbEstado.setCodigoLista(Constante.LISTA.CODIGO.ESTADO_OBJETOS);
			cmbEstado.attach();
			cmbOperadora.setCodigoLista(Constante.LISTA.CODIGO.OPERADORA);
			cmbOperadora.attach();
			
			btnRegistrar.addListener((ClickListener) this);
			btnRegistrarEquipo.addListener((ClickListener) this);
			btnRegistrarTelefono.addListener((ClickListener) this);
			actualizarTelefonos(null);
			actualizarNumeros(null);
			
			cargarNumeros();
			cargarInvolucrados();		
			cargarInvolucrados(lstPropietarios);
			refrescar();
			
			tblTelLista.setSelectable(true);
			tblTelLista.setImmediate(true);
			tblTelLista.setNullSelectionAllowed(true);
			tblTelLista.setNullSelectionItemId(null);
			tblTelLista.addListener(new ValueChangeListener() {
				
				private static final long serialVersionUID = -5711137860826729012L;

				@Override
				public void valueChange(ValueChangeEvent event) {
					boolean esModoNuevo = tblTelLista.getValue() == null;
					habilitarEdicion(!esModoNuevo);
					limpiar();
					if(esModoNuevo){
						tblTelLista.setValue(null);
					}else{
						Item item = tblTelLista.getItem(tblTelLista.getValue());
						detTelefono.setId((Long) item.getItemProperty("id").getValue());
						txaObservacion.setValue(item.getItemProperty("observacion").getValue());
						cmbSituacion.select(new Valor((Long) item.getItemProperty("situacion.id").getValue()));
						cmbEstado.select(new Valor((Long) item.getItemProperty("estado.id").getValue()));
						cmbOperadora.select(new Valor((Long) item.getItemProperty("operadora.id").getValue()));
						cmbNumeroTel.select(new Valor((Long)item.getItemProperty("operadora.id").getValue()));
						cmbEquipo.select((Telefono) item.getItemProperty("equipo").getValue());
						cmbNumeroTel.select((Numero) item.getItemProperty("numero").getValue());
						cmbPersonaImplicada.select((DetExpedientePersona) item.getItemProperty("implicado").getValue());
						cmbPropietario.select((Persona) item.getItemProperty("propietario").getValue());
					}
				}
			});
			inicializado=true;
		}
	}
	
	private void cargarNumeros() {
		List<Numero> lstNumeros = numeroService.buscar(null);
		cmbNumeroTel.setContainerDataSource(new BeanItemContainer<Numero>(Numero.class,  lstNumeros));
		cmbNumeroTel.setItemCaptionPropertyId("numero");
		cmbNumeroTel.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
	}

	private void cargarInvolucrados() {
		List<DetExpedientePersona> lstInvolucrados = expPersonaService.buscar(detPersona);
		cmbPersonaImplicada.setContainerDataSource(new BeanItemContainer<DetExpedientePersona>(DetExpedientePersona.class,  lstInvolucrados));
		cmbPersonaImplicada.setItemCaptionPropertyId("nombreCompleto");
		cmbPersonaImplicada.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
	}
	
	private void cargarInvolucrados(List<Persona> lstInvolucrados){
		cmbPropietario.setContainerDataSource(new BeanItemContainer<Persona>(Persona.class,  lstInvolucrados));
		cmbPropietario.setItemCaptionPropertyId("nombreCompleto");
		cmbPropietario.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
		cmbPropietario.setImmediate(true);
	}

	private void cargarExpTelefonos(List<DetPerTelExp> lstExpTelefonos) {
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("id", Long.class,  null);
		container.addContainerProperty("implicado", DetExpedientePersona.class, null);
		container.addContainerProperty("propietario", Persona.class, null);
		container.addContainerProperty("implicado.nombre", String.class, null);
		container.addContainerProperty("operadora", Valor.class, null);
		container.addContainerProperty("operadora.id", Long.class, null);
		container.addContainerProperty("operadora.nombre", String.class, null);
		container.addContainerProperty("situacion", Valor.class, null);
		container.addContainerProperty("situacion.id", Long.class, null);
		container.addContainerProperty("situacion.nombre", String.class, null);
		container.addContainerProperty("estado", Valor.class, null);
		container.addContainerProperty("estado.id", Long.class, null);
		container.addContainerProperty("estado.nombre", String.class, null);
		container.addContainerProperty("equipo", Telefono.class, null);
		container.addContainerProperty("numero", Numero.class, null);
		container.addContainerProperty("observacion", String.class, null);
		
		tblTelLista.setContainerDataSource(container);
		tblTelLista.setVisibleColumns(new Object[]{"id","implicado.nombre","operadora.nombre","situacion.nombre","estado.nombre"});
		
		int con=1;
		for (DetPerTelExp expTelefono : lstExpTelefonos){
			Item item = container.addItem(con++);
			item.getItemProperty("id").setValue(expTelefono.getId());
			item.getItemProperty("implicado").setValue(expTelefono.getImplicado());
			item.getItemProperty("propietario").setValue(expTelefono.getPropietario());
			item.getItemProperty("implicado.nombre").setValue(expTelefono.getImplicado()!=null?expTelefono.getImplicado().getNombreCompleto():StringUtils.EMPTY);
			item.getItemProperty("operadora.id").setValue(expTelefono.getOperadora() != null ? expTelefono.getOperadora().getId() : null);
			item.getItemProperty("operadora.nombre").setValue(expTelefono.getOperadora() != null ? expTelefono.getOperadora().getNombre() : null);
			item.getItemProperty("situacion.id").setValue(HarecUtil.valorIdToEmpty( expTelefono.getSituacion()));
			item.getItemProperty("situacion.nombre").setValue(HarecUtil.valorNombreToEmpty(expTelefono.getSituacion()));
			item.getItemProperty("estado.id").setValue(HarecUtil.valorIdToEmpty(expTelefono.getEstado()));
			item.getItemProperty("estado.nombre").setValue(HarecUtil.valorNombreToEmpty(expTelefono.getEstado()));
			item.getItemProperty("equipo").setValue(expTelefono.getEquipo());
			item.getItemProperty("numero").setValue(expTelefono.getNumeroTelefonico());
			item.getItemProperty("observacion").setValue(HarecUtil.nullToEmpty( expTelefono.getObservacion() ));
		}
	}
	
	public void refrescar(){
		habilitarEdicion(false);
		limpiar();
		cargarExpTelefonos(expTelefonoService.buscar(null));
	}

	private void habilitarEdicion(boolean flag) {
		if(flag){
			btnRegistrar.setCaption("Actualizar");
		}else{
			btnRegistrar.setCaption("Crear");
		}
	}

	public void actualizarTelefonos(Telefono telefono) {
		cargarTelefonos(telefonoService.buscar(null));
		
		if (telefono != null) {
			cmbEquipo.select(telefono);
		}
	}

	public void actualizarNumeros(Numero numero) {
		cargarNumeros(numeroService.buscar(null));
		
		if (numero != null) {
			cmbNumeroTel.select(numero);
		}
	}
	
	private void cargarNumeros(List<Numero> lstNumeros) {
		cmbNumeroTel.setContainerDataSource(new BeanItemContainer<Numero>(Numero.class,  lstNumeros));
		cmbNumeroTel.setItemCaptionPropertyId("numero");
	}
	
	private void cargarTelefonos(List<Telefono> lstTelefonos) {
		cmbEquipo.setContainerDataSource(new BeanItemContainer<Telefono>(Telefono.class,  lstTelefonos));
		cmbEquipo.setItemCaptionPropertyId("imei");
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnRegistrarEquipo)){			
			pnlAgregarTelefono = new PanelAgregarTelefono();
			pnlAgregarTelefono.setPadre(this);
			
			if(this.getParent().getParent()!=null){
				pnlAgregarTelefono.setParent(this.getParent().getParent());
			}else{
				pnlAgregarTelefono.setParent(this.getParent());
			}
			
			Window window=new Window(){
				
				private static final long serialVersionUID = 1L;

				  protected void close() {
					  getApplication().getMainWindow().removeWindow(getWindow());
				  }};
			window.setCaption("Registrar Teléfono");
			window.addComponent(pnlAgregarTelefono);
			window.setModal(true);
			window.setResizable(false);
			window.setWidth("550px");
			window.setHeight("-1px");
			getApplication().getMainWindow().addWindow(window);
		}
		if(event.getButton().equals(btnRegistrarTelefono)){			
			pnlAgregarNumero = new PanelAgregarNumero();
			pnlAgregarNumero.setPadre(this);
			
			if(this.getParent().getParent()!=null){
				pnlAgregarNumero.setParent(this.getParent().getParent());
			}else{
				pnlAgregarNumero.setParent(this.getParent());
			}
			
			Window window=new Window(){
				
				private static final long serialVersionUID = 1L;

				  protected void close() {
					  getApplication().getMainWindow().removeWindow(getWindow());
				  }};
			window.setCaption("Registrar Número");
			window.addComponent(pnlAgregarNumero);
			window.setModal(true);
			window.setResizable(false);
			window.setWidth("550px");
			window.setHeight("-1px");
			getApplication().getMainWindow().addWindow(window);
			
		}
		if(event.getButton().equals(btnRegistrar)) {
			detTelefono.setEstado((Valor) cmbEstado.getValue());
			detTelefono.setSituacion((Valor) cmbSituacion.getValue());
			detTelefono.setImplicado((DetExpedientePersona) cmbPersonaImplicada.getValue());
			detTelefono.setPropietario((Persona) cmbPropietario.getValue());
			detTelefono.setOperadora((Valor) cmbOperadora.getValue());
			detTelefono.setExpediente(expediente);
			detTelefono.setNumeroTelefonico((Numero) cmbNumeroTel.getValue());
			detTelefono.setObservacion(txaObservacion.getValue().toString());
			detTelefono.setEquipo(cmbEquipo.getValue() != null ? (Telefono) cmbEquipo.getValue() : null);
			
			if(detTelefono.esNuevo()) {
				expTelefonoService.crear(detTelefono);
			} else {
				expTelefonoService.actualizar(detTelefono);
			}
			refrescar();
		}
	}
	
	private void limpiar() {
		detTelefono = new DetPerTelExp();
		detTelefono.setExpediente(expediente);
		cmbEquipo.select(null);
		cmbEstado.select(null);
		cmbNumeroTel.select(null);
		cmbOperadora.select(null);
		cmbPersonaImplicada.select(null);
		cmbPropietario.select(null);
		cmbSituacion.select(null);
		txaObservacion.setValue("");
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
		pnlPrincipal.setImmediate(false);
		pnlPrincipal.setWidth("-1px");
		pnlPrincipal.setHeight("-1px");
		pnlPrincipal.setMargin(true);
		pnlPrincipal.setSpacing(true);
		
		// pnlTelefonos1
		pnlTelefonos1 = buildPnlTelefonos1();
		pnlPrincipal.addComponent(pnlTelefonos1);
		
		// pnlTelefonos2
		pnlTelefonos2 = buildPnlTelefonos2();
		pnlPrincipal.addComponent(pnlTelefonos2);
		
		// txaObservacion
		txaObservacion = new TextArea();
		txaObservacion.setCaption("Observación");
		txaObservacion.setImmediate(false);
		txaObservacion.setWidth("870px");
		txaObservacion.setHeight("70px");
		txaObservacion
				.setInputPrompt("Observaciones adicionales al Equipo o Numero Incautado");
		pnlPrincipal.addComponent(txaObservacion);
		
		// btnRegistrar
		btnRegistrar = new Button();
		btnRegistrar.setCaption("Registrar");
		btnRegistrar.setImmediate(true);
		btnRegistrar.setWidth("-1px");
		btnRegistrar.setHeight("-1px");
		pnlPrincipal.addComponent(btnRegistrar);
		pnlPrincipal.setComponentAlignment(btnRegistrar, new Alignment(20));
		
		// tblTelLista
		tblTelLista = new Table();
		tblTelLista.setImmediate(false);
		tblTelLista.setWidth("900px");
		tblTelLista.setHeight("350px");
		pnlPrincipal.addComponent(tblTelLista);
		
		return pnlPrincipal;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlTelefonos1() {
		// common part: create layout
		pnlTelefonos1 = new HorizontalLayout();
		pnlTelefonos1.setImmediate(false);
		pnlTelefonos1.setWidth("-1px");
		pnlTelefonos1.setHeight("-1px");
		pnlTelefonos1.setMargin(false);
		pnlTelefonos1.setSpacing(true);
		
		// cmbNumeroTel
		cmbNumeroTel = new ComboBox();
		cmbNumeroTel.setCaption("Nro Telefónico");
		cmbNumeroTel.setImmediate(false);
		cmbNumeroTel.setWidth("250px");
		cmbNumeroTel.setHeight("-1px");
		cmbNumeroTel.setRequired(true);
		pnlTelefonos1.addComponent(cmbNumeroTel);
		
		// btnRegistrarTelefono
		btnRegistrarTelefono = new Button();
		btnRegistrarTelefono.setCaption("Agregar Número");
		btnRegistrarTelefono.setImmediate(true);
		btnRegistrarTelefono.setWidth("-1px");
		btnRegistrarTelefono.setHeight("-1px");
		pnlTelefonos1.addComponent(btnRegistrarTelefono);
		pnlTelefonos1.setComponentAlignment(btnRegistrarTelefono,
				new Alignment(10));
		
		// cmbEquipo
		cmbEquipo = new ComboBox();
		cmbEquipo.setCaption("Equipo Telefónico");
		cmbEquipo.setImmediate(false);
		cmbEquipo.setWidth("200px");
		cmbEquipo.setHeight("-1px");
		pnlTelefonos1.addComponent(cmbEquipo);
		
		// btnRegistrarEquipo
		btnRegistrarEquipo = new Button();
		btnRegistrarEquipo.setCaption("Agregar Equipo");
		btnRegistrarEquipo.setImmediate(true);
		btnRegistrarEquipo.setWidth("-1px");
		btnRegistrarEquipo.setHeight("-1px");
		pnlTelefonos1.addComponent(btnRegistrarEquipo);
		pnlTelefonos1.setComponentAlignment(btnRegistrarEquipo, new Alignment(
				10));
		
		return pnlTelefonos1;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlTelefonos2() {
		// common part: create layout
		pnlTelefonos2 = new HorizontalLayout();
		pnlTelefonos2.setImmediate(false);
		pnlTelefonos2.setWidth("-1px");
		pnlTelefonos2.setHeight("-1px");
		pnlTelefonos2.setMargin(false);
		pnlTelefonos2.setSpacing(true);
		
		// cmbPersonaImplicada
		cmbPersonaImplicada = new ComboBox();
		cmbPersonaImplicada.setCaption("Persona Implicada");
		cmbPersonaImplicada.setImmediate(false);
		cmbPersonaImplicada.setWidth("220px");
		cmbPersonaImplicada.setHeight("-1px");
		pnlTelefonos2.addComponent(cmbPersonaImplicada);
		
		// cmbPropietario
		cmbPropietario = new ComboBox();
		cmbPropietario.setCaption("Dueño");
		cmbPropietario.setImmediate(false);
		cmbPropietario.setWidth("220px");
		cmbPropietario.setHeight("-1px");
		pnlTelefonos2.addComponent(cmbPropietario);
		
		// cmbEstado
		cmbEstado = new ComboBoxLOVS();
		cmbEstado.setCaption("Estado");
		cmbEstado.setImmediate(false);
		cmbEstado.setWidth("120px");
		cmbEstado.setHeight("-1px");
		pnlTelefonos2.addComponent(cmbEstado);
		
		// cmbSituacion
		cmbSituacion = new ComboBoxLOVS();
		cmbSituacion.setCaption("Situación");
		cmbSituacion.setImmediate(false);
		cmbSituacion.setWidth("130px");
		cmbSituacion.setHeight("-1px");
		pnlTelefonos2.addComponent(cmbSituacion);
		
		// cmbOperadora
		cmbOperadora = new ComboBoxLOVS();
		cmbOperadora.setCaption("Operadora");
		cmbOperadora.setImmediate(false);
		cmbOperadora.setWidth("150px");
		cmbOperadora.setHeight("-1px");
		pnlTelefonos2.addComponent(cmbOperadora);
		
		return pnlTelefonos2;
	}

}
