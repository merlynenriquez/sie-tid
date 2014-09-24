package pe.gob.mininter.dirandro.vaadin.panel;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.util.HarecUtil;
import pe.gob.mininter.dirandro.vaadin.util.DirandroComponent;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.SelectedTabChangeListener;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.VerticalLayout;

public class PanelRegistroParte extends DirandroComponent implements SelectedTabChangeListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	
	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlPrincipal;
	@AutoGenerated
	private TabSheet tabRegistroParte;
	@AutoGenerated
	private VerticalLayout tabGrupoArmas;
	@AutoGenerated
	private TabSheet tabSheet_2;
	@AutoGenerated
	private PanelRegistroParteMunicion pnlMuniciones;
	@AutoGenerated
	private PanelRegistroParteExplosivo pnlExplosivos;
	@AutoGenerated
	private PanelRegistroParteArma pnlArmas;
	@AutoGenerated
	private VerticalLayout tabGroupInmuebles;
	@AutoGenerated
	private TabSheet tabSheet_4;
	@AutoGenerated
	private PanelRegistroParteVehiculo pnlExpVehiculo;
	@AutoGenerated
	private PanelRegistroParteInmueble pnlExpInmueble;
	@AutoGenerated
	private PanelRegistroParteInstalacion pnlExpInstalacion;
	@AutoGenerated
	private VerticalLayout tabGroupIncautacion;
	@AutoGenerated
	private TabSheet tabSheet_Incautado;
	@AutoGenerated
	private PanelRegistroParteEspecie pnlEspecie;
	@AutoGenerated
	private PanelRegistroParteDinero pnlImporte;
	@AutoGenerated
	private PanelRegistroParteTelefono pnlTelefono;
	@AutoGenerated
	private PanelRegistroParteDocumento pnlAgregarDocumento;
	@AutoGenerated
	private VerticalLayout pnlDelitos;
	@AutoGenerated
	private PanelRegistroParteDelito pnlExpDelitos;
	@AutoGenerated
	private PanelRegistroParteSustancia pnlSustancias;
	@AutoGenerated
	private VerticalLayout tabGroupPersonas;
	@AutoGenerated
	private TabSheet tabSheet_3;
	@AutoGenerated
	private VerticalLayout pnlRegPerNoIden;
	@AutoGenerated
	private PanelRegistroParteNoIdentificado pnlNoIdentificado;
	@AutoGenerated
	private VerticalLayout pnlRegInterviniente;
	@AutoGenerated
	private PanelRegistroParteInterviniente pnlInterviniente;
	@AutoGenerated
	private PanelRegistroPartePrincipal pnlRegistroParte;
	private static final long serialVersionUID = -4639683924066371051L;
	private final Logger logger = Logger.getLogger(PanelRegistroParte.class);
	
	private Expediente expediente;
	
	public PanelRegistroParte( List<Opcion> acciones, String height ) {
		super( acciones , height );
		buildMainLayout();
		setCompositionRoot(mainLayout);
		setExpediente(new Expediente());
		postConstruct();
	}
	
	@Override
	public void postConstruct() {
		
		tabRegistroParte.addListener((SelectedTabChangeListener) this);
		tabSheet_2.addListener((SelectedTabChangeListener) this);
		tabSheet_3.addListener((SelectedTabChangeListener) this);
		tabSheet_4.addListener((SelectedTabChangeListener) this);
		tabSheet_Incautado.addListener((SelectedTabChangeListener) this);
		
		pnlRegistroParte.setPnlAgregarDocumento(pnlAgregarDocumento);
		
		habilitarTab(false);
		tabRegistroParte.getTab(0).setEnabled(true);
	}
	
	public void habilitarTab(boolean flag) {
		Iterator<Component> i = tabRegistroParte.getComponentIterator();
		while (i.hasNext()) {
		    Component c = (Component) i.next();
		    Tab tab = tabRegistroParte.getTab(c);
		    tab.setEnabled(flag);
		}
	}
	
	@Override
	public void attach() {
		super.attach();
		
		pnlRegistroParte.setPanelRegistroParte(this);		
		if(!expediente.esNuevo()) {
			pnlRegistroParte.cargarFormularioExpediente();
			habilitarTab(true);
		}
	}

	@Override
	public void selectedTabChange(SelectedTabChangeEvent event) {
//		if(pnlAgregarDocumento.equals(event.getTabSheet().getSelectedTab())){
//			pnlAgregarDocumento.cargarDocumentos();
//		}
		
		if(event.getTabSheet().isEnabled()){
			
			//tab personas
			if(tabGroupPersonas.equals(event.getTabSheet().getSelectedTab())){
				logger.debug("cargar panel de intervinietnes");
				pnlInterviniente.setExpediente(expediente);
			}
			if(pnlNoIdentificado.equals(event.getTabSheet().getSelectedTab())){
				logger.debug("cargar panel de no identificados");
				pnlNoIdentificado.setExpediente(expediente);
			}
			
			if(pnlSustancias.equals(event.getTabSheet().getSelectedTab())){
				pnlSustancias.setExpediente(expediente);
			}
			
			
			if(pnlDelitos.equals(event.getTabSheet().getSelectedTab())){
				pnlExpDelitos.setExpediente(expediente);
			}		
			
			//tab incautaciones
			if(tabGroupIncautacion.equals(event.getTabSheet().getSelectedTab())){
				pnlTelefono.setExpediente(expediente);
			}
			if(pnlEspecie.equals(event.getTabSheet().getSelectedTab())){
				pnlEspecie.setExpediente(expediente);
			}
			
			if(pnlImporte.equals(event.getTabSheet().getSelectedTab())){
				pnlImporte.setExpediente(expediente);
			}
			
			//Tab vehiculo / inmueble
			if(tabGroupInmuebles.equals(event.getTabSheet().getSelectedTab())){
				pnlExpInstalacion.setExpediente(expediente);
			}
			if(pnlExpInmueble.equals(event.getTabSheet().getSelectedTab())){
				pnlExpInmueble.setExpediente(expediente);
			}
			if(pnlExpVehiculo.equals(event.getTabSheet().getSelectedTab())){
				pnlExpVehiculo.setExpediente(expediente);
			}
			
			//tab arma
			if(tabGrupoArmas.equals(event.getTabSheet().getSelectedTab())){
				logger.debug("cargar panel de armas");
				pnlArmas.setExpediente(expediente);
			}
			if(pnlExplosivos.equals(event.getTabSheet().getSelectedTab())){
				logger.debug("cargar panel de explosivos");
				pnlExplosivos.setExpediente(expediente);
			}
			if(pnlMuniciones.equals(event.getTabSheet().getSelectedTab())){
				logger.debug("cargar panel de municiones");
				pnlMuniciones.setExpediente(expediente);
			}
			
		
		
			
		}
	
	}
	
	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
		logger.debug("expediente = " + HarecUtil.nullToEmpty(expediente.getAutogenerado()) );
		pnlRegistroParte.setExpediente(expediente);
		pnlAgregarDocumento.setExpediente(expediente);
		pnlAgregarDocumento.cargarDocumentos();
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
		
		// tabRegistroParte
		tabRegistroParte = buildTabRegistroParte();
		pnlPrincipal.addComponent(tabRegistroParte);
		pnlPrincipal.setComponentAlignment(tabRegistroParte, new Alignment(20));
		
		return pnlPrincipal;
	}

	@AutoGenerated
	private TabSheet buildTabRegistroParte() {
		// common part: create layout
		tabRegistroParte = new TabSheet();
		tabRegistroParte.setImmediate(true);
		tabRegistroParte.setWidth("950px");
		tabRegistroParte.setHeight("700px");
		
		// pnlRegistroParte
		pnlRegistroParte = new PanelRegistroPartePrincipal();
		pnlRegistroParte.setImmediate(false);
		pnlRegistroParte.setWidth("-1px");
		pnlRegistroParte.setHeight("-1px");
		tabRegistroParte.addTab(pnlRegistroParte, "Registrar Parte", null);
		
		// tabGroupPersonas
		tabGroupPersonas = buildTabGroupPersonas();
		tabRegistroParte.addTab(tabGroupPersonas, "Personas", null);
		
		// pnlSustancias
		pnlSustancias = new PanelRegistroParteSustancia();
		pnlSustancias.setImmediate(false);
		pnlSustancias.setWidth("-1px");
		pnlSustancias.setHeight("-1px");
		tabRegistroParte.addTab(pnlSustancias, "Sustancias", null);
		
		// pnlDelitos
		pnlDelitos = buildPnlDelitos();
		tabRegistroParte.addTab(pnlDelitos, "Delitos", null);
		
		// pnlAgregarDocumento
		pnlAgregarDocumento = new PanelRegistroParteDocumento();
		pnlAgregarDocumento.setImmediate(false);
		pnlAgregarDocumento.setWidth("-1px");
		pnlAgregarDocumento.setHeight("-1px");
		tabRegistroParte.addTab(pnlAgregarDocumento, "Documentos", null);
		
		// tabGroupIncautacion
		tabGroupIncautacion = buildTabGroupIncautacion();
		tabRegistroParte.addTab(tabGroupIncautacion, "Especies", null);
		
		// tabGroupInmuebles
		tabGroupInmuebles = buildTabGroupInmuebles();
		tabRegistroParte.addTab(tabGroupInmuebles, "Vehículos / Inmuebles",
				null);
		
		// tabGrupoArmas
		tabGrupoArmas = buildTabGrupoArmas();
		tabRegistroParte.addTab(tabGrupoArmas, "Armas / Explosivos", null);
		
		return tabRegistroParte;
	}

	@AutoGenerated
	private VerticalLayout buildTabGroupPersonas() {
		// common part: create layout
		tabGroupPersonas = new VerticalLayout();
		tabGroupPersonas.setImmediate(false);
		tabGroupPersonas.setWidth("100.0%");
		tabGroupPersonas.setHeight("-1px");
		tabGroupPersonas.setMargin(false);
		
		// tabSheet_3
		tabSheet_3 = buildTabSheet_3();
		tabGroupPersonas.addComponent(tabSheet_3);
		
		return tabGroupPersonas;
	}

	@AutoGenerated
	private TabSheet buildTabSheet_3() {
		// common part: create layout
		tabSheet_3 = new TabSheet();
		tabSheet_3.setImmediate(true);
		tabSheet_3.setWidth("100.0%");
		tabSheet_3.setHeight("100.0%");
		
		// pnlRegInterviniente
		pnlRegInterviniente = buildPnlRegInterviniente();
		tabSheet_3.addTab(pnlRegInterviniente, "Interviniente", null);
		
		// pnlRegPerNoIden
		pnlRegPerNoIden = buildPnlRegPerNoIden();
		tabSheet_3.addTab(pnlRegPerNoIden, "No Identificados", null);
		
		return tabSheet_3;
	}

	@AutoGenerated
	private VerticalLayout buildPnlRegInterviniente() {
		// common part: create layout
		pnlRegInterviniente = new VerticalLayout();
		pnlRegInterviniente.setImmediate(false);
		pnlRegInterviniente.setWidth("100.0%");
		pnlRegInterviniente.setHeight("632px");
		pnlRegInterviniente.setMargin(false);
		
		// pnlInterviniente
		pnlInterviniente = new PanelRegistroParteInterviniente();
		pnlInterviniente.setImmediate(false);
		pnlInterviniente.setWidth("-1px");
		pnlInterviniente.setHeight("-1px");
		pnlRegInterviniente.addComponent(pnlInterviniente);
		
		return pnlRegInterviniente;
	}

	@AutoGenerated
	private VerticalLayout buildPnlRegPerNoIden() {
		// common part: create layout
		pnlRegPerNoIden = new VerticalLayout();
		pnlRegPerNoIden.setImmediate(false);
		pnlRegPerNoIden.setWidth("100.0%");
		pnlRegPerNoIden.setHeight("632px");
		pnlRegPerNoIden.setMargin(false);
		
		// pnlNoIdentificado
		pnlNoIdentificado = new PanelRegistroParteNoIdentificado();
		pnlNoIdentificado.setImmediate(false);
		pnlNoIdentificado.setWidth("-1px");
		pnlNoIdentificado.setHeight("-1px");
		pnlRegPerNoIden.addComponent(pnlNoIdentificado);
		
		return pnlRegPerNoIden;
	}

	@AutoGenerated
	private VerticalLayout buildPnlDelitos() {
		// common part: create layout
		pnlDelitos = new VerticalLayout();
		pnlDelitos.setImmediate(false);
		pnlDelitos.setWidth("-1px");
		pnlDelitos.setHeight("-1px");
		pnlDelitos.setMargin(false);
		
		// pnlExpDelitos
		pnlExpDelitos = new PanelRegistroParteDelito();
		pnlExpDelitos.setImmediate(false);
		pnlExpDelitos.setWidth("-1px");
		pnlExpDelitos.setHeight("-1px");
		pnlDelitos.addComponent(pnlExpDelitos);
		
		return pnlDelitos;
	}

	@AutoGenerated
	private VerticalLayout buildTabGroupIncautacion() {
		// common part: create layout
		tabGroupIncautacion = new VerticalLayout();
		tabGroupIncautacion.setImmediate(false);
		tabGroupIncautacion.setWidth("100.0%");
		tabGroupIncautacion.setHeight("-1px");
		tabGroupIncautacion.setMargin(false);
		
		// tabSheet_Incautado
		tabSheet_Incautado = buildTabSheet_Incautado();
		tabGroupIncautacion.addComponent(tabSheet_Incautado);
		
		return tabGroupIncautacion;
	}

	@AutoGenerated
	private TabSheet buildTabSheet_Incautado() {
		// common part: create layout
		tabSheet_Incautado = new TabSheet();
		tabSheet_Incautado.setImmediate(true);
		tabSheet_Incautado.setWidth("100.0%");
		tabSheet_Incautado.setHeight("-1px");
		
		// pnlTelefono
		pnlTelefono = new PanelRegistroParteTelefono();
		pnlTelefono.setImmediate(false);
		pnlTelefono.setWidth("-1px");
		pnlTelefono.setHeight("632px");
		tabSheet_Incautado.addTab(pnlTelefono, "Telefono", null);
		
		// pnlImporte
		pnlImporte = new PanelRegistroParteDinero();
		pnlImporte.setImmediate(false);
		pnlImporte.setWidth("-1px");
		pnlImporte.setHeight("632px");
		tabSheet_Incautado.addTab(pnlImporte, "Dinero", null);
		
		// pnlEspecie
		pnlEspecie = new PanelRegistroParteEspecie();
		pnlEspecie.setImmediate(false);
		pnlEspecie.setWidth("-1px");
		pnlEspecie.setHeight("632px");
		tabSheet_Incautado.addTab(pnlEspecie, "Especies", null);
		
		return tabSheet_Incautado;
	}

	@AutoGenerated
	private VerticalLayout buildTabGroupInmuebles() {
		// common part: create layout
		tabGroupInmuebles = new VerticalLayout();
		tabGroupInmuebles.setImmediate(false);
		tabGroupInmuebles.setWidth("100.0%");
		tabGroupInmuebles.setHeight("-1px");
		tabGroupInmuebles.setMargin(false);
		
		// tabSheet_4
		tabSheet_4 = buildTabSheet_4();
		tabGroupInmuebles.addComponent(tabSheet_4);
		tabGroupInmuebles.setComponentAlignment(tabSheet_4, new Alignment(20));
		
		return tabGroupInmuebles;
	}

	@AutoGenerated
	private TabSheet buildTabSheet_4() {
		// common part: create layout
		tabSheet_4 = new TabSheet();
		tabSheet_4.setImmediate(true);
		tabSheet_4.setWidth("100.0%");
		tabSheet_4.setHeight("100.0%");
		
		// pnlExpInstalacion
		pnlExpInstalacion = new PanelRegistroParteInstalacion();
		pnlExpInstalacion.setImmediate(false);
		pnlExpInstalacion.setWidth("-1px");
		pnlExpInstalacion.setHeight("632px");
		tabSheet_4.addTab(pnlExpInstalacion, "Instalaciones", null);
		
		// pnlExpInmueble
		pnlExpInmueble = new PanelRegistroParteInmueble();
		pnlExpInmueble.setImmediate(false);
		pnlExpInmueble.setWidth("-1px");
		pnlExpInmueble.setHeight("632px");
		tabSheet_4.addTab(pnlExpInmueble, "Inmuebles", null);
		
		// pnlExpVehiculo
		pnlExpVehiculo = new PanelRegistroParteVehiculo();
		pnlExpVehiculo.setImmediate(false);
		pnlExpVehiculo.setWidth("-1px");
		pnlExpVehiculo.setHeight("632px");
		tabSheet_4.addTab(pnlExpVehiculo, "Vehiculos", null);
		
		return tabSheet_4;
	}

	@AutoGenerated
	private VerticalLayout buildTabGrupoArmas() {
		// common part: create layout
		tabGrupoArmas = new VerticalLayout();
		tabGrupoArmas.setImmediate(false);
		tabGrupoArmas.setWidth("100.0%");
		tabGrupoArmas.setHeight("-1px");
		tabGrupoArmas.setMargin(false);
		
		// tabSheet_2
		tabSheet_2 = buildTabSheet_2();
		tabGrupoArmas.addComponent(tabSheet_2);
		
		return tabGrupoArmas;
	}

	@AutoGenerated
	private TabSheet buildTabSheet_2() {
		// common part: create layout
		tabSheet_2 = new TabSheet();
		tabSheet_2.setImmediate(true);
		tabSheet_2.setWidth("100.0%");
		tabSheet_2.setHeight("-1px");
		
		// pnlArmas
		pnlArmas = new PanelRegistroParteArma();
		pnlArmas.setImmediate(false);
		pnlArmas.setWidth("-1px");
		pnlArmas.setHeight("-1px");
		tabSheet_2.addTab(pnlArmas, "Armas", null);
		
		// pnlExplosivos
		pnlExplosivos = new PanelRegistroParteExplosivo();
		pnlExplosivos.setImmediate(false);
		pnlExplosivos.setWidth("-1px");
		pnlExplosivos.setHeight("-1px");
		tabSheet_2.addTab(pnlExplosivos, "Explosivos", null);
		
		// pnlMuniciones
		pnlMuniciones = new PanelRegistroParteMunicion();
		pnlMuniciones.setImmediate(false);
		pnlMuniciones.setWidth("100.0%");
		pnlMuniciones.setHeight("632px");
		tabSheet_2.addTab(pnlMuniciones, "Municiones", null);
		
		return tabSheet_2;
	}

}
