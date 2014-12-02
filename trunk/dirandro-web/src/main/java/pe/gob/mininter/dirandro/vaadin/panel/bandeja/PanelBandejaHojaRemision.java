package pe.gob.mininter.dirandro.vaadin.panel.bandeja;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.Hojaremision;
import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.service.HojaRemisionService;
import pe.gob.mininter.dirandro.vaadin.panel.documento.PanelRegistroHojaRem;
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
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class PanelBandejaHojaRemision extends DirandroComponent implements TablaFiltroEnterListener, ClickListener {

	@AutoGenerated
	private VerticalLayout mainLayout;

	@AutoGenerated
	private Panel panel_1;

	@AutoGenerated
	private VerticalLayout verticalLayout_2;

	@AutoGenerated
	private TablaFiltro tblBandeja;

	@AutoGenerated
	private HorizontalLayout lytBotonera;

	@AutoGenerated
	private Button btnBuscar;

	public static final String COLUMNA_NUMERO = "numero";
	public static final String COLUMNA_TIPO_HR = "tipoHr";
	public static final String COLUMNA_EXPEDIENTE = "expediente";
	public static final String COLUMNA_DEPENDENCIA_REMITE = "dependenciaRemite";
	public static final String COLUMNA_DEPENDENCIA_DESTINO = "dependenciaDestino";
	public static final String COLUMNA_FECHA_EMISION = "fechaEmision";
	public static final String COLUMNA_FECHA_TRASLADO = "fechaTraslado";
	public static final String COLUMNA_PERSONA = "persona";
	public static final String COLUMNA_NRO_LICENCIA = "nroLicencia";
	public static final String COLUMNA_OFICIO = "oficio";
	public static final String COLUMNA_VEHICULO_MARCA = "vehiculoMarca";
	public static final String COLUMNA_VEHICULO_PLACA = "vehiculoPlaca";
	public static final String COLUMNA_MOTIVO_TRASLADO = "motivoTraslado";
	public static final String COLUMNA_FECHA_RECEPCION = "fechaRecepcion";
	public static final String COLUMNA_COSTO_TRASLADO = "costoTraslado";
	public static final String COLUMNA_OBSERVACION = "observacion";
	public static final String COLUMNA_CUSTODIO = "custodio";
	public static final String COLUMNA_HOJA_REMISION = "hojaRemision";
	
	private static final Action MODIFICAR_HOJA_REMISION = new Action("Modificar Hoja Remision");
	private static final Action[] ITEM_ACTIONS = new Action[] { MODIFICAR_HOJA_REMISION };
	
	private Action[] action = new Action[] {};

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3860689794611254325L;
	
	private TablaFiltroIndexedContainer container;
		
	private List<Opcion> acciones;

	private HojaRemisionService hojaRemisionService;
	

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelBandejaHojaRemision(List<Opcion> acciones, String height) {
		super(acciones, height);
		
		this.acciones = acciones;
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		hojaRemisionService = Injector.obtenerServicio(HojaRemisionService.class);
		postConstruct();
	}

	@Override
	public void attach() {
		// TODO Auto-generated method stub
		super.attach();
		verticalLayout_2.setSizeUndefined();
		verticalLayout_2.setHeight("100%");
	}

	@Override
	public void postConstruct() {
		
		container = new TablaFiltroIndexedContainer();
		
		container.addContainerProperty(COLUMNA_NUMERO, String.class, StringUtils.EMPTY, "Número", TipoComponente.TEXT, true, 100);
		container.addContainerProperty(COLUMNA_TIPO_HR, String.class, StringUtils.EMPTY, "Tipo", TipoComponente.TEXT, true, 100);
		container.addContainerProperty(COLUMNA_EXPEDIENTE, String.class, StringUtils.EMPTY, "Expediente", TipoComponente.TEXT, true, 100);
		container.addContainerProperty(COLUMNA_DEPENDENCIA_REMITE, String.class, StringUtils.EMPTY, "Remite", TipoComponente.TEXT, true, 100);
		container.addContainerProperty(COLUMNA_DEPENDENCIA_DESTINO, String.class, StringUtils.EMPTY, "Destino", TipoComponente.TEXT, true, 110);
		container.addContainerProperty(COLUMNA_FECHA_EMISION, Date.class, StringUtils.EMPTY, "Fecha Emision", TipoComponente.DATEPICKER, true, 110);
		container.addContainerProperty(COLUMNA_FECHA_TRASLADO, Date.class, null, "Fecha Traslado", TipoComponente.DATEPICKER, false, 120);
		container.addContainerProperty(COLUMNA_PERSONA, String.class, StringUtils.EMPTY, "Persona", TipoComponente.TEXT, true, 120);
		container.addContainerProperty(COLUMNA_NRO_LICENCIA, String.class, StringUtils.EMPTY, "Nro Licencia", TipoComponente.TEXT, true, 180);
		container.addContainerProperty(COLUMNA_OFICIO, String.class, StringUtils.EMPTY, "Oficio", TipoComponente.TEXT, true, 180);
		container.addContainerProperty(COLUMNA_VEHICULO_MARCA, String.class, StringUtils.EMPTY, "Vehiculo Marca", TipoComponente.TEXT, true, 180);
		container.addContainerProperty(COLUMNA_VEHICULO_PLACA, String.class, StringUtils.EMPTY, "Vehiculo Placa", TipoComponente.TEXT, true, 180);
		container.addContainerProperty(COLUMNA_MOTIVO_TRASLADO, String.class, StringUtils.EMPTY, "Motivo Traslado", TipoComponente.TEXT, true, 180);
		container.addContainerProperty(COLUMNA_FECHA_RECEPCION, String.class, StringUtils.EMPTY, "Fecha Recepcion", TipoComponente.DATEPICKER, true, 180);
		container.addContainerProperty(COLUMNA_COSTO_TRASLADO, String.class, StringUtils.EMPTY, "Costo Traslado", TipoComponente.TEXT, true, 180);
		container.addContainerProperty(COLUMNA_OBSERVACION, String.class, StringUtils.EMPTY, "Observacion", TipoComponente.TEXT, true, 180);
		container.addContainerProperty(COLUMNA_CUSTODIO, String.class, StringUtils.EMPTY, "Custodio", TipoComponente.TEXT, true, 100);
		container.addContainerProperty(COLUMNA_HOJA_REMISION, Hojaremision.class, null);
					
		tblBandeja.setContainerDataSource(container);
		tblBandeja.setColumnCollapsingAllowed(true);
		tblBandeja.setColumnReorderingAllowed(true);
		tblBandeja.setSelectable(true);
		tblBandeja.addListener((TablaFiltroEnterListener)this);
		
		tblBandeja.setImmediate(true);
		
		buscarHojaRemisiones(new HashMap<String, Object>());
		
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
		verticalLayout_2.setSizeUndefined();
		verticalLayout_2.setHeight("100%");
	}

	private void asignaActionHandler() {
		tblBandeja.addActionHandler(new Handler() {

			/**
			 * 
			 */
			private static final long serialVersionUID = -6373252406881569655L;

			@Override
			public void handleAction(Action action, Object sender, Object target) {

				if (action.equals(MODIFICAR_HOJA_REMISION)) {
					
					Object objID = tblBandeja.getValue();
					
					Item item = container.getItem(objID);
					
					Hojaremision hojaremision = (Hojaremision)item.getItemProperty(COLUMNA_HOJA_REMISION).getValue();
										
					PanelRegistroHojaRem panelRegistroHojaRem = new PanelRegistroHojaRem(acciones, "-1px");
					panelRegistroHojaRem.setHojaremision(hojaremision);
					
					Window wdHojaRemision = new Window();
					
					wdHojaRemision.setModal(false);
					wdHojaRemision.setResizable(false);
					wdHojaRemision.addComponent(panelRegistroHojaRem);
						
					wdHojaRemision.setCaption("Modificar Hoja de Remision");
					wdHojaRemision.setWidth("1050px");
					getWindow().addWindow(wdHojaRemision);
				}
			}

			@Override
			public Action[] getActions(Object target, Object sender) {
				return action;
			}
		});
	}

	private void buscarHojaRemisiones(Map<String, Object> map) {
		
		List<Hojaremision> hojaremisiones = hojaRemisionService.buscarBandeja(map);
		
		container.removeAllItems();
		int con = 0;
		for (Hojaremision hojaremision : hojaremisiones) {
			Item item = container.addItem(con++);
			item.getItemProperty(COLUMNA_NUMERO).setValue(hojaremision.getNumero());
			item.getItemProperty(COLUMNA_TIPO_HR).setValue(hojaremision.getTipoHr() !=null ? hojaremision.getTipoHr().getNombre() : StringUtils.EMPTY);
			item.getItemProperty(COLUMNA_EXPEDIENTE).setValue(hojaremision.getExpediente() != null ? hojaremision.getExpediente().getAutogenerado() : StringUtils.EMPTY);
			item.getItemProperty(COLUMNA_DEPENDENCIA_REMITE).setValue(hojaremision.getOrigen() != null ? hojaremision.getOrigen().getNombre() : StringUtils.EMPTY);
			item.getItemProperty(COLUMNA_DEPENDENCIA_DESTINO).setValue(hojaremision.getDestino() != null ? hojaremision.getDestino().getNombre() : StringUtils.EMPTY);
			item.getItemProperty(COLUMNA_FECHA_EMISION).setValue(hojaremision.getFechaEmision());
			item.getItemProperty(COLUMNA_FECHA_TRASLADO).setValue(hojaremision.getFechaTraslado());
			item.getItemProperty(COLUMNA_PERSONA).setValue(hojaremision.getConductor() != null ? hojaremision.getConductor().getNombreCompleto() : StringUtils.EMPTY);
			item.getItemProperty(COLUMNA_NRO_LICENCIA).setValue(hojaremision.getNroLicencia());
			item.getItemProperty(COLUMNA_OFICIO).setValue(hojaremision.getOficio());
			item.getItemProperty(COLUMNA_VEHICULO_MARCA).setValue(hojaremision.getVehiculoMarca() !=null ? hojaremision.getVehiculoMarca().getNombre() : StringUtils.EMPTY);
			item.getItemProperty(COLUMNA_VEHICULO_PLACA).setValue(hojaremision.getVehiculoPlaca());
			item.getItemProperty(COLUMNA_MOTIVO_TRASLADO).setValue(hojaremision.getMotivoTraslado());
			item.getItemProperty(COLUMNA_FECHA_RECEPCION).setValue(hojaremision.getFechaRecepcion());
			item.getItemProperty(COLUMNA_COSTO_TRASLADO).setValue(hojaremision.getCostoTraslado());
			item.getItemProperty(COLUMNA_OBSERVACION).setValue(hojaremision.getObservacion());
			item.getItemProperty(COLUMNA_CUSTODIO).setValue(hojaremision.getCustodio() !=null ? hojaremision.getCustodio().getNombreCompleto() : StringUtils.EMPTY);
			item.getItemProperty(COLUMNA_HOJA_REMISION).setValue(hojaremision);
		}
		
	}

	@Override
	public void handleEnterAction(TablaFiltroEnterEvent event) {
		buscarHojaRemisiones(event.getDatos());
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnBuscar)) {
			buscarHojaRemisiones(tblBandeja.getValues());
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
		
		// panel_1
		panel_1 = buildPanel_1();
		mainLayout.addComponent(panel_1);
		mainLayout.setExpandRatio(panel_1, 1.0f);
		
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

	@AutoGenerated
	private Panel buildPanel_1() {
		// common part: create layout
		panel_1 = new Panel();
		panel_1.setImmediate(false);
		panel_1.setWidth("100.0%");
		panel_1.setHeight("100.0%");
		
		// verticalLayout_2
		verticalLayout_2 = buildVerticalLayout_2();
		panel_1.setContent(verticalLayout_2);
		
		return panel_1;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_2() {
		// common part: create layout
		verticalLayout_2 = new VerticalLayout();
		verticalLayout_2.setImmediate(false);
		verticalLayout_2.setWidth("100.0%");
		verticalLayout_2.setHeight("100.0%");
		verticalLayout_2.setMargin(false);
		
		// tblBandeja
		tblBandeja = new TablaFiltro();
		tblBandeja.setImmediate(false);
		tblBandeja.setWidth("100.0%");
		tblBandeja.setHeight("100.0%");
		verticalLayout_2.addComponent(tblBandeja);
		verticalLayout_2.setExpandRatio(tblBandeja, 1.0f);
		
		return verticalLayout_2;
	}

}
