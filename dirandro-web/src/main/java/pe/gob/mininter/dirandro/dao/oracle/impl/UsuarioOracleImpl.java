package pe.gob.mininter.dirandro.dao.oracle.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dirandro.dao.mapper.UsuarioMapper;
import pe.gob.mininter.dirandro.dao.oracle.UsuarioOracle;
import pe.gob.mininter.dirandro.model.Usuario;

@Repository
public class UsuarioOracleImpl extends BaseOracleImpl implements UsuarioOracle{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4368986410282993755L;
	@Autowired
	private UsuarioMapper usuarioMapper;
		
	@Override
	public	List<Usuario> obtenerTodos(){
		
		StringBuffer s_sql = new StringBuffer();
		s_sql.append("select /*+ RICHS_SECRET_HINT */ u.id, u.usuario, u.nombres, u.ape_pat, u.ape_mat from ");
		s_sql.append(obtenerObjetoBBDD("SEG_USUARIO")).append(" u ");
		List<Usuario> usuarios = jdbcTemplate.query(s_sql.toString(), usuarioMapper);
			
		return usuarios;
	}
	
}
