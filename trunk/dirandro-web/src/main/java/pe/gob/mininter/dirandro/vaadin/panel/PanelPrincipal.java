package pe.gob.mininter.dirandro.vaadin.panel;

import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.model.Usuario;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;
import pe.gob.mininter.dirandro.util.PlantillaVelocity;
import pe.gob.mininter.dirandro.vaadin.util.HarecComponent;
import pe.gob.mininter.dirandro.vaadin.util.HarecMenuBar;
import pe.gob.mininter.dirandro.vaadin.util.HarecMenuBar.HarecMenuItem;
import pe.gob.mininter.dirandro.vaadin.util.HarecWindow;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.CloseEvent;

public class PanelPrincipal extends CustomComponent implements Command, Serializable {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
		
	@AutoGenerated
	private VerticalLayout mainLayout;

	@AutoGenerated
	private VerticalLayout mainLayoutContainer;

	@AutoGenerated
	private Label lblPie;

	@AutoGenerated
	private CustomLayout pnlContenido;

	@AutoGenerated
	private VerticalLayout pnlCabecera;

	@AutoGenerated
	private VerticalLayout pnlTitulo;

	@AutoGenerated
	private Label lblTituloPanel;

	@AutoGenerated
	private HarecMenuBar mnuPrincipal;

	private static final Logger logger = Logger.getLogger( PanelPrincipal.class );
	
	private static final long serialVersionUID = -6874093584755981542L;
	
	private PlantillaVelocity plantillaVelocity;
	
	private List<HarecWindow> ventanasAbiertas;
	
	private HarecMenuItem harecMenuItemDefault;
	
	private MenuItem mniUsuario;
	
	private MenuItem mniCerrarSesion;
	
	private boolean flagConsulta;

	public PanelPrincipal() {
		plantillaVelocity = Injector.obtenerServicio(PlantillaVelocity.class);
		buildMainLayout();
		setCompositionRoot(mainLayout);
		lblTituloPanel.setValue("");
		lblTituloPanel.setContentMode(Label.CONTENT_XHTML);
		ventanasAbiertas = new ArrayList<HarecWindow>();		
	}
	
	public void prepararPanelPrincipal() {
		Usuario usuario = HarecUtil.obtenerUsuarioSesion();

		

		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("usuario", usuario);
		plantillaVelocity = new PlantillaVelocity();
		String htmlData = plantillaVelocity.enviarFormato(hashmap, "toolUsuario.vm");	
		mniUsuario = mnuPrincipal.addItem(usuario.getUsuario(), new ThemeResource("../runo/icons/16/user.png"), null);
		mniCerrarSesion = mniUsuario.addItem("Cerrar Sesión", new ThemeResource("../runo/icons/16/cancel.png"),this);
		
		mniUsuario.setDescription(htmlData);

		agregarMenu(Constante.OPCION.KEY_PADRE,  usuario.getRol().getOpciones(), null);	
		
		if(harecMenuItemDefault != null)
			menuSelected(harecMenuItemDefault);
		
	}	
	
	@SuppressWarnings("unused")
	private String generarUsuarioInfo(Usuario usuario) {
		VelocityEngine velocityEngine = new VelocityEngine();
		
		velocityEngine.setProperty("resource.loader", "class");
		velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		velocityEngine.init();
        
        VelocityContext context = new VelocityContext();
        context.put("usuario", usuario);
        
        Map<String, Object> mapa = new HashMap<String, Object>();
        
        Template template = velocityEngine.getTemplate( "toolUsuario.vm" );
        
        StringWriter writer = new StringWriter();

        template.merge( context, writer );
        
		return writer.toString();
	}
	
	private void agregarMenu(String codigo, Map<String, List<Opcion>> map, HarecMenuItem padre) {
		if(!map.containsKey(codigo))
			return;
		
		for (Opcion opc : map.get(codigo)) {
			HarecMenuItem mni;
			if (Constante.VALOR.CODIGO.MENU.equals(opc.getTipo().getCodigo())) {
				mni = mnuPrincipal.addItem(opc.getCodigo(), opc.getAcciones(), opc.getNombre(), null);
			} else if (Constante.VALOR.CODIGO.SUBMENU.equals(opc.getTipo().getCodigo())) {
				mni = padre.addItem(opc.getCodigo(), opc.getAcciones(), opc.getNombre(), this);
				if (StringUtils.equals(opc.getCodigo(), Constante.OPCION.CODIGO_EXP_BND)) {
					harecMenuItemDefault = mni;
				}
			} else {
				continue;
			}

			if (map.get(opc.getCodigo()) != null) {
				agregarMenu(opc.getCodigo(), map, mni);
			}
		}
	}
	
	@Override
	public void menuSelected(MenuItem selectedItem) {
		if(selectedItem.equals(mniCerrarSesion)){
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    		HttpServletRequest request = requestAttributes.getRequest();
    		HttpSession session = request.getSession(false);
    		session.invalidate();
			getWindow().getApplication().close();
		}
		else if(selectedItem instanceof HarecMenuItem){
			
			//Lista de Ventanas Generadas
			HarecMenuItem selectedHarecItem = (HarecMenuItem) selectedItem;
			List<Opcion> acciones = selectedHarecItem.getAcciones();
			String codigo = selectedHarecItem.getCodigo();
			
			//Paneles Estaticos
			/**
			 * Menu Registro de Parte Policial
			 */
			if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_EXP_REG_PP)){
				lblTituloPanel.setValue("<h2>Parte Policial</h2>");
				
				pnlContenido.removeAllComponents();
				pnlContenido.addComponent(new PanelRegistroParte(acciones, "-1px"), "top");
			}
			
			/**
			 * Menu Registro de Mantenimientos
			 */
			else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_MNT_DELITO)){
				lblTituloPanel.setValue("<h2>Mantenimiento de Delitos</h2>");
				pnlContenido.removeAllComponents();
				pnlContenido.addComponent(new PanelRegistroParte(acciones, "-1px"), "top");
			}else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_MNT_EMPRESA)){
				lblTituloPanel.setValue("<h2>Mantenimiento de Delitos</h2>");
				pnlContenido.removeAllComponents();
				pnlContenido.addComponent(new PanelRegistroParte(acciones, "-1px"), "top");
			}else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_MNT_PERSONA)){
				lblTituloPanel.setValue("<h2>Mantenimiento de Persona</h2>");
				pnlContenido.removeAllComponents();
				pnlContenido.addComponent(new PanelMantenPersona(acciones, "-1px"), "top");
			}else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_MNT_DEPENDEN)){
				lblTituloPanel.setValue("<h2>Mantenimiento de Dependencias</h2>");
				pnlContenido.removeAllComponents();
				pnlContenido.addComponent(new PanelMantenDependencias(acciones, "-1px"), "top");
			}else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_MNT_ESTADO)){
				lblTituloPanel.setValue("<h2>Mantenimiento de Estados del Expediente</h2>");
				pnlContenido.removeAllComponents();
				pnlContenido.addComponent(new PanelMantenEstado(acciones, "-1px"), "top");
			}else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_MNT_PAIS)){
				lblTituloPanel.setValue("<h2>Mantenimiento de Paises</h2>");
				pnlContenido.removeAllComponents();
				pnlContenido.addComponent(new PanelMantenPais(acciones, "-1px"), "top");
			}else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_MNT_POBLADO)){
				lblTituloPanel.setValue("<h2>Mantenimiento de Centros Poblados</h2>");
				pnlContenido.removeAllComponents();
				pnlContenido.addComponent(new PanelMantenPoblado(acciones, "-1px"), "top");
			}else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_MNT_LETRADO)){
				lblTituloPanel.setValue("<h2>Mantenimiento de Letrado</h2>");
				pnlContenido.removeAllComponents();
				pnlContenido.addComponent(new PanelMantenLetrado(acciones, "-1px"), "top");
			}else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_MNT_POLICIA)){
				lblTituloPanel.setValue("<h2>Mantenimiento de Policia</h2>");
				pnlContenido.removeAllComponents();
				pnlContenido.addComponent(new PanelMantenPolicia(acciones, "-1px"), "top");
			}
			
			
			/**
			 * Menu de Busqueda
			 */
			else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_BSQ_PERSONA)){
				lblTituloPanel.setValue("<h2>Busqueda de Personas en los Expedientes</h2>");
				pnlContenido.removeAllComponents();
				pnlContenido.addComponent(new PanelBuscaPersona(acciones, "-1px"), "top");
			}
			
			/**
			 * Menu de Configuracion
			 */
			else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_CFG_LOV)){
				lblTituloPanel.setValue("<h2>Administracion de Lista y Valores</h2>");
				pnlContenido.removeAllComponents();
				pnlContenido.addComponent(new PanelConfigListaValores(acciones, "-1px"), "top");
			}else if (StringUtils.equals(codigo, Constante.OPCION.CODIGO_CFG_PARAMETRO)){
				lblTituloPanel.setValue("<h2>Administracion de Parametros</h2>");
				pnlContenido.removeAllComponents();
				pnlContenido.addComponent(new PanelConfigParametro(acciones, "-1px"), "top");
			}
			
			//Ventanas Flotantes
			else {
				String titulo = "Sin título";
				String width = "-1.0";
				
				HarecComponent harecComponent = null;
				
				HarecWindow harecWindow = new HarecWindow();
				harecWindow.setCodigo(codigo);				
				
				//Verifica que la ventana no esté abierta caso contrario termina la ejecución.
				if(ventanasAbiertas.contains(harecWindow)){
					int index = ventanasAbiertas.indexOf(harecWindow);
					ventanasAbiertas.get(index).focus();
					return;
				}
				ventanasAbiertas.add(harecWindow);
				
				harecWindow.setModal(false);
				harecWindow.setResizable(false);
				harecWindow.addListener(new Window.CloseListener() {
			           
					private static final long serialVersionUID = -5881284404987049977L;

					public void windowClose(CloseEvent e) {
		    			if(e.getWindow() instanceof HarecWindow)
		    			{
		    				ventanasAbiertas.remove((HarecWindow) e.getWindow());
		    			}
		            }
		        });
				
				//Menu 1
				if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_MNT_DELITO)){
					titulo = "Mantenimiento de Delitos";
					width = "950px";
				}else {
					//TODO: Mapear la Bandeja de Expedientes
					System.out.println("Bandeja de Expedientes");
				}
				
				
				/*
				
				else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_ADMIN_ROL_MEMB)){
					titulo = "Mantenimiento de Roles de Usuario";
					width = "950px";
					height = "-1.0";
					harecComponent = new PanelConfigRoles(acciones);
				}
				else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_ADMIN_OPCION)){
					titulo = "Mantenimiento de Opciones";
					width = "950px";
					height = "-1.0";
					harecComponent = new PanelAdminOpcionSeguridad(acciones);
				}
				else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_ADMIN_PERM)){
					titulo = "Mantenimiento de Permisos";
					width = "950px";
					height = "-1.0";
					harecComponent = new PanelConfigPermisos(acciones);
				}
				else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_ORG_EQUIPO)){
					titulo = "Mantenimiento de Equipos";
					width = "1050px";
					height = "-1.0";
					harecComponent = new PanelAdminEquipos(acciones);
				}
				else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_ESTADO_EXP)){
					titulo = "Mantenimiento del Estados del Expediente";
					width = "750px";
					height = "-1.0";
					harecComponent = new PanelAdminEstadoExpediente(acciones);
				}
				
				
				else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_EXP_DELITO)){
					titulo = "Mantenimiento de Delitos";
					width = "950px";
					height = "-1.0";
					harecComponent = new PanelAdminDelito(acciones);
				}
				else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_EXP_BANDA)){
					titulo = "Mantenimiento de Bandas";
					width = "950px";
					height = "-1.0";
					harecComponent = new PanelAdminBandas(acciones);
				}
				else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_CFG_ENTIDAD)){
					titulo = "Mantenimiento de Procedencia";
					width = "950px";
					height = "-1.0";
					harecComponent = new PanelAdminEntidades(acciones);
				}			
				else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_ADMIN_DROGA)){
					titulo = "Expediente de Drogas";
					width = "950px";
					height = "-1.0";
					harecComponent = new PanelAdminDrogas(acciones);
				}
				else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_ADMIN_USUARIO)){
					titulo = "Mantenimiento de Usuarios";
					width = "950px";
					height = "-1.0";
					harecComponent = new PanelAdminUsuarios(acciones);
				}
				else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_ADMIN_DEPENDENCIA)){
					titulo = "Mantenimiento de Dependencias";
					width = "950px";
					height = "-1.0";
					harecComponent = new PanelAdminDependencias(acciones);
				}
				else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_ADMIN_POLICIA)){
					titulo = "Mantenimiento de Policias";
					width = "850px";
					height = "-1.0";
					harecComponent = new PanelAdminPolicia(acciones);
				}
				else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_ADMIN_VEHICULO)){
					titulo = "Mantenimiento de Vehículos";
					width = "660px";
					height = "-1.0";
					harecComponent = new PanelAdminVehiculos(acciones);
				}
				
				//Armado del Menu Segunda Columna
				
				else if(StringUtils.equals(codigo, Constante.OPCION.CODIGO_EXP_REG)){
					titulo = "Nuevo Expediente";
					width = "1150px";
					height = "-1.0";
					harecComponent = new PanelRegistroExpediente(acciones);
				}				
				*/				
				
				harecWindow.addComponent(harecComponent);
				harecWindow.setCaption(titulo);
				harecWindow.setWidth(width);
				
				getWindow().addWindow(harecWindow);
			}
			
		}
		else
		{
			//TODO enviar mensaje de opcion no mapeada.
		}
	}

	public void setFlagConsulta(boolean flagConsulta) {
		this.flagConsulta = flagConsulta;
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// mainLayoutContainer
		mainLayoutContainer = buildMainLayoutContainer();
		mainLayout.addComponent(mainLayoutContainer);
		mainLayout.setExpandRatio(mainLayoutContainer, 1.0f);
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildMainLayoutContainer() {
		// common part: create layout
		mainLayoutContainer = new VerticalLayout();
		mainLayoutContainer.setImmediate(false);
		mainLayoutContainer.setWidth("100.0%");
		mainLayoutContainer.setHeight("100.0%");
		mainLayoutContainer.setMargin(false);
		
		// pnlCabecera
		pnlCabecera = buildPnlCabecera();
		mainLayoutContainer.addComponent(pnlCabecera);
		
		// pnlContenido
		pnlContenido = new CustomLayout("contenido");
		pnlContenido.setImmediate(false);
		pnlContenido.setWidth("100.0%");
		pnlContenido.setHeight("100.0%");
		mainLayoutContainer.addComponent(pnlContenido);
		mainLayoutContainer.setExpandRatio(pnlContenido, 1.0f);
		mainLayoutContainer.setComponentAlignment(pnlContenido, new Alignment(
				48));
		
		// lblPie
		lblPie = new Label();
		lblPie.setImmediate(false);
		lblPie.setWidth("-1px");
		lblPie.setHeight("-1px");
		lblPie.setValue("Ministerio del Interior");
		mainLayoutContainer.addComponent(lblPie);
		mainLayoutContainer.setComponentAlignment(lblPie, new Alignment(24));
		
		return mainLayoutContainer;
	}

	@AutoGenerated
	private VerticalLayout buildPnlCabecera() {
		// common part: create layout
		pnlCabecera = new VerticalLayout();
		pnlCabecera.setImmediate(false);
		pnlCabecera.setWidth("100.0%");
		pnlCabecera.setHeight("-1px");
		pnlCabecera.setMargin(false);
		
		// mnuPrincipal
		mnuPrincipal = new HarecMenuBar();
		mnuPrincipal.setImmediate(false);
		mnuPrincipal.setWidth("100.0%");
		mnuPrincipal.setHeight("-1px");
		pnlCabecera.addComponent(mnuPrincipal);
		
		// pnlTitulo
		pnlTitulo = buildPnlTitulo();
		pnlCabecera.addComponent(pnlTitulo);
		
		return pnlCabecera;
	}

	@AutoGenerated
	private VerticalLayout buildPnlTitulo() {
		// common part: create layout
		pnlTitulo = new VerticalLayout();
		pnlTitulo.setImmediate(false);
		pnlTitulo.setWidth("100.0%");
		pnlTitulo.setHeight("40px");
		pnlTitulo.setMargin(false);
		
		// lblTituloPanel
		lblTituloPanel = new Label();
		lblTituloPanel.setImmediate(false);
		lblTituloPanel.setWidth("-1px");
		lblTituloPanel.setHeight("-1px");
		lblTituloPanel.setValue("Label");
		pnlTitulo.addComponent(lblTituloPanel);
		pnlTitulo.setComponentAlignment(lblTituloPanel, new Alignment(48));
		
		return pnlTitulo;
	}

	
}
