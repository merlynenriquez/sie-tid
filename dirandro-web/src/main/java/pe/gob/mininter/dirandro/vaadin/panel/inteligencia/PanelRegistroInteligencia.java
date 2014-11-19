package pe.gob.mininter.dirandro.vaadin.panel.inteligencia;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.vaadin.util.DirandroComponent;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.SelectedTabChangeListener;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.VerticalLayout;

public class PanelRegistroInteligencia extends DirandroComponent implements SelectedTabChangeListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	
	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlPrincipal;
	@AutoGenerated
	private TabSheet tabRegistroDocumento;
	@AutoGenerated
	private VerticalLayout tabOrganizaciones;
	@AutoGenerated
	private PanelRegistroInteligenciaOrganizacion panelRegistroInteligenciaOrganizacion;
	@AutoGenerated
	private VerticalLayout tabZona;
	@AutoGenerated
	private PanelRegistroInteligenciaCultivo panelRegistroInteligenciaCultivo_1;
	@AutoGenerated
	private VerticalLayout tabGremio;
	@AutoGenerated
	private PanelRegistroInteligenciaGremio panelRegistroInteligenciaGremio_1;
	@AutoGenerated
	private VerticalLayout tabAerodromo;
	@AutoGenerated
	private PanelRegistroInteligenciaAerodromo panelRegistroInteligenciaAerodromo;
	@AutoGenerated
	private VerticalLayout tabRutas;
	@AutoGenerated
	private PanelRegistroInteligenciaRutaTID panelRegistroInteligenciaRutaTID;
	@AutoGenerated
	private VerticalLayout tabDocumento;
	@AutoGenerated
	private PanelRegistroInteligenciaPrincipal panelRegistroInteligenciaPrincipal;
	private static final long serialVersionUID = -4639683924066371051L;
	private final Logger logger = Logger.getLogger(PanelRegistroInteligencia.class);
	
	public PanelRegistroInteligencia( List<Opcion> acciones, String height ) {
		super( acciones , height );
		buildMainLayout();
		setCompositionRoot(mainLayout);
		postConstruct();
	}
	
	@Override
	public void postConstruct() {
		
		tabRegistroDocumento.addListener((SelectedTabChangeListener) this);
		habilitarTab(false);
		tabRegistroDocumento.getTab(0).setEnabled(true);
	}
	
	public void habilitarTab(boolean flag) {
		Iterator<Component> i = tabRegistroDocumento.getComponentIterator();
		while (i.hasNext()) {
		    Component c = (Component) i.next();
		    Tab tab = tabRegistroDocumento.getTab(c);
		    tab.setEnabled(flag);
		}
	}
	
	@Override
	public void attach() {
		super.attach();
		
		//pnlRegistroParte.setPanelRegistroParte(this);		
		//if(!expediente.esNuevo()) {
			//pnlRegistroParte.cargarFormularioExpediente();
			habilitarTab(true);
		//}
	}

	@Override
	public void selectedTabChange(SelectedTabChangeEvent event) {
//		if(pnlAgregarDocumento.equals(event.getTabSheet().getSelectedTab())){
//			pnlAgregarDocumento.cargarDocumentos();
//		}
		
		if(event.getTabSheet().isEnabled()){

		
			//if(pnlExpVehiculo.equals(event.getTabSheet().getSelectedTab())){
				//pnlExpVehiculo.setExpediente(expediente);
			//}
		
		
			
		}
	
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
		
		// tabRegistroDocumento
		tabRegistroDocumento = buildTabRegistroDocumento();
		pnlPrincipal.addComponent(tabRegistroDocumento);
		pnlPrincipal.setComponentAlignment(tabRegistroDocumento, new Alignment(
				20));
		
		return pnlPrincipal;
	}

	@AutoGenerated
	private TabSheet buildTabRegistroDocumento() {
		// common part: create layout
		tabRegistroDocumento = new TabSheet();
		tabRegistroDocumento.setImmediate(true);
		tabRegistroDocumento.setWidth("950px");
		tabRegistroDocumento.setHeight("700px");
		
		// tabDocumento
		tabDocumento = buildTabDocumento();
		tabRegistroDocumento.addTab(tabDocumento, "Documento de Inteligencia",
				null);
		
		// tabRutas
		tabRutas = buildTabRutas();
		tabRegistroDocumento.addTab(tabRutas, "Rutas TID", null);
		
		// tabAerodromo
		tabAerodromo = buildTabAerodromo();
		tabRegistroDocumento.addTab(tabAerodromo, "Aerodromo", null);
		
		// tabGremio
		tabGremio = buildTabGremio();
		tabRegistroDocumento.addTab(tabGremio, "Gremio Cocalero", null);
		
		// tabZona
		tabZona = buildTabZona();
		tabRegistroDocumento.addTab(tabZona, "Zona de Cultivo", null);
		
		// tabOrganizaciones
		tabOrganizaciones = buildTabOrganizaciones();
		tabRegistroDocumento.addTab(tabOrganizaciones, "Organizaciones", null);
		
		return tabRegistroDocumento;
	}

	@AutoGenerated
	private VerticalLayout buildTabDocumento() {
		// common part: create layout
		tabDocumento = new VerticalLayout();
		tabDocumento.setImmediate(false);
		tabDocumento.setWidth("100.0%");
		tabDocumento.setHeight("-1px");
		tabDocumento.setMargin(false);
		
		// panelRegistroInteligenciaPrincipal
		panelRegistroInteligenciaPrincipal = new PanelRegistroInteligenciaPrincipal();
		panelRegistroInteligenciaPrincipal.setImmediate(false);
		panelRegistroInteligenciaPrincipal.setWidth("-1px");
		panelRegistroInteligenciaPrincipal.setHeight("-1px");
		tabDocumento.addComponent(panelRegistroInteligenciaPrincipal);
		
		return tabDocumento;
	}

	@AutoGenerated
	private VerticalLayout buildTabRutas() {
		// common part: create layout
		tabRutas = new VerticalLayout();
		tabRutas.setImmediate(false);
		tabRutas.setWidth("100.0%");
		tabRutas.setHeight("-1px");
		tabRutas.setMargin(false);
		
		// panelRegistroInteligenciaRutaTID
		panelRegistroInteligenciaRutaTID = new PanelRegistroInteligenciaRutaTID();
		panelRegistroInteligenciaRutaTID.setImmediate(false);
		panelRegistroInteligenciaRutaTID.setWidth("-1px");
		panelRegistroInteligenciaRutaTID.setHeight("-1px");
		tabRutas.addComponent(panelRegistroInteligenciaRutaTID);
		
		return tabRutas;
	}

	@AutoGenerated
	private VerticalLayout buildTabAerodromo() {
		// common part: create layout
		tabAerodromo = new VerticalLayout();
		tabAerodromo.setImmediate(false);
		tabAerodromo.setWidth("-1px");
		tabAerodromo.setHeight("-1px");
		tabAerodromo.setMargin(false);
		
		// panelRegistroInteligenciaAerodromo
		panelRegistroInteligenciaAerodromo = new PanelRegistroInteligenciaAerodromo();
		panelRegistroInteligenciaAerodromo.setImmediate(false);
		panelRegistroInteligenciaAerodromo.setWidth("-1px");
		panelRegistroInteligenciaAerodromo.setHeight("-1px");
		tabAerodromo.addComponent(panelRegistroInteligenciaAerodromo);
		
		return tabAerodromo;
	}

	@AutoGenerated
	private VerticalLayout buildTabGremio() {
		// common part: create layout
		tabGremio = new VerticalLayout();
		tabGremio.setImmediate(false);
		tabGremio.setWidth("-1px");
		tabGremio.setHeight("-1px");
		tabGremio.setMargin(false);
		
		// panelRegistroInteligenciaGremio_1
		panelRegistroInteligenciaGremio_1 = new PanelRegistroInteligenciaGremio();
		panelRegistroInteligenciaGremio_1.setImmediate(false);
		panelRegistroInteligenciaGremio_1.setWidth("-1px");
		panelRegistroInteligenciaGremio_1.setHeight("-1px");
		tabGremio.addComponent(panelRegistroInteligenciaGremio_1);
		
		return tabGremio;
	}

	@AutoGenerated
	private VerticalLayout buildTabZona() {
		// common part: create layout
		tabZona = new VerticalLayout();
		tabZona.setImmediate(false);
		tabZona.setWidth("-1px");
		tabZona.setHeight("-1px");
		tabZona.setMargin(false);
		
		// panelRegistroInteligenciaCultivo_1
		panelRegistroInteligenciaCultivo_1 = new PanelRegistroInteligenciaCultivo();
		panelRegistroInteligenciaCultivo_1.setImmediate(false);
		panelRegistroInteligenciaCultivo_1.setWidth("-1px");
		panelRegistroInteligenciaCultivo_1.setHeight("-1px");
		tabZona.addComponent(panelRegistroInteligenciaCultivo_1);
		
		return tabZona;
	}

	@AutoGenerated
	private VerticalLayout buildTabOrganizaciones() {
		// common part: create layout
		tabOrganizaciones = new VerticalLayout();
		tabOrganizaciones.setImmediate(false);
		tabOrganizaciones.setWidth("-1px");
		tabOrganizaciones.setHeight("-1px");
		tabOrganizaciones.setMargin(false);
		
		// panelRegistroInteligenciaOrganizacion
		panelRegistroInteligenciaOrganizacion = new PanelRegistroInteligenciaOrganizacion();
		panelRegistroInteligenciaOrganizacion.setImmediate(false);
		panelRegistroInteligenciaOrganizacion.setWidth("-1px");
		panelRegistroInteligenciaOrganizacion.setHeight("-1px");
		tabOrganizaciones.addComponent(panelRegistroInteligenciaOrganizacion);
		
		return tabOrganizaciones;
	}

}