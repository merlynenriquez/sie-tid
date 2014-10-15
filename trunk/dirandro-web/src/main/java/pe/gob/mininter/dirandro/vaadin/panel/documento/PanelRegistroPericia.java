package pe.gob.mininter.dirandro.vaadin.panel.documento;

import org.apache.log4j.Logger;

import pe.gob.mininter.dirandro.vaadin.util.UploadDirandro;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

public class PanelRegistroPericia extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout verticalLayout_2;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private VerticalLayout verticalLayout_1;
	@AutoGenerated
	private Button btnRegistrar;
	@AutoGenerated
	private TextArea txtDescrcipcionLogo;
	@AutoGenerated
	private UploadDirandro updLogo;
	@AutoGenerated
	private UploadDirandro updPericia;
	@AutoGenerated
	private ComboBox cmbEstadoPericia;
	@AutoGenerated
	private PopupDateField dtPericia;
	@AutoGenerated
	private Label lblMuestra;
	@AutoGenerated
	private Table tblPericias;
	private static final Logger logger = Logger.getLogger(PanelRegistroPericia.class);
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelRegistroPericia() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		cmbEstadoPericia.setInputPrompt("Estado de la Pericia");
		btnRegistrar.addListener(new ClickListener() {
			
			private static final long serialVersionUID = 4539783663387871432L;

			@Override
			public void buttonClick(ClickEvent event) {
				
				registraPericia();
				
			}
			
		});
	}

	public void registraPericia(){
		logger.debug(" en el registro ");
		logger.debug(" logo " + updLogo.getFilename() );
		logger.debug(" informe " + updPericia.getFilename() );
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
		
		// verticalLayout_2
		verticalLayout_2 = buildVerticalLayout_2();
		mainLayout.addComponent(verticalLayout_2);
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_2() {
		// common part: create layout
		verticalLayout_2 = new VerticalLayout();
		verticalLayout_2.setImmediate(false);
		verticalLayout_2.setWidth("-1px");
		verticalLayout_2.setHeight("-1px");
		verticalLayout_2.setMargin(false);
		verticalLayout_2.setSpacing(true);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		verticalLayout_2.addComponent(horizontalLayout_1);
		
		return verticalLayout_2;
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
		
		// tblPericias
		tblPericias = new Table();
		tblPericias.setImmediate(false);
		tblPericias.setWidth("300px");
		tblPericias.setHeight("-1px");
		horizontalLayout_1.addComponent(tblPericias);
		
		// verticalLayout_1
		verticalLayout_1 = buildVerticalLayout_1();
		horizontalLayout_1.addComponent(verticalLayout_1);
		
		return horizontalLayout_1;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_1() {
		// common part: create layout
		verticalLayout_1 = new VerticalLayout();
		verticalLayout_1.setImmediate(false);
		verticalLayout_1.setWidth("250px");
		verticalLayout_1.setHeight("-1px");
		verticalLayout_1.setMargin(false);
		verticalLayout_1.setSpacing(true);
		
		// lblMuestra
		lblMuestra = new Label();
		lblMuestra.setImmediate(false);
		lblMuestra.setWidth("-1px");
		lblMuestra.setHeight("-1px");
		lblMuestra.setValue("Label");
		verticalLayout_1.addComponent(lblMuestra);
		
		// dtPericia
		dtPericia = new PopupDateField();
		dtPericia.setCaption("Fecha de Pericia");
		dtPericia.setImmediate(false);
		dtPericia.setWidth("150px");
		dtPericia.setHeight("-1px");
		dtPericia.setRequired(true);
		dtPericia.setResolution(4);
		verticalLayout_1.addComponent(dtPericia);
		
		// cmbEstadoPericia
		cmbEstadoPericia = new ComboBox();
		cmbEstadoPericia.setCaption("Estado de Pericia");
		cmbEstadoPericia.setImmediate(false);
		cmbEstadoPericia.setWidth("250px");
		cmbEstadoPericia.setHeight("-1px");
		cmbEstadoPericia.setRequired(true);
		verticalLayout_1.addComponent(cmbEstadoPericia);
		
		// updPericia
		updPericia = new UploadDirandro();
		updPericia.setImmediate(false);
		updPericia.setWidth("-1px");
		updPericia.setHeight("-1px");
		verticalLayout_1.addComponent(updPericia);
		
		// updLogo
		updLogo = new UploadDirandro();
		updLogo.setImmediate(false);
		updLogo.setWidth("-1px");
		updLogo.setHeight("-1px");
		verticalLayout_1.addComponent(updLogo);
		
		// txtDescrcipcionLogo
		txtDescrcipcionLogo = new TextArea();
		txtDescrcipcionLogo.setCaption("Descripción del logo");
		txtDescrcipcionLogo.setImmediate(false);
		txtDescrcipcionLogo.setWidth("250px");
		txtDescrcipcionLogo.setHeight("-1px");
		txtDescrcipcionLogo.setInputPrompt("Descripción del logo");
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