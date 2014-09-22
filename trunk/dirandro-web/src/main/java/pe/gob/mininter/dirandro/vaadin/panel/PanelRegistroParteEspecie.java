package pe.gob.mininter.dirandro.vaadin.panel;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.Especie;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.ModeloMarca;
import pe.gob.mininter.dirandro.model.TipoEspecie;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.ExpedienteEspecieService;
import pe.gob.mininter.dirandro.service.ModeloMarcaService;
import pe.gob.mininter.dirandro.service.TipoEspecieService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.vaadin.util.ComboBoxLOVS;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
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
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PanelRegistroParteEspecie extends CustomComponent implements ClickListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	
	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout pnlPrincipalEspecie;
	@AutoGenerated
	private Table tblEspListaEspecies;
	@AutoGenerated
	private Button btnEspRegistrar;
	@AutoGenerated
	private HorizontalLayout pnlEspecie2;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private TextField txtEspCantidad;
	@AutoGenerated
	private ComboBoxLOVS cmbEspEstado;
	@AutoGenerated
	private TextField txtEspMedida;
	@AutoGenerated
	private ComboBox cmbTipoMedida;
	@AutoGenerated
	private ComboBox cmbGeneralMedida;
	@AutoGenerated
	private HorizontalLayout pnlEspecie1;
	@AutoGenerated
	private ComboBoxLOVS cmbEspSituacion;
	@AutoGenerated
	private TextField txtEspNumeroSerie;
	@AutoGenerated
	private TextField txtEspNombre;
	@AutoGenerated
	private ComboBox cmbEspTipo;
	@AutoGenerated
	private ComboBox cmbEspFamilia;
	private static final long serialVersionUID = -5843290610457087118L;

	private TipoEspecieService tipoEspecieService;
	private ExpedienteEspecieService expEspecieService;
	private ModeloMarcaService modeloMarcaService;
	
	private List<TipoEspecie> lstTipoEspecies;
	private List<TipoEspecie> lstSubTipoEspecies;
	private List<ModeloMarca> lstTiposMedidas;
	private List<ModeloMarca> lstMedidas;
	
	private Expediente expediente;
	private Long idEspecie;
	private boolean flagNuevaEspecie;
	private boolean inicializado=false;
	
	public PanelRegistroParteEspecie() {
		super();
		tipoEspecieService = Injector.obtenerServicio(TipoEspecieService.class);
		expEspecieService = Injector.obtenerServicio(ExpedienteEspecieService.class);
		modeloMarcaService = Injector.obtenerServicio(ModeloMarcaService.class);
		buildMainLayout();
		setCompositionRoot(mainLayout);
		postConstruct();
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
		postConstruct();
	}

	public void postConstruct() {
		if(expediente!=null && !expediente.esNuevo() && !inicializado){
			cmbEspEstado.setCodigoLista(Constante.LISTA.CODIGO.ESTADO);
			cmbEspSituacion.setCodigoLista(Constante.LISTA.CODIGO.SITUACION_GENERAL);
			cmbEspEstado.attach();
			cmbEspSituacion.attach();
			
			cmbEspFamilia.setInputPrompt("Familia de Especies");
			cmbEspTipo.setInputPrompt("Tipos de Especies");
			cmbGeneralMedida.setInputPrompt("Tipos de Medidas");
			txtEspCantidad.setInputPrompt("Cantidad");
			cmbTipoMedida.setInputPrompt("Medida");
			cmbEspSituacion.setInputPrompt("Situacion Legal del Bien");
			cmbEspSituacion.setRequired(true);
			cmbEspEstado.setInputPrompt("Estado del Bien");
			btnEspRegistrar.addListener((ClickListener) this);
			
			cargarEspecies();
			cargarTiposMedidas();
			refrescar();
			
			tblEspListaEspecies.setSelectable(true);
			tblEspListaEspecies.setImmediate(true);
			tblEspListaEspecies.setNullSelectionAllowed(true);
			tblEspListaEspecies.setNullSelectionItemId(null);
			tblEspListaEspecies.addListener(new ValueChangeListener() {
				
				private static final long serialVersionUID = -3416533772693474159L;
	
				@Override
				public void valueChange(ValueChangeEvent event) {
					boolean esModoNuevo = tblEspListaEspecies.getValue() == null;
					limpiar();
					habilitarEdicion(!esModoNuevo);
					if (!esModoNuevo) {
						Item item = tblEspListaEspecies.getItem(tblEspListaEspecies.getValue());
						idEspecie = (Long) item.getItemProperty("id").getValue();
						txtEspNombre.setValue(item.getItemProperty("nombre").getValue());
						txtEspNumeroSerie.setValue(item.getItemProperty("nroSerie").getValue() != null ? item.getItemProperty("nroSerie").getValue() : StringUtils.EMPTY);
						txtEspMedida.setValue(item.getItemProperty("medida").getValue() != null ? item.getItemProperty("medida").getValue() : StringUtils.EMPTY);
						txtEspCantidad.setValue(item.getItemProperty("cantidad").getValue() != null ? item.getItemProperty("cantidad").getValue() : StringUtils.EMPTY);
						cmbEspSituacion.select(new Valor((Long) item.getItemProperty("situacion.id").getValue()));
						cmbEspEstado.select(new Valor((Long) item.getItemProperty("estado.id").getValue()));
						
						for (TipoEspecie tipoEspecie : lstTipoEspecies) {
							if(tipoEspecie.getId().equals((Long) item.getItemProperty("tipo.id").getValue())){
								cmbEspFamilia.select(tipoEspecie);
								break;
							}
						}
						
						for (TipoEspecie subTipoEspecie : lstSubTipoEspecies) {
							if(subTipoEspecie.getId().equals((Long) item.getItemProperty("subtipo.id").getValue())){
								cmbEspTipo.select(subTipoEspecie);
								break;
							}
						}
						
						for (ModeloMarca tipoMedida : lstTiposMedidas) {
							if(tipoMedida.getId().equals((Long) item.getItemProperty("tipoMedida.id").getValue())){
								cmbGeneralMedida.select(tipoMedida);
								break;
							}
						}	
						
						if (lstMedidas != null && lstMedidas.size() > 0) {
							for (ModeloMarca subTipoMedida : lstMedidas) {
								if(subTipoMedida.getId().equals((Long) item.getItemProperty("subTipoMedida.id").getValue())){
									cmbTipoMedida.select(subTipoMedida);
									break;
								}
							}
						}	
					}
				}
			});
			inicializado=true;
		}
	}
	
	private void cargarTiposMedidas(){
		lstTiposMedidas = modeloMarcaService.buscarHijos(new ModeloMarca(Constante.MODELO_MARCA.MEDIDA.COD_MEDIDA));
		cmbGeneralMedida.setContainerDataSource(new BeanItemContainer<ModeloMarca>(ModeloMarca.class,  lstTiposMedidas));
		cmbGeneralMedida.setItemCaptionPropertyId("nombre");
		cmbGeneralMedida.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
		cmbGeneralMedida.setImmediate(true);		
		cmbGeneralMedida.addListener(new ValueChangeListener() {
		
			private static final long serialVersionUID = -3416533772693474159L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				cargarMedidasChange(event);
			}

			private void cargarMedidasChange(ValueChangeEvent event) {
				lstMedidas = modeloMarcaService.buscarHijos((ModeloMarca) cmbGeneralMedida.getValue());
				cmbTipoMedida.setContainerDataSource(new BeanItemContainer<ModeloMarca>(ModeloMarca.class,  lstMedidas));
				cmbTipoMedida.setItemCaptionPropertyId("nombre");
				cmbTipoMedida.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
				cmbTipoMedida.setImmediate(true);
			}
		});
	}
	
	private void cargarEspecies(){
		lstTipoEspecies = tipoEspecieService.buscarPadres();
		cmbEspFamilia.setContainerDataSource(new BeanItemContainer<TipoEspecie>(TipoEspecie.class,  lstTipoEspecies));
		cmbEspFamilia.setItemCaptionPropertyId("nombre");
		cmbEspFamilia.addListener(new ValueChangeListener() {
			
			private static final long serialVersionUID = 6876725531841960773L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				cmbEspecieChange(event);
			}
			
			private void cmbEspecieChange(ValueChangeEvent event){
				lstSubTipoEspecies = tipoEspecieService.buscarHijos((TipoEspecie) cmbEspFamilia.getValue());
				cmbEspTipo.setContainerDataSource(new BeanItemContainer<TipoEspecie>(TipoEspecie.class,  lstSubTipoEspecies));
				cmbEspTipo.setItemCaptionPropertyId("nombre");
				cmbEspTipo.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
				if (lstSubTipoEspecies.size() != 0) cmbEspTipo.setEnabled(true);
			}
		});
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		
		if (event.getButton().equals(btnEspRegistrar)) {
			Especie expEspecie = new Especie();
			expEspecie.setNombre(txtEspNombre.getValue().toString());
			expEspecie.setSerie(txtEspNumeroSerie.getValue() != null ? txtEspNumeroSerie.getValue().toString() : StringUtils.EMPTY);
			expEspecie.setSituacion((Valor) cmbEspSituacion.getValue());
			expEspecie.setEstado(cmbEspEstado.getValue() != null ? (Valor) cmbEspEstado.getValue() : null);
			expEspecie.setTipoMedida(cmbTipoMedida.getValue() != null ?  (ModeloMarca) cmbTipoMedida.getValue() : null);
			expEspecie.setMedida(txtEspMedida.getValue() != "" ? Double.parseDouble(txtEspMedida.getValue().toString()) : null);
			expEspecie.setTipoEspecie((TipoEspecie) cmbEspTipo.getValue());
			expEspecie.setExpediente(expediente);
			expEspecie.setCantidad(Integer.parseInt(txtEspCantidad.getValue().toString()));
			expEspecie.validar();
			
			if(flagNuevaEspecie)			
				expEspecieService.crear(expEspecie);
			else{
				expEspecie.setId(idEspecie);
				expEspecieService.actualizar(expEspecie);
			}
			refrescar();
		}
	}
	
	private void cargarEspecies(List<Especie> lstEspecies){
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("id", Long.class,  null);
		container.addContainerProperty("nombre", String.class, null);
		container.addContainerProperty("tipo.id", Long.class, null);
		container.addContainerProperty("tipo.familia", String.class, null);
		container.addContainerProperty("subtipo.id", Long.class, null);
		container.addContainerProperty("subtipo.nombre", String.class, null);
		container.addContainerProperty("nroSerie", String.class, null);
		container.addContainerProperty("tipoMedida.id", Long.class, null);
		container.addContainerProperty("subTipoMedida.id", Long.class, null);
		container.addContainerProperty("tipoMedida.nombre", String.class, null);
		container.addContainerProperty("medida", Double.class, null);
		container.addContainerProperty("estado.id", Long.class, null);
		container.addContainerProperty("situacion.id", Long.class, null);
		container.addContainerProperty("situacion", String.class, null);
		container.addContainerProperty("cantidad", Integer.class, null);
		
		tblEspListaEspecies.setContainerDataSource(container);
		tblEspListaEspecies.setVisibleColumns(new Object[]{"nombre", "tipo.familia", "subtipo.nombre", "tipoMedida.nombre", "medida", "situacion"});
		
		tblEspListaEspecies.setColumnHeader("nombre", "Descripción");
		tblEspListaEspecies.setColumnHeader("tipo.familia", "Familia de Especie");
		tblEspListaEspecies.setColumnHeader("tipo.nombre", "Tipo de Especie");
		tblEspListaEspecies.setColumnHeader("nroSerie", "Nro. de Serie");
		tblEspListaEspecies.setColumnHeader("tipoMedida", "Tipo Medida");
		tblEspListaEspecies.setColumnHeader("medida", "Medida");
		tblEspListaEspecies.setColumnHeader("situacion", "Situación");
				
		int con=1;
		for (Especie especie : lstEspecies){
			Item item = container.addItem(con++);
			item.getItemProperty("id").setValue(especie.getId());
			item.getItemProperty("nombre").setValue(especie.getNombre());
			item.getItemProperty("tipo.id").setValue(especie.getTipoEspecie().getPadre().getId());
			item.getItemProperty("tipo.familia").setValue(especie.getTipoEspecie().getPadre().getNombre());
			item.getItemProperty("subtipo.id").setValue(especie.getTipoEspecie() != null ? especie.getTipoEspecie().getId() : StringUtils.EMPTY);
			item.getItemProperty("subtipo.nombre").setValue(especie.getTipoEspecie() != null ? especie.getTipoEspecie().getNombre() : StringUtils.EMPTY);
			item.getItemProperty("tipoMedida.id").setValue(especie.getTipoMedida() != null ? especie.getTipoMedida().getPadre().getId() : null);
			item.getItemProperty("subTipoMedida.id").setValue(especie.getTipoMedida() != null ? especie.getTipoMedida().getId() : null);
			item.getItemProperty("tipoMedida.nombre").setValue(especie.getTipoMedida() != null ? especie.getTipoMedida().getNombre() : StringUtils.EMPTY);
			item.getItemProperty("medida").setValue(especie.getMedida());
			item.getItemProperty("nroSerie").setValue(especie.getSerie());
			item.getItemProperty("estado.id").setValue(especie.getEstado() != null ? especie.getEstado().getId() : null);
			item.getItemProperty("situacion.id").setValue(especie.getSituacion() != null ? especie.getSituacion().getId() : null);
			item.getItemProperty("situacion").setValue(especie.getSituacion() != null ? especie.getSituacion().getNombre() : StringUtils.EMPTY);
			item.getItemProperty("cantidad").setValue(especie.getCantidad());
		}
	}
	
	private void habilitarEdicion(boolean flag){
		flagNuevaEspecie = !flag;
		if(flag){
			btnEspRegistrar.setCaption("Actualizar");
		}
		else{
			btnEspRegistrar.setCaption("Registrar");
		}
	}

	private void refrescar(){
		List<Especie> lstEspecies = expEspecieService.buscar(null);
		cargarEspecies(lstEspecies);
		limpiar();
	}
		
	private void limpiar(){
		cmbEspTipo.select(null);
		cmbEspFamilia.select(null);
		cmbGeneralMedida.select(null);
		cmbTipoMedida.select(null);
		cmbEspEstado.select(null);
		cmbEspSituacion.select(null);
		txtEspNombre.setValue("");
		txtEspNumeroSerie.setValue("");
		txtEspMedida.setValue("");
		txtEspCantidad.setValue("");
	}
			
	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("-1px");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("-1px");
		setHeight("-1px");
		
		// pnlPrincipalEspecie
		pnlPrincipalEspecie = buildPnlPrincipalEspecie();
		mainLayout.addComponent(pnlPrincipalEspecie);
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildPnlPrincipalEspecie() {
		// common part: create layout
		pnlPrincipalEspecie = new VerticalLayout();
		pnlPrincipalEspecie.setImmediate(false);
		pnlPrincipalEspecie.setWidth("-1px");
		pnlPrincipalEspecie.setHeight("-1px");
		pnlPrincipalEspecie.setMargin(true);
		pnlPrincipalEspecie.setSpacing(true);
		
		// pnlEspecie1
		pnlEspecie1 = buildPnlEspecie1();
		pnlPrincipalEspecie.addComponent(pnlEspecie1);
		
		// pnlEspecie2
		pnlEspecie2 = buildPnlEspecie2();
		pnlPrincipalEspecie.addComponent(pnlEspecie2);
		
		// btnEspRegistrar
		btnEspRegistrar = new Button();
		btnEspRegistrar.setCaption("Registrar");
		btnEspRegistrar.setImmediate(true);
		btnEspRegistrar.setWidth("-1px");
		btnEspRegistrar.setHeight("-1px");
		pnlPrincipalEspecie.addComponent(btnEspRegistrar);
		pnlPrincipalEspecie.setComponentAlignment(btnEspRegistrar,
				new Alignment(20));
		
		// tblEspListaEspecies
		tblEspListaEspecies = new Table();
		tblEspListaEspecies.setImmediate(false);
		tblEspListaEspecies.setWidth("900px");
		tblEspListaEspecies.setHeight("450px");
		pnlPrincipalEspecie.addComponent(tblEspListaEspecies);
		
		return pnlPrincipalEspecie;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlEspecie1() {
		// common part: create layout
		pnlEspecie1 = new HorizontalLayout();
		pnlEspecie1.setImmediate(false);
		pnlEspecie1.setWidth("-1px");
		pnlEspecie1.setHeight("-1px");
		pnlEspecie1.setMargin(false);
		pnlEspecie1.setSpacing(true);
		
		// cmbEspFamilia
		cmbEspFamilia = new ComboBox();
		cmbEspFamilia.setCaption("Familia de Especie");
		cmbEspFamilia.setImmediate(false);
		cmbEspFamilia.setWidth("200px");
		cmbEspFamilia.setHeight("-1px");
		cmbEspFamilia.setRequired(true);
		pnlEspecie1.addComponent(cmbEspFamilia);
		
		// cmbEspTipo
		cmbEspTipo = new ComboBox();
		cmbEspTipo.setCaption("Tipo de Especie");
		cmbEspTipo.setImmediate(false);
		cmbEspTipo.setWidth("180px");
		cmbEspTipo.setHeight("-1px");
		cmbEspTipo.setRequired(true);
		pnlEspecie1.addComponent(cmbEspTipo);
		
		// txtEspNombre
		txtEspNombre = new TextField();
		txtEspNombre.setCaption("Nombre");
		txtEspNombre.setImmediate(false);
		txtEspNombre.setWidth("180px");
		txtEspNombre.setHeight("-1px");
		txtEspNombre.setRequired(true);
		txtEspNombre.setInputPrompt("Nombre");
		txtEspNombre.setMaxLength(50);
		pnlEspecie1.addComponent(txtEspNombre);
		
		// txtEspNumeroSerie
		txtEspNumeroSerie = new TextField();
		txtEspNumeroSerie.setCaption("Número de Serie");
		txtEspNumeroSerie.setImmediate(false);
		txtEspNumeroSerie.setWidth("130px");
		txtEspNumeroSerie.setHeight("-1px");
		txtEspNumeroSerie.setInputPrompt("Número de Serie");
		pnlEspecie1.addComponent(txtEspNumeroSerie);
		
		// cmbEspSituacion
		cmbEspSituacion = new ComboBoxLOVS();
		cmbEspSituacion.setCaption("Situacion");
		cmbEspSituacion.setImmediate(false);
		cmbEspSituacion.setWidth("180px");
		cmbEspSituacion.setHeight("-1px");
		pnlEspecie1.addComponent(cmbEspSituacion);
		
		return pnlEspecie1;
	}

	@AutoGenerated
	private HorizontalLayout buildPnlEspecie2() {
		// common part: create layout
		pnlEspecie2 = new HorizontalLayout();
		pnlEspecie2.setImmediate(false);
		pnlEspecie2.setWidth("900px");
		pnlEspecie2.setHeight("-1px");
		pnlEspecie2.setMargin(false);
		pnlEspecie2.setSpacing(true);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		pnlEspecie2.addComponent(horizontalLayout_1);
		
		return pnlEspecie2;
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
		
		// cmbGeneralMedida
		cmbGeneralMedida = new ComboBox();
		cmbGeneralMedida.setCaption("Tipo de Medida");
		cmbGeneralMedida.setImmediate(false);
		cmbGeneralMedida.setWidth("200px");
		cmbGeneralMedida.setHeight("-1px");
		horizontalLayout_1.addComponent(cmbGeneralMedida);
		
		// cmbTipoMedida
		cmbTipoMedida = new ComboBox();
		cmbTipoMedida.setCaption("Medida");
		cmbTipoMedida.setImmediate(false);
		cmbTipoMedida.setWidth("180px");
		cmbTipoMedida.setHeight("-1px");
		horizontalLayout_1.addComponent(cmbTipoMedida);
		
		// txtEspMedida
		txtEspMedida = new TextField();
		txtEspMedida.setCaption("Cant. de la Medida");
		txtEspMedida.setImmediate(false);
		txtEspMedida.setWidth("160px");
		txtEspMedida.setHeight("-1px");
		txtEspMedida.setRequired(true);
		txtEspMedida.setInputPrompt("Cantidad de la Medida");
		txtEspMedida.setMaxLength(50);
		horizontalLayout_1.addComponent(txtEspMedida);
		
		// cmbEspEstado
		cmbEspEstado = new ComboBoxLOVS();
		cmbEspEstado.setCaption("Estado");
		cmbEspEstado.setImmediate(false);
		cmbEspEstado.setWidth("180px");
		cmbEspEstado.setHeight("-1px");
		horizontalLayout_1.addComponent(cmbEspEstado);
		
		// txtEspCantidad
		txtEspCantidad = new TextField();
		txtEspCantidad.setCaption("Cantidad");
		txtEspCantidad.setImmediate(false);
		txtEspCantidad.setWidth("130px");
		txtEspCantidad.setHeight("-1px");
		txtEspCantidad.setInputPrompt("Cantidad de Especies");
		horizontalLayout_1.addComponent(txtEspCantidad);
		
		return horizontalLayout_1;
	}

}
