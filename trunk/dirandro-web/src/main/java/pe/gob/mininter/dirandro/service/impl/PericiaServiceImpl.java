package pe.gob.mininter.dirandro.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.PericiaHibernate;
import pe.gob.mininter.dirandro.exception.ValidacionException;
import pe.gob.mininter.dirandro.model.Adjunto;
import pe.gob.mininter.dirandro.model.Parametro;
import pe.gob.mininter.dirandro.model.Pericia;
import pe.gob.mininter.dirandro.service.AdjuntoService;
import pe.gob.mininter.dirandro.service.ParametroService;
import pe.gob.mininter.dirandro.service.PericiaService;
import pe.gob.mininter.dirandro.service.ValorService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.Constante;
import pe.gob.mininter.dirandro.vaadin.panel.bandeja.PanelBandejaHojaRemision;
import pe.gob.mininter.dirandro.vaadin.panel.bandeja.PanelBandejaPericias;

@Service
public class PericiaServiceImpl extends BaseServiceImpl<Pericia, Long> implements PericiaService {

	private static final long serialVersionUID = -5239881532212124647L;
	
	@Autowired
	private ParametroService parametroService;
	
	@Autowired
	private AdjuntoService adjuntoService;
	
	@Autowired
	private ValorService valorService;
	
	private PericiaHibernate periciaHibernate;
	
	@Autowired
	public PericiaServiceImpl(PericiaHibernate periciaHibernate) {
		super(periciaHibernate);
		
		this.periciaHibernate = periciaHibernate;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Pericia object) {		
		Busqueda filtro = Busqueda.forClass(Pericia.class);
		filtro.add(Restrictions.eq("muestra.id", object.getMuestra().getId()));
		if (periciaHibernate.buscar(filtro).size()>0) {
			throw new ValidacionException(
					Constante.CODIGO_MENSAJE.VALIDAR_PERICIA_EXISTENTE,
					new Object[] { object.getMuestra().getId() });
		}
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Pericia object) {
		logger.debug("validacion de archivo correcta");
		Parametro pathDocumento = parametroService.obtener(Constante.PARAMETRO.PATH_DOCUMENTO);
		
		/* LOGO */
		if( object.getLogo() == null){
			
			File archivo = new File(pathDocumento.getValor()+object.getMuestra().getHojaRemision().getNumero()+File.separator+object.getFilenameLogo());
			logger.debug( " logo " + archivo.getAbsolutePath() );
			archivo.getParentFile().mkdirs();
			
			try {
				archivo.createNewFile();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
			OutputStream outputStream = null;
			try {
				outputStream = new FileOutputStream(archivo);
				((ByteArrayOutputStream)object.getOsLogo()).writeTo(outputStream);			
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
				IOUtils.closeQuietly(object.getOsLogo());
			 }
			logger.debug("archivo cargado, ahora a insertar el registro ADJUNTO en la bd");
			Adjunto adjunto = new Adjunto();
			adjunto.setRuta(archivo.getPath());
			adjunto.setNombre(object.getFilenameLogo());
			adjunto.setTipo(valorService.obtener(1l));
			adjuntoService.crear(adjunto);
			logger.debug("creado el ADJUNTO");
			object.setLogo(adjunto);
				
		}
		
		/* PERICIA */
		if(object.getAdjunto() == null ){
			File archivo =  new File(pathDocumento.getValor()+object.getMuestra().getHojaRemision().getNumero()+File.separator+object.getFilenamePericia());
			logger.debug( " pericia " + archivo.getAbsolutePath() );
			archivo.getParentFile().mkdirs();
			
			try {
				archivo.createNewFile();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
			OutputStream outputStream = null;
			try {
				outputStream = new FileOutputStream(archivo);
				((ByteArrayOutputStream)object.getOsPericia()).writeTo(outputStream);			
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
				IOUtils.closeQuietly(object.getOsPericia());
			 }
			logger.debug("archivo cargado, ahora a insertar el registro pericia en la bd");
			Adjunto adjunto2 = new Adjunto();
			adjunto2.setRuta(archivo.getPath());
			adjunto2.setNombre(object.getFilenamePericia());
			adjunto2.setTipo(valorService.obtener(1l));//FIXME [MGLHPM] preguntar por el valor correspondiente.
			adjuntoService.crear(adjunto2);
			logger.debug("creado el ADJUNTO");
			object.setAdjunto(adjunto2);
				
		}
		
		periciaHibernate.actualizar(object);
	}

	@Override
	public List<Pericia> buscar(Pericia pericia) {
		Busqueda filtro = Busqueda.forClass(Pericia.class);
		
		if (pericia!=null){
			if (pericia.getMuestra() != null) {
				
				if( !pericia.getMuestra().esNuevo() ){
					logger.debug("muestra " + pericia.getMuestra().getId() );
					filtro.add(Restrictions.eq("muestra.id", pericia.getMuestra().getId()));	
				}
			
				if (pericia.getMuestra().getHojaRemision() != null && !pericia.getMuestra().getHojaRemision().esNuevo() ) {
					logger.debug("hoja remision " + pericia.getMuestra().getHojaRemision().getId() );
					filtro.createAlias("muestra.hojaRemision", "h");
					filtro.add(Restrictions.eq("h.id", pericia.getMuestra().getHojaRemision().getId()));
				}
			}
		}
		return periciaHibernate.buscar(filtro);
	}
	

	@Override
	public List<Pericia> buscarBandeja(Map<String, Object> map) {
		Busqueda filtro = Busqueda.forClass(Pericia.class);
		if(map!=null){
			
			if(StringUtils.isNotBlank((String)map.get(PanelBandejaPericias.COLUMNA_EXPEDIENTE))) {
				filtro.createAlias("muestra", "m");
				filtro.createAlias("m.hojaremision", "hr");
				addILikeRestrictions(filtro, "hr.expediente", "ex", "autogenerado", (String)map.get(PanelBandejaPericias.COLUMNA_EXPEDIENTE));
			}
			if(StringUtils.isNotBlank((String)map.get(PanelBandejaPericias.COLUMNA_TIPO_HR))) {
				filtro.createAlias("muestra", "m");
				filtro.createAlias("m.hojaremision", "hr");
				addILikeRestrictions(filtro, "hr.tipoHr", "th", "nombre", (String)map.get(PanelBandejaPericias.COLUMNA_TIPO_HR));
			}
			if(StringUtils.isNotBlank((String)map.get(PanelBandejaPericias.COLUMNA_HOJA_REMISION))) {
				filtro.createAlias("muestra", "m");
				addILikeRestrictions(filtro, "m.hojaRemision", "hr", "numero", (String)map.get(PanelBandejaPericias.COLUMNA_HOJA_REMISION));
			}
			/*
			 * No se puede xq no es campo
			 * if(StringUtils.isNotBlank((String)map.get(PanelBandejaPericias.COLUMNA_TIPO_MUESTRA))) {
				filtro.createAlias("muestra", "m");
				addILikeRestrictions(filtro, "m.", "tm", "autogenerado", (String)map.get(PanelBandejaPericias.COLUMNA_TIPO_MUESTRA));
			}*/
			if(StringUtils.isNotBlank((String)map.get(PanelBandejaPericias.COLUMNA_TIPO_MUESTRA_NOMBRE))) {
				
				filtro.createAlias("muestra", "mu");
				
				filtro.add(Restrictions.or(
						Restrictions.ilike("mu.droga.tipoDroga.nombre", (String)map.get(PanelBandejaHojaRemision.COLUMNA_PERSONA), MatchMode.ANYWHERE),
						Restrictions.ilike("mu.especie.nombre", (String)map.get(PanelBandejaHojaRemision.COLUMNA_PERSONA), MatchMode.ANYWHERE)
				));
			
			}
			/*addILikeRestrictions(filtro, "destino", "de", "nombre", (String)map.get(PanelBandejaPericias.COLUMNA_DEPENDENCIA_DESTINO));
			addBetweenGeLeRestrictions(filtro, "fechaPeritaje", (Date)map.get(PanelBandejaPericias.COLUMNA_FECHA_EMISION+TablaFiltro.KEY_INICIAL), 
					(Date)map.get(PanelBandejaPericias.COLUMNA_FECHA_EMISION+TablaFiltro.KEY_FINAL));
			addILikeRestrictions(filtro, "estado", (String)map.get(PanelBandejaPericias.COLUMNA_NUMERO));
			*/
		}
		return periciaHibernate.buscar(filtro);	
	}

	
	
}