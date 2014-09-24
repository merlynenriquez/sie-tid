package pe.gob.mininter.dirandro.vaadin.panel;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.ModeloMarca;
import pe.gob.mininter.dirandro.model.Telefono;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.ModeloMarcaService;
import pe.gob.mininter.dirandro.service.TelefonoService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.vaadin.dialogs.AlertDialog;
import pe.gob.mininter.dirandro.vaadin.util.ComboBoxLOVS;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;


public class PanelAgregarTelefono extends CustomComponent implements ClickListener{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlBody;
	@AutoGenerated
	private HorizontalLayout pnl6;
	@AutoGenerated
	private Button btnRegistrar;
	@AutoGenerated
	private HorizontalLayout pnl2;
	@AutoGenerated
	private ComboBox cmbEstado;
	@AutoGenerated
	private ComboBox cmbMarca;
	@AutoGenerated
	private ComboBox cmbTipo;
	@AutoGenerated
	private HorizontalLayout pnl1;
	@AutoGenerated
	private ComboBoxLOVS cmbFrecuencia;
	@AutoGenerated
	private TextField txtAlcance;
	@AutoGenerated
	private TextField txtImei;
	@AutoGenerated
	private TextField txtSerie;
	
	private static final long serialVersionUID = -7956048704434267119L;
	
	private PanelRegistroParteTelefono padre;
	private ModeloMarcaService modeloMarcaService;
	private TelefonoService telefonoService;
	private List<ModeloMarca> lstMarcas;
	
	public PanelAgregarTelefono() {
		buildMainLayout();
		modeloMarcaService = Injector.obtenerServicio(ModeloMarcaService.class);
		telefonoService = Injector.obtenerServicio(TelefonoService.class);
		setCompositionRoot(mainLayout);
		postConstruct();
		debugId();
	}
	
	private void debugId(){
		
	}
	
	public void setPadre(PanelRegistroParteTelefono padre) {
		this.padre = padre;
	}

	public void postConstruct() {
		btnRegistrar.addListener((ClickListener) this);
		cmbFrecuencia.setCodigoLista(Constante.LISTA.CODIGO.FRECUENCIA);
		cargarTiposComunicaciones();
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if (event.getButton().equals(btnRegistrar)) {
			Telefono telefono = new Telefono();
			telefono.setAlcance(txtAlcance.getValue() != null ? txtAlcance.getValue().toString() : StringUtils.EMPTY);
			telefono.setSerie(txtSerie.getValue() != null ? txtSerie.getValue().toString() : StringUtils.EMPTY);
			telefono.setMarca((ModeloMarca) cmbMarca.getValue());
			telefono.setFrecuencia(cmbFrecuencia.getValue() != null ? (Valor) cmbFrecuencia.getValue() : null);
			telefono.setImei(txtImei.getValue() != null ? txtImei.getValue().toString() : StringUtils.EMPTY);

			telefonoService.crear(telefono);
			btnRegistrar.setComponentError(null); 
			
			AlertDialog alertDialog = new  AlertDialog("Registro de Arma", "Se ha registrado el arma correctamente", "Aceptar", "400");
			getApplication().getMainWindow().addWindow(alertDialog);
			padre.actualizarTelefonos(telefono);
			getApplication().getMainWindow().removeWindow(getWindow());
		}
	}

	private void cargarTiposComunicaciones() {
		List<ModeloMarca> lstTiposEquipos = modeloMarcaService.buscarHijos(new ModeloMarca(Constante.MODELO_MARCA.COMUNICACIONES.COD_COMUNICACION));
		cmbTipo.setContainerDataSource(new BeanItemContainer<ModeloMarca>(ModeloMarca.class,  lstTiposEquipos));
		cmbTipo.setItemCaptionPropertyId("nombre");
		cmbTipo.setImmediate(true);
		cmbTipo.addListener(new Property.ValueChangeListener() {            
			
			private static final long serialVersionUID = -5023884380372631373L;

			@Override
            public void valueChange(ValueChangeEvent event) {
				if (cmbTipo.getValue() != null) {
					lstMarcas = modeloMarcaService.buscarHijos((ModeloMarca) cmbTipo.getValue());
					cmbMarca.setContainerDataSource(new BeanItemContainer<ModeloMarca>(ModeloMarca.class,lstMarcas));
					cmbMarca.setItemCaptionPropertyId("nombre");
				}
            }
        });
	}
	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("500px");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("500px");
		setHeight("-1px");
		
		// pnlBody
		pnlBody = buildPnlBody();
		mainLayout.addComponent(pnlBody);
		mainLayout.setComponentAlignment(pnlBody, new Alignment(20));
		
		return mainLayout;
	}
	@AutoGenerated
	private VerticalLayout buildPnlBody() {
		// common part: create layout
		pnlBody = new VerticalLayout();
		pnlBody.setStyleName("h2");
		pnlBody.setCaption("Registro del Equipo");
		pnlBody.setImmediate(false);
		pnlBody.setWidth("-1px");
		pnlBody.setHeight("-1px");
		pnlBody.setMargin(true);
		pnlBody.setSpacing(true);
		
		// pnl1
		pnl1 = buildPnl1();
		pnlBody.addComponent(pnl1);
		
		// pnl2
		pnl2 = buildPnl2();
		pnlBody.addComponent(pnl2);
		
		// pnl6
		pnl6 = buildPnl6();
		pnlBody.addComponent(pnl6);
		pnlBody.setComponentAlignment(pnl6, new Alignment(20));
		
		return pnlBody;
	}
	@AutoGenerated
	private HorizontalLayout buildPnl1() {
		// common part: create layout
		pnl1 = new HorizontalLayout();
		pnl1.setImmediate(false);
		pnl1.setWidth("-1px");
		pnl1.setHeight("-1px");
		pnl1.setMargin(false);
		pnl1.setSpacing(true);
		
		// txtSerie
		txtSerie = new TextField();
		txtSerie.setCaption("Serie");
		txtSerie.setImmediate(false);
		txtSerie.setWidth("100px");
		txtSerie.setHeight("-1px");
		pnl1.addComponent(txtSerie);
		
		// txtImei
		txtImei = new TextField();
		txtImei.setCaption("Imei");
		txtImei.setImmediate(false);
		txtImei.setWidth("110px");
		txtImei.setHeight("-1px");
		txtImei.setRequired(true);
		pnl1.addComponent(txtImei);
		
		// txtAlcance
		txtAlcance = new TextField();
		txtAlcance.setCaption("Radio/Alcance");
		txtAlcance.setImmediate(false);
		txtAlcance.setWidth("100px");
		txtAlcance.setHeight("-1px");
		pnl1.addComponent(txtAlcance);
		
		// cmbFrecuencia
		cmbFrecuencia = new ComboBoxLOVS();
		cmbFrecuencia.setCaption("Frecuencia");
		cmbFrecuencia.setImmediate(false);
		cmbFrecuencia.setWidth("130px");
		cmbFrecuencia.setHeight("-1px");
		pnl1.addComponent(cmbFrecuencia);
		
		return pnl1;
	}
	@AutoGenerated
	private HorizontalLayout buildPnl2() {
		// common part: create layout
		pnl2 = new HorizontalLayout();
		pnl2.setImmediate(false);
		pnl2.setWidth("-1px");
		pnl2.setHeight("-1px");
		pnl2.setMargin(false);
		pnl2.setSpacing(true);
		
		// cmbTipo
		cmbTipo = new ComboBox();
		cmbTipo.setCaption("Tipo");
		cmbTipo.setImmediate(false);
		cmbTipo.setWidth("150px");
		cmbTipo.setHeight("-1px");
		cmbTipo.setRequired(true);
		pnl2.addComponent(cmbTipo);
		
		// cmbMarca
		cmbMarca = new ComboBox();
		cmbMarca.setCaption("Marca");
		cmbMarca.setImmediate(false);
		cmbMarca.setWidth("150px");
		cmbMarca.setHeight("-1px");
		cmbMarca.setRequired(true);
		pnl2.addComponent(cmbMarca);
		
		// cmbEstado
		cmbEstado = new ComboBox();
		cmbEstado.setCaption("Estado");
		cmbEstado.setImmediate(false);
		cmbEstado.setWidth("150px");
		cmbEstado.setHeight("-1px");
		pnl2.addComponent(cmbEstado);
		
		return pnl2;
	}
	@AutoGenerated
	private HorizontalLayout buildPnl6() {
		// common part: create layout
		pnl6 = new HorizontalLayout();
		pnl6.setImmediate(false);
		pnl6.setWidth("-1px");
		pnl6.setHeight("-1px");
		pnl6.setMargin(true);
		pnl6.setSpacing(true);
		
		// btnRegistrar
		btnRegistrar = new Button();
		btnRegistrar.setCaption("Grabar");
		btnRegistrar.setImmediate(true);
		btnRegistrar.setWidth("-1px");
		btnRegistrar.setHeight("-1px");
		pnl6.addComponent(btnRegistrar);
		
		return pnl6;
	}
}