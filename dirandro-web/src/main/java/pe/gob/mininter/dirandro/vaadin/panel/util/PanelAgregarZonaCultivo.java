package pe.gob.mininter.dirandro.vaadin.panel.util;

import java.math.BigDecimal;

import pe.gob.mininter.dirandro.model.Distrito;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.model.ZonaCultivo;
import pe.gob.mininter.dirandro.service.UbigeoService;
import pe.gob.mininter.dirandro.service.ZonaCultivoService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.vaadin.dialogs.AlertDialog;
import pe.gob.mininter.dirandro.vaadin.util.ComboBoxLOVS;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.AbstractSelect.Filtering;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PanelAgregarZonaCultivo extends CustomComponent implements ClickListener{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private Button btnRegistrar;
	@AutoGenerated
	private ComboBoxLOVS cmbTipoCultivo;
	@AutoGenerated
	private TextField txtHectareas;
	@AutoGenerated
	private ComboBox cmbUbicacion;
	
	private ZonaCultivo zonaCultivo;
	private ZonaCultivoService zonaCultivoService;
	private UbigeoService ubigeoService;
	
	public ZonaCultivo getZonaCultivo() {
		return zonaCultivo;
	}

	public void setZonaCultivo(ZonaCultivo zonaCultivo) {
		this.zonaCultivo = zonaCultivo;
	}

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelAgregarZonaCultivo() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		zonaCultivoService = Injector.obtenerServicio(ZonaCultivoService.class);
		ubigeoService = Injector.obtenerServicio(UbigeoService.class);
		postConstruct();
	}
	
	private void postConstruct(){
		
		zonaCultivo = new ZonaCultivo();
		
		cmbTipoCultivo.setCodigoLista(Constante.LISTA.CODIGO.TIPO_CULTIVO);
		cmbTipoCultivo.setInputPrompt("Tipo de Cultivo");
		
		cmbUbicacion.setInputPrompt("Distrito - Provincia - Departamento");
		cmbUbicacion.setItemCaptionPropertyId("nombreCompleto");
		cmbUbicacion.setContainerDataSource(new BeanItemContainer<Distrito>(Distrito.class,   ubigeoService.obtenerTodos()));
		cmbUbicacion.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
		
		btnRegistrar.addListener((ClickListener)this);
		
	}
	
	@Override
	public void buttonClick(ClickEvent event){
		if(event.getButton().equals(btnRegistrar)) {
			
			zonaCultivo.setDistrito((Distrito)cmbUbicacion.getValue());
			zonaCultivo.setHectareas(new BigDecimal((String)txtHectareas.getValue()));
			zonaCultivo.setTipoCultivo((Valor)cmbTipoCultivo.getValue());

			zonaCultivoService.crear(zonaCultivo);
			
			AlertDialog alertDialog = new  AlertDialog("Registro de Zona de Cultivo", "Se ha registrado la zona de cultivo correctamente", "Aceptar", "400");
			getApplication().getMainWindow().addWindow(alertDialog);
			
			btnRegistrar.setEnabled(false);
			detach();
			getApplication().getMainWindow().removeWindow(getWindow());
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
		
		// cmbUbicacion
		cmbUbicacion = new ComboBox();
		cmbUbicacion.setCaption("Ubicacion");
		cmbUbicacion.setImmediate(false);
		cmbUbicacion.setWidth("-1px");
		cmbUbicacion.setHeight("-1px");
		mainLayout.addComponent(cmbUbicacion);
		
		// txtHectareas
		txtHectareas = new TextField();
		txtHectareas.setCaption("Hectareas");
		txtHectareas.setImmediate(false);
		txtHectareas.setWidth("-1px");
		txtHectareas.setHeight("-1px");
		txtHectareas.setInputPrompt("Hectarias");
		txtHectareas.setMaxLength(10);
		mainLayout.addComponent(txtHectareas);
		
		// cmbTipoCultivo
		cmbTipoCultivo = new ComboBoxLOVS();
		cmbTipoCultivo.setCaption("Tipo de Cultuvo");
		cmbTipoCultivo.setImmediate(false);
		cmbTipoCultivo.setWidth("-1px");
		cmbTipoCultivo.setHeight("-1px");
		mainLayout.addComponent(cmbTipoCultivo);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		mainLayout.addComponent(horizontalLayout_1);
		
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
		
		// btnRegistrar
		btnRegistrar = new Button();
		btnRegistrar.setCaption("Registrar");
		btnRegistrar.setImmediate(false);
		btnRegistrar.setWidth("-1px");
		btnRegistrar.setHeight("-1px");
		horizontalLayout_1.addComponent(btnRegistrar);
		horizontalLayout_1.setComponentAlignment(btnRegistrar,
				new Alignment(20));
		
		return horizontalLayout_1;
	}

}
