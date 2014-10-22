package pe.gob.mininter.dirandro.vaadin.panel.parte;

import org.apache.log4j.Logger;

import pe.gob.mininter.dirandro.model.Pericia;
import pe.gob.mininter.dirandro.service.PericiaService;
import pe.gob.mininter.dirandro.vaadin.dialogs.AlertDialog;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

public class PanelRegistroAtestado extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout verticalLayout_1;
	@AutoGenerated
	private Button btnRegistrar;
	@AutoGenerated
	private TextArea txtDescrcipcionLogo;
	@AutoGenerated
	private PopupDateField dtPericia;
	@AutoGenerated
	private Label lblExpediente;
	private static final Logger logger = Logger.getLogger(PanelRegistroAtestado.class);
	private Pericia pericia;
	private PericiaService periciaService;
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelRegistroAtestado() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		periciaService = Injector.obtenerServicio(PericiaService.class);
		
		postConstruct();
		
	}

	private void postConstruct(){
		btnRegistrar.addListener(new ClickListener() {
			
			private static final long serialVersionUID = 4539783663387871432L;

			@Override
			public void buttonClick(ClickEvent event) {
				
				registraPericia();
				
			}
			
		});
			
	}
	
	public void registraPericia(){
		
		
		//periciaService.actualizar(pericia);
				
		AlertDialog alertDialog = new  AlertDialog("Actualización de Pericia", "Se ha actualizaod la pericia correctamente", "Aceptar", "400");
		getApplication().getMainWindow().addWindow(alertDialog);
		getApplication().getMainWindow().removeWindow(getWindow());
		
	}
	
	public Pericia getPericia() {
		return pericia;
	}

	public void setPericia(Pericia pericia) {
		this.pericia = pericia;
		cargaDatos();
	}

	private void cargaDatos(){
		
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
		
		// verticalLayout_1
		verticalLayout_1 = buildVerticalLayout_1();
		mainLayout.addComponent(verticalLayout_1);
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_1() {
		// common part: create layout
		verticalLayout_1 = new VerticalLayout();
		verticalLayout_1.setImmediate(false);
		verticalLayout_1.setWidth("500px");
		verticalLayout_1.setHeight("-1px");
		verticalLayout_1.setMargin(true);
		verticalLayout_1.setSpacing(true);
		
		// lblExpediente
		lblExpediente = new Label();
		lblExpediente.setImmediate(false);
		lblExpediente.setWidth("-1px");
		lblExpediente.setHeight("-1px");
		lblExpediente.setValue("Expediente : ");
		verticalLayout_1.addComponent(lblExpediente);
		
		// dtPericia
		dtPericia = new PopupDateField();
		dtPericia.setCaption("Fecha del Atestado");
		dtPericia.setImmediate(false);
		dtPericia.setWidth("150px");
		dtPericia.setHeight("-1px");
		dtPericia.setRequired(true);
		dtPericia.setResolution(4);
		verticalLayout_1.addComponent(dtPericia);
		
		// txtDescrcipcionLogo
		txtDescrcipcionLogo = new TextArea();
		txtDescrcipcionLogo.setCaption("Descripción del Atestado");
		txtDescrcipcionLogo.setImmediate(false);
		txtDescrcipcionLogo.setWidth("400px");
		txtDescrcipcionLogo.setHeight("-1px");
		txtDescrcipcionLogo.setInputPrompt("Descripción del Atestado");
		txtDescrcipcionLogo.setMaxLength(2000);
		verticalLayout_1.addComponent(txtDescrcipcionLogo);
		
		// btnRegistrar
		btnRegistrar = new Button();
		btnRegistrar.setCaption("Crear");
		btnRegistrar.setImmediate(true);
		btnRegistrar.setWidth("-1px");
		btnRegistrar.setHeight("-1px");
		verticalLayout_1.addComponent(btnRegistrar);
		verticalLayout_1.setComponentAlignment(btnRegistrar, new Alignment(48));
		
		return verticalLayout_1;
	}

}