package pe.gob.mininter.dirandro.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Component;

import pe.gob.mininter.dirandro.model.Usuario;

@Component
public class UsuarioMapper implements ParameterizedRowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario usuario =new Usuario();
		usuario.setId(rs.getLong((rs.findColumn("id"))));
		usuario.setNombres(rs.getString(rs.findColumn("nombres")));
		usuario.setApePat(rs.getString(rs.findColumn("ape_pat")));
		usuario.setApeMat((rs.getString(rs.findColumn("ape_mat"))));
		usuario.setUsuario(rs.getString(rs.findColumn("usuario")));
		return usuario;
	}

}
