package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.Usuario;

public interface UsuarioService extends BaseService<Usuario, Long> {
	
	public Usuario grabarUsuario(Usuario usuario);
	
	public Usuario obtenerUsuarioXRegistro(Usuario usuario);
	
	public List<Usuario> obtenerTodos();
	
	public List<Usuario> buscar(Usuario usuario);
		
}
