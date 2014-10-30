package pe.gob.mininter.dirandro.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.DetExpedientePersona;
import pe.gob.mininter.dirandro.model.DetPerArmExp;
import pe.gob.mininter.dirandro.model.DetPerInmExp;
import pe.gob.mininter.dirandro.model.DetPerTelExp;
import pe.gob.mininter.dirandro.model.DetPerVehExp;
import pe.gob.mininter.dirandro.model.Droga;
import pe.gob.mininter.dirandro.model.Especie;
import pe.gob.mininter.dirandro.model.Expediente;
import pe.gob.mininter.dirandro.model.ExpedienteDelito;
import pe.gob.mininter.dirandro.model.Explosivo;
import pe.gob.mininter.dirandro.model.Importe;
import pe.gob.mininter.dirandro.model.Instalacion;
import pe.gob.mininter.dirandro.model.Municion;
import pe.gob.mininter.dirandro.model.NoIdentificado;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.html.simpleparser.StyleSheet;
import com.itextpdf.text.pdf.PdfWriter;

public class ReportePDF {

	@SuppressWarnings("deprecation")
	public static ByteArrayOutputStream exportarPdfAtestado(Expediente expediente, 
			List<DetExpedientePersona> intervinientes,List<NoIdentificado> noIdentificados,
			List<Droga> drogas,List<ExpedienteDelito> lstExpDelitos,
			List<DetPerTelExp> lstExpTelefonos,List<Importe> lstExpImportes,
			List<Especie> lstEspecies,List<Instalacion> lstInstalaciones,
			List<DetPerInmExp> lstinmuebles,List<DetPerVehExp> lstExpVehiculos,
			List<DetPerArmExp> lstArmas,List<Explosivo> lstExplosivos,
			List<Municion> lstMuniciones){
		DateFormat dmt=new SimpleDateFormat("dd/MM/yyyy");
		
		StringBuilder expedienteHtml=new StringBuilder();
		expedienteHtml.append("<div align=center>Atestado Nro ").append(expediente.getAutogenerado()).append("</div>");
		expedienteHtml.append("<br><div>Asunto: ").append(expediente.getAsunto()).append("</div>");
		expedienteHtml.append("<div>Observaciones: ").append(expediente.getDescripcion()==null?"":expediente.getDescripcion()).append("</div>");
		
		expedienteHtml.append("<div><table border=0><tr><td>Nombre del Caso: ").append(expediente.getNombreCaso()==null?"":expediente.getNombreCaso()).append("</td>");
		expedienteHtml.append("<td>Tipo de Hecho: ").append(expediente.getTipoHecho()==null?"":expediente.getTipoHecho().getNombre()).append("</td></tr></table></div>");
		expedienteHtml.append("<table border=0><tr><td>Sub Tipo del Hecho: ").append("").append("</td>");
		expedienteHtml.append("<td>Nombre del Hecho: ").append("").append("</td></tr></table></div>");
		
		expedienteHtml.append("<div><table border=0><tr><td>Dependencia: ").append(expediente.getDependencia()==null?"":expediente.getDependencia().getNombre()).append("</td>");
		expedienteHtml.append("<td>Finalidad: ").append(expediente.getTipoFinalidad()==null?"":expediente.getTipoFinalidad().getNombre()).append("</td></tr></table></div>");
		expedienteHtml.append("<table border=0><tr><td>Fecha de Registro: ").append(expediente.getFechaRegistro()==null?"":dmt.format(expediente.getFechaRegistro())).append("</td>");
		expedienteHtml.append("<td>Dias de Atencion: ").append(expediente.getDiasAtencion()==null?"":expediente.getDiasAtencion()).append("</td></tr></table></div>");
		
		expedienteHtml.append("<div><table border=0><tr><td>Instructor: ").append(expediente.getIntegrante()==null?"":expediente.getIntegrante().getNombreCompletoIntegrante()).append("</td>");
		expedienteHtml.append("<td>Estado: ").append(expediente.getEstado()==null?"":expediente.getEstado().getNombre()).append("</td></tr></table></div>");
		
		expedienteHtml.append("<div><table border=0><tr><td>Lugar de Hecho: ").append(expediente.getLugarHecho()==null?"":expediente.getLugarHecho().getNombreCompleto()).append("</td>");
		expedienteHtml.append("<td>Tipo de Direccion: ").append(expediente.getTipoDireccion()==null?"":expediente.getTipoDireccion().getNombre()).append("</td></tr></table></div>");
		
		expedienteHtml.append("<div><table border=0><tr><td>Direccion de Hecho: ").append(expediente.getDireccionHecho()==null?"":expediente.getDireccionHecho()).append("</td>");
		expedienteHtml.append("<td>Referencia: ").append(expediente.getReferenciaHecho()==null?"":expediente.getReferenciaHecho()).append("</td></tr></table></div>");
		
		expedienteHtml.append("<div><table border=0><tr><td>Jurisdiccion: ").append(expediente.getJurisdiccion()==null?"":expediente.getJurisdiccion().getNombre()).append("</td>");
		expedienteHtml.append("<td>Centro Poblado: ").append(expediente.getCentroPoblado()==null?"":expediente.getCentroPoblado().getNombre()).append("</td></tr></table></div>");
		
		expedienteHtml.append("<div><table border=0><tr><td>Cuenca: ").append(expediente.getCuenca()==null?"":expediente.getCuenca().getNombre()).append("</td>");
		expedienteHtml.append("<td>Tipo de Interviniente: ").append(expediente.getTablaInterviniente()==null?"":expediente.getTablaInterviniente().getNombre()).append("</td></tr></table></div>");
		
		expedienteHtml.append("<div><table border=0><tr><td>Interviniente: ").append(expediente.getIntegrante()==null?"":expediente.getIntegrante().getNombreCompletoIntegrante()).append("</td></tr></table></div>");
		
		expedienteHtml.append("<br><div>Intervinientes</div><br>");
		expedienteHtml.append("<div><table border=1><tr><td>Tipo Int.</td><td>Interviniente</td><td>Est. Dato</td><td>Organizacion</td><td>Ocupacion</td><td>Fecha Int.</td><td>Situacion</td><td>Alias</td></tr>");
		for (DetExpedientePersona interviniente : intervinientes) {
			expedienteHtml.append("<tr><td>").append(interviniente.getInvolucrado() != null ? "Persona" : "Empresa").append("</td>");
			expedienteHtml.append("<td>").append(interviniente.getInvolucrado() != null ? interviniente.getInvolucrado().getNombreCompleto() : interviniente.getEmpresaInvolucrada().getRazonSocial()).append("</td>");
			expedienteHtml.append("<td>").append(interviniente.getEstadoDato() != null ? interviniente.getEstadoDato().getNombre() : StringUtils.EMPTY).append("</td>");
			expedienteHtml.append("<td>").append(interviniente.getOrganizacion() != null ? interviniente.getOrganizacion().getNombre() : StringUtils.EMPTY).append("</td>");
			expedienteHtml.append("<td>").append(interviniente.getOcupacion() != null ? interviniente.getOcupacion().getNombre() : StringUtils.EMPTY).append("</td>");
			expedienteHtml.append("<td>").append(interviniente.getIntervencion() != null ? dmt.format(interviniente.getIntervencion()) : StringUtils.EMPTY).append("</td>");
			expedienteHtml.append("<td>").append(interviniente.getSituacion() != null ? interviniente.getSituacion().getNombre() : StringUtils.EMPTY).append("</td>");
			expedienteHtml.append("<td>").append(interviniente.getAlias() != null ? interviniente.getAlias() : StringUtils.EMPTY).append("</td></tr>");	
		}
		expedienteHtml.append("</table></div>");
		
		expedienteHtml.append("<br><div>No Identificados</div><br>");
		expedienteHtml.append("<div><table border=1><tr><td>Alias</td><td>Nombres</td><td>Apellidos</td><td>Sexo</td><td>Edad</td></tr>");
		for (NoIdentificado noIdentificado : noIdentificados) {
			expedienteHtml.append("<tr><td>").append(noIdentificado.getAlias()).append("</td>");
			expedienteHtml.append("<td>").append(noIdentificado.getNombres()).append("</td>");
			expedienteHtml.append("<td>").append(noIdentificado.getApellidos()).append("</td>");
			expedienteHtml.append("<td>").append(noIdentificado.getSexo() !=null ? noIdentificado.getSexo() : StringUtils.EMPTY).append("</td>");
			expedienteHtml.append("<td>").append(noIdentificado.getEdadAprox() != null ? ""+noIdentificado.getEdadAprox().intValue() : StringUtils.EMPTY).append("</td></tr>");	
		}
		expedienteHtml.append("</table></div>");
		
		expedienteHtml.append("<br><div>Sustancias</div><br>");
		expedienteHtml.append("<div><table border=1><tr><td>Tipo Droga</td><td>Tipo Medida</td>"
				+ "<td>P. Bruto</td><td>P. Neto</td><td>Situacion</td><td>Medida Muestra</td>"
				+ "<td>Procedencia</td><td>Destino</td></tr>");
		for (Droga droga : drogas) {
			expedienteHtml.append("<tr><td>").append(HarecUtil.marcaModeloNombreToEmpty(droga.getTipoDroga())).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.marcaModeloNombreToEmpty(droga.getTipoMedida())).append("</td>");
			expedienteHtml.append("<td>").append(droga.getPesoBruto()).append("</td>");
			expedienteHtml.append("<td>").append(droga.getPesoNeto()).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.valorNombreToEmpty(droga.getSituaccion())).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.marcaModeloNombreToEmpty(droga.getTipoMedidaMuestra())).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.paisNombreToEmpty(droga.getProcedencia())).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.paisNombreToEmpty(droga.getDestino())).append("</td></tr>");	
		}
		expedienteHtml.append("</table></div>");
		
		expedienteHtml.append("<br><div>Delitos</div><br>");
		expedienteHtml.append("<div><table border=1><tr><td>Id</td><td>Modalidad</td>"
				+ "<td>Modalidad</td><td>Prioridad</td></tr>");
		for (ExpedienteDelito expDelito : lstExpDelitos) {
			expedienteHtml.append("<tr><td>").append(expDelito.getId()).append("</td>");
			expedienteHtml.append("<td>").append(expDelito.getDelito().getPadre() != null ? expDelito.getDelito().getPadre().getNombre() : StringUtils.EMPTY).append("</td>");
			expedienteHtml.append("<td>").append(expDelito.getDelito() != null ? expDelito.getDelito().getNombre() : StringUtils.EMPTY).append("</td>");
			expedienteHtml.append("<td>").append(expDelito.getPrioridad() != null ? expDelito.getPrioridad().getNombre() : StringUtils.EMPTY).append("</td></tr>");	
		}
		expedienteHtml.append("</table></div>");
		
		expedienteHtml.append("<br><div>Telefono</div><br>");
		expedienteHtml.append("<div><table border=1><tr><td>Id</td><td>Implicado</td>"
				+ "<td>Operadora</td><td>Situacion</td><td>Estado</td></tr>");
		for (DetPerTelExp expTelefono : lstExpTelefonos){
			expedienteHtml.append("<tr><td>").append(expTelefono.getId()).append("</td>");
			expedienteHtml.append("<td>").append(expTelefono.getImplicado()!=null?expTelefono.getImplicado().getNombreCompleto():StringUtils.EMPTY).append("</td>");
			expedienteHtml.append("<td>").append(expTelefono.getOperadora() != null ? expTelefono.getOperadora().getNombre() : null).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.valorNombreToEmpty(expTelefono.getSituacion())).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.valorNombreToEmpty(expTelefono.getEstado())).append("</td></tr>");	
		}
		expedienteHtml.append("</table></div>");
		
		expedienteHtml.append("<br><div>Dinero</div><br>");
		expedienteHtml.append("<div><table border=1><tr><td>Tipo de Moneda</td><td>Dinero Incautado</td>"
				+ "<td>Situación del Dinero</td><td>Es Autentico?</td><td>Banco</td><td>Nro. de Cuenta</td></tr>");
		for (Importe importe : lstExpImportes) {
			expedienteHtml.append("<tr><td>").append(HarecUtil.valorNombreToEmpty(importe.getTipoMoneda())).append("</td>");
			expedienteHtml.append("<td>").append(importe.getMoneda()).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.valorNombreToEmpty(importe.getSituacion())).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.nullToEmpty(importe.getAutenticidad())).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.valorNombreToEmpty(importe.getBanco())).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.nullToEmpty(importe.getNroCuenta())).append("</td></tr>");	
		}
		expedienteHtml.append("</table></div>");
		
		expedienteHtml.append("<br><div>Especies</div><br>");
		expedienteHtml.append("<div><table border=1><tr><td>Descripción</td><td>Familia de Especie</td>"
				+ "<td>SubTipo</td><td>Tipo Medida</td><td>Medida</td><td>Situacion</td></tr>");
		for (Especie especie : lstEspecies){
			expedienteHtml.append("<tr><td>").append(especie.getNombre()).append("</td>");
			expedienteHtml.append("<td>").append(especie.getTipoEspecie().getPadre().getNombre()).append("</td>");
			expedienteHtml.append("<td>").append(especie.getTipoEspecie() != null ? especie.getTipoEspecie().getNombre() : StringUtils.EMPTY).append("</td>");
			expedienteHtml.append("<td>").append(especie.getTipoMedida() != null ? especie.getTipoMedida().getNombre() : StringUtils.EMPTY).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.nullToEmpty(especie.getMedida())).append("</td>");
			expedienteHtml.append("<td>").append(especie.getSituacion() != null ? especie.getSituacion().getNombre() : StringUtils.EMPTY).append("</td></tr>");	
		}
		expedienteHtml.append("</table></div>");

		expedienteHtml.append("<br><div>Instalaciones</div><br>");
		expedienteHtml.append("<div><table border=1><tr><td>Tipo de Instalacion</td><td>Instalacion</td>"
				+ "<td>Organizacion</td><td>Zona de Produccion</td></tr>");
		for (Instalacion instalacion : lstInstalaciones){
			expedienteHtml.append("<tr><td>").append(HarecUtil.valorNombreToEmpty(instalacion.getTipo())).append("</td>");
			expedienteHtml.append("<td>").append(instalacion.getNombre()).append("</td>");
			expedienteHtml.append("<td>").append(instalacion.getOrganizacionDelictiva()!=null?instalacion.getOrganizacionDelictiva().getNombre():StringUtils.EMPTY).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.nullToEmpty(instalacion.getZonaProduccion())).append("</td></tr>");	
		}
		expedienteHtml.append("</table></div>");

		expedienteHtml.append("<br><div>Inmuebles</div><br>");
		expedienteHtml.append("<div><table border=1><tr><td>Direccion</td><td>Urbanizacion</td>"
				+ "<td>Propietario</td><td>Nro. Pisos</td><td>Situacion</td></tr>");
		for (DetPerInmExp inmueble : lstinmuebles){
			expedienteHtml.append("<tr><td>").append(inmueble.getInmueble()!=null?HarecUtil.nullToEmpty(inmueble.getInmueble().getDireccion()):"").append("</td>");
			expedienteHtml.append("<td>").append(inmueble.getInmueble()!=null?HarecUtil.nullToEmpty(inmueble.getInmueble().getUrbanizacion()):"").append("</td>");
			expedienteHtml.append("<td>").append(inmueble.getPropietario()!=null?HarecUtil.nullToEmpty(inmueble.getPropietario().getNombreCompleto()):"").append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.nullToEmpty(inmueble.getNumeroPisos())).append("</td>");
			expedienteHtml.append("<td>").append(inmueble.getSituacion()!=null?HarecUtil.nullToEmpty(inmueble.getSituacion().getNombre()):"").append("</td></tr>");	
		}
		expedienteHtml.append("</table></div>");

		expedienteHtml.append("<br><div>Vehiculos</div><br>");
		expedienteHtml.append("<div><table border=1><tr><td>Id</td><td>Placa</td>"
				+ "<td>Tamaño</td><td>Fabricación</td><td>Estado Chasis</td>"
				+ "<td>Estado Motor</td><td>Implicado</td></tr>");
		for (DetPerVehExp expVehiculo : lstExpVehiculos){
			expedienteHtml.append("<tr><td>").append(expVehiculo.getId()).append("</td>");
			expedienteHtml.append("<td>").append(expVehiculo.getVehiculo().getPlaca()).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.valorNombreToEmpty(expVehiculo.getVehiculo().getTipoTamano())).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.valorNombreToEmpty(expVehiculo.getVehiculo().getPeriodoFabricacion())).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.valorIdToEmpty(expVehiculo.getEstadoChasis())).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.valorIdToEmpty(expVehiculo.getEstadoMotor())).append("</td>");
			expedienteHtml.append("<td>").append(expVehiculo.getPersonaImplicada().getNombreCompleto()).append("</td></tr>");	
		}
		expedienteHtml.append("</table></div>");

		expedienteHtml.append("<br><div>Armas</div><br>");
		expedienteHtml.append("<div><table border=1><tr><td>Propietario</td><td>Persona</td>"
				+ "<td>Empresa</td><td>Marca</td><td>Modelo</td></tr>");
		for (DetPerArmExp detarma : lstArmas){
			expedienteHtml.append("<tr><td>").append(detarma.getPropietario()!=null?HarecUtil.nullToEmpty(detarma.getPropietario().getNombreCompleto()):null).append("</td>");
			expedienteHtml.append("<td>").append(detarma.getPersonaImplicada()!=null?HarecUtil.nullToEmpty(detarma.getPersonaImplicada().getNombreCompleto()):null).append("</td>");
			expedienteHtml.append("<td>").append(detarma.getEmpresaImplicada()!=null?HarecUtil.nullToEmpty(detarma.getEmpresaImplicada().getRazonSocial()):null).append("</td>");
			expedienteHtml.append("<td>").append(detarma.getArma().getModelo().getPadre()!=null?HarecUtil.nullToEmpty(detarma.getArma().getModelo().getPadre().getNombre()):null).append("</td>");
			expedienteHtml.append("<td>").append(detarma.getArma().getModelo()!=null?HarecUtil.nullToEmpty(detarma.getArma().getModelo().getNombre()):null).append("</td></tr>");	
		}
		expedienteHtml.append("</table></div>");

		expedienteHtml.append("<br><div>Explosivos</div><br>");
		expedienteHtml.append("<div><table border=1><tr><td>Persona</td><td>Empresa</td>"
				+ "<td>Tipo</td><td>Marca</td></tr>");
		for (Explosivo explosivo : lstExplosivos){
			expedienteHtml.append("<tr><td>").append(explosivo.getPersonaImplicada()!=null?HarecUtil.nullToEmpty(explosivo.getPersonaImplicada().getNombreCompleto()):null).append("</td>");
			expedienteHtml.append("<td>").append(explosivo.getEmpresaImplicada()!=null?HarecUtil.nullToEmpty(explosivo.getEmpresaImplicada().getRazonSocial()):null).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.marcaModeloNombreToEmpty(explosivo.getMarca().getPadre())).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.marcaModeloNombreToEmpty(explosivo.getMarca())).append("</td></tr>");	
		}
		expedienteHtml.append("</table></div>");

		expedienteHtml.append("<br><div>Municiones</div><br>");
		expedienteHtml.append("<div><table border=1><tr><td>Persona</td><td>Empresa</td>"
				+ "<td>Calibre</td><td>Tipo</td><td>Marca</td></tr>");
		for (Municion municion : lstMuniciones){
			expedienteHtml.append("<tr><td>").append(municion.getPersonaImplicada()!=null?HarecUtil.nullToEmpty(municion.getPersonaImplicada().getNombreCompleto()):null).append("</td>");
			expedienteHtml.append("<td>").append(municion.getEmpresaImplicada()!=null?HarecUtil.nullToEmpty(municion.getEmpresaImplicada().getRazonSocial()):null).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.valorNombreToEmpty(municion.getCalibre())).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.marcaModeloNombreToEmpty(municion.getMarca().getPadre())).append("</td>");
			expedienteHtml.append("<td>").append(HarecUtil.marcaModeloNombreToEmpty(municion.getMarca())).append("</td></tr>");	
		}
		expedienteHtml.append("</table></div>");
		
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
			objects = HTMLWorker.parseToList(
					new StringReader(expedienteHtml.toString()), styles, null);
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
