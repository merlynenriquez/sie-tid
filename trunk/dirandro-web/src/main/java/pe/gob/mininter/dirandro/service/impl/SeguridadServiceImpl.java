package pe.gob.mininter.dirandro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.model.Permiso;
import pe.gob.mininter.dirandro.model.Usuario;
import pe.gob.mininter.dirandro.service.PermisoService;
import pe.gob.mininter.dirandro.service.SeguridadService;
import pe.gob.mininter.dirandro.service.UsuarioService;
import pe.gob.mininter.dirandro.util.HarecUtil;

@Service
public class SeguridadServiceImpl implements SeguridadService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1919750493918952910L;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PermisoService permisoService;
	
	
	/*@Autowired 
	private IntegranteService integranteService;*/
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Usuario login(String loginUsuario, String clave) {
		
		Usuario usuarioLogin = new Usuario();
		usuarioLogin.setUsuario(loginUsuario);
		usuarioLogin.setClave(clave);
		
		Usuario usuario;
		usuario = usuarioService.obtenerUsuarioXRegistro(usuarioLogin);
		
		if (usuario == null) {
			return null;
		}
			
	
		
		
		
		//usuario = usuarioService.grabarUsuario(usuario);
		
		//usuario.setRol(membresia.getRol());
		System.out.println("prueba= "+ usuario.getRol());		
		
		List<Permiso> permisos = permisoService.obtenerPermisosXRol(usuario.getRol().getId(), true);
		List<Opcion> opciones = new ArrayList<Opcion>();
		for (Permiso permiso : permisos) {
			opciones.add(permiso.getOpcion());
		}
		
		usuario.getRol().setOpciones(HarecUtil.ordenarOpciones(opciones, true));
		
		//Equipo equipo = integranteService.obtenerEquipo(usuario);
		//Equipo equipo = new Equipo();
		
		/*if(equipo == null){
			//TODO arrojar Error
		}*/
		
		//usuario.setEquipo(equipo);
		
		return usuario;
	}

}
