package pe.gob.mininter.dirandro.vaadin.panel;

import java.util.ArrayList;
import java.util.List;


import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.model.Telefono;
import pe.gob.mininter.dirandro.vaadin.util.HarecComponent;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.util.AbstractBeanContainer.BeanIdResolver;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;


public class PanelBuscarTelefono extends HarecComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	
	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlPrincipal;
	@AutoGenerated
	private VerticalLayout verticalLayout_2;
	@AutoGenerated
	private Table tblInmuebles;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private Button button_1;
	@AutoGenerated
	private PopupDateField popupDateField_2;
	@AutoGenerated
	private PopupDateField popupDateField_1;
	@AutoGenerated
	private Label lblFechas;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private TextField txtNumero;
	private static final long serialVersionUID = -6241989533669580659L;
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelBuscarTelefono(List<Opcion> acciones, String height) {
		super(acciones, height);
		buildMainLayout();
		setCompositionRoot(mainLayout);
		postConstruct();
		debugId();
	}
	
	private void debugId(){
		
	}
	
	public void postConstruct() {
		
		
		List<Telefono> telefonos = new ArrayList<Telefono>();
		
		Telefono v = new Telefono();
		v.setId(Long.parseLong("1"));
		v.setNumero("998305147");
		
		telefonos.add(v);
		cargarListas(telefonos, true);
		
	}
	
		
	private void cargarListas(List<Telefono> telefonos, boolean flagLimpiar)
	{
		BeanContainer<Long, Telefono> container=new BeanContainer<Long, Telefono>(Telefono.class);
		container.setBeanIdResolver(new BeanIdResolver<Long, Telefono>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1609951986289481102L;

			@Override
			public Long getIdForBean(Telefono bean) {
				return bean.getId();
			}
			
		});
		container.addAll(telefonos);
		container.setBeanIdProperty("id");
		
		
		tblInmuebles.setContainerDataSource(container);
		tblInmuebles.setVisibleColumns(new Object[]{"numero"});
		tblInmuebles.setColumnWidth("id", 16);
		tblInmuebles.setColumnWidth("numero", 147);
		
		tblInmuebles.setColumnHeader("id", "Id");
		tblInmuebles.setColumnHeader("numero", "Número");
		
		
		
		/*
		if(flagLimpiar)
		{
			txtFiltroIdLista.setValue("");
			txtFiltroCodigoLista.setValue("");
			txtFiltroNombreLista.setValue("");
			txtFiltroEstadoLista.setValue("");
		}
		*/
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
		pnlPrincipal.setStyleName("whiteBackGround");
		pnlPrincipal.setImmediate(false);
		pnlPrincipal.setWidth("800px");
		pnlPrincipal.setHeight("-1px");
		pnlPrincipal.setMargin(true);
		pnlPrincipal.setSpacing(true);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		pnlPrincipal.addComponent(horizontalLayout_1);
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		pnlPrincipal.addComponent(horizontalLayout_2);
		
		// verticalLayout_2
		verticalLayout_2 = buildVerticalLayout_2();
		pnlPrincipal.addComponent(verticalLayout_2);
		
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
		
		// txtNumero
		txtNumero = new TextField();
		txtNumero.setCaption("Número Telefónico:");
		txtNumero.setImmediate(false);
		txtNumero.setWidth("-1px");
		txtNumero.setHeight("-1px");
		horizontalLayout_1.addComponent(txtNumero);
		
		return horizontalLayout_1;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_2() {
		// common part: create layout
		horizontalLayout_2 = new HorizontalLayout();
		horizontalLayout_2.setImmediate(false);
		horizontalLayout_2.setWidth("-1px");
		horizontalLayout_2.setHeight("-1px");
		horizontalLayout_2.setMargin(false);
		horizontalLayout_2.setSpacing(true);
		
		// lblFechas
		lblFechas = new Label();
		lblFechas.setImmediate(false);
		lblFechas.setWidth("-1px");
		lblFechas.setHeight("-1px");
		lblFechas.setValue("Rango de Expediente:");
		horizontalLayout_2.addComponent(lblFechas);
		horizontalLayout_2.setComponentAlignment(lblFechas, new Alignment(48));
		
		// popupDateField_1
		popupDateField_1 = new PopupDateField();
		popupDateField_1.setCaption("Fecha Inicial:");
		popupDateField_1.setImmediate(false);
		popupDateField_1.setWidth("-1px");
		popupDateField_1.setHeight("-1px");
		horizontalLayout_2.addComponent(popupDateField_1);
		
		// popupDateField_2
		popupDateField_2 = new PopupDateField();
		popupDateField_2.setCaption("Fecha Final");
		popupDateField_2.setImmediate(false);
		popupDateField_2.setWidth("-1px");
		popupDateField_2.setHeight("-1px");
		horizontalLayout_2.addComponent(popupDateField_2);
		
		// button_1
		button_1 = new Button();
		button_1.setCaption("Buscar");
		button_1.setImmediate(true);
		button_1.setWidth("-1px");
		button_1.setHeight("-1px");
		horizontalLayout_2.addComponent(button_1);
		horizontalLayout_2.setComponentAlignment(button_1, new Alignment(9));
		
		return horizontalLayout_2;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_2() {
		// common part: create layout
		verticalLayout_2 = new VerticalLayout();
		verticalLayout_2.setImmediate(false);
		verticalLayout_2.setWidth("-1px");
		verticalLayout_2.setHeight("-1px");
		verticalLayout_2.setMargin(false);
		
		// tblInmuebles
		tblInmuebles = new Table();
		tblInmuebles.setImmediate(false);
		tblInmuebles.setWidth("-1px");
		tblInmuebles.setHeight("350px");
		verticalLayout_2.addComponent(tblInmuebles);
		
		return verticalLayout_2;
	}	
	
	
	
	

}
