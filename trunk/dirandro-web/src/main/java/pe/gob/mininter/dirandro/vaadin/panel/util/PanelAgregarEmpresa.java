package pe.gob.mininter.dirandro.vaadin.panel.util;

import java.util.List;

import pe.gob.mininter.dirandro.model.Empresa;
import pe.gob.mininter.dirandro.model.Persona;
import pe.gob.mininter.dirandro.service.EmpresaService;
import pe.gob.mininter.dirandro.service.PersonaService;
import pe.gob.mininter.dirandro.service.ValorService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.vaadin.util.Injector;
import pe.gob.mininter.dirandro.vaadin.util.listener.PanelAgregarEmpresaListener;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.AbstractSelect.Filtering;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PanelAgregarEmpresa extends CustomComponent implements ClickListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7961466367223811373L;
	
	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_4;
	@AutoGenerated
	private Button btnAgregar;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_3;
	@AutoGenerated
	private ComboBox cmbRepresentante;
	@AutoGenerated
	private TextField txtTelefono;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private TextField txtDireccion;
	@AutoGenerated
	private TextField txtPartidaReg;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private TextField txtRazonSocial;
	@AutoGenerated
	private TextField txtRuc;
	
	private EmpresaService empresaService;
	private PersonaService personaService;
	private ValorService valorService;
	
	private PanelAgregarEmpresaListener agregarEmpresaListener;

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelAgregarEmpresa() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		postConstruct();
	}

	private void postConstruct() {
		
		empresaService = Injector.obtenerServicio(EmpresaService.class);
		personaService = Injector.obtenerServicio(PersonaService.class);
		valorService = Injector.obtenerServicio(ValorService.class);
		
		cmbRepresentante.setInputPrompt(cmbRepresentante.getCaption());
		
		cargarRepresentantes();
		
		btnAgregar.addListener( (ClickListener) this  );
		
	}

	private void cargarRepresentantes() {
		List<Persona> personas = personaService.buscar(null);
		cmbRepresentante.setContainerDataSource(new BeanItemContainer<Persona>(Persona.class, personas));
		cmbRepresentante.setItemCaptionPropertyId("nombreCompleto");
		cmbRepresentante.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
		cmbRepresentante.setImmediate(true);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnAgregar)) {
			Empresa empresa = new Empresa();
			empresa.setRuc((String) txtRuc.getValue());
			empresa.setRazonSocial((String) txtRazonSocial.getValue());
			empresa.setPartidaRegistral((String) txtPartidaReg.getValue());//
			empresa.setDireccion((String) txtDireccion.getValue());//
			empresa.setTelefono((String) txtTelefono.getValue());//
			empresa.setPerPersona((Persona)cmbRepresentante.getValue());//
			empresa.setEstado(valorService.obtenerValor(Constante.LISTA.CODIGO.ESTADO, Constante.VALOR.CODIGO.ACTIVO));
			empresaService.crear(empresa);
			
			if(agregarEmpresaListener!=null){
				agregarEmpresaListener.setEmpresaPopUp(empresa);
			}
			
			getApplication().getMainWindow().removeWindow(getWindow());			
		}
	}
	public void setPanelAgregarEmpresaListener(
			PanelAgregarEmpresaListener agregarEmpresaListener) {
		this.agregarEmpresaListener = agregarEmpresaListener;
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
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		mainLayout.addComponent(horizontalLayout_1);
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		mainLayout.addComponent(horizontalLayout_2);
		
		// horizontalLayout_3
		horizontalLayout_3 = buildHorizontalLayout_3();
		mainLayout.addComponent(horizontalLayout_3);
		
		// horizontalLayout_4
		horizontalLayout_4 = buildHorizontalLayout_4();
		mainLayout.addComponent(horizontalLayout_4);
		mainLayout.setComponentAlignment(horizontalLayout_4, new Alignment(48));
		
		return mainLayout;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("100.0%");
		horizontalLayout_1.setHeight("-1px");
		horizontalLayout_1.setMargin(false);
		horizontalLayout_1.setSpacing(true);
		
		// txtRuc
		txtRuc = new TextField();
		txtRuc.setCaption("Ruc");
		txtRuc.setImmediate(false);
		txtRuc.setWidth("-1px");
		txtRuc.setHeight("-1px");
		txtRuc.setInputPrompt("Ruc");
		txtRuc.setSecret(false);
		horizontalLayout_1.addComponent(txtRuc);
		
		// txtRazonSocial
		txtRazonSocial = new TextField();
		txtRazonSocial.setCaption("Razón Social");
		txtRazonSocial.setImmediate(false);
		txtRazonSocial.setWidth("100.0%");
		txtRazonSocial.setHeight("-1px");
		txtRazonSocial.setInputPrompt("Razón Social");
		txtRazonSocial.setSecret(false);
		horizontalLayout_1.addComponent(txtRazonSocial);
		horizontalLayout_1.setExpandRatio(txtRazonSocial, 1.0f);
		
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
		
		// txtPartidaReg
		txtPartidaReg = new TextField();
		txtPartidaReg.setCaption("Partida Reg");
		txtPartidaReg.setImmediate(false);
		txtPartidaReg.setWidth("-1px");
		txtPartidaReg.setHeight("-1px");
		txtPartidaReg.setInputPrompt("Partida Reg");
		txtPartidaReg.setSecret(false);
		horizontalLayout_2.addComponent(txtPartidaReg);
		
		// txtDireccion
		txtDireccion = new TextField();
		txtDireccion.setCaption("Dirección");
		txtDireccion.setImmediate(false);
		txtDireccion.setWidth("100.0%");
		txtDireccion.setHeight("-1px");
		txtDireccion.setInputPrompt("Dirección");
		txtDireccion.setSecret(false);
		horizontalLayout_2.addComponent(txtDireccion);
		horizontalLayout_2.setExpandRatio(txtDireccion, 1.0f);
		
		return horizontalLayout_2;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_3() {
		// common part: create layout
		horizontalLayout_3 = new HorizontalLayout();
		horizontalLayout_3.setImmediate(false);
		horizontalLayout_3.setWidth("100.0%");
		horizontalLayout_3.setHeight("-1px");
		horizontalLayout_3.setMargin(false);
		horizontalLayout_3.setSpacing(true);
		
		// txtTelefono
		txtTelefono = new TextField();
		txtTelefono.setCaption("Teléfono");
		txtTelefono.setImmediate(false);
		txtTelefono.setWidth("-1px");
		txtTelefono.setHeight("-1px");
		txtTelefono.setInputPrompt("Teléfono");
		txtTelefono.setSecret(false);
		horizontalLayout_3.addComponent(txtTelefono);
		
		// cmbRepresentante
		cmbRepresentante = new ComboBox();
		cmbRepresentante.setCaption("Representante Legal");
		cmbRepresentante.setImmediate(false);
		cmbRepresentante.setWidth("100.0%");
		cmbRepresentante.setHeight("-1px");
		horizontalLayout_3.addComponent(cmbRepresentante);
		horizontalLayout_3.setExpandRatio(cmbRepresentante, 1.0f);
		
		return horizontalLayout_3;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_4() {
		// common part: create layout
		horizontalLayout_4 = new HorizontalLayout();
		horizontalLayout_4.setImmediate(false);
		horizontalLayout_4.setWidth("-1px");
		horizontalLayout_4.setHeight("-1px");
		horizontalLayout_4.setMargin(false);
		
		// btnAgregar
		btnAgregar = new Button();
		btnAgregar.setCaption("Agregar");
		btnAgregar.setImmediate(false);
		btnAgregar.setWidth("-1px");
		btnAgregar.setHeight("-1px");
		horizontalLayout_4.addComponent(btnAgregar);
		
		return horizontalLayout_4;
	}

}