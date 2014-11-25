package pe.gob.mininter.dirandro.vaadin.panel.inteligencia;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.DetIntRuta;
import pe.gob.mininter.dirandro.model.Distrito;
import pe.gob.mininter.dirandro.model.Inteligencia;
import pe.gob.mininter.dirandro.model.RutaTid;
import pe.gob.mininter.dirandro.service.DetRutaTIDService;
import pe.gob.mininter.dirandro.service.RutaTIDService;
import pe.gob.mininter.dirandro.vaadin.panel.util.PanelAgregarRutaTID;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.AbstractSelect.Filtering;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class PanelRegistroInteligenciaRutaTID extends CustomComponent implements ClickListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlPrincipal;
	@AutoGenerated
	private Table tblRutaTID;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private Button btnRegistrar;
	@AutoGenerated
	private TextArea txaDescripcionDestino;
	@AutoGenerated
	private TextArea txaDescripcionOrigen;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private Button btnAgregar;
	@AutoGenerated
	private ComboBox cmbRutaTID;
	@AutoGenerated
	private Label lblDocumento;
	private PanelAgregarRutaTID pnlAgregarRutaTID;
	private RutaTid rutaTIDPopUp;
	
	private static final long serialVersionUID = 5897991320433962374L;
	
	private Inteligencia inteligencia;
	private RutaTIDService rutaTIDService;
	private DetRutaTIDService detRutaTIDService;
	
	public RutaTid getRutaTIDPopUp() {
		return rutaTIDPopUp;
	}

	public void setRutaTIDPopUp(RutaTid rutaTIDPopUp) {
		this.rutaTIDPopUp = rutaTIDPopUp;
	}

	public PanelRegistroInteligenciaRutaTID() {
		buildMainLayout();
		rutaTIDService = Injector.obtenerServicio(RutaTIDService.class);
		detRutaTIDService = Injector.obtenerServicio(DetRutaTIDService.class);
		setCompositionRoot(mainLayout);
		postConstruct();		
	}
	
	private void postConstruct(){
		btnAgregar.addListener((ClickListener)this);
		btnRegistrar.addListener((ClickListener)this);
		cmbRutaTID.setInputPrompt("Seleccione Ruta TID");
		List<RutaTid> lstRutaTid = rutaTIDService.buscar(null);
		actualizarRutaTID(lstRutaTid);
		cargarRutasTID();
	}

	public Inteligencia getInteligencia() {
		return inteligencia;
	}
	
	public void setInteligencia(Inteligencia inteligencia) {
		this.inteligencia = inteligencia;
	}
	
	private void cargarRutasTID(){
		limpiar();
		List<DetIntRuta> lstDetRutaTID = detRutaTIDService.buscar(null);
		cargarRutasTID(lstDetRutaTID);
	}

	private void cargarRutasTID(List<DetIntRuta> lstDetRutaTID) {
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("id", Long.class,  null);
		container.addContainerProperty("ruta", RutaTid.class, null);
		container.addContainerProperty("ruta.origen", Distrito.class, null);
		container.addContainerProperty("ruta.origen.nombre", String.class, null);
		container.addContainerProperty("ruta.destino", Distrito.class, null);
		container.addContainerProperty("ruta.destino.nombre", String.class, null);
		container.addContainerProperty("descripcionOrigen", String.class, null);
		container.addContainerProperty("descripcionDestino", String.class, null);
			
		tblRutaTID.setContainerDataSource(container);
		tblRutaTID.setVisibleColumns(new Object[]{"id","ruta.origen.nombre","ruta.destino.nombre","descripcionOrigen","descripcionDestino"});
		
		int con=1;
		for (DetIntRuta detRutaTID : lstDetRutaTID){
			Item item = container.addItem(con++);
			item.getItemProperty("id").setValue(detRutaTID.getId());
			item.getItemProperty("ruta").setValue(detRutaTID.getRuta());
			item.getItemProperty("ruta.origen").setValue(detRutaTID.getRuta().getOrigen());
			item.getItemProperty("ruta.origen.nombre").setValue(detRutaTID.getRuta().getOrigen().getNombre());
			item.getItemProperty("ruta.destino").setValue(detRutaTID.getRuta().getDestino());
			item.getItemProperty("ruta.destino.nombre").setValue(detRutaTID.getRuta().getDestino().getNombre());
			item.getItemProperty("descripcionOrigen").setValue(detRutaTID.getDescripcionOrigen());
			item.getItemProperty("descripcionDestino").setValue(detRutaTID.getDescripcionDestino());
		}
	}

	private void limpiar() {
		cmbRutaTID.select(null);
		txaDescripcionOrigen.setValue("");
		txaDescripcionDestino.setValue("");
	}

	@Override
	public void buttonClick(ClickEvent event) {
		
		if (event.getButton().equals(btnRegistrar)) {
			DetIntRuta detIntRuta = new DetIntRuta();
			detIntRuta.setRuta((RutaTid) cmbRutaTID.getValue());
			detIntRuta.setInteligencia(inteligencia);
			detIntRuta.setDescripcionOrigen(txaDescripcionOrigen.getValue() != null ? txaDescripcionOrigen.getValue().toString() : StringUtils.EMPTY);
			detIntRuta.setDescripcionDestino(txaDescripcionDestino.getValue() != null ? txaDescripcionDestino.getValue().toString() : StringUtils.EMPTY);
			detRutaTIDService.crear(detIntRuta);
		}
		
		if (event.getButton().equals(btnAgregar)) {
			pnlAgregarRutaTID = new PanelAgregarRutaTID();
				
			Window window=new Window(){
				
				private static final long serialVersionUID = 1L;

				  protected void close() {
					  getApplication().getMainWindow().removeWindow(getWindow());
				  }

				@Override
				public void detach() {
					setRutaTIDPopUp(pnlAgregarRutaTID.getRutaTid());
					actualizarRutaTID(rutaTIDService.buscar(null));
				}
				
			};
			window.setCaption("Registrar Ruta TID");
			window.addComponent(pnlAgregarRutaTID);
			window.setModal(true);
			window.setResizable(false);
			window.setWidth("550px");
			window.setHeight("-1px");
			getApplication().getMainWindow().addWindow(window);
		}
	}
	
	public void actualizarRutaTID(List<RutaTid> lstRutaTID) {
		cmbRutaTID.setContainerDataSource(new BeanItemContainer<RutaTid>(RutaTid.class, lstRutaTID));
		cmbRutaTID.setItemCaptionPropertyId("nombreCompleto");
		cmbRutaTID.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
		cmbRutaTID.setImmediate(true);
		
		if (rutaTIDPopUp != null) {
			for (RutaTid rutaTID : lstRutaTID) {
				if (rutaTID.getId().equals(rutaTIDPopUp.getId())){
					cmbRutaTID.select(rutaTID);
					break;
				}
			}
		}
	}
			
	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(true);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// pnlPrincipal
		pnlPrincipal = buildPnlPrincipal();
		mainLayout.addComponent(pnlPrincipal);
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildPnlPrincipal() {
		// common part: create layout
		pnlPrincipal = new VerticalLayout();
		pnlPrincipal.setImmediate(false);
		pnlPrincipal.setWidth("-1px");
		pnlPrincipal.setHeight("-1px");
		pnlPrincipal.setMargin(false);
		pnlPrincipal.setSpacing(true);
		
		// lblDocumento
		lblDocumento = new Label();
		lblDocumento.setImmediate(false);
		lblDocumento.setWidth("-1px");
		lblDocumento.setHeight("-1px");
		lblDocumento.setValue("Referencia del Documento Inteligencia: ");
		pnlPrincipal.addComponent(lblDocumento);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		pnlPrincipal.addComponent(horizontalLayout_1);
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		pnlPrincipal.addComponent(horizontalLayout_2);
		
		// tblRutaTID
		tblRutaTID = new Table();
		tblRutaTID.setImmediate(false);
		tblRutaTID.setWidth("700px");
		tblRutaTID.setHeight("200px");
		pnlPrincipal.addComponent(tblRutaTID);
		
		return pnlPrincipal;
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
		
		// cmbRutaTID
		cmbRutaTID = new ComboBox();
		cmbRutaTID.setImmediate(false);
		cmbRutaTID.setWidth("620px");
		cmbRutaTID.setHeight("-1px");
		horizontalLayout_1.addComponent(cmbRutaTID);
		
		// btnAgregar
		btnAgregar = new Button();
		btnAgregar.setCaption("Agregar");
		btnAgregar.setImmediate(true);
		btnAgregar.setWidth("-1px");
		btnAgregar.setHeight("-1px");
		horizontalLayout_1.addComponent(btnAgregar);
		
		return horizontalLayout_1;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_2() {
		// common part: create layout
		horizontalLayout_2 = new HorizontalLayout();
		horizontalLayout_2.setImmediate(false);
		horizontalLayout_2.setWidth("700px");
		horizontalLayout_2.setHeight("-1px");
		horizontalLayout_2.setMargin(false);
		horizontalLayout_2.setSpacing(true);
		
		// txaDescripcionOrigen
		txaDescripcionOrigen = new TextArea();
		txaDescripcionOrigen.setCaption("Descripcion del Punto de Origen");
		txaDescripcionOrigen.setImmediate(false);
		txaDescripcionOrigen.setWidth("300px");
		txaDescripcionOrigen.setHeight("80px");
		horizontalLayout_2.addComponent(txaDescripcionOrigen);
		
		// txaDescripcionDestino
		txaDescripcionDestino = new TextArea();
		txaDescripcionDestino.setCaption("Descripcion del Punto de Destino");
		txaDescripcionDestino.setImmediate(false);
		txaDescripcionDestino.setWidth("300px");
		txaDescripcionDestino.setHeight("80px");
		horizontalLayout_2.addComponent(txaDescripcionDestino);
		
		// btnRegistrar
		btnRegistrar = new Button();
		btnRegistrar.setCaption("Registrar");
		btnRegistrar.setImmediate(false);
		btnRegistrar.setWidth("-1px");
		btnRegistrar.setHeight("-1px");
		horizontalLayout_2.addComponent(btnRegistrar);
		horizontalLayout_2.setComponentAlignment(btnRegistrar,
				new Alignment(10));
		
		return horizontalLayout_2;
	}
}
