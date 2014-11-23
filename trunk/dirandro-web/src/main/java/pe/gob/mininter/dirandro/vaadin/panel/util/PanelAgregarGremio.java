package pe.gob.mininter.dirandro.vaadin.panel.util;

import pe.gob.mininter.dirandro.model.GremioCocalero;
import pe.gob.mininter.dirandro.service.GremioService;
import pe.gob.mininter.dirandro.vaadin.dialogs.AlertDialog;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * Registrar Gremio cocalero
 * @author Elvis Campos
 * @since 22/11/2014
 *
 */
public class PanelAgregarGremio extends CustomComponent implements ClickListener{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/**
	 * 
	 */
	private static final long serialVersionUID = 368427746268947236L;

	@AutoGenerated
	private VerticalLayout mainLayout;

	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;

	@AutoGenerated
	private Button btnCancelar;

	@AutoGenerated
	private Button btnAgregar;

	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;

	@AutoGenerated
	private TextField txtNombre;

	private GremioCocalero gremioCocalero;
	private GremioService gremioService;
	
	public GremioCocalero getGremioCocalero() {
		return gremioCocalero;
	}

	public void setGremioCocalero(GremioCocalero gremioCocalero) {
		this.gremioCocalero = gremioCocalero;
	}

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelAgregarGremio() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		gremioService = Injector.obtenerServicio(GremioService.class);
		postConstruct();
		// TODO add user code here
	}

	private void postConstruct(){
	
		gremioCocalero = new GremioCocalero();
		btnAgregar.addListener((ClickListener)this);
		btnCancelar.addListener((ClickListener)this);
	}
	
	@Override
	public void buttonClick(ClickEvent event){
		if(event.getButton().equals(btnAgregar)) {
			gremioCocalero.setNombre((String)txtNombre.getValue());
			gremioService.crear(gremioCocalero);
			
			AlertDialog alertDialog = new  AlertDialog("Registro de Gremio Cocalero", "Se ha registrado el gremio cocalero correctamente", "Aceptar", "400");
			getApplication().getMainWindow().addWindow(alertDialog);
			
			btnAgregar.setEnabled(false);
			detach();
			getApplication().getMainWindow().removeWindow(getWindow());
			
		}
		if(event.getButton().equals(btnCancelar)) {
			
		}
	}
	
	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("500px");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true);
		
		// top-level component properties
		setWidth("500px");
		setHeight("-1px");
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		mainLayout.addComponent(horizontalLayout_1);
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		mainLayout.addComponent(horizontalLayout_2);
		
		return mainLayout;
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
		
		// txtNombre
		txtNombre = new TextField();
		txtNombre.setCaption("Nombre del Gremio");
		txtNombre.setImmediate(false);
		txtNombre.setWidth("-1px");
		txtNombre.setHeight("-1px");
		txtNombre.setRequired(true);
		txtNombre.setInputPrompt("Nombre del Gremio");
		horizontalLayout_1.addComponent(txtNombre);
		
		return horizontalLayout_1;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_2() {
		// common part: create layout
		horizontalLayout_2 = new HorizontalLayout();
		horizontalLayout_2.setImmediate(false);
		horizontalLayout_2.setWidth("100.0%");
		horizontalLayout_2.setHeight("-1px");
		horizontalLayout_2.setMargin(false);
		horizontalLayout_2.setSpacing(true);
		
		// btnAgregar
		btnAgregar = new Button();
		btnAgregar.setCaption("Grabar");
		btnAgregar.setImmediate(false);
		btnAgregar.setWidth("-1px");
		btnAgregar.setHeight("-1px");
		horizontalLayout_2.addComponent(btnAgregar);
		horizontalLayout_2.setComponentAlignment(btnAgregar, new Alignment(6));
		
		// btnCancelar
		btnCancelar = new Button();
		btnCancelar.setCaption("Cancelar");
		btnCancelar.setImmediate(false);
		btnCancelar.setWidth("-1px");
		btnCancelar.setHeight("-1px");
		horizontalLayout_2.addComponent(btnCancelar);
		
		return horizontalLayout_2;
	}

}
