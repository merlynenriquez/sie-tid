package pe.gob.mininter.dirandro.vaadin.panel.informe;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.Informe;
import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.service.InformeService;
import pe.gob.mininter.dirandro.util.HarecUtil;
import pe.gob.mininter.dirandro.vaadin.util.DirandroComponent;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.SelectedTabChangeListener;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class PanelRegistroInforme extends DirandroComponent implements SelectedTabChangeListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;

	@AutoGenerated
	private HorizontalLayout lytPrincipal;

	@AutoGenerated
	private TabSheet tabInforme;

	@AutoGenerated
	private VerticalLayout tabOrgano;

	@AutoGenerated
	private PanelRegistroInformeOrgano panelRegistroOrgano;

	@AutoGenerated
	private VerticalLayout tabTitulos;

	@AutoGenerated
	private PanelRegistroInformeTitulo panelRegistroInformeTitulo;

	@AutoGenerated
	private VerticalLayout tabAgenda;

	@AutoGenerated
	private PanelRegistroInformeAgenda panelRegistroInformeAgenda;

	@AutoGenerated
	private VerticalLayout tabNotificaciones;

	@AutoGenerated
	private PanelRegistroInformeNotificacion panelRegistroInformeNotificacion;

	@AutoGenerated
	private VerticalLayout tabPrincipal;

	@AutoGenerated
	private PanelRegistroInformePrincipal pnlRegistroPrincipal;

	private static final Logger logger = Logger.getLogger(PanelRegistroInforme.class);
	
	private Informe informe;
	private Expediente expediente;
	private InformeService informeService;
	
	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
		Informe inf = informeService.obtenerPorExpediente(expediente);
		if(inf!=null)
			setInforme(inf);
		else
			setInforme(new Informe());
	}


	public Informe getInforme() {
		return informe;
	}

	public void setInforme(Informe informe) {
		this.informe = informe;
		informe.setExpediente(expediente);
		logger.debug("informe nuevo? = " + HarecUtil.nullToEmpty(informe.esNuevo() ) );
		pnlRegistroPrincipal.setInforme(informe);
	}

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelRegistroInforme( List<Opcion> acciones, String height ) {
		super( acciones , height );
		buildMainLayout();
		setCompositionRoot(mainLayout);
		informeService = Injector.obtenerServicio(InformeService.class);
		setInforme( new Informe() );
		postConstruct();
	}
	
	@Override
	public void postConstruct() {
		
		tabInforme.addListener((SelectedTabChangeListener) this);
		habilitarTab(false);
		tabInforme.getTab(0).setEnabled(true);
	
	}
	
	public void habilitarTab(boolean flag) {
		Iterator<Component> i = tabInforme.getComponentIterator();
		while (i.hasNext()) {
		    Component c = (Component) i.next();
		    Tab tab = tabInforme.getTab(c);
		    tab.setEnabled(flag);
		}
	}
	
	@Override
	public void attach() {
		super.attach();
		
		pnlRegistroPrincipal.setPadre(this);		
		if(!informe.esNuevo()) {
			pnlRegistroPrincipal.cargarFormulario();
			habilitarTab(true);
		}
	}

	@Override
	public void selectedTabChange(SelectedTabChangeEvent event) {
		
		if(event.getTabSheet().isEnabled()){

			if(tabAgenda.equals(event.getTabSheet().getSelectedTab())){
				panelRegistroInformeAgenda.setInforme(informe);
			}
			if(tabTitulos.equals(event.getTabSheet().getSelectedTab())){
				panelRegistroInformeTitulo.setInforme(informe);
			}
			if(tabNotificaciones.equals(event.getTabSheet().getSelectedTab())){
				panelRegistroInformeNotificacion.setInforme(informe);
			}
			if(tabOrgano.equals(event.getTabSheet().getSelectedTab())){
				logger.debug("cargar tab organos");
				panelRegistroOrgano.setInforme(informe);
			}
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
		
		// lytPrincipal
		lytPrincipal = buildLytPrincipal();
		mainLayout.addComponent(lytPrincipal);
		
		return mainLayout;
	}

	@AutoGenerated
	private HorizontalLayout buildLytPrincipal() {
		// common part: create layout
		lytPrincipal = new HorizontalLayout();
		lytPrincipal.setImmediate(false);
		lytPrincipal.setWidth("-1px");
		lytPrincipal.setHeight("-1px");
		lytPrincipal.setMargin(true);
		lytPrincipal.setSpacing(true);
		
		// tabInforme
		tabInforme = buildTabInforme();
		lytPrincipal.addComponent(tabInforme);
		
		return lytPrincipal;
	}

	@AutoGenerated
	private TabSheet buildTabInforme() {
		// common part: create layout
		tabInforme = new TabSheet();
		tabInforme.setImmediate(true);
		tabInforme.setWidth("950px");
		tabInforme.setHeight("600px");
		
		// tabPrincipal
		tabPrincipal = buildTabPrincipal();
		tabInforme.addTab(tabPrincipal, "Informe", null);
		
		// tabNotificaciones
		tabNotificaciones = buildTabNotificaciones();
		tabInforme.addTab(tabNotificaciones, "Notificaciones", null);
		
		// tabAgenda
		tabAgenda = buildTabAgenda();
		tabInforme.addTab(tabAgenda, "Agenda", null);
		
		// tabTitulos
		tabTitulos = buildTabTitulos();
		tabInforme.addTab(tabTitulos, "Titulos", null);
		
		// tabOrgano
		tabOrgano = buildTabOrgano();
		tabInforme.addTab(tabOrgano, "Organo Exhorto", null);
		
		return tabInforme;
	}

	@AutoGenerated
	private VerticalLayout buildTabPrincipal() {
		// common part: create layout
		tabPrincipal = new VerticalLayout();
		tabPrincipal.setImmediate(false);
		tabPrincipal.setWidth("-1px");
		tabPrincipal.setHeight("-1px");
		tabPrincipal.setMargin(false);
		
		// pnlRegistroPrincipal
		pnlRegistroPrincipal = new PanelRegistroInformePrincipal();
		pnlRegistroPrincipal.setImmediate(false);
		pnlRegistroPrincipal.setWidth("-1px");
		pnlRegistroPrincipal.setHeight("-1px");
		tabPrincipal.addComponent(pnlRegistroPrincipal);
		
		return tabPrincipal;
	}

	@AutoGenerated
	private VerticalLayout buildTabNotificaciones() {
		// common part: create layout
		tabNotificaciones = new VerticalLayout();
		tabNotificaciones.setImmediate(false);
		tabNotificaciones.setWidth("-1px");
		tabNotificaciones.setHeight("-1px");
		tabNotificaciones.setMargin(false);
		
		// panelRegistroInformeNotificacion
		panelRegistroInformeNotificacion = new PanelRegistroInformeNotificacion();
		panelRegistroInformeNotificacion.setImmediate(false);
		panelRegistroInformeNotificacion.setWidth("-1px");
		panelRegistroInformeNotificacion.setHeight("-1px");
		tabNotificaciones.addComponent(panelRegistroInformeNotificacion);
		
		return tabNotificaciones;
	}

	@AutoGenerated
	private VerticalLayout buildTabAgenda() {
		// common part: create layout
		tabAgenda = new VerticalLayout();
		tabAgenda.setImmediate(false);
		tabAgenda.setWidth("-1px");
		tabAgenda.setHeight("-1px");
		tabAgenda.setMargin(false);
		
		// panelRegistroInformeAgenda
		panelRegistroInformeAgenda = new PanelRegistroInformeAgenda();
		panelRegistroInformeAgenda.setImmediate(false);
		panelRegistroInformeAgenda.setWidth("-1px");
		panelRegistroInformeAgenda.setHeight("-1px");
		tabAgenda.addComponent(panelRegistroInformeAgenda);
		
		return tabAgenda;
	}

	@AutoGenerated
	private VerticalLayout buildTabTitulos() {
		// common part: create layout
		tabTitulos = new VerticalLayout();
		tabTitulos.setImmediate(false);
		tabTitulos.setWidth("-1px");
		tabTitulos.setHeight("-1px");
		tabTitulos.setMargin(false);
		
		// panelRegistroInformeTitulo
		panelRegistroInformeTitulo = new PanelRegistroInformeTitulo();
		panelRegistroInformeTitulo.setImmediate(false);
		panelRegistroInformeTitulo.setWidth("-1px");
		panelRegistroInformeTitulo.setHeight("-1px");
		tabTitulos.addComponent(panelRegistroInformeTitulo);
		
		return tabTitulos;
	}

	@AutoGenerated
	private VerticalLayout buildTabOrgano() {
		// common part: create layout
		tabOrgano = new VerticalLayout();
		tabOrgano.setImmediate(false);
		tabOrgano.setWidth("-1px");
		tabOrgano.setHeight("-1px");
		tabOrgano.setMargin(false);
		
		// panelRegistroOrgano
		panelRegistroOrgano = new PanelRegistroInformeOrgano();
		panelRegistroOrgano.setImmediate(false);
		panelRegistroOrgano.setWidth("-1px");
		panelRegistroOrgano.setHeight("-1px");
		tabOrgano.addComponent(panelRegistroOrgano);
		
		return tabOrgano;
	}

}
