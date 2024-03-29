package pe.gob.mininter.dirandro.vaadin.panel.caso;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.Adjunto;
import pe.gob.mininter.dirandro.model.Caso;
import pe.gob.mininter.dirandro.model.DetCasoImagen;
import pe.gob.mininter.dirandro.model.Parametro;
import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.CasoImagenService;
import pe.gob.mininter.dirandro.service.ParametroService;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.HarecUtil;
import pe.gob.mininter.dirandro.vaadin.dialogs.AlertDialog;
import pe.gob.mininter.dirandro.vaadin.util.AdjuntarReceiver;
import pe.gob.mininter.dirandro.vaadin.util.ComboBoxLOVS;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.terminal.FileResource;
import com.vaadin.terminal.StreamResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ProgressIndicator;
import com.vaadin.ui.Table;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.FailedEvent;
import com.vaadin.ui.Upload.FinishedEvent;
import com.vaadin.ui.Upload.StartedEvent;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class PanelRegistroCasoImagen extends CustomComponent implements ClickListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout verticalLayout_1;
	@AutoGenerated
	private HorizontalLayout lytTablaImagen;
	@AutoGenerated
	private Table tblAdjunto;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private Label lblDatosAdjunto;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private Button btnAgregar;
	@AutoGenerated
	private HorizontalLayout lytUpload;
	@AutoGenerated
	private Button btnCancelar;
	@AutoGenerated
	private ProgressIndicator progressAdjunto;
	@AutoGenerated
	private ComboBoxLOVS cmbTipoAdjunto;
	@AutoGenerated
	private Label lblTipo;
	/**
	 * 
	 */
	private static final long serialVersionUID = 387458988852768651L;
	
	//** Variables para los Adjuntos **//
	
	private Adjunto imagenAdjunta = null;
	private Caso caso;
	private DetCasoImagen casoImagen;
	private List<DetCasoImagen> lstAdjunto;
	protected StreamResource resource;
	
	private AdjuntarReceiver receiver=new AdjuntarReceiver();
	private Upload uploadImagen = new Upload(null, receiver);
	private long imageSize = 0;
	private Embedded image;
	private String rutaDocumento;
	private Parametro parametroSize;
	private Parametro parametroRuta;
	private boolean inicializado=false;
	private IndexedContainer container;
	
	private CasoImagenService casoImagenService;
	private ParametroService parametroService;
	
	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
		postConstruct();
	}

	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelRegistroCasoImagen() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		
		parametroService = Injector.obtenerServicio(ParametroService.class);
		casoImagenService = Injector.obtenerServicio(CasoImagenService.class);
		
		postConstruct();
	}

	private void postConstruct(){
		if(caso!=null && !caso.esNuevo() && !inicializado){
			
			limpiar();
			
			parametroSize = parametroService.obtener(Constante.PARAMETRO.ADJUNTOS_SIZE);
			if (parametroSize != null) imageSize = Long.valueOf(parametroSize.getValor());
			
			parametroRuta = parametroService.obtener(Constante.PARAMETRO.ADJUNTOS_PATH);
			if (parametroRuta != null) rutaDocumento = parametroRuta.getValor();
			
			//rutaDocumento += "CASO_"+caso.getId() + "\\";
			
			btnAgregar.addListener((ClickListener)this);
			cmbTipoAdjunto.setInputPrompt("Tipo");
			cmbTipoAdjunto.setCodigoLista(Constante.LISTA.CODIGO.ADJUNTO_TIPO);
			cmbTipoAdjunto.attach();
			
			uploadImagen.setImmediate(true);
			uploadImagen.setButtonCaption("Seleccionar Imagen");
			uploadImagenAddListener();
			
			container = new IndexedContainer();
			container.addContainerProperty("adjunto", Adjunto.class, null);
			container.addContainerProperty("imagen.id", Long.class, null);
			container.addContainerProperty("adjunto.ruta", String.class, null);
			container.addContainerProperty("nombreAdjunto", String.class, null);
			container.addContainerProperty("tipoAdjunto", String.class, null);
			container.addContainerProperty("descargar", Button.class, null);
			
			tblAdjunto.setSelectable(true);
			tblAdjunto.setImmediate(true);
			tblAdjunto.setNullSelectionAllowed(true);
			tblAdjunto.setNullSelectionItemId(null);
			tblAdjunto.addListener(new ValueChangeListener() {
				
				private static final long serialVersionUID = 6266199513918003163L;

				@Override
				public void valueChange(ValueChangeEvent event) {
					
					boolean esModoNuevo = tblAdjunto.getValue() == null;
					limpiar();
					if(esModoNuevo){
						tblAdjunto.setValue(null);
					}else {
						Item item = tblAdjunto.getItem(tblAdjunto.getValue());
						String ruta = item.getItemProperty("adjunto.ruta").getValue().toString();
						String id = item.getItemProperty("imagen.id").getValue().toString();
						String ext = item.getItemProperty("nombreAdjunto").getValue().toString();
						ext = ext.substring(ext.lastIndexOf('.'), ext.length());
						String cadena = ruta+"/"+ id+ext;
						FileResource resource = new FileResource(new File(cadena), getApplication());
						image = new Embedded(null, resource);
						image.setSizeFull();
						lytTablaImagen.addComponent(image);
					}
				}
			});
			//ponerle nombre proIndImagen
			progressAdjunto.setImmediate(true);
			progressAdjunto.setVisible(false);
			
			btnCancelar.setVisible(false);
			btnCancelar.addListener((ClickListener)this);
			
			llenaPanelImagenes();
			
			lytUpload.addComponent(uploadImagen);
		}
	}
	
	private void llenaPanelImagenes(){
		
		DetCasoImagen casoImg = new DetCasoImagen();
		casoImg.setCaso(caso);
		lstAdjunto = casoImagenService.buscar(casoImg);
		container.removeAllItems();
		int con=1;
		if ( lstAdjunto != null) {
	    	 for (DetCasoImagen imagen: lstAdjunto) {
	             Item item = container.addItem(con++);
	             item.getItemProperty("adjunto").setValue(imagen.getAdjunto());
	             item.getItemProperty("imagen.id").setValue(imagen.getAdjunto().getId());
	             item.getItemProperty("adjunto.ruta").setValue(imagen.getAdjunto().getRuta());
	             item.getItemProperty("nombreAdjunto").setValue(imagen.getAdjunto().getNombre());
	             item.getItemProperty("tipoAdjunto").setValue(HarecUtil.valorNombreToEmpty(imagen.getAdjunto().getTipo()));
	             
	             Button detailsField = new Button("Descargar");
			    detailsField.setData(imagen.getAdjunto());
			    detailsField.addListener(new ClickListener() {
					
			    	private static final long serialVersionUID = 5141713121939621261L;

					public void buttonClick(ClickEvent event) {
						descargarAdjunto((Adjunto)event.getButton().getData());
			        }
					
			    });
				item.getItemProperty("descargar").setValue( detailsField );
				
	        }
	    }
		
		tblAdjunto.setContainerDataSource(container);
		tblAdjunto.setVisibleColumns(new Object[]{"tipoAdjunto","nombreAdjunto","descargar"});
	    
	}
	
	private void descargarAdjunto(Adjunto data) {
		
		StreamResource.StreamSource source = new StreamResource.StreamSource() {
            
			private static final long serialVersionUID = 6296851438338689255L;

			public InputStream getStream() {
				Item item = container.getItem(tblAdjunto.getValue());
				Adjunto ad= (Adjunto)item.getItemProperty("adjunto").getValue(); 
            	String ruta = ad.getRuta();
				String id = ad.getId().toString();
				String ext = ad.getNombre();
				
				ext = ext.substring(ext.lastIndexOf('.'), ext.length());
				String cadena = ruta+"/"+ id+ext;
				FileResource resource = new FileResource(new File(cadena), getApplication());
				File f = resource.getSourceFile();
				
				byte[] bies=null;
				try {
					bies = FileUtils.readFileToByteArray(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
            	return new ByteArrayInputStream(bies);
            }
		};
		
		resource = new StreamResource(source, data.getNombre() , getApplication());
		resource.setMIMEType(data.getTipoAdjunto());
		resource.setCacheTime(0);
		
		AlertDialog alertDialog=new AlertDialog("","Proceso de descarga iniciado","Aceptar","500px", resource);
		
		Window window=getApplication().getMainWindow().getWindow();
		window.getWindow().addWindow(alertDialog);
	
		
		
	}

	@Override
	public void buttonClick(ClickEvent event) {
		
		casoImagen.setAdjunto(imagenAdjunta);
		casoImagenService.registrarAdjunta(casoImagen);
		limpiar();
		llenaPanelImagenes();
		
	}
	
	private void uploadImagenAddListener(){
		
        uploadImagen.addListener(new Upload.StartedListener() {
            
			private static final long serialVersionUID = -4333306723016937219L;

			public void uploadStarted(StartedEvent event) {
				if(!HarecUtil.valorNombreToEmpty(cmbTipoAdjunto.getValor()).equals("")){
					progressAdjunto.setValue(0f);
					progressAdjunto.setVisible(true);
					progressAdjunto.setPollingInterval(500);
					uploadImagen.setVisible(false);
					btnCancelar.setVisible(true);
				}else {
					uploadImagen.interruptUpload();
					lblDatosAdjunto.setValue("Debe seleccionar el tipo de adjunto");
				}
            }
        });

        uploadImagen.addListener(new Upload.ProgressListener() {
            
			private static final long serialVersionUID = 1289208147047286098L;

			public void updateProgress(long readBytes, long contentLength) {
				progressAdjunto.setValue(new Float(readBytes / (float) contentLength));
            }
        });

        uploadImagen.addListener(new Upload.SucceededListener() {
            
			private static final long serialVersionUID = -3769903056311972921L;

			public void uploadSucceeded(SucceededEvent event) {
				
				if (event.getLength() > imageSize) {
					uploadImagen.interruptUpload();
					lblDatosAdjunto.setValue("La imagen es muy pesada, no se ha podido cargar");
					return;
				}
				
				try {
					String extension = FilenameUtils.getExtension(event.getFilename());
					validarNombreArchivo(event.getFilename());
					AdjuntarReceiver receiver = (AdjuntarReceiver)uploadImagen.getReceiver();
					ByteArrayOutputStream outputStream= receiver.getOutputStream();					
					imagenAdjunta = new Adjunto();
					imagenAdjunta.setNombre(StringUtils.replace(event.getFilename(), " ","_"));
					imagenAdjunta.setTipo((Valor) cmbTipoAdjunto.getValue());
					imagenAdjunta.setOutputStream(outputStream);
					imagenAdjunta.setTipoAdjunto(event.getMIMEType());
					imagenAdjunta.setExtension(extension);
					imagenAdjunta.setFechaCarga(new Date());
					imagenAdjunta.setRuta(rutaDocumento);
					lblDatosAdjunto.setValue(imagenAdjunta.getTipo().getNombre()+" - "+imagenAdjunta.getNombre());
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });

        uploadImagen.addListener(new Upload.FailedListener() {
            
			private static final long serialVersionUID = 7920554199992944051L;

			public void uploadFailed(FailedEvent event) {
				//Mensaje de Error
            }
        });

        uploadImagen.addListener(new Upload.FinishedListener() {
            
			private static final long serialVersionUID = 6264348242537253603L;

			public void uploadFinished(FinishedEvent event) {
				progressAdjunto.setVisible(false);
            	btnCancelar.setVisible(false);
                uploadImagen.setVisible(true);
            }
        });
	}


	private void validarNombreArchivo(String nombreArchivo){
		nombreArchivo = StringUtils.replace(nombreArchivo, " ","_");
	}
	
	private void limpiar(){
		
		casoImagen = new DetCasoImagen();
		casoImagen.setCaso(caso);
		
		if(image!=null)
			lytTablaImagen.removeComponent(image);
		
		cmbTipoAdjunto.select(null);
		lblDatosAdjunto.setValue("");
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
		verticalLayout_1.setWidth("100.0%");
		verticalLayout_1.setHeight("-1px");
		verticalLayout_1.setMargin(true);
		verticalLayout_1.setSpacing(true);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		verticalLayout_1.addComponent(horizontalLayout_1);
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		verticalLayout_1.addComponent(horizontalLayout_2);
		
		// lytTablaImagen
		lytTablaImagen = buildLytTablaImagen();
		verticalLayout_1.addComponent(lytTablaImagen);
		
		return verticalLayout_1;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("-1px");
		horizontalLayout_1.setHeight("-1px");
		horizontalLayout_1.setMargin(false);
		
		// lytUpload
		lytUpload = buildLytUpload();
		horizontalLayout_1.addComponent(lytUpload);
		
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
	private HorizontalLayout buildLytUpload() {
		// common part: create layout
		lytUpload = new HorizontalLayout();
		lytUpload.setImmediate(false);
		lytUpload.setWidth("-1px");
		lytUpload.setHeight("-1px");
		lytUpload.setMargin(false);
		
		// lblTipo
		lblTipo = new Label();
		lblTipo.setImmediate(false);
		lblTipo.setWidth("-1px");
		lblTipo.setHeight("-1px");
		lblTipo.setValue("Tipo de Adjunto");
		lytUpload.addComponent(lblTipo);
		
		// cmbTipoAdjunto
		cmbTipoAdjunto = new ComboBoxLOVS();
		cmbTipoAdjunto.setImmediate(false);
		cmbTipoAdjunto.setWidth("100px");
		cmbTipoAdjunto.setHeight("-1px");
		lytUpload.addComponent(cmbTipoAdjunto);
		
		// progressAdjunto
		progressAdjunto = new ProgressIndicator();
		progressAdjunto.setImmediate(false);
		progressAdjunto.setWidth("-1px");
		progressAdjunto.setHeight("-1px");
		lytUpload.addComponent(progressAdjunto);
		
		// btnCancelar
		btnCancelar = new Button();
		btnCancelar.setCaption("Cancelar");
		btnCancelar.setImmediate(true);
		btnCancelar.setWidth("-1px");
		btnCancelar.setHeight("-1px");
		lytUpload.addComponent(btnCancelar);
		
		return lytUpload;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_2() {
		// common part: create layout
		horizontalLayout_2 = new HorizontalLayout();
		horizontalLayout_2.setImmediate(false);
		horizontalLayout_2.setWidth("100.0%");
		horizontalLayout_2.setHeight("-1px");
		horizontalLayout_2.setMargin(false);
		
		// lblDatosAdjunto
		lblDatosAdjunto = new Label();
		lblDatosAdjunto.setImmediate(false);
		lblDatosAdjunto.setWidth("100.0%");
		lblDatosAdjunto.setHeight("-1px");
		lblDatosAdjunto.setValue("Label");
		horizontalLayout_2.addComponent(lblDatosAdjunto);
		
		return horizontalLayout_2;
	}

	@AutoGenerated
	private HorizontalLayout buildLytTablaImagen() {
		// common part: create layout
		lytTablaImagen = new HorizontalLayout();
		lytTablaImagen.setImmediate(false);
		lytTablaImagen.setWidth("100.0%");
		lytTablaImagen.setHeight("-1px");
		lytTablaImagen.setMargin(false);
		
		// tblAdjunto
		tblAdjunto = new Table();
		tblAdjunto.setImmediate(false);
		tblAdjunto.setWidth("500px");
		tblAdjunto.setHeight("200px");
		lytTablaImagen.addComponent(tblAdjunto);
		
		return lytTablaImagen;
	}

	

}
