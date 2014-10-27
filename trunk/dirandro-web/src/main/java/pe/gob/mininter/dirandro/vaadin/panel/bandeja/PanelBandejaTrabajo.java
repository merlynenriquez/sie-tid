package pe.gob.mininter.dirandro.vaadin.panel.bandeja;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.Droga;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.service.ExpedienteService;
import pe.gob.mininter.dirandro.util.FormBandejaTrabajo;
import pe.gob.mininter.dirandro.vaadin.panel.PanelDetalleDroga;
import pe.gob.mininter.dirandro.vaadin.panel.parte.PanelRegistroAtestado;
import pe.gob.mininter.dirandro.vaadin.panel.parte.PanelRegistroParte;
import pe.gob.mininter.dirandro.vaadin.util.DirandroComponent;
import pe.gob.mininter.dirandro.vaadin.util.Injector;
import pe.gob.mininter.dirandro.vaadin.util.TablaFiltro;
import pe.gob.mininter.dirandro.vaadin.util.container.TablaFiltroIndexedContainer;
import pe.gob.mininter.dirandro.vaadin.util.container.TablaFiltroIndexedContainer.TipoComponente;
import pe.gob.mininter.dirandro.vaadin.util.event.TablaFiltroEnterEvent;
import pe.gob.mininter.dirandro.vaadin.util.listener.TablaFiltroEnterListener;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class PanelBandejaTrabajo extends DirandroComponent implements TablaFiltroEnterListener, ClickListener {

	@AutoGenerated
	private VerticalLayout mainLayout;

	@AutoGenerated
	private TablaFiltro tblBandeja;

	@AutoGenerated
	private HorizontalLayout lytBotonera;

	@AutoGenerated
	private Button btnBuscar;

	private static final String COLUMNA_AUTOGENERADO = "autogenerado";
	private static final String COLUMNA_NOMBRE_CASO = "nombreCaso";
	private static final String COLUMNA_TIPO_HECHO = "tipoHecho";
	private static final String COLUMNA_DEPENDENCIA = "dependencia";
	private static final String COLUMNA_TIPO_FINALIDAD = "tipoFinalidad";
	private static final String COLUMNA_INTEGRANTE = "integrante";
	private static final String COLUMNA_FECHA_REGISTRO = "fechaRegistro";
	private static final String COLUMNA_DIAS_ATENCION = "diasAtencion";
	private static final String COLUMNA_LUGAR_HECHO = "lugarHecho";
	private static final String COLUMNA_JURISDICCION = "jurisdiccionHecho";
	private static final String COLUMNA_EXPEDIENTE = "expediente";
	
	private static final String COLUMN_DETALLE = "atestado";
	
	private static final Action MODIFICAR_EXPEDIENTE = new Action("Modificar Expediente");
	private static final Action EXPORTAR_EXPEDIENTE = new Action("Exportar Expediente");
	private static final Action[] ITEM_ACTIONS = new Action[] { MODIFICAR_EXPEDIENTE , EXPORTAR_EXPEDIENTE};
	
	private Action[] action = new Action[] {};

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3860689794611254325L;
	
	private TablaFiltroIndexedContainer container;
	
	private ExpedienteService expedienteService;	
	
	private List<Opcion> acciones;

	

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelBandejaTrabajo(List<Opcion> acciones, String height) {
		super(acciones, height);
		
		this.acciones = acciones;
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		
		expedienteService = Injector.obtenerServicio(ExpedienteService.class);

		postConstruct();
	}

	@Override
	public void postConstruct() {
		container = new TablaFiltroIndexedContainer();
		container.addContainerProperty(COLUMNA_AUTOGENERADO, String.class, StringUtils.EMPTY, "Autogenerado", TipoComponente.TEXT, true, 100);
		container.addContainerProperty(COLUMNA_NOMBRE_CASO, String.class, StringUtils.EMPTY, "Caso", TipoComponente.TEXT, true, 100);
		container.addContainerProperty(COLUMNA_TIPO_HECHO, String.class, StringUtils.EMPTY, "Tipo de Hecho", TipoComponente.TEXT, true, 100);
		container.addContainerProperty(COLUMNA_DEPENDENCIA, String.class, StringUtils.EMPTY, "Dependencia", TipoComponente.TEXT, true, 100);
		container.addContainerProperty(COLUMNA_TIPO_FINALIDAD, String.class, StringUtils.EMPTY, "Tipo de Finalidad", TipoComponente.TEXT, true, 110);
		container.addContainerProperty(COLUMNA_INTEGRANTE, String.class, StringUtils.EMPTY, "Integrante", TipoComponente.TEXT, true, 110);
		container.addContainerProperty(COLUMNA_FECHA_REGISTRO, Date.class, null, "Fecha Registro", TipoComponente.DATEPICKER, false, 120);
		container.addContainerProperty(COLUMNA_DIAS_ATENCION, Integer.class, null, "Días Atención", TipoComponente.TEXT, false, 120);
		container.addContainerProperty(COLUMNA_LUGAR_HECHO, String.class, StringUtils.EMPTY, "Lugar Hecho", TipoComponente.TEXT, true, 180);
		container.addContainerProperty(COLUMNA_JURISDICCION, String.class, StringUtils.EMPTY, "Jurisdicción", TipoComponente.TEXT, true, 100);
		container.addContainerProperty(COLUMNA_EXPEDIENTE, Expediente.class, null);
		container.addContainerProperty(COLUMN_DETALLE, Button.class, StringUtils.EMPTY, "Gen. Atestado", TipoComponente.LABEL, true, 120);
					
		tblBandeja.setContainerDataSource(container);
		tblBandeja.setColumnCollapsingAllowed(true);
		tblBandeja.setColumnReorderingAllowed(true);
		tblBandeja.setSelectable(true);
		tblBandeja.addListener((TablaFiltroEnterListener)this);
		
		tblBandeja.setImmediate(true);
		
		buscarExpedientes(new HashMap<String, Object>());
		
		btnBuscar.addListener((ClickListener) this);
		
		tblBandeja.addListener(new ValueChangeListener() {

			/**
			 * 
			 */
			private static final long serialVersionUID = -7070222690010564544L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				
				Integer value = (Integer) event.getProperty().getValue();
				
				tblBandeja.removeAllActionHandlers();
				
				if (value != null) {
					action = ITEM_ACTIONS;
					asignaActionHandler();
				} 

				tblBandeja.requestRepaintTable();
			}
		});		
	}

	private void asignaActionHandler() {
		tblBandeja.addActionHandler(new Handler() {

			/**
			 * 
			 */
			private static final long serialVersionUID = -6373252406881569655L;

			@Override
			public void handleAction(Action action, Object sender, Object target) {

				if (action.equals(MODIFICAR_EXPEDIENTE)) {
					
					Object objID = tblBandeja.getValue();
					
					Item item = container.getItem(objID);
					
					Expediente expedienteGrilla = (Expediente)item.getItemProperty(COLUMNA_EXPEDIENTE).getValue();
					
					Expediente expediente = expedienteService.obtener(expedienteGrilla.getId());
					
					PanelRegistroParte panelRegistroParte = new PanelRegistroParte(acciones, "-1px");
					panelRegistroParte.setExpediente(expediente);					
					
					Window wdExpediente = new Window();
					
					wdExpediente.setModal(false);
					wdExpediente.setResizable(false);
					wdExpediente.addComponent(panelRegistroParte);
						
					wdExpediente.setCaption("Modificar Expediente");
					wdExpediente.setWidth("1050px");
					getWindow().addWindow(wdExpediente);
				}
			}

			@Override
			public Action[] getActions(Object target, Object sender) {
				return action;
			}
		});
	}

	private void buscarExpedientes(Map<String, Object> map) {

		FormBandejaTrabajo form = new FormBandejaTrabajo();
		form.setAutogenerado((String)map.get(COLUMNA_AUTOGENERADO));
		form.setCaso((String)map.get(COLUMNA_NOMBRE_CASO));
		form.setTipoHecho((String)map.get(COLUMNA_TIPO_HECHO));
		form.setDependencia((String)map.get(COLUMNA_DEPENDENCIA));
		form.setTipoFinalidad((String)map.get(COLUMNA_TIPO_FINALIDAD));
		form.setIntegrante((String)map.get(COLUMNA_INTEGRANTE));
		form.setFechaRegInicio((Date)map.get(COLUMNA_FECHA_REGISTRO+TablaFiltro.KEY_INICIAL));
		form.setFechaRegFinal((Date)map.get(COLUMNA_FECHA_REGISTRO+TablaFiltro.KEY_FINAL));
		form.setDiasInicio(
				StringUtils.isNotEmpty((String)map.get(COLUMNA_DIAS_ATENCION+TablaFiltro.KEY_INICIAL))
					&& StringUtils.isNumeric((String)map.get(COLUMNA_DIAS_ATENCION+TablaFiltro.KEY_INICIAL))
				?
					new Integer(StringUtils.trimToEmpty((String)map.get(COLUMNA_DIAS_ATENCION+TablaFiltro.KEY_INICIAL)))
				:
					null
				
				);
		form.setDiasFinal(
				StringUtils.isNotEmpty((String)map.get(COLUMNA_DIAS_ATENCION+TablaFiltro.KEY_FINAL))
					&& StringUtils.isNumeric((String)map.get(COLUMNA_DIAS_ATENCION+TablaFiltro.KEY_FINAL))
				?
					new Integer(StringUtils.trimToEmpty((String)map.get(COLUMNA_DIAS_ATENCION+TablaFiltro.KEY_FINAL)))
				:
					null
				
				);
		form.setLugarHecho((String)map.get(COLUMNA_LUGAR_HECHO));
		form.setJurisdiccion((String)map.get(COLUMNA_JURISDICCION));
		
		List<Expediente> expedientes = expedienteService.obtenerBandejaDeTrabajo(form);
		
		container.removeAllItems();
		int con = 0;
		for (Expediente expediente : expedientes) {
			Item item = container.addItem(con++);
			item.getItemProperty(COLUMNA_AUTOGENERADO).setValue(expediente.getAutogenerado());
			item.getItemProperty(COLUMNA_NOMBRE_CASO).setValue(expediente.getNombreCaso());
			item.getItemProperty(COLUMNA_TIPO_HECHO).setValue(expediente.getTipoHecho() != null ? expediente.getTipoHecho().getNombre() : StringUtils.EMPTY);
			item.getItemProperty(COLUMNA_DEPENDENCIA).setValue(expediente.getDependencia() != null ? expediente.getDependencia().getNombre() : StringUtils.EMPTY);
			item.getItemProperty(COLUMNA_TIPO_FINALIDAD).setValue(expediente.getTipoFinalidad() != null ? expediente.getTipoFinalidad().getNombre() : StringUtils.EMPTY);
			//item.getItemProperty(COLUMNA_INTEGRANTE).setValue(expediente.getIntegrante() != null ? expediente.getIntegrante().getUsuario().getNombreCompleto() : StringUtils.EMPTY);
			item.getItemProperty(COLUMNA_FECHA_REGISTRO).setValue(expediente.getFechaRegistro());
			item.getItemProperty(COLUMNA_DIAS_ATENCION).setValue(expediente.getDiasAtencion());
			item.getItemProperty(COLUMNA_LUGAR_HECHO).setValue(expediente.getLugarHecho() != null ? expediente.getLugarHecho().getNombreCompleto() : StringUtils.EMPTY);
			item.getItemProperty(COLUMNA_JURISDICCION).setValue(expediente.getJurisdiccion() != null ? expediente.getJurisdiccion().getNombre() : StringUtils.EMPTY);
			item.getItemProperty(COLUMNA_EXPEDIENTE).setValue(expediente);	
			Button detalle = new Button();
			detalle.setCaption("Detalle");
			detalle.setData(expediente);
			detalle.addListener(new ClickListener() {
				
				private static final long serialVersionUID = 688255660681167152L;

				@Override
				public void buttonClick(ClickEvent event) {
					PanelRegistroAtestado panelAtestado = new PanelRegistroAtestado();
					//panelAtestado.setPericia(p);
					
					Window wdHojaRemision = new Window();
					
					wdHojaRemision.setModal(false);
					wdHojaRemision.setResizable(false);
					wdHojaRemision.addComponent(panelAtestado);
						
					wdHojaRemision.setCaption("Registro de Atestado");
					wdHojaRemision.setWidth("500px");
					getApplication().getMainWindow().addWindow(wdHojaRemision);
				}
			});
			item.getItemProperty(COLUMN_DETALLE).setValue(detalle);
		}
		
	}

	@Override
	public void handleEnterAction(TablaFiltroEnterEvent event) {
		buscarExpedientes(event.getDatos());
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnBuscar)) {
			buscarExpedientes(tblBandeja.getValues());
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
		mainLayout.setSpacing(true);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// lytBotonera
		lytBotonera = buildLytBotonera();
		mainLayout.addComponent(lytBotonera);
		
		// tblBandeja
		tblBandeja = new TablaFiltro();
		tblBandeja.setImmediate(false);
		tblBandeja.setWidth("100.0%");
		tblBandeja.setHeight("100.0%");
		mainLayout.addComponent(tblBandeja);
		mainLayout.setExpandRatio(tblBandeja, 1.0f);
		
		return mainLayout;
	}

	@AutoGenerated
	private HorizontalLayout buildLytBotonera() {
		// common part: create layout
		lytBotonera = new HorizontalLayout();
		lytBotonera.setImmediate(false);
		lytBotonera.setWidth("100.0%");
		lytBotonera.setHeight("-1px");
		lytBotonera.setMargin(false);
		
		// btnBuscar
		btnBuscar = new Button();
		btnBuscar.setCaption("Buscar");
		btnBuscar.setImmediate(true);
		btnBuscar.setWidth("-1px");
		btnBuscar.setHeight("-1px");
		lytBotonera.addComponent(btnBuscar);
		
		return lytBotonera;
	}

}
