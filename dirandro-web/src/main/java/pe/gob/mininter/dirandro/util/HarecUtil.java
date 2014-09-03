package pe.gob.mininter.dirandro.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import pe.gob.mininter.dirandro.model.Delito;
import pe.gob.mininter.dirandro.model.Dependencia;
import pe.gob.mininter.dirandro.model.Equipo;
import pe.gob.mininter.dirandro.model.ModeloMarca;
import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.model.Persona;
import pe.gob.mininter.dirandro.model.TipoEspecie;
import pe.gob.mininter.dirandro.model.TipoHecho;
import pe.gob.mininter.dirandro.model.Usuario;

public abstract class HarecUtil {
	
	protected static final Log logger = LogFactory.getLog(HarecUtil.class);

	public static Usuario obtenerUsuarioSesion(){
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		HttpSession session = request.getSession(false);
		Usuario usuario = null;
		if(session != null){
			usuario = (Usuario) session.getAttribute(Constante.SESION.USUARIO);
		}
		return usuario;
	}


	/**
	 * Similar a ordenarOpciones(opciones, ordenarAcciones) pero ordenarAcciones = false.
	 * @param opciones = Maestro de opciones a ordenar
	 * @return Lista de opciones ordenadas sin diferenciar las acciones
	 */
	public static Map<String, List<Opcion>> ordenarOpciones(final List<Opcion> opciones){
		return ordenarOpciones(opciones, false);
	}
	
	
	public static Map<String, List<Opcion>> ordenarOpciones(final List<Opcion> opciones, final boolean ordenarAcciones){
		Map<String, List<Opcion>> map = new HashMap<String, List<Opcion>>();
		Map<String,Opcion> map2 = new HashMap<String, Opcion>();
		List<Opcion> list;
		List<Opcion> list2 = new ArrayList<Opcion>();
		String codigoPadre;
		for (Opcion opcion : opciones) {
			if(ordenarAcciones){			
				if(Constante.VALOR.CODIGO.SUBMENU.equals(opcion.getTipo().getCodigo())){
					//opcion.setAcciones(new ArrayList<Opcion>());
					map2.put(opcion.getCodigo(), opcion);
				}
				
				if(Constante.VALOR.CODIGO.ACCION.equals(opcion.getTipo().getCodigo())){
					list2.add(opcion);
					continue;
				}
			}
			
			if(opcion.getPadre() == null){
				codigoPadre = Constante.OPCION.KEY_PADRE;
			}
			else{
				codigoPadre = opcion.getPadre().getCodigo();
			}
			
			if(map.containsKey(codigoPadre)){
				list = map.get(codigoPadre);
			}
			else{
				list = new ArrayList<Opcion>();
				map.put(codigoPadre, list);
			}
			list.add(opcion);
		}
		
		if(ordenarAcciones){			
			for (Opcion opcion : list2) {
				if(map2.containsKey(opcion.getPadre().getCodigo())){
					//--TODO: HABILITAR LA PARTE DE OPCIONES
					//map2.get(opcion.getPadre().getCodigo()).getAcciones().add(opcion);
				}
			}
		}
		
		return map;
	}
	
	/* 
	public static List<Distrito> obtenerDistritos(){
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		HttpSession session = request.getSession(false);
		List<Distrito> lstDistrito = null;
		if(session != null){
			lstDistrito =  (List<Distrito>) session.getAttribute("lstDistritos");
		}
		return lstDistrito;
	}*/
	
	
	public static Map<String, List<Delito>> ordenarDelitos(List<Delito> delitos){
		Map<String, List<Delito>> map = new HashMap<String, List<Delito>>();
		List<Delito> list = null;
		
		for (Delito delito : delitos) {
			if(delito.getPadre() == null){
				if(map.get(Constante.OPCION.KEY_PADRE)==null){
					list = new ArrayList<Delito>();
					list.add(delito);
					map.put(Constante.OPCION.KEY_PADRE, list);
				} else {
					list = (List<Delito>) map.get(Constante.OPCION.KEY_PADRE);
					list.add(delito);
					map.put(Constante.OPCION.KEY_PADRE, list);
				}
			}else{
				if (map.get(delito.getPadre().getId().toString()) == null) {
					list = new ArrayList<Delito>();
					list.add(delito);
					map.put(delito.getPadre().getId().toString(), list);
				} else {
					list = (List<Delito>) map.get(delito.getPadre().getId().toString());
					list.add(delito);
					map.put(delito.getPadre().getId().toString(), list);
				}
			}
		}
		return map;
	}
	
	
	public static Map<String, List<TipoHecho>> ordenarTipoHechos(List<TipoHecho> tiposHecho){
		Map<String, List<TipoHecho>> map = new HashMap<String, List<TipoHecho>>();
		List<TipoHecho> list = null;
		
		for (TipoHecho delito : tiposHecho) {
			if(delito.getPadre() == null){
				if(map.get(Constante.OPCION.KEY_PADRE)==null){
					list = new ArrayList<TipoHecho>();
					list.add(delito);
					map.put(Constante.OPCION.KEY_PADRE, list);
				} else {
					list = (List<TipoHecho>) map.get(Constante.OPCION.KEY_PADRE);
					list.add(delito);
					map.put(Constante.OPCION.KEY_PADRE, list);
				}
			}else{
				if (map.get(delito.getPadre().getId().toString()) == null) {
					list = new ArrayList<TipoHecho>();
					list.add(delito);
					map.put(delito.getPadre().getId().toString(), list);
				} else {
					list = (List<TipoHecho>) map.get(delito.getPadre().getId().toString());
					list.add(delito);
					map.put(delito.getPadre().getId().toString(), list);
				}
			}
		}
		return map;
	}


	public static Map<String, List<TipoEspecie>> ordenarTipoEspecie(List<TipoEspecie> tiposEspecie){
		Map<String, List<TipoEspecie>> map = new HashMap<String, List<TipoEspecie>>();
		List<TipoEspecie> list = null;
		
		for (TipoEspecie delito : tiposEspecie) {
			if(delito.getPadre() == null){
				if(map.get(Constante.OPCION.KEY_PADRE)==null){
					list = new ArrayList<TipoEspecie>();
					list.add(delito);
					map.put(Constante.OPCION.KEY_PADRE, list);
				} else {
					list = (List<TipoEspecie>) map.get(Constante.OPCION.KEY_PADRE);
					list.add(delito);
					map.put(Constante.OPCION.KEY_PADRE, list);
				}
			}else{
				if (map.get(delito.getPadre().getId().toString()) == null) {
					list = new ArrayList<TipoEspecie>();
					list.add(delito);
					map.put(delito.getPadre().getId().toString(), list);
				} else {
					list = (List<TipoEspecie>) map.get(delito.getPadre().getId().toString());
					list.add(delito);
					map.put(delito.getPadre().getId().toString(), list);
				}
			}
		}
		return map;
	}

	
	
	/**
	 * @param opciones = Maestro de opciones a ordenar
	 * @param ordenarAcciones = flag para determinar que tipo de orden hacer (separa las acciones o no)
	 * @return Lista de opciones ordenadas
	 */
	public static Map<String, List<ModeloMarca>> ordenarModeloMarcas(List<ModeloMarca> modeloMarcas){

		Map<String, List<ModeloMarca>> map = new HashMap<String, List<ModeloMarca>>();
		List<ModeloMarca> list = null;
		
		for (ModeloMarca modeloMarca : modeloMarcas) {
			if(modeloMarca.getPadre() == null){
				if(map.get(Constante.OPCION.KEY_PADRE)==null){
					list = new ArrayList<ModeloMarca>();
					list.add(modeloMarca);
					map.put(Constante.OPCION.KEY_PADRE, list);
				} else {
					list = (List<ModeloMarca>) map.get(Constante.OPCION.KEY_PADRE);
					list.add(modeloMarca);
					map.put(Constante.OPCION.KEY_PADRE, list);
				}
			}else{
				if (map.get(modeloMarca.getPadre().getId().toString()) == null) {
					list = new ArrayList<ModeloMarca>();
					list.add(modeloMarca);
					map.put(modeloMarca.getPadre().getId().toString(), list);
				} else {
					list = (List<ModeloMarca>) map.get(modeloMarca.getPadre().getId().toString());
					list.add(modeloMarca);
					map.put(modeloMarca.getPadre().getId().toString(), list);
				}
			}
		}
		return map;
	}
	
	
	public static Map<String, List<Dependencia>> ordenarDependencias(List<Dependencia> dependencias){		
		Map<String, List<Dependencia>> map = new HashMap<String, List<Dependencia>>();
		List<Dependencia> list = null;
		
		for (Dependencia dependencia : dependencias) {		
			if(dependencia.getPadre() == null){
				if(map.get(Constante.OPCION.KEY_PADRE)==null){					
					list = new ArrayList<Dependencia>();
					list.add(dependencia);
					map.put(Constante.OPCION.KEY_PADRE, list);
				} else {
					list = (List<Dependencia>) map.get(Constante.OPCION.KEY_PADRE);
					list.add(dependencia);
					map.put(Constante.OPCION.KEY_PADRE, list);
				}
			}else{
				if (map.get(dependencia.getPadre().getId().toString()) == null) {					
					list = new ArrayList<Dependencia>();
					list.add(dependencia);
					map.put(dependencia.getPadre().getId().toString(), list);
				} else {					
					list = (List<Dependencia>) map.get(dependencia.getPadre().getId().toString());
					list.add(dependencia);
					map.put(dependencia.getPadre().getId().toString(), list);
				}
			}
		}		
		return map;
	}
	

	public static Map<String, List<Persona>> ordenarPersonas(List<Persona> personas){
		Map<String, List<Persona>> map = new HashMap<String, List<Persona>>();
		List<Persona> list = null;
		
		for (Persona persona : personas) {
			if(persona.getPerPersona() == null){
				if(map.get(Constante.OPCION.KEY_PADRE)==null){
					list = new ArrayList<Persona>();
					list.add(persona);
					map.put(Constante.OPCION.KEY_PADRE, list);
				} else {
					list = (List<Persona>) map.get(Constante.OPCION.KEY_PADRE);
					list.add(persona);
					map.put(Constante.OPCION.KEY_PADRE, list);
				}
			}else{
				if (map.get(persona.getPerPersona().getId().toString()) == null) {
					list = new ArrayList<Persona>();
					list.add(persona);
					map.put(persona.getPerPersona().getId().toString(), list);
				} else {
					list = (List<Persona>) map.get(persona.getPerPersona().getId().toString());
					list.add(persona);
					map.put(persona.getPerPersona().getId().toString(), list);
				}
			}
		}
		return map;
	}
	
	
	public static Map<String, List<Equipo>> ordenarEquipos(List<Equipo> equipos){
		Map<String, List<Equipo>> map = new HashMap<String, List<Equipo>>();
		List<Equipo> list2=null;
		
		for (Equipo equipo : equipos) {
			if(equipo.getPadre() == null){
				if(map.get(Constante.OPCION.KEY_PADRE)==null){
					list2=new ArrayList<Equipo>();
					list2.add(equipo);
					map.put(Constante.OPCION.KEY_PADRE, list2);
				}else{
					list2=(List<Equipo>)map.get(Constante.OPCION.KEY_PADRE);
					list2.add(equipo);
					map.put(Constante.OPCION.KEY_PADRE, list2);
				}
			}else{
				if(map.get(equipo.getPadre().getId().toString())==null){
					list2=new ArrayList<Equipo>();
					list2.add(equipo);
					map.put(equipo.getPadre().getId().toString(), list2);
				}else{
					list2=(List<Equipo>)map.get(equipo.getPadre().getId().toString());
					list2.add(equipo);
					map.put(equipo.getPadre().getId().toString(), list2);
				}
			}
		}
		return map;
	}
	
	/*
	public static Map<String, List<Equipo>> obtenerEquipos(List<Equipo> equipos)
	{
		Map<String, List<Equipo>> map = new HashMap<String, List<Equipo>>();
		List<Equipo> list2=null;
		for (Equipo equipo : equipos) {
			if(equipo.getEquipo() == null){
				if(map.get(Constante.OPCION.KEY_PADRE)==null){
					list2=new ArrayList<Equipo>();
					list2.add(equipo);
					map.put(Constante.OPCION.KEY_PADRE, list2);
				}else{
					list2=(List<Equipo>)map.get(Constante.OPCION.KEY_PADRE);
					list2.add(equipo);
					map.put(Constante.OPCION.KEY_PADRE, list2);
				}
			}else{
				if(map.get(equipo.getEquipo().getId().toString())==null){
					list2=new ArrayList<Equipo>();
					list2.add(equipo);
					map.put(equipo.getEquipo().getId().toString(), list2);
				}else{
					list2=(List<Equipo>)map.get(equipo.getEquipo().getId().toString());
					list2.add(equipo);
					map.put(equipo.getEquipo().getId().toString(), list2);
				}
			}
		}
		return map;
	}
	
	public static void misEquipos(String nombre, Map<String, List<Equipo>> map,StringBuilder listaEquipo) {
		for (Equipo equipo : map.get(nombre)) {	
			
			listaEquipo.append(","+equipo.getId());

			if (map.get(equipo.getId().toString()) != null) {
				misEquipos(equipo.getId().toString(), map, listaEquipo);
			} 
		}
	}
	
	public static Calendar devolverFechaEntrega(Date fechaInicial, Integer plazo){
		Calendar fecEntrega = new GregorianCalendar();
		fecEntrega.setTime(fechaInicial);
		fecEntrega.add(Calendar.DATE, plazo);
		
		return fecEntrega;
	}
	
	public static Calendar devolverFechaAlerta(ParametroService parametroService, Date fechaInicial, Integer plazo){
		Parametro paramFecha = new Parametro();
		paramFecha = parametroService.obtener(Constante.PARAMETRO.FECHA_ALERTA);
		
		Integer porcentajeDias = (Integer.parseInt(paramFecha.getValor())*plazo)/100;
		Calendar fecAlerta = new GregorianCalendar();
		fecAlerta.setTime(fechaInicial);
		fecAlerta.add(Calendar.DATE, porcentajeDias);
		
		return fecAlerta;
	}
	
	public static void validarNombreArchivo(String nomArchivo){
		nomArchivo= StringUtils.replace(nomArchivo, " ","_");
	}
	
		 */
	
	public static String returnSHA512(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(password.getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
 
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}

