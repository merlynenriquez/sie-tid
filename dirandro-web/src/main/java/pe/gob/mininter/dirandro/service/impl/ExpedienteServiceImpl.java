package pe.gob.mininter.dirandro.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.ExpedienteHibernate;
import pe.gob.mininter.dirandro.dao.oracle.ExpedienteOracle;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.Adjunto;
import pe.gob.mininter.dirandro.model.DetExpedientePersona;
import pe.gob.mininter.dirandro.model.DetPerArmExp;
import pe.gob.mininter.dirandro.model.DetPerInmExp;
import pe.gob.mininter.dirandro.model.DetPerTelExp;
import pe.gob.mininter.dirandro.model.DetPerVehExp;
import pe.gob.mininter.dirandro.model.Documento;
import pe.gob.mininter.dirandro.model.Droga;
import pe.gob.mininter.dirandro.model.Especie;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.ExpedienteDelito;
import pe.gob.mininter.dirandro.model.Explosivo;
import pe.gob.mininter.dirandro.model.Importe;
import pe.gob.mininter.dirandro.model.Instalacion;
import pe.gob.mininter.dirandro.model.Municion;
import pe.gob.mininter.dirandro.model.NoIdentificado;
import pe.gob.mininter.dirandro.model.Parametro;
import pe.gob.mininter.dirandro.model.Ruta;
import pe.gob.mininter.dirandro.model.Usuario;
import pe.gob.mininter.dirandro.service.AdjuntoService;
import pe.gob.mininter.dirandro.service.DocumentoService;
import pe.gob.mininter.dirandro.service.DrogaService;
import pe.gob.mininter.dirandro.service.ExpedienteArmaService;
import pe.gob.mininter.dirandro.service.ExpedienteDelitoService;
import pe.gob.mininter.dirandro.service.ExpedienteEspecieService;
import pe.gob.mininter.dirandro.service.ExpedienteInmuebleService;
import pe.gob.mininter.dirandro.service.ExpedientePersonaService;
import pe.gob.mininter.dirandro.service.ExpedienteService;
import pe.gob.mininter.dirandro.service.ExpedienteTelefonoService;
import pe.gob.mininter.dirandro.service.ExpedienteVehiculoService;
import pe.gob.mininter.dirandro.service.ExplosivoService;
import pe.gob.mininter.dirandro.service.ImporteService;
import pe.gob.mininter.dirandro.service.InstalacionService;
import pe.gob.mininter.dirandro.service.MunicionService;
import pe.gob.mininter.dirandro.service.NoIdentificadoService;
import pe.gob.mininter.dirandro.service.ParametroService;
import pe.gob.mininter.dirandro.service.RutaService;
import pe.gob.mininter.dirandro.service.ValorService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.util.FormBandejaTrabajo;
import pe.gob.mininter.dirandro.util.ReportePDF;

@Service
public class ExpedienteServiceImpl extends BaseServiceImpl<Expediente, Long> implements ExpedienteService {

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
	
	@Autowired
	private ExpedientePersonaService expedientePersonaService;
	
	@Autowired
	private NoIdentificadoService noIdentificadoService;
	
	@Autowired
	private DrogaService drogaService;
	
	@Autowired
	private ExpedienteDelitoService expDelitoService;
	
	@Autowired
	private ExpedienteTelefonoService expTelefonoService;
	
	@Autowired
	private ImporteService importeService;
	
	@Autowired
	private ExpedienteEspecieService expEspecieService;
	
	@Autowired
	private InstalacionService instalacionService;
	
	@Autowired
	private ExpedienteInmuebleService expedienteInmuebleService;
	
	@Autowired
	private ExpedienteVehiculoService expVehiculoService;
	
	@Autowired
	private ExpedienteArmaService expedienteArmaService;
	
	@Autowired
	private ExplosivoService explosivoService;
	
	@Autowired
	private MunicionService municionService;
	
	@Autowired
	private ExpedienteOracle expedienteOracle;
	
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
		if(documento.isRegistrable()){
			agregarDocumento(expediente, documento);	
		}
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
		logger.debug("por validar el archivo");
		
		Adjunto adjunto = null; 
		
		if(documento.isRegistrable()){
			
			if(StringUtils.isEmpty(documento.getFilename()) || documento.getOsDocumento() == null) {
				throw new ValidacionException(Constante.CODIGO_MENSAJE.VALIDAR_CARGA_ARCHIVO, new Object[]{});
			}
			logger.debug("validacion de archivo correcta");
			Parametro pathDocumento = parametroService.obtener(Constante.PARAMETRO.PATH_DOCUMENTO);
			
			File archivo = new File(pathDocumento.getValor()+expediente.getAutogenerado()+File.separator+documento.getFilename());
			
			archivo.getParentFile().mkdirs();
			
			try {
				archivo.createNewFile();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
			OutputStream outputStream = null;
			try {
				outputStream = new FileOutputStream(archivo);
				((ByteArrayOutputStream)documento.getOsDocumento()).writeTo(outputStream);			
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			finally {
				if(outputStream != null)
				{
					IOUtils.closeQuietly(outputStream);
				}
				IOUtils.closeQuietly(documento.getOsDocumento());
			 }
			logger.debug("archivo cargado, ahora a insertar el registro ADJUNTO en la bd");
			
			adjunto = new Adjunto();
			adjunto.setExpExpediente(expediente);
			adjunto.setRuta(archivo.getPath());
			adjunto.setNombre(documento.getFilename());//FIXME [MGLHPM] preguntar por el nombre correspondiente.
			adjunto.setTipo(valorService.obtener(1l));//FIXME [MGLHPM] preguntar por el valor correspondiente.
			adjuntoService.crear(adjunto);
			logger.debug("creado el ADJUNTO");	
		}
		
		documento.setAdjunto(adjunto);
		documento.setExpediente(expediente);
		logger.debug("por registrar DOCUMENTO");
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

	@Override
	public void actualizarAtestado(Expediente expediente, Usuario usuario) {
		Integer autogenerado = expedienteOracle.obtenerAutogenerado(usuario.getOficina());
		String nroAtestado = "0000000"+autogenerado+"-2014-"+usuario.getOficina().getAbreviatura();
		expediente.setNroAtestado(nroAtestado);
		expedienteHibernate.actualizar(expediente);
	}

	@Override
	public ByteArrayOutputStream imprimirAtestado(Long id) {
		Expediente expediente=obtener(id);
		List<DetExpedientePersona> intervinientes = expedientePersonaService
				.cargarIntervinientes(expediente);
		List<NoIdentificado> noIdentificados = noIdentificadoService.
				cargarDelExpediente(expediente);
		List<Droga> drogas = drogaService.obtenerDrogasExpediente(expediente);
		ExpedienteDelito expDelito=new ExpedienteDelito();
		expDelito.setExpediente(expediente);
		List<ExpedienteDelito> lstExpDelitos = expDelitoService.buscar(expDelito);
		List<DetPerTelExp> lstExpTelefonos=expTelefonoService.buscar(null);
		Importe expImporte=new Importe();
		expImporte.setExpediente(expediente);
		List<Importe> lstExpImportes = importeService.buscar(expImporte);
		List<Especie> lstEspecies = expEspecieService.buscar(null);
		Instalacion instalacion=new Instalacion();
		instalacion.setExpediente(expediente);
		List<Instalacion> lstInstalaciones = instalacionService.buscar(instalacion);
		DetPerInmExp detinm = new DetPerInmExp();
		detinm.setExpediente(expediente);
		List<DetPerInmExp> lstinmuebles = expedienteInmuebleService.buscar(detinm);
		List<DetPerVehExp> lstExpVehiculos = expVehiculoService.buscar(null);
		DetPerArmExp arm = new DetPerArmExp();
		arm.setExpediente(expediente);
		List<DetPerArmExp> lstArmas = expedienteArmaService.buscar(arm);
		Explosivo tmpExplosivo = new Explosivo();
		tmpExplosivo.setExpediente(expediente);
		List<Explosivo> lstExplosivos = explosivoService.buscar(tmpExplosivo);
		Municion munin = new Municion();
		munin.setExpediente(expediente);
		List<Municion> lstMuniciones = municionService.buscar(munin);
		return ReportePDF.exportarPdfAtestado(expediente,intervinientes,noIdentificados,drogas,lstExpDelitos,lstExpTelefonos,lstExpImportes,lstEspecies,lstInstalaciones,
				lstinmuebles,lstExpVehiculos,lstArmas,lstExplosivos,lstMuniciones);
	}
}
