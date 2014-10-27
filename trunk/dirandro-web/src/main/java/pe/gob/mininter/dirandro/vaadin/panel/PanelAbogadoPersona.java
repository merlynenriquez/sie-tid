package pe.gob.mininter.dirandro.vaadin.panel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import pe.gob.mininter.dirandro.model.AbogadoPersona;
import pe.gob.mininter.dirandro.model.DetExpedientePersona;
import pe.gob.mininter.dirandro.model.Letrado;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.AbogadoPersonaService;
import pe.gob.mininter.dirandro.service.LetradoService;
import pe.gob.mininter.dirandro.util.BeanValidar;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;
import pe.gob.mininter.dirandro.vaadin.dialogs.AlertDialog;
import pe.gob.mininter.dirandro.vaadin.dialogs.ConfirmDialog;
import pe.gob.mininter.dirandro.vaadin.util.ComboBoxLOVS;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
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
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class PanelAbogadoPersona extends CustomComponent implements ClickListener{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlPrincipal;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_3;
	@AutoGenerated
	private Table tblAbogadoPersona;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private Button btnRegistrar;
	@AutoGenerated
	private ComboBoxLOVS cmbEstado;
	@AutoGenerated
	private PopupDateField dtFechaIniRep;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_4;
	@AutoGenerated
	private ComboBox cmbAbogado;
	@AutoGenerated
	private Label label_1;
	private DetExpedientePersona persona;
	private LetradoService letradoService;
	private AbogadoPersonaService abogadoPersonaService;
	
	IndexedContainer container;
	
	private static final String COLUMN_ABOGADO_PERSONA = "COLUMN_ABOGADO_PERSONA";
	private static final String COLUMN_ABOGADO = "COLUMN_ABOGADO";
	private static final String COLUMN_FECHA = "COLUMN_FECHA";
	private static final String COLUMN_ELIMINAR = "COLUMN_ELIMINAR";
	
	public PanelAbogadoPersona(DetExpedientePersona persona) {
		buildMainLayout();
		letradoService=Injector.obtenerServicio(LetradoService.class);
		abogadoPersonaService=Injector.obtenerServicio(AbogadoPersonaService.class);
		this.persona=persona;
		setCompositionRoot(mainLayout);

		postConstruct();
	}

	public void postConstruct() {
		cmbEstado.setCodigoLista(Constante.LISTA.CODIGO.ESTADO);
		cmbEstado.setInputPrompt("Estado");
		Letrado letradoBus=new Letrado();
		Valor tipo=new Valor();
		tipo.setCodigo(Constante.VALOR.CODIGO.ABO);
		letradoBus.setTipo(tipo);
		List<Letrado> abogados=letradoService.buscar(letradoBus);
		cmbAbogado.setInputPrompt("Abogado");
		cmbAbogado.setItemCaptionPropertyId("nombreCompleto");
		cmbAbogado.setContainerDataSource(new BeanItemContainer<Letrado>(Letrado.class, abogados));
		
		btnRegistrar.addListener(this);
		
		container = new IndexedContainer();

		container.addContainerProperty(COLUMN_ABOGADO_PERSONA, AbogadoPersona.class,null);
		container. addContainerProperty(COLUMN_ABOGADO, String.class, null);
		container.addContainerProperty(COLUMN_FECHA, String.class, null);
		container.addContainerProperty(COLUMN_ELIMINAR, Button.class, null);

		tblAbogadoPersona.setContainerDataSource(container);

		tblAbogadoPersona.setColumnHeader(COLUMN_ABOGADO, "Abogado");
		tblAbogadoPersona.setColumnHeader(COLUMN_FECHA, "Fecha");
		tblAbogadoPersona.setColumnHeader(COLUMN_ELIMINAR, "");

		tblAbogadoPersona.setVisibleColumns(new Object[] {
				COLUMN_ABOGADO, COLUMN_FECHA,
				COLUMN_ELIMINAR});

		tblAbogadoPersona.setColumnWidth(COLUMN_ABOGADO, 140);
		tblAbogadoPersona.setColumnWidth(COLUMN_FECHA, 70);
		tblAbogadoPersona.setColumnWidth(COLUMN_ELIMINAR, 90);
		
		cargarAbogadosPersonas();
	}
	
	private void cargarAbogadosPersonas(){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		container.removeAllItems();
		
		List<AbogadoPersona> abogadoPersonas=abogadoPersonaService.listarAbogadoPersona();
		
		int con=1;
		for (final AbogadoPersona abogadoPersona : abogadoPersonas) {
			Item item = container.addItem(con++);
			item.getItemProperty(COLUMN_ABOGADO_PERSONA).setValue(abogadoPersona);
			item.getItemProperty(COLUMN_ABOGADO).setValue(abogadoPersona.getPerLetrado().getNombreCompleto());
			item.getItemProperty(COLUMN_FECHA).setValue(df.format(abogadoPersona.getFecIniRepresentacion()));
			Button eliminar=new Button();
			eliminar.setCaption("Eliminar");
			eliminar.addListener(new ClickListener() {
				
				@Override
				public void buttonClick(ClickEvent event) {
					ConfirmDialog.show(getApplication().getMainWindow(), "¿Desea elimiar el registro?",new ConfirmDialog.Listener() {
						
						/**
						 * 
						 */
						private static final long serialVersionUID = 1193668370224762969L;

						@Override
						public void onClose(ConfirmDialog dialog) {
							if (dialog.isConfirmed()) {
								abogadoPersonaService.eliminarXId(abogadoPersona.getId());
								AlertDialog alertDialog = new  AlertDialog("Abogados", "Se eliminó correctamente el registro", "Aceptar", "400");
								getApplication().getMainWindow().addWindow(alertDialog);
								cargarAbogadosPersonas();
							}
						}
					});
				}
			});
			item.getItemProperty(COLUMN_ELIMINAR).setValue(eliminar);
		}
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnRegistrar)){
			btnRegistar();
		}
	}
	
	private void btnRegistar(){
		AbogadoPersona abogadoPersona=new AbogadoPersona();
		abogadoPersona.setExpDetExpedientePersona(persona);
		abogadoPersona.setPerLetrado((Letrado)cmbAbogado.getValue());
		abogadoPersona.setFecIniRepresentacion((Date)dtFechaIniRep.getValue());
		//FIXME Base de datos
		Valor estado=cmbEstado.getValor();
		if(estado!=null){
			abogadoPersona.setEstado(estado.getId());
		}
		HarecUtil.validar(getWindow(), abogadoPersona, new BeanValidar[]{
			new BeanValidar("expDetExpedientePersona", new Object[]{"Abogado"}, cmbAbogado),
            new BeanValidar("fecIniRepresentacion", new Object[]{"Fecha representación"}, dtFechaIniRep),
            new BeanValidar("estado", new Object[]{"Estado"}, cmbEstado)});
		abogadoPersonaService.crear(abogadoPersona);
		cmbAbogado.setValue(null);
		cmbEstado.setValue(null);
		dtFechaIniRep.setValue(null);
		cargarAbogadosPersonas();
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
		pnlPrincipal.setHeight("300px");
		pnlPrincipal.setMargin(true);
		pnlPrincipal.setSpacing(true);
		
		// label_1
		label_1 = new Label();
		label_1.setStyleName("h2");
		label_1.setImmediate(false);
		label_1.setWidth("304px");
		label_1.setHeight("-1px");
		label_1.setValue("Abogados que representan al Implicado");
		pnlPrincipal.addComponent(label_1);
		pnlPrincipal.setComponentAlignment(label_1, new Alignment(20));
		
		// horizontalLayout_4
		horizontalLayout_4 = buildHorizontalLayout_4();
		pnlPrincipal.addComponent(horizontalLayout_4);
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		pnlPrincipal.addComponent(horizontalLayout_2);
		
		// horizontalLayout_3
		horizontalLayout_3 = buildHorizontalLayout_3();
		pnlPrincipal.addComponent(horizontalLayout_3);
		
		return pnlPrincipal;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_4() {
		// common part: create layout
		horizontalLayout_4 = new HorizontalLayout();
		horizontalLayout_4.setImmediate(false);
		horizontalLayout_4.setWidth("-1px");
		horizontalLayout_4.setHeight("-1px");
		horizontalLayout_4.setMargin(false);
		horizontalLayout_4.setSpacing(true);
		
		// cmbAbogado
		cmbAbogado = new ComboBox();
		cmbAbogado.setCaption("Abogado");
		cmbAbogado.setImmediate(false);
		cmbAbogado.setWidth("418px");
		cmbAbogado.setHeight("-1px");
		horizontalLayout_4.addComponent(cmbAbogado);
		
		return horizontalLayout_4;
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
		
		// dtFechaIniRep
		dtFechaIniRep = new PopupDateField();
		dtFechaIniRep.setCaption("Fecha representación");
		dtFechaIniRep.setImmediate(false);
		dtFechaIniRep.setWidth("127px");
		dtFechaIniRep.setHeight("-1px");
		horizontalLayout_2.addComponent(dtFechaIniRep);
		
		// cmbEstado
		cmbEstado = new ComboBoxLOVS();
		cmbEstado.setCaption("Estado");
		cmbEstado.setImmediate(false);
		cmbEstado.setWidth("118px");
		cmbEstado.setHeight("-1px");
		horizontalLayout_2.addComponent(cmbEstado);
		
		// btnRegistrar
		btnRegistrar = new Button();
		btnRegistrar.setCaption("Registrar");
		btnRegistrar.setImmediate(true);
		btnRegistrar.setWidth("-1px");
		btnRegistrar.setHeight("-1px");
		horizontalLayout_2.addComponent(btnRegistrar);
		horizontalLayout_2
				.setComponentAlignment(btnRegistrar, new Alignment(9));
		
		return horizontalLayout_2;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_3() {
		// common part: create layout
		horizontalLayout_3 = new HorizontalLayout();
		horizontalLayout_3.setImmediate(false);
		horizontalLayout_3.setWidth("-1px");
		horizontalLayout_3.setHeight("-1px");
		horizontalLayout_3.setMargin(false);
		horizontalLayout_3.setSpacing(true);
		
		// tblAbogadoPersona
		tblAbogadoPersona = new Table();
		tblAbogadoPersona.setImmediate(false);
		tblAbogadoPersona.setWidth("420px");
		tblAbogadoPersona.setHeight("120px");
		horizontalLayout_3.addComponent(tblAbogadoPersona);
		
		return horizontalLayout_3;
	}

}
