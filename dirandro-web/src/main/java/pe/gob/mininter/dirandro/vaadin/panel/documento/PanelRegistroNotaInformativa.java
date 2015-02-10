package pe.gob.mininter.dirandro.vaadin.panel.documento;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Date;
import java.util.List;

import org.vaadin.openesignforms.ckeditor.CKEditorConfig;

import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.NotaInformativa;
import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.service.ExpedienteService;
import pe.gob.mininter.dirandro.service.NotaInformativaService;
import pe.gob.mininter.dirandro.util.HarecUtil;
import pe.gob.mininter.dirandro.vaadin.dialogs.AlertDialog;
import pe.gob.mininter.dirandro.vaadin.util.DirandroComponent;
import pe.gob.mininter.dirandro.vaadin.util.Injector;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.html.simpleparser.StyleSheet;
import com.itextpdf.text.pdf.PdfWriter;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.terminal.StreamResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class PanelRegistroNotaInformativa extends DirandroComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout lytCuerpo;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_5;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_4;
	@AutoGenerated
	private Button btnExportar;
	@AutoGenerated
	private Button btnGrabar;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_3;
	@AutoGenerated
	private RichTextArea txtNota;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private PopupDateField dtRegistro;
	@AutoGenerated
	private ComboBox cmbExpediente;
	@AutoGenerated
	private Label lblNumero;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	/**
	 * 
	 */
	private static final long serialVersionUID = 293759736665740217L;
	protected StreamResource resource;
	private NotaInformativa notaInformativa;
	private NotaInformativaService notaInformativaService;
	private ExpedienteService expedienteService;
	private List<Expediente> lstExpedientes;
	
	public NotaInformativa getNotaInformativa() {
		return notaInformativa;
	}

	public void setNotaInformativa(NotaInformativa notaInformativa) {
		this.notaInformativa = notaInformativa;
		llenaNota();
	}

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelRegistroNotaInformativa(List<Opcion> acciones, String height) {
		super(acciones, height);
		notaInformativa = new NotaInformativa();
		notaInformativaService = Injector.obtenerServicio(NotaInformativaService.class);
		expedienteService = Injector.obtenerServicio(ExpedienteService.class);
		buildMainLayout();
		setCompositionRoot(mainLayout);
		
		postConstruct();
	}

	@Override
	public void postConstruct() {
		
		 CKEditorConfig config = new CKEditorConfig();
         config.useCompactTags();
         config.disableElementsPath();
         config.setResizeDir(CKEditorConfig.RESIZE_DIR.HORIZONTAL);
         config.disableSpellChecker();
         config.setToolbarCanCollapse(false);
         //config.addOpenESignFormsCustomToolbar();
         config.setWidth("100%");
         
         //final CKEditorTextField ckEditorTextField = new CKEditorTextField(config);
		
       //  cKEditorNota.setConfig(config);
         
		lstExpedientes = expedienteService.buscar(null);
		
		cmbExpediente.setInputPrompt("Expediente");
		cmbExpediente.setItemCaptionPropertyId("autogenerado");
		cmbExpediente.setContainerDataSource(new BeanItemContainer<Expediente>(Expediente.class, lstExpedientes));
		
		dtRegistro.setValue( new Date() );
		
		btnGrabar.addListener( new ClickListener() {
			
			private static final long serialVersionUID = 4037637201491238306L;

			@Override
			public void buttonClick(ClickEvent event) {
				guardarNotaInformativa();
			}
		});
		
		btnExportar.addListener( new ClickListener() {
			
			private static final long serialVersionUID = 6193560256581930602L;

			@Override
			public void buttonClick(ClickEvent event) {
				generaPdf();
			}
		});
	}

	private void generaPdf(){

		StreamResource.StreamSource source = new StreamResource.StreamSource() {
        
			private static final long serialVersionUID = 5222747902016377903L;

			public InputStream getStream() {
              	ByteArrayOutputStream baos = obtenerNota();
            	return new ByteArrayInputStream(baos.toByteArray());
            }
		};
		resource = new StreamResource(source, "nota_"+lblNumero.getValue().toString()+".pdf", getApplication());
		resource.setMIMEType("application/x-unknown");
		resource.setCacheTime(0);
		
		AlertDialog alertDialog=new AlertDialog("","Proceso de descarga iniciado","Aceptar","500px", resource);
		
		Window window=getApplication().getMainWindow().getWindow();
		window.getWindow().addWindow(alertDialog);
	
	}
	
	private ByteArrayOutputStream obtenerNota(){
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Document document = new Document(PageSize.A4, 30, 30, 20, 20);
		
		try {
			PdfWriter.getInstance(document, outputStream);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		document.open();
		
		StyleSheet styles = new StyleSheet();
        styles.loadStyle("pdfFont", "size", "8px");
        styles.loadStyle("pdfFont", "face", "times-roman");
		
		List<Element> objects = null;
		try {
			objects = HTMLWorker.parseToList( new StringReader( generarNota() ), styles, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (Element element : objects){
	    	try {
				document.add(element);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
	    }
		
		document.close();
		
		return outputStream;
	}
	
	public String generarNota(){
		return txtNota.getValue().toString();
	}
	
	private void llenaNota(){
		if(notaInformativa!=null){
			
			txtNota.setValue(notaInformativa.getContenido());
			lblNumero.setValue(notaInformativa.getNumero());
			dtRegistro.setValue(notaInformativa.getFechaRegistro());
			cmbExpediente.select(notaInformativa.getParte());
			
		}
	}
	
	private void guardarNotaInformativa(){

		//notaInformativa.setNumero(HarecUtil.nullToEmpty(lblNumero.getValue()));
		notaInformativa.setContenido(HarecUtil.nullToEmpty(txtNota.getValue()));
		notaInformativa.setFechaRegistro((Date)dtRegistro.getValue());
		notaInformativa.setParte((Expediente) cmbExpediente.getValue() );
		
		if(notaInformativa.esNuevo()){
			notaInformativaService.registrarNotaInformativa(notaInformativa);
		}else{
			notaInformativaService.actualizar(notaInformativa);
		}
		
		lblNumero.setValue(notaInformativa.getNumero());
		AlertDialog alertDialog = new  AlertDialog("Registro de Nota Informativa", "Se ha registrado la Nota Informativa correctamente", "Aceptar", "400");
		getApplication().getMainWindow().addWindow(alertDialog);
	
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
		
		// lytCuerpo
		lytCuerpo = buildLytCuerpo();
		mainLayout.addComponent(lytCuerpo);
		mainLayout.setComponentAlignment(lytCuerpo, new Alignment(20));
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildLytCuerpo() {
		// common part: create layout
		lytCuerpo = new VerticalLayout();
		lytCuerpo.setImmediate(false);
		lytCuerpo.setWidth("-1px");
		lytCuerpo.setHeight("-1px");
		lytCuerpo.setMargin(true);
		lytCuerpo.setSpacing(true);
		
		// horizontalLayout_1
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("-1px");
		horizontalLayout_1.setHeight("-1px");
		horizontalLayout_1.setMargin(false);
		horizontalLayout_1.setSpacing(true);
		lytCuerpo.addComponent(horizontalLayout_1);
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		lytCuerpo.addComponent(horizontalLayout_2);
		
		// horizontalLayout_3
		horizontalLayout_3 = buildHorizontalLayout_3();
		lytCuerpo.addComponent(horizontalLayout_3);
		
		// horizontalLayout_4
		horizontalLayout_4 = buildHorizontalLayout_4();
		lytCuerpo.addComponent(horizontalLayout_4);
		
		// horizontalLayout_5
		horizontalLayout_5 = new HorizontalLayout();
		horizontalLayout_5.setImmediate(false);
		horizontalLayout_5.setWidth("-1px");
		horizontalLayout_5.setHeight("-1px");
		horizontalLayout_5.setMargin(false);
		lytCuerpo.addComponent(horizontalLayout_5);
		
		return lytCuerpo;
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
		
		// lblNumero
		lblNumero = new Label();
		lblNumero.setCaption("Número de Nota");
		lblNumero.setImmediate(false);
		lblNumero.setWidth("150px");
		lblNumero.setHeight("-1px");
		lblNumero.setValue("   ");
		horizontalLayout_2.addComponent(lblNumero);
		
		// cmbExpediente
		cmbExpediente = new ComboBox();
		cmbExpediente.setCaption("Parte Policial");
		cmbExpediente.setImmediate(false);
		cmbExpediente.setWidth("250px");
		cmbExpediente.setHeight("-1px");
		horizontalLayout_2.addComponent(cmbExpediente);
		
		// dtRegistro
		dtRegistro = new PopupDateField();
		dtRegistro.setCaption("Fecha de Registro");
		dtRegistro.setImmediate(false);
		dtRegistro.setWidth("150px");
		dtRegistro.setHeight("-1px");
		dtRegistro.setResolution(4);
		horizontalLayout_2.addComponent(dtRegistro);
		
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
		
		// txtNota
		txtNota = new RichTextArea();
		txtNota.setImmediate(false);
		txtNota.setWidth("650px");
		txtNota.setHeight("250px");
		horizontalLayout_3.addComponent(txtNota);
		
		return horizontalLayout_3;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_4() {
		// common part: create layout
		horizontalLayout_4 = new HorizontalLayout();
		horizontalLayout_4.setImmediate(false);
		horizontalLayout_4.setWidth("100.0%");
		horizontalLayout_4.setHeight("-1px");
		horizontalLayout_4.setMargin(false);
		horizontalLayout_4.setSpacing(true);
		
		// btnGrabar
		btnGrabar = new Button();
		btnGrabar.setCaption("Grabar");
		btnGrabar.setImmediate(true);
		btnGrabar.setWidth("-1px");
		btnGrabar.setHeight("-1px");
		horizontalLayout_4.addComponent(btnGrabar);
		horizontalLayout_4.setComponentAlignment(btnGrabar, new Alignment(6));
		
		// btnExportar
		btnExportar = new Button();
		btnExportar.setCaption("Descargar");
		btnExportar.setImmediate(true);
		btnExportar.setWidth("-1px");
		btnExportar.setHeight("-1px");
		horizontalLayout_4.addComponent(btnExportar);
		
		return horizontalLayout_4;
	}

}
