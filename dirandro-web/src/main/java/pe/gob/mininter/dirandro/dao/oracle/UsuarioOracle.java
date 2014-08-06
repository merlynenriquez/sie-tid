package pe.gob.mininter.dirandro.dao.oracle;

import java.util.List;

import pe.gob.mininter.dirandro.model.Usuario;

public interface UsuarioOracle extends BaseOracle  {
	
	List<Usuario> obtenerTodos();
	
}
