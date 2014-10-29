package pe.gob.mininter.dirandro.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import pe.gob.mininter.dirandro.model.Expediente;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;

public class ReportePDF {

	@SuppressWarnings("deprecation")
	public static ByteArrayOutputStream exportarPdfAtestado(Expediente expediente){
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Document document = new Document(PageSize.A4, 5, 5, 20, 20);
		
		try {
			PdfWriter.getInstance(document, outputStream);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		document.open();
		
		List<Element> objects = null;
		try {
			objects = HTMLWorker.parseToList(
					new StringReader(
							"<div align=center>Atestado Nro "+expediente.getAutogenerado()+"</div>"
							+ "<div align=center>Asunto: "+expediente.getAsunto()+"</div>"
					), null, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Element element : objects){
	    	try {
				document.add(element);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		
		document.close();
		
		return outputStream;
	}
	
}
