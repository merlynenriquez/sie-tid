package pe.gob.mininter.dirandro.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteHibernate;
import pe.gob.mininter.dirandro.model.Adjunto;
import pe.gob.mininter.dirandro.model.Documento;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.Parametro;
import pe.gob.mininter.dirandro.service.AdjuntoService;
import pe.gob.mininter.dirandro.service.DocumentoService;
import pe.gob.mininter.dirandro.service.ExpedienteService;
import pe.gob.mininter.dirandro.service.ParametroService;
import pe.gob.mininter.dirandro.service.ValorService;
import pe.gob.mininter.dirandro.util.Constante;

@Service
public class ExpedienteServiceImpl extends BaseServiceImpl<Expediente, Long> implements ExpedienteService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 852185817306565470L;
		
	@Autowired
	private DocumentoService documentoService;
	
	@Autowired
	private ParametroService parametroService;
	
	@Autowired
	private AdjuntoService adjuntoService;
	
	@Autowired
	private ValorService valorService;
	
	private ExpedienteHibernate expedienteHibernate;
	
	@Autowired
	public ExpedienteServiceImpl(
			ExpedienteHibernate expedienteHibernate) {
		super(expedienteHibernate);
		this.expedienteHibernate = expedienteHibernate;
	}

	@Override
	@Transactional
	public void registrarExpediente(Expediente expediente, Documento documento) {
		
		crear(expediente);
		String numeroParte = StringUtils.leftPad(String.valueOf(expediente.getId()), 10, "0");
		expediente.setAutogenerado(numeroParte);		
		
		Parametro pathDocumento = parametroService.obtener(Constante.PARAMETRO.PATH_DOCUMENTO);
		
		File archivo = new File(pathDocumento.getValor()+expediente.getAutogenerado()+File.separator+documento.getFilename());
		
		archivo.getParentFile().mkdirs();
		
		try {
			archivo.createNewFile();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(archivo);
			((ByteArrayOutputStream)documento.getOsDocumento()).writeTo(outputStream);
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			if(outputStream != null)
			{
				IOUtils.closeQuietly(outputStream);
			}
			IOUtils.closeQuietly(documento.getOsDocumento());
		 }
		
		Adjunto adjunto = new Adjunto();
		adjunto.setExpExpediente(expediente);
		adjunto.setRuta(archivo.getPath());
		adjunto.setNombre(documento.getFilename());//FIXME [MGLHPM] preguntar por el nombre correspondiente.
		adjunto.setTipo(valorService.obtener(1l));//FIXME [MGLHPM] preguntar por el valor correspondiente.
		adjuntoService.crear(adjunto);
		
		documento.setExpAdjunto(adjunto);
		documento.setExpediente(expediente);
		documento.setEsInicial("1");
		documentoService.crear(documento);
		
		actualizar(expediente);
	}

}
