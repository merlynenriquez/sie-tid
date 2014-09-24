package pe.gob.mininter.dirandro.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.Adjunto;
import pe.gob.mininter.dirandro.model.Documento;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.Parametro;
import pe.gob.mininter.dirandro.model.Ruta;
import pe.gob.mininter.dirandro.service.AdjuntoService;
import pe.gob.mininter.dirandro.service.DocumentoService;
import pe.gob.mininter.dirandro.service.ExpedienteService;
import pe.gob.mininter.dirandro.service.ParametroService;
import pe.gob.mininter.dirandro.service.RutaService;
import pe.gob.mininter.dirandro.service.ValorService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.FormBandejaTrabajo;

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
	
	@Autowired
	private RutaService rutaService;
	
	private ExpedienteHibernate expedienteHibernate;
	
	@Autowired
	public ExpedienteServiceImpl(
			ExpedienteHibernate expedienteHibernate) {
		super(expedienteHibernate);
		this.expedienteHibernate = expedienteHibernate;
	}

	@Override
	@Transactional
	public void registrarExpediente(Expediente expediente, Documento documento, Ruta ruta) {
		
		crear(expediente);
		String numeroParte = StringUtils.leftPad(String.valueOf(expediente.getId()), 10, "0");
		expediente.setAutogenerado(numeroParte);		
		
		//try {
		agregarDocumento(expediente, documento);
		ruta.setExpediente(expediente);
		rutaService.crear(ruta);
			
		actualizar(expediente);
		//} catch(Exception e) {
			//expediente.setId(null);
		//}
		
	}

	@Override
	@Transactional
	public void agregarDocumento(Expediente expediente, Documento documento) {
		
		if(StringUtils.isEmpty(documento.getFilename()) || documento.getOsDocumento() == null) {
			throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_CARGA_ARCHIVO, new Object[]{});
		}
		
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
		
		documento.setAdjunto(adjunto);
		documento.setExpediente(expediente);
		documentoService.crear(documento);
	}

	@Override
	public List<Expediente> obtenerBandejaDeTrabajo(FormBandejaTrabajo form) {
		
		Busqueda filtro = Busqueda.forClass(Expediente.class);
		addILikeRestrictions(filtro, "autogenerado", form.getAutogenerado());
		addILikeRestrictions(filtro, "nombreCaso", form.getCaso());
		
		addILikeRestrictions(filtro, "tipoHecho", "th", "nombre", form.getTipoHecho());
		
		addILikeRestrictions(filtro, "dependencia", "d", "nombre", form.getDependencia());
		
		addILikeRestrictions(filtro, "tipoFinalidad", "tf", "nombre", form.getTipoFinalidad());
		
		if(StringUtils.isNotEmpty(form.getIntegrante())) {
			
			filtro.createAlias("integrante", "i");
			filtro.createAlias("i.usuario", "u");
						
			filtro.add(Restrictions.or(
					Restrictions.ilike("u.nombres", StringUtils.trimToEmpty(form.getIntegrante()), MatchMode.ANYWHERE),
					Restrictions.ilike("u.apePat", StringUtils.trimToEmpty(form.getIntegrante()), MatchMode.ANYWHERE),
					Restrictions.ilike("u.apeMat", StringUtils.trimToEmpty(form.getIntegrante()), MatchMode.ANYWHERE)
					));
		}
		
		addBetweenGeLeRestrictions(filtro, "fechaRegistro", form.getFechaRegInicio(), form.getFechaRegFinal());
		addBetweenGeLeRestrictions(filtro, "diasAtencion", form.getDiasInicio() != null ? Integer.parseInt(form.getDiasInicio().toString()) : null, form.getDiasFinal() != null ? Integer.parseInt(form.getDiasFinal().toString()) : null );
		addILikeRestrictions(filtro, "lugarHecho", "lh", "nombre", form.getLugarHecho());
		addILikeRestrictions(filtro, "jurisdiccion", "j", "nombre", form.getJurisdiccion());
				
		return expedienteHibernate.buscar(filtro);
	}

	@Override
	public List<Expediente> buscar(Expediente expediente) {
		Busqueda filtro = Busqueda.forClass(Expediente.class);
		if(expediente!=null)
		{
			if ( expediente.getId()!=null) {
				filtro.add(Restrictions.eq("id", expediente.getId()));
			}
		}
		return expedienteHibernate.buscar(filtro);
	}	

}
